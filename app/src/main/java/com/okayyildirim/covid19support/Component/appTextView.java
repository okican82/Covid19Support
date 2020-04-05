package com.okayyildirim.covid19support.Component;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.okayyildirim.covid19support.Utils.FontUtil;

public class appTextView extends TextView
{
    public appTextView(Context context) {
        super(context);
        this.setTypeface(getTypeFace(context));
    }

    public appTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(getTypeFace(context));
    }

    public appTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(getTypeFace(context));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public appTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTypeface(getTypeFace(context));
    }



    public Typeface getTypeFace(Context context) {
        return FontUtil.getInstance().getTypeFace(context);

    }


}
