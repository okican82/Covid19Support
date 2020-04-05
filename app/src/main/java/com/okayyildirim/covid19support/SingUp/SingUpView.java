package com.okayyildirim.covid19support.SingUp;

import com.okayyildirim.covid19support.Base.BaseView;

public interface SingUpView extends BaseView {
    void setUserNameError();
    void setPasswordError();
    void initAppData();
    void navigateToLogin();

    void onError(String erroMessage);

}
