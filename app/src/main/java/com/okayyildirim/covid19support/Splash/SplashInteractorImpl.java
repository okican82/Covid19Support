package com.okayyildirim.covid19support.Splash;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class SplashInteractorImpl implements SplashInteractor {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    public void authListener(final onSplashAuthListener listener)
    {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            // User is signed in
            Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            //saveUser();
            listener.onSuccess();
        } else {
            listener.onError();
        }
    }
}
