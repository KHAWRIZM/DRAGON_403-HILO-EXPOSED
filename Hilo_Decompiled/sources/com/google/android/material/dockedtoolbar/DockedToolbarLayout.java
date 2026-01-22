package com.google.android.material.dockedtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.p0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.b0;
import androidx.core.view.d2;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import f8.i;
import f8.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DockedToolbarLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    private static final int f٩٠٠٦c = R.style.Widget_Material3_DockedToolbar;

    /* renamed from: a, reason: collision with root package name */
    private Boolean f٩٠٠٧a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f٩٠٠٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements k0.d {
        a() {
        }

        @Override // com.google.android.material.internal.k0.d
        public d2 a(View view, d2 d2Var, k0.e eVar) {
            int i10;
            int i11;
            if (DockedToolbarLayout.this.f٩٠٠٧a != null && DockedToolbarLayout.this.f٩٠٠٨b != null && !DockedToolbarLayout.this.f٩٠٠٧a.booleanValue() && !DockedToolbarLayout.this.f٩٠٠٨b.booleanValue()) {
                return d2Var;
            }
            b0 f10 = d2Var.f(d2.m.g() | d2.m.a() | d2.m.b());
            int i12 = f10.f٢٧٩٦d;
            int i13 = f10.f٢٧٩٤b;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (DockedToolbarLayout.this.d(layoutParams, 48) && DockedToolbarLayout.this.f٩٠٠٧a == null && DockedToolbarLayout.this.getFitsSystemWindows()) {
                i10 = i13;
            } else {
                i10 = 0;
            }
            if (DockedToolbarLayout.this.d(layoutParams, 80) && DockedToolbarLayout.this.f٩٠٠٨b == null && DockedToolbarLayout.this.getFitsSystemWindows()) {
                i11 = i12;
            } else {
                i11 = 0;
            }
            if (DockedToolbarLayout.this.f٩٠٠٨b != null) {
                if (!DockedToolbarLayout.this.f٩٠٠٨b.booleanValue()) {
                    i12 = 0;
                }
                i11 = i12;
            }
            if (DockedToolbarLayout.this.f٩٠٠٧a != null) {
                if (!DockedToolbarLayout.this.f٩٠٠٧a.booleanValue()) {
                    i13 = 0;
                }
                i10 = i13;
            }
            eVar.f٩٣٢٠b += i10;
            eVar.f٩٣٢٢d += i11;
            eVar.a(view);
            return d2Var;
        }
    }

    public DockedToolbarLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(ViewGroup.LayoutParams layoutParams, int i10) {
        if (layoutParams instanceof CoordinatorLayout.f) {
            if ((((CoordinatorLayout.f) layoutParams).f٢٥٦٢c & i10) == i10) {
                return true;
            }
            return false;
        }
        if ((layoutParams instanceof FrameLayout.LayoutParams) && (((FrameLayout.LayoutParams) layoutParams).gravity & i10) == i10) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            int childCount = getChildCount();
            int max = Math.max(getMeasuredHeight(), getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom());
            for (int i12 = 0; i12 < childCount; i12++) {
                measureChild(getChildAt(i12), i10, View.MeasureSpec.makeMeasureSpec(max, 1073741824));
            }
            setMeasuredDimension(getMeasuredWidth(), max);
        }
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dockedToolbarStyle);
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, f٩٠٠٦c);
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(g8.a.d(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        p0 j10 = h0.j(context2, attributeSet, R.styleable.DockedToolbar, i10, i11, new int[0]);
        int i12 = R.styleable.DockedToolbar_backgroundTint;
        if (j10.s(i12)) {
            int b10 = j10.b(i12, 0);
            i iVar = new i(o.e(context2, attributeSet, i10, i11).m());
            iVar.h0(ColorStateList.valueOf(b10));
            setBackground(iVar);
        }
        int i13 = R.styleable.DockedToolbar_paddingTopSystemWindowInsets;
        if (j10.s(i13)) {
            this.f٩٠٠٧a = Boolean.valueOf(j10.a(i13, true));
        }
        int i14 = R.styleable.DockedToolbar_paddingBottomSystemWindowInsets;
        if (j10.s(i14)) {
            this.f٩٠٠٨b = Boolean.valueOf(j10.a(i14, true));
        }
        k0.f(this, new a());
        setImportantForAccessibility(1);
        j10.x();
    }
}
