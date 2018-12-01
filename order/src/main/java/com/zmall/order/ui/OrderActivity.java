package com.zmall.order.ui;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.order.R;

public class OrderActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {


    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        String orderStatus = getIntent().getStringExtra("orderStatus");

        String title="";
        /*
         * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 ，7-退货申请，
         * 8-退货中，9-已退货，‘A’ -退款申请，B’ -退款中，‘C’ -已退款，‘D’-失效',
         */
        switch (orderStatus) {

            case "1":
                title="未付款";
                break;
            case "2":
                title="已付款";
                break;
            case "3":
                title="未发货";
                break;
            case "4":
                title="已发货";
                break;
            case "5":
                title="交易成功";
                break;
            case "6":
                title="交易关闭";
                break;
            default:
                title="订单";
                break;
        }

        initToobar(title);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        OrderFragment orderFragment = OrderFragment.newInstance(orderStatus);
        transaction.add(R.id.orderFragmentView, orderFragment);
        transaction.commit();
    }
}
