package com.z.baselibrary.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.z.baselibrary.imgage.ImageLoader;


/**
 *
 * @author zhangkangbin
 * @date 2016/2/17 14:48
 */
public class CombinationViewHolder extends RecyclerView.ViewHolder {

    private View mView;
    private SparseArray<View> mViewArray;

    public CombinationViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mViewArray = new SparseArray<>();
    }

    public CombinationViewHolder setText(int id, String s) {
        setTextView(id, s);
        return this;
    }

    public TextView setTextView(int id, String s) {
        TextView textView = getView(id);
        if (!TextUtils.isEmpty(s)) {
            textView.setText(s);
        }

        return textView;
    }


    public TextView getTextView(int id) {
        return getView(id);
    }

    /**
     * 设置图片
     *
     * @param context
     * @param id
     * @param imageUrl
     * @return
     */
    public ImageView setImageView(Context context, int id, String imageUrl) {
        ImageView imageView = getView(id);
        ImageLoader.getInstance().displayImage(context, imageUrl, imageView);
        return imageView;
    }

    public <T extends View> T getView(int id) {

        View v = mViewArray.get(id);
        if (v == null) {
            v = mView.findViewById(id);
            mViewArray.put(id, v);
        }

        return (T) v;

    }
}