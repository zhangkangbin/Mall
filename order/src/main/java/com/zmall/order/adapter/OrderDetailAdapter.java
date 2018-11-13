package com.zmall.order.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.z.baselibrary.imgage.ImageLoader;
import com.zmall.order.R;
import com.zmall.order.bean.AllOrderBean;
import com.zmall.order.bean.OrderDetailBean;

import java.util.List;

/**
 * @author kang
 * @date 2018/11/13 0013
 */
public class OrderDetailAdapter extends BaseAdapter {


    private List<OrderDetailBean.DataBean.OrderAllInfoBean.GoodsListBean> list;

    private LayoutInflater inflater;

    public OrderDetailAdapter(LayoutInflater inflater, List<OrderDetailBean.DataBean.OrderAllInfoBean.GoodsListBean> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_order_sub, null);
            viewHolder.orderTvTitle = convertView.findViewById(R.id.orderTvTitle);
            viewHolder.orderTvType = convertView.findViewById(R.id.orderTvType);
            viewHolder.orderTvPrice = convertView.findViewById(R.id.orderTvPrice);
            viewHolder.orderTvNumber = convertView.findViewById(R.id.orderTvNumber);

            viewHolder.orderImg = convertView.findViewById(R.id.orderIv);

            convertView.setTag(viewHolder);

        } else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        OrderDetailBean.DataBean.OrderAllInfoBean.GoodsListBean info = list.get(position);
        viewHolder.orderTvNumber.setText(String.format("x%d", info.getNum()));
        viewHolder.orderTvTitle.setText(info.getGoodsName());
        viewHolder.orderTvPrice.setText(info.getPrice());
        viewHolder.orderTvType.setText(info.getAttrDesc());
        ImageLoader.getInstance().displayImage(parent.getContext(), info.getPicUri(),viewHolder.orderImg );

        return convertView;

    }

    static class ViewHolder {
        TextView orderTvTitle;
        TextView orderTvType;
        TextView orderTvPrice;
        TextView orderTvNumber;
        ImageView orderImg;
    }

}
