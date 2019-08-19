package com.ekwing.simalayademo.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.TableLayout;

import com.ekwing.simalayademo.R;
import com.ekwing.simalayademo.test.adapter.MyViewPagerAdapter;
import com.ekwing.simalayademo.test.fragment.FragmentHome;
import com.ekwing.simalayademo.test.fragment.FragmentMusic;
import com.ekwing.simalayademo.test.fragment.FragmentVip;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private Context mContext;//上下文
    private TabLayout tlShowTitle;//头部标题展示
    private ViewPager vpPage;//滑动页面
    private List<Fragment> mDataFragment;//fragment的集合
    private List<String> mDataTitle;//tab的标题
    private MyViewPagerAdapter mViewPagerAdapter;//vp的适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        initView();
        setUpData();
    }
    private void initView() {
        tlShowTitle=findViewById(R.id.tl_show_title);
        vpPage=findViewById(R.id.vp_show);
        ImmersionBar.with(this).statusBarColor(R.color.colorBar).init();
        mDataFragment=new ArrayList<>();
        mDataTitle=new ArrayList<>();
    }
    public void setUpData(){
        mDataTitle.add("推荐");
        mDataTitle.add("VIP");
        mDataTitle.add("小说");
        mDataFragment.add(new FragmentHome());
        mDataFragment.add(new FragmentVip());
        mDataFragment.add(new FragmentMusic());
        mViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager(),mDataFragment,mDataTitle,mContext);
        vpPage.setAdapter(mViewPagerAdapter);
        tlShowTitle.setupWithViewPager(vpPage);
    }

}
