package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    final a f٨٨٦٦a;

    /* renamed from: b, reason: collision with root package name */
    final a f٨٨٦٧b;

    /* renamed from: c, reason: collision with root package name */
    final a f٨٨٦٨c;

    /* renamed from: d, reason: collision with root package name */
    final a f٨٨٦٩d;

    /* renamed from: e, reason: collision with root package name */
    final a f٨٨٧٠e;

    /* renamed from: f, reason: collision with root package name */
    final a f٨٨٧١f;

    /* renamed from: g, reason: collision with root package name */
    final a f٨٨٧٢g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f٨٨٧٣h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c8.b.f(context, R.attr.materialCalendarStyle, l.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f٨٨٦٦a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f٨٨٧٢g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f٨٨٦٧b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f٨٨٦٨c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a10 = c8.c.a(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f٨٨٦٩d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f٨٨٧٠e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f٨٨٧١f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f٨٨٧٣h = paint;
        paint.setColor(a10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
