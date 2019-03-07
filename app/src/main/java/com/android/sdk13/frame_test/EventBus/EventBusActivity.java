package com.android.sdk13.frame_test.EventBus;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.sdk13.frame_test.EventBus.Event.MessageEvent;
import com.android.sdk13.frame_test.EventBus.Event.StickcyMessage;
import com.android.sdk13.frame_test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {

    TextView tv_eventbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_event_bus );
        tv_eventbus = findViewById( R.id.tv_eventbus );
        //1、注册
        EventBus.getDefault().register( this );
        //2、构造发送消息类

        //3、发送消息
    }

    public void help(View v) {
        new AlertDialog.Builder( this )
                .setTitle( "EventBus" )
                .setMessage( "简介：" +
                        "\nEventBus是一个Android端优化的publish/subscribe消息总线," +
                        "简化了应用程序内各组件间、组件与后台线程间的通信。" +
                        "\n功能:" +
                        "\n1.请求网络，等网络返回时通过Handler或Broadcast通知UI。" +
                        "\n2.两个Fragment之间需要通过Listener通信。" )
                .setPositiveButton( "确认", null )
                .show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(MessageEvent message){
        //接收传来的消息
        tv_eventbus.setText( message.getName() );
    }

    //跳转到发送页面
    public void goto_send_activity(View v){
        startActivity( new Intent( this,EventBusSendActivity.class ) );
    }

    //发送粘性事件再跳转到发送页面
    public void send_sticky_events(View v){
        EventBus.getDefault().postSticky( new StickcyMessage( "feiwu" ,123456) );
        startActivity( new Intent( this,EventBusSendActivity.class ) );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解注册
        EventBus.getDefault().unregister( this );
    }
}
