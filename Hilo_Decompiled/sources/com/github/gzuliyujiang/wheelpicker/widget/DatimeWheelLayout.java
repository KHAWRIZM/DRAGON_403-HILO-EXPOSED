package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import r6.a;
import r6.g;
import r6.r;
import s6.c;
import t6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DatimeWheelLayout extends BaseWheelLayout {

    /* renamed from: b, reason: collision with root package name */
    private DateWheelLayout f٧٩٩٦b;

    /* renamed from: c, reason: collision with root package name */
    private TimeWheelLayout f٧٩٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private c f٧٩٩٨d;

    /* renamed from: e, reason: collision with root package name */
    private c f٧٩٩٩e;

    public DatimeWheelLayout(Context context) {
        super(context);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void a(WheelView wheelView) {
        this.f٧٩٩٦b.a(wheelView);
        this.f٧٩٩٧c.a(wheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void b(WheelView wheelView, int i10) {
        this.f٧٩٩٦b.b(wheelView, i10);
        this.f٧٩٩٧c.b(wheelView, i10);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void c(WheelView wheelView, int i10) {
        this.f٧٩٩٦b.c(wheelView, i10);
        this.f٧٩٩٧c.c(wheelView, i10);
    }

    @Override // u6.a
    public void d(WheelView wheelView, int i10) {
        this.f٧٩٩٦b.d(wheelView, i10);
        this.f٧٩٩٧c.d(wheelView, i10);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatimeWheelLayout);
        setDateMode(obtainStyledAttributes.getInt(R.styleable.DatimeWheelLayout_wheel_dateMode, 0));
        setTimeMode(obtainStyledAttributes.getInt(R.styleable.DatimeWheelLayout_wheel_timeMode, 0));
        k(obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_yearLabel), obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_monthLabel), obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_dayLabel));
        String string = obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_hourLabel);
        String string2 = obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_minuteLabel);
        String string3 = obtainStyledAttributes.getString(R.styleable.DatimeWheelLayout_wheel_secondLabel);
        obtainStyledAttributes.recycle();
        m(string, string2, string3);
        setDateFormatter(new t6.c());
        setTimeFormatter(new d(this.f٧٩٩٧c));
    }

    public final DateWheelLayout getDateWheelLayout() {
        return this.f٧٩٩٦b;
    }

    public final TextView getDayLabelView() {
        return this.f٧٩٩٦b.getDayLabelView();
    }

    public final NumberWheelView getDayWheelView() {
        return this.f٧٩٩٦b.getDayWheelView();
    }

    public final c getEndValue() {
        return this.f٧٩٩٩e;
    }

    public final TextView getHourLabelView() {
        return this.f٧٩٩٧c.getHourLabelView();
    }

    public final NumberWheelView getHourWheelView() {
        return this.f٧٩٩٧c.getHourWheelView();
    }

    public final WheelView getMeridiemWheelView() {
        return this.f٧٩٩٧c.getMeridiemWheelView();
    }

    public final TextView getMinuteLabelView() {
        return this.f٧٩٩٧c.getMinuteLabelView();
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.f٧٩٩٧c.getMinuteWheelView();
    }

    public final TextView getMonthLabelView() {
        return this.f٧٩٩٦b.getMonthLabelView();
    }

    public final NumberWheelView getMonthWheelView() {
        return this.f٧٩٩٦b.getMonthWheelView();
    }

    public final TextView getSecondLabelView() {
        return this.f٧٩٩٧c.getSecondLabelView();
    }

    public final NumberWheelView getSecondWheelView() {
        return this.f٧٩٩٧c.getSecondWheelView();
    }

    public final int getSelectedDay() {
        return this.f٧٩٩٦b.getSelectedDay();
    }

    public final int getSelectedHour() {
        return this.f٧٩٩٧c.getSelectedHour();
    }

    public final int getSelectedMinute() {
        return this.f٧٩٩٧c.getSelectedMinute();
    }

    public final int getSelectedMonth() {
        return this.f٧٩٩٦b.getSelectedMonth();
    }

    public final int getSelectedSecond() {
        return this.f٧٩٩٧c.getSelectedSecond();
    }

    public final int getSelectedYear() {
        return this.f٧٩٩٦b.getSelectedYear();
    }

    public final c getStartValue() {
        return this.f٧٩٩٨d;
    }

    public final TimeWheelLayout getTimeWheelLayout() {
        return this.f٧٩٩٧c;
    }

    public final TextView getYearLabelView() {
        return this.f٧٩٩٦b.getYearLabelView();
    }

    public final NumberWheelView getYearWheelView() {
        return this.f٧٩٩٦b.getYearWheelView();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void h(Context context) {
        this.f٧٩٩٦b = (DateWheelLayout) findViewById(R.id.wheel_picker_date_wheel);
        this.f٧٩٩٧c = (TimeWheelLayout) findViewById(R.id.wheel_picker_time_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int i() {
        return R.layout.wheel_picker_datime;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List j() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f٧٩٩٦b.j());
        arrayList.addAll(this.f٧٩٩٧c.j());
        return arrayList;
    }

    public void k(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f٧٩٩٦b.p(charSequence, charSequence2, charSequence3);
    }

    public void l(c cVar, c cVar2, c cVar3) {
        if (cVar == null) {
            cVar = c.c();
        }
        if (cVar2 == null) {
            cVar2 = c.f(10);
        }
        if (cVar3 == null) {
            cVar3 = cVar;
        }
        this.f٧٩٩٦b.q(cVar.a(), cVar2.a(), cVar3.a());
        this.f٧٩٩٧c.q(null, null, cVar3.b());
        this.f٧٩٩٨d = cVar;
        this.f٧٩٩٩e = cVar2;
    }

    public void m(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f٧٩٩٧c.r(charSequence, charSequence2, charSequence3);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 && this.f٧٩٩٨d == null && this.f٧٩٩٩e == null) {
            l(c.c(), c.f(30), c.c());
        }
    }

    public void setDateFormatter(a aVar) {
        this.f٧٩٩٦b.setDateFormatter(aVar);
    }

    public void setDateMode(int i10) {
        this.f٧٩٩٦b.setDateMode(i10);
    }

    public void setDefaultValue(c cVar) {
        if (cVar == null) {
            cVar = c.c();
        }
        this.f٧٩٩٦b.setDefaultValue(cVar.a());
        this.f٧٩٩٧c.setDefaultValue(cVar.b());
    }

    public void setTimeFormatter(r rVar) {
        this.f٧٩٩٧c.setTimeFormatter(rVar);
    }

    public void setTimeMode(int i10) {
        this.f٧٩٩٧c.setTimeMode(i10);
    }

    public DatimeWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DatimeWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void setOnDatimeSelectedListener(g gVar) {
    }
}
