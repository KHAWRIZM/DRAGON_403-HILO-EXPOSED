package com.qiahao.nextvideo.ui.reusable.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SwitchView extends View {
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;
    private b M;
    private final AccelerateInterpolator a;
    private final Paint b;
    private final Path c;
    private final Path d;
    private final RectF e;
    private float f;
    private float g;
    private RadialGradient h;
    protected float i;
    protected float j;
    private int k;
    private int l;
    private boolean m;
    private View.OnClickListener n;
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected boolean v;
    protected boolean w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private boolean a;

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

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = 1 == parcel.readInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class a implements b {
        a() {
        }

        @Override // com.qiahao.nextvideo.ui.reusable.views.SwitchView.b
        public void a(SwitchView switchView) {
            SwitchView.this.d(false);
        }

        @Override // com.qiahao.nextvideo.ui.reusable.views.SwitchView.b
        public void b(SwitchView switchView) {
            SwitchView.this.d(true);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface b {
        void a(SwitchView switchView);

        void b(SwitchView switchView);
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    private void a(float f) {
        this.d.reset();
        RectF rectF = this.e;
        float f2 = this.F;
        float f3 = this.D;
        rectF.left = f2 + (f3 / 2.0f);
        rectF.right = this.G - (f3 / 2.0f);
        this.d.arcTo(rectF, 90.0f, 180.0f);
        RectF rectF2 = this.e;
        float f4 = this.F;
        float f5 = this.B;
        float f6 = this.D;
        rectF2.left = f4 + (f * f5) + (f6 / 2.0f);
        rectF2.right = (this.G + (f * f5)) - (f6 / 2.0f);
        this.d.arcTo(rectF2, 270.0f, 180.0f);
        this.d.close();
    }

    private float b(float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i = this.k;
        int i2 = i - this.l;
        if (i2 != -3) {
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i == 1) {
                                    f4 = this.K;
                                } else {
                                    if (i == 4) {
                                        f4 = this.H;
                                    }
                                    f4 = 0.0f;
                                }
                            } else {
                                f5 = this.H;
                                f6 = this.K;
                                f4 = f5 - ((f5 - f6) * f);
                            }
                        } else {
                            if (i == 4) {
                                f5 = this.H;
                                f6 = this.K;
                            } else {
                                if (i == 3) {
                                    f5 = this.I;
                                    f6 = this.K;
                                }
                                f4 = 0.0f;
                            }
                            f4 = f5 - ((f5 - f6) * f);
                        }
                    } else if (i == 2) {
                        f4 = this.K;
                    } else {
                        if (i == 4) {
                            f5 = this.H;
                            f6 = this.I;
                            f4 = f5 - ((f5 - f6) * f);
                        }
                        f4 = 0.0f;
                    }
                } else if (i == 3) {
                    f2 = this.I;
                    f3 = this.H;
                } else {
                    if (i == 1) {
                        f4 = this.K;
                    }
                    f4 = 0.0f;
                }
            } else if (i == 1) {
                f2 = this.K;
                f3 = this.I;
            } else {
                if (i == 2) {
                    f2 = this.J;
                    f3 = this.H;
                }
                f4 = 0.0f;
            }
            return f4 - this.K;
        }
        f2 = this.K;
        f3 = this.H;
        f4 = f2 + ((f3 - f2) * f);
        return f4 - this.K;
    }

    private void c(int i) {
        boolean z = this.w;
        if (!z && i == 4) {
            this.w = true;
        } else if (z && i == 1) {
            this.w = false;
        }
        this.l = this.k;
        this.k = i;
        postInvalidate();
    }

    public void d(boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 1;
        }
        int i2 = this.k;
        if (i == i2) {
            return;
        }
        if ((i == 4 && (i2 == 1 || i2 == 2)) || (i == 1 && (i2 == 4 || i2 == 3))) {
            this.f = 1.0f;
        }
        this.g = 1.0f;
        c(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        float f;
        float f2;
        float f3;
        int i2;
        super.onDraw(canvas);
        if (!this.m) {
            return;
        }
        boolean z = true;
        this.b.setAntiAlias(true);
        int i3 = this.k;
        if (i3 != 4 && i3 != 3) {
            z = false;
        }
        Paint paint = this.b;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = this.b;
        if (z) {
            i = this.o;
        } else {
            i = this.q;
        }
        paint2.setColor(i);
        canvas.drawPath(this.c, this.b);
        float f4 = this.f;
        float f5 = this.j;
        if (f4 - f5 > 0.0f) {
            f = f4 - f5;
        } else {
            f = 0.0f;
        }
        this.f = f;
        float f6 = this.g;
        if (f6 - f5 > 0.0f) {
            f2 = f6 - f5;
        } else {
            f2 = 0.0f;
        }
        this.g = f2;
        float interpolation = this.a.getInterpolation(f);
        float interpolation2 = this.a.getInterpolation(this.g);
        float f7 = this.A;
        if (z) {
            f3 = interpolation;
        } else {
            f3 = 1.0f - interpolation;
        }
        float f8 = f7 * f3;
        float f9 = (this.x - this.y) - this.C;
        if (z) {
            interpolation = 1.0f - interpolation;
        }
        canvas.save();
        canvas.scale(f8, f8, this.y + (f9 * interpolation), this.z);
        this.b.setColor(this.u);
        canvas.drawPath(this.c, this.b);
        canvas.restore();
        canvas.save();
        canvas.translate(b(interpolation2), this.L);
        int i4 = this.k;
        if (i4 == 3 || i4 == 2) {
            interpolation2 = 1.0f - interpolation2;
        }
        a(interpolation2);
        if (this.v) {
            this.b.setStyle(style);
            this.b.setShader(this.h);
            canvas.drawPath(this.d, this.b);
            this.b.setShader(null);
        }
        canvas.translate(0.0f, -this.L);
        float f10 = this.E;
        canvas.scale(0.98f, 0.98f, f10 / 2.0f, f10 / 2.0f);
        this.b.setStyle(style);
        this.b.setColor(this.t);
        canvas.drawPath(this.d, this.b);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.D * 0.5f);
        Paint paint3 = this.b;
        if (z) {
            i2 = this.p;
        } else {
            i2 = this.r;
        }
        paint3.setColor(i2);
        canvas.drawPath(this.d, this.b);
        canvas.restore();
        this.b.reset();
        if (this.f > 0.0f || this.g > 0.0f) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != 1073741824) {
            int paddingLeft = ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f)) + getPaddingLeft() + getPaddingRight();
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(paddingLeft, size);
            } else {
                size = paddingLeft;
            }
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            int paddingTop = ((int) (size * this.i)) + getPaddingTop() + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(paddingTop, size2);
            } else {
                size2 = paddingTop;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z = savedState.a;
        this.w = z;
        if (z) {
            i = 4;
        } else {
            i = 1;
        }
        this.k = i;
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.w;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        int paddingLeft;
        int width;
        int paddingTop;
        int height;
        super.onSizeChanged(i, i2, i3, i4);
        if (i > getPaddingLeft() + getPaddingRight() && i2 > getPaddingTop() + getPaddingBottom()) {
            z = true;
        } else {
            z = false;
        }
        this.m = z;
        if (z) {
            int paddingLeft2 = (i - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (i2 - getPaddingTop()) - getPaddingBottom();
            float f = paddingLeft2;
            float f2 = this.i;
            float f3 = paddingTop2;
            if (f * f2 < f3) {
                paddingLeft = getPaddingLeft();
                width = i - getPaddingRight();
                int i5 = ((int) (f3 - (f * this.i))) / 2;
                paddingTop = getPaddingTop() + i5;
                height = (getHeight() - getPaddingBottom()) - i5;
            } else {
                int i6 = ((int) (f - (f3 / f2))) / 2;
                paddingLeft = getPaddingLeft() + i6;
                width = (getWidth() - getPaddingRight()) - i6;
                paddingTop = getPaddingTop();
                height = getHeight() - getPaddingBottom();
            }
            float f4 = (int) ((height - paddingTop) * 0.07f);
            this.L = f4;
            float f5 = paddingLeft;
            float f6 = paddingTop + f4;
            float f7 = width;
            this.x = f7;
            float f8 = height - f4;
            float f9 = f8 - f6;
            this.y = (f7 + f5) / 2.0f;
            float f10 = (f8 + f6) / 2.0f;
            this.z = f10;
            this.F = f5;
            this.E = f9;
            this.G = f5 + f9;
            float f11 = f9 / 2.0f;
            float f12 = 0.95f * f11;
            this.C = f12;
            float f13 = 0.2f * f12;
            this.B = f13;
            float f14 = (f11 - f12) * 2.0f;
            this.D = f14;
            float f15 = f7 - f9;
            this.H = f15;
            this.I = f15 - f13;
            this.K = f5;
            this.J = f13 + f5;
            this.A = 1.0f - (f14 / f9);
            this.c.reset();
            RectF rectF = new RectF();
            rectF.top = f6;
            rectF.bottom = f8;
            rectF.left = f5;
            rectF.right = f5 + f9;
            this.c.arcTo(rectF, 90.0f, 180.0f);
            float f16 = this.x;
            rectF.left = f16 - f9;
            rectF.right = f16;
            this.c.arcTo(rectF, 270.0f, 180.0f);
            this.c.close();
            RectF rectF2 = this.e;
            float f17 = this.F;
            rectF2.left = f17;
            float f18 = this.G;
            rectF2.right = f18;
            float f19 = this.D;
            rectF2.top = f6 + (f19 / 2.0f);
            rectF2.bottom = f8 - (f19 / 2.0f);
            float f20 = (f18 + f17) / 2.0f;
            int i7 = this.s;
            int i8 = (i7 >> 16) & 255;
            int i9 = (i7 >> 8) & 255;
            int i10 = i7 & 255;
            this.h = new RadialGradient(f20, f10, this.C, Color.argb(200, i8, i9, i10), Color.argb(25, i8, i9, i10), Shader.TileMode.CLAMP);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = this.k;
        if ((i == 4 || i == 1) && this.f * this.g == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i2 = this.k;
                this.l = i2;
                this.g = 1.0f;
                if (i2 == 1) {
                    c(2);
                    this.M.b(this);
                } else if (i2 == 4) {
                    c(3);
                    this.M.a(this);
                }
                View.OnClickListener onClickListener = this.n;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.n = onClickListener;
    }

    public void setOnStateChangedListener(b bVar) {
        if (bVar != null) {
            this.M = bVar;
            return;
        }
        throw new IllegalArgumentException("empty listener");
    }

    public void setOpened(boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 1;
        }
        if (i == this.k) {
            return;
        }
        c(i);
    }

    public void setShadow(boolean z) {
        this.v = z;
        invalidate();
    }

    @TargetApi(11)
    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AccelerateInterpolator(2.0f);
        this.b = new Paint();
        this.c = new Path();
        this.d = new Path();
        this.e = new RectF();
        this.i = 0.68f;
        this.j = 0.1f;
        this.m = false;
        this.M = new a();
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchView);
        this.o = obtainStyledAttributes.getColor(6, -11806877);
        this.p = obtainStyledAttributes.getColor(7, -12925358);
        this.q = obtainStyledAttributes.getColor(4, -1842205);
        this.r = obtainStyledAttributes.getColor(5, -4210753);
        this.s = obtainStyledAttributes.getColor(9, -13421773);
        this.t = obtainStyledAttributes.getColor(0, -1);
        this.u = obtainStyledAttributes.getColor(1, -1);
        this.i = obtainStyledAttributes.getFloat(8, 0.68f);
        this.v = obtainStyledAttributes.getBoolean(2, true);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        this.w = z;
        int i = z ? 4 : 1;
        this.k = i;
        this.l = i;
        obtainStyledAttributes.recycle();
        if (this.o == -11806877 && this.p == -12925358) {
            try {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
                int i2 = typedValue.data;
                if (i2 > 0) {
                    this.o = i2;
                }
                TypedValue typedValue2 = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorPrimaryDark, typedValue2, true);
                int i3 = typedValue2.data;
                if (i3 > 0) {
                    this.p = i3;
                }
            } catch (Exception unused) {
            }
        }
    }
}
