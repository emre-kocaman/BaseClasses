package com.emre.base.bases;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.emre.base.utils.BaseProgress;
import com.emre.base.R;
import com.emre.base.utils.ToastUtils;

public abstract class BaseFragment extends Fragment implements BaseInterface {

    private Context context;
    private BaseProgress progress;
    public String title;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        progress = new BaseProgress(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initUI(view);
        super.onViewCreated(view, savedInstanceState);
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return getActivity().findViewById(id);
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
    public void onProgress(int code) {
        if (code == 0){
            progress.showProgress("standard",null);
        } else {
            progress.showProgress("plane",null);
        }
    }
    @Override
    public void onProgress(int code,String color) {
        if (code == 0){
            progress.showProgress("standard",color);
        } else {
            progress.showProgress("plane",color);
        }
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

    public abstract int getFragmentLayout();
}
