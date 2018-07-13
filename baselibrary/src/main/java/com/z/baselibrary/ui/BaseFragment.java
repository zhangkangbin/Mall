package com.z.baselibrary.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.z.baselibrary.R;
import com.z.baselibrary.net.imp.HttpDialogLoading;
import com.z.baselibrary.ui.dialog.TipsDialog;


/**
 * Created by zhangkb on 2018/1/30 0030.
 */

public abstract class BaseFragment extends Fragment implements HttpDialogLoading, View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view, inflater, container, savedInstanceState);

        return view;
    }

    abstract public int getLayoutId();

    abstract public void initView(View view, LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState);


    private TipsDialog tipsDialog;

    @Override
    public void showLoading() {
        //todo:
        if(getActivity()==null){

            showToast("请求数据中...."); //容错
            return;
        }
        tipsDialog = new TipsDialog.Builder(getActivity())
                .setGravity(Gravity.CENTER)
                .setBackground(R.color.transparent)
                .setView(LayoutInflater.from(getActivity()).inflate(R.layout.view_loading, null))
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

        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName("com.my089.fydlivehomeplugin", "com.my089.fydlivehomeplugin.ui.login.LoginActivity");
        startActivity(intent);

    }

    public void showToast(String text) {

        if (TextUtils.isEmpty(text)||getActivity()==null) return;

        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showTipsDialog(String msg) {
        if (TextUtils.isEmpty(msg)) return;
        new TipsDialog.Builder(getActivity()).setContentText(msg).show();
    }

    protected void showToast(int textID) {

        Toast.makeText(this.getActivity(), getResources().getText(textID), Toast.LENGTH_SHORT).show();

    }

    public int getColor(int color) {

        return getResources().getColor(color);

    }


    public void hideSoftInput(View view) {
        try {
            ((InputMethodManager) getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
