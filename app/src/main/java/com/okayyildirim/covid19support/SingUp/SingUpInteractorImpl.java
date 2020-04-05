package com.okayyildirim.covid19support.SingUp;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import javax.inject.Inject;

public class SingUpInteractorImpl implements SingUpInteractor {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Inject
    SingUpInteractorImpl(){}


    @Override
    public void SingUp(final String userName, final String password, final onSingUpFinishedListener listener, final SingUpView singUpView) {
        auth.createUserWithEmailAndPassword(userName,password).addOnCompleteListener((Activity) singUpView, task ->{
            if(task.isSuccessful())
            {
                listener.onSuccess();
            }
            else
            {
                listener.onError(((FirebaseAuthException) task.getException()).getErrorCode());
            }
        });


    }
}
