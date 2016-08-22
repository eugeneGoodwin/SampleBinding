package com.test.my.samplebinding.viewmodel;

public abstract class BaseViewModel<T extends BaseViewModelInterface> {

    protected T view;

    public final void attachView(T t) {
        this.view = t;
    }

    public final void detachView() {
        view = null;
    }
}
