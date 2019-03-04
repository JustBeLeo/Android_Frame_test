package com.android.sdk13.frame_test.Json;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.sdk13.frame_test.Json.Info.Film;
import com.android.sdk13.frame_test.Json.Info.Person;
import com.android.sdk13.frame_test.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class GsonActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_gson_from)
    TextView tv_gson_from;
    @ViewInject(R.id.tv_gson_to)
    TextView tv_gson_to;
    Film f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_gson );
        initView();
    }

    private void initView() {
        x.view().inject( this );
        tv_gson_from.setMovementMethod( ScrollingMovementMethod.getInstance() );
        tv_gson_to.setMovementMethod( ScrollingMovementMethod.getInstance() );

    }

    public void help(View v) {
        new AlertDialog.Builder( this )
                .setTitle( "Gson的常用功能" )
                .setMessage( "看下面吧" )
                .setPositiveButton( "确认", null )
                .show();
    }

    //json对象装换成java对象
    public void gson1(View v) {
        tv_gson_from.setText( " " );
        tv_gson_to.setText( " " );
        String str = "{\n" +
                "id: 73917,\n" +
                "movieName: \"新版《地狱男爵》剧场预告\",\n" +
                "coverImg: \"http://img5.mtime.cn/mg/2019/03/01/141330.12746212_120X90X4.jpg\",\n" +
                "movieId: 247677,\n" +
                "url: \"http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4\",\n" +
                "hightUrl: \"http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4\",\n" +
                "videoTitle: \"地狱男爵：血皇后崛起 中文剧场版预告\",\n" +
                "videoLength: 160,\n" +
                "rating: -1,\n" +
                "type: [\n" +
                "\"动作\",\n" +
                "\"冒险\",\n" +
                "\"奇幻\",\n" +
                "\"科幻\"\n" +
                "],\n" +
                "summary: \"血皇后等怪物轮番登场\"\n" +
                "}";
        tv_gson_from.setText( str );
        f1 = Film.objectFromData( str );
        tv_gson_to.setText( f1.toString() );
    }

    //json数组转换成java数组
    public void gson2(View v) {
        tv_gson_from.setText( " " );
        tv_gson_to.setText( " " );
        String str = "[\n" +
                "{\n" +
                "id: 73917,\n" +
                "movieName: \"新版《地狱男爵》剧场预告\",\n" +
                "coverImg: \"http://img5.mtime.cn/mg/2019/03/01/141330.12746212_120X90X4.jpg\",\n" +
                "movieId: 247677,\n" +
                "url: \"http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4\",\n" +
                "hightUrl: \"http://vfx.mtime.cn/Video/2019/03/01/mp4/190301141332024373.mp4\",\n" +
                "videoTitle: \"地狱男爵：血皇后崛起 中文剧场版预告\",\n" +
                "videoLength: 160,\n" +
                "rating: -1,\n" +
                "type: [\n" +
                "\"动作\",\n" +
                "\"冒险\",\n" +
                "\"奇幻\",\n" +
                "\"科幻\"\n" +
                "],\n" +
                "summary: \"血皇后等怪物轮番登场\"\n" +
                "},\n" +
                "{\n" +
                "id: 73909,\n" +
                "movieName: \"《X战警：黑凤凰》中文正式预告\",\n" +
                "coverImg: \"http://img5.mtime.cn/mg/2019/02/28/134619.57373676_120X90X4.jpg\",\n" +
                "movieId: 241485,\n" +
                "url: \"http://vfx.mtime.cn/Video/2019/02/28/mp4/190228134803297354.mp4\",\n" +
                "hightUrl: \"http://vfx.mtime.cn/Video/2019/02/28/mp4/190228134803297354.mp4\",\n" +
                "videoTitle: \"X战警：黑凤凰 正式中文预告\",\n" +
                "videoLength: 143,\n" +
                "rating: -1,\n" +
                "type: [\n" +
                "\"动作\",\n" +
                "\"冒险\",\n" +
                "\"科幻\"\n" +
                "],\n" +
                "summary: \"黑凤凰觉醒危机重重\"\n" +
                "}" + "]\n";
        List<Film> films = Film.arrayFilmFromData( str );
        tv_gson_from.setText( str );
        tv_gson_to.setText( films.get( 0 ).toString() + "\n" + films.get( 1 ).toString() );
    }

    public void gson3(View v) {
        tv_gson_from.setText( " " );
        tv_gson_to.setText( " " );
        Person person = new Person( 1, "Leo" );
        String str = new Gson().toJson( person );
        tv_gson_from.setText( person.toString() );
        tv_gson_to.setText( str );
    }

    public void gson4(View v) {
        tv_gson_from.setText( " " );
        tv_gson_to.setText( " " );
        Person p1 = new Person( 1, "Leo" );
        Person p2 = new Person( 2, "Leo2" );
        Person p3 = new Person( 3, "Leo3" );
        List<Person> list = new ArrayList<>();
        list.add( p1 );
        list.add( p2 );
        list.add( p3 );
        tv_gson_from.setText( list.toString() );
        String str = new Gson().toJson( list, new TypeToken<ArrayList<Person>>(){}.getType() );
        tv_gson_to.setText( str );
    }
}
