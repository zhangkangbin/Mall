package com.zmall.home.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.billy.cc.core.component.CC;
import com.z.baselibrary.ui.BaseViewPagerActivity;
import com.zmall.home.R;


import java.util.ArrayList;
import java.util.List;


/**
 * @author zhangkb
 */
public class IndexActivity extends BaseViewPagerActivity {

    //registerForDebug
    @Override
    protected List<Fragment> getFragmentList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ProductTypeFragment());
        list.add(new ShoppingCarFragment());
        Fragment fragment = CC.obtainBuilder("User").setActionName("MyFragment").build().call().getDataItem("MyFragment");

        if (fragment != null) {
            list.add(fragment);

        }
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        // ConcurrentLinkedQueue list;
        //   list.add()
        //CC.registerGlobalInterceptor();
       // findViewById(R.id.main_rb_me).setOnClickListener(view -> CC.obtainBuilder("User").setActionName("login").build().call());

        findViewById(R.id.main_rb_index).setOnClickListener(view -> {

            getViewPager().setCurrentItem(0);
        });


        findViewById(R.id.main_rb_type).setOnClickListener(view -> {

            getViewPager().setCurrentItem(1);
        });


        findViewById(R.id.main_rb_car).setOnClickListener(view -> {

            getViewPager().setCurrentItem(2);
        });

        findViewById(R.id.main_rb_me).setOnClickListener(view -> {

            getViewPager().setCurrentItem(3);

           // CC.obtainBuilder("GoodsComponent").setActionName("GoodsDetail").build().call();
        });
    }

}
