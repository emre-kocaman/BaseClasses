package com.emre.base.bases;

import android.view.View;

public interface BaseInterface {

    //Beginning
    void initUI(View v);
    void initUI();

    void initData();

    void initListeners();


    //States
    void onProgress(int progress);
    void onProgress(int progress,String Color);

    void onError();

    void hideProgress();

    void onError(String error);
}
