package com.okayyildirim.covid19support.Component;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.okayyildirim.covid19support.Utils.FontUtil;

public class appButton extends Button
{
    public appButton(Context context) {
        super(context);
        this.setTypeface(getTypeFace(context));
    }

    public appButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(getTypeFace(context));
    }

    public appButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(getTypeFace(context));
    }

    public Typeface getTypeFace(Context context) {
        return FontUtil.getInstance().getTypeFace(context);
    }
}