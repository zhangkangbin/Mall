package com.zmall.user;

import android.content.Context;
import com.billy.cc.core.component.CC;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.user.login.LoginActivity;

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
