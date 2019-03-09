package com.android.sdk13.frame_test.Picasso.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.sdk13.frame_test.Picasso.Adapter.PicassoAdapter;
import com.android.sdk13.frame_test.Picasso.Contacts;
import com.android.sdk13.frame_test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PicassoListViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_picasso)
    RecyclerView rvPicasso;

    PicassoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_picasso_list_view );
        ButterKnife.bind( this );
        adapter = new PicassoAdapter(this,Contacts.IMAGES );
        rvPicasso.setAdapter( adapter );
        rvPicasso.setLayoutManager( new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false ) );
    }



    public void help(View v) {
    }
}
