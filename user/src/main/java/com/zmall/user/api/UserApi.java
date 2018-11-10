package com.zmall.user.api;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.MyCallback;
import com.zmall.user.bean.AddressManageBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface UserApi {

    @FormUrlEncoded
    @POST("api/user/login")
    Call<BaseBean> userLogin(@FieldMap Map<String,String> map);


    @POST("/token/addMgr/userAddMgrList")
    Call<AddressManageBean> getAddressList();

    @FormUrlEncoded
    @POST("/token/addMgr/userAddMgrList")
    Call<BaseBean> addAddress(@FieldMap Map<String,String> map);
}
