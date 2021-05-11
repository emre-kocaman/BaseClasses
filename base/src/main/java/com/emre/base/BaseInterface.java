package com.emre.base;

public interface BaseInterface {

    //Beginning
    void initUI();

    //States
    void onProgress();
    void onError();
    void hideProgress();
    void onError(String error);
}
