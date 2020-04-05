package com.okayyildirim.covid19support.CaseDetail;


import android.os.Bundle;

import com.okayyildirim.covid19support.Base.BaseAppCompatActivity;
import com.okayyildirim.covid19support.R;

public class CaseDetailActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_detail);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_case_detail;
    }
}
