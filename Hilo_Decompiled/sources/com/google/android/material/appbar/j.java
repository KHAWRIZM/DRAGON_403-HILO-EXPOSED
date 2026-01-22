package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d2;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j extends k {

    /* renamed from: d, reason: collision with root package name */
    final Rect f٨٢٢٥d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f٨٢٢٦e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٢٢٧f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٢٢٨g;

    public j() {
        this.f٨٢٢٥d = new Rect();
        this.f٨٢٢٦e = new Rect();
        this.f٨٢٢٧f = 0;
    }

    private static int T(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.k
    public void L(CoordinatorLayout coordinatorLayout, View view, int i10) {
        View N = N(coordinatorLayout.x(view));
        if (N != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f٨٢٢٥d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, N.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + N.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            d2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                rect.left += lastWindowInsets.k();
                rect.right -= lastWindowInsets.l();
            }
            Rect rect2 = this.f٨٢٢٦e;
            Gravity.apply(T(fVar.f٢٥٦٢c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            int O = O(N);
            view.layout(rect2.left, rect2.top - O, rect2.right, rect2.bottom - O);
            this.f٨٢٢٧f = rect2.top - N.getBottom();
            return;
        }
        super.L(coordinatorLayout, view, i10);
        this.f٨٢٢٧f = 0;
    }

    abstract View N(List list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int O(View view) {
        if (this.f٨٢٢٨g == 0) {
            return 0;
        }
        float P = P(view);
        int i10 = this.f٨٢٢٨g;
        return j2.a.b((int) (P * i10), 0, i10);
    }

    abstract float P(View view);

    public final int Q() {
        return this.f٨٢٢٨g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int S() {
        return this.f٨٢٢٧f;
    }

    public final void U(int i10) {
        this.f٨٢٢٨g = i10;
    }

    protected boolean V() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        View N;
        int i14;
        d2 lastWindowInsets;
        int i15 = view.getLayoutParams().height;
        if ((i15 == -1 || i15 == -2) && (N = N(coordinatorLayout.x(view))) != null) {
            int size = View.MeasureSpec.getSize(i12);
            if (size > 0) {
                if (N.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.m() + lastWindowInsets.j();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int R = size + R(N);
            int measuredHeight = N.getMeasuredHeight();
            if (V()) {
                view.setTranslationY(-measuredHeight);
            } else {
                view.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
                R -= measuredHeight;
            }
            if (i15 == -1) {
                i14 = 1073741824;
            } else {
                i14 = Integer.MIN_VALUE;
            }
            coordinatorLayout.P(view, i10, i11, View.MeasureSpec.makeMeasureSpec(R, i14), i13);
            return true;
        }
        return false;
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٢٢٥d = new Rect();
        this.f٨٢٢٦e = new Rect();
        this.f٨٢٢٧f = 0;
    }
}
