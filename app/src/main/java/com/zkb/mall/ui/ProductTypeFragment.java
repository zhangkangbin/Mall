package com.zkb.mall.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.log.LogUtils;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.recycleview.CommonRecycleViewAdapter;
import com.z.baselibrary.ui.BaseFragment;
import com.zkb.mall.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author zhangkb
 */
public class ProductTypeFragment extends BaseFragment {


    public ProductTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product_type;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        initProductType(view);
        initProductList(view);

    }


    private void initProductType(View view) {
        RecyclerView productRlType = view.findViewById(R.id.product_rl_type);
        productRlType.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<String> typeList = new ArrayList<>();
        typeList.add("A");
        typeList.add("B");
        typeList.add("C");
        typeList.add("D");
        typeList.add("A");
        typeList.add("B");
        typeList.add("C");
        typeList.add("D");
        typeList.add("A");
        typeList.add("B");
        typeList.add("C");
        typeList.add("D");
        typeList.add("A");
        typeList.add("B");
        typeList.add("C");
        typeList.add("D");
        final CommonRecycleViewAdapter<String> typeAdapter = new CommonRecycleViewAdapter<String>(typeList, R.layout.adapter_product_type) {
            @Override
            public void setData(CombinationViewHolder holder, String s, int position) {

                holder.setTextView(R.id.type, s).setOnClickListener(v -> {

                    LogUtils.getInstance().d("s:" + s);
                    initData(s);

                    initProductList(view);

                });
            }
        };

        productRlType.setAdapter(typeAdapter);
    }

    private void initData(String string) {
        typeList.clear();

        Random rand = new Random();
        for (int i = 0; i < (50 + rand.nextInt(60)); i++) {

            typeList.add(i + string);
        }

    }

    private List<String> typeList = new ArrayList<>();
    CommonRecycleViewAdapter<String> productAdapter;
    RecyclerView productTypeList;

    private void initProductList(View view) {


        productTypeList = view.findViewById(R.id.product_rl_list);
        productTypeList.setLayoutManager(new GridLayoutManager(getActivity(), 3));


        productAdapter = new CommonRecycleViewAdapter<String>(typeList, R.layout.adapter_product_type) {
            @Override
            public void setData(CombinationViewHolder holder, String s, int position) {
                holder.setText(R.id.type, s);
            }
        };

        productTypeList.setAdapter(productAdapter);
    }
}
