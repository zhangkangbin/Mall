package com.zmall.user.ui.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;

public class AddressManageActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_manage;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToobar("地址管理");

        findViewById(R.id.address_btn_create).setOnClickListener(v -> {


            startActivity(new Intent(AddressManageActivity.this, AddAddressActivity.class));
        });

    }

    @Override

    protected void initData(Bundle savedInstanceState) {

    }
}
