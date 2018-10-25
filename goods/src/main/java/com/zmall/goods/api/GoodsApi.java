package com.zmall.goods.api;

import com.z.baselibrary.net.BaseBean;
import com.zmall.goods.bean.GoodsDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author zhangkb
 * @date on 2018/10/20.
 */
public interface GoodsApi {

    @GET("public/goods/goodsShow/{goodsId}")
    Call<GoodsDetailBean> getGoodsDetail(@Path("goodsId") String goodsId);
}
