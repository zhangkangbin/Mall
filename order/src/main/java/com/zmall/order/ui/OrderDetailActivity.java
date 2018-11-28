package com.zmall.order.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.z.baselibrary.ui.list.ListViewScrollView;
import com.zmall.order.R;
import com.zmall.order.adapter.AllOrderAdapter;
import com.zmall.order.adapter.OrderDetailAdapter;
import com.zmall.order.api.OrderApi;
import com.zmall.order.bean.OrderDetailBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 订单详情
 *
 * @author zhangkb
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

        setTextView(R.id.orderDetailTvTile, info.getTitle());

        TextView name = findViewById(R.id.orderDetailTvName);
        name.setText(String.format("%s:%s", info.getReceiverName(), info.getReceiverMobile()));
        TextView address = findViewById(R.id.orderDetailTvAddress);
        address.setText(info.getReceiverAddressDetail());
        TextView payPrice = findViewById(R.id.orderDetailTvPayPrice);
        payPrice.setText(String.format("应付款：￥%s", info.getDealSum()));
        setGoodsList(info.getGoodsList());

        TextView orderTvFreight = findViewById(R.id.orderTvFreight);
        orderTvFreight.setText("￥" + info.getPostFee());

        TextView orderTvPay = findViewById(R.id.orderTvPay);
        orderTvPay.setText("￥" + info.getDealSum());

        TextView orderDetailTvFpType = findViewById(R.id.orderDetailTvFpType);
        orderDetailTvFpType.setText(info.getInvoiceType());

        TextView orderDetailTvFpTitle = findViewById(R.id.orderDetailTvFpTitle);
        orderDetailTvFpTitle.setText(info.getInvoiceHead());

        TextView orderDetailTvFpContent = findViewById(R.id.orderDetailTvFpContent);
        orderDetailTvFpContent.setText(info.getInvoiceContent());

        TextView orderDetailTvPayType = findViewById(R.id.orderDetailTvPayType);

        if ("1".equals(info.getPaymentType())) {
            orderDetailTvPayType.setText("微信支付");
        } else {
            orderDetailTvPayType.setText("支付宝支付");
        }

        TextView orderDetailTvPostTime = findViewById(R.id.orderDetailTvPostTime);
        orderDetailTvPostTime.setText(info.getPaymentDate());

    }


    private void setGoodsList(List<OrderDetailBean.DataBean.OrderAllInfoBean.GoodsListBean> goodsList) {

        ListViewScrollView listViewScrollView = findViewById(R.id.orderDetailListView);
        listViewScrollView.setFocusable(false);
        listViewScrollView.setAdapter(new OrderDetailAdapter(getLayoutInflater(), goodsList));
    }

    private void getOrderDetail(String orderId) {

        HttpUtil.getRetrofit().create(OrderApi.class)
                .getOrderAllInfo(orderId).enqueue(new MyCallback<OrderDetailBean>(this, MyCallback.TIPS_TOAST) {

            @Override
            public void onSuccess(Call<OrderDetailBean> call, Response<OrderDetailBean> response) {
                if (response.body().getData() != null) {
                    setInfo(response.body().getData().getOrderAllInfo());
                }
            }
        });

    }

}
