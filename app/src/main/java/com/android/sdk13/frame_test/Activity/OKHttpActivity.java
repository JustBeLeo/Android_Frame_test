package com.android.sdk13.frame_test.Activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.sdk13.frame_test.R;
import okhttp3.*;

import java.io.IOException;


public class OKHttpActivity extends AppCompatActivity {

    private static final int GET = 1;
    TextView tv_okhttp_text;
    Button button;
    OkHttpClient client = new OkHttpClient();
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            switch (msg.what){
                case GET:
                    tv_okhttp_text.setText( (String)msg.obj );
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_okhttp );
         tv_okhttp_text = findViewById( R.id.tv_okhttp_text );
         button = findViewById( R.id.bt_okhttp_getpost );
        //使用原生的okhttp进行各种操作
         button.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 getDataFromGet();
             }
         } );
    }

    void getDataFromGet(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = get("https://www.baidu.com/");
                    Message msg = Message.obtain();
                    msg.what = GET;
                    msg.obj = result;
                    handler.sendMessage( msg );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public String get(String url) throws IOException{
        Request request = new Request.Builder()
                .url( url )
                .build();
        Response response = client.newCall( request ).execute();
        return response.body().string();
    }

}
