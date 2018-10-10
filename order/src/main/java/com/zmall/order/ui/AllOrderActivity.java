package com.zmall.order.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import com.z.baselibrary.ui.BaseTabLayoutPager;
import java.util.ArrayList;
import java.util.List;

public class AllOrderActivity extends BaseTabLayoutPager {

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        initToobar("全部订单");
    }

    @Override
    public List<String> getTitiList() {
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("待付款");
        list.add("待收货");
        list.add("已完成");
        list.add("已取消");
        return list;
    }

    @Override
    protected List<Fragment> getFragmentList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new OrderFragment());
        list.add(new OrderFragment());
        list.add(new OrderFragment());
        list.add(new OrderFragment());
        list.add(new OrderFragment());
        return list;
    }

}
