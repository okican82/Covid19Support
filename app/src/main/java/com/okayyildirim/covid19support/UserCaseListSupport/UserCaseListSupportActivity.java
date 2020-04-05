package com.okayyildirim.covid19support.UserCaseListSupport;

import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.R;

public class UserCaseListSupportActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_case_list_support);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_user_case_list_support;
    }
}
