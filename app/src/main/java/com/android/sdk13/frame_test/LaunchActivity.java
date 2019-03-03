package com.android.sdk13.frame_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 第一个参数是需要添加的新的窗口属性的标志位（相当于值）
        // 第二个 参数是窗口的哪一个特性标志位需要修改（相当于开关）
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_launch );
        //建一个Handler 利用他的postDelayed方法延迟启动主界面
        new Handler(  ).postDelayed( new Runnable() {
            @Override
            public void run() {
                //在主线程运行
                startActivity( new Intent( LaunchActivity.this, MainActivity.class ));
                finish();
            }
        },1500);
    }
    public void start(){
        ;
    }
}
