package com.okayyildirim.covid19support.Splash;

import javax.inject.Inject;

public class SplashPresenterImpl implements SplashPresenter,onSplashAuthListener {

    @Inject
    SplashInteractor splashInteractor;
    @Inject SplashView splashView;

    @Inject
    SplashPresenterImpl(SplashInteractor splashInteractor, SplashView splashView) {
        this.splashInteractor = splashInteractor;
        this.splashView = splashView;
    }


    @Override
    public void onDestroy() {
        this.splashView = null;
    }

    @Override
    public void getAuthListener() {
        if (splashView != null) {
            splashView.showLoading();
        }
        splashInteractor.authListener(this);
    }


    @Override
    public void onSuccess() {
        if (splashView != null) {

            splashView.hideLoading();
            splashView.navigateToMain();
        }
    }

    @Override
    public void onError() {
        if (splashView != null) {

            splashView.hideLoading();
            splashView.navigateToLogin();
        }
    }
}
