package com.emre.base.bases;

import android.view.View;

public interface BaseInterface {

    //Beginning
    void initUI();

    void initData();

    void initListeners();


    //States
    void onProgress();

    void onError();

    void hideProgress();

    void onError(String error);
}
