package com.scwang.smart.refresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.scwang.smart.refresh.header.material.CircleImageView;
import com.scwang.smart.refresh.header.material.R;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import tc.d;
import tc.e;
import tc.f;
import tech.sud.gip.core.view.round.RoundedDrawable;
import uc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MaterialHeader extends SimpleComponent implements d {
    protected boolean a;
    protected int b;
    protected ImageView c;
    protected e d;
    protected sc.a e;
    protected int f;
    protected int g;
    protected int h;
    protected Path i;
    protected Paint j;
    protected uc.b k;
    protected boolean l;
    protected boolean m;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;
        final /* synthetic */ boolean b;

        a(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.animate().setListener(null);
            MaterialHeader.this.e.start();
            MaterialHeader.this.d.c(animator, this.b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[uc.b.values().length];
            a = iArr;
            try {
                iArr[uc.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[uc.b.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[uc.b.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[uc.b.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MaterialHeader(Context context) {
        this(context, null);
    }

    public MaterialHeader a(int... iArr) {
        this.e.e(iArr);
        return this;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public boolean autoOpen(int i, float f, boolean z) {
        if (this.l || this.d == null) {
            return false;
        }
        ImageView imageView = this.c;
        imageView.setAlpha(1.0f);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setTranslationY((this.h / 2.0f) + (this.b / 2.0f));
        imageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(i).setListener(new a(imageView, z));
        return true;
    }

    public MaterialHeader b(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.a.getColor(context, iArr[i]);
        }
        return a(iArr2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.l) {
            this.i.reset();
            this.i.lineTo(0.0f, this.g);
            this.i.quadTo(getMeasuredWidth() / 2.0f, this.g + (this.f * 1.9f), getMeasuredWidth(), this.g);
            this.i.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.i, this.j);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public int onFinish(f fVar, boolean z) {
        ImageView imageView = this.c;
        this.e.stop();
        imageView.animate().scaleX(0.0f).scaleY(0.0f);
        this.a = true;
        return 0;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onInitialized(e eVar, int i, int i2) {
        if (!this.l) {
            eVar.h(this, false);
        }
        if (isInEditMode()) {
            int i3 = i / 2;
            this.g = i3;
            this.f = i3;
        }
        this.d = eVar;
        this.h = i;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            return;
        }
        ImageView imageView = this.c;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        if (isInEditMode() && (i5 = this.g) > 0) {
            int i6 = i5 - (measuredHeight / 2);
            int i7 = measuredWidth / 2;
            int i8 = measuredWidth2 / 2;
            imageView.layout(i7 - i8, i6, i7 + i8, measuredHeight + i6);
            this.e.k(true);
            this.e.i(0.0f, 0.8f);
            this.e.d(1.0f);
            imageView.setAlpha(1.0f);
            imageView.setVisibility(0);
            return;
        }
        int i9 = measuredWidth / 2;
        int i10 = measuredWidth2 / 2;
        imageView.layout(i9 - i10, -measuredHeight, i9 + i10, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        uc.b bVar = this.k;
        uc.b bVar2 = uc.b.Refreshing;
        if (bVar == bVar2) {
            return;
        }
        if (this.l) {
            this.g = Math.min(i, i2);
            this.f = Math.max(0, i - i2);
            postInvalidate();
        }
        if (z || (!this.e.isRunning() && !this.a)) {
            if (this.k != bVar2) {
                float f2 = i2;
                float max = (((float) Math.max(Math.min(1.0f, Math.abs((i * 1.0f) / f2)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                double max2 = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
                float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
                this.e.k(true);
                this.e.i(0.0f, Math.min(0.8f, max * 0.8f));
                this.e.d(Math.min(1.0f, max));
                this.e.f((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
            }
            ImageView imageView = this.c;
            float f3 = i;
            imageView.setTranslationY(Math.min(f3, (f3 / 2.0f) + (this.b / 2.0f)));
            imageView.setAlpha(Math.min(1.0f, (f3 * 4.0f) / this.b));
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onStartAnimator(f fVar, int i, int i2) {
        this.e.start();
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, vc.i
    public void onStateChanged(f fVar, uc.b bVar, uc.b bVar2) {
        ImageView imageView = this.c;
        this.k = bVar2;
        if (b.a[bVar2.ordinal()] == 4) {
            this.a = false;
            imageView.setVisibility(0);
            imageView.setTranslationY(0.0f);
            imageView.setScaleX(1.0f);
            imageView.setScaleY(1.0f);
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.j.setColor(iArr[0]);
        }
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.l = false;
        this.m = true;
        this.mSpinnerStyle = c.h;
        setMinimumHeight(wc.c.c(100.0f));
        sc.a aVar = new sc.a(this);
        this.e = aVar;
        aVar.e(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, -328966);
        this.c = circleImageView;
        circleImageView.setImageDrawable(this.e);
        this.c.setAlpha(0.0f);
        addView(this.c);
        this.b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.i = new Path();
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.l = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlShowBezierWave, this.l);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlScrollableWhenRefreshing, this.m);
        this.j.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_srlPrimaryColor, -15614977));
        int i = R.styleable.MaterialHeader_srlShadowRadius;
        if (obtainStyledAttributes.hasValue(i)) {
            this.j.setShadowLayer(obtainStyledAttributes.getDimensionPixelOffset(i, 0), 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, RoundedDrawable.DEFAULT_BORDER_COLOR));
            setLayerType(1, null);
        }
        this.l = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.l);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhScrollableWhenRefreshing, this.m);
        int i2 = R.styleable.MaterialHeader_mhPrimaryColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.j.setColor(obtainStyledAttributes.getColor(i2, -15614977));
        }
        int i3 = R.styleable.MaterialHeader_mhShadowRadius;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.j.setShadowLayer(obtainStyledAttributes.getDimensionPixelOffset(i3, 0), 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, RoundedDrawable.DEFAULT_BORDER_COLOR));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }
}
