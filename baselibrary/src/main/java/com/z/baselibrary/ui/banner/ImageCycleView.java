package com.z.baselibrary.ui.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.z.baselibrary.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 自动轮播控件</br>
 */
public class ImageCycleView extends LinearLayout {
    private static final String TAG = "ImageCycleView";
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 图片轮播视图
     */
    private ZViewPager mAdvPager = null;
    /**
     * 滚动图片视图适配
     */
    private PagerAdapter mAdvAdapter;
    /**
     * 图片轮播指示器控件
     */
    private LinearLayout mGroup;

    /**
     * 图片轮播指示个图
     */
    private ImageView mImageView = null;

    /**
     * 滚动图片指示视图列表
     */
    private ImageView[] mImageViews = null;

    /**
     * 游标是圆形还是长条，要是设置为0是长条，要是1就是圆形 默认是圆形
     */
    public int stype = 1;


    public boolean isAutoCycle = false;

    /**
     * 是否需要自动
     *
     * @param isAuroCycle
     */
    public void setAutoCycle(boolean isAuroCycle) {
        this.isAutoCycle = isAuroCycle;
    }

    public ImageCycleView(Context context) {
        super(context);
        init(context);
    }

    public ImageCycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.common_cycle_view, this);
        mAdvPager = findViewById(R.id.adv_pager);
        mAdvPager.addOnPageChangeListener(new GuidePageChangeListener());
        // 滚动图片右下指示器视
        mGroup = findViewById(R.id.viewGroup);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_CANCEL
                || event.getAction() == MotionEvent.ACTION_UP) {
            startImageCycle();
        } else {
            // 此句代码是为了通知他的父ViewPager现在进行的是本控件的操作，不要对我的操作进行干扰
            getParent().requestDisallowInterceptTouchEvent(true);
            stopImageTimerTask();
        }
        return super.dispatchTouchEvent(event);

    }

    public void setImageResources(List<String> imageUrlList) {

        setImageResources(null, imageUrlList, null, 0);
    }

    public void setImageResources(List<String> imageUrlList, ImageCycleViewListener imageCycleViewListener) {

        setImageResources(null, imageUrlList, imageCycleViewListener, 0);
    }

    public void setImageResources(PagerAdapter adapter, List<String> imageUrlList) {

        setImageResources(adapter, imageUrlList, null, 0);
    }

    public void setImageResources(PagerAdapter adapter, List<String> imageUrlList, ImageCycleViewListener imageCycleViewListener) {

        setImageResources(adapter, imageUrlList, imageCycleViewListener, 0);
    }

    /**
     * 装填图片数据
     *
     * @param stype                  游标是圆形还是长条，要是设置为0是长条，要是1就是圆形 默认是圆形
     * @param imageUrlList
     * @param imageCycleViewListener
     */
    public void setImageResources(PagerAdapter adapter, List<String> imageUrlList, ImageCycleViewListener imageCycleViewListener, int stype) {
        setImageResources(adapter, imageUrlList, imageCycleViewListener, stype, Gravity.CENTER);
    }

    public void setImageResources(List<String> imageUrlList, ImageCycleViewListener imageCycleViewListener, int stype, int Gravity) {
        setImageResources(null, imageUrlList, imageCycleViewListener, stype, Gravity);
    }

    /**
     * 装填图片数据
     *
     * @param stype                  游标是圆形还是长条，要是设置为0是长条，要是1就是圆形 默认是圆形
     * @param imageUrlList
     * @param imageCycleViewListener
     * @param Gravity                游标的位置
     */
    public void setImageResources(PagerAdapter adapter, List<String> imageUrlList, ImageCycleViewListener imageCycleViewListener, int stype, int Gravity) {
        this.stype = stype;
        initGroup(imageUrlList); //初始化游标数量

        if (adapter == null) {
            mAdvAdapter = new ImageCycleAdapter(mContext, imageUrlList, imageCycleViewListener);

        } else {
            mAdvAdapter = adapter;
        }

        mAdvPager.setAdapter(mAdvAdapter);
        mAdvPager.setCurrentItem(0);

        mGroup.setGravity(Gravity);

        //自动滚动
        startImageCycle();
    }

    /**
     * 初始化游标
     *
     * @param imageUrlList
     */

    public void initGroup(List<String> imageUrlList) {
        // 清除
        mGroup.removeAllViews();
        // 图片广告数量

        final int imageCount = imageUrlList.size();
        mImageViews = new ImageView[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageView = new ImageView(mContext);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin = 30;
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setLayoutParams(params);
            mImageViews[i] = mImageView;
            if (i == 0) {
                if (this.stype == 1) {
                    mImageViews[i].setBackgroundResource(R.drawable.banner_dian_focus);
                } else {
                    mImageViews[i].setBackgroundResource(R.drawable.cicle_banner_dian_focus);
                }
            } else {
                if (this.stype == 1) {
                    mImageViews[i].setBackgroundResource(R.drawable.banner_dian_blur);
                } else {
                    mImageViews[i].setBackgroundResource(R.drawable.cicle_banner_dian_blur);
                }
            }
            mGroup.addView(mImageViews[i]);
        }
    }


    /**
     * 得到图片轮播视图
     */

    public ZViewPager getViewPager() {


        return mAdvPager;
    }

    /**
     * 滚动图片视图适配 ...用于更新
     */
    public PagerAdapter getImageCycleAdapter() {


        return this.mAdvAdapter;
    }

    /**
     * 图片轮播(手动控制自动轮播与否，便于资源控件）
     */
    public void startImageCycle() {
        startImageTimerTask(mAtuoPlayTime);
    }

    /**
     * 暂停轮播—用于节省资源
     */
    public void pushImageCycle() {
        stopImageTimerTask();
    }

    private final int mAtuoPlayTime = 4000;

    private Timer myTimer = null;

    /**
     * 图片滚动任务
     */
    public void startImageTimerTask(int time) {
        stopImageTimerTask();
        // 图片滚动
        if (isAutoCycle) {
            myTimer = new Timer();
            myTimer.schedule(new MyTimerTask(), mAtuoPlayTime, time);
        }
    }

    /**
     * 停止图片滚动任务
     */
    public void stopImageTimerTask() {
        if (myTimer != null)
            myTimer.cancel();
        myTimer = null;
    }

    private class MyTimerTask extends TimerTask {


        @Override
        public void run() {
            // TODO Auto-generated method stub
            Message message = new Message();
            message.arg1 = 0;
            lunboTimerHandler.sendMessage(message);
        }
    }

    private LunboTimerHandler lunboTimerHandler = new LunboTimerHandler();

    class LunboTimerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            try {
                if (msg.arg1 == 0) {
                    if (mImageViews != null) {
                        int size = mImageViews.length;

                        //    log.logI(TAG, "图片自动轮播Task ::: size= " + size + " ::: currentItem= " + mAdvPager.getCurrentItem());
                        if (mAdvPager.getCurrentItem() + 1 == size) {
                            mAdvPager.setCurrentItem(0);
                            //    log.logI(TAG, "图片自动轮播Task00");
                        } else {

                            //      log.logI(TAG, "图片自动轮播Task");
                            mAdvPager.setCurrentItem(mAdvPager.getCurrentItem() + 1);
                        }
                    }
                } else if (msg.arg1 == 1) {
                    int index = msg.arg2;
                    // 设置当前显示的图片
                    // 设置图片滚动指示器背
                    mImageViews[index].setBackgroundResource(stype == 1 ? R.drawable.banner_dian_focus : R.drawable.cicle_banner_dian_focus);
                    for (int i = 0; i < mImageViews.length; i++) {
                        if (index != i) {
                            mImageViews[i].setBackgroundResource(stype == 1 ? R.drawable.banner_dian_blur : R.drawable.cicle_banner_dian_blur);
                        }
                    }
                }
            } catch (Exception ex) {
                // TODO: handle exception
                //   log.logCacheE(TAG, log.getStackMsg("WelcomeTimerHandler", ex));
            }
        }
    }

    /**
     * 轮播图片监听
     *
     * @author minking
     */
    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {

            // log.logI(TAG, "state"+state);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int index) {
            //       log.logI(TAG, "GuidePageChangeListener ::: onPageSelected ::: index  1= " + index + " ::: imgs.len= " + mImageViews.length);
            //
            index = index % mImageViews.length;
            //   log.logI(TAG, "GuidePageChangeListener ::: onPageSelected ::: index  2= " + index);

            //
            Message message = new Message();
            message.arg1 = 1;
            message.arg2 = index;
            lunboTimerHandler.sendMessage(message);
        }
    }


    //设置图片缩放模式
    public void setScaleType(ImageView.ScaleType type) {

        this.Image_Type = type;

    }

    private ImageView.ScaleType Image_Type = ImageView.ScaleType.FIT_CENTER;

    /**
     * 轮播控件的监听事件
     *
     * @author minking
     */
    public interface ImageCycleViewListener {

        /**
         * 单击图片事件
         *
         * @param position
         * @param imageView
         */
        void onImageClick(int position, View imageView);
    }


    public class ImageCycleAdapter extends PagerAdapter {
        /**
         * 图片视图缓存列表
         */
        private ArrayList<ImageView> mImageViewCacheList;
        /**
         * 图片资源列表
         */
        private List<String> mAdList = new ArrayList<String>();
        /**
         * 广告图片点击监听
         */
        private ImageCycleViewListener mImageCycleViewListener;

        private Context mContext;

        public ImageCycleAdapter(Context context, List<String> adList, ImageCycleViewListener imageCycleViewListener) {
            this.mContext = context;
            this.mAdList = adList;
            mImageCycleViewListener = imageCycleViewListener;
            mImageViewCacheList = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return mAdList == null ? 0 : mAdList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            String imageUrl = mAdList.get(position % mAdList.size());
            // String imageUrl = mAdList.get(position);
            ImageView imageView = null;
            if (mImageViewCacheList.isEmpty()) {
                /// LogUtil.i("isEmpty---");
                imageView = new ImageView(mContext);
                //    imageView = (SimpleDraweeView) LayoutInflater.from(mContext).inflate(R.layout.view_simple_drawee_view,container,false);
                imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

            } else {
                imageView = mImageViewCacheList.remove(0);
                //  log.logI(TAG, "ImageCycleViewListener :::: instantiateItem ::: remove---");
            }
            // 设置图片点击监听
            imageView.setOnClickListener(v -> {

                if (mImageCycleViewListener != null) {
                    mImageCycleViewListener.onImageClick(position % mAdList.size(), v);
                }

            });
            imageView.setBackgroundColor(getResources().getColor(R.color.color_white));
            //设置图片缩放模式
            imageView.setScaleType(Image_Type);
            container.addView(imageView);
            //
            Glide.with(mContext).load(imageUrl).into(imageView);
            // log.logI(TAG, "getHeight---"+imageView.getHeight());
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ImageView view = (ImageView) object;
            mAdvPager.removeView(view);
            mImageViewCacheList.add(view);

        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            mAdvPager.setCurrentItem(0);
        }
    }


}
