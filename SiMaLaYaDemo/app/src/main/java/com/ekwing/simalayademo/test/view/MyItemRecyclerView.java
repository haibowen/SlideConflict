package com.ekwing.simalayademo.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemRecyclerView  extends RecyclerView {
    private int mMove_x;
    private int mMove_y;
    private int mTouchSlop;
    public MyItemRecyclerView(@NonNull Context context) {
        super(context);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public MyItemRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final ViewConfiguration vc = ViewConfiguration.get(context);
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public MyItemRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()){

            case MotionEvent.ACTION_DOWN:
                mMove_x = (int) e.getX();
                mMove_y = (int) e.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;


            case MotionEvent.ACTION_MOVE:

                int y = (int) e.getY();
                int x = (int) e.getX();
                if(Math.abs(y-mMove_y)>mTouchSlop*2&&Math.abs(x-mMove_x)<mTouchSlop){
                    getParent().requestDisallowInterceptTouchEvent(true);
                }else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;


        }

        return super.onTouchEvent(e);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
