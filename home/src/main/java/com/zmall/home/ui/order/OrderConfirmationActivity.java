package com.zmall.home.ui.order;

import android.content.Intent;
import android.os.Bundle;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.home.R;

public class OrderConfirmationActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_confirmation;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("订单确认");

        findViewById(R.id.orderTvPost).setOnClickListener(v -> {

            startActivity(new Intent(OrderConfirmationActivity.this, PayCompleteActivity.class));
        });

        findViewById(R.id.orderRlAddress).setOnClickListener(v -> {

            CC.obtainBuilder("User").setActionName("AddressManageActivity").build().call();

        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

}
