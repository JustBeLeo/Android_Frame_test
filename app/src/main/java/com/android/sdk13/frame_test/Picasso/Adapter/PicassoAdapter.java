package com.android.sdk13.frame_test.Picasso.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sdk13.frame_test.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class PicassoAdapter extends RecyclerView.Adapter<PicassoAdapter.PicassoViewHolder> {

    Context context;
    String[] images;

    public PicassoAdapter(Context context, String[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public PicassoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate( context,R.layout.item_picasso,null );
        return new PicassoViewHolder( view );
    }

    @Override
    public void onBindViewHolder(PicassoViewHolder holder, int i) {
        holder.text.setText( "这是第" + (i+1) + "条数据" );
        //加载图片
        Picasso.get()
                .load( images[i] )
                .placeholder( R.mipmap.dfyc )
                .error( R.mipmap.girl )
                .into( holder.iv );
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    class PicassoViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView text;

        public PicassoViewHolder(View itemView) {
            super( itemView );
            iv = itemView.findViewById( R.id.iv_picasso_item );
            text = itemView.findViewById(R.id.tv_picasso_item);
        }
    }
}
