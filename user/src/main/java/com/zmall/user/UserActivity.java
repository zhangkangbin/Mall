package com.zmall.user;

import android.os.Bundle;
import android.view.View;
import com.z.baselibrary.ui.BaseAppCompatActivity;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserActivity extends BaseAppCompatActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {



        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("成功");
            }
        } catch (IOException e) {
            e.printStackTrace();


        }
    }


}
