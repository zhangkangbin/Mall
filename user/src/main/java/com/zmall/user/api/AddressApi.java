package com.zmall.user.api;

import com.z.baselibrary.net.BaseBean;
import com.zmall.user.bean.AddressManageBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author kang
 * @date 2018/11/13 0013
 */
public interface AddressApi {

    @POST("/token/addMgr/userAddMgrList")
    Call<AddressManageBean> getAddressList();

    @FormUrlEncoded
    @POST("/token/addMgr/userAddMgrinsert")
    Call<BaseBean> addAddress(@FieldMap Map<String,String> map);
    /**
     *
     * delete Address
     * @param addressId
     * @return
     */
    @FormUrlEncoded
    @POST("/token/addMgr/userAddMgrDelectByNo")
    Call<BaseBean> deleteAddress(@Field("idUserAddrMgr") String addressId);
    /**
     *
     * set default Address
     * @param addressId
     * @return
     */
    @FormUrlEncoded
    @POST("/token/addMgr/userAddMgrSetDefault")
    Call<BaseBean> setDefaultAddress(@Field("idUserAddrMgr") String addressId);

}
