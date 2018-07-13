package com.z.baselibrary.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.z.baselibrary.BaseApplication;
import com.z.baselibrary.Config;
import com.z.baselibrary.ui.test.TestAppActivity;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by zhangkangbin on 2017/5/22.
 */
public class HttpUtil {


    public final static int HTTP_STATUS_SUCCESS = 1000;
    public final static int HTTP_STATUS_LOGIN_FAIL = 1010;//登录过期
    public final static int HTTP_STATUS_NO_PERMISSION = 1011;//无权限

    //    private static final String URL_TEST = "https://pre-m.my089.net";//登录测试的url
    //
    // public final static String HTTP_STATUS_PROMOTER_NOT = "190009";//被推荐人/邀请人房产查询 错误：非推广员
    private final static String TAG = HttpUtil.class.getSimpleName();
    //  private static final String URL = "https://app300.my089.com";//登录线上的url
//    private static final String URL_TEST = "https://dev-m.my089.net";//登录测试的url
    private static Retrofit retrofit = null;

    private static Context mContext = BaseApplication.get();

    private static String mBaseUrl = getHeadUrl();
    // private static String mBaseUrl = "http://172.16.1.138:8080";
    /*172.16.1.138:8080  我的开发环境
    172.16.0.130:8080  开发环境
    120.55.172.189  公网测试环境*/
    //public static final String BASE_URL = getHeadUrl();
//    public static final String URL_BBS_TEST  = "https://pre-bbs.my089.net";//论坛测试的url
    //

    private HttpUtil() {
    }

    public static void init(String baseUrl) {
        mBaseUrl = baseUrl;
    }


    public static Retrofit getRetrofit() {

        if(mBaseUrl.contains("https")){
            return getRetrofit(mBaseUrl, true);
        }else {
            return getRetrofit(mBaseUrl, false);
        }

    }

    public static Retrofit getRetrofit(String baseUrl, boolean isSSL) {
        if (retrofit == null) {

            if (mContext == null) {
                throw new NullPointerException("context is  null! please init context.");
            }
            mBaseUrl = baseUrl;
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(baseUrl);
            builder.addConverterFactory(GsonConverterFactory.create());

            OkHttpClient client = new OkHttpClient();
            OkHttpClient.Builder clientBuilder = client.newBuilder();

            if (Config.getConfig().isDebug()) {

    /*            clientBuilder.addInterceptor(new ReadCookiesInterceptor(mContext)) //cookie 拦截
                        .addInterceptor(new ReceivedCookiesInterceptor(mContext));//cookie 拦截*/
                // .addInterceptor(new GzipRequestInterceptor())


                try {
                    //创建类
                    Class<?> class1 = Class.forName("com.facebook.stetho.okhttp3.StethoInterceptor");
                    //创建实例化：相当于 new 了一个对象
                    Interceptor stethoInterceptor = (Interceptor) class1.newInstance();
                    if (stethoInterceptor != null) {
                        clientBuilder.addNetworkInterceptor(stethoInterceptor);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            clientBuilder.readTimeout(15, TimeUnit.SECONDS) //set超时
                    .addInterceptor(new ReadCookiesInterceptor(mContext))
                    .addInterceptor(new ReceivedCookiesInterceptor(mContext));


            if (isSSL) {

                //  clientBuilder.sslSocketFactory()
                clientBuilder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())//配置
                        .hostnameVerifier(SSLSocketClient.getHostnameVerifier());//配置

                //证书校验
            /*        builder2.sslSocketFactory(MyWebViewClient.getSSLContext(TAG).getSocketFactory())
                            .hostnameVerifier(new HostnameVerifier() {
                                @Override
                                public boolean verify(String hostname, SSLSession session) {
                                    return true;
                                }
                            });*/
            }

            client = clientBuilder.build();
            builder.client(client);
            retrofit = builder.build();
        }

        return retrofit;
    }


    public static Retrofit.Builder getRetrofitBuiler() {
        return getRetrofitBuiler(mBaseUrl);
    }

    public static Retrofit.Builder getRetrofitBuiler(String baseUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);

        return builder;
    }

    /**
     * get base url of http
     *
     * @return url
     */
    public static final String baseUrl = "https://fydadmnew.my089.com";

    public static String getHeadUrl() {

        if (!Config.getConfig().isDebug()) {
            return baseUrl;
        } else {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
            String url = preferences.getString(TestAppActivity.URL_HEAD, baseUrl);
            if (TextUtils.isEmpty(url)) {
                return baseUrl;
            } else {
                return url;

            }
        }

    }


    /**
     * 返回请求的路径
     *
     * @return url
     */
    public static String getUrl(Call call) {
        String url ;
        try {
            if (call == null) return "call is null";
            url = call.request().url().url().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception:" + e.getMessage();
        }

        return url;
    }
}

