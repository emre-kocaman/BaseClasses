package com.emre.base.bases;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.emre.base.utils.BaseProgress;
import com.emre.base.R;
import com.emre.base.utils.ToastUtils;

public abstract class BaseActivity extends AppCompatActivity implements BaseInterface {

    private BaseProgress progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        progress = new BaseProgress(getContext());
        initUI();
        initData();
    }

    public <T extends View> T findView(@IdRes int id) {
        return findViewById(id);
    }

    protected Context getContext() {
        return this;
    }

    protected Intent getIntent(Class<?> cls) {
        return new Intent(getContext(), cls);
    }

    protected Intent getIntent(Class<?> cls, int flags) {
        Intent intent = getIntent(cls);
        intent.setFlags(flags);
        return intent;
    }

    protected void startActivity(Class<?> cls) {
        startActivity(getIntent(cls));
    }

    protected void startActivity(Class<?> cls, int flags) {
        startActivity(getIntent(cls, flags));
    }

    protected void startActivityWithFinish(Class<?> cls) {
        startActivity(getIntent(cls));
        finish();
    }

    protected void startActivityWithFinish(Class<?> cls, int flags) {
        startActivity(getIntent(cls, flags));
        finish();
    }

    public void startShake(View v, @StringRes int resId) {
        startShake(v);
        showToast(resId);
    }

    public void startShake(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.shake));
    }

    protected void showToast(@StringRes int resId) {
        if (resId != -1)
            ToastUtils.showToast(getContext(), resId);
    }

    protected void showLongToast(@StringRes int resId) {
        if (resId != -1)
            ToastUtils.showToast(getContext(), resId, Toast.LENGTH_LONG);
    }

    protected void showToast(CharSequence text) {
        ToastUtils.showToast(getContext(), text);
    }

    protected void showLongToast(CharSequence text) {
        ToastUtils.showToast(getContext(), text, Toast.LENGTH_LONG);
    }

    @Override
    public void onProgress() {
        progress.showProgress();
    }

    @Override
    public void onError(String error) {
        progress.showProgress(false, error);
    }

    @Override
    public void onError() {
        progress.showProgress(false, getString(R.string.somethingWentWrong));
    }

    @Override
    public void hideProgress() {
        progress.hideProgress();
    }


    public abstract int getActivityLayoutId();


}
