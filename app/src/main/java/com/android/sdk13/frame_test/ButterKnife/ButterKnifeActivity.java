package com.android.sdk13.frame_test.ButterKnife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.sdk13.frame_test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {


    @BindView(R.id.bt_btk)
    Button show;
    @BindView(R.id.tv_btk)
    TextView tv_btk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_butter_knife );
        ButterKnife.bind( this );
        tv_btk.setMovementMethod( ScrollingMovementMethod.getInstance());
    }

    public void help(View v) {
    }

    @OnClick(R.id.bt_btk)
    public void onViewClicked() {
        tv_btk.setText( "绑定注解：\n@BindView—->绑定一个view；id为一个view 变量\n" +
                "@BindViews —-> 绑定多个view；id为一个view的list变量\n" +
                "@BindArray—-> 绑定string里面array数组；@BindArray(R.array.city ) String[] citys ;\n" +
                "@BindBitmap—->绑定图片资源为Bitmap；@BindBitmap( R.mipmap.wifi ) Bitmap bitmap;\n" +
                "@BindBool —->绑定boolean值\n" +
                "@BindColor —->绑定color；@BindColor(R.color.colorAccent) int black;\n" +
                "@BindDimen —->绑定Dimen；@BindDimen(R.dimen.borth_width) int mBorderWidth;\n" +
                "@BindDrawable —-> 绑定Drawable；@BindDrawable(R.drawable.test_pic) Drawable mTestPic;\n" +
                "@BindFloat —->绑定float\n" +
                "@BindInt —->绑定int\n" +
                "@BindString —->绑定一个String id为一个String变量；@BindString( R.string.app_name ) String meg;\n" +
                "事件注解:@OnClick—->点击事件\n" +
                "@OnCheckedChanged —->选中，取消选中\n" +
                "@OnEditorAction —->软键盘的功能键\n" +
                "@OnFocusChange —->焦点改变\n" +
                "@OnItemClick item—->被点击(注意这里有坑，如果item里面有Button等这些有点击的控件事件的，需要设置这些控件属性focusable为false)\n" +
                "@OnItemLongClick item—->长按(返回真可以拦截onItemClick)\n" +
                "@OnItemSelected —->item被选择事件\n" +
                "@OnLongClick —->长按事件\n" +
                "@OnPageChange —->页面改变事件\n" +
                "@OnTextChanged —->EditText里面的文本变化事件\n" +
                "@OnTouch —->触摸事件\n" +
                "@Optional —->选择性注入，如果当前对象不存在，就会抛出一个异常，为了压制这个异常，可以在变量或者方法上加入一下注解,让注入变成选择性的,如果目标View存在,则注入, 不存在,则什么事情都不做\n" +
                "\n" );
    }
}
