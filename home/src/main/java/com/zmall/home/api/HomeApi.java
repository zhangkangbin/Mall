package com.zmall.home.api;

import com.zmall.home.bean.HomeBean;
import com.zmall.home.bean.ClassTypeBean;
import com.zmall.home.bean.ClassTypeProductList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author kang
 */
public interface HomeApi {

    @GET("/public/class/init")
    Call<ClassTypeBean> getClassTypeList();

    @GET("/public/class/getClass/{superClassNo}")
    Call<ClassTypeBean> getClassSubTypeList(@Path("superClassNo") String superClassNo);

    @GET("/public/class/goodsListByClass/{classNo}/{pageSize}/{page}")
    Call<ClassTypeProductList> getClassTypeProductList(@Path("classNo") String superClassNo,
                                                       @Path("pageSize") String pageSize, @Path("page") String page);
    @GET("public/goods/goodsShow/{goodsId}")
    Call<HomeBean> getHomeData(@Path("goodsId") String goodsId);


}
