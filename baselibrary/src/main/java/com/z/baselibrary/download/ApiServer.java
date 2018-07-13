package com.z.baselibrary.download;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by zhangkb on 2017/12/28 0028.
 */

public interface ApiServer {
    /**
     * get 下载文件:图片/文件
     * @param fileUrl
     * @return
     */
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);

    /**
     * Post方式 下载:图片/文件
     * @param fileUrl
     * @return
     */
    @POST
    Call<ResponseBody> downloadFileToPost(@Url String fileUrl);

}
