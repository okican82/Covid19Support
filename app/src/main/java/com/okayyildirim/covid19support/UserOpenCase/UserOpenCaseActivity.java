package com.okayyildirim.covid19support.UserOpenCase;

import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.R;

public class UserOpenCaseActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_open_case);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_user_open_case;
    }
}
