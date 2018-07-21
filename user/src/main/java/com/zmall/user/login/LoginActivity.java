package com.zmall.user.login;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import com.zmall.user.R;
import com.zmall.user.api.UserApi;
import com.zmall.user.register.UserRegisterActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author zhangkb
 */
public class LoginActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    private EditText login_edt_name;
    private EditText login_edt_pwd;

    private View login_ll_code;
    private View login_ll;

    @Override
    protected void initView(Bundle savedInstanceState) {

        initToobar("登录");
        login_edt_name = findViewById(R.id.login_edt_name);
        login_edt_pwd = findViewById(R.id.login_edt_pwd);

        findViewById(R.id.login_btn_start).setOnClickListener(view -> {
            userLogin();
        });
        findViewById(R.id.login_tv_register).setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, UserRegisterActivity.class));
        });


        login_ll = findViewById(R.id.login_ll);

        login_ll_code = findViewById(R.id.login_ll_code);

        findViewById(R.id.login_tv_sms).setOnClickListener(v->{


            if (login_ll_code.getVisibility() == View.VISIBLE) {
                login_ll_code.setVisibility(View.GONE);
                login_edt_pwd.setVisibility(View.VISIBLE);
            } else {
                login_edt_pwd.setVisibility(View.GONE);
                login_ll_code.setVisibility(View.VISIBLE);
            }

            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(login_ll, "rotationY", 180, 360);
            objectAnimator.setDuration(1500);

            objectAnimator.start();
        });
    }

    private void userLogin() {

        login_edt_name.requestLayout();
        String name = login_edt_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            showToast("请输入用户名");
            return;
        }
        String password = login_edt_pwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            showToast("请输入密码");
            return;
        }


        Map<String, String> map = new HashMap<>();

        HttpUtil.getRetrofit().create(UserApi.class).userLogin(map).enqueue(new MyCallback<BaseBean>(this) {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

            }

        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


}
