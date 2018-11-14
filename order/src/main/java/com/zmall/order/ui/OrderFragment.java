package com.zmall.order.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.ui.BaseListFragment;
import com.z.baselibrary.ui.dialog.ITipsDialog;
import com.z.baselibrary.ui.dialog.TipsDialog;
import com.z.baselibrary.ui.list.ListViewScrollView;
import com.zmall.order.R;
import com.zmall.order.adapter.AllOrderAdapter;
import com.zmall.order.api.OrderApi;
import com.zmall.order.bean.AllOrderBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * order list
 */
public class OrderFragment extends BaseListFragment<AllOrderBean, AllOrderBean.DataBean> {


    public OrderFragment() {
        // Required empty public constructor
    }

    public static OrderFragment newInstance(String orderStatus) {

        Bundle args = new Bundle();
        args.putString("OrderStatus", orderStatus);
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected RecyclerView getRecyclerView(View view) {

        FrameLayout frameLayout = view.findViewById(R.id.orderFl);
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        frameLayout.addView(recyclerView);
        return recyclerView;

        //    return view.findViewById(R.id.recycler_view);

    }

    @Override
    public void initData(View view, Bundle savedInstanceState) {


    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public int getAdapterLayoutId() {
        return R.layout.item_order;
    }

    @Override
    public List<AllOrderBean.DataBean> getAdapterList(AllOrderBean result) {
        return result.getData();
    }

    @Override
    public void bindData(CombinationViewHolder holder, AllOrderBean.DataBean data, int position) {

        holder.setText(R.id.orderTvOrderNo, "订单号：" + data.getOrderId());
        holder.setText(R.id.orderTvPayPrice, data.getDealSum());
        holder.setText(R.id.orderTvStatus, data.getDataStateStr());
        View cancelBtn = holder.getView(R.id.orderBtnCancel);
        if (isShowCancelBtn(data.getDataState())) {
            cancelBtn.setVisibility(View.VISIBLE);
            cancelBtn.setOnClickListener(view -> {
                cancelOrder(data.getOrderId());

            });

        } else {
            cancelBtn.setVisibility(View.GONE);
        }

        View payBtn = holder.getView(R.id.orderBtnPay);

        if (isShowPayBtn(data.getDataState())) {
            payBtn.setVisibility(View.VISIBLE);

        } else {
            payBtn.setVisibility(View.GONE);
        }

 /*       holder.getView(R.id.orderRl).setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), OrderDetailActivity.class);
            intent.putExtra("orderId", data.getOrderId());
            startActivity(intent);
        });*/


        ListViewScrollView listView = holder.getView(R.id.orderListView);
        listView.setFocusable(false);
        listView.setOnItemClickListener((parent, view, position1, id) -> {
            if (getActivity() == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(getActivity(), OrderDetailActivity.class);
            intent.putExtra("orderId", data.getOrderId());
            startActivity(intent);
        });

        AllOrderAdapter adapter = new AllOrderAdapter(getLayoutInflater(), data.getGoodsList());
        listView.setAdapter(adapter);

    }

    private boolean isShowPayBtn(String status) {
        //   状态：1、未付款，
        return "1".equals(status);

    }

    private boolean isShowCancelBtn(String status) {
        /*
         * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 ，7-退货申请，
         * 8-退货中，9-已退货，‘A’ -退款申请，B’ -退款中，‘C’ -已退款，‘D’-失效',
         */
        boolean isShow;
        switch (status) {

            case "2":
                isShow = true;
                break;
            case "3":
                isShow = true;
                break;
            case "5":
                isShow = false;
                break;
            case "6":
                isShow = false;
                break;
            default:
                isShow = true;
                break;

        }


        return isShow;
    }

    private void cancelOrder(String orderId) {


        TipsDialog tipsDialog=new TipsDialog.Builder(getActivity())
                .setContentText("确定要取消")
                .setNegativeButton(() -> {
                    Map<String, Object> params = new HashMap<>(2);
                    params.put("orderId", orderId);
                    params.put("remark", "买多了");
                    params.put("afState", "0");

                    HttpUtil.getRetrofit().create(OrderApi.class).cancelOrder(params).enqueue(new MyCallback<BaseBean>() {
                        @Override
                        public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

                        }
                    });
                })
                .show();




    }

    @Override
    public Call<AllOrderBean> getCall(Map<String, Object> map) {

        String status = getArguments().getString("OrderStatus", "0");
        Map<String, Object> params = new HashMap<>();
        params.put("dataState", status);

        return HttpUtil.getRetrofit().create(OrderApi.class).getOrderInfoList(params);
    }


}
