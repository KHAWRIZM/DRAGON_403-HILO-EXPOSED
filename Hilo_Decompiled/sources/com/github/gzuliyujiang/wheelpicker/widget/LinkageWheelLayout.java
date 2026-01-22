package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;
import r6.b;
import r6.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class LinkageWheelLayout extends BaseWheelLayout {

    /* renamed from: b, reason: collision with root package name */
    private WheelView f٨٠٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private WheelView f٨٠٠١c;

    /* renamed from: d, reason: collision with root package name */
    private WheelView f٨٠٠٢d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f٨٠٠٣e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f٨٠٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f٨٠٠٥g;

    /* renamed from: h, reason: collision with root package name */
    private ProgressBar f٨٠٠٦h;

    /* renamed from: i, reason: collision with root package name */
    private Object f٨٠٠٧i;

    /* renamed from: j, reason: collision with root package name */
    private Object f٨٠٠٨j;

    /* renamed from: k, reason: collision with root package name */
    private Object f٨٠٠٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f٨٠١٠l;

    /* renamed from: m, reason: collision with root package name */
    private int f٨٠١١m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨٠١٢n;

    /* renamed from: o, reason: collision with root package name */
    private b f٨٠١٣o;

    public LinkageWheelLayout(Context context) {
        super(context);
    }

    private void k() {
        this.f٨٠٠٠b.setData(this.f٨٠١٣o.e());
        this.f٨٠٠٠b.setDefaultPosition(this.f٨٠١٠l);
    }

    private void l() {
        this.f٨٠٠١c.setData(this.f٨٠١٣o.b(this.f٨٠١٠l));
        this.f٨٠٠١c.setDefaultPosition(this.f٨٠١١m);
    }

    private void m() {
        if (!this.f٨٠١٣o.f()) {
            return;
        }
        this.f٨٠٠٢d.setData(this.f٨٠١٣o.g(this.f٨٠١٠l, this.f٨٠١١m));
        this.f٨٠٠٢d.setDefaultPosition(this.f٨٠١٢n);
    }

    private void n() {
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, u6.a
    public void b(WheelView wheelView, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        int id = wheelView.getId();
        boolean z13 = false;
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            WheelView wheelView2 = this.f٨٠٠١c;
            if (i10 == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            wheelView2.setEnabled(z12);
            WheelView wheelView3 = this.f٨٠٠٢d;
            if (i10 == 0) {
                z13 = true;
            }
            wheelView3.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_linkage_second_wheel) {
            WheelView wheelView4 = this.f٨٠٠٠b;
            if (i10 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            wheelView4.setEnabled(z11);
            WheelView wheelView5 = this.f٨٠٠٢d;
            if (i10 == 0) {
                z13 = true;
            }
            wheelView5.setEnabled(z13);
            return;
        }
        if (id == R.id.wheel_picker_linkage_third_wheel) {
            WheelView wheelView6 = this.f٨٠٠٠b;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            wheelView6.setEnabled(z10);
            WheelView wheelView7 = this.f٨٠٠١c;
            if (i10 == 0) {
                z13 = true;
            }
            wheelView7.setEnabled(z13);
        }
    }

    @Override // u6.a
    public void d(WheelView wheelView, int i10) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.f٨٠١٠l = i10;
            this.f٨٠١١m = 0;
            this.f٨٠١٢n = 0;
            l();
            m();
            n();
            return;
        }
        if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.f٨٠١١m = i10;
            this.f٨٠١٢n = 0;
            m();
            n();
            return;
        }
        if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.f٨٠١٢n = i10;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinkageWheelLayout);
        setFirstVisible(obtainStyledAttributes.getBoolean(R.styleable.LinkageWheelLayout_wheel_firstVisible, true));
        setThirdVisible(obtainStyledAttributes.getBoolean(R.styleable.LinkageWheelLayout_wheel_thirdVisible, true));
        String string = obtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_firstLabel);
        String string2 = obtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_secondLabel);
        String string3 = obtainStyledAttributes.getString(R.styleable.LinkageWheelLayout_wheel_thirdLabel);
        obtainStyledAttributes.recycle();
        o(string, string2, string3);
    }

    public final TextView getFirstLabelView() {
        return this.f٨٠٠٣e;
    }

    public final WheelView getFirstWheelView() {
        return this.f٨٠٠٠b;
    }

    public final ProgressBar getLoadingView() {
        return this.f٨٠٠٦h;
    }

    public final TextView getSecondLabelView() {
        return this.f٨٠٠٤f;
    }

    public final WheelView getSecondWheelView() {
        return this.f٨٠٠١c;
    }

    public final TextView getThirdLabelView() {
        return this.f٨٠٠٥g;
    }

    public final WheelView getThirdWheelView() {
        return this.f٨٠٠٢d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void h(Context context) {
        this.f٨٠٠٠b = (WheelView) findViewById(R.id.wheel_picker_linkage_first_wheel);
        this.f٨٠٠١c = (WheelView) findViewById(R.id.wheel_picker_linkage_second_wheel);
        this.f٨٠٠٢d = (WheelView) findViewById(R.id.wheel_picker_linkage_third_wheel);
        this.f٨٠٠٣e = (TextView) findViewById(R.id.wheel_picker_linkage_first_label);
        this.f٨٠٠٤f = (TextView) findViewById(R.id.wheel_picker_linkage_second_label);
        this.f٨٠٠٥g = (TextView) findViewById(R.id.wheel_picker_linkage_third_label);
        this.f٨٠٠٦h = (ProgressBar) findViewById(R.id.wheel_picker_linkage_loading);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int i() {
        return R.layout.wheel_picker_linkage;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List j() {
        return Arrays.asList(this.f٨٠٠٠b, this.f٨٠٠١c, this.f٨٠٠٢d);
    }

    public void o(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f٨٠٠٣e.setText(charSequence);
        this.f٨٠٠٤f.setText(charSequence2);
        this.f٨٠٠٥g.setText(charSequence3);
    }

    public void setData(b bVar) {
        setFirstVisible(bVar.h());
        setThirdVisible(bVar.f());
        Object obj = this.f٨٠٠٧i;
        if (obj != null) {
            this.f٨٠١٠l = bVar.a(obj);
        }
        Object obj2 = this.f٨٠٠٨j;
        if (obj2 != null) {
            this.f٨٠١١m = bVar.c(this.f٨٠١٠l, obj2);
        }
        Object obj3 = this.f٨٠٠٩k;
        if (obj3 != null) {
            this.f٨٠١٢n = bVar.d(this.f٨٠١٠l, this.f٨٠١١m, obj3);
        }
        this.f٨٠١٣o = bVar;
        k();
        l();
        m();
    }

    public void setFirstVisible(boolean z10) {
        if (z10) {
            this.f٨٠٠٠b.setVisibility(0);
            this.f٨٠٠٣e.setVisibility(0);
        } else {
            this.f٨٠٠٠b.setVisibility(8);
            this.f٨٠٠٣e.setVisibility(8);
        }
    }

    public void setThirdVisible(boolean z10) {
        if (z10) {
            this.f٨٠٠٢d.setVisibility(0);
            this.f٨٠٠٥g.setVisibility(0);
        } else {
            this.f٨٠٠٢d.setVisibility(8);
            this.f٨٠٠٥g.setVisibility(8);
        }
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void setOnLinkageSelectedListener(i iVar) {
    }
}
