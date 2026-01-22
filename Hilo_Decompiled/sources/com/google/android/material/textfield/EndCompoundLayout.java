package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.p0;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class EndCompoundLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f١٠٠٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f١٠٠٧٦b;

    /* renamed from: c, reason: collision with root package name */
    private final CheckableImageButton f١٠٠٧٧c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f١٠٠٧٨d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f١٠٠٧٩e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnLongClickListener f١٠٠٨٠f;

    /* renamed from: g, reason: collision with root package name */
    private final CheckableImageButton f١٠٠٨١g;

    /* renamed from: h, reason: collision with root package name */
    private final d f١٠٠٨٢h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٠٠٨٣i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashSet f١٠٠٨٤j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f١٠٠٨٥k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f١٠٠٨٦l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٠٠٨٧m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView.ScaleType f١٠٠٨٨n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnLongClickListener f١٠٠٨٩o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f١٠٠٩٠p;

    /* renamed from: q, reason: collision with root package name */
    private final TextView f١٠٠٩١q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٠٠٩٢r;

    /* renamed from: s, reason: collision with root package name */
    private EditText f١٠٠٩٣s;

    /* renamed from: t, reason: collision with root package name */
    private final AccessibilityManager f١٠٠٩٤t;

    /* renamed from: u, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f١٠٠٩٥u;

    /* renamed from: v, reason: collision with root package name */
    private final TextWatcher f١٠٠٩٦v;

    /* renamed from: w, reason: collision with root package name */
    private final TextInputLayout.g f١٠٠٩٧w;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends com.google.android.material.internal.g0 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EndCompoundLayout.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.g0, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            EndCompoundLayout.this.m().b(charSequence, i10, i11, i12);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements TextInputLayout.g {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout) {
            if (EndCompoundLayout.this.f١٠٠٩٣s == textInputLayout.getEditText()) {
                return;
            }
            if (EndCompoundLayout.this.f١٠٠٩٣s != null) {
                EndCompoundLayout.this.f١٠٠٩٣s.removeTextChangedListener(EndCompoundLayout.this.f١٠٠٩٦v);
                if (EndCompoundLayout.this.f١٠٠٩٣s.getOnFocusChangeListener() == EndCompoundLayout.this.m().e()) {
                    EndCompoundLayout.this.f١٠٠٩٣s.setOnFocusChangeListener(null);
                }
            }
            EndCompoundLayout.this.f١٠٠٩٣s = textInputLayout.getEditText();
            if (EndCompoundLayout.this.f١٠٠٩٣s != null) {
                EndCompoundLayout.this.f١٠٠٩٣s.addTextChangedListener(EndCompoundLayout.this.f١٠٠٩٦v);
            }
            EndCompoundLayout.this.m().n(EndCompoundLayout.this.f١٠٠٩٣s);
            EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
            endCompoundLayout.d0(endCompoundLayout.m());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            EndCompoundLayout.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            EndCompoundLayout.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray f١٠١٠١a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        private final EndCompoundLayout f١٠١٠٢b;

        /* renamed from: c, reason: collision with root package name */
        private final int f١٠١٠٣c;

        /* renamed from: d, reason: collision with root package name */
        private final int f١٠١٠٤d;

        d(EndCompoundLayout endCompoundLayout, p0 p0Var) {
            this.f١٠١٠٢b = endCompoundLayout;
            this.f١٠١٠٣c = p0Var.n(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.f١٠١٠٤d = p0Var.n(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        private s b(int i10) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                return new q(this.f١٠١٠٢b);
                            }
                            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
                        }
                        return new f(this.f١٠١٠٢b);
                    }
                    return new x(this.f١٠١٠٢b, this.f١٠١٠٤d);
                }
                return new v(this.f١٠١٠٢b);
            }
            return new g(this.f١٠١٠٢b);
        }

        s c(int i10) {
            s sVar = (s) this.f١٠١٠١a.get(i10);
            if (sVar == null) {
                s b10 = b(i10);
                this.f١٠١٠١a.append(i10, b10);
                return b10;
            }
            return sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndCompoundLayout(TextInputLayout textInputLayout, p0 p0Var) {
        super(textInputLayout.getContext());
        this.f١٠٠٨٣i = 0;
        this.f١٠٠٨٤j = new LinkedHashSet();
        this.f١٠٠٩٦v = new a();
        b bVar = new b();
        this.f١٠٠٩٧w = bVar;
        this.f١٠٠٩٤t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f١٠٠٧٥a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f١٠٠٧٦b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton i10 = i(this, from, R.id.text_input_error_icon);
        this.f١٠٠٧٧c = i10;
        CheckableImageButton i11 = i(frameLayout, from, R.id.text_input_end_icon);
        this.f١٠٠٨١g = i11;
        this.f١٠٠٨٢h = new d(this, p0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f١٠٠٩١q = appCompatTextView;
        C(p0Var);
        B(p0Var);
        D(p0Var);
        frameLayout.addView(i11);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(i10);
        textInputLayout.addOnEditTextAttachedListener(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B(p0 p0Var) {
        int i10 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (!p0Var.s(i10)) {
            int i11 = R.styleable.TextInputLayout_endIconTint;
            if (p0Var.s(i11)) {
                this.f١٠٠٨٥k = c8.c.b(getContext(), p0Var, i11);
            }
            int i12 = R.styleable.TextInputLayout_endIconTintMode;
            if (p0Var.s(i12)) {
                this.f١٠٠٨٦l = com.google.android.material.internal.k0.o(p0Var.k(i12, -1), null);
            }
        }
        int i13 = R.styleable.TextInputLayout_endIconMode;
        if (p0Var.s(i13)) {
            U(p0Var.k(i13, 0));
            int i14 = R.styleable.TextInputLayout_endIconContentDescription;
            if (p0Var.s(i14)) {
                Q(p0Var.p(i14));
            }
            O(p0Var.a(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (p0Var.s(i10)) {
            int i15 = R.styleable.TextInputLayout_passwordToggleTint;
            if (p0Var.s(i15)) {
                this.f١٠٠٨٥k = c8.c.b(getContext(), p0Var, i15);
            }
            int i16 = R.styleable.TextInputLayout_passwordToggleTintMode;
            if (p0Var.s(i16)) {
                this.f١٠٠٨٦l = com.google.android.material.internal.k0.o(p0Var.k(i16, -1), null);
            }
            U(p0Var.a(i10, false) ? 1 : 0);
            Q(p0Var.p(R.styleable.TextInputLayout_passwordToggleContentDescription));
        }
        T(p0Var.f(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i17 = R.styleable.TextInputLayout_endIconScaleType;
        if (p0Var.s(i17)) {
            V(t.b(p0Var.k(i17, -1)));
        }
    }

    private void C(p0 p0Var) {
        int i10 = R.styleable.TextInputLayout_errorIconTint;
        if (p0Var.s(i10)) {
            this.f١٠٠٧٨d = c8.c.b(getContext(), p0Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_errorIconTintMode;
        if (p0Var.s(i11)) {
            this.f١٠٠٧٩e = com.google.android.material.internal.k0.o(p0Var.k(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_errorIconDrawable;
        if (p0Var.s(i12)) {
            a0(p0Var.g(i12));
        }
        this.f١٠٠٧٧c.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        this.f١٠٠٧٧c.setImportantForAccessibility(2);
        this.f١٠٠٧٧c.setClickable(false);
        this.f١٠٠٧٧c.setPressable(false);
        this.f١٠٠٧٧c.setCheckable(false);
        this.f١٠٠٧٧c.setFocusable(false);
    }

    private void D(p0 p0Var) {
        this.f١٠٠٩١q.setVisibility(8);
        this.f١٠٠٩١q.setId(R.id.textinput_suffix_text);
        this.f١٠٠٩١q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        this.f١٠٠٩١q.setAccessibilityLiveRegion(1);
        m0(p0Var.n(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        int i10 = R.styleable.TextInputLayout_suffixTextColor;
        if (p0Var.s(i10)) {
            n0(p0Var.c(i10));
        }
        l0(p0Var.p(R.styleable.TextInputLayout_suffixText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f١٠٠٩٥u;
        if (touchExplorationStateChangeListener != null && (accessibilityManager = this.f١٠٠٩٤t) != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(s sVar) {
        if (this.f١٠٠٩٣s == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f١٠٠٩٣s.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f١٠٠٨١g.setOnFocusChangeListener(sVar.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f١٠٠٩٥u != null && this.f١٠٠٩٤t != null && isAttachedToWindow()) {
            this.f١٠٠٩٤t.addTouchExplorationStateChangeListener(this.f١٠٠٩٥u);
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        t.e(checkableImageButton);
        if (c8.c.k(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    private void j(int i10) {
        Iterator it = this.f١٠٠٨٤j.iterator();
        if (!it.hasNext()) {
            return;
        }
        androidx.appcompat.app.a0.a(it.next());
        throw null;
    }

    private void o0(s sVar) {
        sVar.s();
        this.f١٠٠٩٥u = sVar.h();
        g();
    }

    private void p0(s sVar) {
        M();
        this.f١٠٠٩٥u = null;
        sVar.u();
    }

    private void q0(boolean z10) {
        if (z10 && n() != null) {
            Drawable mutate = h2.b.r(n()).mutate();
            mutate.setTint(this.f١٠٠٧٥a.getErrorCurrentTextColors());
            this.f١٠٠٨١g.setImageDrawable(mutate);
            return;
        }
        t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k, this.f١٠٠٨٦l);
    }

    private void r0() {
        int i10;
        char c10;
        FrameLayout frameLayout = this.f١٠٠٧٦b;
        int i11 = 8;
        if (this.f١٠٠٨١g.getVisibility() == 0 && !G()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        frameLayout.setVisibility(i10);
        if (this.f١٠٠٩٠p != null && !this.f١٠٠٩٢r) {
            c10 = 0;
        } else {
            c10 = '\b';
        }
        if (F() || G() || c10 == 0) {
            i11 = 0;
        }
        setVisibility(i11);
    }

    private void s0() {
        boolean z10;
        int i10 = 0;
        if (s() != null && this.f١٠٠٧٥a.N() && this.f١٠٠٧٥a.f0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        CheckableImageButton checkableImageButton = this.f١٠٠٧٧c;
        if (!z10) {
            i10 = 8;
        }
        checkableImageButton.setVisibility(i10);
        r0();
        t0();
        if (!A()) {
            this.f١٠٠٧٥a.r0();
        }
    }

    private int t(s sVar) {
        int i10 = this.f١٠٠٨٢h.f١٠١٠٣c;
        if (i10 == 0) {
            return sVar.d();
        }
        return i10;
    }

    private void u0() {
        int i10;
        int visibility = this.f١٠٠٩١q.getVisibility();
        boolean z10 = false;
        if (this.f١٠٠٩٠p != null && !this.f١٠٠٩٢r) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (visibility != i10) {
            s m10 = m();
            if (i10 == 0) {
                z10 = true;
            }
            m10.q(z10);
        }
        r0();
        this.f١٠٠٩١q.setVisibility(i10);
        this.f١٠٠٧٥a.r0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        if (this.f١٠٠٨٣i != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        if (A() && this.f١٠٠٨١g.isChecked()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F() {
        if (this.f١٠٠٧٦b.getVisibility() == 0 && this.f١٠٠٨١g.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        if (this.f١٠٠٧٧c.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(boolean z10) {
        this.f١٠٠٩٢r = z10;
        u0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        s0();
        K();
        J();
        if (m().t()) {
            q0(this.f١٠٠٧٥a.f0());
        }
    }

    void J() {
        t.d(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k);
    }

    void K() {
        t.d(this.f١٠٠٧٥a, this.f١٠٠٧٧c, this.f١٠٠٧٨d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean isChecked;
        s m10 = m();
        boolean z12 = true;
        if (m10.l() && (isChecked = this.f١٠٠٨١g.isChecked()) != m10.m()) {
            this.f١٠٠٨١g.setChecked(!isChecked);
            z11 = true;
        } else {
            z11 = false;
        }
        if (m10.j() && (isActivated = this.f١٠٠٨١g.isActivated()) != m10.k()) {
            N(!isActivated);
        } else {
            z12 = z11;
        }
        if (z10 || z12) {
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(boolean z10) {
        this.f١٠٠٨١g.setActivated(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z10) {
        this.f١٠٠٨١g.setCheckable(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        Q(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f١٠٠٨١g.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        S(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(Drawable drawable) {
        this.f١٠٠٨١g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k, this.f١٠٠٨٦l);
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f١٠٠٨٧m) {
                this.f١٠٠٨٧m = i10;
                t.g(this.f١٠٠٨١g, i10);
                t.g(this.f١٠٠٧٧c, i10);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i10) {
        boolean z10;
        if (this.f١٠٠٨٣i == i10) {
            return;
        }
        p0(m());
        int i11 = this.f١٠٠٨٣i;
        this.f١٠٠٨٣i = i10;
        j(i11);
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Y(z10);
        s m10 = m();
        R(t(m10));
        P(m10.c());
        O(m10.l());
        if (m10.i(this.f١٠٠٧٥a.getBoxBackgroundMode())) {
            o0(m10);
            setEndIconOnClickListener(m10.f());
            EditText editText = this.f١٠٠٩٣s;
            if (editText != null) {
                m10.n(editText);
                d0(m10);
            }
            t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k, this.f١٠٠٨٦l);
            L(true);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f١٠٠٧٥a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ImageView.ScaleType scaleType) {
        this.f١٠٠٨٨n = scaleType;
        t.j(this.f١٠٠٨١g, scaleType);
        t.j(this.f١٠٠٧٧c, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(ColorStateList colorStateList) {
        if (this.f١٠٠٨٥k != colorStateList) {
            this.f١٠٠٨٥k = colorStateList;
            t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, colorStateList, this.f١٠٠٨٦l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(PorterDuff.Mode mode) {
        if (this.f١٠٠٨٦l != mode) {
            this.f١٠٠٨٦l = mode;
            t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(boolean z10) {
        int i10;
        if (F() != z10) {
            CheckableImageButton checkableImageButton = this.f١٠٠٨١g;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            r0();
            t0();
            this.f١٠٠٧٥a.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        a0(drawable);
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(Drawable drawable) {
        this.f١٠٠٧٧c.setImageDrawable(drawable);
        s0();
        t.a(this.f١٠٠٧٥a, this.f١٠٠٧٧c, this.f١٠٠٧٨d, this.f١٠٠٧٩e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnEndIconChangedListener(TextInputLayout.h hVar) {
        this.f١٠٠٨٤j.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(ColorStateList colorStateList) {
        if (this.f١٠٠٧٨d != colorStateList) {
            this.f١٠٠٧٨d = colorStateList;
            t.a(this.f١٠٠٧٥a, this.f١٠٠٧٧c, colorStateList, this.f١٠٠٧٩e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(PorterDuff.Mode mode) {
        if (this.f١٠٠٧٩e != mode) {
            this.f١٠٠٧٩e = mode;
            t.a(this.f١٠٠٧٥a, this.f١٠٠٧٧c, this.f١٠٠٧٨d, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        f0(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0(CharSequence charSequence) {
        this.f١٠٠٨١g.setContentDescription(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        h0(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f١٠٠٨١g.performClick();
        this.f١٠٠٨١g.jumpDrawablesToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(Drawable drawable) {
        this.f١٠٠٨١g.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(boolean z10) {
        if (z10 && this.f١٠٠٨٣i != 1) {
            U(1);
        } else if (!z10) {
            U(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0(ColorStateList colorStateList) {
        this.f١٠٠٨٥k = colorStateList;
        t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, colorStateList, this.f١٠٠٨٦l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton k() {
        if (G()) {
            return this.f١٠٠٧٧c;
        }
        if (A() && F()) {
            return this.f١٠٠٨١g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0(PorterDuff.Mode mode) {
        this.f١٠٠٨٦l = mode;
        t.a(this.f١٠٠٧٥a, this.f١٠٠٨١g, this.f١٠٠٨٥k, mode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence l() {
        return this.f١٠٠٨١g.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f١٠٠٩٠p = charSequence2;
        this.f١٠٠٩١q.setText(charSequence);
        u0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s m() {
        return this.f١٠٠٨٢h.c(this.f١٠٠٨٣i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(int i10) {
        androidx.core.widget.l.m(this.f١٠٠٩١q, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable n() {
        return this.f١٠٠٨١g.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(ColorStateList colorStateList) {
        this.f١٠٠٩١q.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f١٠٠٨٧m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f١٠٠٨٣i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView.ScaleType q() {
        return this.f١٠٠٨٨n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton r() {
        return this.f١٠٠٨١g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOnEndIconChangedListener(TextInputLayout.h hVar) {
        this.f١٠٠٨٤j.remove(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable s() {
        return this.f١٠٠٧٧c.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        t.h(this.f١٠٠٨١g, onClickListener, this.f١٠٠٨٩o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠٠٨٩o = onLongClickListener;
        t.i(this.f١٠٠٨١g, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        t.h(this.f١٠٠٧٧c, onClickListener, this.f١٠٠٨٠f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠٠٨٠f = onLongClickListener;
        t.i(this.f١٠٠٧٧c, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0() {
        int i10;
        if (this.f١٠٠٧٥a.f١٠١٣٨e == null) {
            return;
        }
        if (!F() && !G()) {
            i10 = this.f١٠٠٧٥a.f١٠١٣٨e.getPaddingEnd();
        } else {
            i10 = 0;
        }
        this.f١٠٠٩١q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f١٠٠٧٥a.f١٠١٣٨e.getPaddingTop(), i10, this.f١٠٠٧٥a.f١٠١٣٨e.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence u() {
        return this.f١٠٠٨١g.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable v() {
        return this.f١٠٠٨١g.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w() {
        return this.f١٠٠٩٠p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f١٠٠٩١q.getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        int measuredWidth;
        if (!F() && !G()) {
            measuredWidth = 0;
        } else {
            measuredWidth = this.f١٠٠٨١g.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f١٠٠٨١g.getLayoutParams()).getMarginStart();
        }
        return getPaddingEnd() + this.f١٠٠٩١q.getPaddingEnd() + measuredWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView z() {
        return this.f١٠٠٩١q;
    }
}
