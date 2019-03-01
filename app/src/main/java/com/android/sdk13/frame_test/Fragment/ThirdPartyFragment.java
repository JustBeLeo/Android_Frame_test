package com.android.sdk13.frame_test.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.android.sdk13.frame_test.Base.BaseFragment;

public class ThirdPartyFragment extends BaseFragment {
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();

    @Override
    public View initView() {
        Log.e(TAG,"第三方页面被初始化了...");
        TextView textView = new TextView( mContext );
        textView.setText( "第三方页面" );
        textView.setTextSize( 20 );
        textView.setGravity( Gravity.CENTER );
        return textView;
    }

    @Override
    protected void initData() {

    }
}
