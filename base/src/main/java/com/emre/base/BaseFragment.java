package com.emre.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

abstract class BaseFragment extends Fragment implements BaseInterface {

    private Context context;
    private ProgressPanel progressPanel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        progressPanel = new ProgressPanel(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initUI();
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    //region Navigation
    protected void startActivity(Class<?> cls) {
        startActivity(getIntent(cls));
    }

    protected void startActivity(Class<?> cls, int flags) {
        startActivity(getIntent(cls, flags));
    }

    protected void startActivityWithFinish(Class<?> cls) {
        startActivity(cls);
        finish();
    }

    protected void startActivityWithFinish(Class<?> cls, int flags) {
        startActivity(cls, flags);
        finish();
    }

    protected void finish() {
        getActivity().finish();
    }
    //endregion

    protected Intent getIntent() {
        return getActivity().getIntent();
    }

    protected Intent getIntent(Class<?> cls) {
        return new Intent(context, cls);
    }

    protected Intent getIntent(Class<?> cls, int flags) {
        Intent intent = getIntent(cls);
        intent.setFlags(flags);
        return intent;
    }

    public void startShake(View v, @StringRes int resId) {
        startShake(v);
        showToast(resId);
    }

    public void startShake(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake));
    }

    protected void showToast(@StringRes int resId) {
        if (resId != -1)
            ToastUtils.showToast(context, resId);
    }

    protected void showLongToast(@StringRes int resId) {
        if (resId != -1)
            ToastUtils.showToast(context, resId, Toast.LENGTH_LONG);
    }

    protected void showToast(CharSequence text) {
        ToastUtils.showToast(context, text);
    }

    protected void showLongToast(CharSequence text) {
        ToastUtils.showToast(context, text, Toast.LENGTH_LONG);
    }

    @Override
    public void onError() {
        progressPanel.showProgress(false,"Error");
    }

    @Override
    public void onProgress(int progress) {
        if (progress == 0)
            progressPanel.showProgress("plane",null);
        else
            progressPanel.showProgress("standard",null);
    }

    @Override
    public void onProgress(int progress, String Color) {
        if (progress == 0)
            progressPanel.showProgress("plane",Color);
        else
            progressPanel.showProgress("standard",Color);
    }

    @Override
    public void onError(String error) {
        progressPanel.showProgress(false, error);
    }

    @Override
    public void hideProgress() {
        progressPanel.hideProgress();
    }

    public abstract int getFragmentLayout();
}
