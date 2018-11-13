package com.z.baselibrary.ui.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * list 套list 或者  ScrollView  套list
 */
public class ListViewScrollView extends ListView {
    public ListViewScrollView(Context context) {
        super(context);
    }

    public ListViewScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewScrollView(Context context, AttributeSet attrs,
                              int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 绘制最大高度模式
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}