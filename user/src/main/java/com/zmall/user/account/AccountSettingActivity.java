package com.zmall.user.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;
import com.zmall.user.UserInfoActivity;

public class AccountSettingActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_setting;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("账号设置");

        findViewById(R.id.account_ll_user_info).setOnClickListener(v -> {

            startActivity(new Intent(AccountSettingActivity.this, UserInfoActivity.class));
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
