package com.qiahao.nextvideo.flowingdrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Scroller;
import com.qiahao.nextvideo.R;
import pa.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ElasticDrawer extends ViewGroup {
    protected static final Interpolator G = new com.qiahao.nextvideo.flowingdrawer.c();
    protected Bundle A;
    protected boolean B;
    protected int C;
    private float D;
    protected boolean E;
    private final Runnable F;
    protected boolean a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    private Scroller f;
    protected boolean g;
    protected boolean h;
    protected float i;
    protected float j;
    protected float k;
    protected float l;
    protected VelocityTracker m;
    protected int n;
    private int o;
    private int p;
    protected int q;
    protected int r;
    protected BuildLayerFrameLayout s;
    protected BuildLayerFrameLayout t;
    private FlowingMenuLayout u;
    protected int v;
    protected float w;
    private f x;
    protected int y;
    protected int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Bundle a;

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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readBundle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ElasticDrawer.this.r();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class b implements i.g {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public void a(i iVar) {
            ElasticDrawer.this.u(((Float) iVar.u()).floatValue(), this.a, 6);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class c extends com.qiahao.nextvideo.flowingdrawer.a {
        c() {
        }

        public void c(pa.a aVar) {
            ElasticDrawer elasticDrawer = ElasticDrawer.this;
            elasticDrawer.a = false;
            elasticDrawer.u(0.0f, 0.0f, 0);
            ElasticDrawer.this.setDrawerState(0);
            ElasticDrawer.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class d implements i.g {
        d() {
        }

        public void a(i iVar) {
            ElasticDrawer.this.u.setUpDownFraction(iVar.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class e extends com.qiahao.nextvideo.flowingdrawer.a {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        public void c(pa.a aVar) {
            boolean z;
            ElasticDrawer elasticDrawer = ElasticDrawer.this;
            if (elasticDrawer.z == 6) {
                int i = this.a;
                int i2 = 0;
                if (i != 0) {
                    z = true;
                } else {
                    z = false;
                }
                elasticDrawer.a = z;
                elasticDrawer.u(i, 0.0f, 0);
                ElasticDrawer elasticDrawer2 = ElasticDrawer.this;
                if (this.a != 0) {
                    i2 = 8;
                }
                elasticDrawer2.setDrawerState(i2);
                ElasticDrawer.this.y();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface f {
        void onDrawerSlide(float f, int i);

        void onDrawerStateChange(int i, int i2);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface g {
    }

    public ElasticDrawer(Context context) {
        super(context);
        this.h = false;
        this.k = -1.0f;
        this.l = -1.0f;
        this.q = 1;
        this.y = 600;
        this.z = 0;
        this.C = -1;
        this.F = new a();
    }

    private void g() {
        this.f.abortAnimation();
        k(this.f.getFinalX());
    }

    private void k(int i) {
        i x = i.x(new float[]{0.0f, 1.0f});
        x.n(new d());
        x.a(new e(i));
        x.z(300L);
        x.B(new OvershootInterpolator(4.0f));
        x.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        boolean z = true;
        if (this.f.computeScrollOffset()) {
            int i = (int) this.w;
            int currX = this.f.getCurrX();
            if (currX != i) {
                int i2 = this.z;
                if (i2 == 6) {
                    u(currX, this.D, 2);
                } else if (i2 == 1) {
                    u(currX, this.D, 4);
                }
            }
            if (currX != this.f.getFinalX()) {
                postOnAnimation(this.F);
                return;
            }
        }
        int i3 = this.z;
        if (i3 == 6) {
            g();
            return;
        }
        if (i3 == 1) {
            this.f.abortAnimation();
            int finalX = this.f.getFinalX();
            int i4 = 0;
            if (finalX == 0) {
                z = false;
            }
            this.a = z;
            u(finalX, 0.0f, 0);
            if (finalX != 0) {
                i4 = 8;
            }
            setDrawerState(i4);
            y();
        }
    }

    private void setPosition(int i) {
        this.o = i;
        this.p = getPosition();
    }

    protected void c(int i, int i2, float f2) {
        int i3 = (int) this.w;
        int i4 = i - i3;
        if (getPosition() == 1) {
            if (i4 > 0) {
                setDrawerState(6);
            } else {
                setDrawerState(1);
            }
        } else if (i4 > 0) {
            setDrawerState(1);
        } else {
            setDrawerState(6);
        }
        this.f.startScroll(i3, 0, i4, 0, i2);
        this.D = f2;
        w();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i, int i2, boolean z, float f2) {
        int abs;
        j();
        int i3 = i - ((int) this.w);
        if (i3 != 0 && z) {
            int abs2 = Math.abs(i2);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(i3 / abs2) * 1000.0f) * 4;
            } else {
                abs = (int) (Math.abs(i3 / this.b) * 600.0f);
            }
            c(i, Math.min(abs, this.y), f2);
            return;
        }
        int i4 = 0;
        u(i, 0.0f, 0);
        if (i != 0) {
            i4 = 8;
        }
        setDrawerState(i4);
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public void e() {
        f(true);
    }

    public abstract void f(boolean z);

    public ViewGroup getContentContainer() {
        return this.t;
    }

    public int getDrawerState() {
        return this.z;
    }

    public ViewGroup getMenuContainer() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPosition() {
        int a2 = com.qiahao.nextvideo.flowingdrawer.d.a(this);
        int i = this.o;
        if (i != 3) {
            if (i != 4) {
                return i;
            }
            if (a2 != 1) {
                return 2;
            }
            return 1;
        }
        if (a2 == 1) {
            return 2;
        }
        return 1;
    }

    public int getTouchBezelSize() {
        return this.c;
    }

    protected void h(float f2, int i) {
        f fVar = this.x;
        if (fVar != null) {
            fVar.onDrawerSlide(f2, i);
        }
    }

    protected int i(int i) {
        return (int) ((getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.B = false;
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float l(VelocityTracker velocityTracker) {
        return velocityTracker.getXVelocity(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Context context, AttributeSet attributeSet, int i) {
        setWillNotDraw(false);
        setFocusable(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ElasticDrawer);
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, i(240));
        this.v = obtainStyledAttributes.getColor(1, -2236963);
        this.c = obtainStyledAttributes.getDimensionPixelSize(4, i(32));
        this.y = obtainStyledAttributes.getInt(0, 600);
        setPosition(obtainStyledAttributes.getInt(3, 0));
        obtainStyledAttributes.recycle();
        NoClickThroughFrameLayout noClickThroughFrameLayout = new NoClickThroughFrameLayout(context);
        this.s = noClickThroughFrameLayout;
        noClickThroughFrameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        this.t = new NoClickThroughFrameLayout(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d = viewConfiguration.getScaledTouchSlop();
        this.e = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f = new Scroller(context, G);
        this.n = i(3);
        this.t.setLayerType(0, null);
        this.t.setHardwareLayersEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n() {
        if (Math.abs(this.w) <= this.n) {
            return true;
        }
        return false;
    }

    protected abstract void o(int i);

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 2) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                removeView(childAt);
                this.t.removeAllViews();
                this.t.addView(childAt, new ViewGroup.LayoutParams(-1, -1));
                View childAt2 = getChildAt(0);
                if (childAt2 != null) {
                    removeView(childAt2);
                    FlowingMenuLayout flowingMenuLayout = (FlowingMenuLayout) childAt2;
                    this.u = flowingMenuLayout;
                    flowingMenuLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    this.u.setPaintColor(this.v);
                    this.u.setMenuPosition(getPosition());
                    this.s.removeAllViews();
                    this.s.addView(childAt2, new ViewGroup.LayoutParams(-1, -1));
                    addView(this.t, -1, new ViewGroup.LayoutParams(-1, -1));
                    addView(this.s, -1, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                throw new IllegalStateException("menu view must be added in xml .");
            }
            throw new IllegalStateException("content view must be added in xml .");
        }
        throw new IllegalStateException("child count isn't equal to 2 , content and Menu view must be added in xml .");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        s(savedState.a);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (getPosition() != this.p) {
            this.p = getPosition();
            u(this.w * (-1.0f), 0.0f, 0);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.A == null) {
            this.A = new Bundle();
        }
        t(this.A);
        savedState.a = this.A;
        return savedState;
    }

    public void p() {
        q(true);
    }

    @Override // android.view.View
    public void postOnAnimation(Runnable runnable) {
        super.postOnAnimation(runnable);
    }

    public abstract void q(boolean z);

    public void s(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        this.A = bundle;
        boolean z = bundle.getBoolean("ElasticDrawer.menuVisible");
        int i = 0;
        if (z) {
            q(false);
        } else {
            u(0.0f, 0.0f, 0);
        }
        if (z) {
            i = 8;
        }
        this.z = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDrawerState(int i) {
        int i2 = this.z;
        if (i != i2) {
            this.z = i;
            f fVar = this.x;
            if (fVar != null) {
                fVar.onDrawerStateChange(i2, i);
            }
        }
    }

    public void setHardwareLayerEnabled(boolean z) {
        if (z != this.h) {
            this.h = z;
            this.s.setHardwareLayersEnabled(z);
            this.t.setHardwareLayersEnabled(z);
            y();
        }
    }

    public void setMaxAnimationDuration(int i) {
        this.y = i;
    }

    public void setMenuSize(int i) {
        this.b = i;
        int i2 = this.z;
        if (i2 == 8 || i2 == 6) {
            u(i, 0.0f, 0);
        }
        requestLayout();
        invalidate();
    }

    public void setOnDrawerStateChangeListener(f fVar) {
        this.x = fVar;
    }

    public void setOnInterceptMoveEventListener(g gVar) {
    }

    public void setTouchBezelSize(int i) {
        this.c = i;
    }

    public void setTouchMode(int i) {
        if (this.q != i) {
            this.q = i;
            z();
        }
    }

    void t(Bundle bundle) {
        boolean z;
        int i = this.z;
        if (i != 8 && i != 6) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean("ElasticDrawer.menuVisible", z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(float f2, float f3, int i) {
        boolean z;
        int i2 = (int) this.w;
        int i3 = (int) f2;
        this.w = f2;
        this.u.c(f2, f3, i);
        if (i3 != i2) {
            o(i3);
            if (i3 != 0) {
                z = true;
            } else {
                z = false;
            }
            this.a = z;
            h(Math.abs(i3) / this.b, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i) {
        j();
        setDrawerState(1);
        i x = i.x(new float[]{this.w, 0.0f});
        x.n(new b(i));
        x.a(new c());
        x.z(500L);
        x.B(new DecelerateInterpolator(4.0f));
        x.D();
    }

    protected void w() {
        if (this.h && !this.g) {
            this.g = true;
            this.t.setLayerType(2, null);
            this.s.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        removeCallbacks(this.F);
        this.f.abortAnimation();
        y();
    }

    protected void y() {
        if (this.g) {
            this.g = false;
            this.t.setLayerType(0, null);
            this.s.setLayerType(0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        int i = this.q;
        if (i == 1) {
            this.r = this.c;
        } else if (i == 2) {
            this.r = getMeasuredWidth();
        } else {
            this.r = 0;
        }
    }

    public ElasticDrawer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.elasticDrawerStyle);
    }

    public ElasticDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.k = -1.0f;
        this.l = -1.0f;
        this.q = 1;
        this.y = 600;
        this.z = 0;
        this.C = -1;
        this.F = new a();
        m(context, attributeSet, i);
    }
}
