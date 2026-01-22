package com.qiahao.nextvideo.ui.reusable.views;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.ColorUtility;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SwitchButton extends CompoundButton {
    private static final int[] f0 = {R.attr.state_checked, R.attr.state_enabled, R.attr.state_pressed};
    private static final int[] g0 = {-16842912, R.attr.state_enabled, R.attr.state_pressed};
    private RectF A;
    private Paint B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ObjectAnimator F;
    private float G;
    private RectF H;
    private float I;
    private float J;
    private float K;
    private int L;
    private int M;
    private Paint N;
    private CharSequence O;
    private CharSequence P;
    private TextPaint Q;
    private Layout R;
    private Layout S;
    private float T;
    private float U;
    private int V;
    private int W;
    private Drawable a;
    private int a0;
    private Drawable b;
    private boolean b0;
    private ColorStateList c;
    private boolean c0;
    private ColorStateList d;
    private boolean d0;
    private float e;
    private CompoundButton.OnCheckedChangeListener e0;
    private float f;
    private RectF g;
    private float h;
    private long i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private Drawable u;
    private Drawable v;
    private RectF w;
    private RectF x;
    private RectF y;
    private RectF z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence a;
        CharSequence b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.a, parcel, i);
            TextUtils.writeToParcel(this.b, parcel, i);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.a = (CharSequence) creator.createFromParcel(parcel);
            this.b = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(attributeSet);
    }

    private void b() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.d0 = true;
    }

    private int c(double d) {
        return (int) Math.ceil(d);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        Drawable drawable;
        float f2;
        float f3;
        Drawable drawable2;
        float f4;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        float f5;
        float f6;
        float f7;
        int i5;
        float f8;
        float f9;
        float f10;
        ColorStateList colorStateList3;
        TypedArray obtainStyledAttributes2;
        boolean z2;
        boolean z3;
        float f11;
        this.L = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.M = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.B = new Paint(1);
        Paint paint = new Paint(1);
        this.N = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.N.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.Q = getPaint();
        this.w = new RectF();
        this.x = new RectF();
        this.y = new RectF();
        this.g = new RectF();
        this.z = new RectF();
        this.A = new RectF();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.F = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.H = new RectF();
        float f12 = getResources().getDisplayMetrics().density * 2.0f;
        if (attributeSet == null) {
            obtainStyledAttributes = null;
        } else {
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qiahao.nextvideo.R.styleable.SwitchButton);
        }
        if (obtainStyledAttributes != null) {
            drawable2 = obtainStyledAttributes.getDrawable(11);
            ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(10);
            float dimension = obtainStyledAttributes.getDimension(13, f12);
            float dimension2 = obtainStyledAttributes.getDimension(15, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(16, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(17, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(14, dimension);
            float dimension6 = obtainStyledAttributes.getDimension(20, 0.0f);
            float dimension7 = obtainStyledAttributes.getDimension(12, 0.0f);
            float dimension8 = obtainStyledAttributes.getDimension(18, -1.0f);
            float dimension9 = obtainStyledAttributes.getDimension(3, -1.0f);
            Drawable drawable3 = obtainStyledAttributes.getDrawable(2);
            ColorStateList colorStateList5 = obtainStyledAttributes.getColorStateList(1);
            f6 = dimension8;
            float f13 = obtainStyledAttributes.getFloat(19, 1.8f);
            int integer = obtainStyledAttributes.getInteger(0, RoomEvent.ROOM_CURRENT_USER_ONLINE);
            boolean z4 = obtainStyledAttributes.getBoolean(4, true);
            int color = obtainStyledAttributes.getColor(21, 0);
            String string = obtainStyledAttributes.getString(8);
            String string2 = obtainStyledAttributes.getString(7);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(9, 0);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            obtainStyledAttributes.recycle();
            f8 = dimension2;
            f9 = dimension3;
            i5 = integer;
            str2 = string2;
            i4 = color;
            f5 = dimension9;
            colorStateList = colorStateList5;
            f = dimension6;
            colorStateList2 = colorStateList4;
            drawable = drawable3;
            f2 = dimension5;
            f4 = dimension7;
            i = dimensionPixelSize;
            i2 = dimensionPixelSize2;
            f3 = dimension4;
            i3 = dimensionPixelSize3;
            str = string;
            f7 = f13;
            z = z4;
        } else {
            str = null;
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            f = 0.0f;
            drawable = null;
            f2 = 0.0f;
            f3 = 0.0f;
            drawable2 = null;
            f4 = 0.0f;
            colorStateList = null;
            colorStateList2 = null;
            z = true;
            f5 = -1.0f;
            f6 = -1.0f;
            f7 = 1.8f;
            i5 = RoomEvent.ROOM_CURRENT_USER_ONLINE;
            f8 = 0.0f;
            f9 = 0.0f;
        }
        float f14 = f2;
        if (attributeSet == null) {
            f10 = f3;
            colorStateList3 = colorStateList;
            obtainStyledAttributes2 = null;
        } else {
            f10 = f3;
            colorStateList3 = colorStateList;
            obtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.focusable, R.attr.clickable});
        }
        if (obtainStyledAttributes2 != null) {
            boolean z5 = obtainStyledAttributes2.getBoolean(0, true);
            boolean z6 = obtainStyledAttributes2.getBoolean(1, z5);
            setFocusable(z5);
            setClickable(z6);
            obtainStyledAttributes2.recycle();
        } else {
            setFocusable(true);
            setClickable(true);
        }
        this.O = str;
        this.P = str2;
        this.V = i;
        this.W = i2;
        this.a0 = i3;
        this.a = drawable2;
        this.d = colorStateList2;
        if (drawable2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.C = z2;
        this.k = i4;
        if (i4 == 0) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130968985, typedValue, true)) {
                this.k = typedValue.data;
            } else {
                this.k = 3309506;
            }
        }
        if (!this.C && this.d == null) {
            ColorStateList generateThumbColorWithTintColor = ColorUtility.INSTANCE.generateThumbColorWithTintColor(this.k);
            this.d = generateThumbColorWithTintColor;
            this.p = generateThumbColorWithTintColor.getDefaultColor();
        }
        this.l = c(f);
        this.m = c(f4);
        this.b = drawable;
        ColorStateList colorStateList6 = colorStateList3;
        this.c = colorStateList6;
        if (drawable != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.D = z3;
        if (!z3 && colorStateList6 == null) {
            ColorStateList generateBackColorWithTintColor = ColorUtility.INSTANCE.generateBackColorWithTintColor(this.k);
            this.c = generateBackColorWithTintColor;
            int defaultColor = generateBackColorWithTintColor.getDefaultColor();
            this.q = defaultColor;
            this.r = this.c.getColorForState(f0, defaultColor);
        }
        this.g.set(f8, f10, f9, f14);
        if (this.g.width() >= 0.0f) {
            f11 = Math.max(f7, 1.0f);
        } else {
            f11 = f7;
        }
        this.h = f11;
        this.e = f6;
        this.f = f5;
        long j = i5;
        this.i = j;
        this.j = z;
        this.F.setDuration(j);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private Layout e(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.Q, (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    private int f(int i) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.m == 0 && this.C) {
            this.m = this.a.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.m != 0) {
                RectF rectF = this.g;
                this.o = c(r6 + rectF.top + rectF.bottom);
                this.o = c(Math.max(r6, this.U));
                if ((((r6 + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.g.top)) - Math.min(0.0f, this.g.bottom) > size) {
                    this.m = 0;
                }
            }
            if (this.m == 0) {
                int c = c(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.g.top) + Math.min(0.0f, this.g.bottom));
                this.o = c;
                if (c < 0) {
                    this.o = 0;
                    this.m = 0;
                    return size;
                }
                RectF rectF2 = this.g;
                this.m = c((c - rectF2.top) - rectF2.bottom);
            }
            if (this.m < 0) {
                this.o = 0;
                this.m = 0;
                return size;
            }
            return size;
        }
        if (this.m == 0) {
            this.m = c(getResources().getDisplayMetrics().density * 20.0f);
        }
        float f = this.m;
        RectF rectF3 = this.g;
        int c2 = c(f + rectF3.top + rectF3.bottom);
        this.o = c2;
        if (c2 < 0) {
            this.o = 0;
            this.m = 0;
            return size;
        }
        int c3 = c(this.U - c2);
        if (c3 > 0) {
            this.o += c3;
            this.m += c3;
        }
        int max = Math.max(this.m, this.o);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int g(int i) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.l == 0 && this.C) {
            this.l = this.a.getIntrinsicWidth();
        }
        int c = c(this.T);
        if (this.h == 0.0f) {
            this.h = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.l != 0) {
                int c2 = c(r2 * this.h);
                int i2 = this.W + c;
                int i3 = c2 - this.l;
                RectF rectF = this.g;
                int c3 = i2 - (i3 + c(Math.max(rectF.left, rectF.right)));
                float f = c2;
                RectF rectF2 = this.g;
                int c4 = c(rectF2.left + f + rectF2.right + Math.max(c3, 0));
                this.n = c4;
                if (c4 < 0) {
                    this.l = 0;
                }
                if (f + Math.max(this.g.left, 0.0f) + Math.max(this.g.right, 0.0f) + Math.max(c3, 0) > paddingLeft) {
                    this.l = 0;
                }
            }
            if (this.l == 0) {
                int c5 = c((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.g.left, 0.0f)) - Math.max(this.g.right, 0.0f));
                if (c5 < 0) {
                    this.l = 0;
                    this.n = 0;
                    return size;
                }
                float f2 = c5;
                this.l = c(f2 / this.h);
                RectF rectF3 = this.g;
                int c6 = c(f2 + rectF3.left + rectF3.right);
                this.n = c6;
                if (c6 < 0) {
                    this.l = 0;
                    this.n = 0;
                    return size;
                }
                int i4 = c + this.W;
                int i5 = c5 - this.l;
                RectF rectF4 = this.g;
                int c7 = i4 - (i5 + c(Math.max(rectF4.left, rectF4.right)));
                if (c7 > 0) {
                    this.l -= c7;
                }
                if (this.l < 0) {
                    this.l = 0;
                    this.n = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.l == 0) {
            this.l = c(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.h == 0.0f) {
            this.h = 1.8f;
        }
        int c8 = c(this.l * this.h);
        float f3 = c + this.W;
        float f4 = c8 - this.l;
        RectF rectF5 = this.g;
        int c9 = c(f3 - ((f4 + Math.max(rectF5.left, rectF5.right)) + this.V));
        float f5 = c8;
        RectF rectF6 = this.g;
        int c10 = c(rectF6.left + f5 + rectF6.right + Math.max(0, c9));
        this.n = c10;
        if (c10 < 0) {
            this.l = 0;
            this.n = 0;
            return size;
        }
        int c11 = c(f5 + Math.max(0.0f, this.g.left) + Math.max(0.0f, this.g.right) + Math.max(0, c9));
        return Math.max(c11, getPaddingLeft() + c11 + getPaddingRight());
    }

    private float getProgress() {
        return this.G;
    }

    private boolean getStatusBasedOnPos() {
        if (getProgress() > 0.5f) {
            return true;
        }
        return false;
    }

    private void j() {
        int i;
        float paddingTop;
        float paddingLeft;
        if (this.l != 0 && (i = this.m) != 0 && this.n != 0 && this.o != 0) {
            if (this.e == -1.0f) {
                this.e = Math.min(r0, i) / 2;
            }
            if (this.f == -1.0f) {
                this.f = Math.min(this.n, this.o) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int c = c((this.n - Math.min(0.0f, this.g.left)) - Math.min(0.0f, this.g.right));
            if (measuredHeight <= c((this.o - Math.min(0.0f, this.g.top)) - Math.min(0.0f, this.g.bottom))) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.g.top);
            } else {
                paddingTop = (((measuredHeight - r3) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.g.top);
            }
            if (measuredWidth <= this.n) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.g.left);
            } else {
                paddingLeft = (((measuredWidth - c) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.g.left);
            }
            this.w.set(paddingLeft, paddingTop, this.l + paddingLeft, this.m + paddingTop);
            RectF rectF = this.w;
            float f = rectF.left;
            RectF rectF2 = this.g;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.x;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.n + f2, (f3 - f4) + this.o);
            RectF rectF4 = this.y;
            RectF rectF5 = this.w;
            rectF4.set(rectF5.left, 0.0f, (this.x.right - this.g.right) - rectF5.width(), 0.0f);
            this.f = Math.min(Math.min(this.x.width(), this.x.height()) / 2.0f, this.f);
            Drawable drawable = this.b;
            if (drawable != null) {
                RectF rectF6 = this.x;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, c(rectF6.right), c(this.x.bottom));
            }
            if (this.R != null) {
                RectF rectF7 = this.x;
                float width = (rectF7.left + (((((rectF7.width() + this.V) - this.l) - this.g.right) - this.R.getWidth()) / 2.0f)) - this.a0;
                RectF rectF8 = this.x;
                float height = rectF8.top + ((rectF8.height() - this.R.getHeight()) / 2.0f);
                this.z.set(width, height, this.R.getWidth() + width, this.R.getHeight() + height);
            }
            if (this.S != null) {
                RectF rectF9 = this.x;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.V) - this.l) - this.g.left) - this.S.getWidth()) / 2.0f)) - this.S.getWidth()) + this.a0;
                RectF rectF10 = this.x;
                float height2 = rectF10.top + ((rectF10.height() - this.S.getHeight()) / 2.0f);
                this.A.set(width2, height2, this.S.getWidth() + width2, this.S.getHeight() + height2);
            }
            this.c0 = true;
        }
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    private void setProgress(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.G = f;
        invalidate();
    }

    protected void a(boolean z) {
        ObjectAnimator objectAnimator = this.F;
        if (objectAnimator == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.F.cancel();
        }
        this.F.setDuration(this.i);
        if (z) {
            this.F.setFloatValues(this.G, 1.0f);
        } else {
            this.F.setFloatValues(this.G, 0.0f);
        }
        this.F.start();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        int[] iArr;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.C && (colorStateList2 = this.d) != null) {
            this.p = colorStateList2.getColorForState(getDrawableState(), this.p);
        } else {
            setDrawableState(this.a);
        }
        if (isChecked()) {
            iArr = g0;
        } else {
            iArr = f0;
        }
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.s = textColors.getColorForState(f0, defaultColor);
            this.t = textColors.getColorForState(g0, defaultColor);
        }
        if (!this.D && (colorStateList = this.c) != null) {
            int colorForState = colorStateList.getColorForState(getDrawableState(), this.q);
            this.q = colorForState;
            this.r = this.c.getColorForState(iArr, colorForState);
            return;
        }
        Drawable drawable = this.b;
        if ((drawable instanceof StateListDrawable) && this.j) {
            drawable.setState(iArr);
            this.v = this.b.getCurrent().mutate();
        } else {
            this.v = null;
        }
        setDrawableState(this.b);
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            this.u = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.i;
    }

    public ColorStateList getBackColor() {
        return this.c;
    }

    public Drawable getBackDrawable() {
        return this.b;
    }

    public float getBackRadius() {
        return this.f;
    }

    public PointF getBackSizeF() {
        return new PointF(this.x.width(), this.x.height());
    }

    public CharSequence getTextOff() {
        return this.P;
    }

    public CharSequence getTextOn() {
        return this.O;
    }

    public ColorStateList getThumbColor() {
        return this.d;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public float getThumbHeight() {
        return this.m;
    }

    public RectF getThumbMargin() {
        return this.g;
    }

    public float getThumbRadius() {
        return this.e;
    }

    public float getThumbRangeRatio() {
        return this.h;
    }

    public float getThumbWidth() {
        return this.l;
    }

    public int getTintColor() {
        return this.k;
    }

    public void h(CharSequence charSequence, CharSequence charSequence2) {
        this.O = charSequence;
        this.P = charSequence2;
        this.R = null;
        this.S = null;
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void i(float f, float f2, float f3, float f4) {
        this.g.set(f, f2, f3, f4);
        this.c0 = false;
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        Layout layout;
        RectF rectF;
        RectF rectF2;
        float f;
        int i3;
        Drawable drawable;
        Drawable drawable2;
        super.onDraw(canvas);
        if (!this.c0) {
            j();
        }
        if (!this.c0) {
            return;
        }
        if (this.D) {
            if (this.j && this.u != null && this.v != null) {
                if (isChecked()) {
                    drawable = this.u;
                } else {
                    drawable = this.v;
                }
                if (isChecked()) {
                    drawable2 = this.v;
                } else {
                    drawable2 = this.u;
                }
                int progress = (int) (getProgress() * 255.0f);
                drawable.setAlpha(progress);
                drawable.draw(canvas);
                drawable2.setAlpha(255 - progress);
                drawable2.draw(canvas);
            } else {
                this.b.setAlpha(255);
                this.b.draw(canvas);
            }
        } else if (this.j) {
            if (isChecked()) {
                i = this.q;
            } else {
                i = this.r;
            }
            if (isChecked()) {
                i2 = this.r;
            } else {
                i2 = this.q;
            }
            int progress2 = (int) (getProgress() * 255.0f);
            this.B.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
            RectF rectF3 = this.x;
            float f2 = this.f;
            canvas.drawRoundRect(rectF3, f2, f2, this.B);
            this.B.setARGB((Color.alpha(i2) * (255 - progress2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
            RectF rectF4 = this.x;
            float f3 = this.f;
            canvas.drawRoundRect(rectF4, f3, f3, this.B);
            this.B.setAlpha(255);
        } else {
            this.B.setColor(this.q);
            RectF rectF5 = this.x;
            float f4 = this.f;
            canvas.drawRoundRect(rectF5, f4, f4, this.B);
        }
        if (getProgress() > 0.5d) {
            layout = this.R;
        } else {
            layout = this.S;
        }
        if (getProgress() > 0.5d) {
            rectF = this.z;
        } else {
            rectF = this.A;
        }
        if (layout != null && rectF != null) {
            double progress3 = getProgress();
            float progress4 = getProgress();
            if (progress3 >= 0.75d) {
                f = (progress4 * 4.0f) - 3.0f;
            } else if (progress4 < 0.25d) {
                f = 1.0f - (getProgress() * 4.0f);
            } else {
                f = 0.0f;
            }
            int i4 = (int) (f * 255.0f);
            if (getProgress() > 0.5d) {
                i3 = this.s;
            } else {
                i3 = this.t;
            }
            layout.getPaint().setARGB((Color.alpha(i3) * i4) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
            canvas.save();
            canvas.translate(rectF.left, rectF.top);
            layout.draw(canvas);
            canvas.restore();
        }
        this.H.set(this.w);
        this.H.offset(this.G * this.y.width(), 0.0f);
        if (this.C) {
            Drawable drawable3 = this.a;
            RectF rectF6 = this.H;
            drawable3.setBounds((int) rectF6.left, (int) rectF6.top, c(rectF6.right), c(this.H.bottom));
            this.a.draw(canvas);
        } else {
            this.B.setColor(this.p);
            RectF rectF7 = this.H;
            float f5 = this.e;
            canvas.drawRoundRect(rectF7, f5, f5, this.B);
        }
        if (this.E) {
            this.N.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.x, this.N);
            this.N.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.H, this.N);
            this.N.setColor(Color.parseColor("#000000"));
            RectF rectF8 = this.y;
            float f6 = rectF8.left;
            float f7 = this.w.top;
            canvas.drawLine(f6, f7, rectF8.right, f7, this.N);
            this.N.setColor(Color.parseColor("#00CC00"));
            if (getProgress() > 0.5d) {
                rectF2 = this.z;
            } else {
                rectF2 = this.A;
            }
            canvas.drawRect(rectF2, this.N);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        float f;
        float f2;
        float f3;
        float f4;
        if (this.R == null && !TextUtils.isEmpty(this.O)) {
            this.R = e(this.O);
        }
        if (this.S == null && !TextUtils.isEmpty(this.P)) {
            this.S = e(this.P);
        }
        Layout layout = this.R;
        if (layout != null) {
            f = layout.getWidth();
        } else {
            f = 0.0f;
        }
        Layout layout2 = this.S;
        if (layout2 != null) {
            f2 = layout2.getWidth();
        } else {
            f2 = 0.0f;
        }
        if (f == 0.0f && f2 == 0.0f) {
            this.T = 0.0f;
        } else {
            this.T = Math.max(f, f2);
        }
        Layout layout3 = this.R;
        if (layout3 != null) {
            f3 = layout3.getHeight();
        } else {
            f3 = 0.0f;
        }
        Layout layout4 = this.S;
        if (layout4 != null) {
            f4 = layout4.getHeight();
        } else {
            f4 = 0.0f;
        }
        if (f3 == 0.0f && f4 == 0.0f) {
            this.U = 0.0f;
        } else {
            this.U = Math.max(f3, f4);
        }
        setMeasuredDimension(g(i), f(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        h(savedState.a, savedState.b);
        this.b0 = true;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.b0 = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.O;
        savedState.b = this.P;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r0 != 3) goto L٤٧;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isClickable() || !isFocusable() || !this.c0) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.I;
        float y = motionEvent.getY() - this.J;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x2 = motionEvent.getX();
                    setProgress(getProgress() + ((x2 - this.K) / this.y.width()));
                    if (!this.d0 && (Math.abs(x) > this.L / 2 || Math.abs(y) > this.L / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            b();
                        }
                    }
                    this.K = x2;
                }
            }
            this.d0 = false;
            setPressed(false);
            float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
            if (Math.abs(x) < this.L && Math.abs(y) < this.L && eventTime < this.M) {
                performClick();
            } else {
                boolean statusBasedOnPos = getStatusBasedOnPos();
                if (statusBasedOnPos != isChecked()) {
                    playSoundEffect(0);
                    setChecked(statusBasedOnPos);
                } else {
                    a(statusBasedOnPos);
                }
            }
        } else {
            this.I = motionEvent.getX();
            this.J = motionEvent.getY();
            this.K = this.I;
            setPressed(true);
        }
        return true;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j) {
        this.i = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.c = colorStateList;
        if (colorStateList != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(androidx.core.content.a.getColorStateList(getContext(), i));
    }

    public void setBackDrawable(Drawable drawable) {
        boolean z;
        this.b = drawable;
        if (drawable != null) {
            z = true;
        } else {
            z = false;
        }
        this.D = z;
        refreshDrawableState();
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(androidx.core.content.a.getDrawable(getContext(), i));
    }

    public void setBackRadius(float f) {
        this.f = f;
        if (!this.D) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            a(z);
        }
        if (this.b0) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        float f;
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.F;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.F.cancel();
        }
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        setProgress(f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.e0 == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.e0);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.e0 == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.e0);
    }

    public void setDrawDebugRect(boolean z) {
        this.E = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.j = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.e0 = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.a0 = i;
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.W = i;
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.V = i;
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.d = colorStateList;
        if (colorStateList != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(androidx.core.content.a.getColorStateList(getContext(), i));
    }

    public void setThumbDrawable(Drawable drawable) {
        boolean z;
        this.a = drawable;
        if (drawable != null) {
            z = true;
        } else {
            z = false;
        }
        this.C = z;
        refreshDrawableState();
        this.c0 = false;
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i) {
        setThumbDrawable(androidx.core.content.a.getDrawable(getContext(), i));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            i(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            i(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f) {
        this.e = f;
        if (!this.C) {
            invalidate();
        }
    }

    public void setThumbRangeRatio(float f) {
        this.h = f;
        this.c0 = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.k = i;
        ColorUtility colorUtility = ColorUtility.INSTANCE;
        this.d = colorUtility.generateThumbColorWithTintColor(i);
        this.c = colorUtility.generateBackColorWithTintColor(this.k);
        this.D = false;
        this.C = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.E = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        d(null);
    }
}
