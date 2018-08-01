package com.zmall.user;

import android.content.Context;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.z.baselibrary.cc.BaseComponent;
import com.zmall.user.ui.login.LoginActivity;

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

        switch (cc.getActionName()) {

            case "MyFragment":

                CC.sendCCResult(cc.getCallId(), CCResult.success("MyFragment", new MyFragment()));
                break;
            case "UserLogin":
                startActivity(LoginActivity.class);
                break;

            default:
                startActivity(LoginActivity.class);
                break;

        }

        return false;
    }
}
