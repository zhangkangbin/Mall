package com.zkb.mall.ui.order;

import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zkb.mall.R;

public class PayCompleteActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_complete;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToobar("支付成功");

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
