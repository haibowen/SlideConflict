package com.ekwing.simalayademo.test.fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ekwing.simalayademo.R;
import com.ekwing.simalayademo.test.adapter.MyRecyclerViewTypeAdapter;
import com.ekwing.simalayademo.test.bean.BaseBean;
import com.ekwing.simalayademo.test.bean.BannerBean;
import com.ekwing.simalayademo.test.bean.BookBean;
import com.ekwing.simalayademo.test.bean.HorizontalBean;
import com.ekwing.simalayademo.test.bean.MoreBookBean;
import com.ekwing.simalayademo.test.bean.MovieBean;
import com.ekwing.simalayademo.test.bean.MusicBean;
import com.ekwing.simalayademo.test.bean.VerticalBean;
import com.ekwing.simalayademo.test.bean.ViewpagerBean;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {
    private Context mContext;//
    private RecyclerView rvList;//横向的列表
    private List<BaseBean> mTypeData = new ArrayList<>();//类型列表
    private MyRecyclerViewTypeAdapter mRecyclerViewTypeAdapter;//适配器
    private GridLayoutManager mGridLayoutManager;//布局管理器
    private MoreBookBean moreBookBean;
    private SwipeRefreshLayout srlReferh;//下拉刷新

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragent_home, container, false);
        mContext = getContext();
        initBanner();
        initMusicData();
        initMoreBookData();
        initBookData();
        initMoreBookData();
        initMoveData();
        initMoreBookData();
        initHeng();
        initMoreBookData();
        initViewPager();
        initVert();
        initGridLayout(view);
        initRefershLayout(view);
        return view;
    }

    /**
     * 下拉刷新的初始化
     * @param view
     */

    public void initRefershLayout(View view){
        srlReferh=view.findViewById(R.id.swi_refersh);
        srlReferh.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_orange_light,android.R.color.holo_red_light);
        srlReferh.setProgressBackgroundColorSchemeResource(android.R.color.white);

        srlReferh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Thread.sleep(2000);

                           //dosomething

                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                       getActivity().runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               srlReferh.setRefreshing(false);
                           }
                       });

                   }
               }).start();

            }
        });


    }

    /**
     * 数据初始化
     */
    private void initMusicData(){
        for (int i =0;i<8;i++){
            MusicBean musicBean=new MusicBean("音乐");
            musicBean.setType(BaseBean.MUSIC);
            mTypeData.add(musicBean);
        }
    }
    private void initBookData(){

        for (int i=0;i<4;i++){
            BookBean bookBean=new BookBean(getResources().getString(R.string.icon_url),"测试");
            bookBean.setType(BaseBean.BOOK);
            mTypeData.add(bookBean);
        }
    }
    private void initMoveData(){

        for (int i=0;i<4;i++){
            MovieBean movieBean =new MovieBean(getResources().getString(R.string.icon_url_move),"测试",1);
            movieBean.setType(BaseBean.MOVE);
            mTypeData.add(movieBean);
        }
    }
    public void  initMoreBookData(){
        moreBookBean=new MoreBookBean();
        moreBookBean.setType(BaseBean.MOREBOOK);
        mTypeData.add(moreBookBean);
    }
    public void initBanner(){
        BannerBean mBannerBean=new BannerBean();
        mBannerBean.setType(BaseBean.BANNER);
        mTypeData.add(mBannerBean);

    }
    public void initHeng(){
            HorizontalBean mHorizontalBean =new HorizontalBean();
            mHorizontalBean.setType(BaseBean.HENG);
            mTypeData.add(mHorizontalBean);

    }
    public void  initViewPager(){
        ViewpagerBean mViewpagerBean=new ViewpagerBean();
        mViewpagerBean.setType(BaseBean.VIEW_PAGER);
        mTypeData.add(mViewpagerBean);

    }
    public void initVert(){
        VerticalBean mVerticalBean =new VerticalBean();
        mVerticalBean.setType(BaseBean.TYPE_VERT);
        mTypeData.add(mVerticalBean);

    }

    /**
     * 返回列表列
     * @param view
     */
    public void initGridLayout(View view){
        mGridLayoutManager=new GridLayoutManager(mContext,4);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                BaseBean baseBean =mTypeData.get(position);
                if (baseBean.getType()==BaseBean.BANNER){
                    return 4;
                }else if (baseBean.getType()==BaseBean.MUSIC){
                    return 1;
                }else if (baseBean.getType()==BaseBean.MOREBOOK){
                    return 4;
                }
                else if (baseBean.getType()==BaseBean.BOOK){
                    return 2;
                }else if (baseBean.getType()==BaseBean.MOVE){
                    return 4;
                }else if (baseBean.getType()==BaseBean.HENG){
                    return 4;
                }else if (baseBean.getType()==BaseBean.VIEW_PAGER){
                    return 4;
                }
                else if (baseBean.getType()==BaseBean.TYPE_VERT){
                    return 4;
                }
                return 0;
            }
        });

        rvList = view.findViewById(R.id.rv_list);
        rvList.setLayoutManager(mGridLayoutManager);
        mRecyclerViewTypeAdapter = new MyRecyclerViewTypeAdapter(mContext, mTypeData);
        rvList.setAdapter(mRecyclerViewTypeAdapter);
    }

}
