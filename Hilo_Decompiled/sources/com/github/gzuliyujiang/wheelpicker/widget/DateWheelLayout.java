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
import r6.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DateWheelLayout extends BaseWheelLayout {

    /* renamed from: b, reason: collision with root package name */
    private NumberWheelView f٧٩٧٨b;

    /* renamed from: c, reason: collision with root package name */
    private NumberWheelView f٧٩٧٩c;

    /* renamed from: d, reason: collision with root package name */
    private NumberWheelView f٧٩٨٠d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f٧٩٨١e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f٧٩٨٢f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f٧٩٨٣g;

    /* renamed from: h, reason: collision with root package name */
    private s6.b f٧٩٨٤h;

    /* renamed from: i, reason: collision with root package name */
    private s6.b f٧٩٨٥i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f٧٩٨٦j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f٧٩٨٧k;

    /* renamed from: l, reason: collision with root package name */
    private Integer f٧٩٨٨l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٧٩٨٩m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r6.a f٧٩٩٠a;

        a(r6.a aVar) {
            this.f٧٩٩٠a = aVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٧٩٩٠a.c(((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r6.a f٧٩٩٢a;

        b(r6.a aVar) {
            this.f٧٩٩٢a = aVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٧٩٩٢a.a(((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements u6.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r6.a f٧٩٩٤a;

        c(r6.a aVar) {
            this.f٧٩٩٤a = aVar;
        }

        @Override // u6.c
        public String a(Object obj) {
            return this.f٧٩٩٤a.b(((Integer) obj).intValue());
        }
    }

    public DateWheelLayout(Context context) {
        super(context);
        this.f٧٩٨٩m = true;
    }

    private void k(int i10, int i11) {
        int o10;
        int i12;
        if (i10 == this.f٧٩٨٤h.c() && i11 == this.f٧٩٨٤h.b() && i10 == this.f٧٩٨٥i.c() && i11 == this.f٧٩٨٥i.b()) {
            i12 = this.f٧٩٨٤h.a();
            o10 = this.f٧٩٨٥i.a();
        } else if (i10 == this.f٧٩٨٤h.c() && i11 == this.f٧٩٨٤h.b()) {
            int a10 = this.f٧٩٨٤h.a();
            o10 = o(i10, i11);
            i12 = a10;
        } else {
            if (i10 == this.f٧٩٨٥i.c() && i11 == this.f٧٩٨٥i.b()) {
                o10 = this.f٧٩٨٥i.a();
            } else {
                o10 = o(i10, i11);
            }
            i12 = 1;
        }
        Integer num = this.f٧٩٨٨l;
        if (num == null) {
            this.f٧٩٨٨l = Integer.valueOf(i12);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), i12));
            this.f٧٩٨٨l = valueOf;
            this.f٧٩٨٨l = Integer.valueOf(Math.min(valueOf.intValue(), o10));
        }
        this.f٧٩٨٠d.M(i12, o10, 1);
        this.f٧٩٨٠d.setDefaultValue(this.f٧٩٨٨l);
    }

    private void l(int i10) {
        int i11;
        int i12;
        if (this.f٧٩٨٤h.c() == this.f٧٩٨٥i.c()) {
            i12 = Math.min(this.f٧٩٨٤h.b(), this.f٧٩٨٥i.b());
            i11 = Math.max(this.f٧٩٨٤h.b(), this.f٧٩٨٥i.b());
        } else {
            i11 = 12;
            if (i10 == this.f٧٩٨٤h.c()) {
                i12 = this.f٧٩٨٤h.b();
            } else {
                if (i10 == this.f٧٩٨٥i.c()) {
                    i11 = this.f٧٩٨٥i.b();
                }
                i12 = 1;
            }
        }
        Integer num = this.f٧٩٨٧k;
        if (num == null) {
            this.f٧٩٨٧k = Integer.valueOf(i12);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), i12));
            this.f٧٩٨٧k = valueOf;
            this.f٧٩٨٧k = Integer.valueOf(Math.min(valueOf.intValue(), i11));
        }
        this.f٧٩٧٩c.M(i12, i11, 1);
        this.f٧٩٧٩c.setDefaultValue(this.f٧٩٨٧k);
        k(i10, this.f٧٩٨٧k.intValue());
    }

    private void m() {
        int min = Math.min(this.f٧٩٨٤h.c(), this.f٧٩٨٥i.c());
        int max = Math.max(this.f٧٩٨٤h.c(), this.f٧٩٨٥i.c());
        Integer num = this.f٧٩٨٦j;
        if (num == null) {
            this.f٧٩٨٦j = Integer.valueOf(min);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), min));
            this.f٧٩٨٦j = valueOf;
            this.f٧٩٨٦j = Integer.valueOf(Math.min(valueOf.intValue(), max));
        }
        this.f٧٩٧٨b.M(min, max, 1);
        this.f٧٩٧٨b.setDefaultValue(this.f٧٩٨٦j);
        l(this.f٧٩٨٦j.intValue());
    }

    private void n() {
    }

    private int o(int i10, int i11) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3 && i11 != 5 && i11 != 10 && i11 != 12 && i11 != 7 && i11 != 8) {
                    return 30;
                }
                return 31;
            }
            if (i10 <= 0) {
                return 29;
            }
            if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0) {
                return 29;
            }
            return 28;
        }
        return 31;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void b(WheelView wheelView, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        int id = wheelView.getId();
        boolean z13 = false;
        if (id == R.id.wheel_picker_date_year_wheel) {
            NumberWheelView numberWheelView = this.f٧٩٧٩c;
            if (i10 == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            numberWheelView.setEnabled(z12);
            NumberWheelView numberWheelView2 = this.f٧٩٨٠d;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView2.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_date_month_wheel) {
            NumberWheelView numberWheelView3 = this.f٧٩٧٨b;
            if (i10 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            numberWheelView3.setEnabled(z11);
            NumberWheelView numberWheelView4 = this.f٧٩٨٠d;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView4.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_date_day_wheel) {
            NumberWheelView numberWheelView5 = this.f٧٩٧٨b;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            numberWheelView5.setEnabled(z10);
            NumberWheelView numberWheelView6 = this.f٧٩٧٩c;
            if (i10 == 0) {
                z13 = true;
            }
            numberWheelView6.setEnabled(z13);
        }
    }

    @Override // u6.a
    public void d(WheelView wheelView, int i10) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            Integer num = (Integer) this.f٧٩٧٨b.w(i10);
            this.f٧٩٨٦j = num;
            if (this.f٧٩٨٩m) {
                this.f٧٩٨٧k = null;
                this.f٧٩٨٨l = null;
            }
            l(num.intValue());
            n();
            return;
        }
        if (id == R.id.wheel_picker_date_month_wheel) {
            this.f٧٩٨٧k = (Integer) this.f٧٩٧٩c.w(i10);
            if (this.f٧٩٨٩m) {
                this.f٧٩٨٨l = null;
            }
            k(this.f٧٩٨٦j.intValue(), this.f٧٩٨٧k.intValue());
            n();
            return;
        }
        if (id == R.id.wheel_picker_date_day_wheel) {
            this.f٧٩٨٨l = (Integer) this.f٧٩٨٠d.w(i10);
            n();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DateWheelLayout);
        setDateMode(obtainStyledAttributes.getInt(R.styleable.DateWheelLayout_wheel_dateMode, 0));
        String string = obtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_yearLabel);
        String string2 = obtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_monthLabel);
        String string3 = obtainStyledAttributes.getString(R.styleable.DateWheelLayout_wheel_dayLabel);
        obtainStyledAttributes.recycle();
        p(string, string2, string3);
        setDateFormatter(new t6.c());
    }

    public final TextView getDayLabelView() {
        return this.f٧٩٨٣g;
    }

    public final NumberWheelView getDayWheelView() {
        return this.f٧٩٨٠d;
    }

    public final s6.b getEndValue() {
        return this.f٧٩٨٥i;
    }

    public final TextView getMonthLabelView() {
        return this.f٧٩٨٢f;
    }

    public final NumberWheelView getMonthWheelView() {
        return this.f٧٩٧٩c;
    }

    public final int getSelectedDay() {
        return ((Integer) this.f٧٩٨٠d.getCurrentItem()).intValue();
    }

    public final int getSelectedMonth() {
        return ((Integer) this.f٧٩٧٩c.getCurrentItem()).intValue();
    }

    public final int getSelectedYear() {
        return ((Integer) this.f٧٩٧٨b.getCurrentItem()).intValue();
    }

    public final s6.b getStartValue() {
        return this.f٧٩٨٤h;
    }

    public final TextView getYearLabelView() {
        return this.f٧٩٨١e;
    }

    public final NumberWheelView getYearWheelView() {
        return this.f٧٩٧٨b;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void h(Context context) {
        this.f٧٩٧٨b = (NumberWheelView) findViewById(R.id.wheel_picker_date_year_wheel);
        this.f٧٩٧٩c = (NumberWheelView) findViewById(R.id.wheel_picker_date_month_wheel);
        this.f٧٩٨٠d = (NumberWheelView) findViewById(R.id.wheel_picker_date_day_wheel);
        this.f٧٩٨١e = (TextView) findViewById(R.id.wheel_picker_date_year_label);
        this.f٧٩٨٢f = (TextView) findViewById(R.id.wheel_picker_date_month_label);
        this.f٧٩٨٣g = (TextView) findViewById(R.id.wheel_picker_date_day_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int i() {
        return R.layout.wheel_picker_date;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public List j() {
        return Arrays.asList(this.f٧٩٧٨b, this.f٧٩٧٩c, this.f٧٩٨٠d);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 && this.f٧٩٨٤h == null && this.f٧٩٨٥i == null) {
            q(s6.b.j(), s6.b.k(30), s6.b.j());
        }
    }

    public void p(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f٧٩٨١e.setText(charSequence);
        this.f٧٩٨٢f.setText(charSequence2);
        this.f٧٩٨٣g.setText(charSequence3);
    }

    public void q(s6.b bVar, s6.b bVar2, s6.b bVar3) {
        if (bVar == null) {
            bVar = s6.b.j();
        }
        if (bVar2 == null) {
            bVar2 = s6.b.k(30);
        }
        if (bVar2.i() >= bVar.i()) {
            this.f٧٩٨٤h = bVar;
            this.f٧٩٨٥i = bVar2;
            if (bVar3 != null) {
                this.f٧٩٨٦j = Integer.valueOf(bVar3.c());
                this.f٧٩٨٧k = Integer.valueOf(bVar3.b());
                this.f٧٩٨٨l = Integer.valueOf(bVar3.a());
            } else {
                this.f٧٩٨٦j = null;
                this.f٧٩٨٧k = null;
                this.f٧٩٨٨l = null;
            }
            m();
            return;
        }
        throw new IllegalArgumentException("Ensure the start date is less than the end date");
    }

    public void setDateFormatter(r6.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f٧٩٧٨b.setFormatter(new a(aVar));
        this.f٧٩٧٩c.setFormatter(new b(aVar));
        this.f٧٩٨٠d.setFormatter(new c(aVar));
    }

    public void setDateMode(int i10) {
        this.f٧٩٧٨b.setVisibility(0);
        this.f٧٩٨١e.setVisibility(0);
        this.f٧٩٧٩c.setVisibility(0);
        this.f٧٩٨٢f.setVisibility(0);
        this.f٧٩٨٠d.setVisibility(0);
        this.f٧٩٨٣g.setVisibility(0);
        if (i10 == -1) {
            this.f٧٩٧٨b.setVisibility(8);
            this.f٧٩٨١e.setVisibility(8);
            this.f٧٩٧٩c.setVisibility(8);
            this.f٧٩٨٢f.setVisibility(8);
            this.f٧٩٨٠d.setVisibility(8);
            this.f٧٩٨٣g.setVisibility(8);
            return;
        }
        if (i10 == 2) {
            this.f٧٩٧٨b.setVisibility(8);
            this.f٧٩٨١e.setVisibility(8);
        } else if (i10 == 1) {
            this.f٧٩٨٠d.setVisibility(8);
            this.f٧٩٨٣g.setVisibility(8);
        }
    }

    public void setDefaultValue(s6.b bVar) {
        q(this.f٧٩٨٤h, this.f٧٩٨٥i, bVar);
    }

    public void setResetWhenLinkage(boolean z10) {
        this.f٧٩٨٩m = z10;
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٧٩٨٩m = true;
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٩٨٩m = true;
    }

    public void setOnDateSelectedListener(e eVar) {
    }
}
