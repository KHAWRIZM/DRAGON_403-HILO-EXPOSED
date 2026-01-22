package com.oudi.widget.text;

import android.view.View;
import java.util.Locale;
import l2.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class ViewUtils {
    public static int getViewPaddingLeft(View view) {
        boolean z10 = true;
        if (q.a(Locale.getDefault()) != 1) {
            z10 = false;
        }
        int paddingStart = view.getPaddingStart();
        int paddingEnd = view.getPaddingEnd();
        int paddingLeft = view.getPaddingLeft();
        if (z10) {
            if (paddingEnd != 0) {
                return paddingEnd;
            }
        } else if (paddingStart != 0) {
            return paddingStart;
        }
        return paddingLeft;
    }

    public static int getViewPaddingRight(View view) {
        boolean z10 = true;
        if (q.a(Locale.getDefault()) != 1) {
            z10 = false;
        }
        int paddingStart = view.getPaddingStart();
        int paddingEnd = view.getPaddingEnd();
        int paddingRight = view.getPaddingRight();
        if (z10) {
            if (paddingStart != 0) {
                return paddingStart;
            }
        } else if (paddingEnd != 0) {
            return paddingEnd;
        }
        return paddingRight;
    }
}
