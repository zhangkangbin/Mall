package com.zmall.user;

import android.content.Intent;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IComponent;
import com.zmall.user.login.LoginActivity;

import java.util.Map;

public class User implements IComponent {
    @Override
    public String getName() {
        return "User";
    }

    @Override
    public boolean onCall(CC cc) {
        Intent intent = new Intent(cc.getContext(), LoginActivity.class);

    /*    if (cc.getParams() != null || cc.getParams().isEmpty()) {


        }*/
        cc.getContext().startActivity(intent);
        return false;
    }
}
