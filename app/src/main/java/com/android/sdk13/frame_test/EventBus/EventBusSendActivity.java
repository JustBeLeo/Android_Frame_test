package com.android.sdk13.frame_test.EventBus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.sdk13.frame_test.EventBus.Event.MessageEvent;
import com.android.sdk13.frame_test.EventBus.Event.StickcyMessage;
import com.android.sdk13.frame_test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusSendActivity extends AppCompatActivity {

    TextView tv_eventbus_send;
    EditText view;
    boolean firstFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_event_bus_send );
        tv_eventbus_send = findViewById( R.id.tv_eventbus_send );


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


    public void send_event(View v){
        view = new EditText( this );
        new AlertDialog.Builder( this )
                .setTitle( "请输入你要发送的消息" )
                .setView( view )
                .setPositiveButton( "确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EventBus.getDefault().post( new MessageEvent( view.getText().toString() ) );
                    }
                } )
                .setNegativeButton( "取消",null )
                .show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void recieveStickyMessage(StickcyMessage event){
        tv_eventbus_send.setText( event.getName() + ":" + event.getPassword() );
    }

    public void receive_sticky_events(View v){
        if(firstFlag){
            EventBus.getDefault().register( this );
            firstFlag = false;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister( this );
    }
}
