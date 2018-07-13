package com.z.baselibrary.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.z.baselibrary.R;


/**
 * Created by zhangkangbin
 * 基础提示框
 */
public class TipsDialog {

    private final static int SHOW = 1;
    private final static int DISMISSIMG = 2;
    private final static int HIDE = 3;
    private ViewGroup mDecorView;
    private MyLayout rootView;
    private ViewGroup layout_root;
    private Context mContext;
    private boolean mCancelable = true;
    private int state = HIDE; // 1 显示状态 2 正在dismiss  3 没有显示。
    private Builder builder;
    private String TAG="TipsDialog";
    public TipsDialog(final Builder builder) {

        this.builder = builder;
        mContext = builder.getContext();
        mCancelable = builder.isCancelable();
        Activity context = (Activity) mContext;

        mDecorView = (ViewGroup) context.getWindow().getDecorView().findViewById(android.R.id.content);

        //  mDecorView = (ViewGroup) context.getWindow(); //
        // contentContainer = (ViewGroup) mDecorView.findViewById(com.bigkoo.pickerview.R.id.content_container);
        rootView = createRootView();

        rootView.setBackgroundColor(context.getResources().getColor(R.color.transparent_50)); //透明度

        layout_root = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_tips_root, rootView, false); //布局的根视图
        if (builder.getBackground() != 0) {
            layout_root.setBackgroundResource(builder.getBackground());
        }

        rootView.setClickable(true);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mCancelable) {
                    dismiss();
                }
                return false;
            }
        });

        rootView.addView(layout_root);
        initView(builder);


    }

    private MyLayout createRootView() {


        MyLayout rootView = new MyLayout(mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        // layoutParams.gravity = Gravity.BOTTOM;
        rootView.setLayoutParams(layoutParams);

        return rootView;
    }

    private void initView(final Builder builder) {
        //布局内容视图
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, builder.getHeight());
        layoutParams.gravity = builder.getGravity();
        if (!builder.isFullView()) {
            int margin = dip2px(mContext, 25);
         //   LogUtil.i(margin + "");
            layoutParams.leftMargin = margin;
            layoutParams.rightMargin = margin;
        }

        layout_root.setLayoutParams(layoutParams);

        if (builder.getView() != null) {
            layout_root.addView(builder.getView());
        } else {

            View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.dialog_default_tips, null);

            if(!TextUtils.isEmpty(builder.getContentText())){
                TextView tv_context = view.findViewById(R.id.tv_context);
                tv_context.setText(builder.getContentText());
            }
            if(builder.getPositiveButtonListener()!=null){

                TextView tv_confim =  view.findViewById(R.id.tv_confim);
                tv_confim.setVisibility(View.VISIBLE);
                tv_confim.setText(builder.getPositiveText());
                tv_confim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(builder.isCancelable()){
                            mDecorView.removeView(rootView);
                        }
                        builder.getPositiveButtonListener().onClick();
                    }
                });
            }
            if(builder.getNegativeButtonListener()!=null){

                view.findViewById(R.id.tips_line).setVisibility(View.VISIBLE);
                TextView tv_cancle =  view.findViewById(R.id.tv_cancle);
                tv_cancle.setVisibility(View.VISIBLE);
                tv_cancle.setText(builder.getNegativeText());
                tv_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(builder.isCancelable()){
                            mDecorView.removeView(rootView);
                        }

                        builder.getNegativeButtonListener().onClick();
                    }
                });
            }


            layout_root.addView(view);
        }
    }

    public void show() {
      //  Logger.getLogger().logD(TAG, "-----show()-----");

        if (state == HIDE) {
            state = SHOW;
            //具体可以后改
            if (builder.getGravity() == Gravity.BOTTOM) {
                Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_out);
                layout_root.startAnimation(animation);
            }

            mDecorView.addView(rootView);

          //  LogUtil.i("showing...");
        }

    }

    public boolean hasWindowFocus(){
        if(rootView!=null){
            return rootView.hasWindowFocus();
        }
        return false;

    }

    public boolean isShow() {
        if (state == SHOW) {
            return true;
        }
        return false;
    }

    public void dismiss() {
       // Logger.getLogger().logD(TAG, "-----dismiss()-----");
        if (state == SHOW) {
            if (mDecorView != null) {

                if (builder.getGravity() == Gravity.BOTTOM) {
                    Animation  animation = AnimationUtils.loadAnimation(mContext,android.R.anim.fade_out);
                    layout_root.startAnimation(animation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            state = DISMISSIMG;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            if(rootView!=null){
                                rootView.setVisibility(View.GONE);
                                mDecorView.removeView(rootView);
                            }
                            state = HIDE;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                } else {
                   // animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_dialog_alpha);
                    if(rootView!=null){
                        rootView.setVisibility(View.GONE);
                        mDecorView.removeView(rootView);
                    }
                    state = HIDE;
                   // LogUtil.i("dismiss...end");
                }

            }

        }

    }

    public static class Builder {

        private ITipsDialog mNegativeButtonListener;
        private boolean mCancelable = true;
        private Context context;
        private int backgroundRes;
        private int gravity = Gravity.BOTTOM; //默认下方
        private View view;
        private boolean mFullView; //宽度全屏
        private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        private CharSequence positiveText;
        private CharSequence negativeText;
        private ITipsDialog mPositiveButtonListener;
        private CharSequence contentText;

        public Builder(Activity context) {
            setContext(context);
        }

        public Context getContext() {
            return context;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public int getGravity() {
            return gravity;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public View getView() {
            return view;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public boolean isCancelable() {
            return mCancelable;
        }

        public Builder setCancelable(boolean cancelable) {

            this.mCancelable = cancelable;
            return this;
        }

        public int getBackground() {
            return backgroundRes;
        }

        public Builder setBackground(int background) {
            this.backgroundRes = background;
            return this;
        }

        public int getHeight() {
            return height;
        }

        /**
         * 设置高
         * @param height
         */
        public Builder setHeight(int height) {
            this.height = height;

            return this;
        }

        public CharSequence getContentText() {
            return contentText;
        }

        /**
         * 设置内容
         * @param contentText
         */
        public Builder setContentText(CharSequence contentText) {
            this.contentText = contentText;
            return this;
        }

        public CharSequence getPositiveText() {
            return positiveText;
        }

        public Builder setPositiveText(CharSequence positiveText) {
            this.positiveText = positiveText;
            return this;
        }

        public CharSequence getNegativeText() {
            return negativeText;
        }

        public Builder setNegativeText(CharSequence negativeText) {
            this.negativeText = negativeText;
            return this;
        }

        public ITipsDialog getNegativeButtonListener() {
            return mNegativeButtonListener;
        }

        public ITipsDialog getPositiveButtonListener() {
            return mPositiveButtonListener;
        }

        public boolean isFullView() {
            return mFullView;
        }

        /**
         * 宽度是否全屏
         * @param mFullView
         */
        public Builder setFullView(boolean mFullView) {
            this.mFullView = mFullView;
            return this;
        }

        public Builder setPositiveButton(CharSequence text,  ITipsDialog listener) {
            this.positiveText = text;
            this.mPositiveButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(CharSequence text,  ITipsDialog listener) {
            this.negativeText = text;
            this.mNegativeButtonListener = listener;
            return this;
        }

        public Builder setPositiveButton(ITipsDialog listener) {
            return  setPositiveButton("确认",listener);
        }

        public Builder setNegativeButton(ITipsDialog listener) {
            return setNegativeButton("取消",listener);
        }

        public TipsDialog show() {
            TipsDialog tipsDialog = new TipsDialog(this);
            tipsDialog.show();
            return tipsDialog;
        }
    }

    class MyLayout extends FrameLayout {
        public MyLayout(Context context) {
            super(context);

        }
        public MyLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }


        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            // LogUtil.i("data", "init dispatchKeyEvent");
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                if (mCancelable) {
                    dismiss();
                }
            }
            return true;
        }

        @Override
        public boolean hasFocus() {
            return true;
        }


    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
