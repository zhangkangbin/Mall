package com.zkb.mall.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.z.baselibrary.ui.BaseFragment;
import com.z.baselibrary.ui.banner.ImageCycleView;
import com.zkb.mall.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<String> imageUrlList=new ArrayList<>();
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=209531698,2607942925&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3877368857,984168879&fm=27&gp=0.jpg");
        ImageCycleView imageCycleView=view.findViewById(R.id.home_banner);
        imageCycleView.setImageResources(imageUrlList);
        imageCycleView.startImageCycle();

    }

    @Override
    public void onClick(View v) {

    }
}
