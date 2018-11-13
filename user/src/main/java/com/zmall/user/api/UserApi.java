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
    Call<BaseBean> userLogin(@FieldMap Map<String,String> map);




}
