package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.d2;
import androidx.core.view.j0;
import ic.h;
import ic.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUINotchConsumeLayout extends FrameLayout {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            QMUINotchConsumeLayout.this.a();
            return d2Var;
        }
    }

    public QMUINotchConsumeLayout(Context context) {
        this(context, null);
    }

    public boolean a() {
        setPadding(h.m(this), h.p(this), h.o(this), h.l(this));
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!h.x()) {
            a();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!h.x()) {
            a();
        }
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUINotchConsumeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        n.i(this, new a(), true);
    }
}
