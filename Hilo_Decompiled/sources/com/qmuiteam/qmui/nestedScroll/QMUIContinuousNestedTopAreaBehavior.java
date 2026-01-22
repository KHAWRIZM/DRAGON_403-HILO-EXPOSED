package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedTopAreaBehavior extends QMUIViewOffsetBehavior<View> {

    /* renamed from: d, reason: collision with root package name */
    private final b f١٢٧٨٣d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f١٢٧٨٤e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٢٧٨٥f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٧٨٦g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٧٨٧h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢٧٨٨i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f١٢٧٨٩j;

    /* renamed from: k, reason: collision with root package name */
    private a f١٢٧٩٠k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٢٧٩١l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٢٧٩٢m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٢٧٩٣n;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
        void c();

        void d();

        void g();

        void i();

        void j(int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f١٢٧٩٤a;

        /* renamed from: b, reason: collision with root package name */
        OverScroller f١٢٧٩٥b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f١٢٧٩٦c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٢٧٩٧d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f١٢٧٩٨e;

        /* renamed from: f, reason: collision with root package name */
        private CoordinatorLayout f١٢٧٩٩f;

        /* renamed from: g, reason: collision with root package name */
        private View f١٢٨٠٠g;

        b(Context context) {
            Interpolator interpolator = yb.a.f١٩٢٣٨h;
            this.f١٢٧٩٦c = interpolator;
            this.f١٢٧٩٧d = false;
            this.f١٢٧٩٨e = false;
            this.f١٢٧٩٥b = new OverScroller(context, interpolator);
        }

        private void b() {
            if (this.f١٢٨٠٠g != null) {
                this.f١٢٧٩٩f.removeCallbacks(this);
                d1.i0(this.f١٢٨٠٠g, this);
            }
        }

        private void c() {
            if (QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٠k != null && QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٢m) {
                QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٠k.d();
            }
            QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٢m = false;
        }

        private void d(CoordinatorLayout coordinatorLayout, View view) {
            QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٢m = true;
            if (QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٠k != null) {
                QMUIContinuousNestedTopAreaBehavior.this.f١٢٧٩٠k.g();
            }
            this.f١٢٧٩٩f = coordinatorLayout;
            this.f١٢٨٠٠g = view;
            this.f١٢٧٩٤a = 0;
            Interpolator interpolator = this.f١٢٧٩٦c;
            Interpolator interpolator2 = yb.a.f١٩٢٣٨h;
            if (interpolator != interpolator2) {
                this.f١٢٧٩٦c = interpolator2;
                this.f١٢٧٩٥b = new OverScroller(this.f١٢٧٩٩f.getContext(), interpolator2);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, int i10) {
            d(coordinatorLayout, view);
            this.f١٢٧٩٥b.fling(0, 0, 0, i10, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f١٢٧٩٧d) {
                this.f١٢٧٩٨e = true;
            } else {
                b();
            }
        }

        public void f() {
            View view = this.f١٢٨٠٠g;
            if (view != null) {
                view.removeCallbacks(this);
            }
            this.f١٢٧٩٥b.abortAnimation();
            this.f١٢٨٠٠g = null;
            this.f١٢٧٩٩f = null;
            c();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٢٧٩٨e = false;
            this.f١٢٧٩٧d = true;
            OverScroller overScroller = this.f١٢٧٩٥b;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i10 = currY - this.f١٢٧٩٤a;
                this.f١٢٧٩٤a = currY;
                CoordinatorLayout coordinatorLayout = this.f١٢٧٩٩f;
                if (coordinatorLayout != null && this.f١٢٨٠٠g != null) {
                    if (coordinatorLayout instanceof QMUIContinuousNestedScrollLayout) {
                        QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = (QMUIContinuousNestedScrollLayout) coordinatorLayout;
                        if ((i10 > 0 && qMUIContinuousNestedScrollLayout.getCurrentScroll() >= qMUIContinuousNestedScrollLayout.getScrollRange()) || (i10 < 0 && qMUIContinuousNestedScrollLayout.getCurrentScroll() <= 0)) {
                            this.f١٢٧٩٥b.abortAnimation();
                        }
                    }
                    QMUIContinuousNestedTopAreaBehavior.this.T(this.f١٢٧٩٩f, this.f١٢٨٠٠g, i10);
                    e();
                }
            }
            this.f١٢٧٩٧d = false;
            if (this.f١٢٧٩٨e) {
                b();
                return;
            }
            this.f١٢٧٩٩f = null;
            this.f١٢٨٠٠g = null;
            c();
        }
    }

    public QMUIContinuousNestedTopAreaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٧٨٤e = new int[2];
        this.f١٢٧٨٦g = -1;
        this.f١٢٧٨٨i = -1;
        this.f١٢٧٩١l = false;
        this.f١٢٧٩٢m = false;
        this.f١٢٧٩٣n = true;
        this.f١٢٧٨٣d = new b(context);
    }

    private void R() {
        if (this.f١٢٧٨٩j == null) {
            this.f١٢٧٨٩j = VelocityTracker.obtain();
        }
    }

    private View S(CoordinatorLayout coordinatorLayout) {
        for (int i10 = 0; i10 < coordinatorLayout.getChildCount(); i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if (childAt instanceof com.qmuiteam.qmui.nestedScroll.a) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if (r0 != 3) goto L٤٧;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f١٢٧٨٨i < 0) {
            this.f١٢٧٨٨i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f١٢٧٨٦g);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y10 = (int) motionEvent.getY(findPointerIndex);
                    int i10 = this.f١٢٧٨٧h - y10;
                    if (!this.f١٢٧٨٥f && Math.abs(i10) > this.f١٢٧٨٨i) {
                        this.f١٢٧٨٥f = true;
                        a aVar = this.f١٢٧٩٠k;
                        if (aVar != null) {
                            aVar.c();
                        }
                        i10 = i10 > 0 ? i10 - this.f١٢٧٨٨i : i10 + this.f١٢٧٨٨i;
                    }
                    if (this.f١٢٧٨٥f) {
                        this.f١٢٧٨٧h = y10;
                        T(coordinatorLayout, view, i10);
                    }
                }
            } else {
                this.f١٢٧٩١l = false;
                a aVar2 = this.f١٢٧٩٠k;
                if (aVar2 != null) {
                    aVar2.i();
                }
                VelocityTracker velocityTracker = this.f١٢٧٨٩j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.f١٢٧٨٩j.computeCurrentVelocity(1000);
                    this.f١٢٧٨٣d.a(coordinatorLayout, view, -((int) (this.f١٢٧٨٩j.getYVelocity(this.f١٢٧٨٦g) + 0.5f)));
                }
            }
            if (this.f١٢٧٩١l) {
                this.f١٢٧٩١l = false;
                a aVar3 = this.f١٢٧٩٠k;
                if (aVar3 != null) {
                    aVar3.i();
                }
            }
            this.f١٢٧٨٥f = false;
            this.f١٢٧٨٦g = -1;
            VelocityTracker velocityTracker2 = this.f١٢٧٨٩j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f١٢٧٨٩j = null;
            }
        } else {
            this.f١٢٧٨٣d.f();
            this.f١٢٧٩١l = true;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!coordinatorLayout.H(view, x10, y11)) {
                return false;
            }
            this.f١٢٧٨٧h = y11;
            this.f١٢٧٨٦g = motionEvent.getPointerId(0);
            R();
        }
        VelocityTracker velocityTracker3 = this.f١٢٧٨٩j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
    public boolean N(int i10) {
        boolean N = super.N(i10);
        a aVar = this.f١٢٧٩٠k;
        if (aVar != null) {
            aVar.j(i10);
        }
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void T(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int[] iArr = this.f١٢٧٨٤e;
        iArr[0] = 0;
        iArr[1] = 0;
        w(coordinatorLayout, view, view, 0, i10, iArr, 0);
        int i11 = i10 - this.f١٢٧٨٤e[1];
        if (view instanceof c) {
            i11 = ((c) view).a(i11);
        }
        int i12 = i11;
        y(coordinatorLayout, view, view, 0, i10 - i12, 0, i12, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        this.f١٢٧٨٣d.f();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f١٢٧٨٨i < 0) {
            this.f١٢٧٨٨i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f١٢٧٨٥f) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (actionIndex != 0 && !coordinatorLayout.H(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && coordinatorLayout.H(view, (int) motionEvent.getX(actionIndex), (int) motionEvent.getY(actionIndex))) {
                                return true;
                            }
                            return false;
                        }
                    }
                } else {
                    int i10 = this.f١٢٧٨٦g;
                    if (i10 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i10)) != -1) {
                        int y10 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y10 - this.f١٢٧٨٧h) > this.f١٢٧٨٨i) {
                            this.f١٢٧٨٥f = true;
                            if ((view instanceof WebView) || (view instanceof QMUIContinuousNestedTopDelegateLayout)) {
                                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                                obtain.offsetLocation(-view.getLeft(), -view.getTop());
                                if (this.f١٢٧٩٣n) {
                                    obtain.setAction(2);
                                } else {
                                    obtain.setAction(3);
                                }
                                view.dispatchTouchEvent(obtain);
                                obtain.recycle();
                            }
                            this.f١٢٧٨٧h = y10;
                            a aVar = this.f١٢٧٩٠k;
                            if (aVar != null) {
                                aVar.c();
                            }
                        }
                    }
                }
            }
            this.f١٢٧٩١l = false;
            this.f١٢٧٨٥f = false;
            this.f١٢٧٨٦g = -1;
            VelocityTracker velocityTracker = this.f١٢٧٨٩j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f١٢٧٨٩j = null;
            }
        } else {
            this.f١٢٧٨٣d.f();
            this.f١٢٧٩١l = true;
            this.f١٢٧٨٥f = false;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (coordinatorLayout.H(view, x10, y11)) {
                this.f١٢٧٨٧h = y11;
                this.f١٢٧٨٦g = motionEvent.getPointerId(0);
                R();
            }
        }
        VelocityTracker velocityTracker2 = this.f١٢٧٨٩j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.f١٢٧٨٥f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        int i14 = view.getLayoutParams().height;
        int size = View.MeasureSpec.getSize(i12);
        if (i14 == -1) {
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.P(view, i10, i11, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i13);
            return true;
        }
        coordinatorLayout.P(view, i10, i11, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE), i13);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
        int height;
        int height2;
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        if (view2 == view) {
            if (i11 < 0) {
                if (view.getTop() <= i11) {
                    N((view.getTop() - i11) - K());
                    iArr[1] = iArr[1] + i11;
                    return;
                } else {
                    if (view.getTop() < 0) {
                        int top = view.getTop();
                        N(0 - K());
                        iArr[1] = iArr[1] + top;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i11 > 0 && (view2 instanceof com.qmuiteam.qmui.nestedScroll.a)) {
            int contentHeight = ((com.qmuiteam.qmui.nestedScroll.a) view2).getContentHeight();
            if (contentHeight != -1) {
                height = coordinatorLayout.getHeight() - contentHeight;
                height2 = view.getHeight();
            } else {
                height = coordinatorLayout.getHeight() - view.getHeight();
                height2 = view2.getHeight();
            }
            int i13 = height - height2;
            if (view.getTop() - i11 >= i13) {
                N((view.getTop() - i11) - K());
                iArr[1] = iArr[1] + i11;
            } else if (view.getTop() > i13) {
                int top2 = view.getTop() - i13;
                N(i13);
                iArr[1] = iArr[1] + top2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void y(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14) {
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        boolean z10 = false;
        if (view2 == view) {
            if (i13 > 0) {
                View S = S(coordinatorLayout);
                if (S != 0 && S.getVisibility() != 8) {
                    com.qmuiteam.qmui.nestedScroll.a aVar = (com.qmuiteam.qmui.nestedScroll.a) S;
                    int contentHeight = aVar.getContentHeight();
                    int height = coordinatorLayout.getHeight();
                    if (contentHeight != -1) {
                        height = (coordinatorLayout.getHeight() + S.getHeight()) - contentHeight;
                    } else {
                        z10 = true;
                    }
                    if (S.getBottom() - height > i13) {
                        N((view2.getTop() - i13) - K());
                        return;
                    }
                    if (S.getBottom() - height > 0) {
                        int bottom = S.getBottom() - height;
                        N((view2.getTop() - bottom) - K());
                        if (i13 != Integer.MAX_VALUE) {
                            i13 -= bottom;
                        }
                    }
                    if (z10) {
                        aVar.a(i13);
                        return;
                    }
                    return;
                }
                int height2 = coordinatorLayout.getHeight();
                if (view2.getBottom() - height2 >= i13) {
                    N((view2.getTop() - i13) - K());
                    return;
                } else {
                    if (view2.getBottom() - height2 > 0) {
                        N((view2.getTop() - (view2.getBottom() - height2)) - K());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i13 < 0) {
            if (view.getTop() <= i13) {
                N((view.getTop() - i13) - K());
                return;
            }
            if (view.getTop() < 0) {
                int top = view.getTop();
                N(0 - K());
                if (i13 != Integer.MIN_VALUE) {
                    i11 = i13 - top;
                }
                i13 = i11;
            }
            if (view instanceof c) {
                ((c) view).a(i13);
            }
        }
    }
}
