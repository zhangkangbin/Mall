package com.z.baselibrary.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.R;
import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.recycleview.ListBindDataHelper;
import com.z.baselibrary.recycleview.ListBindDataInterface;


/**
 * @author zhangkb
 */
public abstract class BaseListFragment<T extends BaseBean, D> extends BaseFragment implements ListBindDataInterface<T, D> {

    public BaseListFragment() {
        // Required empty public constructor
    }

    private ListBindDataHelper<T, D> dataHelper;


    private boolean isInitData = true; //

    public void setInitData(boolean isInitData) {

        this.isInitData = isInitData;
    }


    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView recyclerView = getRecyclerView(view);


        dataHelper = new ListBindDataHelper<>(getActivity(), recyclerView, getAdapterLayoutId(), this, this);

        initData(view, savedInstanceState);

        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        }

        dataHelper.startPostData(getCall(dataHelper.getMap()), !isInitData);


        final SwipeRefreshLayout swipe_refresh_layout = view.findViewById(R.id.swipe_refresh_layout);

        dataHelper.setListRefreshListener(() -> {
            if (swipe_refresh_layout != null) {
                swipe_refresh_layout.setRefreshing(false);
            }

        });
        if (swipe_refresh_layout != null) {
            swipe_refresh_layout.setColorSchemeColors(getColor(R.color.refresh_orange), Color.BLUE, Color.BLACK);
            swipe_refresh_layout.setOnRefreshListener(() -> dataHelper.onRefreshData());

        }


    }


    protected ListBindDataHelper<T, D> getListBindDataHelper() {

        return dataHelper;
    }

    //   public abstract int getLayoutId();
    protected abstract RecyclerView getRecyclerView(View view);

    public abstract void initData(View view, Bundle savedInstanceState);


}
