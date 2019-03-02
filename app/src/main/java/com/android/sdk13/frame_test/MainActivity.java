package com.android.sdk13.frame_test;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.android.sdk13.frame_test.Base.BaseFragment;
import com.android.sdk13.frame_test.Fragment.CommonFrameFragment;
import com.android.sdk13.frame_test.Fragment.CustomFragment;
import com.android.sdk13.frame_test.Fragment.OtherFragment;
import com.android.sdk13.frame_test.Fragment.ThirdPartyFragment;
import com.android.sdk13.frame_test.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    RadioGroup rg_main;
    List<BaseFragment> mBaseFragment;
    public int positon;
    BaseFragment fragment;
    FragmentManager fm;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        setListener();
        getPermission();
    }

    private void getPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add( new CommonFrameFragment() );
        mBaseFragment.add( new ThirdPartyFragment() );
        mBaseFragment.add(new CustomFragment() );
        mBaseFragment.add(new OtherFragment() );

        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        for(int i=0;i<=3;i++){
            transaction.add(R.id.fl_main_content, mBaseFragment.get(i) );
            transaction.hide( mBaseFragment.get(i) );
        }
        transaction.show( mBaseFragment.get(0) );
        transaction.commit();
    }

    private void initView() {
        setContentView( R.layout.activity_main );
        rg_main = findViewById( R.id.rg_main );
        rg_main.check( R.id.rb_main_frame );
    }

    private void setListener() {
        rg_main.setOnCheckedChangeListener( new MyOnCheckedChangeListener() );
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_main_frame:
                    positon = 0;
                    break;
                case R.id.rb_main_tpos:
                    positon = 1;
                    break;
                case R.id.rb_main_custom:
                    positon = 2;
                    break;
                case R.id.rb_main_other:
                    positon = 3;
                    break;
            }
            switchFragment();
        }
    }
    public void switchFragment(){
        transaction = fm.beginTransaction();
        for(int i=0;i<=3;i++)
            if(mBaseFragment.get(i)!=null)
                transaction.hide( mBaseFragment.get(i) );
        transaction.show( mBaseFragment.get(positon) );
        transaction.commit();
    }


}
