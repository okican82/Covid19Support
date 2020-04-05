package com.okayyildirim.covid19support.SingUp;

import javax.inject.Inject;

public class SingUpPresenterImpl implements SingUpPresenter,onSingUpFinishedListener {


    @Inject
    SingUpInteractor SingUpInteractor;

    @Inject
    SingUpView SingUpView;

    @Inject
    SingUpPresenterImpl(SingUpInteractor SingUpInteractor,SingUpView SingUpView)
    {
        this.SingUpInteractor = SingUpInteractor;
        this.SingUpView = SingUpView;
    }


    @Override
    public void singUpUser(String username, String password) {
        if(SingUpView != null)
        {
            SingUpView.showLoading();
        }

        if (username != null && !username.isEmpty())
        {
            if(password != null && !password.isEmpty())
            {
                SingUpInteractor.SingUp(username,password,this,SingUpView);
            }
            else
            {
                onPassworError();
            }
        }
        else
        {
            onUsernameError();
        }

    }


    @Override
    public void onDestroy() {
        SingUpView = null;
    }



    @Override
    public void onSuccess() {
        if(SingUpView != null)
        {
            SingUpView.hideLoading();
            SingUpView.navigateToLogin();
        }
    }

    @Override
    public void onError(String ErrorMessage) {
        SingUpView.hideLoading();
        SingUpView.onError(ErrorMessage);
    }

    private void onUsernameError()
    {
        SingUpView.hideLoading();
        SingUpView.setPasswordError();
    }

    private void onPassworError()
    {
        SingUpView.hideLoading();
        SingUpView.setPasswordError();
    }
}
