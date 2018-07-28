package com.zmall.user.ui;

import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;

public class UserInfoActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("个人信息");

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
