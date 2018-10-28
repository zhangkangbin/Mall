package com.zmall.home;

import android.content.Context;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.home.ui.IndexActivity;

public class HomeComponent extends BaseComponent {
    @Override
    protected boolean onCall(CC cc, Context context) {
        startActivity(IndexActivity.class);
        return false;
    }

    @Override
    public String getName() {
        return "Home";
    }
}
