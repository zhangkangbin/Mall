package com.z.baselibrary.imgage;

/**
 * Created by zhangkb on 2017/9/8 0008.
 */

/**
 * 统一加载框架入口 方便以后切换图片框架
 * 用法
 * ImageLoader.getInstance().loadImage(this,"http://url.img.jpg",imageView);
 * ImageLoader.getInstance().loadImage(context, "http://url.img.jpg", imageView, new IImageLoaderListener() {
 * public void onSuccess() {
 * }
 * public void onException(Exception e) {
 * }});
 */
public class ImageLoader {

    private static ILoaderProxy iLoaderProxy;

    private ImageLoader() {
    }

    public static ILoaderProxy getInstance() {
        if (iLoaderProxy == null) {
            //以后切换改这里就可以了
            synchronized (ImageLoader.class) {
                if (iLoaderProxy == null) {
                    iLoaderProxy = new GlideImageLoader();
                }
            }

        }
        return iLoaderProxy;
    }
}
