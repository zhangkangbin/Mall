package com.zmall.user.ui.account;

import android.content.Intent;
import android.os.Bundle;

import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.recycleview.BaseListActivity;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.zmall.user.R;
import com.zmall.user.api.UserApi;
import com.zmall.user.bean.AddressManageBean;

import java.util.List;
import java.util.Map;

import retrofit2.Call;


public class AddressManageActivity extends BaseListActivity<AddressManageBean,AddressManageBean.DataBean> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_manage;
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
    public void bindData(CombinationViewHolder holder, AddressManageBean.DataBean t, int position) {

        holder.setTextView(R.id.addressTvName,t.getReceiverName());
        holder.setTextView(R.id.addressTvPhone,t.getReceiverMobile());
        holder.setTextView(R.id.addressTvAddress,t.getReceiverAddressDetail());

    }

    @Override
    public Call<AddressManageBean> getCall(Map<String, Object> map) {
        return   HttpUtil.getRetrofit().create(UserApi.class).getAddressList();
    }
}
