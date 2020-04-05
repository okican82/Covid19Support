package com.okayyildirim.covid19support.Login;

public interface OnLoginFinishedListener {
    void onSuccess();
    void onError(String errorMessage);
}
