package com.zmall.home.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.test.BaseList;
import com.z.baselibrary.ui.BaseListFragment;
import com.zmall.home.R;
import com.zmall.home.ui.order.OrderConfirmationActivity;


import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCarFragment extends BaseListFragment<BaseList, BaseList.ProductList> {


    public ShoppingCarFragment() {
        // Required empty public constructor
    }

    @Override
    protected RecyclerView getRecyclerView(View view) {


        return view.findViewById(R.id.recycler_view);
    }

    @Override
    public void initData(View view, Bundle savedInstanceState) {

        view.findViewById(R.id.shoppingTvPay).setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), OrderConfirmationActivity.class));

        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_shopping_car;
    }

    @Override
    public int getAdapterLayoutId() {
        return R.layout.adapter_shopping_car;
    }

    @Override
    public List<BaseList.ProductList> getAdapterList(BaseList result) {
        return result.getTestList();
    }

    @Override
    public void bindData(CombinationViewHolder holder, BaseList.ProductList t, int position) {

    }

    @Override
    public Call<BaseList> getCall(Map<String, Object> map) {
        return null;
    }
}
