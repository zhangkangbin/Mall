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
        list.add("待发货");
        list.add("待收货");
        list.add("已完成");
        list.add("已取消");
        return list;
    }

    @Override
    protected List<Fragment> getFragmentList() {

        /*
         * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭 ，7-退货申请，
         * 8-退货中，9-已退货，‘A’ -退款申请，B’ -退款中，‘C’ -已退款，‘D’-失效',
         */
        List<Fragment> list = new ArrayList<>();
        list.add(OrderFragment.newInstance("0"));
        list.add(OrderFragment.newInstance("1"));
        list.add(OrderFragment.newInstance("3"));
        list.add(OrderFragment.newInstance("4"));
        list.add(OrderFragment.newInstance("5"));
        list.add(OrderFragment.newInstance("6"));
        return list;
    }

}
