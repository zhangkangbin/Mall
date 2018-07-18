package com.zmall.user;

import android.content.Context;
import android.content.Intent;

import com.billy.cc.core.component.AbstractComponent;
import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IComponent;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.user.login.LoginActivity;

import java.util.Map;

/**
 * @author zhangkb
 */
public class User extends BaseComponent {

    @Override
    public String getName() {
        return "User";
    }


    @Override
    protected boolean onCall(CC cc, Context context) {

        startActivity(LoginActivity.class);
        return false;
    }
}
