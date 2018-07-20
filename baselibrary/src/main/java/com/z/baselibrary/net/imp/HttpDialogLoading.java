package com.z.baselibrary.net.imp;

/**
 *
 * @author zhangkb
 * @date 2017/12/22 0022
 */


public interface HttpDialogLoading {

    void showLoading();

    void dismissLoading();

    void goToLogin();

    void showToast(String msg);

    void showTipsDialog(String msg);
}
