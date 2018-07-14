package com.z.baselibrary.net;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.z.baselibrary.log.LogUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 *  Created by zhangkb on 2018/5/24 0024.
 * 拦截请求 ，把cookie add to header
 */
public class ReadCookiesInterceptor implements Interceptor {
    //
    public static final String PREF_COOKIES = "mall_cookie_name";
    private final String TAG = ReadCookiesInterceptor.class.getSimpleName();
    private Context context;

    public ReadCookiesInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        RequestBody requestBody = request.body();
        if (request.method().equals("POST") && requestBody instanceof FormBody) { //判断是是post请求数据
            FormBody.Builder formBody = new FormBody.Builder();

            HashMap<Object, Object> hashMap = new HashMap<>();
            for (int i = 0; i < ((FormBody) requestBody).size(); i++) {
                hashMap.put(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
                formBody.addEncoded(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
            }

            FormBody formBuilder = formBody.build();
          //  log.logE(TAG, "intercept ::: map ::: requestBody= " + hashMap.toString());
            builder.method(request.method(), formBuilder);
        }

        Set<String> preferences;
        try {
            preferences= PreferenceManager.getDefaultSharedPreferences(context).getStringSet(ReadCookiesInterceptor.PREF_COOKIES, new HashSet<String>());

        } catch (Exception e) {
         //   log.logE(TAG, "read getCookieHashSet ::: Exception= " + e.getMessage());
            //发送异常删除cookie
            //MyApplication.getInstance().removeCookie(context, ReadCookiesInterceptor.PREF_COOKIES);
            preferences = new HashSet<>();
          //  MyApplication.getInstance().reportError(e);
            e.printStackTrace();

        }

        //添加cookie
        for (String cookie : preferences) {

            if(!TextUtils.isEmpty(cookie)){
                builder.addHeader("Cookie", cookie);
              LogUtils.getInstance().d(cookie);
            }


        }
        builder.addHeader("FROM", "ANDROID_APP");
        builder.addHeader("VERSION_NAME", "");//版本号
        builder.addHeader("BRAND", android.os.Build.BRAND);//设备型号
        if (!TextUtils.isEmpty(android.os.Build.FINGERPRINT)) {
            builder.addHeader("FINGERPRINT", android.os.Build.FINGERPRINT);//唯一标识
        }
        //builder.addHeader("User-Agent", Functions.getUserAgent(context));
        return chain.proceed(builder.build());
    }


}