package com.zmall.goods.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.ui.BaseFragment;
import com.zmall.goods.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsDetailFragment extends BaseFragment {

    public GoodsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_goods_detail;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

}
