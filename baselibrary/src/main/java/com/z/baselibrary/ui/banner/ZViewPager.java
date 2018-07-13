package com.z.baselibrary.ui.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 主要作用捕获异常
 */
public class ZViewPager extends ViewPager {
    public ZViewPager(Context context) {
        super(context);
    }

    public ZViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


/*

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true); //阻止父view拦截点击事件
        return super.dispatchTouchEvent(ev);
    }
*/

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
            // LogUtil.i("Exception-------"+e.getMessage());
            //  e.printStackTrace();
            return true;
        }
    }
}
