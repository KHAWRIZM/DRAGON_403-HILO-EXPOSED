package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.util.Pools;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import androidx.core.view.t;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CoordinatorLayout extends ViewGroup implements f0, g0 {

    /* renamed from: u, reason: collision with root package name */
    static final String f٢٥٣٢u;

    /* renamed from: v, reason: collision with root package name */
    static final Class[] f٢٥٣٣v;

    /* renamed from: w, reason: collision with root package name */
    static final ThreadLocal f٢٥٣٤w;

    /* renamed from: x, reason: collision with root package name */
    static final Comparator f٢٥٣٥x;

    /* renamed from: y, reason: collision with root package name */
    private static final Pools.Pool f٢٥٣٦y;

    /* renamed from: a, reason: collision with root package name */
    private final List f٢٥٣٧a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.b f٢٥٣٨b;

    /* renamed from: c, reason: collision with root package name */
    private final List f٢٥٣٩c;

    /* renamed from: d, reason: collision with root package name */
    private final List f٢٥٤٠d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f٢٥٤١e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f٢٥٤٢f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f٢٥٤٣g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٢٥٤٤h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٢٥٤٥i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f٢٥٤٦j;

    /* renamed from: k, reason: collision with root package name */
    private View f٢٥٤٧k;

    /* renamed from: l, reason: collision with root package name */
    private View f٢٥٤٨l;

    /* renamed from: m, reason: collision with root package name */
    private g f٢٥٤٩m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٢٥٥٠n;

    /* renamed from: o, reason: collision with root package name */
    private d2 f٢٥٥١o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٢٥٥٢p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f٢٥٥٣q;

    /* renamed from: r, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f٢٥٥٤r;

    /* renamed from: s, reason: collision with root package name */
    private j0 f٢٥٥٥s;

    /* renamed from: t, reason: collision with root package name */
    private final i0 f٢٥٥٦t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return CoordinatorLayout.this.c0(d2Var);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class c {
        public c() {
        }

        public void A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10) {
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
            if (i11 == 0) {
                A(coordinatorLayout, view, view2, view3, i10);
            }
        }

        public boolean C(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            return false;
        }

        public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean F(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10) {
            return false;
        }

        public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
            if (i11 == 0) {
                return F(coordinatorLayout, view, view2, view3, i10);
            }
            return false;
        }

        public void H(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void I(CoordinatorLayout coordinatorLayout, View view, View view2, int i10) {
            if (i10 == 0) {
                H(coordinatorLayout, view, view2);
            }
        }

        public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean g(CoordinatorLayout coordinatorLayout, View view) {
            if (j(coordinatorLayout, view) > DownloadProgress.UNKNOWN_PROGRESS) {
                return true;
            }
            return false;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int i(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float j(CoordinatorLayout coordinatorLayout, View view) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public d2 l(CoordinatorLayout coordinatorLayout, View view, d2 d2Var) {
            return d2Var;
        }

        public void m(f fVar) {
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void o(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void p() {
        }

        public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return false;
        }

        public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean u(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11) {
            return false;
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr) {
        }

        public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                v(coordinatorLayout, view, view2, i10, i11, iArr);
            }
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13) {
        }

        public void y(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                x(coordinatorLayout, view, view2, i10, i11, i12, i13);
            }
        }

        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            y(coordinatorLayout, view, view2, i10, i11, i12, i13, i14);
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public @interface d {
        Class value();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f٢٥٥٤r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.N(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f٢٥٥٤r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.N(0);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class h implements Comparator {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float Q = d1.Q(view);
            float Q2 = d1.Q(view2);
            if (Q > Q2) {
                return -1;
            }
            if (Q < Q2) {
                return 1;
            }
            return 0;
        }
    }

    static {
        String str;
        Package r02 = CoordinatorLayout.class.getPackage();
        if (r02 != null) {
            str = r02.getName();
        } else {
            str = null;
        }
        f٢٥٣٢u = str;
        f٢٥٣٥x = new h();
        f٢٥٣٣v = new Class[]{Context.class, AttributeSet.class};
        f٢٥٣٤w = new ThreadLocal();
        f٢٥٣٦y = new Pools.SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private void B(View view, int i10, Rect rect, Rect rect2, f fVar, int i11, int i12) {
        int width;
        int height;
        int b10 = t.b(X(fVar.f٢٥٦٢c), i10);
        int b11 = t.b(Y(fVar.f٢٥٦٣d), i10);
        int i13 = b10 & 7;
        int i14 = b10 & 112;
        int i15 = b11 & 7;
        int i16 = b11 & 112;
        if (i15 != 1) {
            if (i15 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i16 != 16) {
            if (i16 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i13 != 1) {
            if (i13 != 5) {
                width -= i11;
            }
        } else {
            width -= i11 / 2;
        }
        if (i14 != 16) {
            if (i14 != 80) {
                height -= i12;
            }
        } else {
            height -= i12 / 2;
        }
        rect2.set(width, height, i11 + width, i12 + height);
    }

    private int C(int i10) {
        int[] iArr = this.f٢٥٤٦j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    private void F(List list) {
        int i10;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            if (isChildrenDrawingOrderEnabled) {
                i10 = getChildDrawingOrder(childCount, i11);
            } else {
                i10 = i11;
            }
            list.add(getChildAt(i10));
        }
        Comparator comparator = f٢٥٣٥x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean G(View view) {
        return this.f٢٥٣٨b.j(view);
    }

    private void I(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        Rect m10 = m();
        m10.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f٢٥٥١o != null && d1.A(this) && !d1.A(view)) {
            m10.left += this.f٢٥٥١o.k();
            m10.top += this.f٢٥٥١o.m();
            m10.right -= this.f٢٥٥١o.l();
            m10.bottom -= this.f٢٥٥١o.j();
        }
        Rect m11 = m();
        t.a(Y(fVar.f٢٥٦٢c), view.getMeasuredWidth(), view.getMeasuredHeight(), m10, m11, i10);
        view.layout(m11.left, m11.top, m11.right, m11.bottom);
        U(m10);
        U(m11);
    }

    private void J(View view, View view2, int i10) {
        Rect m10 = m();
        Rect m11 = m();
        try {
            z(view2, m10);
            A(view, i10, m10, m11);
            view.layout(m11.left, m11.top, m11.right, m11.bottom);
        } finally {
            U(m10);
            U(m11);
        }
    }

    private void K(View view, int i10, int i11) {
        int i12;
        f fVar = (f) view.getLayoutParams();
        int b10 = t.b(Z(fVar.f٢٥٦٢c), i11);
        int i13 = b10 & 7;
        int i14 = b10 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int C = C(i10) - measuredWidth;
        if (i13 != 1) {
            if (i13 == 5) {
                C += measuredWidth;
            }
        } else {
            C += measuredWidth / 2;
        }
        if (i14 != 16) {
            if (i14 != 80) {
                i12 = 0;
            } else {
                i12 = measuredHeight;
            }
        } else {
            i12 = measuredHeight / 2;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(C, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i12, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void L(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (d1.V(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f10 = fVar.f();
            Rect m10 = m();
            Rect m11 = m();
            m11.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f10 != null && f10.h(this, view, m10)) {
                if (!m11.contains(m10)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + m10.toShortString() + " | Bounds:" + m11.toShortString());
                }
            } else {
                m10.set(m11);
            }
            U(m11);
            if (m10.isEmpty()) {
                U(m10);
                return;
            }
            int b10 = t.b(fVar.f٢٥٦٧h, i10);
            boolean z12 = true;
            if ((b10 & 48) == 48 && (i15 = (m10.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f٢٥٦٩j) < (i16 = rect.top)) {
                b0(view, i16 - i15);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 80) == 80 && (height = ((getHeight() - m10.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f٢٥٦٩j) < (i14 = rect.bottom)) {
                b0(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                b0(view, 0);
            }
            if ((b10 & 3) == 3 && (i12 = (m10.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f٢٥٦٨i) < (i13 = rect.left)) {
                a0(view, i13 - i12);
                z11 = true;
            } else {
                z11 = false;
            }
            if ((b10 & 5) == 5 && (width = ((getWidth() - m10.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f٢٥٦٨i) < (i11 = rect.right)) {
                a0(view, width - i11);
            } else {
                z12 = z11;
            }
            if (!z12) {
                a0(view, 0);
            }
            U(m10);
        }
    }

    static c Q(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(InstructionFileId.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f٢٥٣٢u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f٢٥٣٤w;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f٢٥٣٣v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    private boolean R(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f٢٥٣٩c;
        F(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) list.get(i11);
            f fVar = (f) view.getLayoutParams();
            c f10 = fVar.f();
            if ((z10 || z11) && actionMasked != 0) {
                if (f10 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
                    }
                    if (i10 != 0) {
                        if (i10 == 1) {
                            f10.J(this, view, motionEvent2);
                        }
                    } else {
                        f10.q(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z10 && f10 != null) {
                    if (i10 != 0) {
                        if (i10 == 1) {
                            z10 = f10.J(this, view, motionEvent);
                        }
                    } else {
                        z10 = f10.q(this, view, motionEvent);
                    }
                    if (z10) {
                        this.f٢٥٤٧k = view;
                    }
                }
                boolean c10 = fVar.c();
                boolean i12 = fVar.i(this, view);
                if (i12 && !c10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i12 && !z11) {
                    break;
                }
            }
        }
        list.clear();
        return z10;
    }

    private void S() {
        this.f٢٥٣٧a.clear();
        this.f٢٥٣٨b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f E = E(childAt);
            E.d(this, childAt);
            this.f٢٥٣٨b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (E.b(this, childAt, childAt2)) {
                        if (!this.f٢٥٣٨b.d(childAt2)) {
                            this.f٢٥٣٨b.b(childAt2);
                        }
                        this.f٢٥٣٨b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f٢٥٣٧a.addAll(this.f٢٥٣٨b.i());
        Collections.reverse(this.f٢٥٣٧a);
    }

    private static void U(Rect rect) {
        rect.setEmpty();
        f٢٥٣٦y.release(rect);
    }

    private void W(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c f10 = ((f) childAt.getLayoutParams()).f();
            if (f10 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
                if (z10) {
                    f10.q(this, childAt, obtain);
                } else {
                    f10.J(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).m();
        }
        this.f٢٥٤٧k = null;
        this.f٢٥٤٤h = false;
    }

    private static int X(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    private static int Y(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    private static int Z(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    private void a0(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f٢٥٦٨i;
        if (i11 != i10) {
            d1.a0(view, i10 - i11);
            fVar.f٢٥٦٨i = i10;
        }
    }

    private void b0(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f٢٥٦٩j;
        if (i11 != i10) {
            d1.b0(view, i10 - i11);
            fVar.f٢٥٦٩j = i10;
        }
    }

    private void d0() {
        if (d1.A(this)) {
            if (this.f٢٥٥٥s == null) {
                this.f٢٥٥٥s = new a();
            }
            d1.E0(this, this.f٢٥٥٥s);
            setSystemUiVisibility(1280);
            return;
        }
        d1.E0(this, null);
    }

    private static Rect m() {
        Rect rect = (Rect) f٢٥٣٦y.acquire();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    private static int o(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void p(f fVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    private d2 q(d2 d2Var) {
        c f10;
        if (d2Var.q()) {
            return d2Var;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (d1.A(childAt) && (f10 = ((f) childAt.getLayoutParams()).f()) != null) {
                d2Var = f10.l(this, childAt, d2Var);
                if (d2Var.q()) {
                    break;
                }
            }
        }
        return d2Var;
    }

    void A(View view, int i10, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        B(view, i10, rect, rect2, fVar, measuredWidth, measuredHeight);
        p(fVar, rect2, measuredWidth, measuredHeight);
    }

    void D(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f E(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f٢٥٦١b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f٢٥٦١b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o((c) dVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
                fVar.f٢٥٦١b = true;
            }
        }
        return fVar;
    }

    public boolean H(View view, int i10, int i11) {
        Rect m10 = m();
        z(view, m10);
        try {
            return m10.contains(i10, i11);
        } finally {
            U(m10);
        }
    }

    void M(View view, int i10) {
        c f10;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f٢٥٧٠k != null) {
            Rect m10 = m();
            Rect m11 = m();
            Rect m12 = m();
            z(fVar.f٢٥٧٠k, m10);
            boolean z10 = false;
            w(view, false, m11);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            B(view, i10, m10, m12, fVar, measuredWidth, measuredHeight);
            if (m12.left != m11.left || m12.top != m11.top) {
                z10 = true;
            }
            p(fVar, m12, measuredWidth, measuredHeight);
            int i11 = m12.left - m11.left;
            int i12 = m12.top - m11.top;
            if (i11 != 0) {
                d1.a0(view, i11);
            }
            if (i12 != 0) {
                d1.b0(view, i12);
            }
            if (z10 && (f10 = fVar.f()) != null) {
                f10.n(this, view, fVar.f٢٥٧٠k);
            }
            U(m10);
            U(m11);
            U(m12);
        }
    }

    final void N(int i10) {
        boolean z10;
        int D = d1.D(this);
        int size = this.f٢٥٣٧a.size();
        Rect m10 = m();
        Rect m11 = m();
        Rect m12 = m();
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) this.f٢٥٣٧a.get(i11);
            f fVar = (f) view.getLayoutParams();
            if (i10 != 0 || view.getVisibility() != 8) {
                for (int i12 = 0; i12 < i11; i12++) {
                    if (fVar.f٢٥٧١l == ((View) this.f٢٥٣٧a.get(i12))) {
                        M(view, D);
                    }
                }
                w(view, true, m11);
                if (fVar.f٢٥٦٦g != 0 && !m11.isEmpty()) {
                    int b10 = t.b(fVar.f٢٥٦٦g, D);
                    int i13 = b10 & 112;
                    if (i13 != 48) {
                        if (i13 == 80) {
                            m10.bottom = Math.max(m10.bottom, getHeight() - m11.top);
                        }
                    } else {
                        m10.top = Math.max(m10.top, m11.bottom);
                    }
                    int i14 = b10 & 7;
                    if (i14 != 3) {
                        if (i14 == 5) {
                            m10.right = Math.max(m10.right, getWidth() - m11.left);
                        }
                    } else {
                        m10.left = Math.max(m10.left, m11.right);
                    }
                }
                if (fVar.f٢٥٦٧h != 0 && view.getVisibility() == 0) {
                    L(view, m10, D);
                }
                if (i10 != 2) {
                    D(view, m12);
                    if (!m12.equals(m11)) {
                        T(view, m11);
                    }
                }
                for (int i15 = i11 + 1; i15 < size; i15++) {
                    View view2 = (View) this.f٢٥٣٧a.get(i15);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f10 = fVar2.f();
                    if (f10 != null && f10.k(this, view2, view)) {
                        if (i10 == 0 && fVar2.g()) {
                            fVar2.k();
                        } else {
                            if (i10 != 2) {
                                z10 = f10.n(this, view2, view);
                            } else {
                                f10.o(this, view2, view);
                                z10 = true;
                            }
                            if (i10 == 1) {
                                fVar2.p(z10);
                            }
                        }
                    }
                }
            }
        }
        U(m10);
        U(m11);
        U(m12);
    }

    public void O(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.f٢٥٧٠k;
            if (view2 != null) {
                J(view, view2, i10);
                return;
            }
            int i11 = fVar.f٢٥٦٤e;
            if (i11 >= 0) {
                K(view, i11, i10);
                return;
            } else {
                I(view, i10);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void P(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    void T(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void V() {
        if (this.f٢٥٤٥i && this.f٢٥٤٩m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f٢٥٤٩m);
        }
        this.f٢٥٥٠n = false;
    }

    final d2 c0(d2 d2Var) {
        boolean z10;
        if (!androidx.core.util.f.a(this.f٢٥٥١o, d2Var)) {
            this.f٢٥٥١o = d2Var;
            boolean z11 = false;
            if (d2Var != null && d2Var.m() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f٢٥٥٢p = z10;
            if (!z10 && getBackground() == null) {
                z11 = true;
            }
            setWillNotDraw(z11);
            d2 q10 = q(d2Var);
            requestLayout();
            return q10;
        }
        return d2Var;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof f) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f٢٥٦٠a;
        if (cVar != null) {
            float j11 = cVar.j(this, view);
            if (j11 > DownloadProgress.UNKNOWN_PROGRESS) {
                if (this.f٢٥٤١e == null) {
                    this.f٢٥٤١e = new Paint();
                }
                this.f٢٥٤١e.setColor(fVar.f٢٥٦٠a.i(this, view));
                this.f٢٥٤١e.setAlpha(o(Math.round(j11 * 255.0f), 0, KotlinVersion.MAX_COMPONENT_VALUE));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f٢٥٤١e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f٢٥٥٣q;
        if (drawable != null && drawable.isStateful()) {
            z10 = drawable.setState(drawableState);
        } else {
            z10 = false;
        }
        if (z10) {
            invalidate();
        }
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        S();
        return Collections.unmodifiableList(this.f٢٥٣٧a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final d2 getLastWindowInsets() {
        return this.f٢٥٥١o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f٢٥٥٦t.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f٢٥٥٣q;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    void n() {
        if (this.f٢٥٤٥i) {
            if (this.f٢٥٤٩m == null) {
                this.f٢٥٤٩m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f٢٥٤٩m);
        }
        this.f٢٥٥٠n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        W(false);
        if (this.f٢٥٥٠n) {
            if (this.f٢٥٤٩m == null) {
                this.f٢٥٤٩m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f٢٥٤٩m);
        }
        if (this.f٢٥٥١o == null && d1.A(this)) {
            d1.n0(this);
        }
        this.f٢٥٤٥i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        W(false);
        if (this.f٢٥٥٠n && this.f٢٥٤٩m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f٢٥٤٩m);
        }
        View view = this.f٢٥٤٨l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f٢٥٤٥i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (this.f٢٥٥٢p && this.f٢٥٥٣q != null) {
            d2 d2Var = this.f٢٥٥١o;
            if (d2Var != null) {
                i10 = d2Var.m();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f٢٥٥٣q.setBounds(0, 0, getWidth(), i10);
                this.f٢٥٥٣q.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            W(true);
        }
        boolean R = R(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            W(true);
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c f10;
        int D = d1.D(this);
        int size = this.f٢٥٣٧a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) this.f٢٥٣٧a.get(i14);
            if (view.getVisibility() != 8 && ((f10 = ((f) view.getLayoutParams()).f()) == null || !f10.r(this, view, D))) {
                O(view, D);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011c, code lost:
    
        if (r0.s(r30, r20, r11, r21, r23, 0) == false) goto L٤٧;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        int i15;
        c f10;
        f fVar;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        S();
        s();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int D = d1.D(this);
        if (D == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int i22 = paddingLeft + paddingRight;
        int i23 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (this.f٢٥٥١o != null && d1.A(this)) {
            z11 = true;
        } else {
            z11 = false;
        }
        int size3 = this.f٢٥٣٧a.size();
        int i24 = suggestedMinimumWidth;
        int i25 = suggestedMinimumHeight;
        int i26 = 0;
        int i27 = 0;
        while (i27 < size3) {
            View view = (View) this.f٢٥٣٧a.get(i27);
            if (view.getVisibility() == 8) {
                i20 = i27;
                i17 = size3;
                i18 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i28 = fVar2.f٢٥٦٤e;
                if (i28 >= 0 && mode != 0) {
                    int C = C(i28);
                    int b10 = t.b(Z(fVar2.f٢٥٦٢c), D) & 7;
                    i12 = i26;
                    if ((b10 == 3 && !z10) || (b10 == 5 && z10)) {
                        i13 = Math.max(0, (size - paddingRight) - C);
                    } else if ((b10 == 5 && !z10) || (b10 == 3 && z10)) {
                        i13 = Math.max(0, C - paddingLeft);
                    }
                    if (!z11 && !d1.A(view)) {
                        int k10 = this.f٢٥٥١o.k() + this.f٢٥٥١o.l();
                        int m10 = this.f٢٥٥١o.m() + this.f٢٥٥١o.j();
                        i14 = View.MeasureSpec.makeMeasureSpec(size - k10, mode);
                        i15 = View.MeasureSpec.makeMeasureSpec(size2 - m10, mode2);
                    } else {
                        i14 = i10;
                        i15 = i11;
                    }
                    f10 = fVar2.f();
                    if (f10 == null) {
                        fVar = fVar2;
                        i19 = i12;
                        i20 = i27;
                        i16 = i25;
                        i18 = paddingLeft;
                        i21 = i24;
                        i17 = size3;
                    } else {
                        fVar = fVar2;
                        i16 = i25;
                        i17 = size3;
                        i18 = paddingLeft;
                        i19 = i12;
                        i20 = i27;
                        i21 = i24;
                    }
                    P(view, i14, i13, i15, 0);
                    f fVar3 = fVar;
                    int max = Math.max(i21, i22 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                    int max2 = Math.max(i16, i23 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                    i26 = View.combineMeasuredStates(i19, view.getMeasuredState());
                    i24 = max;
                    i25 = max2;
                } else {
                    i12 = i26;
                }
                i13 = 0;
                if (!z11) {
                }
                i14 = i10;
                i15 = i11;
                f10 = fVar2.f();
                if (f10 == null) {
                }
                P(view, i14, i13, i15, 0);
                f fVar32 = fVar;
                int max3 = Math.max(i21, i22 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar32).leftMargin + ((ViewGroup.MarginLayoutParams) fVar32).rightMargin);
                int max22 = Math.max(i16, i23 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar32).topMargin + ((ViewGroup.MarginLayoutParams) fVar32).bottomMargin);
                i26 = View.combineMeasuredStates(i19, view.getMeasuredState());
                i24 = max3;
                i25 = max22;
            }
            i27 = i20 + 1;
            paddingLeft = i18;
            size3 = i17;
        }
        int i29 = i26;
        setMeasuredDimension(View.resolveSizeAndState(i24, i10, (-16777216) & i29), View.resolveSizeAndState(i25, i11, i29 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        c f12;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f12 = fVar.f()) != null) {
                    z11 |= f12.t(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (z11) {
            N(1);
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        c f12;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f12 = fVar.f()) != null) {
                    z10 |= f12.u(this, childAt, view, f10, f11);
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray sparseArray = savedState.f٢٥٥٧a;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            c f10 = E(childAt).f();
            if (id != -1 && f10 != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                f10.D(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable E;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            c f10 = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && f10 != null && (E = f10.E(this, childAt)) != null) {
                sparseArray.append(id, E);
            }
        }
        savedState.f٢٥٥٧a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L٩;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean J;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.f٢٥٤٧k == null) {
            z10 = R(motionEvent, 1);
        } else {
            z10 = false;
        }
        c f10 = ((f) this.f٢٥٤٧k.getLayoutParams()).f();
        if (f10 != null) {
            J = f10.J(this, this.f٢٥٤٧k, motionEvent);
            motionEvent2 = null;
            if (this.f٢٥٤٧k != null) {
                J |= super.onTouchEvent(motionEvent);
            } else if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                W(false);
            }
            return J;
        }
        J = false;
        motionEvent2 = null;
        if (this.f٢٥٤٧k != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked != 1) {
        }
        W(false);
        return J;
    }

    public void r(View view) {
        List g10 = this.f٢٥٣٨b.g(view);
        if (g10 != null && !g10.isEmpty()) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                View view2 = (View) g10.get(i10);
                c f10 = ((f) view2.getLayoutParams()).f();
                if (f10 != null) {
                    f10.n(this, view2, view);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c f10 = ((f) view.getLayoutParams()).f();
        if (f10 != null && f10.C(this, view, rect, z10)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.f٢٥٤٤h) {
            W(false);
            this.f٢٥٤٤h = true;
        }
    }

    void s() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (G(getChildAt(i10))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 != this.f٢٥٥٠n) {
            if (z10) {
                n();
            } else {
                V();
            }
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        d0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f٢٥٥٤r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f٢٥٥٣q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f٢٥٥٣q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f٢٥٥٣q.setState(getDrawableState());
                }
                h2.b.m(this.f٢٥٥٣q, d1.D(this));
                Drawable drawable4 = this.f٢٥٥٣q;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f٢٥٥٣q.setCallback(this);
            }
            d1.h0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = androidx.core.content.a.getDrawable(getContext(), i10);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f٢٥٥٣q;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f٢٥٥٣q.setVisible(z10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f٢٥٥٣q) {
            return false;
        }
        return true;
    }

    void w(View view, boolean z10, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z10) {
                z(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    public List x(View view) {
        List h10 = this.f٢٥٣٨b.h(view);
        this.f٢٥٤٠d.clear();
        if (h10 != null) {
            this.f٢٥٤٠d.addAll(h10);
        }
        return this.f٢٥٤٠d;
    }

    public List y(View view) {
        List g10 = this.f٢٥٣٨b.g(view);
        this.f٢٥٤٠d.clear();
        if (g10 != null) {
            this.f٢٥٤٠d.addAll(g10);
        }
        return this.f٢٥٤٠d;
    }

    void z(View view, Rect rect) {
        androidx.coordinatorlayout.widget.c.a(this, view, rect);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        c f10;
        int childCount = getChildCount();
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i12) && (f10 = fVar.f()) != null) {
                    int[] iArr2 = this.f٢٥٤٢f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.w(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f٢٥٤٢f;
                    i13 = i10 > 0 ? Math.max(i13, iArr3[0]) : Math.min(i13, iArr3[0]);
                    int[] iArr4 = this.f٢٥٤٢f;
                    i14 = i11 > 0 ? Math.max(i14, iArr4[1]) : Math.min(i14, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = i13;
        iArr[1] = i14;
        if (z10) {
            N(1);
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f٢٥٤٣g);
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        c f10;
        this.f٢٥٥٦t.c(view, view2, i10, i11);
        this.f٢٥٤٨l = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i11) && (f10 = fVar.f()) != null) {
                f10.B(this, childAt, view, view2, i10, i11);
            }
        }
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f10 = fVar.f();
                if (f10 != null) {
                    boolean G = f10.G(this, childAt, view, view2, i10, i11);
                    z10 |= G;
                    fVar.r(i11, G);
                } else {
                    fVar.r(i11, false);
                }
            }
        }
        return z10;
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        this.f٢٥٥٦t.e(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i10)) {
                c f10 = fVar.f();
                if (f10 != null) {
                    f10.I(this, childAt, view, i10);
                }
                fVar.l(i10);
                fVar.k();
            }
        }
        this.f٢٥٤٨l = null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes;
        this.f٢٥٣٧a = new ArrayList();
        this.f٢٥٣٨b = new androidx.coordinatorlayout.widget.b();
        this.f٢٥٣٩c = new ArrayList();
        this.f٢٥٤٠d = new ArrayList();
        this.f٢٥٤٢f = new int[2];
        this.f٢٥٤٣g = new int[2];
        this.f٢٥٥٦t = new i0(this);
        if (i10 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i10, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i10 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i10, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f٢٥٤٦j = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f٢٥٤٦j.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f٢٥٤٦j[i11] = (int) (r12[i11] * f10);
            }
        }
        this.f٢٥٥٣q = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        d0();
        super.setOnHierarchyChangeListener(new e());
        if (d1.B(this) == 0) {
            d1.z0(this, 1);
        }
    }

    @Override // androidx.core.view.g0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        c f10;
        int min;
        int childCount = getChildCount();
        boolean z10 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i14) && (f10 = fVar.f()) != null) {
                    int[] iArr2 = this.f٢٥٤٢f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.z(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f٢٥٤٢f;
                    i15 = i12 > 0 ? Math.max(i15, iArr3[0]) : Math.min(i15, iArr3[0]);
                    if (i13 > 0) {
                        min = Math.max(i16, this.f٢٥٤٢f[1]);
                    } else {
                        min = Math.min(i16, this.f٢٥٤٢f[1]);
                    }
                    i16 = min;
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i15;
        iArr[1] = iArr[1] + i16;
        if (z10) {
            N(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        SparseArray f٢٥٥٧a;

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
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f٢٥٥٧a = new SparseArray(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f٢٥٥٧a.append(iArr[i10], readParcelableArray[i10]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int i11;
            super.writeToParcel(parcel, i10);
            SparseArray sparseArray = this.f٢٥٥٧a;
            if (sparseArray != null) {
                i11 = sparseArray.size();
            } else {
                i11 = 0;
            }
            parcel.writeInt(i11);
            int[] iArr = new int[i11];
            Parcelable[] parcelableArr = new Parcelable[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = this.f٢٥٥٧a.keyAt(i12);
                parcelableArr[i12] = (Parcelable) this.f٢٥٥٧a.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        c f٢٥٦٠a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٢٥٦١b;

        /* renamed from: c, reason: collision with root package name */
        public int f٢٥٦٢c;

        /* renamed from: d, reason: collision with root package name */
        public int f٢٥٦٣d;

        /* renamed from: e, reason: collision with root package name */
        public int f٢٥٦٤e;

        /* renamed from: f, reason: collision with root package name */
        int f٢٥٦٥f;

        /* renamed from: g, reason: collision with root package name */
        public int f٢٥٦٦g;

        /* renamed from: h, reason: collision with root package name */
        public int f٢٥٦٧h;

        /* renamed from: i, reason: collision with root package name */
        int f٢٥٦٨i;

        /* renamed from: j, reason: collision with root package name */
        int f٢٥٦٩j;

        /* renamed from: k, reason: collision with root package name */
        View f٢٥٧٠k;

        /* renamed from: l, reason: collision with root package name */
        View f٢٥٧١l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f٢٥٧٢m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f٢٥٧٣n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f٢٥٧٤o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f٢٥٧٥p;

        /* renamed from: q, reason: collision with root package name */
        final Rect f٢٥٧٦q;

        /* renamed from: r, reason: collision with root package name */
        Object f٢٥٧٧r;

        public f(int i10, int i11) {
            super(i10, i11);
            this.f٢٥٦١b = false;
            this.f٢٥٦٢c = 0;
            this.f٢٥٦٣d = 0;
            this.f٢٥٦٤e = -1;
            this.f٢٥٦٥f = -1;
            this.f٢٥٦٦g = 0;
            this.f٢٥٦٧h = 0;
            this.f٢٥٧٦q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f٢٥٦٥f);
            this.f٢٥٧٠k = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f٢٥٧١l = null;
                        this.f٢٥٧٠k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f٢٥٧١l = null;
                            this.f٢٥٧٠k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = parent;
                    }
                }
                this.f٢٥٧١l = findViewById;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.f٢٥٧١l = null;
                this.f٢٥٧٠k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f٢٥٦٥f) + " to anchor view " + view);
        }

        private boolean s(View view, int i10) {
            int b10 = t.b(((f) view.getLayoutParams()).f٢٥٦٦g, i10);
            if (b10 != 0 && (t.b(this.f٢٥٦٧h, i10) & b10) == b10) {
                return true;
            }
            return false;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f٢٥٧٠k.getId() != this.f٢٥٦٥f) {
                return false;
            }
            View view2 = this.f٢٥٧٠k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.f٢٥٧١l = null;
                    this.f٢٥٧٠k = null;
                    return false;
                }
            }
            this.f٢٥٧١l = view2;
            return true;
        }

        boolean a() {
            if (this.f٢٥٧٠k == null && this.f٢٥٦٥f != -1) {
                return true;
            }
            return false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            if (view2 != this.f٢٥٧١l && !s(view2, d1.D(coordinatorLayout)) && ((cVar = this.f٢٥٦٠a) == null || !cVar.k(coordinatorLayout, view, view2))) {
                return false;
            }
            return true;
        }

        boolean c() {
            if (this.f٢٥٦٠a == null) {
                this.f٢٥٧٢m = false;
            }
            return this.f٢٥٧٢m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f٢٥٦٥f == -1) {
                this.f٢٥٧١l = null;
                this.f٢٥٧٠k = null;
                return null;
            }
            if (this.f٢٥٧٠k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f٢٥٧٠k;
        }

        public int e() {
            return this.f٢٥٦٥f;
        }

        public c f() {
            return this.f٢٥٦٠a;
        }

        boolean g() {
            return this.f٢٥٧٥p;
        }

        Rect h() {
            return this.f٢٥٧٦q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10;
            boolean z11 = this.f٢٥٧٢m;
            if (z11) {
                return true;
            }
            c cVar = this.f٢٥٦٠a;
            if (cVar != null) {
                z10 = cVar.g(coordinatorLayout, view);
            } else {
                z10 = false;
            }
            boolean z12 = z10 | z11;
            this.f٢٥٧٢m = z12;
            return z12;
        }

        boolean j(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    return false;
                }
                return this.f٢٥٧٤o;
            }
            return this.f٢٥٧٣n;
        }

        void k() {
            this.f٢٥٧٥p = false;
        }

        void l(int i10) {
            r(i10, false);
        }

        void m() {
            this.f٢٥٧٢m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f٢٥٦٠a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.p();
                }
                this.f٢٥٦٠a = cVar;
                this.f٢٥٧٧r = null;
                this.f٢٥٦١b = true;
                if (cVar != null) {
                    cVar.m(this);
                }
            }
        }

        void p(boolean z10) {
            this.f٢٥٧٥p = z10;
        }

        void q(Rect rect) {
            this.f٢٥٧٦q.set(rect);
        }

        void r(int i10, boolean z10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    this.f٢٥٧٤o = z10;
                    return;
                }
                return;
            }
            this.f٢٥٧٣n = z10;
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٢٥٦١b = false;
            this.f٢٥٦٢c = 0;
            this.f٢٥٦٣d = 0;
            this.f٢٥٦٤e = -1;
            this.f٢٥٦٥f = -1;
            this.f٢٥٦٦g = 0;
            this.f٢٥٦٧h = 0;
            this.f٢٥٧٦q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f٢٥٦٢c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f٢٥٦٥f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f٢٥٦٣d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f٢٥٦٤e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f٢٥٦٦g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f٢٥٦٧h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i10);
            this.f٢٥٦١b = hasValue;
            if (hasValue) {
                this.f٢٥٦٠a = CoordinatorLayout.Q(context, attributeSet, obtainStyledAttributes.getString(i10));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f٢٥٦٠a;
            if (cVar != null) {
                cVar.m(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f٢٥٦١b = false;
            this.f٢٥٦٢c = 0;
            this.f٢٥٦٣d = 0;
            this.f٢٥٦٤e = -1;
            this.f٢٥٦٥f = -1;
            this.f٢٥٦٦g = 0;
            this.f٢٥٦٧h = 0;
            this.f٢٥٧٦q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f٢٥٦١b = false;
            this.f٢٥٦٢c = 0;
            this.f٢٥٦٣d = 0;
            this.f٢٥٦٤e = -1;
            this.f٢٥٦٥f = -1;
            this.f٢٥٦٦g = 0;
            this.f٢٥٦٧h = 0;
            this.f٢٥٧٦q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٢٥٦١b = false;
            this.f٢٥٦٢c = 0;
            this.f٢٥٦٣d = 0;
            this.f٢٥٦٤e = -1;
            this.f٢٥٦٥f = -1;
            this.f٢٥٦٦g = 0;
            this.f٢٥٦٧h = 0;
            this.f٢٥٧٦q = new Rect();
        }
    }
}
