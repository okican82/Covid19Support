package com.okayyildirim.covid19support.SingUp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.Login.LoginActivity;
import com.okayyildirim.covid19support.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingUpActivity extends BaseAppCompatActivity implements SingUpView {


    @BindView(R.id.singin_button)
    Button singin_button;

    @BindView(R.id.user_name_txt)
    EditText user_name_txt;

    @BindView(R.id.user_pass_txt)
    EditText user_pass_txt;

    @Inject
    SingUpPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        initAppData();

        ButterKnife.bind(this);

        setTitle(getApplicationContext().getResources().getString(R.string.sing_in));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_sing_up;
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
    public void initAppData() {
        DaggerSingUpComponent.builder().singUpModule(new SingUpModule(this)).build().inject(this);
    }

    @Override
    public void navigateToLogin() {
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
    }



    @Override
    public void onError(String erroMessage) {
        switch (erroMessage) {

            case "ERROR_INVALID_CUSTOM_TOKEN":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_INVALID_CUSTOM_TOKEN), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_CUSTOM_TOKEN_MISMATCH":
                Toast.makeText(SingUpActivity.this,getString(R.string.ERROR_CUSTOM_TOKEN_MISMATCH) , Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_CREDENTIAL":
                Toast.makeText(SingUpActivity.this,getString(R.string.ERROR_INVALID_CREDENTIAL) , Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_EMAIL":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_INVALID_EMAIL), Toast.LENGTH_LONG).show();
                user_name_txt.setError(getString(R.string.ERROR_INVALID_EMAIL));
                user_name_txt.requestFocus();
                break;

            case "ERROR_WRONG_PASSWORD":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_WRONG_PASSWORD), Toast.LENGTH_LONG).show();
                user_pass_txt.setError("password is incorrect ");
                user_pass_txt.requestFocus();
                user_pass_txt.setText("");
                break;

            case "ERROR_USER_MISMATCH":
                Toast.makeText(SingUpActivity.this,getString(R.string.ERROR_USER_MISMATCH) , Toast.LENGTH_LONG).show();
                break;

            case "ERROR_REQUIRES_RECENT_LOGIN":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_REQUIRES_RECENT_LOGIN), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_EMAIL_ALREADY_IN_USE), Toast.LENGTH_LONG).show();
                user_name_txt.setError(getString(R.string.ERROR_EMAIL_ALREADY_IN_USE));
                user_name_txt.requestFocus();
                break;

            case "ERROR_CREDENTIAL_ALREADY_IN_USE":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_CREDENTIAL_ALREADY_IN_USE), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_DISABLED":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_USER_DISABLED), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_TOKEN_EXPIRED":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_USER_TOKEN_EXPIRED), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_USER_NOT_FOUND), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_USER_TOKEN":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_INVALID_USER_TOKEN), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_OPERATION_NOT_ALLOWED":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_OPERATION_NOT_ALLOWED), Toast.LENGTH_LONG).show();
                break;

            case "ERROR_WEAK_PASSWORD":
                Toast.makeText(SingUpActivity.this, getString(R.string.ERROR_WEAK_PASSWORD), Toast.LENGTH_LONG).show();
                user_pass_txt.setError(getString(R.string.ERROR_WEAK_PASSWORD_DESCRIPTION));
                user_pass_txt.requestFocus();
                break;

        }
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    public void singUpUser(String username, String password) {

        presenter.singUpUser(username,password);
    }

    @OnClick(R.id.singin_button)
    void singinButtonClicked(){
        singUpUser(user_name_txt.getText().toString().trim(), user_pass_txt.getText().toString().trim());
    }
}
