package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;
import r6.o;
import r6.q;
import r6.r;
import s6.g;
import t6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TimeWheelLayout extends BaseWheelLayout {

    /* renamed from: b, reason: collision with root package name */
    private NumberWheelView f٨٠١٦b;

    /* renamed from: c, reason: collision with root package name */
    private NumberWheelView f٨٠١٧c;

    /* renamed from: d, reason: collision with root package name */
    private NumberWheelView f٨٠١٨d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f٨٠١٩e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f٨٠٢٠f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f٨٠٢١g;

    /* renamed from: h, reason: collision with root package name */
    private WheelView f٨٠٢٢h;

    /* renamed from: i, reason: collision with root package name */
    private g f٨٠٢٣i;

    /* renamed from: j, reason: collision with root package name */
    private g f٨٠٢٤j;

    /* renamed from: k, reason: collision with root package name */
    private g f٨٠٢٥k;

    /* renamed from: l, reason: collision with root package name */
    private Integer f٨٠٢٦l;

    /* renamed from: m, reason: collision with root package name */
    private Integer f٨٠٢٧m;

    /* renamed from: n, reason: collision with root package name */
    private Integer f٨٠٢٨n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٨٠٢٩o;

    /* renamed from: p, reason: collision with root package name */
    private int f٨٠٣٠p;

    /* renamed from: q, reason: collision with root package name */
    private int f٨٠٣١q;

    /* renamed from: r, reason: collision with root package name */
    private int f٨٠٣٢r;

    /* renamed from: s, reason: collision with root package name */
    private int f٨٠٣٣s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٠٣٤t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f٨٠٣٥a;

        a(r rVar) {
            this.f٨٠٣٥a = rVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٨٠٣٥a.b(((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f٨٠٣٧a;

        b(r rVar) {
            this.f٨٠٣٧a = rVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٨٠٣٧a.a(((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f٨٠٣٩a;

        c(r rVar) {
            this.f٨٠٣٩a = rVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٨٠٣٩a.c(((Integer) obj).intValue());
        }
    }

    public TimeWheelLayout(Context context) {
        super(context);
        this.f٨٠٣١q = 1;
        this.f٨٠٣٢r = 1;
        this.f٨٠٣٣s = 1;
        this.f٨٠٣٤t = true;
    }

    private void k() {
        String str;
        WheelView wheelView = this.f٨٠٢٢h;
        if (this.f٨٠٢٩o) {
            str = "AM";
        } else {
            str = "PM";
        }
        wheelView.setDefaultValue(str);
    }

    private void l() {
        int i10;
        int min = Math.min(this.f٨٠٢٣i.a(), this.f٨٠٢٤j.a());
        int max = Math.max(this.f٨٠٢٣i.a(), this.f٨٠٢٤j.a());
        boolean p10 = p();
        if (p()) {
            i10 = 12;
        } else {
            i10 = 23;
        }
        int max2 = Math.max(p10 ? 1 : 0, min);
        int min2 = Math.min(i10, max);
        Integer num = this.f٨٠٢٦l;
        if (num == null) {
            this.f٨٠٢٦l = Integer.valueOf(max2);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), max2));
            this.f٨٠٢٦l = valueOf;
            this.f٨٠٢٦l = Integer.valueOf(Math.min(valueOf.intValue(), min2));
        }
        this.f٨٠١٦b.M(max2, min2, this.f٨٠٣١q);
        this.f٨٠١٦b.setDefaultValue(this.f٨٠٢٦l);
        m(this.f٨٠٢٦l.intValue());
    }

    private void m(int i10) {
        int i11;
        int b10;
        if (i10 == this.f٨٠٢٣i.a() && i10 == this.f٨٠٢٤j.a()) {
            i11 = this.f٨٠٢٣i.b();
            b10 = this.f٨٠٢٤j.b();
        } else {
            if (i10 == this.f٨٠٢٣i.a()) {
                i11 = this.f٨٠٢٣i.b();
            } else if (i10 == this.f٨٠٢٤j.a()) {
                b10 = this.f٨٠٢٤j.b();
                i11 = 0;
            } else {
                i11 = 0;
            }
            b10 = 59;
        }
        Integer num = this.f٨٠٢٧m;
        if (num == null) {
            this.f٨٠٢٧m = Integer.valueOf(i11);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), i11));
            this.f٨٠٢٧m = valueOf;
            this.f٨٠٢٧m = Integer.valueOf(Math.min(valueOf.intValue(), b10));
        }
        this.f٨٠١٧c.M(i11, b10, this.f٨٠٣٢r);
        this.f٨٠١٧c.setDefaultValue(this.f٨٠٢٧m);
        n();
    }

    private void n() {
        if (this.f٨٠٢٨n == null) {
            this.f٨٠٢٨n = 0;
        }
        this.f٨٠١٨d.M(0, 59, this.f٨٠٣٣s);
        this.f٨٠١٨d.setDefaultValue(this.f٨٠٢٨n);
    }

    private int o(int i10) {
        if (p()) {
            if (i10 == 0) {
                i10 = 24;
            }
            if (i10 > 12) {
                return i10 - 12;
            }
            return i10;
        }
        return i10;
    }

    private void s() {
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void b(WheelView wheelView, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        int id = wheelView.getId();
        boolean z13 = false;
        if (id == R.id.wheel_picker_time_hour_wheel) {
            NumberWheelView numberWheelView = this.f٨٠١٧c;
            if (i10 == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            numberWheelView.setEnabled(z12);
            NumberWheelView numberWheelView2 = this.f٨٠١٨d;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView2.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_time_minute_wheel) {
            NumberWheelView numberWheelView3 = this.f٨٠١٦b;
            if (i10 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            numberWheelView3.setEnabled(z11);
            NumberWheelView numberWheelView4 = this.f٨٠١٨d;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView4.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_time_second_wheel) {
            NumberWheelView numberWheelView5 = this.f٨٠١٦b;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            numberWheelView5.setEnabled(z10);
            NumberWheelView numberWheelView6 = this.f٨٠١٧c;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView6.setEnabled(z13);
        }
    }

    @Override // u6.a
    public void d(WheelView wheelView, int i10) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_time_hour_wheel) {
            Integer num = (Integer) this.f٨٠١٦b.w(i10);
            this.f٨٠٢٦l = num;
            if (this.f٨٠٣٤t) {
                this.f٨٠٢٧m = null;
                this.f٨٠٢٨n = null;
            }
            m(num.intValue());
            s();
            return;
        }
        if (id == R.id.wheel_picker_time_minute_wheel) {
            this.f٨٠٢٧m = (Integer) this.f٨٠١٧c.w(i10);
            if (this.f٨٠٣٤t) {
                this.f٨٠٢٨n = null;
            }
            n();
            s();
            return;
        }
        if (id == R.id.wheel_picker_time_second_wheel) {
            this.f٨٠٢٨n = (Integer) this.f٨٠١٨d.w(i10);
            s();
        } else if (id == R.id.wheel_picker_time_meridiem_wheel) {
            this.f٨٠٢٩o = "AM".equalsIgnoreCase((String) this.f٨٠٢٢h.w(i10));
            s();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TimeWheelLayout);
        setTimeMode(obtainStyledAttributes.getInt(R.styleable.TimeWheelLayout_wheel_timeMode, 0));
        String string = obtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_hourLabel);
        String string2 = obtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_minuteLabel);
        String string3 = obtainStyledAttributes.getString(R.styleable.TimeWheelLayout_wheel_secondLabel);
        obtainStyledAttributes.recycle();
        r(string, string2, string3);
        setTimeFormatter(new d(this));
    }

    public final g getEndValue() {
        return this.f٨٠٢٤j;
    }

    public final TextView getHourLabelView() {
        return this.f٨٠١٩e;
    }

    public final NumberWheelView getHourWheelView() {
        return this.f٨٠١٦b;
    }

    @Deprecated
    public final TextView getMeridiemLabelView() {
        throw new UnsupportedOperationException("Use getMeridiemWheelView instead");
    }

    public final WheelView getMeridiemWheelView() {
        return this.f٨٠٢٢h;
    }

    public final TextView getMinuteLabelView() {
        return this.f٨٠٢٠f;
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.f٨٠١٧c;
    }

    public final TextView getSecondLabelView() {
        return this.f٨٠٢١g;
    }

    public final NumberWheelView getSecondWheelView() {
        return this.f٨٠١٨d;
    }

    public final int getSelectedHour() {
        return o(((Integer) this.f٨٠١٦b.getCurrentItem()).intValue());
    }

    public final int getSelectedMinute() {
        return ((Integer) this.f٨٠١٧c.getCurrentItem()).intValue();
    }

    public final int getSelectedSecond() {
        int i10 = this.f٨٠٣٠p;
        if (i10 != 2 && i10 != 0) {
            return ((Integer) this.f٨٠١٨d.getCurrentItem()).intValue();
        }
        return 0;
    }

    public final g getStartValue() {
        return this.f٨٠٢٣i;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void h(Context context) {
        this.f٨٠١٦b = (NumberWheelView) findViewById(R.id.wheel_picker_time_hour_wheel);
        this.f٨٠١٧c = (NumberWheelView) findViewById(R.id.wheel_picker_time_minute_wheel);
        this.f٨٠١٨d = (NumberWheelView) findViewById(R.id.wheel_picker_time_second_wheel);
        this.f٨٠١٩e = (TextView) findViewById(R.id.wheel_picker_time_hour_label);
        this.f٨٠٢٠f = (TextView) findViewById(R.id.wheel_picker_time_minute_label);
        this.f٨٠٢١g = (TextView) findViewById(R.id.wheel_picker_time_second_label);
        this.f٨٠٢٢h = (WheelView) findViewById(R.id.wheel_picker_time_meridiem_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int i() {
        return R.layout.wheel_picker_time;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public List j() {
        return Arrays.asList(this.f٨٠١٦b, this.f٨٠١٧c, this.f٨٠١٨d, this.f٨٠٢٢h);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 && this.f٨٠٢٣i == null && this.f٨٠٢٤j == null) {
            q(g.h(0, 0, 0), g.h(23, 59, 59), g.d());
        }
    }

    public boolean p() {
        int i10 = this.f٨٠٣٠p;
        if (i10 != 2 && i10 != 3) {
            return false;
        }
        return true;
    }

    public void q(g gVar, g gVar2, g gVar3) {
        int i10;
        boolean z10 = false;
        if (gVar == null) {
            gVar = g.h(p() ? 1 : 0, 0, 0);
        }
        if (gVar2 == null) {
            if (p()) {
                i10 = 12;
            } else {
                i10 = 23;
            }
            gVar2 = g.h(i10, 59, 59);
        }
        if (gVar2.j() >= gVar.j()) {
            this.f٨٠٢٣i = gVar;
            this.f٨٠٢٤j = gVar2;
            if (gVar3 == null) {
                gVar3 = gVar;
            }
            this.f٨٠٢٥k = gVar3;
            if (gVar3.a() < 12 || gVar3.a() == 24) {
                z10 = true;
            }
            this.f٨٠٢٩o = z10;
            this.f٨٠٢٦l = Integer.valueOf(o(gVar3.a()));
            this.f٨٠٢٧m = Integer.valueOf(gVar3.b());
            this.f٨٠٢٨n = Integer.valueOf(gVar3.c());
            l();
            k();
            return;
        }
        throw new IllegalArgumentException("Ensure the start time is less than the time date");
    }

    public void r(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f٨٠١٩e.setText(charSequence);
        this.f٨٠٢٠f.setText(charSequence2);
        this.f٨٠٢١g.setText(charSequence3);
    }

    public void setDefaultValue(g gVar) {
        q(this.f٨٠٢٣i, this.f٨٠٢٤j, gVar);
    }

    public void setResetWhenLinkage(boolean z10) {
        this.f٨٠٣٤t = z10;
    }

    public void setTimeFormatter(r rVar) {
        if (rVar == null) {
            return;
        }
        this.f٨٠١٦b.setFormatter(new a(rVar));
        this.f٨٠١٧c.setFormatter(new b(rVar));
        this.f٨٠١٨d.setFormatter(new c(rVar));
    }

    public void setTimeMode(int i10) {
        this.f٨٠٣٠p = i10;
        this.f٨٠١٦b.setVisibility(0);
        this.f٨٠١٩e.setVisibility(0);
        this.f٨٠١٧c.setVisibility(0);
        this.f٨٠٢٠f.setVisibility(0);
        this.f٨٠١٨d.setVisibility(0);
        this.f٨٠٢١g.setVisibility(0);
        this.f٨٠٢٢h.setVisibility(8);
        if (i10 == -1) {
            this.f٨٠١٦b.setVisibility(8);
            this.f٨٠١٩e.setVisibility(8);
            this.f٨٠١٧c.setVisibility(8);
            this.f٨٠٢٠f.setVisibility(8);
            this.f٨٠١٨d.setVisibility(8);
            this.f٨٠٢١g.setVisibility(8);
            this.f٨٠٣٠p = i10;
            return;
        }
        if (i10 == 2 || i10 == 0) {
            this.f٨٠١٨d.setVisibility(8);
            this.f٨٠٢١g.setVisibility(8);
        }
        if (p()) {
            this.f٨٠٢٢h.setVisibility(0);
            this.f٨٠٢٢h.setData(Arrays.asList("AM", "PM"));
        }
    }

    public TimeWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٠٣١q = 1;
        this.f٨٠٣٢r = 1;
        this.f٨٠٣٣s = 1;
        this.f٨٠٣٤t = true;
    }

    public TimeWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٠٣١q = 1;
        this.f٨٠٣٢r = 1;
        this.f٨٠٣٣s = 1;
        this.f٨٠٣٤t = true;
    }

    public void setOnTimeMeridiemSelectedListener(o oVar) {
    }

    public void setOnTimeSelectedListener(q qVar) {
    }
}
