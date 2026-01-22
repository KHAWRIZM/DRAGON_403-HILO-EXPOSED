package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.d0;
import androidx.core.view.d1;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.i0;
import com.qmuiteam.qmui.nestedScroll.b;
import ic.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedTopDelegateLayout extends FrameLayout implements d0, f0, c {

    /* renamed from: a, reason: collision with root package name */
    private b.a f١٢٨٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private View f١٢٨٠٣b;

    /* renamed from: c, reason: collision with root package name */
    private c f١٢٨٠٤c;

    /* renamed from: d, reason: collision with root package name */
    private View f١٢٨٠٥d;

    /* renamed from: e, reason: collision with root package name */
    private l f١٢٨٠٦e;

    /* renamed from: f, reason: collision with root package name */
    private l f١٢٨٠٧f;

    /* renamed from: g, reason: collision with root package name */
    private l f١٢٨٠٨g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٨٠٩h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢٨١٠i;

    /* renamed from: j, reason: collision with root package name */
    private final i0 f١٢٨١١j;

    /* renamed from: k, reason: collision with root package name */
    private final e0 f١٢٨١٢k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f١٢٨١٣l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIContinuousNestedTopDelegateLayout.this.b();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f١٢٨١٥a;

        b(b.a aVar) {
            this.f١٢٨١٥a = aVar;
        }

        @Override // com.qmuiteam.qmui.nestedScroll.b.a
        public void a(int i10, int i11) {
            this.f١٢٨١٥a.a(QMUIContinuousNestedTopDelegateLayout.this.getCurrentScroll(), QMUIContinuousNestedTopDelegateLayout.this.getScrollOffsetRange());
        }

        @Override // com.qmuiteam.qmui.nestedScroll.b.a
        public void b(View view, int i10) {
        }
    }

    public QMUIContinuousNestedTopDelegateLayout(Context context) {
        this(context, null);
    }

    private void g(int i10) {
        this.f١٢٨٠٩h = i10;
        l lVar = this.f١٢٨٠٦e;
        if (lVar != null) {
            lVar.h(-i10);
        }
        l lVar2 = this.f١٢٨٠٧f;
        if (lVar2 != null) {
            lVar2.h(-i10);
        }
        l lVar3 = this.f١٢٨٠٨g;
        if (lVar3 != null) {
            lVar3.h(-i10);
        }
        b.a aVar = this.f١٢٨٠٢a;
        if (aVar != null) {
            aVar.a(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int a(int i10) {
        int height;
        int height2;
        int i11 = this.f١٢٨١٠i;
        if (i11 <= 0) {
            c cVar = this.f١٢٨٠٤c;
            if (cVar != null) {
                return cVar.a(i10);
            }
            return i10;
        }
        if (i10 > 0) {
            if (this.f١٢٨٠٤c == null) {
                if (i10 == Integer.MAX_VALUE) {
                    g(i11);
                    return i10;
                }
                int i12 = this.f١٢٨٠٩h;
                if (i12 + i10 <= i11) {
                    g(i12 + i10);
                    return 0;
                }
                if (i12 < i11) {
                    int i13 = i10 - (i11 - i12);
                    g(i11);
                    return i13;
                }
                return i10;
            }
            int paddingTop = getPaddingTop();
            View view = this.f١٢٨٠٣b;
            if (view == null) {
                height2 = 0;
            } else {
                height2 = view.getHeight();
            }
            int min = Math.min(i11, paddingTop + height2);
            if (i10 == Integer.MAX_VALUE) {
                g(min);
            } else {
                int i14 = this.f١٢٨٠٩h;
                if (i14 + i10 <= min) {
                    g(i14 + i10);
                    return 0;
                }
                if (i14 < min) {
                    i10 -= min - i14;
                    g(min);
                }
            }
            int a10 = this.f١٢٨٠٤c.a(i10);
            if (a10 <= 0) {
                return a10;
            }
            if (a10 == Integer.MAX_VALUE) {
                g(this.f١٢٨١٠i);
                return a10;
            }
            int i15 = this.f١٢٨٠٩h;
            int i16 = i15 + a10;
            int i17 = this.f١٢٨١٠i;
            if (i16 <= i17) {
                g(i15 + a10);
                return 0;
            }
            int i18 = a10 - (i17 - i15);
            g(i17);
            return i18;
        }
        if (i10 < 0) {
            if (this.f١٢٨٠٤c == null) {
                if (i10 == Integer.MIN_VALUE) {
                    g(0);
                    return i10;
                }
                int i19 = this.f١٢٨٠٩h;
                if (i19 + i10 >= 0) {
                    g(i19 + i10);
                    return 0;
                }
                if (i19 > 0) {
                    int i20 = i10 + i19;
                    g(0);
                    return i20;
                }
                return i10;
            }
            int paddingBottom = i11 - getPaddingBottom();
            View view2 = this.f١٢٨٠٥d;
            if (view2 == null) {
                height = 0;
            } else {
                height = view2.getHeight();
            }
            int max = Math.max(0, paddingBottom - height);
            if (i10 == Integer.MIN_VALUE) {
                g(max);
            } else {
                int i21 = this.f١٢٨٠٩h;
                if (i21 + i10 > max) {
                    g(i21 + i10);
                    return 0;
                }
                if (i21 > max) {
                    i10 += i21 - max;
                    g(max);
                }
            }
            int a11 = this.f١٢٨٠٤c.a(i10);
            if (a11 >= 0) {
                return a11;
            }
            if (a11 == Integer.MIN_VALUE) {
                g(0);
                return a11;
            }
            int i22 = this.f١٢٨٠٩h;
            if (i22 + a11 > 0) {
                g(i22 + a11);
                return 0;
            }
            if (i22 > 0) {
                int i23 = a11 + i22;
                g(0);
                return i23;
            }
            return a11;
        }
        return i10;
    }

    public void b() {
        int i10;
        if ((this.f١٢٨٠٣b == null && this.f١٢٨٠٥d == null) || this.f١٢٨٠٤c == null) {
            return;
        }
        int containerHeaderOffsetRange = getContainerHeaderOffsetRange();
        int currentScroll = this.f١٢٨٠٤c.getCurrentScroll();
        int scrollOffsetRange = this.f١٢٨٠٤c.getScrollOffsetRange();
        if (currentScroll > 0 && this.f١٢٨٠٣b != null && (i10 = this.f١٢٨٠٩h) < containerHeaderOffsetRange) {
            int i11 = containerHeaderOffsetRange - i10;
            if (i11 >= currentScroll) {
                this.f١٢٨٠٤c.a(Integer.MIN_VALUE);
                g(this.f١٢٨٠٩h + currentScroll);
            } else {
                this.f١٢٨٠٤c.a(-i11);
                g(containerHeaderOffsetRange);
            }
        }
        int i12 = this.f١٢٨٠٩h;
        if (i12 > containerHeaderOffsetRange && currentScroll < scrollOffsetRange && this.f١٢٨٠٥d != null) {
            int i13 = i12 - containerHeaderOffsetRange;
            int i14 = scrollOffsetRange - currentScroll;
            if (i13 >= i14) {
                this.f١٢٨٠٤c.a(Integer.MAX_VALUE);
                g((containerHeaderOffsetRange + i13) - i14);
            } else {
                this.f١٢٨٠٤c.a(i13);
                g(containerHeaderOffsetRange);
            }
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.b
    public void c(b.a aVar) {
        this.f١٢٨٠٢a = aVar;
        c cVar = this.f١٢٨٠٤c;
        if (cVar != null) {
            cVar.c(new b(aVar));
        }
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.f١٢٨١٢k.d(i10, i11, iArr, iArr2, i12);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f١٢٨١٢k.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f١٢٨١٢k.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return e(i10, i11, i12, i13, iArr, 0);
    }

    public boolean e(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return this.f١٢٨١٢k.g(i10, i11, i12, i13, iArr, i14);
    }

    public boolean f(int i10) {
        return this.f١٢٨١٢k.l(i10);
    }

    public int getContainerHeaderOffsetRange() {
        if (this.f١٢٨١٠i != 0 && this.f١٢٨٠٣b != null) {
            return Math.min(getPaddingTop() + this.f١٢٨٠٣b.getHeight(), this.f١٢٨١٠i);
        }
        return 0;
    }

    public int getContainerOffsetCurrent() {
        return this.f١٢٨٠٩h;
    }

    public int getContainerOffsetRange() {
        return this.f١٢٨١٠i;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getCurrentScroll() {
        int i10 = this.f١٢٨٠٩h;
        c cVar = this.f١٢٨٠٤c;
        if (cVar != null) {
            return i10 + cVar.getCurrentScroll();
        }
        return i10;
    }

    public c getDelegateView() {
        return this.f١٢٨٠٤c;
    }

    public View getFooterView() {
        return this.f١٢٨٠٥d;
    }

    public View getHeaderView() {
        return this.f١٢٨٠٣b;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f١٢٨١١j.a();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getScrollOffsetRange() {
        int i10 = this.f١٢٨١٠i;
        c cVar = this.f١٢٨٠٤c;
        if (cVar != null) {
            return i10 + cVar.getScrollOffsetRange();
        }
        return i10;
    }

    public void h() {
        removeCallbacks(this.f١٢٨١٣l);
        post(this.f١٢٨١٣l);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return f(0);
    }

    public boolean i(int i10, int i11) {
        return this.f١٢٨١٢k.q(i10, i11);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f١٢٨١٢k.m();
    }

    public void j(int i10) {
        this.f١٢٨١٢k.s(i10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int paddingTop = getPaddingTop();
        View view = this.f١٢٨٠٣b;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            this.f١٢٨٠٣b.layout(0, paddingTop, i14, measuredHeight);
            paddingTop = measuredHeight;
        }
        Object obj = this.f١٢٨٠٤c;
        if (obj != null) {
            View view2 = (View) obj;
            int measuredHeight2 = view2.getMeasuredHeight() + paddingTop;
            view2.layout(0, paddingTop, i14, measuredHeight2);
            paddingTop = measuredHeight2;
        }
        View view3 = this.f١٢٨٠٥d;
        if (view3 != null) {
            int measuredHeight3 = view3.getMeasuredHeight() + paddingTop;
            this.f١٢٨٠٥d.layout(0, paddingTop, i14, measuredHeight3);
            paddingTop = measuredHeight3;
        }
        this.f١٢٨١٠i = Math.max(0, (paddingTop + getPaddingBottom()) - i15);
        l lVar = this.f١٢٨٠٦e;
        if (lVar != null) {
            lVar.e();
            this.f١٢٨٠٩h = -this.f١٢٨٠٦e.d();
        }
        l lVar2 = this.f١٢٨٠٧f;
        if (lVar2 != null) {
            lVar2.e();
            this.f١٢٨٠٩h = -this.f١٢٨٠٧f.d();
        }
        l lVar3 = this.f١٢٨٠٨g;
        if (lVar3 != null) {
            lVar3.e();
            this.f١٢٨٠٩h = -this.f١٢٨٠٨g.d();
        }
        int i16 = this.f١٢٨٠٩h;
        int i17 = this.f١٢٨١٠i;
        if (i16 > i17) {
            g(i17);
        }
        h();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingTop = getPaddingTop();
        View view = this.f١٢٨٠٣b;
        if (view != null) {
            view.measure(i10, View.MeasureSpec.makeMeasureSpec(size2, 0));
            paddingTop += this.f١٢٨٠٣b.getMeasuredHeight();
        }
        Object obj = this.f١٢٨٠٤c;
        if (obj != null) {
            View view2 = (View) obj;
            view2.measure(i10, View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            paddingTop += view2.getMeasuredHeight();
        }
        View view3 = this.f١٢٨٠٥d;
        if (view3 != null) {
            view3.measure(i10, View.MeasureSpec.makeMeasureSpec(size2, 0));
            paddingTop += this.f١٢٨٠٥d.getMeasuredHeight();
        }
        int paddingBottom = paddingTop + getPaddingBottom();
        if (paddingBottom < size2) {
            setMeasuredDimension(size, paddingBottom);
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        d(i10, i11, iArr, null, i12);
        int i13 = i11 - iArr[1];
        if (i13 > 0) {
            int i14 = this.f١٢٨١٠i;
            int paddingTop = getPaddingTop();
            View view2 = this.f١٢٨٠٣b;
            int min = Math.min(i14, paddingTop + (view2 != null ? view2.getHeight() : 0));
            int i15 = this.f١٢٨٠٩h;
            if (i15 + i13 <= min) {
                g(i15 + i13);
                iArr[1] = iArr[1] + i13;
                return;
            } else {
                if (i15 < min) {
                    iArr[1] = iArr[1] + (min - i15);
                    g(min);
                    return;
                }
                return;
            }
        }
        if (i13 < 0) {
            int paddingBottom = getPaddingBottom();
            View view3 = this.f١٢٨٠٥d;
            int height = paddingBottom + (view3 != null ? view3.getHeight() : 0);
            int i16 = this.f١٢٨١٠i;
            if (i16 > height) {
                int i17 = i16 - height;
                int i18 = this.f١٢٨٠٩h;
                if (i18 + i13 >= i17) {
                    g(i18 + i13);
                    iArr[1] = iArr[1] + i13;
                } else if (i18 > i17) {
                    iArr[1] = iArr[1] + (i17 - i18);
                    g(i17);
                }
            }
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        int i15 = 0;
        if (i13 > 0) {
            int i16 = this.f١٢٨٠٩h;
            int i17 = i16 + i13;
            int i18 = this.f١٢٨١٠i;
            if (i17 <= i18) {
                g(i16 + i13);
                i15 = i13;
            } else if (i16 <= i18) {
                i15 = i18 - i16;
                g(i18);
            }
        } else if (i13 < 0) {
            int i19 = this.f١٢٨٠٩h;
            if (i19 + i13 >= 0) {
                g(i19 + i13);
                i15 = i13;
            } else if (i19 >= 0) {
                g(0);
                i15 = -i19;
            }
        }
        e(0, i11 + i15, 0, i13 - i15, null, i14);
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        this.f١٢٨١١j.c(view, view2, i10, i11);
        i(2, i11);
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        this.f١٢٨١١j.e(view, i10);
        j(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setDelegateView(c cVar) {
        if (cVar instanceof View) {
            c cVar2 = this.f١٢٨٠٤c;
            if (cVar2 != null) {
                cVar2.c(null);
            }
            this.f١٢٨٠٤c = cVar;
            View view = (View) cVar;
            this.f١٢٨٠٧f = new l(view);
            addView(view, new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        throw new IllegalArgumentException("delegateView must be a instance of View");
    }

    public void setFooterView(View view) {
        this.f١٢٨٠٥d = view;
        this.f١٢٨٠٨g = new l(view);
        addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setHeaderView(View view) {
        this.f١٢٨٠٣b = view;
        this.f١٢٨٠٦e = new l(view);
        addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View, androidx.core.view.d0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f١٢٨١٢k.n(z10);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return i(i10, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        j(0);
    }

    public QMUIContinuousNestedTopDelegateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    public QMUIContinuousNestedTopDelegateLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٨٠٩h = 0;
        this.f١٢٨١٠i = 0;
        this.f١٢٨١٣l = new a();
        this.f١٢٨١١j = new i0(this);
        this.f١٢٨١٢k = new e0(this);
        d1.D0(this, true);
        setClipToPadding(false);
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
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }
}
