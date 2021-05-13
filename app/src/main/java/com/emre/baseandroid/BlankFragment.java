package com.emre.baseandroid;

import android.widget.TextView;

import com.emre.base.bases.BaseFragment;


public class BlankFragment extends BaseFragment {

    private TextView tv;

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_blank;
    }

    @Override
    public void initUI() {
        tv = (TextView) findViewById(R.id.tv);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListeners() {
        tv.setOnClickListener(this::startShake);
    }
}