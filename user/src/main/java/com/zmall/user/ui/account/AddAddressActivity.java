package com.zmall.user.ui.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.tool.ActivityManager;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;
import com.zmall.user.api.AddressApi;
import com.zmall.user.api.UserApi;
import com.zmall.user.bean.AddressManageBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * add  address
 */
public class AddAddressActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        mName = findViewById(R.id.addEdtName);
        mPhone = findViewById(R.id.addEdtPhone);
        mAddressDetail = findViewById(R.id.addEdtDetailAddress);

        addressCbSetDefault = findViewById(R.id.addressCbSetDefault);

        findViewById(R.id.addBtnSave).setOnClickListener(view -> {

            postAddress();
        });

        initPicker();

    }


    private EditText mName;
    private EditText mPhone;
    private String mProvinceName;
    private String mCityName;
    private String mDistrictName;
    private EditText mAddressDetail;

    private CityPickerView mPicker = new CityPickerView();


    private CheckBox addressCbSetDefault;

    @Override
    protected void initData(Bundle savedInstanceState) {



        AddressManageBean.DataBean address = (AddressManageBean.DataBean) getIntent().getSerializableExtra("ADDRESS_JSON");

        if (address == null) {
            initToobar("新建地址");
        } else {
            initToobar("编辑地址");

            mName.setText(address.getReceiverName());
            mPhone.setText(address.getReceiverMobile());
            mAddressDetail.setText(address.getReceiverAddressDetail());

            mProvinceName = address.getReceiverState();
            mCityName = address.getReceiverCity();
            mDistrictName = address.getDefaultSite();

            addressSSQ.setText(String.format("%s%s%s", mProvinceName, mCityName, mDistrictName));
        }

    }

    TextView addressSSQ;

    private void initPicker() {
        /**
         * 预先加载仿iOS滚轮实现的全部数据
         */
        mPicker.init(this);
        addressSSQ = findViewById(R.id.addTvSelectAddressSSQ);
        addressSSQ.setOnClickListener(view -> {

            //显示
            mPicker.showCityPicker();
        });
        //添加默认的配置，不需要自己定义
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);
        //监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {

                StringBuilder sb = new StringBuilder();
                //省份
                if (province != null) {
                    mProvinceName = province.getName();
                    sb.append(province.getName());
                }

                //城市
                if (city != null) {
                    sb.append(city.getName());
                    mCityName = city.getName();
                }

                //地区
                if (district != null) {
                    sb.append(district.getName());
                    mDistrictName = district.getName();
                }

                addressSSQ.setText(sb.toString());

            }

            @Override
            public void onCancel() {
                ToastUtils.showLongToast(AddAddressActivity.this, "已取消");
            }
        });


    }

    private void postAddress() {

        String name = mName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showToast("请输入用户名");
            return;
        }

        String phone = mPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast("请输入手机号码");
            return;
        }


        String addressDetail = mAddressDetail.getText().toString();
        if (TextUtils.isEmpty(addressDetail)) {
            showToast("请输入详细地址");
            return;
        }


        Map<String, String> map = new HashMap<>(6);
        map.put("receiverName", name);
        map.put("receiverMobile", phone);
        map.put("receiverState", mProvinceName);
        map.put("receiverCity", mCityName);
        map.put("receiverDistrict", mDistrictName);
        map.put("receiverAddressDetail", addressDetail);
        map.put("receiverZipCode", "0");
        map.put("defaultSite", addressCbSetDefault.isChecked() ? "1" : "0");

        // TextUtils.isEmpty()

        HttpUtil.getRetrofit().create(AddressApi.class).addAddress(map).enqueue(new MyCallback<BaseBean>(this, MyCallback.TIPS_TOAST) {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

                ActivityManager.getInstance().killTopActivity();
            }
        });
    }
}
