package com.z.baselibrary.net;


import android.text.TextUtils;

import com.z.baselibrary.log.LogUtils;
import com.z.baselibrary.net.imp.HttpDialogLoading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhangkangbin on 2017/5/25
 */

public abstract class MyCallback<T extends BaseBean> implements Callback<T> {
    public static final int TIPS_TOAST = 1;//  showToast
    public static final int TIPS_DIALOG = 2;//showDialog
    private final static String tips_request_fail = "请求失败！";
    private final String TAG = MyCallback.class.getSimpleName();
    private int mCode = 0;  // 请求结果code

    // private boolean isDebug=false;
    private HttpDialogLoading dialogLoading;
    /**
     * 错误的处理
     */
    private int mErrorTips=1;  //   1 showToast   2 ,showDialog
    private boolean mIsShowLoading = true;  //  是否要显示加载中

    /**
     * 不需要 加载Loading...
     */
    public MyCallback() {
    }

    /**
     * /必须得传DialogLoading的回调进来才可以提示登录过期
     * DialogLoading的回调
     *
     * @param dialogLoading DialogLoading的回调
     */
    public MyCallback(HttpDialogLoading dialogLoading) {
        init(dialogLoading, 0, true);//

    }

    public MyCallback(HttpDialogLoading dialogLoading, int errorTips) {
        init(dialogLoading, errorTips, true);
    }

    public MyCallback(HttpDialogLoading dialogLoading, int errorTips, boolean isShowLoading) {
        init(dialogLoading, errorTips, isShowLoading);
    }


    private void init(HttpDialogLoading dialogLoading, int errorTips, boolean isShowLoading) {
        this.dialogLoading = dialogLoading;
        this.mErrorTips = errorTips;
        this.mIsShowLoading = isShowLoading;

        showLoading();

    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        dismissLoading();

        if (response != null && response.body() != null) {
            mCode = response.body().getCode();
            if (HttpUtil.HTTP_STATUS_SUCCESS == mCode) {
                onSuccess(call, response);
            } else if (HttpUtil.HTTP_STATUS_LOGIN_FAIL == mCode) {
                String msg = response.body().getMessage();
                showMessage(msg);
                //
                Throwable t = new Throwable(msg);
                onFailure(call, t);
                //登录超时跳转登录页面
                if (dialogLoading != null) {
                    dialogLoading.goToLogin();//显示登录超时跳转登录dialog
                }


                //   MyApplication.getInstance().setLogin(false);

            } else {
                String msg = response.body().getMessage();
                showMessage(msg);
                //
                Throwable t = new Throwable(msg);
                onFailure(call, t);
            }
        } else {
            showMessage(tips_request_fail);
            Throwable t = new Throwable(tips_request_fail);
            onFailure(call, t);

  /*          if (!isDebug) {
                try {
                    // 在非debug时候上传这个错误
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("code:" + response.code() + "\n");
                    stringBuilder.append("headers:" + response.headers().toString() + "\n");
                    stringBuilder.append("url:" + call.request().url() + "\n");
                    stringBuilder.append("method:" + call.request().method() + "\n");

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }*/
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        LogUtils.getInstance().e(TAG, "onFailure ::: fail-" + t.getMessage());
        dismissLoading();
        showMessage(tips_request_fail);
/*        if (NetUtils.isConnected()) {
            log.logE(TAG, "onFailure ::: fail-" + t.getMessage());
            //错误的处理。
            showMessage(tips_request_fail);
            //
            Throwable tt = new Throwable(tips_request_fail);
            onFail(call, tt);

        } else {
            String msg = "请检测手机是否联网！";
            showMessage(msg);
            //
            Throwable tt = new Throwable(msg);
            onFail(call, tt);

        }*/

    }

    private void showMessage(String msg) {

        if (TextUtils.isEmpty(msg)) return;

        switch (mErrorTips) {
            case TIPS_TOAST: //1
                if (dialogLoading != null) {
                    dialogLoading.showToast(msg);
                }
                break;
            case TIPS_DIALOG://2
                if (dialogLoading != null) {
                    dialogLoading.showTipsDialog(msg);
                }
                break;
            default:
                break;
        }
    }

    private void showLoading() {
        
        if (dialogLoading != null && mIsShowLoading) {
            dialogLoading.showLoading();
        }

    }

    private void dismissLoading() {

        if (dialogLoading != null && mIsShowLoading) {
            dialogLoading.dismissLoading();
        }

    }

    /**
     * 错误码 一般用于处理特殊情况
     *
     * @return 错误码
     */
    protected int getResponseCode() {
        return mCode;
    }

    abstract public void onSuccess(Call<T> call, Response<T> response);

   // abstract public void onFail(Call<T> call, Throwable t);
}
