package com.test.my.samplebinding.viewmodel;

import android.app.ProgressDialog;
import android.content.Context;

import com.test.my.samplebinding.R;

/**
 * Created by Android-dev on 22.08.2016.
 */
public class BaseProgressViewModel<T extends BaseViewModelInterface> extends BaseViewModel<T>{
    static ProgressDialog progress;

    public void showProgress() {
        Context context = view.getContext();
        if (progress == null) {
            progress = ProgressDialog.show(context, "", context.getString(R.string.loading));
        } else {
            progress.show();
        }
    }

    public void hideProgress() {
        if (progress != null) {
            progress.dismiss();
            progress = null;
        }
    }
}
