package com.zmall.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.z.baselibrary.ui.BaseFragment;
import com.zmall.user.ui.account.AccountSettingActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView(View view, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view.findViewById(R.id.myIvFace).setOnClickListener(v->{

            startActivity(new Intent(getActivity(),AccountSettingActivity.class));
        });

    }

}
