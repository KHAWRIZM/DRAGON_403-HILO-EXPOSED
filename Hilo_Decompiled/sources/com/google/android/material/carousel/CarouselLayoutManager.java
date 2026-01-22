package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.x;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.c;
import com.google.android.material.carousel.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements t7.a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    int f٨٦١٤a;

    /* renamed from: b, reason: collision with root package name */
    int f٨٦١٥b;

    /* renamed from: c, reason: collision with root package name */
    int f٨٦١٦c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٨٦١٧d;

    /* renamed from: e, reason: collision with root package name */
    private final c f٨٦١٨e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.material.carousel.c f٨٦١٩f;

    /* renamed from: g, reason: collision with root package name */
    private f f٨٦٢٠g;

    /* renamed from: h, reason: collision with root package name */
    private e f٨٦٢١h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٦٢٢i;

    /* renamed from: j, reason: collision with root package name */
    private Map f٨٦٢٣j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.android.material.carousel.b f٨٦٢٤k;

    /* renamed from: l, reason: collision with root package name */
    private final View.OnLayoutChangeListener f٨٦٢٥l;

    /* renamed from: m, reason: collision with root package name */
    private int f٨٦٢٦m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨٦٢٧n;

    /* renamed from: o, reason: collision with root package name */
    private int f٨٦٢٨o;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f٨٦٢٠g != null && CarouselLayoutManager.this.d()) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f٨٦٢٠g != null && !CarouselLayoutManager.this.d()) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.u(carouselLayoutManager.getPosition(view));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final View f٨٦٣٠a;

        /* renamed from: b, reason: collision with root package name */
        final float f٨٦٣١b;

        /* renamed from: c, reason: collision with root package name */
        final float f٨٦٣٢c;

        /* renamed from: d, reason: collision with root package name */
        final d f٨٦٣٣d;

        b(View view, float f10, float f11, d dVar) {
            this.f٨٦٣٠a = view;
            this.f٨٦٣١b = f10;
            this.f٨٦٣٢c = f11;
            this.f٨٦٣٣d = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final Paint f٨٦٣٤a;

        /* renamed from: b, reason: collision with root package name */
        private List f٨٦٣٥b;

        c() {
            Paint paint = new Paint();
            this.f٨٦٣٤a = paint;
            this.f٨٦٣٥b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void a(List list) {
            this.f٨٦٣٥b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.f٨٦٣٤a.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (e.c cVar : this.f٨٦٣٥b) {
                this.f٨٦٣٤a.setColor(x.c(-65281, -16776961, cVar.f٨٦٧٩c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.f٨٦٧٨b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).K(), cVar.f٨٦٧٨b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).G(), this.f٨٦٣٤a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).H(), cVar.f٨٦٧٨b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).I(), cVar.f٨٦٧٨b, this.f٨٦٣٤a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final e.c f٨٦٣٦a;

        /* renamed from: b, reason: collision with root package name */
        final e.c f٨٦٣٧b;

        d(e.c cVar, e.c cVar2) {
            boolean z10;
            if (cVar.f٨٦٧٧a <= cVar2.f٨٦٧٧a) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.a(z10);
            this.f٨٦٣٦a = cVar;
            this.f٨٦٣٧b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new h());
    }

    private int A() {
        int i10;
        int i11;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.f٨٦٢٤k.f٨٦٥٤a == 0) {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i10 + i11;
    }

    private e B(f fVar) {
        if (P()) {
            return fVar.h();
        }
        return fVar.l();
    }

    private e C(int i10) {
        e eVar;
        Map map = this.f٨٦٢٣j;
        if (map != null && (eVar = (e) map.get(Integer.valueOf(j2.a.b(i10, 0, Math.max(0, getItemCount() - 1))))) != null) {
            return eVar;
        }
        return this.f٨٦٢٠g.g();
    }

    private int D() {
        if (getClipToPadding()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingTop();
        }
        return getPaddingLeft();
    }

    private float E(float f10, d dVar) {
        e.c cVar = dVar.f٨٦٣٦a;
        float f11 = cVar.f٨٦٨٠d;
        e.c cVar2 = dVar.f٨٦٣٧b;
        return p7.a.b(f11, cVar2.f٨٦٨٠d, cVar.f٨٦٧٨b, cVar2.f٨٦٧٨b, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G() {
        return this.f٨٦٢٤k.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        return this.f٨٦٢٤k.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        return this.f٨٦٢٤k.h();
    }

    private int J() {
        return this.f٨٦٢٤k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        return this.f٨٦٢٤k.j();
    }

    private int L() {
        if (getClipToPadding()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingBottom();
        }
        return getPaddingRight();
    }

    private int M(int i10, e eVar) {
        if (P()) {
            return (int) (((y() - eVar.i().f٨٦٧٧a) - (i10 * eVar.g())) - (eVar.g() / 2.0f));
        }
        return (int) (((i10 * eVar.g()) - eVar.b().f٨٦٧٧a) + (eVar.g() / 2.0f));
    }

    private int N(int i10, e eVar) {
        int i11;
        int i12 = Integer.MAX_VALUE;
        for (e.c cVar : eVar.f()) {
            float g10 = (i10 * eVar.g()) + (eVar.g() / 2.0f);
            if (P()) {
                i11 = (int) ((y() - cVar.f٨٦٧٧a) - g10);
            } else {
                i11 = (int) (g10 - cVar.f٨٦٧٧a);
            }
            int i13 = i11 - this.f٨٦١٤a;
            if (Math.abs(i12) > Math.abs(i13)) {
                i12 = i13;
            }
        }
        return i12;
    }

    private static d O(List list, float f10, boolean z10) {
        float f11;
        float f12 = Float.MAX_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MAX_VALUE;
        float f15 = -3.4028235E38f;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < list.size(); i14++) {
            e.c cVar = (e.c) list.get(i14);
            if (z10) {
                f11 = cVar.f٨٦٧٨b;
            } else {
                f11 = cVar.f٨٦٧٧a;
            }
            float abs = Math.abs(f11 - f10);
            if (f11 <= f10 && abs <= f12) {
                i10 = i14;
                f12 = abs;
            }
            if (f11 > f10 && abs <= f13) {
                i12 = i14;
                f13 = abs;
            }
            if (f11 <= f14) {
                i11 = i14;
                f14 = f11;
            }
            if (f11 > f15) {
                i13 = i14;
                f15 = f11;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new d((e.c) list.get(i10), (e.c) list.get(i12));
    }

    private boolean Q(float f10, d dVar) {
        float n10 = n(f10, E(f10, dVar) / 2.0f);
        if (P()) {
            if (n10 >= DownloadProgress.UNKNOWN_PROGRESS) {
                return false;
            }
        } else if (n10 <= y()) {
            return false;
        }
        return true;
    }

    private boolean R(float f10, d dVar) {
        float m10 = m(f10, E(f10, dVar) / 2.0f);
        if (P()) {
            if (m10 <= y()) {
                return false;
            }
        } else if (m10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i12 - i10 != i16 - i14 || i13 - i11 != i17 - i15) {
            view.post(new Runnable() { // from class: t7.c
                @Override // java.lang.Runnable
                public final void run() {
                    CarouselLayoutManager.this.X();
                }
            });
        }
    }

    private void T() {
        if (this.f٨٦١٧d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + z(childAt) + ", child index:" + i10);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private b U(RecyclerView.Recycler recycler, float f10, int i10) {
        View viewForPosition = recycler.getViewForPosition(i10);
        measureChildWithMargins(viewForPosition, 0, 0);
        float m10 = m(f10, this.f٨٦٢١h.g() / 2.0f);
        d O = O(this.f٨٦٢١h.h(), m10, false);
        return new b(viewForPosition, m10, r(m10, O), O);
    }

    private float V(View view, float f10, float f11, Rect rect) {
        float m10 = m(f10, f11);
        d O = O(this.f٨٦٢١h.h(), m10, false);
        float r10 = r(m10, O);
        super.getDecoratedBoundsWithMargins(view, rect);
        d0(view, m10, O);
        this.f٨٦٢٤k.m(view, rect, f11, r10);
        return r10;
    }

    private void W(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        e g10 = this.f٨٦١٩f.g(this, viewForPosition);
        if (P()) {
            g10 = e.p(g10, y());
        }
        this.f٨٦٢٠g = f.f(this, g10, A(), D(), L(), this.f٨٦١٩f.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.f٨٦٢٠g = null;
        requestLayout();
    }

    private void Y(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float z10 = z(childAt);
            if (!R(z10, O(this.f٨٦٢١h.h(), z10, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float z11 = z(childAt2);
            if (Q(z11, O(this.f٨٦٢١h.h(), z11, true))) {
                removeAndRecycleView(childAt2, recycler);
            } else {
                return;
            }
        }
    }

    private void Z(RecyclerView recyclerView, int i10) {
        if (d()) {
            recyclerView.scrollBy(i10, 0);
        } else {
            recyclerView.scrollBy(0, i10);
        }
    }

    private void b0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            a0(obtainStyledAttributes.getInt(R.styleable.Carousel_carousel_alignment, 0));
            setOrientation(obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            obtainStyledAttributes.recycle();
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        int orientation = getOrientation();
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        Log.d("CarouselLayoutManager", "Unknown focus request:" + i10);
                        return Integer.MIN_VALUE;
                    }
                    if (orientation == 1) {
                        return 1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (orientation != 0) {
                    return Integer.MIN_VALUE;
                }
                if (P()) {
                    return -1;
                }
                return 1;
            }
            if (orientation == 1) {
                return -1;
            }
            return Integer.MIN_VALUE;
        }
        if (orientation != 0) {
            return Integer.MIN_VALUE;
        }
        if (!P()) {
            return -1;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d0(View view, float f10, d dVar) {
        if (!(view instanceof g)) {
            return;
        }
        e.c cVar = dVar.f٨٦٣٦a;
        float f11 = cVar.f٨٦٧٩c;
        e.c cVar2 = dVar.f٨٦٣٧b;
        float b10 = p7.a.b(f11, cVar2.f٨٦٧٩c, cVar.f٨٦٧٧a, cVar2.f٨٦٧٧a, f10);
        float height = view.getHeight();
        float width = view.getWidth();
        RectF e10 = this.f٨٦٢٤k.e(height, width, p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, height / 2.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, b10), p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, width / 2.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, b10));
        float r10 = r(f10, dVar);
        RectF rectF = new RectF(r10 - (e10.width() / 2.0f), r10 - (e10.height() / 2.0f), r10 + (e10.width() / 2.0f), (e10.height() / 2.0f) + r10);
        RectF rectF2 = new RectF(H(), K(), I(), G());
        if (this.f٨٦١٩f.e() == c.a.CONTAINED) {
            this.f٨٦٢٤k.a(e10, rectF, rectF2);
        }
        this.f٨٦٢٤k.l(e10, rectF, rectF2);
        ((g) view).setMaskRectF(e10);
    }

    private void e0(f fVar) {
        int i10 = this.f٨٦١٦c;
        int i11 = this.f٨٦١٥b;
        if (i10 <= i11) {
            this.f٨٦٢١h = B(fVar);
        } else {
            this.f٨٦٢١h = fVar.j(this.f٨٦١٤a, i11, i10);
        }
        this.f٨٦١٨e.a(this.f٨٦٢١h.h());
    }

    private void f0() {
        int itemCount = getItemCount();
        int i10 = this.f٨٦٢٦m;
        if (itemCount != i10 && this.f٨٦٢٠g != null) {
            if (this.f٨٦١٩f.h(this, i10)) {
                X();
            }
            this.f٨٦٢٦m = itemCount;
        }
    }

    private void g0() {
        if (this.f٨٦١٧d && getChildCount() >= 1) {
            int i10 = 0;
            while (i10 < getChildCount() - 1) {
                int position = getPosition(getChildAt(i10));
                int i11 = i10 + 1;
                int position2 = getPosition(getChildAt(i11));
                if (position <= position2) {
                    i10 = i11;
                } else {
                    T();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i10 + "] had adapter position [" + position + "] and child at index [" + i11 + "] had adapter position [" + position2 + "].");
                }
            }
        }
    }

    private View getChildClosestToEnd() {
        int childCount;
        if (P()) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    private View getChildClosestToStart() {
        int i10;
        if (P()) {
            i10 = getChildCount() - 1;
        } else {
            i10 = 0;
        }
        return getChildAt(i10);
    }

    private void l(View view, int i10, b bVar) {
        float g10 = this.f٨٦٢١h.g() / 2.0f;
        addView(view, i10);
        measureChildWithMargins(view, 0, 0);
        float f10 = bVar.f٨٦٣٢c;
        this.f٨٦٢٤k.k(view, (int) (f10 - g10), (int) (f10 + g10));
        d0(view, bVar.f٨٦٣١b, bVar.f٨٦٣٣d);
    }

    private float m(float f10, float f11) {
        if (P()) {
            return f10 - f11;
        }
        return f10 + f11;
    }

    private float n(float f10, float f11) {
        if (P()) {
            return f10 + f11;
        }
        return f10 - f11;
    }

    private void o(RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 >= 0 && i10 < getItemCount()) {
            b U = U(recycler, s(i10), i10);
            l(U.f٨٦٣٠a, i11, U);
        }
    }

    private void p(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        float s10 = s(i10);
        while (i10 < state.getItemCount()) {
            float m10 = m(s10, this.f٨٦٢١h.g() / 2.0f);
            d O = O(this.f٨٦٢١h.h(), m10, false);
            float r10 = r(m10, O);
            if (!Q(r10, O)) {
                s10 = m(s10, this.f٨٦٢١h.g());
                if (!R(r10, O)) {
                    View viewForPosition = recycler.getViewForPosition(i10);
                    l(viewForPosition, -1, new b(viewForPosition, m10, r10, O));
                }
                i10++;
            } else {
                return;
            }
        }
    }

    private void q(RecyclerView.Recycler recycler, int i10) {
        float s10 = s(i10);
        while (i10 >= 0) {
            float m10 = m(s10, this.f٨٦٢١h.g() / 2.0f);
            d O = O(this.f٨٦٢١h.h(), m10, false);
            float r10 = r(m10, O);
            if (!R(r10, O)) {
                s10 = n(s10, this.f٨٦٢١h.g());
                if (!Q(r10, O)) {
                    View viewForPosition = recycler.getViewForPosition(i10);
                    l(viewForPosition, 0, new b(viewForPosition, m10, r10, O));
                }
                i10--;
            } else {
                return;
            }
        }
    }

    private float r(float f10, d dVar) {
        e.c cVar = dVar.f٨٦٣٦a;
        float f11 = cVar.f٨٦٧٨b;
        e.c cVar2 = dVar.f٨٦٣٧b;
        float b10 = p7.a.b(f11, cVar2.f٨٦٧٨b, cVar.f٨٦٧٧a, cVar2.f٨٦٧٧a, f10);
        if (dVar.f٨٦٣٧b == this.f٨٦٢١h.d() || dVar.f٨٦٣٦a == this.f٨٦٢١h.k()) {
            e.c cVar3 = dVar.f٨٦٣٧b;
            return b10 + ((f10 - cVar3.f٨٦٧٧a) * (1.0f - cVar3.f٨٦٧٩c));
        }
        return b10;
    }

    private float s(int i10) {
        return m(J() - this.f٨٦١٤a, this.f٨٦٢١h.g() * i10);
    }

    private int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f10;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        if (this.f٨٦٢٠g == null) {
            W(recycler);
        }
        if (getItemCount() <= B(this.f٨٦٢٠g).n()) {
            return 0;
        }
        int v10 = v(i10, this.f٨٦١٤a, this.f٨٦١٥b, this.f٨٦١٦c);
        this.f٨٦١٤a += v10;
        e0(this.f٨٦٢٠g);
        float g10 = this.f٨٦٢١h.g() / 2.0f;
        float s10 = s(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        if (P()) {
            f10 = this.f٨٦٢١h.i().f٨٦٧٨b;
        } else {
            f10 = this.f٨٦٢١h.b().f٨٦٧٨b;
        }
        float f11 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float abs = Math.abs(f10 - V(childAt, s10, g10, rect));
            if (childAt != null && abs < f11) {
                this.f٨٦٢٧n = getPosition(childAt);
                f11 = abs;
            }
            s10 = m(s10, this.f٨٦٢١h.g());
        }
        x(recycler, state);
        return v10;
    }

    private int t(RecyclerView.State state, f fVar) {
        e h10;
        e.c i10;
        float f10;
        boolean P = P();
        if (P) {
            h10 = fVar.l();
        } else {
            h10 = fVar.h();
        }
        if (P) {
            i10 = h10.b();
        } else {
            i10 = h10.i();
        }
        int i11 = 1;
        float itemCount = (state.getItemCount() - 1) * h10.g();
        if (P) {
            f10 = -1.0f;
        } else {
            f10 = 1.0f;
        }
        float J = (itemCount * f10) - (i10.f٨٦٧٧a - J());
        if (P) {
            i11 = -1;
        }
        int i12 = (int) (J + ((i11 * i10.f٨٦٨٠d) / 2.0f));
        if (P) {
            return Math.min(0, i12);
        }
        return Math.max(0, i12);
    }

    private static int v(int i10, int i11, int i12, int i13) {
        int i14 = i11 + i10;
        return i14 < i12 ? i12 - i11 : i14 > i13 ? i13 - i11 : i10;
    }

    private int w(f fVar) {
        e l10;
        e.c b10;
        boolean P = P();
        if (P) {
            l10 = fVar.h();
        } else {
            l10 = fVar.l();
        }
        if (P) {
            b10 = l10.i();
        } else {
            b10 = l10.b();
        }
        return (int) (J() - n(b10.f٨٦٧٧a, l10.g() / 2.0f));
    }

    private void x(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Y(recycler);
        if (getChildCount() == 0) {
            q(recycler, this.f٨٦٢٢i - 1);
            p(recycler, state, this.f٨٦٢٢i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            q(recycler, position - 1);
            p(recycler, state, position2 + 1);
        }
        g0();
    }

    private int y() {
        if (d()) {
            return a();
        }
        return b();
    }

    private float z(View view) {
        int centerY;
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        if (d()) {
            centerY = rect.centerX();
        } else {
            centerY = rect.centerY();
        }
        return centerY;
    }

    int F(int i10, e eVar) {
        return M(i10, eVar) - this.f٨٦١٤a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean P() {
        if (d() && getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // t7.a
    public int a() {
        return getWidth();
    }

    public void a0(int i10) {
        this.f٨٦٢٨o = i10;
        X();
    }

    @Override // t7.a
    public int b() {
        return getHeight();
    }

    @Override // t7.a
    public int c() {
        return this.f٨٦٢٨o;
    }

    public void c0(com.google.android.material.carousel.c cVar) {
        this.f٨٦١٩f = cVar;
        X();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() != 0 && this.f٨٦٢٠g != null && getItemCount() > 1) {
            return (int) (getWidth() * (this.f٨٦٢٠g.g().g() / computeHorizontalScrollRange(state)));
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f٨٦١٤a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.f٨٦١٦c - this.f٨٦١٥b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        if (this.f٨٦٢٠g == null) {
            return null;
        }
        int F = F(i10, C(i10));
        if (d()) {
            return new PointF(F, DownloadProgress.UNKNOWN_PROGRESS);
        }
        return new PointF(DownloadProgress.UNKNOWN_PROGRESS, F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() != 0 && this.f٨٦٢٠g != null && getItemCount() > 1) {
            return (int) (getHeight() * (this.f٨٦٢٠g.g().g() / computeVerticalScrollRange(state)));
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.f٨٦١٤a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.f٨٦١٦c - this.f٨٦١٥b;
    }

    @Override // t7.a
    public boolean d() {
        if (this.f٨٦٢٤k.f٨٦٥٤a == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        float f10;
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = rect.centerY();
        if (d()) {
            centerY = rect.centerX();
        }
        float E = E(centerY, O(this.f٨٦٢١h.h(), centerY, true));
        boolean d10 = d();
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if (d10) {
            f10 = (rect.width() - E) / 2.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (!d()) {
            f11 = (rect.height() - E) / 2.0f;
        }
        rect.set((int) (rect.left + f10), (int) (rect.top + f11), (int) (rect.right - f10), (int) (rect.bottom - f11));
    }

    public int getOrientation() {
        return this.f٨٦٢٤k.f٨٦٥٤a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i10, int i11) {
        float f10;
        float f11;
        if (view instanceof g) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            calculateItemDecorationsForChild(view, rect);
            int i12 = i10 + rect.left + rect.right;
            int i13 = i11 + rect.top + rect.bottom;
            f fVar = this.f٨٦٢٠g;
            if (fVar != null && this.f٨٦٢٤k.f٨٦٥٤a == 0) {
                f10 = fVar.g().g();
            } else {
                f10 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            }
            f fVar2 = this.f٨٦٢٠g;
            if (fVar2 != null && this.f٨٦٢٤k.f٨٦٥٤a == 1) {
                f11 = fVar2.g().g();
            } else {
                f11 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            }
            view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, (int) f10, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, (int) f11, canScrollVertically()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f٨٦١٩f.f(recyclerView.getContext());
        X();
        recyclerView.addOnLayoutChangeListener(this.f٨٦٢٥l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f٨٦٢٥l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            o(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        o(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z10;
        int i10;
        if (state.getItemCount() > 0 && y() > DownloadProgress.UNKNOWN_PROGRESS) {
            boolean P = P();
            f fVar = this.f٨٦٢٠g;
            if (fVar == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 || fVar.g().a() != y()) {
                W(recycler);
            }
            int w10 = w(this.f٨٦٢٠g);
            int t10 = t(state, this.f٨٦٢٠g);
            if (P) {
                i10 = t10;
            } else {
                i10 = w10;
            }
            this.f٨٦١٥b = i10;
            if (P) {
                t10 = w10;
            }
            this.f٨٦١٦c = t10;
            if (z10) {
                this.f٨٦١٤a = w10;
                this.f٨٦٢٣j = this.f٨٦٢٠g.i(getItemCount(), this.f٨٦١٥b, this.f٨٦١٦c, P());
                int i11 = this.f٨٦٢٧n;
                if (i11 != -1) {
                    this.f٨٦١٤a = M(i11, C(i11));
                }
            }
            int i12 = this.f٨٦١٤a;
            this.f٨٦١٤a = i12 + v(0, i12, this.f٨٦١٥b, this.f٨٦١٦c);
            this.f٨٦٢٢i = j2.a.b(this.f٨٦٢٢i, 0, state.getItemCount());
            e0(this.f٨٦٢٠g);
            detachAndScrapAttachedViews(recycler);
            x(recycler, state);
            this.f٨٦٢٦m = getItemCount();
            return;
        }
        removeAndRecycleAllViews(recycler);
        this.f٨٦٢٢i = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.f٨٦٢٢i = 0;
        } else {
            this.f٨٦٢٢i = getPosition(getChildAt(0));
        }
        g0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        int N;
        if (this.f٨٦٢٠g == null || (N = N(getPosition(view), C(getPosition(view)))) == 0) {
            return false;
        }
        Z(recyclerView, N(getPosition(view), this.f٨٦٢٠g.j(this.f٨٦١٤a + v(N, this.f٨٦١٤a, this.f٨٦١٥b, this.f٨٦١٦c), this.f٨٦١٥b, this.f٨٦١٦c)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f٨٦٢٧n = i10;
        if (this.f٨٦٢٠g == null) {
            return;
        }
        this.f٨٦١٤a = M(i10, C(i10));
        this.f٨٦٢٢i = j2.a.b(i10, 0, Math.max(0, getItemCount() - 1));
        e0(this.f٨٦٢٠g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        com.google.android.material.carousel.b bVar = this.f٨٦٢٤k;
        if (bVar == null || i10 != bVar.f٨٦٥٤a) {
            this.f٨٦٢٤k = com.google.android.material.carousel.b.c(this, i10);
            X();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    int u(int i10) {
        return (int) (this.f٨٦١٤a - M(i10, C(i10)));
    }

    public CarouselLayoutManager(com.google.android.material.carousel.c cVar) {
        this(cVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.c cVar, int i10) {
        this.f٨٦١٧d = false;
        this.f٨٦١٨e = new c();
        this.f٨٦٢٢i = 0;
        this.f٨٦٢٥l = new View.OnLayoutChangeListener() { // from class: t7.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.this.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f٨٦٢٧n = -1;
        this.f٨٦٢٨o = 0;
        c0(cVar);
        setOrientation(i10);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f٨٦١٧d = false;
        this.f٨٦١٨e = new c();
        this.f٨٦٢٢i = 0;
        this.f٨٦٢٥l = new View.OnLayoutChangeListener() { // from class: t7.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i112, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.this.S(view, i112, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f٨٦٢٧n = -1;
        this.f٨٦٢٨o = 0;
        c0(new h());
        b0(context, attributeSet);
    }
}
