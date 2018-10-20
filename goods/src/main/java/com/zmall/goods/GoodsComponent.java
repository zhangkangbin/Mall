package com.zmall.goods;

import android.content.Context;
import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.goods.ui.GoodsDetailActivity;
/**
 * @author zhangkb
 */
public class GoodsComponent extends BaseComponent {

    @Override
    public String getName() {
        return "GoodsComponent";
    }

    @Override
    protected boolean onCall(CC cc, Context context) {

        switch (cc.getActionName()) {

            case "GoodsDetail":
                startActivity(GoodsDetailActivity.class);
                break;

            default:
                break;
        }

        return false;
    }
}
