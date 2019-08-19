package com.ekwing.simalayademo.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewpager extends ViewPager {
    private int mMove_x;
    private int mMove_y;
    private int mTouchSlop;
    public MyViewpager(@NonNull Context context) {
        super(context);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public MyViewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                mMove_x = (int) ev.getX();
                mMove_y = (int) ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);

                break;

            case MotionEvent.ACTION_MOVE:
                int y = (int) ev.getY();
                int x = (int) ev.getX();
                if(Math.abs(y-mMove_y)>mTouchSlop&&Math.abs(x-mMove_x)<mTouchSlop*2){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;


        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //MeasureSpec 不仅有组件的大小还有组件的尺寸的模式，EXACTLY  AT_MOST  UNSPECIFIED

        int mHeight=0;
        //下面遍历所有childview的高度
        for (int i = 0; i <getChildCount() ; i++) {
            View child=getChildAt(i);
            child.measure(widthMeasureSpec,MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
            int h=child.getMeasuredHeight();
            if (h>mHeight){
                mHeight=h;

            }
            heightMeasureSpec=MeasureSpec.makeMeasureSpec(mHeight,MeasureSpec.EXACTLY);


        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
