package com.ekwing.simalayademo.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ekwing.simalayademo.R;
import com.ekwing.simalayademo.test.bean.HorizontalDataBean;
import com.ekwing.simalayademo.test.view.MyItemRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdatapterHorizontal extends RecyclerView.Adapter<MyAdatapterHorizontal.ViewHolder> {
    private Context mContext;
    private List<HorizontalDataBean> mData=new ArrayList<>();


    public MyAdatapterHorizontal(Context mContext) {
        this.mContext = mContext;
        setData();
    }
    public List setData(){
        for (int i=0;i<8;i++){
            HorizontalDataBean mHorizontalDataBean =new HorizontalDataBean("图片","测试号");
            mData.add(mHorizontalDataBean);
        }

        return mData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MyItemRecyclerView mItemRecyclerView;
        ImageView mImageView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemRecyclerView=itemView.findViewById(R.id.rv_vertion);
            mImageView=itemView.findViewById(R.id.iv_pic_item_list);

        }
    }

    @NonNull
    @Override
    public MyAdatapterHorizontal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.rv_list_heng_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdatapterHorizontal.ViewHolder holder, final int position) {

        Glide.with(mContext).load(mData.get(position).getmImagId()).into(holder.mImageView);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext,"我是onclick的点击事件",Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
