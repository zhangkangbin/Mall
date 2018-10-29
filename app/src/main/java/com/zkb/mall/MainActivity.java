package com.zkb.mall;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.z.baselibrary.ui.BaseViewPagerActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhangkb
 */
public class MainActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        CC.obtainBuilder("Home").build().call();
    }


}
