package com.zmall.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;

public class UserInfoActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        inittoobar("个人信息");

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
