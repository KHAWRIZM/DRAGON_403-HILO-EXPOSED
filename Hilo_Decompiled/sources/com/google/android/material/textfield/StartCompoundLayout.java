package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.p0;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class StartCompoundLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final TextInputLayout f١٠١١٧a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f١٠١١٨b;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f١٠١١٩c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f١٠١٢٠d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f١٠١٢١e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f١٠١٢٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٠١٢٣g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView.ScaleType f١٠١٢٤h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f١٠١٢٥i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٠١٢٦j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartCompoundLayout(TextInputLayout textInputLayout, p0 p0Var) {
        super(textInputLayout.getContext());
        this.f١٠١١٧a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f١٠١٢٠d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f١٠١١٨b = appCompatTextView;
        j(p0Var);
        i(p0Var);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void A() {
        int i10;
        int i11 = 8;
        if (this.f١٠١١٩c != null && !this.f١٠١٢٦j) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (this.f١٠١٢٠d.getVisibility() == 0 || i10 == 0) {
            i11 = 0;
        }
        setVisibility(i11);
        this.f١٠١١٨b.setVisibility(i10);
        this.f١٠١١٧a.r0();
    }

    private void i(p0 p0Var) {
        this.f١٠١١٨b.setVisibility(8);
        this.f١٠١١٨b.setId(R.id.textinput_prefix_text);
        this.f١٠١١٨b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f١٠١١٨b.setAccessibilityLiveRegion(1);
        o(p0Var.n(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        int i10 = R.styleable.TextInputLayout_prefixTextColor;
        if (p0Var.s(i10)) {
            p(p0Var.c(i10));
        }
        n(p0Var.p(R.styleable.TextInputLayout_prefixText));
    }

    private void j(p0 p0Var) {
        if (c8.c.k(getContext())) {
            ((ViewGroup.MarginLayoutParams) this.f١٠١٢٠d.getLayoutParams()).setMarginEnd(0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i10 = R.styleable.TextInputLayout_startIconTint;
        if (p0Var.s(i10)) {
            this.f١٠١٢١e = c8.c.b(getContext(), p0Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_startIconTintMode;
        if (p0Var.s(i11)) {
            this.f١٠١٢٢f = com.google.android.material.internal.k0.o(p0Var.k(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_startIconDrawable;
        if (p0Var.s(i12)) {
            s(p0Var.g(i12));
            int i13 = R.styleable.TextInputLayout_startIconContentDescription;
            if (p0Var.s(i13)) {
                r(p0Var.p(i13));
            }
            q(p0Var.a(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        t(p0Var.f(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i14 = R.styleable.TextInputLayout_startIconScaleType;
        if (p0Var.s(i14)) {
            u(t.b(p0Var.k(i14, -1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f١٠١١٩c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f١٠١١٨b.getTextColors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i10;
        if (k()) {
            i10 = this.f١٠١٢٠d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f١٠١٢٠d.getLayoutParams()).getMarginEnd();
        } else {
            i10 = 0;
        }
        return getPaddingStart() + this.f١٠١١٨b.getPaddingStart() + i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView d() {
        return this.f١٠١١٨b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence e() {
        return this.f١٠١٢٠d.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable f() {
        return this.f١٠١٢٠d.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f١٠١٢٣g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView.ScaleType h() {
        return this.f١٠١٢٤h;
    }

    boolean k() {
        if (this.f١٠١٢٠d.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z10) {
        this.f١٠١٢٦j = z10;
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        t.d(this.f١٠١١٧a, this.f١٠١٢٠d, this.f١٠١٢١e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f١٠١١٩c = charSequence2;
        this.f١٠١١٨b.setText(charSequence);
        A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i10) {
        androidx.core.widget.l.m(this.f١٠١١٨b, i10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ColorStateList colorStateList) {
        this.f١٠١١٨b.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z10) {
        this.f١٠١٢٠d.setCheckable(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f١٠١٢٠d.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Drawable drawable) {
        this.f١٠١٢٠d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f١٠١١٧a, this.f١٠١٢٠d, this.f١٠١٢١e, this.f١٠١٢٢f);
            x(true);
            m();
        } else {
            x(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            r(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        t.h(this.f١٠١٢٠d, onClickListener, this.f١٠١٢٥i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠١٢٥i = onLongClickListener;
        t.i(this.f١٠١٢٠d, onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f١٠١٢٣g) {
                this.f١٠١٢٣g = i10;
                t.g(this.f١٠١٢٠d, i10);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(ImageView.ScaleType scaleType) {
        this.f١٠١٢٤h = scaleType;
        t.j(this.f١٠١٢٠d, scaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.f١٠١٢١e != colorStateList) {
            this.f١٠١٢١e = colorStateList;
            t.a(this.f١٠١١٧a, this.f١٠١٢٠d, colorStateList, this.f١٠١٢٢f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.f١٠١٢٢f != mode) {
            this.f١٠١٢٢f = mode;
            t.a(this.f١٠١١٧a, this.f١٠١٢٠d, this.f١٠١٢١e, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(boolean z10) {
        int i10;
        if (k() != z10) {
            CheckableImageButton checkableImageButton = this.f١٠١٢٠d;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            z();
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(m2.g0 g0Var) {
        if (this.f١٠١١٨b.getVisibility() == 0) {
            g0Var.A0(this.f١٠١١٨b);
            g0Var.S0(this.f١٠١١٨b);
        } else {
            g0Var.S0(this.f١٠١٢٠d);
        }
    }

    void z() {
        int paddingStart;
        EditText editText = this.f١٠١١٧a.f١٠١٣٨e;
        if (editText == null) {
            return;
        }
        if (k()) {
            paddingStart = 0;
        } else {
            paddingStart = editText.getPaddingStart();
        }
        this.f١٠١١٨b.setPaddingRelative(paddingStart, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }
}
