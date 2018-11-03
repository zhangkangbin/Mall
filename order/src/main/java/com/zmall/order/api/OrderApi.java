package com.zmall.order.api;

import com.z.baselibrary.net.BaseBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface OrderApi {

    @POST("/token/order/orderInfoList")
    Call<BaseBean> getOrderInfoList(@PartMap Map<String, Object> params);
}
