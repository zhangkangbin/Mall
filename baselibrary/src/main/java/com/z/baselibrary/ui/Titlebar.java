package com.z.baselibrary.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.z.baselibrary.R;

/**
 * Created by zhangkb on 2018/1/11 0011.
 */

public class Titlebar extends FrameLayout {

    public Titlebar(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public Titlebar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Titlebar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    /**
     * 初始化
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {


        if (context == null || attrs == null) return;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Titlebar);//从xml那传来的一组值
        //选中
        String title = typedArray.getString(R.styleable.Titlebar_title);

        int titleColor = typedArray.getColor(R.styleable.Titlebar_title_color, context.getResources().getColor(R.color.title_text));
        int bgColor = typedArray.getColor(R.styleable.Titlebar_title_bg, context.getResources().getColor(R.color.title_bg));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.include_toolbar, null);
        TextView toolbar_title = view.findViewById(R.id.toolbar_title);
        toolbar_title.setTextColor(titleColor);
        toolbar_title.setText(title);



        LinearLayout toolbar_relative_layout = view.findViewById(R.id.toolbar_relative_layout);
        toolbar_relative_layout.setBackgroundColor(bgColor);
        addView(view);

        typedArray.recycle();

    }


}
