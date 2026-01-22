package com.ruffian.library.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import mc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private c f١٣٤٨٠a;

    public RTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c cVar = this.f١٣٤٨٠a;
        if (cVar != null) {
            cVar.G();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar = this.f١٣٤٨٠a;
        if (cVar != null) {
            cVar.P(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        c cVar = this.f١٣٤٨٠a;
        if (cVar != null) {
            cVar.S(z10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        c cVar = this.f١٣٤٨٠a;
        if (cVar != null) {
            cVar.a0(z10);
        }
        super.setSelected(z10);
    }

    public RTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٨٠a = new c(context, this, attributeSet);
    }

    public c getHelper() {
        return this.f١٣٤٨٠a;
    }
}
