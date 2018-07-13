package com.z.baselibrary.ui.viewselector;

import android.content.Context;
import android.util.AttributeSet;


/**
 * Created by zhangkb on 2017/9/25 0025.
 * 设置按钮选择和默认的颜色
 * 按钮的圆度radius
 */

public class TextViewSelector extends android.support.v7.widget.AppCompatTextView {
    public TextViewSelector(Context context) {
        super(context);
    }

    private String TAG = this.getClass().getSimpleName();

    public TextViewSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextViewSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        SelectorUtils.setBackground(context,attrs,this);
    }

}
