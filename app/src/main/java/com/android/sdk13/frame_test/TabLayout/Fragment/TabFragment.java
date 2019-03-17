package com.android.sdk13.frame_test.TabLayout.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class TabFragment extends Fragment {
    TextView view;
    Context context;
    String title;
    String content;

    public String getTitle() {
        return title;
    }

    public TabFragment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        context = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = new TextView( context );
        view.setGravity( Gravity.CENTER );
        view.setTextColor( Color.RED );
        view.setTextSize( 15 );
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        view.setText( content );
    }
}
