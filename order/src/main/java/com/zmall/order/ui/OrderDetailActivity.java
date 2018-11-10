package com.zmall.order.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.order.R;
import com.zmall.order.api.OrderApi;
import com.zmall.order.bean.OrderDetailBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 订单详情
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


    private void setInfo(OrderDetailBean.DataBean.OrderAllInfoBean info) {

        TextView name = findViewById(R.id.orderDetailTvName);
        name.setText(String.format("%s:%s", info.getReceiverName(), info.getReceiverMobile()));
        TextView address = findViewById(R.id.orderDetailTvAddress);
        address.setText(info.getReceiverAddressDetail());
        TextView payPrice = findViewById(R.id.orderDetailTvPayPrice);
        payPrice.setText(String.format("应付款：￥%s", info.getDealSum()));

    }

    private void getOrderDetail(String orderId) {

        HttpUtil.getRetrofit().create(OrderApi.class)
                .getOrderAllInfo(orderId).enqueue(new Callback<OrderDetailBean>() {
            @Override
            public void onResponse(Call<OrderDetailBean> call, Response<OrderDetailBean> response) {

                setInfo(response.body().getData().getOrderAllInfo());

            }

            @Override
            public void onFailure(Call<OrderDetailBean> call, Throwable t) {

            }
        });

    }

}
