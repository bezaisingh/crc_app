package com.example.crc_rajnandangaon;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class HindiTextView extends androidx.appcompat.widget.AppCompatTextView {
    public HindiTextView(Context context) {
        super(context);
        initTypeFace(context);
    }

    public HindiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeFace(context);
    }

    public HindiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeFace(context);
    }
    private void initTypeFace(Context context){
        Typeface typeface= Typeface.createFromAsset(context.getAssets(), "NotoSansDevanagari-Regular.ttf");
        this.setTypeface(typeface);
    }
}
