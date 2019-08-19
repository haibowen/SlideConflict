package com.ekwing.simalayademo.test.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.ekwing.simalayademo.R;
import com.ekwing.simalayademo.test.bean.BaseBean;
import com.ekwing.simalayademo.test.bean.BookBean;
import com.ekwing.simalayademo.test.bean.MoreBookBean;
import com.ekwing.simalayademo.test.bean.MovieBean;
import com.ekwing.simalayademo.test.bean.MusicBean;
import com.ekwing.simalayademo.test.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<BaseBean> mData;//数据源
    private List<View> mDataView=new ArrayList<>();//view
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_TITLE = 1;
    public static final int TYPE_MORE_BOOK = 2;
    public static final int TYPE_CARD_VERTICAL = 3;
    public static final int TYPE_CARD_HORZITAL = 4;
    public static final int TYPE_HENG=5;
    public static  final  int TYPE_PAGER=6;
    public static final int TYPE_VERT=7;


    public MyRecyclerViewTypeAdapter(Context mContext, List<BaseBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    /**
     *  各种 viewholder
     */
    static class BannerVieHolder extends RecyclerView.ViewHolder {
        private Banner mBanner;//展示类型的

        public BannerVieHolder(@NonNull View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.view_banner);
        }
    }

    static class MusicViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;//展示类型的

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_type);
        }
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;//展示类型的
        private ImageView ivPic;//展示图片的

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;//展示类型的
        private ImageView ivPic;//展示图片的

        public MoveViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }

    static class MoreBookHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;//展示类型的
        private TextView tvMore;//更多

        public MoreBookHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_tuijian);
            tvMore = itemView.findViewById(R.id.tv_more);
        }
    }
    static class HengViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView mRecyclerView;//列表

        public HengViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecyclerView=itemView.findViewById(R.id.rv_list_heng);


        }
    }
    static class PagerViewHolder extends RecyclerView.ViewHolder {
        private ViewPager mViewPager;//列表

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mViewPager = itemView.findViewById(R.id.vp_type);


        }
    }
        static class VertViewHolder extends RecyclerView.ViewHolder {
            private RecyclerView mRecyclerView;//列表
            private ImageView mImageView;

            public VertViewHolder(@NonNull View itemView) {
                super(itemView);
                mRecyclerView=itemView.findViewById(R.id.rv_vertion);
                mImageView=itemView.findViewById(R.id.iv_pic_item_list);


            }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == TYPE_TITLE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_music, parent, false);
            MusicViewHolder viewHolder = new MusicViewHolder(view);
            return viewHolder;
        }
        if (viewType == TYPE_MORE_BOOK) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_book_title, parent, false);
            MoreBookHolder viewHolder = new MoreBookHolder(view);
            return viewHolder;
        }
        if (viewType == TYPE_CARD_VERTICAL) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_book, parent, false);
            BookViewHolder viewHolder = new BookViewHolder(view);
            return viewHolder;
        }
        if (viewType == TYPE_CARD_HORZITAL) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_move, parent, false);
            MoveViewHolder viewHolder = new MoveViewHolder(view);
            return viewHolder;
        }
        if (viewType == TYPE_BANNER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_banner, parent, false);
            BannerVieHolder viewHolder = new BannerVieHolder(view);
            return viewHolder;
        }
        if (viewType==TYPE_HENG){
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_item_heng, parent, false);
            HengViewHolder viewHolder = new HengViewHolder(view);
            return viewHolder;
        }
        if (viewType==TYPE_PAGER){
            view=LayoutInflater.from(mContext).inflate(R.layout.rv_item_vp_list,parent,false);
            PagerViewHolder pagerViewHolder=new PagerViewHolder(view);
            return pagerViewHolder;
        }if (viewType==TYPE_VERT){
            view=LayoutInflater.from(mContext).inflate(R.layout.rv_item_rv,parent,false);
            VertViewHolder mVertViewHolder=new VertViewHolder(view);
            return mVertViewHolder;
        }


        return null;

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MusicViewHolder) {
            MusicViewHolder mViewHolder = (MusicViewHolder) holder;
            MusicBean musicBean = (MusicBean) mData.get(position);
            mViewHolder.tvTitle.setText(musicBean.getmTypeWord());
        }
        if (holder instanceof MoreBookHolder) {
            MoreBookHolder moreBookHolder = (MoreBookHolder) holder;
            MoreBookBean moreBookBean = (MoreBookBean) mData.get(position);
            moreBookHolder.tvMore.setText("更多");
            moreBookHolder.tvContent.setText("推荐数据");

        }
        if (holder instanceof BookViewHolder) {
            BookViewHolder mViewHolder = (BookViewHolder) holder;
            BookBean bookBean = (BookBean) mData.get(position);
            mViewHolder.tvContent.setText(bookBean.getmTextCotent());
            Glide.with(mContext).load(bookBean.getmImageId()).into(mViewHolder.ivPic);
           // Palette.from().generate();
        }
        if (holder instanceof MoveViewHolder) {
            MoveViewHolder mViewHolder = (MoveViewHolder) holder;
            MovieBean movieBean = (MovieBean) mData.get(position);
            mViewHolder.tvContent.setText(movieBean.getmTextContent());
            Glide.with(mContext).load(movieBean.getmImageId()).into(mViewHolder.ivPic);
        }
        if (holder instanceof BannerVieHolder) {
            setBanner((BannerVieHolder) holder);//设置轮播图
        }
        if (holder instanceof HengViewHolder){
            HengViewHolder hengViewHolder= (HengViewHolder) holder;
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL,false);
            hengViewHolder.mRecyclerView.setLayoutManager(layoutManager);
            MyAdatapterHorizontal mAdatapterHeng=new MyAdatapterHorizontal(mContext);
            hengViewHolder.mRecyclerView.setAdapter(mAdatapterHeng);


        }
        if (holder instanceof PagerViewHolder){
            PagerViewHolder pagerViewHolder= (PagerViewHolder) holder;
            LayoutInflater mLayoutInflater=LayoutInflater.from(mContext);
            mDataView.add(mLayoutInflater.inflate(R.layout.vp_bottom_layout_view,null));
            mDataView.add(mLayoutInflater.inflate(R.layout.vp_bottom_layout_view2,null));
            MyViewPagerTypeAdapter mViewPagerBottomAdapter=new MyViewPagerTypeAdapter(mDataView,mContext);

            pagerViewHolder.mViewPager.setAdapter(mViewPagerBottomAdapter);


        }
        if (holder instanceof VertViewHolder){
            VertViewHolder vertViewHolder= (VertViewHolder) holder;
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext);
            vertViewHolder.mRecyclerView.setLayoutManager(layoutManager);
            MyAdatapterHorizontal mAdatapterHeng=new MyAdatapterHorizontal(mContext);
            vertViewHolder.mRecyclerView.setAdapter(mAdatapterHeng);



        }
    }

    private void setBanner(@NonNull BannerVieHolder holder) {
        List<String> mPicData = new ArrayList<>();
        mPicData.add("https://cdn.pixabay.com/photo/2018/03/10/09/45/businessman-3213659_1280.jpg");
        mPicData.add("https://img.xjh.me/mobile/bg/nature/63792823_p0.jpg");
        mPicData.add("http://api.dujin.org/bing/1920.php");
        mPicData.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        //banner的设置
        holder.mBanner.setImageLoader(new GlideImageLoader());//设置图片加载
        holder.mBanner.setImages(mPicData);//设置图片数据源
        holder.mBanner.setBannerAnimation(Transformer.ZoomOutSlide);//设置轮播的动画
        holder.mBanner.isAutoPlay(true);//自动播放
        holder.mBanner.setDelayTime(4000);//延时
        holder.mBanner.setIndicatorGravity(BannerConfig.CENTER);//指示器的位置
        holder.mBanner.start();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.size() <= 0) {
            return 0;
        } else if (mData.get(position).getType() == TYPE_BANNER) {
            return TYPE_BANNER;

        } else if (mData.get(position).getType() == TYPE_TITLE) {
            return TYPE_TITLE;
        } else if (mData.get(position).getType() == TYPE_MORE_BOOK) {
            return TYPE_MORE_BOOK;
        } else if (mData.get(position).getType() == TYPE_CARD_VERTICAL) {
            return TYPE_CARD_VERTICAL;
        } else if (mData.get(position).getType() == TYPE_CARD_HORZITAL) {
            return TYPE_CARD_HORZITAL;
        }else if (mData.get(position).getType()==TYPE_HENG){
            return TYPE_HENG;
        }else if (mData.get(position).getType()==TYPE_PAGER){
            return TYPE_PAGER;
        }else if (mData.get(position).getType()==TYPE_VERT){
            return TYPE_VERT;
        }

        return super.getItemViewType(position);
    }
}
