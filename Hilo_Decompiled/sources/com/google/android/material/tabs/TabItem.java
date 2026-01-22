package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.p0;
import com.google.android.material.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TabItem extends View {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f١٠٠١٩a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f١٠٠٢٠b;

    /* renamed from: c, reason: collision with root package name */
    public final int f١٠٠٢١c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p0 u10 = p0.u(context, attributeSet, R.styleable.TabItem);
        this.f١٠٠١٩a = u10.p(R.styleable.TabItem_android_text);
        this.f١٠٠٢٠b = u10.g(R.styleable.TabItem_android_icon);
        this.f١٠٠٢١c = u10.n(R.styleable.TabItem_android_layout, 0);
        u10.x();
    }
}
