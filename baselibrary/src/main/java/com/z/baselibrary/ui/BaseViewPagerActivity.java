package com.z.baselibrary.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.z.baselibrary.R;
import java.util.List;

/**
 * Created by zhangkb on 2018/1/16 0016.
 */

public abstract class BaseViewPagerActivity extends BaseAppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerFragmentAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {

        viewPager = findViewById(R.id.base_viewpager);
        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getFragmentList());

        if(viewPager!=null){
            viewPager.setAdapter(adapter);
        }


    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public ViewPagerFragmentAdapter getViewPagerAdapter() {
        return adapter;
    }

    protected abstract List<Fragment> getFragmentList();
}
