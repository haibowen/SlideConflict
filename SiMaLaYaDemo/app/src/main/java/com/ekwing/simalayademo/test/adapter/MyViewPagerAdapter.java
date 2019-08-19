package com.ekwing.simalayademo.test.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mDataFragment;
    private List<String> mDataTitle;
    private Context mContext;

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> mDataFragment, List<String> mDataTitle, Context mContext) {
        super(fm);
        this.mDataFragment = mDataFragment;
        this.mDataTitle = mDataTitle;
        this.mContext = mContext;
    }


    @Override
    public Fragment getItem(int position) {
        return mDataFragment.get(position);
    }

    @Override
    public int getCount() {
        return mDataFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mDataTitle.get(position);
    }

    /**
     *
     * 档viewpager切换fragment以后，fragment中出现数据重复加载的问题的时候要重写此方法
     * 将super的语句删掉
     * @param container
     * @param position
     * @param object
     */

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }
}
