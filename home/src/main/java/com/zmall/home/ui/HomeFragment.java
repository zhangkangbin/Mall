package com.zmall.home.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.ui.BaseListFragment;
import com.z.baselibrary.ui.banner.ImageCycleView;
import com.zmall.home.R;
import com.zmall.home.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;


/**
 * @author zhangkb
 */
public class HomeFragment extends BaseListFragment<HomeBean, HomeBean.DataBean> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected RecyclerView getRecyclerView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return recyclerView;
    }


    @Override
    public void initData(View view, Bundle savedInstanceState) {


        View header=LayoutInflater.from(getActivity()).inflate(R.layout.item_header_home,null);
        getListBindDataHelper().addHeader(header);

        List<String> imageUrlList = new ArrayList<>();
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=209531698,2607942925&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3877368857,984168879&fm=27&gp=0.jpg");
        ImageCycleView imageCycleView = header.findViewById(R.id.home_banner);
        imageCycleView.setImageResources(imageUrlList);
        imageCycleView.startImageCycle();


    }


    @Override
    public int getAdapterLayoutId() {
        return R.layout.adapter_home;
    }

    @Override
    public List<HomeBean.DataBean> getAdapterList(HomeBean result) {

        List<HomeBean.DataBean> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            HomeBean.DataBean dataBean = new HomeBean.DataBean();
          //  dataBean.setPirce(i + ".00 元");
            list.add(dataBean);
        }


        return list;
    }

    @Override
    public void bindData(CombinationViewHolder holder, HomeBean.DataBean t, int position) {

    //    holder.setTextView(R.id.price,t.getPirce());
        holder.getView(R.id.img_product).setOnClickListener(v -> CC.obtainBuilder("User").setActionName("UserLogin").build().call());
    }

    @Override
    public Call<HomeBean> getCall(Map<String, Object> map) {
        return null;
    }
}
