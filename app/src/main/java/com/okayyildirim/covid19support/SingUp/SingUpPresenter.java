package com.okayyildirim.covid19support.SingUp;

public interface SingUpPresenter {
    void singUpUser(String username, String password);
    void onDestroy();
}
