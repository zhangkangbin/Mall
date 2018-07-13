package com.z.baselibrary.recycleview;


import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * Created by zhangkb on 2017/11/27 0027.
 */

public interface ListBindDataInterface<T,D> {

    int getAdapterLayoutId();//获取布局ID
    List<D> getAdapterList(T result);//获取数据
    void bindData(CombinationViewHolder holder, D t, int position);//绑定数据
    Call<T> getCall(Map<String, Object> map);//获取请求的call
}
