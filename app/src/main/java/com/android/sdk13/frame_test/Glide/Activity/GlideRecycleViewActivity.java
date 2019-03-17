package com.android.sdk13.frame_test.Glide.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.sdk13.frame_test.Glide.Adapter.GlideAdapter;
import com.android.sdk13.frame_test.Glide.Contacts;
import com.android.sdk13.frame_test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideRecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_glide)
    RecyclerView rvGlide;

    GlideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_glide_recycle_view );
        ButterKnife.bind( this );
        adapter = new GlideAdapter( this, Contacts.IMAGES );
        rvGlide.setAdapter( adapter );
        rvGlide.setLayoutManager( new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false ) );
    }
}
