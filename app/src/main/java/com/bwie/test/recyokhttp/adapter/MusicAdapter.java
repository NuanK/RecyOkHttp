package com.bwie.test.recyokhttp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.recyokhttp.R;
import com.bwie.test.recyokhttp.bean.MusicBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by ASUS on 2017/11/10.
 */

public class MusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MusicBean.SongListBean>list;

    public MusicAdapter(Context context, List<MusicBean.SongListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MusicBean.SongListBean songListBean = list.get(position);
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        ImageLoader.getInstance().displayImage(songListBean.getPic_big(), myViewHolder.rv_img);
        myViewHolder.tv_time.setText(songListBean.getTitle());
        myViewHolder.tv_content.setText(songListBean.getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView rv_img;
        private TextView tv_time;
        private TextView tv_content;


        public MyViewHolder(View itemView) {
            super(itemView);
            rv_img = itemView.findViewById(R.id.rv_img);
            tv_time = itemView.findViewById(R.id.rv_time);
            tv_content = itemView.findViewById(R.id.rv_content);
        }
    }

}
