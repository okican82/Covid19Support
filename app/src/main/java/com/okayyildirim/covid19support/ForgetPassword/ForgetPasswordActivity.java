package com.okayyildirim.covid19support.ForgetPassword;

import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.R;

public class ForgetPasswordActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_forget_password;
    }
}
