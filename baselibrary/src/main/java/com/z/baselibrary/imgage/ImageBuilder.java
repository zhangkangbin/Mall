package com.z.baselibrary.imgage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


/**
 * Created by zhangkb on 2017/9/8 0008.
 */

public class ImageBuilder{


    private int imageResOnLoading = 0;//设置资源加载过程中的占位。
    private int imageResOnFail = 0; //设置资源加载出错的占位。
    private Drawable imageOnLoading = null;// 设置资源加载过程中的占位Drawable。
    private Drawable imageOnFail = null;//设置资源加载出错的占位Drawable。


    private boolean cacheInMemory = true; //是否缓存到内存
    private boolean cacheOnDisk = true;//是否缓存到硬盘

    private ImageView.ScaleType imageScaleType= ImageView.ScaleType.CENTER_CROP;

    public ImageBuilder showImageOnLoading(int imageRes) {
        this.imageResOnLoading = imageRes;
        return this;
    }

    public ImageBuilder showImageOnLoading(Drawable drawable) {
        this.imageOnLoading = drawable;
        return this;
    }

    public ImageBuilder showImageOnFail(int imageRes) {
        this.imageResOnFail = imageRes;
        return this;
    }

    public ImageBuilder showImageOnFail(Drawable drawable) {
        this.imageOnFail = drawable;
        return this;
    }

    public ImageBuilder cacheInMemory(boolean cacheInMemory) {
        this.cacheInMemory = cacheInMemory;
        return this;
    }

    public ImageBuilder cacheOnDisk(boolean cacheOnDisk) {
        this.cacheOnDisk = cacheOnDisk;
        return this;
    }

    public Drawable getImageOnLoading(Resources res) {
        return imageResOnLoading!=0?res.getDrawable(imageResOnLoading):this.imageOnLoading;
    }

    public Drawable getImageOnFail(Resources res) {
        return imageResOnFail!=0?res.getDrawable(imageResOnFail):this.imageOnFail;
    }

    public boolean isCacheInMemory() {
        return cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return cacheOnDisk;
    }

    public ImageView.ScaleType getImageScaleType() {
        return imageScaleType;
    }

    public void setImageScaleType(ImageView.ScaleType imageScaleType) {
        this.imageScaleType = imageScaleType;
    }
}
