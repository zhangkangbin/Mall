package com.zmall.user.ui.register;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.tool.StringUtils;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;
import com.zmall.user.api.UserApi;

import retrofit2.Call;
import retrofit2.Response;

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
     * //验证码
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


        findViewById(R.id.registerBtnGetCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCode();
            }
        });

    }

    private String smsCodeId;

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

        String md5Pwd = StringUtils.getMD5(password);

        userRegister(phone, code, smsCodeId, md5Pwd);
    }

    private void userRegister(String phone, String code, String smsCodeId, String md5Pwd) {


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    /**
     * 获取验证码
     */
    private void getCode() {
        String phone = mPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast(mPhone.getHint().toString());
            return;
        }

        HttpUtil.getRetrofit().create(UserApi.class).getSmsCode(phone).enqueue(new MyCallback<BaseBean>() {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {


            }
        });


    }
}
