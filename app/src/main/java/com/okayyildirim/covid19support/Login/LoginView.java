package com.okayyildirim.covid19support.Login;

import com.okayyildirim.covid19support.Base.BaseView;

public interface LoginView extends BaseView {
    void setError(String errorMessage);
    void setUserNameError();
    void setPasswordError();
    void navigateToMain();
    void navigateToForgetPassword();
    void loginUser(String username, String password);



}
