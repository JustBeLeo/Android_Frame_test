package com.android.sdk13.frame_test.Json;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.sdk13.frame_test.Json.Info.Person;
import com.android.sdk13.frame_test.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class FastJsonActivity extends AppCompatActivity {

    @ViewInject( R.id.tv_fast_json_from )
    TextView tv_fast_json_from;
    @ViewInject( R.id.tv_fast_json_to )
    TextView tv_fast_json_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fast_json );
        initView();
    }

    public void help(View v) {
        new AlertDialog.Builder( this )
                .setTitle( "FastJson的常用功能" )
                .setMessage( "看下面吧" )
                .setPositiveButton( "确认", null )
                .show();
    }

    private void initView() {
        x.view().inject( this );
        tv_fast_json_from.setMovementMethod( ScrollingMovementMethod.getInstance() );
        tv_fast_json_to.setMovementMethod( ScrollingMovementMethod.getInstance() );
    }

    private void clearText() {
        tv_fast_json_from.setText( "" );
        tv_fast_json_to.setText( "" );
    }

    //json2java
    public void fastjson1(View v){
        clearText();
        String json = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Leo\"\n" +
                "}";
        tv_fast_json_from.setText( json );
        Person p1 = JSON.parseObject( json,Person.class );
        tv_fast_json_to.setText( p1.toString() );
    }

    //jsons2javas
    public void fastjson2(View v){
        clearText();
        String json = "[{\n" +
                "\t\"id\": 1,\n" +
                "\t\"name\": \"Leo\"\n" +
                "}, {\n" +
                "\t\"id\": 2,\n" +
                "\t\"name\": \"Leo2\"\n" +
                "}]";
        List<Person> list = JSONArray.parseArray( json,Person.class );
        tv_fast_json_from.setText( json );
        tv_fast_json_to.setText( list.toString() );
    }

    //java2json
    public void fastjson3(View v){
        Person p1 = new Person( 1,"LL" );
        String str = JSON.toJSONString( p1 );
        tv_fast_json_from.setText( p1.toString() );
        tv_fast_json_to.setText( str );
    }

    //javas2jsons
    public void fastjson4(View v){
        clearText();
        Person p1 = new Person( 1, "asd" );
        Person p2 = new Person( 2, "qwe" );
        Person p3 = new Person( 3, "zxc" );
        List<Person> list = new ArrayList<>();
        list.add( p1 );
        list.add( p2 );
        list.add( p3 );
        tv_fast_json_from.setText( list.toString() );
        String json = JSON.toJSONString( list );
        tv_fast_json_to.setText( json );
    }
}
