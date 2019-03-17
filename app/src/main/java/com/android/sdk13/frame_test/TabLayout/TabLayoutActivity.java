package com.android.sdk13.frame_test.TabLayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.android.sdk13.frame_test.R;
import com.android.sdk13.frame_test.TabLayout.Adapter.TabAdapter;
import com.android.sdk13.frame_test.TabLayout.Fragment.TabFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {


    @BindView(R.id.vp_tablayout)
    ViewPager vp;

    @BindView( R.id.tl_tablayout )
    TabLayout tl;

    TabAdapter adapter;
    ArrayList<TabFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tab_layout );
        ButterKnife.bind( this );
        fragments = new ArrayList<>();
        for(int i = 1;i<=10;i++){
            fragments.add( new TabFragment( "页面"+ i,"这是第"+i+"个页面" ) );
        }
        adapter = new TabAdapter( getSupportFragmentManager(),fragments );
        vp.setAdapter( adapter );
        tl.setTabMode( TabLayout.MODE_SCROLLABLE );
        tl.setupWithViewPager( vp );
    }
}
