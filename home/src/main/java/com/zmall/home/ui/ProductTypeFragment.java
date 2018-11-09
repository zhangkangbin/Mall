package com.zmall.home.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.log.LogUtils;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.recycleview.CommonRecycleViewAdapter;
import com.z.baselibrary.ui.BaseFragment;

import com.zmall.home.R;
import com.zmall.home.api.HomeApi;
import com.zmall.home.bean.ClassTypeBean;


import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Response;

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

    private List<String> mSubTypeList = new ArrayList<>();
    private CommonRecycleViewAdapter<ClassTypeBean.DataBean.RecommendedClassBean> productAdapter;

    private RecyclerView mProductRVType;
    private RecyclerView mProductTypeList;

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mProductRVType = view.findViewById(R.id.product_rl_type);
        mProductRVType.setLayoutManager(new LinearLayoutManager(getActivity()));

        mProductTypeList = view.findViewById(R.id.product_rl_list);
        mProductTypeList.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        initList();

    }


    private void initProductType(List<ClassTypeBean.DataBean.GoodsClassListBean> productTypeList) {
/*        List<String> productTypeList = new ArrayList<>();
        for(ClassTypeBean.DataBean.GoodsClassListBean list:listBeans){
            productTypeList.add(list.getClassDes());
        }*/

        final CommonRecycleViewAdapter<ClassTypeBean.DataBean.GoodsClassListBean> typeAdapter =
                new CommonRecycleViewAdapter<ClassTypeBean.DataBean.GoodsClassListBean>(productTypeList, R.layout.adapter_product_type) {
                    @Override
                    public void setData(CombinationViewHolder holder, ClassTypeBean.DataBean.GoodsClassListBean data, int position) {

                        holder.setTextView(R.id.type, data.getClassDes()).setOnClickListener(v -> {
                            LogUtils.getInstance().d("data.getClassDes():" + data.getClassDes());
                            //  initData(s);
                            // initProductList(view);
                            getSubTypeList(data.getClassNo());
                        });
                    }
                };

        mProductRVType.setAdapter(typeAdapter);
    }


    private void initSubProductList(List<ClassTypeBean.DataBean.RecommendedClassBean> recommendedClass) {

        productAdapter = new CommonRecycleViewAdapter<ClassTypeBean.DataBean.RecommendedClassBean>(recommendedClass, R.layout.adapter_product_type) {
            @Override
            public void setData(CombinationViewHolder holder, ClassTypeBean.DataBean.RecommendedClassBean s, int position) {
                holder.setText(R.id.type, s.getClassDes());
            }
        };

        mProductTypeList.setAdapter(productAdapter);
    }

    private void initList() {

        HttpUtil.getRetrofit().create(HomeApi.class).getClassTypeList().enqueue(new MyCallback<ClassTypeBean>() {
            @Override
            public void onSuccess(Call<ClassTypeBean> call, Response<ClassTypeBean> response) {

                initProductType(response.body().getData().getGoodsClassList());

                initSubProductList(response.body().getData().getRecommendedClass());
            }
        });

    }

    private void getSubTypeList(String superClassNo) {

        HttpUtil.getRetrofit().create(HomeApi.class).getClassSubTypeList(superClassNo).enqueue(new MyCallback<ClassTypeBean>() {
            @Override
            public void onSuccess(Call<ClassTypeBean> call, Response<ClassTypeBean> response) {

            }
        });

    }
}
