package com.ruffian.library.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatRadioButton;
import mc.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RRadioButton extends AppCompatRadioButton {

    /* renamed from: e, reason: collision with root package name */
    private b f١٣٤٧٨e;

    public RRadioButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.f١٣٤٧٨e;
        if (bVar != null) {
            bVar.G();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar = this.f١٣٤٧٨e;
        if (bVar != null) {
            bVar.P(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        b bVar = this.f١٣٤٧٨e;
        if (bVar != null) {
            bVar.Q(z10);
        }
        super.setChecked(z10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        b bVar = this.f١٣٤٧٨e;
        if (bVar != null) {
            bVar.S(z10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        b bVar = this.f١٣٤٧٨e;
        if (bVar != null) {
            bVar.a0(z10);
        }
        super.setSelected(z10);
    }

    public RRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٧٨e = new b(context, this, attributeSet);
    }

    public b getHelper() {
        return this.f١٣٤٧٨e;
    }
}
