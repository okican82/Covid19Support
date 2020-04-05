package com.okayyildirim.covid19support.UserInfoDetail;

import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.R;

public class UserInfoDetailActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_detail);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_user_info_detail;
    }
}
