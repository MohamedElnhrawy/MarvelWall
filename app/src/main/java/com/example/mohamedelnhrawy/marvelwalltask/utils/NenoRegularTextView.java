package com.example.mohamedelnhrawy.marvelwalltask.utils;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class NenoRegularTextView extends TextView
{

    public NenoRegularTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }
    public NenoRegularTextView(Context context)
    {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }

    public NenoRegularTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }


    @Override
    protected void onDraw (Canvas canvas)
    {
        super.onDraw(canvas);
    }
}
