package com.zmall.user.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.recycleview.BaseListActivity;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.zmall.user.R;
import com.zmall.user.api.AddressApi;
import com.zmall.user.api.UserApi;
import com.zmall.user.bean.AddressManageBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;


public class AddressManageActivity extends BaseListActivity<AddressManageBean, AddressManageBean.DataBean> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_manage;
    }

    @Override
    public boolean isNeedLoadMore() {
        return false;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initToobar("地址管理");

        findViewById(R.id.address_btn_create).setOnClickListener(v -> {

            startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class));
        });

    }


    @Override
    public int getAdapterLayoutId() {
        return R.layout.adapter_address_manage;
    }

    @Override
    public List<AddressManageBean.DataBean> getAdapterList(AddressManageBean result) {
        return result.getData();
    }

    @Override
    public void bindData(CombinationViewHolder holder, AddressManageBean.DataBean dataBean, int position) {

        holder.setTextView(R.id.addressTvName, dataBean.getReceiverName());
        holder.setTextView(R.id.addressTvPhone, dataBean.getReceiverMobile());
        holder.setTextView(R.id.addressTvAddress, dataBean.getReceiverAddressDetail());


        holder.getView(R.id.addressTvEdit).setOnClickListener(v -> {
            Intent intent = new Intent(AddressManageActivity.this, AddAddressActivity.class);
            intent.putExtra("ADDRESS_JSON", dataBean);
            startActivity(intent);

        });


        View addressTvDefault = holder.getView(R.id.addressTvDefault);

        if("1".equals(dataBean.getDefaultSite())){

            addressTvDefault.setVisibility(View.VISIBLE);
        }else {

            addressTvDefault.setVisibility(View.GONE);
        }

    }

    @Override
    public Call<AddressManageBean> getCall(Map<String, Object> map) {
        return HttpUtil.getRetrofit().create(AddressApi.class).getAddressList();
    }
}
