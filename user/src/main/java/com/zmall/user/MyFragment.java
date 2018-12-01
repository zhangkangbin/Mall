package com.zmall.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.ui.BaseFragment;
import com.zmall.user.ui.account.AccountSettingActivity;
import com.zmall.user.ui.login.LoginActivity;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view.findViewById(R.id.myIvFace).setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), AccountSettingActivity.class));
        });

        view.findViewById(R.id.myOrderAll).setOnClickListener(v -> {

            CC.obtainBuilder("order").build().call();
        });

        view.findViewById(R.id.myTvMsg).setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        });


        view.findViewById(R.id.myTvWaitPay).setOnClickListener(v -> {
            goOrder("1");
        });
        view.findViewById(R.id.myTvWaitPost).setOnClickListener(v -> {
            goOrder("2");
        });
        view.findViewById(R.id.myTvWaitReceive).setOnClickListener(v -> {
            goOrder("4");
        });
        view.findViewById(R.id.myTvOrderSuccess).setOnClickListener(v -> {
            goOrder("5");
        });
    }

    private void goOrder(String orderStatus) {

        /*
         * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 ，7-退货申请，
         * 8-退货中，9-已退货，‘A’ -退款申请，B’ -退款中，‘C’ -已退款，‘D’-失效',
         */
        Map<String, Object> params = new HashMap<>();
        params.put("orderStatus", orderStatus);
        CC.obtainBuilder("order").setActionName("OrderActivity")
                .setParams(params).build().call();
    }

}
