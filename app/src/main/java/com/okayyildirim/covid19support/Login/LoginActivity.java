package com.okayyildirim.covid19support.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.Component.appButton;
import com.okayyildirim.covid19support.Component.appEdittext;
import com.okayyildirim.covid19support.ForgetPassword.ForgetPasswordActivity;
import com.okayyildirim.covid19support.Main.MainActivity;
import com.okayyildirim.covid19support.R;
import com.okayyildirim.covid19support.SingUp.SingUpActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class LoginActivity extends BaseAppCompatActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.user_pass_txt)
    appEdittext user_pass_txt;

    @BindView(R.id.user_name_txt)
    appEdittext user_name_txt;

    @BindView(R.id.login_button)
    appButton login_button;

    @BindView(R.id.sing_in_button)
    appButton sing_in_button;

    @BindView(R.id.forget_password_button)
    appButton forget_password_button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initAppData();

        ButterKnife.bind(this);

        setTitle(getApplicationContext().getResources().getString(R.string.login));
        setToolbarNavigationButtonEnable(false);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_login;
    }

    public void initAppData() {
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
    }

    @Override
    public void setError(String errorMessage) {
        Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.login_button)
    void loginButtonClicked(){
        loginUser(user_name_txt.getText().toString().trim(), user_pass_txt.getText().toString().trim());
    }

    @OnClick(R.id.forget_password_button)
    void forgetPasswordButtonClicked(){
        navigateToForgetPassword();
    }

    @OnClick(R.id.sing_in_button)
    void singinButtonClicked(){
        openSinginActivity();
    }

    @Override
    public void setUserNameError() {
        user_name_txt.setError(getString(R.string.emailErrorValidation));
    }

    @Override
    public void setPasswordError() {
        user_pass_txt.setError(getString(R.string.passwordErrorValidation));
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(getBaseContext(), MainActivity.class));
    }

    @Override
    public void navigateToForgetPassword() {
        startActivity(new Intent(getBaseContext(), ForgetPasswordActivity.class));
    }

    @Override
    public void loginUser(String username, String password) {
        presenter.validateCredentials(username,password);
    }

    private void openSinginActivity()
    {
        Intent singinActivityIntent = new Intent(getBaseContext(), SingUpActivity.class);
        singinActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(singinActivityIntent);
    }
}
