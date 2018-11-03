package com.zmall.order.api;

import com.z.baselibrary.net.BaseBean;
import com.zmall.order.bean.AllOrderBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface OrderApi {

    @POST("/token/order/orderInfoList")
    @FormUrlEncoded
    Call<AllOrderBean> getOrderInfoList(@FieldMap Map<String, Object> params);


    /**
     * cancel order
     *
     * @param params
     * @return
     */
    @POST("/token/order/orderRefund")
    @FormUrlEncoded
    Call<BaseBean> cancelOrder(@FieldMap Map<String, Object> params);
}
