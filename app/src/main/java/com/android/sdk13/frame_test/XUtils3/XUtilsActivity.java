package com.android.sdk13.frame_test.XUtils3;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.sdk13.frame_test.BuildConfig;
import com.android.sdk13.frame_test.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class XUtilsActivity extends AppCompatActivity {

    @ViewInject( R.id.tv_xutils3_title )
    TextView tv_xutils3_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_xutils );

        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);
        x.view().inject( this );
    }

    public void help(View v){
        new AlertDialog.Builder(this)
                .setTitle( "xUtils3  的主要功能" )
                .setMessage( "1、注解\n" +
                        "2、联网请求文本数据\n" +
                        "3、大文件下载\n" +
                        "4、大文件上传\n" +
                        "5、请求图片\n" +
                        "6、数据库模块达到和 greenDao 一致的性能" )
                .setPositiveButton( "确认",null )
                .show();
    }

    public void xNote(View v){
        tv_xutils3_title.setText( "xUtils3测试" );
    }

    public void xNet(View v){

    }

    public void xBitMap(View v){

    }

    public void xBitMaps(View v){

    }

}
