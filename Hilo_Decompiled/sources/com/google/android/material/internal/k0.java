package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.d3;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k0 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f٩٣١٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f٩٣١٤b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f٩٣١٥c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f٩٣١٦d;

        a(boolean z10, boolean z11, boolean z12, d dVar) {
            this.f٩٣١٣a = z10;
            this.f٩٣١٤b = z11;
            this.f٩٣١٥c = z12;
            this.f٩٣١٦d = dVar;
        }

        @Override // com.google.android.material.internal.k0.d
        public d2 a(View view, d2 d2Var, e eVar) {
            if (this.f٩٣١٣a) {
                eVar.f٩٣٢٢d += d2Var.j();
            }
            boolean m10 = k0.m(view);
            if (this.f٩٣١٤b) {
                if (m10) {
                    eVar.f٩٣٢١c += d2Var.k();
                } else {
                    eVar.f٩٣١٩a += d2Var.k();
                }
            }
            if (this.f٩٣١٥c) {
                if (m10) {
                    eVar.f٩٣١٩a += d2Var.l();
                } else {
                    eVar.f٩٣٢١c += d2Var.l();
                }
            }
            eVar.a(view);
            d dVar = this.f٩٣١٦d;
            if (dVar != null) {
                return dVar.a(view, d2Var, eVar);
            }
            return d2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements androidx.core.view.j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f٩٣١٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f٩٣١٨b;

        b(d dVar, e eVar) {
            this.f٩٣١٧a = dVar;
            this.f٩٣١٨b = eVar;
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return this.f٩٣١٧a.a(view, d2Var, new e(this.f٩٣١٨b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            view.requestApplyInsets();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        d2 a(View view, d2 d2Var, e eVar);
    }

    public static Rect b(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i12 = i10 - iArr2[0];
        int i13 = i11 - iArr2[1];
        return new Rect(i12, i13, view2.getWidth() + i12, view2.getHeight() + i13);
    }

    public static Rect c(View view) {
        return d(view, 0);
    }

    public static Rect d(View view, int i10) {
        return new Rect(view.getLeft(), view.getTop() + i10, view.getRight(), view.getBottom() + i10);
    }

    public static void e(View view, AttributeSet attributeSet, int i10, int i11, d dVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i10, i11);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z12 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        f(view, new a(z10, z11, z12, dVar));
    }

    public static void f(View view, d dVar) {
        d1.E0(view, new b(dVar, new e(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom())));
        p(view);
    }

    public static float g(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static Integer h(View view) {
        ColorStateList g10 = com.google.android.material.drawable.g.g(view.getBackground());
        if (g10 != null) {
            return Integer.valueOf(g10.getDefaultColor());
        }
        return null;
    }

    public static ViewGroup i(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    private static InputMethodManager j(View view) {
        return (InputMethodManager) androidx.core.content.a.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static float k(View view) {
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f10 += ((View) parent).getElevation();
        }
        return f10;
    }

    public static void l(View view, boolean z10) {
        d3 O;
        if (z10 && (O = d1.O(view)) != null) {
            O.a(d2.m.b());
            return;
        }
        InputMethodManager j10 = j(view);
        if (j10 != null) {
            j10.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean m(View view) {
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode o(int i10, PorterDuff.Mode mode) {
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 9) {
                    switch (i10) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void p(View view) {
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void q(final View view, final boolean z10) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.j0
            @Override // java.lang.Runnable
            public final void run() {
                k0.r(view, z10);
            }
        });
    }

    public static void r(View view, boolean z10) {
        d3 O;
        if (z10 && (O = d1.O(view)) != null) {
            O.f(d2.m.b());
        } else {
            j(view).showSoftInput(view, 1);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f٩٣١٩a;

        /* renamed from: b, reason: collision with root package name */
        public int f٩٣٢٠b;

        /* renamed from: c, reason: collision with root package name */
        public int f٩٣٢١c;

        /* renamed from: d, reason: collision with root package name */
        public int f٩٣٢٢d;

        public e(int i10, int i11, int i12, int i13) {
            this.f٩٣١٩a = i10;
            this.f٩٣٢٠b = i11;
            this.f٩٣٢١c = i12;
            this.f٩٣٢٢d = i13;
        }

        public void a(View view) {
            view.setPaddingRelative(this.f٩٣١٩a, this.f٩٣٢٠b, this.f٩٣٢١c, this.f٩٣٢٢d);
        }

        public e(e eVar) {
            this.f٩٣١٩a = eVar.f٩٣١٩a;
            this.f٩٣٢٠b = eVar.f٩٣٢٠b;
            this.f٩٣٢١c = eVar.f٩٣٢١c;
            this.f٩٣٢٢d = eVar.f٩٣٢٢d;
        }
    }
}
