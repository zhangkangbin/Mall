package com.z.baselibrary.download;

import android.text.TextUtils;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.tool.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zkb on 2017/7/22.
 */

public class DownloadPresenter extends BasePresenter<IDownload> {

    private final String TAG = DownloadPresenter.class.getSimpleName();
  //  private Logger log;

    //下载进度监听
    private ProgressResponseBody.ProgressListener progressListener;
    public DownloadPresenter(IDownload iDownload) {
        super(iDownload);
    }

    /**
     * @param url  文件URl
     * @param path 文件路径
     */
    public void downloadFile(final String url, final String path) {
     //   log.logE(TAG, "downloadFile ::: downApk....");
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(path)) {
         //   CrashExceptionHelper.getInstance().reportDiyException(MyApplication.getInstance(),"DownloadPresenter","地址或者SD卡路径不存在");
            iBase.downloadFile(false, "地址或者SD卡路径不存在", path);
            return;
        }

        Retrofit.Builder builder = HttpUtil.getRetrofitBuilder();
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        okhttp3.Response orginalResponse = chain.proceed(chain.request());

                        return orginalResponse.newBuilder()
                                .body(new ProgressResponseBody(orginalResponse.body(), new ProgressResponseBody.ProgressListener() {
                                    @Override
                                    public void onProgress(long progress, long total, boolean done) {

                                        //int result = (int) (progress * 100 / total);
                                        if (progressListener != null) {
                                            progressListener.onProgress(progress, total, done);
                                        }
                                    }
                                }))
                                .build();
                    }
                })
                .build();
        ApiServer api = builder.client(client)
                .build().create(ApiServer.class);

        api.downloadFile(url).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
              //  log.logE(TAG, "downloadFile ::: onResponse....");

                String name = StringUtils.getMD5(url);
                boolean isok = writeResponseBodyToDisk(response.body(), path, name);
                if (isok) {
                    iBase.downloadFile(isok, "下载成功", path + "/" + name);
                } else {

                    iBase.downloadFile(isok, "写入文件失败", path + "/" + name);


                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
              //  log.logE(TAG, "downloadFile ::: onFailure....");
                iBase.downloadFile(false, t.getMessage(), path);
            }
        });


    }

    private boolean writeResponseBodyToDisk(ResponseBody body, String path, String name) {
        File f = new File(path);
        if (!f.isDirectory()) {
            boolean mkdirs = f.mkdirs();
            if (!mkdirs) {
                return false;
            }
        }
        try {

            long fileSize = body == null ? 0 : body.contentLength();
           // log.logE(TAG, "writeResponseBodyToDisk ::: fileSize= " + fileSize);
            if (fileSize <= 0)
                return false;
            File futureStudioIconFile = new File(path, name);
            InputStream inputStream = body.byteStream();
            Source inputStreamSource = Okio.source(inputStream);
            Sink sink2 = Okio.sink(futureStudioIconFile);
            BufferedSink buffer2 = Okio.buffer(sink2);
            buffer2.writeAll(inputStreamSource);
            buffer2.flush();
            buffer2.close();

            return true;
        } catch (IOException e) {
           // CrashExceptionHelper.getInstance().reportDiyException(e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 下载进度监听
     *
     * @param progress
     */
    public void setDownloadProgress(ProgressResponseBody.ProgressListener progress) {
        this.progressListener = progress;
    }

}
