package com.z.baselibrary.imgage;

import android.content.Context;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by zhangkb on 2017/9/8 0008.
 */
//@GlideImageLoader.class
public interface ILoaderProxy {


    void displayImage(Context context, String url, ImageView imageView, ImageBuilder builder);

    void displayImage(Context context, String url, ImageView imageView);
    void displayImage(String url, ImageView imageView);
    void displayImage(Context context, String url, ImageView imageView, IImageLoaderListener listener);

    void displayImage(Context context, int res, ImageView imageView);

    void displayImage(Context context, File file, ImageView imageView);

    void preload(Context context, String url);//预加载图片

    void clearDiskCache(Context context);

    void clearMemory(Context context);

    void clearAllCache(Context context);
 /*   void loadImage(String url, ImageView imageView);

    void loadImage(int res, ImageView imageView);

    void loadImage(File file, ImageView imageView);*/
}
