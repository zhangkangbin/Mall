package com.zmall.order.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.test.BaseList;
import com.z.baselibrary.ui.BaseListFragment;
import com.zmall.order.R;

import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseListFragment<BaseList, BaseList.ProductList> {


    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    protected RecyclerView getRecyclerView(View view) {

       FrameLayout frameLayout = view.findViewById(R.id.orderFl);
        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        frameLayout.addView(recyclerView);
        return recyclerView;

    //    return view.findViewById(R.id.recycler_view);

    }

    @Override
    public void initData(View view, Bundle savedInstanceState) {

    }


/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }*/

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public int getAdapterLayoutId() {
        return R.layout.item_order;
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
