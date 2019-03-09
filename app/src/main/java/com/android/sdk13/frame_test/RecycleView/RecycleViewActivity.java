package com.android.sdk13.frame_test.RecycleView;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.sdk13.frame_test.R;
import com.android.sdk13.frame_test.RecycleView.Adapter.RecycleViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_view)
    RecyclerView rvView;

    private ArrayList<String> data;
    RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recycle_view );
        ButterKnife.bind( this );
        initData();
        adapter = new RecycleViewAdapter( this,data );
        rvView.setAdapter( adapter );
        rvView.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false ) );
    }

    public void help(View v){
       new AlertDialog.Builder(this)
               .setTitle( "RecycleView的一些操作" )
               .setMessage( "比ListView好使一点哦" )
               .setPositiveButton( "确认",null )
               .show();
    }

    private void initData() {
        data = new ArrayList<>();
        for(int i = 1; i<=100 ; i++){
            data.add("第"+i+"号数据");
        }
    }

    public void rv_add(View v) {
        adapter.addItem( 0,"1234" );
        rvView.scrollToPosition( 0 );
    }

    public void rv_del(View v) {
        adapter.removeItem( 0 );
    }

    public void rv_list(View v) {
        rvView.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false ) );
    }

    public void rv_grid(View v) {
        rvView.setLayoutManager(new GridLayoutManager( this,3,GridLayoutManager.VERTICAL,false ) );
    }

    public void rv_flow(View v) {
        rvView.setLayoutManager(new StaggeredGridLayoutManager( 3,StaggeredGridLayoutManager.VERTICAL ) ) ;
    }

}
