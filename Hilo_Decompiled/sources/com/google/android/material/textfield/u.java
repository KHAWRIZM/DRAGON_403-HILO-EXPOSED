package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class u {
    private ColorStateList A;

    /* renamed from: B, reason: collision with root package name */
    private Typeface f١٠٢٣٦B;

    /* renamed from: a, reason: collision with root package name */
    private final int f١٠٢٣٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٠٢٣٨b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٠٢٣٩c;

    /* renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f١٠٢٤٠d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f١٠٢٤١e;

    /* renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f١٠٢٤٢f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f١٠٢٤٣g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout f١٠٢٤٤h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f١٠٢٤٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٠٢٤٦j;

    /* renamed from: k, reason: collision with root package name */
    private FrameLayout f١٠٢٤٧k;

    /* renamed from: l, reason: collision with root package name */
    private Animator f١٠٢٤٨l;

    /* renamed from: m, reason: collision with root package name */
    private final float f١٠٢٤٩m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٠٢٥٠n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٠٢٥١o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f١٠٢٥٢p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٠٢٥٣q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f١٠٢٥٤r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f١٠٢٥٥s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٠٢٥٦t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٠٢٥٧u;

    /* renamed from: v, reason: collision with root package name */
    private ColorStateList f١٠٢٥٨v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f١٠٢٥٩w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f١٠٢٦٠x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f١٠٢٦١y;

    /* renamed from: z, reason: collision with root package name */
    private int f١٠٢٦٢z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f١٠٢٦٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f١٠٢٦٤b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f١٠٢٦٥c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f١٠٢٦٦d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f١٠٢٦٣a = i10;
            this.f١٠٢٦٤b = textView;
            this.f١٠٢٦٥c = i11;
            this.f١٠٢٦٦d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f١٠٢٥٠n = this.f١٠٢٦٣a;
            u.this.f١٠٢٤٨l = null;
            TextView textView = this.f١٠٢٦٤b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f١٠٢٦٥c == 1 && u.this.f١٠٢٥٤r != null) {
                    u.this.f١٠٢٥٤r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f١٠٢٦٦d;
            if (textView2 != null) {
                textView2.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
                this.f١٠٢٦٦d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f١٠٢٦٦d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f١٠٢٦٦d.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f١٠٢٤٤h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f١٠٢٤٣g = context;
        this.f١٠٢٤٤h = textInputLayout;
        this.f١٠٢٤٩m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        int i10 = R.attr.motionDurationShort4;
        this.f١٠٢٣٧a = a8.k.f(context, i10, 217);
        this.f١٠٢٣٨b = a8.k.f(context, R.attr.motionDurationMedium4, 167);
        this.f١٠٢٣٩c = a8.k.f(context, i10, 167);
        int i11 = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        this.f١٠٢٤٠d = a8.k.g(context, i11, p7.a.f١٦٩٥٠d);
        TimeInterpolator timeInterpolator = p7.a.f١٦٩٤٧a;
        this.f١٠٢٤١e = a8.k.g(context, i11, timeInterpolator);
        this.f١٠٢٤٢f = a8.k.g(context, R.attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    private void D(int i10, int i11) {
        TextView m10;
        TextView m11;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (m11 = m(i11)) != null) {
            m11.setVisibility(0);
            m11.setAlpha(1.0f);
        }
        if (i10 != 0 && (m10 = m(i10)) != null) {
            m10.setVisibility(4);
            if (i10 == 1) {
                m10.setText((CharSequence) null);
            }
        }
        this.f١٠٢٥٠n = i11;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        if (this.f١٠٢٤٤h.isLaidOut() && this.f١٠٢٤٤h.isEnabled() && (this.f١٠٢٥١o != this.f١٠٢٥٠n || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    private void S(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f١٠٢٤٨l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f١٠٢٦٠x, this.f١٠٢٦١y, 2, i10, i11);
            i(arrayList, this.f١٠٢٥٣q, this.f١٠٢٥٤r, 1, i10, i11);
            p7.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
            animatorSet.start();
        } else {
            D(i10, i11);
        }
        this.f١٠٢٤٤h.s0();
        this.f١٠٢٤٤h.y0(z10);
        this.f١٠٢٤٤h.E0();
    }

    private boolean g() {
        if (this.f١٠٢٤٥i != null && this.f١٠٢٤٤h.getEditText() != null) {
            return true;
        }
        return false;
    }

    private void i(List list, boolean z10, TextView textView, int i10, int i11, int i12) {
        boolean z11;
        if (textView != null && z10) {
            if (i10 == i12 || i10 == i11) {
                if (i12 == i10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                ObjectAnimator j10 = j(textView, z11);
                if (i10 == i12 && i11 != 0) {
                    j10.setStartDelay(this.f١٠٢٣٩c);
                }
                list.add(j10);
                if (i12 == i10 && i11 != 0) {
                    ObjectAnimator k10 = k(textView);
                    k10.setStartDelay(this.f١٠٢٣٩c);
                    list.add(k10);
                }
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z10) {
        float f10;
        int i10;
        TimeInterpolator timeInterpolator;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, f10);
        if (z10) {
            i10 = this.f١٠٢٣٨b;
        } else {
            i10 = this.f١٠٢٣٩c;
        }
        ofFloat.setDuration(i10);
        if (z10) {
            timeInterpolator = this.f١٠٢٤١e;
        } else {
            timeInterpolator = this.f١٠٢٤٢f;
        }
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f١٠٢٤٩m, DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat.setDuration(this.f١٠٢٣٧a);
        ofFloat.setInterpolator(this.f١٠٢٤٠d);
        return ofFloat;
    }

    private TextView m(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            return this.f١٠٢٦١y;
        }
        return this.f١٠٢٥٤r;
    }

    private int v(boolean z10, int i10, int i11) {
        if (z10) {
            return this.f١٠٢٤٣g.getResources().getDimensionPixelSize(i10);
        }
        return i11;
    }

    private boolean y(int i10) {
        if (i10 == 1 && this.f١٠٢٥٤r != null && !TextUtils.isEmpty(this.f١٠٢٥٢p)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f١٠٢٥٣q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f١٠٢٦٠x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f١٠٢٤٥i == null) {
            return;
        }
        if (z(i10) && (frameLayout = this.f١٠٢٤٧k) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f١٠٢٤٥i.removeView(textView);
        }
        int i11 = this.f١٠٢٤٦j - 1;
        this.f١٠٢٤٦j = i11;
        O(this.f١٠٢٤٥i, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i10) {
        this.f١٠٢٥٦t = i10;
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null) {
            textView.setAccessibilityLiveRegion(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(CharSequence charSequence) {
        this.f١٠٢٥٥s = charSequence;
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(boolean z10) {
        if (this.f١٠٢٥٣q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f١٠٢٤٣g);
            this.f١٠٢٥٤r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            this.f١٠٢٥٤r.setTextAlignment(5);
            Typeface typeface = this.f١٠٢٣٦B;
            if (typeface != null) {
                this.f١٠٢٥٤r.setTypeface(typeface);
            }
            H(this.f١٠٢٥٧u);
            I(this.f١٠٢٥٨v);
            F(this.f١٠٢٥٥s);
            E(this.f١٠٢٥٦t);
            this.f١٠٢٥٤r.setVisibility(4);
            e(this.f١٠٢٥٤r, 0);
        } else {
            w();
            C(this.f١٠٢٥٤r, 0);
            this.f١٠٢٥٤r = null;
            this.f١٠٢٤٤h.s0();
            this.f١٠٢٤٤h.E0();
        }
        this.f١٠٢٥٣q = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i10) {
        this.f١٠٢٥٧u = i10;
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null) {
            this.f١٠٢٤٤h.e0(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ColorStateList colorStateList) {
        this.f١٠٢٥٨v = colorStateList;
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i10) {
        this.f١٠٢٦٢z = i10;
        TextView textView = this.f١٠٢٦١y;
        if (textView != null) {
            androidx.core.widget.l.m(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (this.f١٠٢٦٠x == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f١٠٢٤٣g);
            this.f١٠٢٦١y = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            this.f١٠٢٦١y.setTextAlignment(5);
            Typeface typeface = this.f١٠٢٣٦B;
            if (typeface != null) {
                this.f١٠٢٦١y.setTypeface(typeface);
            }
            this.f١٠٢٦١y.setVisibility(4);
            this.f١٠٢٦١y.setAccessibilityLiveRegion(1);
            J(this.f١٠٢٦٢z);
            L(this.A);
            e(this.f١٠٢٦١y, 1);
            this.f١٠٢٦١y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f١٠٢٦١y, 1);
            this.f١٠٢٦١y = null;
            this.f١٠٢٤٤h.s0();
            this.f١٠٢٤٤h.E0();
        }
        this.f١٠٢٦٠x = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f١٠٢٦١y;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.f١٠٢٣٦B) {
            this.f١٠٢٣٦B = typeface;
            M(this.f١٠٢٥٤r, typeface);
            M(this.f١٠٢٦١y, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(CharSequence charSequence) {
        h();
        this.f١٠٢٥٢p = charSequence;
        this.f١٠٢٥٤r.setText(charSequence);
        int i10 = this.f١٠٢٥٠n;
        if (i10 != 1) {
            this.f١٠٢٥١o = 1;
        }
        S(i10, this.f١٠٢٥١o, P(this.f١٠٢٥٤r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(CharSequence charSequence) {
        h();
        this.f١٠٢٥٩w = charSequence;
        this.f١٠٢٦١y.setText(charSequence);
        int i10 = this.f١٠٢٥٠n;
        if (i10 != 2) {
            this.f١٠٢٥١o = 2;
        }
        S(i10, this.f١٠٢٥١o, P(this.f١٠٢٦١y, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(TextView textView, int i10) {
        if (this.f١٠٢٤٥i == null && this.f١٠٢٤٧k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f١٠٢٤٣g);
            this.f١٠٢٤٥i = linearLayout;
            linearLayout.setOrientation(0);
            this.f١٠٢٤٤h.addView(this.f١٠٢٤٥i, -1, -2);
            this.f١٠٢٤٧k = new FrameLayout(this.f١٠٢٤٣g);
            this.f١٠٢٤٥i.addView(this.f١٠٢٤٧k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f١٠٢٤٤h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f١٠٢٤٧k.setVisibility(0);
            this.f١٠٢٤٧k.addView(textView);
        } else {
            this.f١٠٢٤٥i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f١٠٢٤٥i.setVisibility(0);
        this.f١٠٢٤٦j++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f١٠٢٤٤h.getEditText();
            boolean k10 = c8.c.k(this.f١٠٢٤٣g);
            LinearLayout linearLayout = this.f١٠٢٤٥i;
            int i10 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            linearLayout.setPaddingRelative(v(k10, i10, editText.getPaddingStart()), v(k10, R.dimen.material_helper_text_font_1_3_padding_top, this.f١٠٢٤٣g.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), v(k10, i10, editText.getPaddingEnd()), 0);
        }
    }

    void h() {
        Animator animator = this.f١٠٢٤٨l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f١٠٢٥١o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f١٠٢٥٦t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f١٠٢٥٥s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f١٠٢٥٢p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList r() {
        TextView textView = this.f١٠٢٥٤r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence s() {
        return this.f١٠٢٥٩w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View t() {
        return this.f١٠٢٦١y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        TextView textView = this.f١٠٢٦١y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f١٠٢٥٢p = null;
        h();
        if (this.f١٠٢٥٠n == 1) {
            if (this.f١٠٢٦٠x && !TextUtils.isEmpty(this.f١٠٢٥٩w)) {
                this.f١٠٢٥١o = 2;
            } else {
                this.f١٠٢٥١o = 0;
            }
        }
        S(this.f١٠٢٥٠n, this.f١٠٢٥١o, P(this.f١٠٢٥٤r, ""));
    }

    void x() {
        h();
        int i10 = this.f١٠٢٥٠n;
        if (i10 == 2) {
            this.f١٠٢٥١o = 0;
        }
        S(i10, this.f١٠٢٥١o, P(this.f١٠٢٦١y, ""));
    }

    boolean z(int i10) {
        return i10 == 0 || i10 == 1;
    }
}
