package com.z.baselibrary.cc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IComponent;

/**
 * Created by zhangkb on 2018/3/26 0026.
 */

public abstract class BaseComponent implements IComponent {
    private Context context;
    @Override
    public boolean onCall(CC cc) {
        this.context = cc.getContext();
        return onCall(cc, cc.getContext());
    }


    protected void startActivity(Class<?> cls) {

        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            //调用方没有设置context或app间组件跳转，context为application
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);

    }

    protected void startActivity(Intent intent, Class<?> cls) {
        intent.setClass(context, cls);
        if (!(context instanceof Activity)) {
            //调用方没有设置context或app间组件跳转，context为application
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);

    }

    protected abstract boolean onCall(CC cc, Context context);
}
