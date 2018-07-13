package com.z.baselibrary.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.z.baselibrary.Config;
import com.z.baselibrary.log.LogUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Interceptor;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by zhangkb on 2017/5/25 0025.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private static final String PREF_COOKIES = ReadCookiesInterceptor.PREF_COOKIES;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static Set<String> cookies;
    private final String TAG = ReceivedCookiesInterceptor.class.getSimpleName();
    private Context context;

    public ReceivedCookiesInterceptor(Context context) {
        this.context = context;
    }

    private boolean IS_DEBUG = Config.getConfig().isDebug();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        String url = chain.request().url().url().toString();
        if (Config.getConfig().isDebug()) {
            BufferedSource source = originalResponse.body().source();
            source.buffer();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            LogUtils.getInstance().d(TAG, "intercept ::: URL:[" + url + "] ::: body: " + buffer.clone().readString(UTF8)); //打印后台请求返回的Json

        }


        //判断接收cookie
        if (containsCookie()) {

            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                //   log.logD(TAG, "intercept ::: url:" + chain.request().url().url().toString());

                cookies = new HashSet<>();
                boolean isEmpty = true;
                LogUtils.getInstance().d("-----start for------");
                for (String cookie : originalResponse.headers("Set-Cookie")) {

         /*      if(!CookieHelper.getInstance().isFilter(cookie)){
                            log.logD(TAG, "cookie:" + cookie);
                            cookies.add(cookie);
                        isEmpty=false;
                    }*/
                    LogUtils.getInstance().d("-----add cookie------");
                    LogUtils.getInstance().d("cookie--99-"+cookie);

                    if(cookie.contains("JSESSIONID")){

                        cookies.add(cookie);
                    }


                }
                if (isEmpty) {
                    //  CrashExceptionHelper.getInstance().reportDiyException(context,"Received cookie is null","Received cookie is null！---"+url);
                }


                if(cookies.size()!=0){
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                    editor.remove(ReadCookiesInterceptor.PREF_COOKIES);
                    editor.apply();
                    editor.commit();

                    SharedPreferences.Editor memes = PreferenceManager.getDefaultSharedPreferences(context).edit();
                    memes.putStringSet(PREF_COOKIES, cookies);
                    memes.commit();
                }


                //  MyApplication.getInstance().saveCookie(context, cookies, PREF_COOKIES);
                //      log.logD(TAG, "intercept ::: cookie :: " + cookies);
            }

        }


        return originalResponse;
    }

    private boolean containsCookie() {
    /*    url.contains(Urls.getLogin()) || url.contains(Urls.getUserRegister())
                || url.contains(Urls.getUserSetUsername())  || url.contains(Urls.getUserGesturePasswordLogin())
                || url.contains(Urls.getUserSaveGesturePassword())  || url.contains(Urls.getUserDeleteGesturePassword()*/


        return true;
    }

}