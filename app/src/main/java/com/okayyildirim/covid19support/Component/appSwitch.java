package com.okayyildirim.covid19support.Component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Switch;

import com.okayyildirim.covid19support.Utils.FontUtil;

public class appSwitch extends Switch {


    public appSwitch(Context context) {
        super(context);
        this.setTypeface(getTypeFace(context));
    }

    public appSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(getTypeFace(context));
    }

    public appSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(getTypeFace(context));
    }

    public appSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTypeface(getTypeFace(context));
    }

    public Typeface getTypeFace(Context context) {
        return FontUtil.getInstance().getTypeFace(context);
    }
}
