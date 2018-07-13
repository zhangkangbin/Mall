package com.z.baselibrary.ui.test;

import com.z.baselibrary.Config;
import com.z.baselibrary.R;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.recycleview.CommonRecycleViewAdapter;
import com.z.baselibrary.tool.ActivityManager;
import com.z.baselibrary.ui.BaseAppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TestAppActivity extends BaseAppCompatActivity {
    public static final String URL_HEAD = "URL_HEAD";
    private AlertDialog mAlertDialog;
    private AlertDialog mAlertDialogChange;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_app;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        final TextView test_tv_url = findViewById(R.id.test_tv_url);
        test_tv_url.setText("目前环境：" + HttpUtil.getHeadUrl());


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> stringList = new ArrayList<>();
        stringList.add("http://120.55.172.189:8080");
        stringList.add("https://fydadmnew.my089.com");

        CommonRecycleViewAdapter<String> adapter
                = new CommonRecycleViewAdapter<String>(stringList, R.layout.item_testurl_list) {
            @Override
            public void setData(CombinationViewHolder holder, final String urlList, int position) {

                TextView textView = holder.getView(R.id.tv_url);
                textView.setText(urlList);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setBaseUrl(urlList);
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);


       // String.format()

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void click(View view) {

    }


    private void setBaseUrl(String url) {


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(URL_HEAD, url);
        //edit.apply();
        if (Config.getConfig().isDebug()) {//再次检验
            boolean isok = edit.commit();
            if (isok) {
                showToast("请重新启动APP!");
                ActivityManager.getInstance().AppExit();
            } else {
                showToast("数据提交失败，请重新提交");

            }
        }

    }
}
