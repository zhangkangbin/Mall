package com.zmall.goods.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.ui.BaseAppCompatActivity;

import com.z.baselibrary.ui.ViewPagerFragmentAdapter;

import com.zmall.goods.R;
import com.zmall.goods.api.GoodsApi;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GoodsDetailActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        ViewPager viewPager = findViewById(R.id.goodsViewpager);
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getFragmentList());

        if (viewPager != null) {
            viewPager.setAdapter(adapter);
        }

        //   ViewPager viewPager=findViewById(R.id.goodsDetailViewPager);

        findViewById(R.id.GoodsTvBuy).setOnClickListener(v -> {

            addOrder();
        });
    }


    private void addOrder() {


        List<String> list = new ArrayList<>();
        list.add("3");
        HttpUtil.getRetrofit().create(GoodsApi.class).addOrder(list,"3").enqueue(new MyCallback<BaseBean>(this, MyCallback.TIPS_TOAST) {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

            }
        });
    }

    protected List<Fragment> getFragmentList() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GoodsInfoFragment());
        fragments.add(new GoodsDetailFragment());
        return fragments;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {


    }


}
