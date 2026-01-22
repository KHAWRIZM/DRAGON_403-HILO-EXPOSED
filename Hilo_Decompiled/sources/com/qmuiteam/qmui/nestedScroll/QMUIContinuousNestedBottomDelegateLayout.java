package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.d0;
import androidx.core.view.d1;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.i0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.nestedScroll.b;
import ic.k;
import ic.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class QMUIContinuousNestedBottomDelegateLayout extends QMUIFrameLayout implements d0, f0, com.qmuiteam.qmui.nestedScroll.a {

    /* renamed from: c, reason: collision with root package name */
    private final i0 f١٢٧٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private final e0 f١٢٧٥٣d;

    /* renamed from: e, reason: collision with root package name */
    private View f١٢٧٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private View f١٢٧٥٥f;

    /* renamed from: g, reason: collision with root package name */
    private l f١٢٧٥٦g;

    /* renamed from: h, reason: collision with root package name */
    private l f١٢٧٥٧h;

    /* renamed from: i, reason: collision with root package name */
    private b.a f١٢٧٥٨i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٢٧٥٩j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٢٧٦٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٧٦١l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٢٧٦٢m;

    /* renamed from: n, reason: collision with root package name */
    private VelocityTracker f١٢٧٦٣n;

    /* renamed from: o, reason: collision with root package name */
    private final b f١٢٧٦٤o;

    /* renamed from: p, reason: collision with root package name */
    private final int[] f١٢٧٦٥p;

    /* renamed from: q, reason: collision with root package name */
    private final int[] f١٢٧٦٦q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f١٢٧٦٧r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٢٧٦٨s;

    /* renamed from: t, reason: collision with root package name */
    private Runnable f١٢٧٦٩t;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIContinuousNestedBottomDelegateLayout.this.h();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f١٢٧٧١a;

        /* renamed from: b, reason: collision with root package name */
        OverScroller f١٢٧٧٢b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f١٢٧٧٣c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٢٧٧٤d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٢٧٧٥e;

        b() {
            Interpolator interpolator = yb.a.f١٩٢٣٨h;
            this.f١٢٧٧٣c = interpolator;
            this.f١٢٧٧٤d = false;
            this.f١٢٧٧٥e = false;
            this.f١٢٧٧٢b = new OverScroller(QMUIContinuousNestedBottomDelegateLayout.this.getContext(), interpolator);
        }

        private void b() {
            QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            d1.i0(QMUIContinuousNestedBottomDelegateLayout.this, this);
        }

        public void a(int i10) {
            QMUIContinuousNestedBottomDelegateLayout.this.t(2, 1);
            this.f١٢٧٧١a = 0;
            Interpolator interpolator = this.f١٢٧٧٣c;
            Interpolator interpolator2 = yb.a.f١٩٢٣٨h;
            if (interpolator != interpolator2) {
                this.f١٢٧٧٣c = interpolator2;
                this.f١٢٧٧٢b = new OverScroller(QMUIContinuousNestedBottomDelegateLayout.this.getContext(), interpolator2);
            }
            this.f١٢٧٧٢b.fling(0, 0, 0, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        void c() {
            if (this.f١٢٧٧٤d) {
                this.f١٢٧٧٥e = true;
            } else {
                b();
            }
        }

        public void d() {
            QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            this.f١٢٧٧٢b.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٢٧٧٥e = false;
            this.f١٢٧٧٤d = true;
            OverScroller overScroller = this.f١٢٧٧٢b;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i10 = currY - this.f١٢٧٧١a;
                this.f١٢٧٧١a = currY;
                com.qmuiteam.qmui.nestedScroll.a aVar = (com.qmuiteam.qmui.nestedScroll.a) QMUIContinuousNestedBottomDelegateLayout.this.f١٢٧٥٥f;
                if (i10 > 0 && aVar.getCurrentScroll() >= aVar.getScrollOffsetRange()) {
                    d();
                } else {
                    if (!QMUIContinuousNestedBottomDelegateLayout.this.f١٢٧٥٣d.l(1)) {
                        QMUIContinuousNestedBottomDelegateLayout.this.t(2, 1);
                    }
                    QMUIContinuousNestedBottomDelegateLayout.this.a(i10);
                    c();
                }
            }
            this.f١٢٧٧٤d = false;
            if (this.f١٢٧٧٥e) {
                b();
            } else {
                QMUIContinuousNestedBottomDelegateLayout.this.u(1);
            }
        }
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context) {
        this(context, null);
    }

    private int getMiniOffset() {
        int contentHeight = ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getContentHeight();
        int headerStickyHeight = ((-this.f١٢٧٥٤e.getHeight()) - ((FrameLayout.LayoutParams) this.f١٢٧٥٤e.getLayoutParams()).bottomMargin) + getHeaderStickyHeight();
        if (contentHeight != -1) {
            return Math.min(headerStickyHeight + (this.f١٢٧٥٥f.getHeight() - contentHeight), 0);
        }
        return headerStickyHeight;
    }

    private void m() {
        if (this.f١٢٧٦٣n == null) {
            this.f١٢٧٦٣n = VelocityTracker.obtain();
        }
    }

    private boolean o(int i10, int i11) {
        k.c(this, this.f١٢٧٥٤e, this.f١٢٧٦٧r);
        return this.f١٢٧٦٧r.contains(i10, i11);
    }

    private int p(int i10) {
        int i11;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f١٢٧٥٤e.getLayoutParams();
        int miniOffset = getMiniOffset();
        if (i10 > 0) {
            i11 = Math.min(this.f١٢٧٥٤e.getTop() - miniOffset, i10);
        } else if (i10 < 0) {
            i11 = Math.max(this.f١٢٧٥٤e.getTop() - layoutParams.topMargin, i10);
        } else {
            i11 = 0;
        }
        if (i11 != 0) {
            l lVar = this.f١٢٧٥٦g;
            lVar.h(lVar.d() - i11);
            l lVar2 = this.f١٢٧٥٧h;
            lVar2.h(lVar2.d() - i11);
        }
        this.f١٢٧٥٨i.a(-this.f١٢٧٥٦g.d(), this.f١٢٧٥٤e.getHeight() + ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getScrollOffsetRange());
        return i10 - i11;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public void a(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            p(i10);
            ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).a(Integer.MAX_VALUE);
        } else if (i10 == Integer.MIN_VALUE) {
            ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).a(Integer.MIN_VALUE);
            p(i10);
        } else {
            ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).a(i10);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f١٢٧٥٣d.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f١٢٧٥٣d.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return k(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return l(i10, i11, i12, i13, iArr, 0);
    }

    protected int getContentBottomMargin() {
        return 0;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getContentHeight() {
        int contentHeight = ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getContentHeight();
        if (contentHeight == -1 || contentHeight > this.f١٢٧٥٥f.getHeight()) {
            return -1;
        }
        int contentBottomMargin = getContentBottomMargin();
        if (this.f١٢٧٥٤e.getHeight() + contentHeight + contentBottomMargin > getHeight()) {
            return -1;
        }
        return this.f١٢٧٥٤e.getHeight() + contentHeight + contentBottomMargin;
    }

    public View getContentView() {
        return this.f١٢٧٥٥f;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getCurrentScroll() {
        return (-this.f١٢٧٥٦g.d()) + ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getCurrentScroll();
    }

    protected int getHeaderHeightLayoutParam() {
        return -2;
    }

    protected int getHeaderStickyHeight() {
        return 0;
    }

    public View getHeaderView() {
        return this.f١٢٧٥٤e;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f١٢٧٥٢c.a();
    }

    public int getOffsetCurrent() {
        return -this.f١٢٧٥٦g.d();
    }

    public int getOffsetRange() {
        return -getMiniOffset();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public int getScrollOffsetRange() {
        if (getContentHeight() != -1) {
            return 0;
        }
        return (this.f١٢٧٥٤e.getHeight() - getHeaderStickyHeight()) + ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getScrollOffsetRange();
    }

    public void h() {
        int offsetCurrent = getOffsetCurrent();
        int offsetRange = getOffsetRange();
        com.qmuiteam.qmui.nestedScroll.a aVar = (com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f;
        if (offsetCurrent < offsetRange && aVar.getCurrentScroll() > 0) {
            aVar.a(Integer.MIN_VALUE);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return n(0);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f١٢٧٥٣d.m();
    }

    public boolean k(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.f١٢٧٥٣d.d(i10, i11, iArr, iArr2, i12);
    }

    public boolean l(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return this.f١٢٧٥٣d.g(i10, i11, i12, i13, iArr, i14);
    }

    public boolean n(int i10) {
        return this.f١٢٧٥٣d.l(i10);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f١٢٧٦٢m < 0) {
            this.f١٢٧٦٢m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f١٢٧٥٩j) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (actionIndex != 0 && !o((int) motionEvent.getX(), (int) motionEvent.getY()) && o((int) motionEvent.getX(actionIndex), (int) motionEvent.getY(actionIndex))) {
                                return true;
                            }
                            return false;
                        }
                    }
                } else {
                    int i10 = this.f١٢٧٦٠k;
                    if (i10 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i10)) != -1) {
                        int y10 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y10 - this.f١٢٧٦١l) > this.f١٢٧٦٢m) {
                            this.f١٢٧٥٩j = true;
                            this.f١٢٧٦١l = y10;
                        }
                    }
                }
            }
            this.f١٢٧٥٩j = false;
            this.f١٢٧٦٠k = -1;
            u(0);
        } else {
            this.f١٢٧٦٤o.d();
            this.f١٢٧٥٩j = false;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (o(x10, y11)) {
                this.f١٢٧٦١l = y11;
                this.f١٢٧٦٠k = motionEvent.getPointerId(0);
                t(2, 0);
            }
        }
        return this.f١٢٧٥٩j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.f١٢٧٥٤e;
        view.layout(0, 0, view.getMeasuredWidth(), this.f١٢٧٥٤e.getMeasuredHeight());
        int bottom = this.f١٢٧٥٤e.getBottom();
        View view2 = this.f١٢٧٥٥f;
        view2.layout(0, bottom, view2.getMeasuredWidth(), this.f١٢٧٥٥f.getMeasuredHeight() + bottom);
        this.f١٢٧٥٦g.e();
        this.f١٢٧٥٧h.e();
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f١٢٧٥٥f.measure(i10, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i11) - getHeaderStickyHeight()) - getContentBottomMargin(), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!z10) {
            this.f١٢٧٦٤o.a((int) f11);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        k(i10, i11, iArr, null, i12);
        int i13 = iArr[1];
        int i14 = i11 - i13;
        if (i14 > 0) {
            iArr[1] = i13 + (i14 - p(i14));
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        int p10 = p(i13);
        l(0, i13 - p10, 0, p10, null, i14);
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        this.f١٢٧٥٢c.c(view, view2, i10, i11);
        t(2, i11);
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        this.f١٢٧٥٢c.e(view, i10);
        u(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r2 != 3) goto L٥٠;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f١٢٧٦٢m < 0) {
            this.f١٢٧٦٢m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 0) {
            this.f١٢٧٦٨s = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, this.f١٢٧٦٨s);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f١٢٧٦٠k);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y10 = (int) motionEvent.getY(findPointerIndex);
                    int i10 = this.f١٢٧٦١l - y10;
                    if (!this.f١٢٧٥٩j) {
                        int abs = Math.abs(i10);
                        int i11 = this.f١٢٧٦٢m;
                        if (abs > i11) {
                            this.f١٢٧٥٩j = true;
                            i10 = i10 > 0 ? i10 - i11 : i10 + i11;
                        }
                    }
                    if (this.f١٢٧٥٩j) {
                        this.f١٢٧٦١l = y10;
                        if (i10 < 0 && ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).getCurrentScroll() > 0) {
                            return true;
                        }
                        int[] iArr = this.f١٢٧٦٥p;
                        iArr[0] = 0;
                        iArr[1] = 0;
                        if (dispatchNestedPreScroll(0, i10, iArr, this.f١٢٧٦٦q)) {
                            i10 -= this.f١٢٧٦٥p[1];
                            int i12 = this.f١٢٧٦٦q[1];
                            this.f١٢٧٦١l = y10 - i12;
                            obtain.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, i12);
                            this.f١٢٧٦٨s += this.f١٢٧٦٦q[1];
                        }
                        int p10 = p(i10);
                        if (l(0, i10 - p10, 0, p10, this.f١٢٧٦٦q, 0)) {
                            int i13 = this.f١٢٧٦٦q[1];
                            this.f١٢٧٦١l = y10 - i13;
                            obtain.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, i13);
                            this.f١٢٧٦٨s += this.f١٢٧٦٦q[1];
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.f١٢٧٦٣n;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(obtain);
                    this.f١٢٧٦٣n.computeCurrentVelocity(1000);
                    this.f١٢٧٦٤o.a(-((int) (this.f١٢٧٦٣n.getYVelocity(this.f١٢٧٦٠k) + 0.5f)));
                }
            }
            this.f١٢٧٥٩j = false;
            this.f١٢٧٦٠k = -1;
            VelocityTracker velocityTracker2 = this.f١٢٧٦٣n;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f١٢٧٦٣n = null;
            }
            u(0);
        } else {
            this.f١٢٧٦٤o.d();
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!o(x10, y11)) {
                return false;
            }
            this.f١٢٧٦١l = y11;
            this.f١٢٧٦٠k = motionEvent.getPointerId(0);
            m();
            t(2, 0);
        }
        VelocityTracker velocityTracker3 = this.f١٢٧٦٣n;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    protected abstract View q();

    protected abstract View r();

    public void s() {
        removeCallbacks(this.f١٢٧٦٩t);
        post(this.f١٢٧٦٩t);
    }

    @Override // android.view.View, androidx.core.view.d0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f١٢٧٥٣d.n(z10);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return t(i10, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        u(0);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.a
    public void stopScroll() {
        ((com.qmuiteam.qmui.nestedScroll.a) this.f١٢٧٥٥f).stopScroll();
    }

    public boolean t(int i10, int i11) {
        return this.f١٢٧٥٣d.q(i10, i11);
    }

    public void u(int i10) {
        this.f١٢٧٥٣d.s(i10);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٧٦٠k = -1;
        this.f١٢٧٦٢m = -1;
        this.f١٢٧٦٥p = new int[2];
        this.f١٢٧٦٦q = new int[2];
        this.f١٢٧٦٧r = new Rect();
        this.f١٢٧٦٨s = 0;
        this.f١٢٧٦٩t = new a();
        this.f١٢٧٥٢c = new i0(this);
        this.f١٢٧٥٣d = new e0(this);
        d1.D0(this, true);
        this.f١٢٧٥٤e = r();
        View q10 = q();
        this.f١٢٧٥٥f = q10;
        if (q10 instanceof com.qmuiteam.qmui.nestedScroll.a) {
            addView(this.f١٢٧٥٤e, new FrameLayout.LayoutParams(-1, getHeaderHeightLayoutParam()));
            addView(this.f١٢٧٥٥f, new FrameLayout.LayoutParams(-1, -1));
            this.f١٢٧٥٦g = new l(this.f١٢٧٥٤e);
            this.f١٢٧٥٧h = new l(this.f١٢٧٥٥f);
            this.f١٢٧٦٤o = new b();
            return;
        }
        throw new IllegalStateException("the view create by onCreateContentView() should implement from IQMUIContinuousNestedBottomView");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }
}
