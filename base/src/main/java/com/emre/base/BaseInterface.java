package com.emre.base;

import android.view.View;

public interface BaseInterface {

    //Beginning
    void initUI(View v);

    //States
    void onProgress();
    void onError();
    void hideProgress();
    void onError(String error);
}
