package com.zmall.home.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.ui.BaseListFragment;
import com.zmall.home.R;
import com.zmall.home.api.HomeApi;
import com.zmall.home.bean.ShoppingCarBean;
import com.zmall.home.ui.order.OrderConfirmationActivity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCarFragment extends BaseListFragment<ShoppingCarBean, ShoppingCarBean.DataBean> {


    public ShoppingCarFragment() {
        // Required empty public constructor
    }

    @Override
    protected RecyclerView getRecyclerView(View view) {


        return view.findViewById(R.id.recycler_view);
    }

    TextView shoppingTvSumPrice;

    @Override
    public void initData(View view, Bundle savedInstanceState) {

        view.findViewById(R.id.shoppingTvPay).setOnClickListener(v -> {

            startActivity(new Intent(getActivity(), OrderConfirmationActivity.class));

        });

        shoppingTvSumPrice = view.findViewById(R.id.shoppingTvSumPrice);

        view.<CheckBox>findViewById(R.id.shoppingCbAllSelect).setOnCheckedChangeListener((buttonView, isChecked) -> {

            for (ShoppingCarBean.DataBean list : getListBindDataHelper().getListData()) {

                list.setSelect(isChecked);

            }

            getListBindDataHelper().notifyDataSetChanged();
        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_shopping_car;
    }

    @Override
    public int getAdapterLayoutId() {
        return R.layout.adapter_shopping_car;
    }

    @Override
    public List<ShoppingCarBean.DataBean> getAdapterList(ShoppingCarBean result) {
        return result.getData();
    }

    private double mSumPrice;

    @Override
    public void bindData(CombinationViewHolder holder, ShoppingCarBean.DataBean dataBean,
                         int position) {

        holder.setText(R.id.shoppingTvTitle, dataBean.getGoodsName());
        holder.setText(R.id.shoppingTvSubTitle, dataBean.getAttrDesc());
        holder.setText(R.id.shoppingTvPrice, "￥" + dataBean.getPrice());

        holder.setImageView(getActivity().getApplicationContext(), R.id.shoppingIvImg, dataBean.getPicUri());

        CheckBox shoppingCbSelect = holder.getView(R.id.shoppingCbSelect);
        shoppingCbSelect.setChecked(dataBean.isSelect());
        shoppingCbSelect.setOnCheckedChangeListener((buttonView, isChecked) -> {

            double price = Double.parseDouble(dataBean.getPrice());

            if (isChecked) {
                mSumPrice = mSumPrice + price;
            } else {
                mSumPrice = mSumPrice - price;
            }
            shoppingTvSumPrice.setText("￥" + mSumPrice);
        });

    }


    @Override
    public Call<ShoppingCarBean> getCall(Map<String, Object> map) {
        return HttpUtil.getRetrofit().create(HomeApi.class).getShoppingCarInfo();

    }


}
