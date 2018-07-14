package com.zmall.user.api;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.MyCallback;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface UserApi {

    @POST("user/login")
    Call<BaseBean> userLogin(@FieldMap Map<String,String> map);
}
