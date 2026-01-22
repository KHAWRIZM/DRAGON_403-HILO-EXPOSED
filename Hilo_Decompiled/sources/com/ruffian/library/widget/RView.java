package com.ruffian.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import mc.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RView extends View {

    /* renamed from: a, reason: collision with root package name */
    private a f١٣٤٨١a;

    public RView(Context context) {
        this(context, null);
    }

    public a getHelper() {
        return this.f١٣٤٨١a;
    }

    public RView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٤٨١a = new a(context, this, attributeSet);
    }
}
