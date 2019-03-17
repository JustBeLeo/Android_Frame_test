package com.android.sdk13.frame_test.Glide.Activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.sdk13.frame_test.R;
import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlideBasicActivity extends AppCompatActivity {

    @BindView(R.id.iv_glide_netpic)
    ImageView netpic;
    @BindView(R.id.iv_glide_respic)
    ImageView respic;
    @BindView(R.id.iv_glide_sdpic)
    ImageView sdpic;
    @BindView(R.id.iv_glide_netgif)
    ImageView netgif;
    @BindView(R.id.iv_glide_resgif)
    ImageView resgif;
    @BindView(R.id.iv_glide_sdgif)
    ImageView sdgif;
    @BindView(R.id.iv_glide_sdvideo)
    ImageView sdvideo;
    @BindView(R.id.iv_glide_thumb)
    ImageView thumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_glide_basic );
        ButterKnife.bind( this );
        initView();
    }

    private void initView() {
        //加载网络图片
        Glide.with(this)
                .load("http://img1.imgtn.bdimg.com/it/u=2615772929,948758168&fm=21&gp=0.jpg")
                .into(netpic);

        //加载资源图片
        Glide.with( this )
                .load( R.mipmap.dfyc )
                .into( respic );

        //加载本地图片
        Glide.with( this )
                .load( new File( Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/1.jpg" ) )
                .into( sdpic );

        //加载网络gif
        Glide.with( this )
                .load( "http://b.hiphotos.baidu.com/zhidao/pic/item/faedab64034f78f066abccc57b310a55b3191c67.jpg" )
                .placeholder( R.mipmap.ic_launcher )
                .into( netgif );

        //加载资源gif
        Glide.with( this )
                .load( R.mipmap.loading )
                .placeholder( R.mipmap.ic_launcher )
                .into( resgif );

        //加载本地gif
        Glide.with( this )
                .load( new File( Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/gif1.jpg" ) )
                .into( sdgif );

        //加载本地小视频
        Glide.with( this )
                .load( new File( Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/video.mp4" ) )
                .placeholder( R.mipmap.ic_launcher )
                .into( sdvideo );

        //加载缩略图
        Glide.with(this).load("https://images.pexels.com/photos/604895/pexels-photo-604895.jpeg?cs=srgb&dl=adventure-attraction-beautiful-604895.jpg")
                .thumbnail(0.1f)
                .centerCrop()
                .into(thumb);
    }
}
