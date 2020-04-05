package com.okayyildirim.covid19support.SingUp;

public interface SingUpInteractor {
    void SingUp(String userName, String password, onSingUpFinishedListener listener, SingUpView singInView);
}
