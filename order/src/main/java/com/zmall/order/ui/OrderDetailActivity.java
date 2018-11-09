package com.zmall.order.ui;

import android.os.Bundle;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.order.R;
import com.zmall.order.api.OrderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class OrderDetailActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("订单详情");
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        String orderId = getIntent().getStringExtra("orderId");
        getOrderDetail(orderId);
    }


    private void getOrderDetail(String orderId) {


        HttpUtil.getRetrofit().create(OrderApi.class).getOrderAllInfo(orderId).enqueue(new Callback<BaseBean>() {
            @Override
            public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {

            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {

            }
        });

    }

}
