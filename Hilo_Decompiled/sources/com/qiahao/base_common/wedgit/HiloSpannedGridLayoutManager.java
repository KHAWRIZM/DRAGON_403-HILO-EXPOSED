package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class HiloSpannedGridLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٦١٢c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f١٢٦١٣d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٦١٤e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٦١٥f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٦١٦g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٦١٧h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٢٦١٨i;

    /* renamed from: j, reason: collision with root package name */
    private SparseArray f١٢٦١٩j;

    /* renamed from: k, reason: collision with root package name */
    private List f١٢٦٢٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٦٢١l;

    /* renamed from: a, reason: collision with root package name */
    private int f١٢٦١٠a = 1;

    /* renamed from: b, reason: collision with root package name */
    private float f١٢٦١١b = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f١٢٦٢٢m = new Rect();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i10) {
            return new PointF(DownloadProgress.UNKNOWN_PROGRESS, (HiloSpannedGridLayoutManager.this.o(i10) - HiloSpannedGridLayoutManager.this.f١٢٦١٦g) * HiloSpannedGridLayoutManager.this.f١٢٦١٢c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f١٢٦٢٤a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٢٦٢٥b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٢٦٢٦c;

        /* renamed from: d, reason: collision with root package name */
        final int f١٢٦٢٧d;

        b(int i10, int i11, int i12, int i13) {
            this.f١٢٦٢٤a = i10;
            this.f١٢٦٢٥b = i11;
            this.f١٢٦٢٦c = i12;
            this.f١٢٦٢٧d = i13;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class c extends RecyclerView.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f١٢٦٢٨a;

        /* renamed from: b, reason: collision with root package name */
        int f١٢٦٢٩b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class d {

        /* renamed from: c, reason: collision with root package name */
        public static final d f١٢٦٣٠c = new d(1, 1);

        /* renamed from: a, reason: collision with root package name */
        public int f١٢٦٣١a;

        /* renamed from: b, reason: collision with root package name */
        public int f١٢٦٣٢b;

        public d(int i10, int i11) {
            this.f١٢٦٣١a = i10;
            this.f١٢٦٣٢b = i11;
        }
    }

    @Keep
    public HiloSpannedGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
    }

    private void h() {
        int i10;
        int i11 = 1;
        this.f١٢٦١٣d = new int[this.f١٢٦١٠a + 1];
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i12 = 0;
        this.f١٢٦١٣d[0] = paddingLeft;
        int i13 = this.f١٢٦١٠a;
        int i14 = width / i13;
        int i15 = width % i13;
        while (true) {
            int i16 = this.f١٢٦١٠a;
            if (i11 <= i16) {
                i12 += i15;
                if (i12 > 0 && i16 - i12 < i15) {
                    i10 = i14 + 1;
                    i12 -= i16;
                } else {
                    i10 = i14;
                }
                paddingLeft += i10;
                this.f١٢٦١٣d[i11] = paddingLeft;
                i11++;
            } else {
                return;
            }
        }
    }

    private void i(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int itemCount = state.getItemCount();
        this.f١٢٦١٩j = new SparseArray(itemCount);
        this.f١٢٦٢٠k = new ArrayList();
        u(0, 0);
        int i10 = this.f١٢٦١٠a;
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = 1;
            if (i11 < itemCount) {
                if (recycler.convertPreLayoutPositionToPostLayout(i11) == -1) {
                    d p10 = p(i11);
                    int i15 = p10.f١٢٦٣١a;
                    int i16 = this.f١٢٦١٠a;
                    if (i15 > i16) {
                        p10.f١٢٦٣١a = i16;
                    }
                    if (p10.f١٢٦٣١a + i12 > i16) {
                        i13++;
                        u(i13, i11);
                        i12 = 0;
                    }
                    while (iArr[i12] > i13) {
                        i12++;
                        if (p10.f١٢٦٣١a + i12 > this.f١٢٦١٠a) {
                            i13++;
                            u(i13, i11);
                            i12 = 0;
                        }
                    }
                    this.f١٢٦١٩j.put(i11, new b(i13, p10.f١٢٦٣٢b, i12, p10.f١٢٦٣١a));
                    for (int i17 = 0; i17 < p10.f١٢٦٣١a; i17++) {
                        iArr[i12 + i17] = p10.f١٢٦٣٢b + i13;
                    }
                    if (p10.f١٢٦٣٢b > 1) {
                        int k10 = k(i13);
                        while (i14 < p10.f١٢٦٣٢b) {
                            u(i13 + i14, k10);
                            i14++;
                        }
                    }
                    i12 += p10.f١٢٦٣١a;
                    i11++;
                } else {
                    throw null;
                }
            } else {
                this.f١٢٦٢١l = iArr[0];
                while (i14 < i10) {
                    int i18 = iArr[i14];
                    if (i18 > this.f١٢٦٢١l) {
                        this.f١٢٦٢١l = i18;
                    }
                    i14++;
                }
                return;
            }
        }
    }

    private void j() {
        this.f١٢٦١٢c = (int) Math.floor(((int) Math.floor(((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.f١٢٦١٠a)) * (1.0f / this.f١٢٦١١b));
        h();
    }

    private int k(int i10) {
        return ((Integer) this.f١٢٦٢٠k.get(i10)).intValue();
    }

    private int l(int i10, RecyclerView.State state) {
        int itemCount;
        int n10 = n(i10);
        if (n10 != q()) {
            itemCount = k(n10);
        } else {
            itemCount = state.getItemCount();
        }
        return itemCount - 1;
    }

    private int m() {
        int ceil = ((int) Math.ceil(getHeight() / this.f١٢٦١٢c)) + 1;
        int i10 = this.f١٢٦٢١l;
        if (i10 < ceil) {
            return 0;
        }
        return o(k(i10 - ceil));
    }

    private int n(int i10) {
        int k10 = k(i10);
        do {
            i10++;
            if (i10 >= q()) {
                break;
            }
        } while (k(i10) == k10);
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(int i10) {
        if (i10 < this.f١٢٦١٩j.size()) {
            return ((b) this.f١٢٦١٩j.get(i10)).f١٢٦٢٤a;
        }
        return -1;
    }

    private d p(int i10) {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (i10 == getPosition(childAt)) {
                c cVar = (c) childAt.getLayoutParams();
                return new d(cVar.f١٢٦٢٨a, cVar.f١٢٦٢٩b);
            }
        }
        return d.f١٢٦٣٠c;
    }

    private int q() {
        return this.f١٢٦٢٠k.size();
    }

    private void r(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
    }

    private int s(int i10, int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int childCount;
        int k10 = k(i10);
        int l10 = l(i10, state);
        if (i10 < this.f١٢٦١٦g) {
            childCount = 0;
        } else {
            childCount = getChildCount();
        }
        int i12 = childCount;
        int i13 = k10;
        boolean z10 = false;
        while (i13 <= l10) {
            View viewForPosition = recycler.getViewForPosition(i13);
            c cVar = (c) viewForPosition.getLayoutParams();
            boolean isItemRemoved = z10 | cVar.isItemRemoved();
            b bVar = (b) this.f١٢٦١٩j.get(i13);
            addView(viewForPosition, i12);
            int[] iArr = this.f١٢٦١٣d;
            int i14 = bVar.f١٢٦٢٦c;
            t(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(iArr[bVar.f١٢٦٢٧d + i14] - iArr[i14], 1073741824, 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(bVar.f١٢٦٢٥b * this.f١٢٦١٢c, 1073741824, 0, ((ViewGroup.MarginLayoutParams) cVar).height, true));
            int i15 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin + this.f١٢٦١٣d[bVar.f١٢٦٢٦c];
            int i16 = ((ViewGroup.MarginLayoutParams) cVar).topMargin + i11 + (bVar.f١٢٦٢٤a * this.f١٢٦١٢c);
            layoutDecorated(viewForPosition, i15, i16, i15 + getDecoratedMeasuredWidth(viewForPosition), i16 + getDecoratedMeasuredHeight(viewForPosition));
            cVar.f١٢٦٢٨a = bVar.f١٢٦٢٧d;
            cVar.f١٢٦٢٩b = bVar.f١٢٦٢٥b;
            i13++;
            i12++;
            z10 = isItemRemoved;
        }
        if (k10 < this.f١٢٦١٤e) {
            this.f١٢٦١٤e = k10;
            this.f١٢٦١٦g = o(k10);
        }
        if (l10 > this.f١٢٦١٥f) {
            this.f١٢٦١٥f = l10;
            this.f١٢٦١٧h = o(l10);
        }
        if (z10) {
            return 0;
        }
        b bVar2 = (b) this.f١٢٦١٩j.get(k10);
        b bVar3 = (b) this.f١٢٦١٩j.get(l10);
        return ((bVar3.f١٢٦٢٤a + bVar3.f١٢٦٢٥b) - bVar2.f١٢٦٢٤a) * this.f١٢٦١٢c;
    }

    private void t(View view, int i10, int i11) {
        calculateItemDecorationsForChild(view, this.f١٢٦٢٢m);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.f١٢٦٢٢m;
        int updateSpecWithExtra = updateSpecWithExtra(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.f١٢٦٢٢m;
        view.measure(updateSpecWithExtra, updateSpecWithExtra(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom));
    }

    private void u(int i10, int i11) {
        if (q() < i10 + 1) {
            this.f١٢٦٢٠k.add(Integer.valueOf(i11));
        }
    }

    private int updateSpecWithExtra(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i10) - i11) - i12, mode);
    }

    private void v(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int k10 = k(i10);
        int l10 = l(i10, state);
        for (int i11 = l10; i11 >= k10; i11--) {
            removeAndRecycleViewAt(i11 - this.f١٢٦١٤e, recycler);
        }
        if (i10 == this.f١٢٦١٦g) {
            int i12 = l10 + 1;
            this.f١٢٦١٤e = i12;
            this.f١٢٦١٦g = o(i12);
        }
        if (i10 == this.f١٢٦١٧h) {
            int i13 = k10 - 1;
            this.f١٢٦١٥f = i13;
            this.f١٢٦١٧h = o(i13);
        }
    }

    private void w() {
        this.f١٢٦١٩j = null;
        this.f١٢٦٢٠k = null;
        this.f١٢٦١٤e = 0;
        this.f١٢٦١٦g = 0;
        this.f١٢٦١٥f = 0;
        this.f١٢٦١٧h = 0;
        this.f١٢٦١٢c = 0;
        this.f١٢٦١٨i = false;
    }

    private void x() {
        int m10 = m();
        if (this.f١٢٦١٦g > m10) {
            this.f١٢٦١٦g = m10;
        }
        int k10 = k(this.f١٢٦١٦g);
        this.f١٢٦١٤e = k10;
        this.f١٢٦١٧h = this.f١٢٦١٦g;
        this.f١٢٦١٥f = k10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return (getPaddingTop() + (this.f١٢٦١٦g * this.f١٢٦١٢c)) - getDecoratedTop(getChildAt(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.f١٢٦٢٠k == null) {
            return 0;
        }
        return (q() * this.f١٢٦١٢c) + getPaddingTop() + getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i10) {
        int i11 = this.f١٢٦١٤e;
        if (i10 >= i11 && i10 <= this.f١٢٦١٥f) {
            return getChildAt(i10 - i11);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        j();
        i(recycler, state);
        int i10 = 0;
        if (state.getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.f١٢٦١٦g = 0;
            x();
            return;
        }
        int paddingTop = getPaddingTop();
        if (this.f١٢٦١٨i) {
            paddingTop = -(this.f١٢٦١٦g * this.f١٢٦١٢c);
            this.f١٢٦١٨i = false;
        } else if (getChildCount() != 0) {
            i10 = getDecoratedTop(getChildAt(0));
            paddingTop = i10 - (this.f١٢٦١٦g * this.f١٢٦١٢c);
            x();
        }
        detachAndScrapAttachedViews(recycler);
        int i11 = this.f١٢٦١٦g;
        int height = getHeight() - i10;
        int itemCount = state.getItemCount() - 1;
        while (height > 0 && this.f١٢٦١٥f < itemCount) {
            height -= s(i11, paddingTop, recycler, state);
            i11 = n(i11);
        }
        r(recycler, state, paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        if (i10 >= getItemCount()) {
            i10 = getItemCount() - 1;
        }
        this.f١٢٦١٦g = o(i10);
        x();
        this.f١٢٦١٨i = true;
        removeAllViews();
        requestLayout();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v10 int, still in use, count: 1, list:
          (r1v10 int) from 0x002f: ARITH (r1v10 int) * (wrap:int:0x002d: IGET (r5v0 'this' com.qiahao.base_common.wedgit.HiloSpannedGridLayoutManager A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:46) com.qiahao.base_common.wedgit.HiloSpannedGridLayoutManager.c int) A[WRAPPED] (LINE:48)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:163)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:95)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:79)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:163)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:140)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:116)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r6, androidx.recyclerview.widget.RecyclerView.Recycler r7, androidx.recyclerview.widget.RecyclerView.State r8) {
        /*
            r5 = this;
            int r0 = r5.getChildCount()
            r1 = 0
            if (r0 == 0) goto Lb7
            if (r6 != 0) goto Lb
            goto Lb7
        Lb:
            android.view.View r0 = r5.getChildAt(r1)
            int r0 = r5.getDecoratedTop(r0)
            if (r6 >= 0) goto L53
            int r1 = r5.f١٢٦١٦g
            if (r1 != 0) goto L23
            int r1 = r5.getPaddingTop()
            int r1 = r1 - r0
            int r1 = -r1
            int r6 = java.lang.Math.max(r6, r1)
        L23:
            int r1 = r0 - r6
            if (r1 < 0) goto L35
            int r1 = r5.f١٢٦١٦g
            int r2 = r1 + (-1)
            if (r2 < 0) goto L35
            int r3 = r5.f١٢٦١٢c
            int r1 = r1 * r3
            int r0 = r0 - r1
            r5.s(r2, r0, r7, r8)
        L35:
            int r0 = r5.f١٢٦١٧h
            int r0 = r5.k(r0)
            int r1 = r5.f١٢٦١٤e
            int r0 = r0 - r1
            android.view.View r0 = r5.getChildAt(r0)
            int r0 = r5.getDecoratedTop(r0)
            int r0 = r0 - r6
            int r1 = r5.getHeight()
            if (r0 <= r1) goto Lb2
            int r0 = r5.f١٢٦١٧h
            r5.v(r0, r7, r8)
            goto Lb2
        L53:
            int r2 = r5.getChildCount()
            int r2 = r2 + (-1)
            android.view.View r2 = r5.getChildAt(r2)
            int r2 = r5.getDecoratedBottom(r2)
            int r3 = r5.f١٢٦١٥f
            int r4 = r5.getItemCount()
            int r4 = r4 + (-1)
            if (r3 != r4) goto L7e
            int r3 = r5.getHeight()
            int r3 = r2 - r3
            int r4 = r5.getPaddingBottom()
            int r3 = r3 + r4
            int r1 = java.lang.Math.max(r3, r1)
            int r6 = java.lang.Math.min(r6, r1)
        L7e:
            int r2 = r2 - r6
            int r1 = r5.getHeight()
            if (r2 >= r1) goto L99
            int r1 = r5.f١٢٦١٧h
            int r1 = r1 + 1
            int r2 = r5.q()
            if (r1 >= r2) goto L99
            int r2 = r5.f١٢٦١٦g
            int r3 = r5.f١٢٦١٢c
            int r2 = r2 * r3
            int r0 = r0 - r2
            r5.s(r1, r0, r7, r8)
        L99:
            int r0 = r5.f١٢٦١٦g
            int r0 = r5.l(r0, r8)
            int r1 = r5.f١٢٦١٤e
            int r0 = r0 - r1
            android.view.View r0 = r5.getChildAt(r0)
            int r0 = r5.getDecoratedBottom(r0)
            int r0 = r0 - r6
            if (r0 >= 0) goto Lb2
            int r0 = r5.f١٢٦١٦g
            r5.v(r0, r7, r8)
        Lb2:
            int r7 = -r6
            r5.offsetChildrenVertical(r7)
            return r6
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiahao.base_common.wedgit.HiloSpannedGridLayoutManager.scrollVerticallyBy(int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        if (i10 >= getItemCount()) {
            i10 = getItemCount() - 1;
        }
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }
}
