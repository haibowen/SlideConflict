package com.ekwing.simalayademo.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyViewPagerTypeAdapter extends PagerAdapter {
    private List<View>mDataView;
    private Context mContext;

    public MyViewPagerTypeAdapter(List<View> mDataView, Context context) {
        this.mDataView = mDataView;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDataView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView(mDataView.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mDataView.get(position));
        //每次滑动的时候把视图添加到viewpager
        return mDataView.get(position);
    }
}
