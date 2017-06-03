package com.app.grocergrocer.grocergrocer.views;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class SpannableTextView extends ClickableSpan {

    @Override
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(true);
        textPaint.setColor(Color.parseColor("#ff5252"));
    }
}