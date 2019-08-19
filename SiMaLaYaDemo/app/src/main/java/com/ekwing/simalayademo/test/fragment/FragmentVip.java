package com.ekwing.simalayademo.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ekwing.simalayademo.R;
import com.ekwing.simalayademo.test.adapter.MyViewPagerTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentVip extends Fragment {
    private ViewPager vpShowType;
    private Context mContext;
    private List<View> mDataView=new ArrayList<>();
    private MyViewPagerTypeAdapter mViewPagerBottomAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vip, container, false);
        mContext=getContext();
       initViewPager(view);
        return view;
    }

    public  void initViewPager(View view){

        vpShowType=view.findViewById(R.id.vp_type);
        LayoutInflater mLayoutInflater=LayoutInflater.from(mContext);
        mDataView.add(mLayoutInflater.inflate(R.layout.vp_bottom_layout_view,null));
        mDataView.add(mLayoutInflater.inflate(R.layout.vp_bottom_layout_view2,null));
        mViewPagerBottomAdapter=new MyViewPagerTypeAdapter(mDataView,mContext);

        vpShowType.setAdapter(mViewPagerBottomAdapter);



    }

}
