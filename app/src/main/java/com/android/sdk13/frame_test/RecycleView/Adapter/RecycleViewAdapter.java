/*
 * Copyright (c) 2019.
 */

package com.android.sdk13.frame_test.RecycleView.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sdk13.frame_test.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> data;
    Bitmap image;

    public RecycleViewAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        image = BitmapFactory.decodeResource(context.getResources(),R.mipmap.dfyc);
    }

    //将itemView绑定到ViewHolder里
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate( context, R.layout.item_recycler_view,null);
        return new MyViewHolder( view );
    }

    //数据和ViewHolder绑定
    public void onBindViewHolder(MyViewHolder v, int i) {
        v.title.setText( data.get( i ) );
        v.text.setText( "What I am talking about" );
        v.chathead.setImageBitmap( image );
    }


    public int getItemCount() {
        return data.size();
    }

    public void addItem(int position, String str){
        data.add( position,str );
        notifyItemInserted( position );
    }

    public void removeItem(int position){
        data.remove( position );
        notifyItemRemoved( position );
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView text;
        ImageView chathead;

        public MyViewHolder(View v) {
            super( v );
            title = v.findViewById( R.id.tv_rvitem_title );
            text = v.findViewById( R.id.tv_rvitem_text );
            chathead = v.findViewById( R.id.iv_rvitem_chathead );
            v.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText( context,data.get( getLayoutPosition() ),Toast.LENGTH_SHORT ).show();
                }
            } );
        }
    }
}
