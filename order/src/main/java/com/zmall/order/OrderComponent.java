package com.zmall.order;

import android.content.Context;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.order.ui.AllOrderActivity;

/**
 * @author zhangkb
 * @date on 2018/9/26.
 */
public class OrderComponent extends BaseComponent {
    @Override
    protected boolean onCall(CC cc, Context context) {

        startActivity(AllOrderActivity.class);

        return false;
    }

    @Override
    public String getName() {
        return "order";
    }
}
