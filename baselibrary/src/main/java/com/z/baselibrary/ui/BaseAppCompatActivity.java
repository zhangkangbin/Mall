package com.z.baselibrary.ui;


import android.annotation.TargetApi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.z.baselibrary.R;
import com.z.baselibrary.log.LogUtils;
import com.z.baselibrary.net.imp.HttpDialogLoading;
import com.z.baselibrary.tool.ActivityManager;
import com.z.baselibrary.ui.dialog.TipsDialog;

/**
 * Created by zhangkb on 2017/12/27 0027.
 */

public abstract class BaseAppCompatActivity extends AppCompatActivity implements View.OnClickListener, HttpDialogLoading {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setContentView(getLayoutId());


        ActivityManager.getInstance().addActivity(this);
        initView(savedInstanceState);
        initData(savedInstanceState);
    }

    /**
     * set toolbar title
     *
     * @param
     */
    protected Toolbar mToolbar;

    public Toolbar inittoobar(int titleId) {

        return inittoobar(getResources().getString(titleId));
    }

    public Toolbar inittoobar(String title) {

        return inittoobar(title, 0);
    }

    public Toolbar inittoobar(String title, int id) {
        mToolbar = getToolbar(title, id);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityManager.getInstance().killTopActivity();
            }
        });

        return mToolbar;

    }

    private TextView toolbar_title;

    public Toolbar getToolbar(String title, int id) {

        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mToolbar == null) {
                return null;
            }

            setSupportActionBar(mToolbar);
            mToolbar.setTitle(null);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (id == 0) {
                mToolbar.setNavigationIcon(R.drawable.toolbar_back);
            } else {

                mToolbar.setNavigationIcon(id);
            }


        }
        if (toolbar_title == null) {
            toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        }
        if (TextUtils.isEmpty(title)) {

            if (toolbar_title != null) {
                toolbar_title.setText("");
            }

        } else {

            if (toolbar_title != null) {
                toolbar_title.setText(title);
            }

        }

        return mToolbar;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().killActivity(this);
    }

    abstract protected int getLayoutId();

    abstract protected void initView(Bundle savedInstanceState);

    abstract protected void initData(Bundle savedInstanceState);

    abstract protected void click(View view);

    @Override
    public void onClick(View view) {
        click(view);
    }


    private TipsDialog tipsDialog;

    @Override
    public void showLoading() {
        //todo:

        tipsDialog = new TipsDialog.Builder(this)
                .setGravity(Gravity.CENTER)
                .setBackground(R.color.transparent)
                .setView(LayoutInflater.from(this).inflate(R.layout.view_loading, null))
                .show();


    }

    @Override
    public void dismissLoading() {

        if (tipsDialog != null) {
            tipsDialog.dismiss();
        }
    }

    @Override
    public void goToLogin() {

        // Activity 通过包名来启动

        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName("com.my089.fydlivehomeplugin", "com.my089.fydlivehomeplugin.ui.login.LoginActivity");
        startActivity(intent);
    }

    public void showToast(String text) {

        Toast.makeText(this.getApplicationContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showTipsDialog(String msg) {
        if (TextUtils.isEmpty(msg)) return;
        new TipsDialog.Builder(this).setContentText(msg).show();
    }

    protected void showToast(int textID) {

      Toast.makeText(this.getApplicationContext(), getResources().getText(textID), Toast.LENGTH_SHORT).show();


    }

    protected void logD(String msg) {
        LogUtils.getInstance().d(msg);
    }

    protected void logD(String tag, String msg) {
        LogUtils.getInstance().d(tag, msg);

    }

    /**
     * 检查是否有权限
     */
    @TargetApi(Build.VERSION_CODES.M)
    protected boolean hasPermissions(String permission) {
        if (canMakeSmores()) {
            return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
        }
        return true;
    }

    /**
     * 检查是否有权限
     */
    @TargetApi(Build.VERSION_CODES.M)
    protected boolean hasPermissions(String[] permissions) {


      //  ActivityCompat.checkSelfPermission(getApplicationContext(),permissions);
        if (canMakeSmores()) {
            // log.logE(TAG, "hasPermissions ::: !!!!!");
            int index = 0;
            for (String str : permissions) {
                if ((checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED)) {
                    index++;
                }
            }

            //   log.logE(TAG, "hasPermissions ::: index= " + index + " :: permissions.len= " + permissions.length);
            return index <= 0;
        }
        return true;
    }

    /**
     * 是否是23 以上的系统
     *
     * @return
     */
    public boolean canMakeSmores() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public void hideSoftInput(View view){

        ((InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
}