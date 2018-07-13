package com.z.baselibrary.imgage;

/**
 * Created by zhangkb on 2017/9/8 0008.
 */

public interface IImageLoaderListener {
    void onSuccess();
    void onException(Exception e);
}
