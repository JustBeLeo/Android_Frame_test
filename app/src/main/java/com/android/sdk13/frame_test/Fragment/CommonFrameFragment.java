package com.android.sdk13.frame_test.Fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sdk13.frame_test.Activity.OKHttpActivity;
import com.android.sdk13.frame_test.Adpter.MyListAdpter;
import com.android.sdk13.frame_test.Base.BaseFragment;
import com.android.sdk13.frame_test.R;

import java.net.ConnectException;

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
        mList = new String[]{"OKHttp","xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Gson","FastJson","picasso","eventBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};
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
            if(mList[position].toLowerCase().equals( "okhttp" ))
                mContext.startActivity( new Intent( mContext,OKHttpActivity.class ) );
        }
    }
}



