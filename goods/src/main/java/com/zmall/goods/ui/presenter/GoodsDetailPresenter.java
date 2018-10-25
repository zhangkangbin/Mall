package com.zmall.goods.ui.presenter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.zmall.goods.api.GoodsApi;
import com.zmall.goods.bean.GoodsDetailBean;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author zhangkb
 * @date on 2018/10/20.
 */
public class GoodsDetailPresenter extends ViewModel {
    private MutableLiveData<GoodsDetailBean> mGoodsDetailBean;


    public MutableLiveData<GoodsDetailBean> getGoodsDetail(String goodsId) {
        if (mGoodsDetailBean == null) {
            mGoodsDetailBean = new MutableLiveData<>();
        }
        HttpUtil.getRetrofit().create(GoodsApi.class).getGoodsDetail(goodsId).enqueue(new MyCallback<GoodsDetailBean>() {
            @Override
            public void onSuccess(Call<GoodsDetailBean> call, Response<GoodsDetailBean> response) {

                mGoodsDetailBean.setValue(response.body());
            }
        });
        return mGoodsDetailBean;
    }

}
