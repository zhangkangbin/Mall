package com.zmall.goods.ui;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.ui.BaseFragment;
import com.z.baselibrary.ui.banner.ImageCycleView;
import com.zmall.goods.R;
import com.zmall.goods.bean.GoodsDetailBean;
import com.zmall.goods.ui.presenter.GoodsDetailPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsInfoFragment extends BaseFragment {


    public GoodsInfoFragment() {
        // Required empty public constructor
    }

    ImageCycleView mImageCycleView;

    private void initImageCycleView(List<GoodsDetailBean.DataBean.ImgeListBean> imageUrlList) {

        List<String> list = new ArrayList<>();
        for (GoodsDetailBean.DataBean.ImgeListBean img : imageUrlList) {
            list.add(img.getPicUri());
        }
        mImageCycleView.setImageResources(list);
        mImageCycleView.startImageCycle();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_info;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GoodsDetailPresenter presenter = new GoodsDetailPresenter();
        presenter.getGoodsDetail("1").observe(this, new Observer<GoodsDetailBean>() {
            @Override
            public void onChanged(@Nullable GoodsDetailBean goodsDetailBean) {

                initImageCycleView(goodsDetailBean.getData().getImgeList());
            }
        });

        mImageCycleView = view.findViewById(R.id.goodsInfoViewPager);
    }

}
