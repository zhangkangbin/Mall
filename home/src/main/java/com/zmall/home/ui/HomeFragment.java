package com.zmall.home.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.imgage.ImageLoader;
import com.z.baselibrary.net.HttpUtil;
import com.z.baselibrary.net.MyCallback;
import com.z.baselibrary.recycleview.CombinationViewHolder;
import com.z.baselibrary.ui.BaseListFragment;
import com.z.baselibrary.ui.banner.ImageCycleView;
import com.zmall.home.R;
import com.zmall.home.api.HomeApi;
import com.zmall.home.bean.HomeBean;
import com.zmall.home.bean.HomeInfoBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;


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

    private View header;

    @Override
    public void initData(View view, Bundle savedInstanceState) {


        header = LayoutInflater.from(getActivity()).inflate(R.layout.item_header_home, null);
        getListBindDataHelper().addHeader(header);
        initInfo();

    }


    private void initInfo() {


        HttpUtil.getRetrofit().create(HomeApi.class).getHomeInfo().enqueue(new MyCallback<HomeInfoBean>() {
            @Override
            public void onSuccess(Call<HomeInfoBean> call, Response<HomeInfoBean> response) {
                initImageCycleView(response.body().getData());
            }
        });

    }

    private void initImageCycleView(HomeInfoBean.DataBean data) {
        List<String> imageUrlList = new ArrayList<>();

        for (HomeInfoBean.DataBean.SlideShowListBean info : data.getSlideShowList()) {
            imageUrlList.add(info.getPicUri());
        }

        //  imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=209531698,2607942925&fm=27&gp=0.jpg");
        //   imageUrlList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3877368857,984168879&fm=27&gp=0.jpg");
        ImageCycleView imageCycleView = header.findViewById(R.id.home_banner);
        imageCycleView.setImageResources(imageUrlList);
        imageCycleView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageCycleView.startImageCycle();
    }


    @Override
    public int getAdapterLayoutId() {
        return R.layout.adapter_home;
    }

    @Override
    public List<HomeBean.DataBean> getAdapterList(HomeBean result) {


        return result.getData();
    }

    @Override
    public void bindData(CombinationViewHolder holder, HomeBean.DataBean t, int position) {

        ImageView productImg = holder.getView(R.id.img_product);

        ImageLoader.getInstance().displayImage(getActivity().getApplicationContext(), t.getPicUri(), productImg);

        productImg.setOnClickListener(v -> CC.obtainBuilder("GoodsComponent").setActionName("GoodsDetail").build().call());
        holder.setTextView(R.id.goodsName, t.getGoodsName());
        holder.setTextView(R.id.price, "￥" + t.getPrice());

    }

    @Override
    public Call<HomeBean> getCall(Map<String, Object> map) {

        return HttpUtil.getRetrofit().create(HomeApi.class).getHomeData((String) map.get("pageSize"),
                (Integer) map.get("curPage"));
    }
}
