package com.android.sdk13.frame_test.Glide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.sdk13.frame_test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends AppCompatActivity {

    @BindView(R.id.bt_glide_basic)
    Button basic;
    @BindView(R.id.bt_glide_list)
    Button list;
    @BindView(R.id.bt_glide_transform)
    Button transform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_glide );
        ButterKnife.bind( this );
    }

    @OnClick({R.id.bt_glide_basic, R.id.bt_glide_list, R.id.bt_glide_transform})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_glide_basic:
                startActivity( new Intent( this,GlideBasicActivity.class ) );
                break;
            case R.id.bt_glide_list:
                startActivity( new Intent( this,GlideRecycleViewActivity.class ) );
                break;
            case R.id.bt_glide_transform:
                startActivity( new Intent( this,GlideTransformActivity.class ) );
                break;
        }
    }

    public void help(View view) {

    }
}
