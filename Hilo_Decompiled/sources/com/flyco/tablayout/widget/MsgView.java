package com.flyco.tablayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.flyco.tablayout.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MsgView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private Context f٧٩٣١a;

    /* renamed from: b, reason: collision with root package name */
    private GradientDrawable f٧٩٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private int f٧٩٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٩٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f٧٩٣٥e;

    /* renamed from: f, reason: collision with root package name */
    private int f٧٩٣٦f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٧٩٣٧g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٧٩٣٨h;

    public MsgView(Context context) {
        this(context, null);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
        this.f٧٩٣٣c = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_backgroundColor, 0);
        this.f٧٩٣٤d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_cornerRadius, 0);
        this.f٧٩٣٥e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_strokeWidth, 0);
        this.f٧٩٣٦f = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_strokeColor, 0);
        this.f٧٩٣٧g = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.f٧٩٣٨h = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isWidthHeightEqual, false);
        obtainStyledAttributes.recycle();
    }

    private void f(GradientDrawable gradientDrawable, int i10, int i11) {
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(this.f٧٩٣٤d);
        gradientDrawable.setStroke(this.f٧٩٣٥e, i11);
    }

    protected int a(float f10) {
        return (int) ((f10 * this.f٧٩٣١a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public boolean b() {
        return this.f٧٩٣٧g;
    }

    public boolean c() {
        return this.f٧٩٣٨h;
    }

    public void e() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        f(this.f٧٩٣٢b, this.f٧٩٣٣c, this.f٧٩٣٦f);
        stateListDrawable.addState(new int[]{-16842919}, this.f٧٩٣٢b);
        setBackground(stateListDrawable);
    }

    public int getBackgroundColor() {
        return this.f٧٩٣٣c;
    }

    public int getCornerRadius() {
        return this.f٧٩٣٤d;
    }

    public int getStrokeColor() {
        return this.f٧٩٣٦f;
    }

    public int getStrokeWidth() {
        return this.f٧٩٣٥e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (b()) {
            setCornerRadius(getHeight() / 2);
        } else {
            e();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (c() && getWidth() > 0 && getHeight() > 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f٧٩٣٣c = i10;
        e();
    }

    public void setCornerRadius(int i10) {
        this.f٧٩٣٤d = a(i10);
        e();
    }

    public void setIsRadiusHalfHeight(boolean z10) {
        this.f٧٩٣٧g = z10;
        e();
    }

    public void setIsWidthHeightEqual(boolean z10) {
        this.f٧٩٣٨h = z10;
        e();
    }

    public void setStrokeColor(int i10) {
        this.f٧٩٣٦f = i10;
        e();
    }

    public void setStrokeWidth(int i10) {
        this.f٧٩٣٥e = a(i10);
        e();
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٩٣٢b = new GradientDrawable();
        this.f٧٩٣١a = context;
        d(context, attributeSet);
    }
}
