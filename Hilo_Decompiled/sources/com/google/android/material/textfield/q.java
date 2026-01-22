package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class q extends s {

    /* renamed from: e, reason: collision with root package name */
    private final int f١٠٢١٧e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٠٢١٨f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f١٠٢١٩g;

    /* renamed from: h, reason: collision with root package name */
    private AutoCompleteTextView f١٠٢٢٠h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f١٠٢٢١i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f١٠٢٢٢j;

    /* renamed from: k, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f١٠٢٢٣k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٠٢٢٤l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٠٢٢٥m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٠٢٢٦n;

    /* renamed from: o, reason: collision with root package name */
    private long f١٠٢٢٧o;

    /* renamed from: p, reason: collision with root package name */
    private AccessibilityManager f١٠٢٢٨p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f١٠٢٢٩q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f١٠٢٣٠r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q.this.r();
            q.this.f١٠٢٣٠r.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f١٠٢٢١i = new View.OnClickListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.this.J(view);
            }
        };
        this.f١٠٢٢٢j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                q.this.K(view, z10);
            }
        };
        this.f١٠٢٢٣k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.o
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                q.this.L(z10);
            }
        };
        this.f١٠٢٢٧o = LongCompanionObject.MAX_VALUE;
        Context context = endCompoundLayout.getContext();
        int i10 = R.attr.motionDurationShort3;
        this.f١٠٢١٨f = a8.k.f(context, i10, 67);
        this.f١٠٢١٧e = a8.k.f(endCompoundLayout.getContext(), i10, 50);
        this.f١٠٢١٩g = a8.k.g(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, p7.a.f١٦٩٤٧a);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i10, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f١٠٢١٩g);
        ofFloat.setDuration(i10);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                q.this.I(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void F() {
        this.f١٠٢٣٠r = E(this.f١٠٢١٨f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        ValueAnimator E = E(this.f١٠٢١٧e, 1.0f, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٠٢٢٩q = E;
        E.addListener(new a());
    }

    private boolean G() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f١٠٢٢٧o;
        if (uptimeMillis >= 0 && uptimeMillis <= 300) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f١٠٢٢٠h.isPopupShowing();
        O(isPopupShowing);
        this.f١٠٢٢٥m = isPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f١٠٢٣٥d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f١٠٢٢٤l = z10;
        r();
        if (!z10) {
            O(false);
            this.f١٠٢٢٥m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        int i10;
        AutoCompleteTextView autoCompleteTextView = this.f١٠٢٢٠h;
        if (autoCompleteTextView != null && !r.a(autoCompleteTextView)) {
            CheckableImageButton checkableImageButton = this.f١٠٢٣٥d;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            checkableImageButton.setImportantForAccessibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f١٠٢٢٥m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z10) {
        if (this.f١٠٢٢٦n != z10) {
            this.f١٠٢٢٦n = z10;
            this.f١٠٢٣٠r.cancel();
            this.f١٠٢٢٩q.start();
        }
    }

    private void P() {
        this.f١٠٢٢٠h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M;
                M = q.this.M(view, motionEvent);
                return M;
            }
        });
        this.f١٠٢٢٠h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.l
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                q.this.N();
            }
        });
        this.f١٠٢٢٠h.setThreshold(0);
    }

    private void Q() {
        if (this.f١٠٢٢٠h == null) {
            return;
        }
        if (G()) {
            this.f١٠٢٢٥m = false;
        }
        if (!this.f١٠٢٢٥m) {
            O(!this.f١٠٢٢٦n);
            if (this.f١٠٢٢٦n) {
                this.f١٠٢٢٠h.requestFocus();
                this.f١٠٢٢٠h.showDropDown();
                return;
            } else {
                this.f١٠٢٢٠h.dismissDropDown();
                return;
            }
        }
        this.f١٠٢٢٥m = false;
    }

    private void R() {
        this.f١٠٢٢٥m = true;
        this.f١٠٢٢٧o = SystemClock.uptimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f١٠٢٢٨p.isTouchExplorationEnabled() && r.a(this.f١٠٢٢٠h) && !this.f١٠٢٣٥d.hasFocus()) {
            this.f١٠٢٢٠h.dismissDropDown();
        }
        this.f١٠٢٢٠h.post(new Runnable() { // from class: com.google.android.material.textfield.p
            @Override // java.lang.Runnable
            public final void run() {
                q.this.H();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f١٠٢٢٢j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f١٠٢٢١i;
    }

    @Override // com.google.android.material.textfield.s
    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f١٠٢٢٣k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean i(int i10) {
        return i10 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f١٠٢٢٤l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f١٠٢٢٦n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f١٠٢٢٠h = D(editText);
        P();
        this.f١٠٢٣٢a.setErrorIconDrawable((Drawable) null);
        if (!r.a(editText) && this.f١٠٢٢٨p.isTouchExplorationEnabled()) {
            this.f١٠٢٣٥d.setImportantForAccessibility(2);
        }
        this.f١٠٢٣٢a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, m2.g0 g0Var) {
        if (!r.a(this.f١٠٢٢٠h)) {
            g0Var.o0(Spinner.class.getName());
        }
        if (g0Var.X()) {
            g0Var.z0(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        boolean z10;
        if (this.f١٠٢٢٨p.isEnabled() && !r.a(this.f١٠٢٢٠h)) {
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f١٠٢٢٦n && !this.f١٠٢٢٠h.isPopupShowing()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z10) {
                Q();
                R();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f١٠٢٢٨p = (AccessibilityManager) this.f١٠٢٣٤c.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f١٠٢٢٠h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f١٠٢٢٠h.setOnDismissListener(null);
        }
    }
}
