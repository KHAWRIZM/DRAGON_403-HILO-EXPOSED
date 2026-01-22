package com.qiahao.nextvideo.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.Locale;
import l2.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RTLLayoutManager extends GridLayoutManager {
    public RTLLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected boolean isLayoutRTL() {
        if (q.a(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }
}
