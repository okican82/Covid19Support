package com.okayyildirim.covid19support.Login;

public interface LoginInteractor {
    void login(String username, String password, OnLoginFinishedListener listener, LoginView view);
}
