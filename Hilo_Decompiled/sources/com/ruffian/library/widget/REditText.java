package com.ruffian.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import mc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class REditText extends AppCompatEditText {

    /* renamed from: a, reason: collision with root package name */
    private c f١٣٤٦٢a;

    public REditText(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar = this.f١٣٤٦٢a;
        if (cVar != null) {
            cVar.P(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        c cVar = this.f١٣٤٦٢a;
        if (cVar != null) {
            cVar.S(z10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        c cVar = this.f١٣٤٦٢a;
        if (cVar != null) {
            cVar.a0(z10);
        }
        super.setSelected(z10);
    }

    public REditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٦٢a = new c(context, this, attributeSet);
    }

    public c getHelper() {
        return this.f١٣٤٦٢a;
    }
}
