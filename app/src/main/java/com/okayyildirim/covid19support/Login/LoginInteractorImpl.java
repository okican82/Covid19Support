package com.okayyildirim.covid19support.Login;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginInteractorImpl implements LoginInteractor {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener, final LoginView view) {
        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener((Activity) view, task -> {
            if (!task.isSuccessful()) {

                listener.onError(task.getException().getLocalizedMessage());
            } else {
                listener.onSuccess();
            }
        });
    }
}
