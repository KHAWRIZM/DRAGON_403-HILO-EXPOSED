package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.d1;
import androidx.customview.view.AbsSavedState;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import m2.g0;
import s2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f٤٠٩٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f٤٠٩٨b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f٤٠٩٩c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f٤١٠٠d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٤١٠١e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٤١٠٢f;

    /* renamed from: g, reason: collision with root package name */
    View f٤١٠٣g;

    /* renamed from: h, reason: collision with root package name */
    float f٤١٠٤h;

    /* renamed from: i, reason: collision with root package name */
    private float f٤١٠٥i;

    /* renamed from: j, reason: collision with root package name */
    int f٤١٠٦j;

    /* renamed from: k, reason: collision with root package name */
    boolean f٤١٠٧k;

    /* renamed from: l, reason: collision with root package name */
    private int f٤١٠٨l;

    /* renamed from: m, reason: collision with root package name */
    private float f٤١٠٩m;

    /* renamed from: n, reason: collision with root package name */
    private float f٤١١٠n;

    /* renamed from: o, reason: collision with root package name */
    final s2.c f٤١١١o;

    /* renamed from: p, reason: collision with root package name */
    boolean f٤١١٢p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٤١١٣q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f٤١١٤r;

    /* renamed from: s, reason: collision with root package name */
    final ArrayList f٤١١٥s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f٤١١٦a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٤١١٦a ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٤١١٦a = parcel.readInt() != 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f٤١١٧a = new Rect();

        a() {
        }

        private void c(g0 g0Var, g0 g0Var2) {
            Rect rect = this.f٤١١٧a;
            g0Var2.m(rect);
            g0Var.j0(rect);
            g0Var2.n(rect);
            g0Var.k0(rect);
            g0Var.T0(g0Var2.Z());
            g0Var.E0(g0Var2.z());
            g0Var.o0(g0Var2.q());
            g0Var.s0(g0Var2.t());
            g0Var.u0(g0Var2.O());
            g0Var.p0(g0Var2.M());
            g0Var.w0(g0Var2.P());
            g0Var.x0(g0Var2.Q());
            g0Var.h0(g0Var2.J());
            g0Var.M0(g0Var2.W());
            g0Var.B0(g0Var2.T());
            g0Var.a(g0Var2.k());
            g0Var.D0(g0Var2.x());
        }

        public boolean d(View view) {
            return SlidingPaneLayout.this.h(view);
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            g0 c02 = g0.c0(g0Var);
            super.onInitializeAccessibilityNodeInfo(view, c02);
            c(g0Var, c02);
            c02.e0();
            g0Var.o0(SlidingPaneLayout.class.getName());
            g0Var.O0(view);
            Object J = d1.J(view);
            if (J instanceof View) {
                g0Var.G0((View) J);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i10);
                if (!d(childAt) && childAt.getVisibility() == 0) {
                    d1.z0(childAt, 1);
                    g0Var.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!d(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final View f٤١١٩a;

        b(View view) {
            this.f٤١١٩a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f٤١١٩a.getParent() == SlidingPaneLayout.this) {
                this.f٤١١٩a.setLayerType(0, null);
                SlidingPaneLayout.this.g(this.f٤١١٩a);
            }
            SlidingPaneLayout.this.f٤١١٥s.remove(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class c extends c.AbstractC٠٢٢٦c {
        c() {
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            d dVar = (d) SlidingPaneLayout.this.f٤١٠٣g.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + SlidingPaneLayout.this.f٤١٠٣g.getWidth());
                return Math.max(Math.min(i10, width), width - SlidingPaneLayout.this.f٤١٠٦j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            return Math.min(Math.max(i10, paddingLeft), SlidingPaneLayout.this.f٤١٠٦j + paddingLeft);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f٤١٠٦j;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onEdgeDragStarted(int i10, int i11) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f٤١١١o.c(slidingPaneLayout.f٤١٠٣g, i11);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewCaptured(View view, int i10) {
            SlidingPaneLayout.this.p();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewDragStateChanged(int i10) {
            if (SlidingPaneLayout.this.f٤١١١o.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f٤١٠٤h == DownloadProgress.UNKNOWN_PROGRESS) {
                    slidingPaneLayout.r(slidingPaneLayout.f٤١٠٣g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f٤١٠٣g);
                    SlidingPaneLayout.this.f٤١١٢p = false;
                    return;
                }
                slidingPaneLayout.e(slidingPaneLayout.f٤١٠٣g);
                SlidingPaneLayout.this.f٤١١٢p = true;
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            SlidingPaneLayout.this.l(i10);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewReleased(View view, float f10, float f11) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.i()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                if (f10 < DownloadProgress.UNKNOWN_PROGRESS || (f10 == DownloadProgress.UNKNOWN_PROGRESS && SlidingPaneLayout.this.f٤١٠٤h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f٤١٠٦j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f٤١٠٣g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f10 > DownloadProgress.UNKNOWN_PROGRESS || (f10 == DownloadProgress.UNKNOWN_PROGRESS && SlidingPaneLayout.this.f٤١٠٤h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f٤١٠٦j;
                }
            }
            SlidingPaneLayout.this.f٤١١١o.P(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean tryCaptureView(View view, int i10) {
            if (SlidingPaneLayout.this.f٤١٠٧k) {
                return false;
            }
            return ((d) view.getLayoutParams()).f٤١٢٤b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface e {
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private boolean b(View view, int i10) {
        if (!this.f٤١١٣q && !q(DownloadProgress.UNKNOWN_PROGRESS, i10)) {
            return false;
        }
        this.f٤١١٢p = false;
        return true;
    }

    private void c(View view, float f10, int i10) {
        d dVar = (d) view.getLayoutParams();
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && i10 != 0) {
            int i11 = (((int) ((((-16777216) & i10) >>> 24) * f10)) << 24) | (i10 & 16777215);
            if (dVar.f٤١٢٦d == null) {
                dVar.f٤١٢٦d = new Paint();
            }
            dVar.f٤١٢٦d.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, dVar.f٤١٢٦d);
            }
            g(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = dVar.f٤١٢٦d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.f٤١١٥s.add(bVar);
            d1.i0(this, bVar);
        }
    }

    private boolean n(View view, int i10) {
        if (!this.f٤١١٣q && !q(1.0f, i10)) {
            return false;
        }
        this.f٤١١٢p = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o(float f10) {
        boolean z10;
        int childCount;
        float f11;
        int i10;
        boolean i11 = i();
        d dVar = (d) this.f٤١٠٣g.getLayoutParams();
        if (dVar.f٤١٢٥c) {
            if (i11) {
                i10 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
            } else {
                i10 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            }
            if (i10 <= 0) {
                z10 = true;
                childCount = getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt != this.f٤١٠٣g) {
                        float f12 = 1.0f - this.f٤١٠٥i;
                        int i13 = this.f٤١٠٨l;
                        this.f٤١٠٥i = f10;
                        int i14 = ((int) (f12 * i13)) - ((int) ((1.0f - f10) * i13));
                        if (i11) {
                            i14 = -i14;
                        }
                        childAt.offsetLeftAndRight(i14);
                        if (z10) {
                            float f13 = this.f٤١٠٥i;
                            if (i11) {
                                f11 = f13 - 1.0f;
                            } else {
                                f11 = 1.0f - f13;
                            }
                            c(childAt, f11, this.f٤٠٩٨b);
                        }
                    }
                }
            }
        }
        z10 = false;
        childCount = getChildCount();
        while (i12 < childCount) {
        }
    }

    private static boolean s(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    public boolean a() {
        return b(this.f٤١٠٣g, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof d) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f٤١١١o.n(true)) {
            if (!this.f٤١٠٢f) {
                this.f٤١١١o.a();
            } else {
                d1.h0(this);
            }
        }
    }

    void d(View view) {
        sendAccessibilityEvent(32);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i10;
        int i11;
        super.draw(canvas);
        if (i()) {
            drawable = this.f٤١٠٠d;
        } else {
            drawable = this.f٤٠٩٩c;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (i()) {
                i11 = view.getRight();
                i10 = intrinsicWidth + i11;
            } else {
                int left = view.getLeft();
                int i12 = left - intrinsicWidth;
                i10 = left;
                i11 = i12;
            }
            drawable.setBounds(i11, top, i10, bottom);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        d dVar = (d) view.getLayoutParams();
        int save = canvas.save();
        if (this.f٤١٠٢f && !dVar.f٤١٢٤b && this.f٤١٠٣g != null) {
            canvas.getClipBounds(this.f٤١١٤r);
            if (i()) {
                Rect rect = this.f٤١١٤r;
                rect.left = Math.max(rect.left, this.f٤١٠٣g.getRight());
            } else {
                Rect rect2 = this.f٤١١٤r;
                rect2.right = Math.min(rect2.right, this.f٤١٠٣g.getLeft());
            }
            canvas.clipRect(this.f٤١١٤r);
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        return drawChild;
    }

    void e(View view) {
        sendAccessibilityEvent(32);
    }

    void f(View view) {
    }

    void g(View view) {
        d1.C0(view, ((d) view.getLayoutParams()).f٤١٢٦d);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f٤٠٩٨b;
    }

    public int getParallaxDistance() {
        return this.f٤١٠٨l;
    }

    public int getSliderFadeColor() {
        return this.f٤٠٩٧a;
    }

    boolean h(View view) {
        if (view == null) {
            return false;
        }
        d dVar = (d) view.getLayoutParams();
        if (!this.f٤١٠٢f || !dVar.f٤١٢٥c || this.f٤١٠٤h <= DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        return true;
    }

    boolean i() {
        if (d1.D(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f٤١٠٢f && this.f٤١٠٤h != 1.0f) {
            return false;
        }
        return true;
    }

    public boolean k() {
        return this.f٤١٠٢f;
    }

    void l(int i10) {
        int paddingLeft;
        int i11;
        if (this.f٤١٠٣g == null) {
            this.f٤١٠٤h = DownloadProgress.UNKNOWN_PROGRESS;
            return;
        }
        boolean i12 = i();
        d dVar = (d) this.f٤١٠٣g.getLayoutParams();
        int width = this.f٤١٠٣g.getWidth();
        if (i12) {
            i10 = (getWidth() - i10) - width;
        }
        if (i12) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (i12) {
            i11 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
        } else {
            i11 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
        }
        float f10 = (i10 - (paddingLeft + i11)) / this.f٤١٠٦j;
        this.f٤١٠٤h = f10;
        if (this.f٤١٠٨l != 0) {
            o(f10);
        }
        if (dVar.f٤١٢٥c) {
            c(this.f٤١٠٣g, this.f٤١٠٤h, this.f٤٠٩٧a);
        }
        f(this.f٤١٠٣g);
    }

    public boolean m() {
        return n(this.f٤١٠٣g, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f٤١١٣q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f٤١١٣q = true;
        int size = this.f٤١١٥s.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) this.f٤١١٥s.get(i10)).run();
        }
        this.f٤١١٥s.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f٤١٠٢f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f٤١١٢p = !this.f٤١١١o.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f٤١٠٢f && (!this.f٤١٠٧k || actionMasked == 0)) {
            if (actionMasked != 3 && actionMasked != 1) {
                if (actionMasked != 0) {
                    if (actionMasked == 2) {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        float abs = Math.abs(x10 - this.f٤١٠٩m);
                        float abs2 = Math.abs(y10 - this.f٤١١٠n);
                        if (abs > this.f٤١١١o.A() && abs2 > abs) {
                            this.f٤١١١o.b();
                            this.f٤١٠٧k = true;
                            return false;
                        }
                    }
                } else {
                    this.f٤١٠٧k = false;
                    float x11 = motionEvent.getX();
                    float y11 = motionEvent.getY();
                    this.f٤١٠٩m = x11;
                    this.f٤١١٠n = y11;
                    if (this.f٤١١١o.F(this.f٤١٠٣g, (int) x11, (int) y11) && h(this.f٤١٠٣g)) {
                        z10 = true;
                        if (this.f٤١١١o.Q(motionEvent) && !z10) {
                            return false;
                        }
                    }
                }
                z10 = false;
                return this.f٤١١١o.Q(motionEvent) ? true : true;
            }
            this.f٤١١١o.b();
            return false;
        }
        this.f٤١١١o.b();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z11;
        float f10;
        boolean i19 = i();
        if (i19) {
            this.f٤١١١o.N(2);
        } else {
            this.f٤١١١o.N(1);
        }
        int i20 = i12 - i10;
        if (i19) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (i19) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f٤١١٣q) {
            if (this.f٤١٠٢f && this.f٤١١٢p) {
                f10 = 1.0f;
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            this.f٤١٠٤h = f10;
        }
        int i21 = paddingLeft;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt = getChildAt(i22);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f٤١٢٤b) {
                    int i23 = i20 - paddingRight;
                    int min = (Math.min(paddingLeft, i23 - this.f٤١٠١e) - i21) - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin);
                    this.f٤١٠٦j = min;
                    if (i19) {
                        i18 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                    } else {
                        i18 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    }
                    if (i21 + i18 + min + (measuredWidth / 2) > i23) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    dVar.f٤١٢٥c = z11;
                    int i24 = (int) (min * this.f٤١٠٤h);
                    i21 += i18 + i24;
                    this.f٤١٠٤h = i24 / min;
                    i14 = 0;
                } else if (this.f٤١٠٢f && (i15 = this.f٤١٠٨l) != 0) {
                    i14 = (int) ((1.0f - this.f٤١٠٤h) * i15);
                    i21 = paddingLeft;
                } else {
                    i21 = paddingLeft;
                    i14 = 0;
                }
                if (i19) {
                    i17 = (i20 - i21) + i14;
                    i16 = i17 - measuredWidth;
                } else {
                    i16 = i21 - i14;
                    i17 = i16 + measuredWidth;
                }
                childAt.layout(i16, paddingTop, i17, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft += childAt.getWidth();
            }
        }
        if (this.f٤١١٣q) {
            if (this.f٤١٠٢f) {
                if (this.f٤١٠٨l != 0) {
                    o(this.f٤١٠٤h);
                }
                if (((d) this.f٤١٠٣g.getLayoutParams()).f٤١٢٥c) {
                    c(this.f٤١٠٣g, this.f٤١٠٤h, this.f٤٠٩٧a);
                }
            } else {
                for (int i25 = 0; i25 < childCount; i25++) {
                    c(getChildAt(i25), DownloadProgress.UNKNOWN_PROGRESS, this.f٤٠٩٧a);
                }
            }
            r(this.f٤١٠٣g);
        }
        this.f٤١١٣q = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int paddingTop;
        int i12;
        int i13;
        boolean z10;
        int measuredWidth;
        int makeMeasureSpec;
        int i14;
        int i15;
        int makeMeasureSpec2;
        int makeMeasureSpec3;
        int makeMeasureSpec4;
        boolean z11;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (mode2 == 0) {
            if (isInEditMode()) {
                if (mode2 == 0) {
                    mode2 = Integer.MIN_VALUE;
                    size2 = 300;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
        boolean z12 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i12 = 0;
                paddingTop = 0;
            } else {
                i12 = (size2 - getPaddingTop()) - getPaddingBottom();
                paddingTop = i12;
            }
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i12 = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f٤١٠٣g = null;
        int i16 = paddingLeft;
        int i17 = 0;
        boolean z13 = false;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        while (true) {
            i13 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            d dVar = (d) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                dVar.f٤١٢٥c = z12;
            } else {
                float f11 = dVar.f٤١٢٣a;
                if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                    f10 += f11;
                    if (((ViewGroup.MarginLayoutParams) dVar).width == 0) {
                    }
                }
                int i18 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                int i19 = ((ViewGroup.MarginLayoutParams) dVar).width;
                if (i19 == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, Integer.MIN_VALUE);
                } else if (i19 == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i18, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                }
                int i20 = ((ViewGroup.MarginLayoutParams) dVar).height;
                if (i20 == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (i20 == -1) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                }
                childAt.measure(makeMeasureSpec3, makeMeasureSpec4);
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i12) {
                    i12 = Math.min(measuredHeight, paddingTop);
                }
                i16 -= measuredWidth2;
                if (i16 < 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                dVar.f٤١٢٤b = z11;
                z13 |= z11;
                if (z11) {
                    this.f٤١٠٣g = childAt;
                }
            }
            i17++;
            z12 = false;
        }
        if (z13 || f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            int i21 = paddingLeft - this.f٤١٠١e;
            int i22 = 0;
            while (i22 < childCount) {
                View childAt2 = getChildAt(i22);
                if (childAt2.getVisibility() != i13) {
                    d dVar2 = (d) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i13) {
                        if (((ViewGroup.MarginLayoutParams) dVar2).width == 0 && dVar2.f٤١٢٣a > DownloadProgress.UNKNOWN_PROGRESS) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            measuredWidth = 0;
                        } else {
                            measuredWidth = childAt2.getMeasuredWidth();
                        }
                        if (z13 && childAt2 != this.f٤١٠٣g) {
                            if (((ViewGroup.MarginLayoutParams) dVar2).width < 0 && (measuredWidth > i21 || dVar2.f٤١٢٣a > DownloadProgress.UNKNOWN_PROGRESS)) {
                                if (z10) {
                                    int i23 = ((ViewGroup.MarginLayoutParams) dVar2).height;
                                    if (i23 == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i15 = 1073741824;
                                    } else if (i23 == -1) {
                                        i15 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i15 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i23, 1073741824);
                                    }
                                } else {
                                    i15 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i21, i15), makeMeasureSpec2);
                            }
                        } else if (dVar2.f٤١٢٣a > DownloadProgress.UNKNOWN_PROGRESS) {
                            if (((ViewGroup.MarginLayoutParams) dVar2).width == 0) {
                                int i24 = ((ViewGroup.MarginLayoutParams) dVar2).height;
                                if (i24 == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (i24 == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                }
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z13) {
                                int i25 = paddingLeft - (((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin);
                                i14 = i21;
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i25, 1073741824);
                                if (measuredWidth != i25) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                                i22++;
                                i21 = i14;
                                i13 = 8;
                            } else {
                                i14 = i21;
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((dVar2.f٤١٢٣a * Math.max(0, i16)) / f10)), 1073741824), makeMeasureSpec);
                                i22++;
                                i21 = i14;
                                i13 = 8;
                            }
                        }
                    }
                }
                i14 = i21;
                i22++;
                i21 = i14;
                i13 = 8;
            }
        }
        setMeasuredDimension(size, i12 + getPaddingTop() + getPaddingBottom());
        this.f٤١٠٢f = z13;
        if (this.f٤١١١o.B() != 0 && !z13) {
            this.f٤١١١o.a();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f٤١١٦a) {
            m();
        } else {
            a();
        }
        this.f٤١١٢p = savedState.f٤١١٦a;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (k()) {
            z10 = j();
        } else {
            z10 = this.f٤١١٢p;
        }
        savedState.f٤١١٦a = z10;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.f٤١١٣q = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f٤١٠٢f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f٤١١١o.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && h(this.f٤١٠٣g)) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                float f10 = x10 - this.f٤١٠٩m;
                float f11 = y10 - this.f٤١١٠n;
                int A = this.f٤١١١o.A();
                if ((f10 * f10) + (f11 * f11) < A * A && this.f٤١١١o.F(this.f٤١٠٣g, (int) x10, (int) y10)) {
                    b(this.f٤١٠٣g, 0);
                }
            }
        } else {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f٤١٠٩m = x11;
            this.f٤١١٠n = y11;
        }
        return true;
    }

    void p() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    boolean q(float f10, int i10) {
        int paddingLeft;
        if (!this.f٤١٠٢f) {
            return false;
        }
        boolean i11 = i();
        d dVar = (d) this.f٤١٠٣g.getLayoutParams();
        if (i11) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + (f10 * this.f٤١٠٦j)) + this.f٤١٠٣g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + (f10 * this.f٤١٠٦j));
        }
        s2.c cVar = this.f٤١١١o;
        View view = this.f٤١٠٣g;
        if (!cVar.R(view, paddingLeft, view.getTop())) {
            return false;
        }
        p();
        d1.h0(this);
        return true;
    }

    void r(View view) {
        int paddingLeft;
        int width;
        int i10;
        int i11;
        int i12;
        int i13;
        View childAt;
        int i14;
        boolean z10;
        int i15;
        int i16;
        View view2 = view;
        boolean i17 = i();
        if (i17) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (i17) {
            width = getPaddingLeft();
        } else {
            width = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 != null && s(view)) {
            i10 = view.getLeft();
            i11 = view.getRight();
            i12 = view.getTop();
            i13 = view.getBottom();
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        int childCount = getChildCount();
        int i18 = 0;
        while (i18 < childCount && (childAt = getChildAt(i18)) != view2) {
            if (childAt.getVisibility() == 8) {
                z10 = i17;
            } else {
                if (i17) {
                    i14 = width;
                } else {
                    i14 = paddingLeft;
                }
                int max = Math.max(i14, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                z10 = i17;
                if (i17) {
                    i15 = paddingLeft;
                } else {
                    i15 = width;
                }
                int min = Math.min(i15, childAt.getRight());
                int min2 = Math.min(height, childAt.getBottom());
                if (max >= i10 && max2 >= i12 && min <= i11 && min2 <= i13) {
                    i16 = 4;
                } else {
                    i16 = 0;
                }
                childAt.setVisibility(i16);
            }
            i18++;
            view2 = view;
            i17 = z10;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        boolean z10;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f٤١٠٢f) {
            if (view == this.f٤١٠٣g) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٤١١٢p = z10;
        }
    }

    public void setCoveredFadeColor(int i10) {
        this.f٤٠٩٨b = i10;
    }

    public void setPanelSlideListener(e eVar) {
    }

    public void setParallaxDistance(int i10) {
        this.f٤١٠٨l = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f٤٠٩٩c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f٤١٠٠d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i10) {
        setShadowDrawable(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setSliderFadeColor(int i10) {
        this.f٤٠٩٧a = i10;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: e, reason: collision with root package name */
        private static final int[] f٤١٢٢e = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f٤١٢٣a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٤١٢٤b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٤١٢٥c;

        /* renamed from: d, reason: collision with root package name */
        Paint f٤١٢٦d;

        public d() {
            super(-1, -1);
            this.f٤١٢٣a = DownloadProgress.UNKNOWN_PROGRESS;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٤١٢٣a = DownloadProgress.UNKNOWN_PROGRESS;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f٤١٢٣a = DownloadProgress.UNKNOWN_PROGRESS;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٤١٢٣a = DownloadProgress.UNKNOWN_PROGRESS;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f٤١٢٢e);
            this.f٤١٢٣a = obtainStyledAttributes.getFloat(0, DownloadProgress.UNKNOWN_PROGRESS);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٤٠٩٧a = -858993460;
        this.f٤١١٣q = true;
        this.f٤١١٤r = new Rect();
        this.f٤١١٥s = new ArrayList();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f٤١٠١e = (int) ((32.0f * f10) + 0.5f);
        setWillNotDraw(false);
        d1.q0(this, new a());
        d1.z0(this, 1);
        s2.c o10 = s2.c.o(this, 0.5f, new c());
        this.f٤١١١o = o10;
        o10.O(f10 * 400.0f);
    }
}
