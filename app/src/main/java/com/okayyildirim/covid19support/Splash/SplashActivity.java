package com.okayyildirim.covid19support.Splash;

import android.content.Intent;
import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseActivity;
import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.Login.LoginActivity;
import com.okayyildirim.covid19support.Main.MainActivity;
import com.okayyildirim.covid19support.R;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView{

    @Inject
    SplashPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initAppData();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUserLogin();
    }

    private void initAppData()
    {
        DaggerSplashComponent.builder().splashModule(new SplashModule(this)).build().inject(this);
        // loginViewModule(new LoginViewModule(this)).build().inject(this);
    }

    public void checkUserLogin() {
        presenter.getAuthListener();


    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(getBaseContext(), MainActivity.class));

    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
    }
}
