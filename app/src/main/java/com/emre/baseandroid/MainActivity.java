package com.emre.baseandroid;

import android.view.View;
import android.widget.TextView;

import com.emre.base.bases.BaseActivity;
import com.emre.base.bases.BaseRecyclerViewAdapter;
import com.emre.base.bases.BaseViewHolder;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TextView tv;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        tv = findView(R.id.tv);
        tv.setOnClickListener(this::startShake);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListeners() {

    }

}