package com.z.baselibrary.imgage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.z.baselibrary.R;

import java.io.File;

/**
 * Created by zhangkb on 2017/9/8 0008.
 */

/**
 * 统一加载框架 方便以后切换图片框架
 * 用法 ImageLoader.getInstance().displayImage(context,"http://url.img.jpg",imageView);
 */
class GlideImageLoader implements ILoaderProxy {


    /**
     * 加载图片
     *
     * @param context   上下文
     * @param url       图片url
     * @param imageView 图片视图
     * @param builder   图片配置项
     */
    @Override
    public void displayImage(Context context, String url, ImageView imageView, ImageBuilder builder) {

  /*      imageView.setScaleType(builder.getImageScaleType());//图片ScaleType
        DiskCacheStrategy diskCacheStrategy = builder.isCacheOnDisk() ? DiskCacheStrategy.ALL : DiskCacheStrategy.NONE;
        Resources res = context.getResources();
        //
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(builder.getImageOnLoading(res))//加载中显示图片
                .skipMemoryCache(builder.isCacheInMemory())//是否缓存到内存中
                .diskCacheStrategy(diskCacheStrategy)//是否缓存到硬盘中
                .error(builder.getImageOnFail(res))//错误显示图片
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getInstance())
                .load(url)
                .apply(options)
                .into(imageView);*/
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    @Override
    public void displayImage(String url, ImageView imageView) {

/*       if (MyApplication.getInstance() == null) {
            throw new IllegalArgumentException("Context为空");
        }
        //
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.img_loading_fail)
                .error(R.mipmap.img_loading_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getInstance())
                .load(url)
                .apply(options)
                .into(imageView);*/
    }

    @Override
    public void displayImage(Context context, String url, ImageView imageView, final IImageLoaderListener listener) {

/*        //
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.img_loading_fail)
                .error(R.mipmap.img_loading_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getInstance())
                .load(url)
                .apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Drawable> target, boolean b) {
                        listener.onException(e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable drawable, Object o, Target<Drawable> target, DataSource dataSource, boolean b) {
                        listener.onSuccess();
                        return false;
                    }
                })
                .into(imageView);*/
    }


    @Override
    public void displayImage(Context context, int res, ImageView imageView) {
        //
     /*   RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.img_loading_fail)
                .error(R.mipmap.img_loading_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getInstance())
                .load(res)
                .apply(options)
                .into(imageView);*/
    }

    @Override
    public void displayImage(Context context, File file, ImageView imageView) {
        //
    /*    RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.img_loading_fail)
                .error(R.mipmap.img_loading_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(MyApplication.getInstance())
                .load(file)
                .apply(options)
                .into(imageView);*/
    }

    /**
     * 预加载图片
     *
     * @param context 上下文
     * @param url     图片 url
     */
    @Override
    public void preload(Context context, String url) {
        // Glide.with(context).load(url).preload();
    }

    /**
     * 清楚硬盘缓存
     *
     * @param context
     */
    @Override
    public void clearDiskCache(Context context) {
        //  Glide.get(context).clearDiskCache();
    }

    /**
     * 清楚内存缓存
     *
     * @param context
     */
    @Override
    public void clearMemory(Context context) {
        //    Glide.get(context).clearMemory();
    }

    /**
     * 清楚硬盘和内存缓存
     *
     * @param context
     */
    @Override
    public void clearAllCache(Context context) {
        // Glide.get(context).clearMemory();
        // Glide.get(context).clearDiskCache();
    }
}
