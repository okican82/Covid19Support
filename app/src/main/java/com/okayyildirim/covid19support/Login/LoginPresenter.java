package com.okayyildirim.covid19support.Login;

public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void onDestroy();

}
