package com.emre.baseandroid;

import android.view.View;
import android.widget.TextView;

import com.emre.base.BaseFragment;


public class BlankFragment extends BaseFragment {

    TextView tv;
    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_blank;
    }

    @Override
    public void initUI(View v) {
        tv = (TextView) findViewById(R.id.tv);



    }

    @Override
    public void onError() {

    }


}