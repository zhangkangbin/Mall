package com.z.baselibrary.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.z.baselibrary.R;
import com.z.baselibrary.ui.dialog.TipsDialog;

public class ViewHelper {

    private TipsDialog tipsDialog;


    public void showLoading(Activity activity) {
        //todo:
        if(activity==null){

            showToast("请求数据中...."); //容错
            return;
        }
        tipsDialog = new TipsDialog.Builder(activity)
                .setGravity(Gravity.CENTER)
                .setBackground(R.color.transparent)
                .setView(LayoutInflater.from(activity).inflate(R.layout.view_loading, null))
                .show();


    }


    public void dismissLoading() {

        if (tipsDialog != null) {
            tipsDialog.dismiss();
        }
    }


    public void showToast(String text) {

        if (TextUtils.isEmpty(text)||getActivity()==null) return;

        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();

    }

    public void showTipsDialog(String msg) {
        if (TextUtils.isEmpty(msg)) return;
        new TipsDialog.Builder(getActivity()).setContentText(msg).show();
    }

    protected void showToast(int textID) {

        Toast.makeText(this.getActivity(), getActivity().getResources().getText(textID), Toast.LENGTH_SHORT).show();

    }

    public int getColor(int color) {

        return getActivity().getResources().getColor(color);

    }


    public void hideSoftInput(View view) {
        try {
            ((InputMethodManager) getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private Activity activity;
    public Activity getActivity() {
        return activity;
    }


}
