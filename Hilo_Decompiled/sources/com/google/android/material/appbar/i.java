package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class i extends k {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f٨٢١٥d;

    /* renamed from: e, reason: collision with root package name */
    OverScroller f٨٢١٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٨٢١٧f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٢١٨g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٢١٩h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٢٢٠i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f٨٢٢١j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f٨٢٢٢a;

        /* renamed from: b, reason: collision with root package name */
        private final View f٨٢٢٣b;

        a(CoordinatorLayout coordinatorLayout, View view) {
            this.f٨٢٢٢a = coordinatorLayout;
            this.f٨٢٢٣b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f٨٢٢٣b != null && (overScroller = i.this.f٨٢١٦e) != null) {
                if (overScroller.computeScrollOffset()) {
                    i iVar = i.this;
                    iVar.V(this.f٨٢٢٢a, this.f٨٢٢٣b, iVar.f٨٢١٦e.getCurrY());
                    this.f٨٢٢٣b.postOnAnimation(this);
                    return;
                }
                i.this.T(this.f٨٢٢٢a, this.f٨٢٢٣b);
            }
        }
    }

    public i() {
        this.f٨٢١٨g = -1;
        this.f٨٢٢٠i = -1;
    }

    private void O() {
        if (this.f٨٢٢١j == null) {
            this.f٨٢٢١j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        if (motionEvent.getActionIndex() == 0) {
                            i10 = 1;
                        } else {
                            i10 = 0;
                        }
                        this.f٨٢١٨g = motionEvent.getPointerId(i10);
                        this.f٨٢١٩h = (int) (motionEvent.getY(i10) + 0.5f);
                    }
                }
            } else {
                int findPointerIndex = motionEvent.findPointerIndex(this.f٨٢١٨g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y10 = (int) motionEvent.getY(findPointerIndex);
                int i11 = this.f٨٢١٩h - y10;
                this.f٨٢١٩h = y10;
                U(coordinatorLayout, view, i11, Q(view), 0);
            }
            z10 = false;
            velocityTracker2 = this.f٨٢٢١j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (!this.f٨٢١٧f && !z10) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.f٨٢٢١j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f٨٢٢١j.computeCurrentVelocity(1000);
            P(coordinatorLayout, view, -R(view), 0, this.f٨٢٢١j.getYVelocity(this.f٨٢١٨g));
            z10 = true;
            this.f٨٢١٧f = false;
            this.f٨٢١٨g = -1;
            velocityTracker = this.f٨٢٢١j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f٨٢٢١j = null;
            }
            velocityTracker2 = this.f٨٢٢١j;
            if (velocityTracker2 != null) {
            }
            return !this.f٨٢١٧f ? true : true;
        }
        z10 = false;
        this.f٨٢١٧f = false;
        this.f٨٢١٨g = -1;
        velocityTracker = this.f٨٢٢١j;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f٨٢٢١j;
        if (velocityTracker2 != null) {
        }
        if (!this.f٨٢١٧f) {
        }
    }

    abstract boolean N(View view);

    final boolean P(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, float f10) {
        Runnable runnable = this.f٨٢١٥d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f٨٢١٥d = null;
        }
        if (this.f٨٢١٦e == null) {
            this.f٨٢١٦e = new OverScroller(view.getContext());
        }
        this.f٨٢١٦e.fling(0, K(), 0, Math.round(f10), 0, 0, i10, i11);
        if (this.f٨٢١٦e.computeScrollOffset()) {
            a aVar = new a(coordinatorLayout, view);
            this.f٨٢١٥d = aVar;
            view.postOnAnimation(aVar);
            return true;
        }
        T(coordinatorLayout, view);
        return false;
    }

    abstract int Q(View view);

    abstract int R(View view);

    abstract int S();

    abstract void T(CoordinatorLayout coordinatorLayout, View view);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int U(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        return W(coordinatorLayout, view, S() - i10, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int V(CoordinatorLayout coordinatorLayout, View view, int i10) {
        return W(coordinatorLayout, view, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int W(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        int findPointerIndex;
        if (this.f٨٢٢٠i < 0) {
            this.f٨٢٢٠i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f٨٢١٧f) {
            int i10 = this.f٨٢١٨g;
            if (i10 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y10 - this.f٨٢١٩h) > this.f٨٢٢٠i) {
                this.f٨٢١٩h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f٨٢١٨g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (N(view) && coordinatorLayout.H(view, x10, y11)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٨٢١٧f = z10;
            if (z10) {
                this.f٨٢١٩h = y11;
                this.f٨٢١٨g = motionEvent.getPointerId(0);
                O();
                OverScroller overScroller = this.f٨٢١٦e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f٨٢١٦e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f٨٢٢١j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٢١٨g = -1;
        this.f٨٢٢٠i = -1;
    }
}
