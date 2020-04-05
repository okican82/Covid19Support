package com.okayyildirim.covid19support.Utils;

import android.content.Context;
import android.graphics.Typeface;

public class FontUtil {

    private static FontUtil fontUtilInstance = null;

    public synchronized static FontUtil getInstance()
    {
        if(fontUtilInstance == null)
        {
            fontUtilInstance = new FontUtil();
        }
        return fontUtilInstance;
    }

    public Typeface getTypeFace(Context context)
    {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Lato-Regular.ttf");
        return font;
    }
}
