package com.okayyildirim.covid19support.Login;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener {
    @Inject
    LoginInteractor loginInteractor;
    @Inject LoginView loginView;

    @Inject
    LoginPresenterImpl(LoginInteractor loginInteractor, LoginView loginView) {
        this.loginInteractor = loginInteractor;
        this.loginView = loginView;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showLoading();
        }

        if(username != null && !username.isEmpty()){
            if(password != null && !password.isEmpty()){
                loginInteractor.login(username, password, this, loginView);
            } else
            {
                onPasswordError();
            }
        } else
        {
            onUsernameError();
        }
    }


    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideLoading();
        }
    }


    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideLoading();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {

            loginView.hideLoading();
            loginView.navigateToMain();
        }
    }

    @Override
    public void onError(String errorMessage) {
        if (loginView != null) {
            loginView.setError(errorMessage);
            loginView.hideLoading();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
