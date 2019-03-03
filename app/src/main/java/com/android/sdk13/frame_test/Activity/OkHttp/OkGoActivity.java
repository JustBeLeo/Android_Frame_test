package com.android.sdk13.frame_test.Activity.OkHttp;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sdk13.frame_test.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class OkGoActivity extends AppCompatActivity {

    ProgressBar pb_okgo;
    TextView tv_okgo;
    ImageView iv_okgo_bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ok_go );
        initView();

    }

    private void initView() {
        pb_okgo = findViewById( R.id.pb_okgo );
        tv_okgo = findViewById( R.id.tv_okgo );
        iv_okgo_bitmap = findViewById( R.id.iv_okgo_bitmap );
        tv_okgo.setText( "进度：" );
        pb_okgo.setMax( 100 );
    }

    public void help(View v){
        new AlertDialog.Builder(this)
                .setTitle( "OkGo的常用功能" )
                .setMessage( "基本的get、post、put、delete、head、options、trace、patch八种请求\n" +
                        "支持upString，upJson，upBytes，upFile等up类方法上传特定数据\n" +
                        "支持一个key上传一个文件，也可以一个key上传多个文件，也可以多文件和多参数一起上传\n" +
                        "大文件下载和下载进度回调\n" +
                        "大文件上传和上传进度回调\n" +
                        "支持cookie的自动管理，并可自定义cookie管理策略\n" +
                        "支持缓存模式，不仅支持http缓存协议，也支持自定义缓存策略\n" +
                        "支持重定向\n" +
                        "支持自定义超时自动重连次数\n" +
                        "支持链式调用\n" +
                        "支持https访问，支持双向认证\n" +
                        "支持根据tag取消请求，也可全部取消\n" +
                        "支持自定义Callback，自动解析网络数据" )
                .setPositiveButton( "确认",null )
                .show();
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
        OkGo.<File>get("http://192.168.43.10:8080/FileUpload/index.jsp")
                .execute( new FileCallback() {
                    @Override
                    public void onStart(Request<File, ? extends Request> request) {
                        super.onStart( request );
                        pb_okgo.setProgress( 0 );
                    }

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

    public void goUpload(View v){
        File file = new File( Environment.getExternalStorageDirectory(),"text.txt" );
        Map<String ,String> map = new HashMap<>();
        map.put( "username","Leo" );
        map.put( "password","123" );
        OkGo.<File>post( "http://192.168.43.10:8080/FileUpload/FileUploadServlet")
                .params( "file1",file,"text.txt" )
                .params( map )
                .isSpliceUrl(true)
                .execute( new FileCallback(){
                    @Override
                    public void onStart(Request<File, ? extends Request> request) {
                        super.onStart( request );
                        pb_okgo.setProgress( 0 );
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress( progress );
                        tv_okgo.setText( "进度：" + progress.currentSize + "/" + progress.totalSize );
                        long rate = (progress.currentSize * 100) / progress.totalSize;
                        pb_okgo.setProgress( (int)rate );
                    }

                    @Override
                    public void onSuccess(Response<File> response) {
                        Toast.makeText( OkGoActivity.this,"上传成功",Toast.LENGTH_SHORT ).show();
                    }
                } );
    }

    public void goGetBitMap(View v){
        OkGo.<Bitmap>get("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551594182906&di=8b1ff30de36464ff57322e4391773289&imgtype=0&src=http%3A%2F%2Fpic31.photophoto.cn%2F20140514%2F0011024384333682_b.jpg")
                .execute( new BitmapCallback() {
                    @Override
                    public void onStart(Request<Bitmap, ? extends Request> request) {
                        super.onStart( request );
                        iv_okgo_bitmap.setImageBitmap( null );
                        pb_okgo.setProgress( 0 );
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        super.downloadProgress( progress );
                        tv_okgo.setText( "进度：" + progress.currentSize + "/" + progress.totalSize );
                        long rate = (progress.currentSize * 100) / progress.totalSize;
                        pb_okgo.setProgress( (int)rate );
                    }

                    @Override
                    public void onSuccess(Response<Bitmap> response) {
                        iv_okgo_bitmap.setImageBitmap( response.body() );
                    }
                } );
    }
}
