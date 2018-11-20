package com.zmall.goods.api;

import com.z.baselibrary.net.BaseBean;
import com.zmall.goods.bean.GoodsDetailBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author zhangkb
 * @date on 2018/10/20.
 */
public interface GoodsApi {

    @GET("public/goods/goodsShow/{goodsId}")
    Call<GoodsDetailBean> getGoodsDetail(@Path("goodsId") String goodsId);

    @POST("/token/order/orderDoInsert")
    @FormUrlEncoded
    Call<BaseBean> addOrder(@Field("shoppingCartGoodsIDList") List<String> goodsIDList,@Field("UserId") String UserId);

}
