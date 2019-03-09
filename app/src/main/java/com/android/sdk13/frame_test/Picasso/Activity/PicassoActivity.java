package com.android.sdk13.frame_test.Picasso.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.sdk13.frame_test.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PicassoActivity extends AppCompatActivity {

    @BindView(R.id.iv_picasso_image1)
    ImageView image1;
    @BindView(R.id.iv_picasso_image2)
    ImageView image2;
    @BindView(R.id.iv_picasso_image3)
    ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_picasso );
        ButterKnife.bind( this );
    }

    public void help(View v) {
        new AlertDialog.Builder( this )
                .setTitle( "Picasso框架" )
                .setMessage( "主要用于图片资源的加载\n" +
                        "解决了在adapter 中需要取消已经不在视野范围的ImageView 图片资源的加载\n" +
                        "使用复杂的图片压缩转换来尽可能的减少内存消耗\n" +
                        "自带内存和硬盘二级缓存功能" )
                .setPositiveButton( "确认", null )
                .show();
    }

    public void loadImage(View v) {
        // 基本用法

        // 基本加载图片
        Picasso.get().load( "http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg" )
                .into( image1 );
        // 裁剪加载图片
        Picasso.get()
                .load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                .resize(50, 50)
                .centerCrop()
                .into(image2);
        // 旋转180度
        Picasso.get()
                .load("http://n.sinaimg.cn/translate/20160819/9BpA-fxvcsrn8627957.jpg")
                .rotate( 180 )
                .into(image3);
    }

    public void loadListImage(View v) {
        startActivity( new Intent( this,PicassoListViewActivity.class ) );
    }

    public void transformImage(View v) {
        startActivity( new Intent( this,PicassoTransformActivity.class ) );
    }
}
