package com.zmall.order;

import android.content.Context;
import android.content.Intent;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.order.ui.AllOrderActivity;
import com.zmall.order.ui.OrderActivity;

/**
 * @author zhangkb
 * @date on 2018/9/26.
 */
public class OrderComponent extends BaseComponent {
    @Override
    protected boolean onCall(CC cc, Context context) {


        if ("OrderActivity".equals(cc.getActionName())) {
            String orderStatus = cc.getParamItem("orderStatus");
            Intent intent = new Intent();
            intent.putExtra("orderStatus", orderStatus);
            startActivity(intent, OrderActivity.class);
        } else {

            startActivity(AllOrderActivity.class);
        }


        return false;
    }

    @Override
    public String getName() {
        return "order";
    }
}
