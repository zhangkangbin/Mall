package com.z.baselibrary.recycleview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.z.baselibrary.R;
import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.ui.BaseAppCompatActivity;

/**
 * Created by zhangkb on 2017/12/27 0027.
 */

public abstract class BaseListActivity<T extends BaseBean, D> extends BaseAppCompatActivity implements ListBindDataInterface<T, D> {


    private ListBindDataHelper<T, D> listBindDataHelper;

    @Override
    protected void initView(Bundle savedInstanceState) {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listBindDataHelper = new ListBindDataHelper<>(this, recyclerView, getAdapterLayoutId(), this, this);
        listBindDataHelper.setNeedLoadMore(isNeedLoadMore());
        listBindDataHelper.startPostData(getCall(listBindDataHelper.getMap()));
    }

    protected ListBindDataHelper getListBindDataHelper() {
        return listBindDataHelper;
    }


    /**
     * 是否需要加载更多
     *
     * @return
     */
    public boolean isNeedLoadMore() {
        return true;
    }

}
