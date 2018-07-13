package com.z.baselibrary.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * webview 一定要使用这个。不然会报错。复制报错
 * Created by zhangkb on 2017/12/22 0022.
 */

public class RePluginWebView extends WebView {

    public RePluginWebView(Context context) {
        super(context);
        init(context);
    }

    public RePluginWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RePluginWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        WebViewResourceHelper.addChromeResourceIfNeeded(context);
    }
}