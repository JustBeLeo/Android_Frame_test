package com.android.sdk13.frame_test.XUtils3.annotation;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.sdk13.frame_test.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class XUtils3Fragment extends AppCompatActivity {

    @ViewInject( R.id.tv_xutils3_fragment_title )
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //setContentView( R.layout.activity_xutils3_fragment );
        x.view().inject( this );

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();


    }
}
