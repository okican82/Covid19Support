package com.okayyildirim.covid19support.Base;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.okayyildirim.covid19support.R;

public abstract class BaseAppCompatActivity extends AppCompatActivity
{
    private ProgressDialog prg;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutResourceId());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setToolbarNavigationButtonEnable(true);
    }

    public void setToolbarNavigationButtonEnable(boolean enabled)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
        getSupportActionBar().setDisplayShowHomeEnabled(enabled);
    }

    protected abstract int getLayoutResourceId();

    public void showLoading() {
        try {
            if (prg == null) {
                prg = new ProgressDialog(this);
                prg.setMessage(getString(R.string.please_wait));
                prg.setCancelable(false);
                prg.setIndeterminate(true);
            }
            if (!prg.isShowing())
                prg.show();
        } catch (Exception e) {

        }
    }


    public void hideLoading() {
        if (prg != null)
            if (prg.isShowing())
                prg.dismiss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }




}