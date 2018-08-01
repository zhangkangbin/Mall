package com.zmall.user.ui.account;

import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;

public class AddAddressActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("新建地址");
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
