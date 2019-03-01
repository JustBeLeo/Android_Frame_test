package com.android.sdk13.frame_test.Adpter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyListAdpter extends BaseAdapter {
    String[] mList;
    Context mContext;

    public MyListAdpter(Context context,String[] mList) {
        this.mList = mList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView( mContext );
        view.setText( mList[position] );
        view.setTextSize( 20 );
        view.setPadding( 20,20,0,20 );
        view.setGravity( Gravity.CENTER_VERTICAL );
        return view;
    }
}
