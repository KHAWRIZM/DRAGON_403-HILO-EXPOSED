package com.google.android.material.floatingtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.p0;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import f8.i;
import f8.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FloatingToolbarLayout extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private static final String f٩١٣٧j = "FloatingToolbarLayout";

    /* renamed from: k, reason: collision with root package name */
    private static final int f٩١٣٨k = R.style.Widget_Material3_FloatingToolbar;

    /* renamed from: a, reason: collision with root package name */
    private boolean f٩١٣٩a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٩١٤٠b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩١٤١c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٩١٤٢d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f٩١٤٣e;

    /* renamed from: f, reason: collision with root package name */
    private int f٩١٤٤f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩١٤٥g;

    /* renamed from: h, reason: collision with root package name */
    private int f٩١٤٦h;

    /* renamed from: i, reason: collision with root package name */
    private int f٩١٤٧i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            if (!FloatingToolbarLayout.this.f٩١٣٩a && !FloatingToolbarLayout.this.f٩١٤١c && !FloatingToolbarLayout.this.f٩١٤٠b && !FloatingToolbarLayout.this.f٩١٤٢d) {
                return d2Var;
            }
            b0 f10 = d2Var.f(d2.m.g() | d2.m.a() | d2.m.b());
            FloatingToolbarLayout.this.f٩١٤٤f = f10.f٢٧٩٦d;
            FloatingToolbarLayout.this.f٩١٤٥g = f10.f٢٧٩٤b;
            FloatingToolbarLayout.this.f٩١٤٧i = f10.f٢٧٩٥c;
            FloatingToolbarLayout.this.f٩١٤٦h = f10.f٢٧٩٣a;
            FloatingToolbarLayout.this.j();
            return d2Var;
        }
    }

    public FloatingToolbarLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i10;
        int i11;
        int i12;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Rect rect = this.f٩١٤٣e;
        if (rect == null) {
            Log.w(f٩١٣٧j, "Unable to update margins because original view margins are not set");
            return;
        }
        int i13 = rect.left;
        int i14 = 0;
        if (this.f٩١٣٩a) {
            i10 = this.f٩١٤٦h;
        } else {
            i10 = 0;
        }
        int i15 = i13 + i10;
        int i16 = rect.right;
        if (this.f٩١٤١c) {
            i11 = this.f٩١٤٧i;
        } else {
            i11 = 0;
        }
        int i17 = i16 + i11;
        int i18 = rect.top;
        if (this.f٩١٤٠b) {
            i12 = this.f٩١٤٥g;
        } else {
            i12 = 0;
        }
        int i19 = i18 + i12;
        int i20 = rect.bottom;
        if (this.f٩١٤٢d) {
            i14 = this.f٩١٤٤f;
        }
        int i21 = i20 + i14;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.bottomMargin != i21 || marginLayoutParams.leftMargin != i15 || marginLayoutParams.rightMargin != i17 || marginLayoutParams.topMargin != i19) {
            marginLayoutParams.bottomMargin = i21;
            marginLayoutParams.leftMargin = i15;
            marginLayoutParams.rightMargin = i17;
            marginLayoutParams.topMargin = i19;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f٩١٤٣e = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            j();
            return;
        }
        this.f٩١٤٣e = null;
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingToolbarStyle);
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, f٩١٣٨k);
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(g8.a.d(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        p0 j10 = h0.j(context2, attributeSet, R.styleable.FloatingToolbar, i10, i11, new int[0]);
        int i12 = R.styleable.FloatingToolbar_backgroundTint;
        if (j10.s(i12)) {
            int b10 = j10.b(i12, 0);
            i iVar = new i(o.e(context2, attributeSet, i10, i11).m());
            iVar.h0(ColorStateList.valueOf(b10));
            setBackground(iVar);
        }
        this.f٩١٣٩a = j10.a(R.styleable.FloatingToolbar_marginLeftSystemWindowInsets, true);
        this.f٩١٤٠b = j10.a(R.styleable.FloatingToolbar_marginTopSystemWindowInsets, false);
        this.f٩١٤١c = j10.a(R.styleable.FloatingToolbar_marginRightSystemWindowInsets, true);
        this.f٩١٤٢d = j10.a(R.styleable.FloatingToolbar_marginBottomSystemWindowInsets, true);
        d1.E0(this, new a());
        j10.x();
    }
}
