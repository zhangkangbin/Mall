package com.zmall.home.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.z.baselibrary.net.BaseBean;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.ui.BaseListFragment;
import com.zmall.home.R;
import com.zmall.home.api.HomeApi;
import com.zmall.home.bean.ShoppingCarBean;
import com.zmall.home.ui.order.OrderConfirmationActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCarFragment extends BaseListFragment<ShoppingCarBean, ShoppingCarBean.DataBean> {


    public ShoppingCarFragment() {
        // Required empty public constructor
    }

    List<String> mGoodList;

    @Override
    protected RecyclerView getRecyclerView(View view) {


        return view.findViewById(R.id.recycler_view);
    }

    TextView shoppingTvSumPrice;
    TextView shoppingTvEdit;

    TextView shoppingTvPay;
    //
    boolean isEidt;

    @Override
    public void initData(View view, Bundle savedInstanceState) {


        mGoodList = new ArrayList<>();
        shoppingTvEdit = view.findViewById(R.id.shoppingTvEdit);
        shoppingTvEdit.setOnClickListener(v -> {


            if (!isEidt) {
                shoppingTvEdit.setText("完成");
                shoppingTvPay.setText("删除");
                shoppingTvSumPrice.setVisibility(View.GONE);
                isEidt = true;
            } else {
                shoppingTvPay.setText("结算");
                shoppingTvEdit.setText("编辑");
                shoppingTvSumPrice.setVisibility(View.VISIBLE);
                isEidt = false;
            }


        });

        shoppingTvPay = view.findViewById(R.id.shoppingTvPay);
        shoppingTvPay.setOnClickListener(v -> {

            if(isEidt){
               // idShoppingCart
                deleteGoods("idShoppingCart");
            }else {
                startActivity(new Intent(getActivity(), OrderConfirmationActivity.class));

            }

        });

        shoppingTvSumPrice = view.findViewById(R.id.shoppingTvSumPrice);

        view.<CheckBox>findViewById(R.id.shoppingCbAllSelect).setOnCheckedChangeListener((buttonView, isChecked) -> {

            selectGoods(isChecked);
        });
    }


    private void selectGoods(boolean isChecked) {
        for (ShoppingCarBean.DataBean list : getListBindDataHelper().getListData()) {

            list.setSelect(isChecked);

            if (isChecked) {
                mGoodList.add(list.getSkuNo());
            }

        }


        if (!isChecked) {
            mGoodList.clear();
        }

        getListBindDataHelper().notifyDataSetChanged();
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
                mGoodList.add(dataBean.getSkuNo());

            } else {
                mGoodList.remove(dataBean.getSkuNo());
                mSumPrice = mSumPrice - price;
            }
            shoppingTvSumPrice.setText("合计：￥" + mSumPrice);
        });

    }


    @Override
    public Call<ShoppingCarBean> getCall(Map<String, Object> map) {
        return HttpUtil.getRetrofit().create(HomeApi.class).getShoppingCarInfo();

    }


    private void  deleteGoods(String idShoppingCart){


        HttpUtil.getRetrofit().create(HomeApi.class).deleteShoppingCart(idShoppingCart).enqueue(new MyCallback<BaseBean>() {
            @Override
            public void onSuccess(Call<BaseBean> call, Response<BaseBean> response) {

            }

            @Override
            public void onFailure(Call<BaseBean> call, Throwable t) {
                super.onFailure(call, t);
            }
        });

    }

}
