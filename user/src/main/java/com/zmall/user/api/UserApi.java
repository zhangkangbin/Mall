package com.zmall.user.api;

import com.z.baselibrary.net.BaseBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author zhangkb
 */
public interface UserApi {

    @FormUrlEncoded
    @POST("api/user/login")
    Call<BaseBean> userLogin(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST("/api/user/getSmsCode")
    Call<BaseBean> getSmsCode(@Field("mobile") String mobile);


    /***
     *
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/register")
    Call<BaseBean> userRegister(@FieldMap Map<String, String> map);

    /**
     * user logout login
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/logout")
    Call<BaseBean> logout();


}
