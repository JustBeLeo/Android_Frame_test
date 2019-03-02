package com.android.sdk13.frame_test.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sdk13.frame_test.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;

public class OkGoActivity extends AppCompatActivity {

    ProgressBar pb_okgo;
    TextView tv_okgo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ok_go );
        initView();
    }

    private void initView() {
        pb_okgo = findViewById( R.id.pb_okgo );
        tv_okgo = findViewById( R.id.tv_okgo );
        tv_okgo.setText( "进度：" );
        pb_okgo.setMax( 100 );
    }

    public void goGet(View v){
        OkGo.<String>get("https://www.baidu.com/")
                .execute( new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText( OkGoActivity.this,response.body(),Toast.LENGTH_SHORT ).show();
                    }
                } );
    }

    public void goPost(View v){
        OkGo.<String>post( "https://www.baidu.com/s" )
                .params( "ie","utf-8" )
                .params( "wd","okhttp" )
                .execute( new StringCallback() {
                    @Override

                    public void onSuccess(Response<String> response) {
                        Toast.makeText( OkGoActivity.this,response.body(),Toast.LENGTH_SHORT ).show();
                    }
                } );
    }

    public void goDownload(View v){
        OkGo.<File>get("https://www.apk8.com/game/downs_az_222_53642.html")
                .execute( new FileCallback() {
                    @Override
                    public void downloadProgress(Progress progress) {
                        super.downloadProgress( progress );
                        tv_okgo.setText( "进度：" + progress.currentSize + "/" + progress.totalSize );
                        long rate = (progress.currentSize * 100) / progress.totalSize;
                        pb_okgo.setProgress( (int)rate );
                    }

                    @Override
                    public void onSuccess(Response<File> response) {
                        Toast.makeText( OkGoActivity.this,"下载成功",Toast.LENGTH_SHORT ).show();
                    }
                } );
    }
}
