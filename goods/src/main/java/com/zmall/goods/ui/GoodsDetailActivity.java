package com.zmall.goods.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.z.baselibrary.ui.BaseViewPagerActivity;
import com.z.baselibrary.ui.ViewPagerFragmentAdapter;
import com.z.baselibrary.ui.banner.ImageCycleView;
import com.zmall.goods.R;
import com.zmall.goods.bean.GoodsDetailBean;
import com.zmall.goods.ui.presenter.GoodsDetailPresenter;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        ViewPager viewPager = findViewById(R.id.goodsViewpager);
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getFragmentList());

        if(viewPager!=null){
            viewPager.setAdapter(adapter);
        }

     //   ViewPager viewPager=findViewById(R.id.goodsDetailViewPager);

    }


    protected List<Fragment> getFragmentList() {

        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new GoodsInfoFragment());
        fragments.add(new GoodsDetailFragment());
        return fragments;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {



    }


}
