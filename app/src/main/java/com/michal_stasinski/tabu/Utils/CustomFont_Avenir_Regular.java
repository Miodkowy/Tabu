package com.michal_stasinski.tabu.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by win8 on 04.01.2017.
 */

public class CustomFont_Avenir_Regular extends android.support.v7.widget.AppCompatTextView {

    public CustomFont_Avenir_Regular(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/Avenir Next Condensed.ttc"));
        this.setTypeface(Typeface.DEFAULT,0);
    }


}