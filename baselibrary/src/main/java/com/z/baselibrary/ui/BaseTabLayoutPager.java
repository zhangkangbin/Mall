package com.z.baselibrary.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;

import com.z.baselibrary.R;

import java.util.List;

/**
 * Created by zhangkb on 2018/3/30 0030.
 */

public abstract class BaseTabLayoutPager extends BaseViewPagerActivity {

    @Override
    protected void initData(Bundle savedInstanceState) {


        TabLayoutPagerAdapter viewPagerFragmentAdapter = new TabLayoutPagerAdapter(getSupportFragmentManager(), getFragmentList(), getTitiList());
        getViewPager().setAdapter(viewPagerFragmentAdapter);

        TabLayout tabLayout = findViewById(R.id.base_tablayout);
        tabLayout.setupWithViewPager(getViewPager());
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }


    abstract  public List<String> getTitiList();
}
