package com.zkb.mall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.z.baselibrary.ui.BaseViewPagerActivity;
import com.zkb.mall.ui.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseViewPagerActivity {

    @Override
    protected List<Fragment> getFragmentList() {
        List<Fragment> list=new ArrayList<>();

        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


}
