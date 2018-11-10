package com.zmall.user.ui.account;

import android.os.Bundle;
import android.widget.EditText;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;
import com.zmall.user.api.UserApi;

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

        initToobar("新建地址");
    }


    private EditText mName;
    private EditText mPhone;
    private String mAddressSSQ;
    private EditText mAddressDetail;

    @Override
    protected void initData(Bundle savedInstanceState) {
        mName = findViewById(R.id.addEdtName);
        mPhone = findViewById(R.id.addEdtPhone);
        mAddressDetail = findViewById(R.id.addEdtDetailAddress);

    }

    private void postAddress() {

        Map<String, String> map = new HashMap<>(6);
        map.put("receiverName", "");
        map.put("receiverPhone", "");
        map.put("receiverMobile", "");
        map.put("receiverState", "");
        map.put("receiverCity", "");
        map.put("receiverDistrict", "");
        map.put("receiverAddressDetail", "");

        HttpUtil.getRetrofit().create(UserApi.class).addAddress(null).enqueue(new MyCallback<BaseBean>() {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

            }
        });
    }
}
