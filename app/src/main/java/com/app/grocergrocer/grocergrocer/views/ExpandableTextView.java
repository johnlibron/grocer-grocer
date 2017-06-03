package com.app.grocergrocer.grocergrocer.views;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class ExpandableTextView {

    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {
        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
            ViewTreeObserver obs = tv.getViewTreeObserver();
            obs.removeGlobalOnLayoutListener(this);
            if (maxLine == 0) {
                int lineEndIndex = tv.getLayout().getLineEnd(0);
                String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(addClickablePartTextViewResizable(tv.getText().toString(), tv, expandText, viewMore), TextView.BufferType.SPANNABLE);
            } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(addClickablePartTextViewResizable(tv.getText().toString(), tv, expandText, viewMore), TextView.BufferType.SPANNABLE);
            } else {
                int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(addClickablePartTextViewResizable(tv.getText().toString(), tv, expandText, viewMore), TextView.BufferType.SPANNABLE);
            }
            }
        });
    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final String strSpanned, final TextView tv, final String spanableText, final boolean viewMore) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);
        if (strSpanned.contains(spanableText)) {
            ssb.setSpan(new SpannableTextView() {

                @Override
                public void onClick(View widget) {
                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -3, "Read Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, "Read More", true);
                    }
                }
            }, strSpanned.indexOf(spanableText), strSpanned.indexOf(spanableText) + spanableText.length(), 0);
        }
        return ssb;
    }
}