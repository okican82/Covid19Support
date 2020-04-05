package com.okayyildirim.covid19support.Splash;

import com.okayyildirim.covid19support.Base.BaseView;

public interface SplashView extends BaseView {
    void showLoading();
    void hideLoading();
    void navigateToMain();
    void navigateToLogin();

}
