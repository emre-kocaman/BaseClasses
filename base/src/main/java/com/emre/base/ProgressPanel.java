package com.emre.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import com.airbnb.lottie.LottieAnimationView;


public class ProgressPanel {
    private final Context context;
    public Dialog dialog, dialogInfo, dialogConfirm;
    private int animation = R.raw.progress;
    private int delay = 100;
    public MutableLiveData<Boolean> doneListener = new MutableLiveData<>();
    public MutableLiveData<Boolean> confirmListener = new MutableLiveData<>();


    public ProgressPanel(Context context) {
        this.context = context;
    }

    public ProgressPanel(Context context, int animation, int delay) {
        this.context = context;
        this.animation = animation;
        this.delay = delay;
    }

    public ProgressPanel(Context context, int delay) {
        this.context = context;
        this.delay = delay;
    }

    public ProgressPanel(Fragment fragment) {
        //defaultMessage = activity.getResources().getString(R.string.default_progress_message);
        context = fragment.getActivity();
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.show();
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public void showProgress(String progress) {
        if (dialog == null) {
            dialog = new Dialog(context);
            dialog.setCancelable(false);
            View v = LayoutInflater.from(context).inflate(R.layout.fragment_lottie_dialog, null, false);

            if (progress.equals("standard")) {
                if (animation != R.raw.progress) {
                    animation = R.raw.progress;
                    LottieAnimationView animationView = v.findViewById(R.id.animationView);
                    animationView.setAnimation(animation);
                }
            } else {
                if (animation != R.raw.plane) {
                    animation = R.raw.plane;
                    LottieAnimationView animationView = v.findViewById(R.id.animationView);
                    animationView.setAnimation(animation);
                }
            }


            dialog.setContentView(v);
            dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
            dialog.show();
        } else
            dialog.show();
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public void showProgress(boolean isSuccess, String information) {
        doneListener = new MutableLiveData<>();
        if (isSuccess) {
            dialogInfo = new Dialog(context);
            dialogInfo.setCancelable(false);
            View v = LayoutInflater.from(context).inflate(R.layout.information_dialog, null, false);
            TextView textView = v.findViewById(R.id.info);
            textView.setText(information);

            TextView textViewDone = v.findViewById(R.id.done);
            textViewDone.setOnClickListener(v1 -> {
                doneListener.postValue(true);
                dialogInfo.dismiss();
            });
            dialogInfo.setContentView(v);
            dialogInfo.getWindow().setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
            dialogInfo.show();

        } else {
            dialogInfo = new Dialog(context);
            dialogInfo.setCancelable(false);
            View v = LayoutInflater.from(context).inflate(R.layout.information_dialog, null, false);
            TextView textView = v.findViewById(R.id.info);
            textView.setText(information);

            TextView textViewDone = v.findViewById(R.id.done);
            textViewDone.setOnClickListener(v1 -> {
                doneListener.postValue(true);
                dialogInfo.dismiss();
            });


            dialogInfo.setContentView(v);
            dialogInfo.getWindow().setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
            if (!dialogInfo.isShowing())
                dialogInfo.show();
        }
    }

    public void showConfirmProgress(String information, String confirmText, String cancelText) {
        confirmListener = new MutableLiveData<>();
        dialogConfirm = new Dialog(context);
        dialogConfirm.setCancelable(false);
        View v = LayoutInflater.from(context).inflate(R.layout.confirm_dialog, null, false);
        TextView textView = v.findViewById(R.id.info);
        textView.setText(information);

        TextView textViewConfirm = v.findViewById(R.id.confirm);
        textViewConfirm.setText(confirmText);
        textViewConfirm.setOnClickListener(v1 -> {
            confirmListener.postValue(true);
            dialogConfirm.dismiss();
        });

        TextView textViewCancel = v.findViewById(R.id.cancel);
        textViewCancel.setText(cancelText);
        textViewCancel.setOnClickListener(v1 -> {
            confirmListener.postValue(false);
            dialogConfirm.dismiss();
        });

        dialogConfirm.setContentView(v);
        dialogConfirm.getWindow().setBackgroundDrawable(context.getResources().getDrawable(android.R.color.transparent));
        dialogConfirm.show();
    }

    public void hideProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
