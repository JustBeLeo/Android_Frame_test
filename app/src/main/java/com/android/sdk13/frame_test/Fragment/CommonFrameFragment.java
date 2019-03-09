package com.android.sdk13.frame_test.Fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.sdk13.frame_test.ButterKnife.ButterKnifeActivity;
import com.android.sdk13.frame_test.EventBus.EventBusActivity;
import com.android.sdk13.frame_test.Json.FastJsonActivity;
import com.android.sdk13.frame_test.Json.GsonActivity;
import com.android.sdk13.frame_test.OkHttp.OKHttpActivity;
import com.android.sdk13.frame_test.OkHttp.OkGoActivity;
import com.android.sdk13.frame_test.Picasso.Activity.PicassoActivity;
import com.android.sdk13.frame_test.RecycleView.RecycleViewActivity;
import com.android.sdk13.frame_test.XUtils3.XUtilsActivity;
import com.android.sdk13.frame_test.Adpter.MyListAdpter;
import com.android.sdk13.frame_test.Base.BaseFragment;
import com.android.sdk13.frame_test.R;

public class CommonFrameFragment extends BaseFragment {
    private static final String TAG = CommonFrameFragment.class.getSimpleName();
    ListView mListView;
    String[] mList;

    @Override
    public View initView() {
        View view = View.inflate( mContext,R.layout.fragment_common_frame,null );
        mListView = view.findViewById( R.id.lv_common_frame_list );
        return view;
    }

    @Override
    protected void initData() {
        mList = new String[]{"OKHttp","OkGO","Gson" ,"FastJson" ,"xUtils3","EventBus" ,"ButterKnife","RecycleView","Picasso" ,"Retrofit2","Fresco","Glide","greenDao","RxJava","volley","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
        mListView.setAdapter( new MyListAdpter(mContext,mList) );
        mListView.setOnItemClickListener( new MyOnItemClickListener(mContext) );
        mListView.setVisibility( View.VISIBLE );
    }


    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        Context context;

        public MyOnItemClickListener(Context mContext){
            context = mContext;
        }
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(cmp(position,"okhttp"))
                start( OKHttpActivity.class );
            if(cmp(position,"okgo"))
                start( OkGoActivity.class );
            if(cmp(position,"xutils3"))
                start( XUtilsActivity.class );
            if(cmp(position,"gson"))
                start( GsonActivity.class );
            if(cmp(position,"fastjson"))
                start( FastJsonActivity.class );
            if(cmp(position,"eventbus"))
                start( EventBusActivity.class );
            if(cmp(position,"butterknife"))
                start( ButterKnifeActivity.class );
            if(cmp(position,"recycleview"))
                start( RecycleViewActivity.class );
            if(cmp(position,"picasso"))
                start( PicassoActivity.class );
        }
    }

    private void start(Class<?> c){
        mContext.startActivity( new Intent( mContext, c ) );
    }

    private boolean cmp(int position,String s) {
        if(mList[position].toLowerCase().equals(s))
            return true;
        return false;
    }
}



