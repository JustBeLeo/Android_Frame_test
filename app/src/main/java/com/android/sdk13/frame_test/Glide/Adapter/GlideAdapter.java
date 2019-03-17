package com.android.sdk13.frame_test.Glide.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.sdk13.frame_test.R;
import com.bumptech.glide.Glide;

public class GlideAdapter extends RecyclerView.Adapter<GlideAdapter.GlideHolder> {
    Context context;
    String[] datas;

    public GlideAdapter(Context context, String[] datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public GlideHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate( context,R.layout.item_glide,null );
        return new GlideHolder( view );
    }

    @Override
    public void onBindViewHolder(GlideHolder holder, int i) {
        Glide.with( context )
                .load( datas[i] )
                .placeholder( R.mipmap.loading )
                .into( holder.view );
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    class GlideHolder extends RecyclerView.ViewHolder{
        ImageView view;
        public GlideHolder(View itemView) {
            super( itemView );
            view = itemView.findViewById( R.id.iv_glide_item );
        }
    }
}
