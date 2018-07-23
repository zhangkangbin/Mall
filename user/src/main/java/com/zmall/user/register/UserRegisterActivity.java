package com.zmall.user.register;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;

/**
 * @author zhangkb
 */
public class UserRegisterActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_register;
    }

    private EditText mPhone;

    /**
     *  //验证码
     */
    private EditText mCode;
    private EditText mPassword;

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToobar("注册");

        findViewById(R.id.register_btn_post).setOnClickListener(v -> {

            checkData();
        });
        mPhone = findViewById(R.id.register_edt_phone);
        mCode = findViewById(R.id.register_edt_code);
        mPassword = findViewById(R.id.register_edt_pwd);

        findViewById(R.id.register_btn_get_code).setOnClickListener(v -> getCode());
    }

    private void checkData() {

        String phone = mPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast(mPhone.getHint().toString());
            return;
        }

        String code = mCode.getText().toString();
        if (TextUtils.isEmpty(code)) {
            showToast(mCode.getHint().toString());
            return;
        }
        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            showToast(mPassword.getHint().toString());
            return;
        }
        userRegister(phone,password,code);
    }

    private void userRegister(String phone,String password,String code) {


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    /**
     * 获取验证码
     */
    public void getCode() {
        String phone = mPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast(mPhone.getHint().toString());
            return;
        }

    }
}
