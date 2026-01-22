package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f extends s {

    /* renamed from: e, reason: collision with root package name */
    private final int f١٠١٩٦e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٠١٩٧f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f١٠١٩٨g;

    /* renamed from: h, reason: collision with root package name */
    private final TimeInterpolator f١٠١٩٩h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f١٠٢٠٠i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f١٠٢٠١j;

    /* renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f١٠٢٠٢k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f١٠٢٠٣l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f١٠٢٠٤m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f١٠٢٣٣b.Y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f١٠٢٣٣b.Y(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f١٠٢٠١j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.G(view);
            }
        };
        this.f١٠٢٠٢k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                f.this.H(view, z10);
            }
        };
        Context context = endCompoundLayout.getContext();
        int i10 = R.attr.motionDurationShort3;
        this.f١٠١٩٦e = a8.k.f(context, i10, 100);
        this.f١٠١٩٧f = a8.k.f(endCompoundLayout.getContext(), i10, 150);
        this.f١٠١٩٨g = a8.k.g(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, p7.a.f١٦٩٤٧a);
        this.f١٠١٩٩h = a8.k.g(endCompoundLayout.getContext(), R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٥٠d);
    }

    private void A(boolean z10) {
        boolean z11;
        if (this.f١٠٢٣٣b.F() == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && !this.f١٠٢٠٣l.isRunning()) {
            this.f١٠٢٠٤m.cancel();
            this.f١٠٢٠٣l.start();
            if (z11) {
                this.f١٠٢٠٣l.end();
                return;
            }
            return;
        }
        if (!z10) {
            this.f١٠٢٠٣l.cancel();
            this.f١٠٢٠٤m.start();
            if (z11) {
                this.f١٠٢٠٤m.end();
            }
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f١٠١٩٨g);
        ofFloat.setDuration(this.f١٠١٩٦e);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.E(valueAnimator);
            }
        });
        return ofFloat;
    }

    private ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f١٠١٩٩h);
        ofFloat.setDuration(this.f١٠١٩٧f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.F(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void D() {
        ValueAnimator C = C();
        ValueAnimator B2 = B(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f١٠٢٠٣l = animatorSet;
        animatorSet.playTogether(C, B2);
        this.f١٠٢٠٣l.addListener(new a());
        ValueAnimator B3 = B(1.0f, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٠٢٠٤m = B3;
        B3.addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f١٠٢٣٥d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f١٠٢٣٥d.setScaleX(floatValue);
        this.f١٠٢٣٥d.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f١٠٢٠٠i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    private boolean J() {
        EditText editText = this.f١٠٢٠٠i;
        if (editText != null && ((editText.hasFocus() || this.f١٠٢٣٥d.hasFocus()) && this.f١٠٢٠٠i.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f١٠٢٣٣b.w() != null) {
            return;
        }
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f١٠٢٠٢k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f١٠٢٠١j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f١٠٢٠٢k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f١٠٢٠٠i = editText;
        this.f١٠٢٣٢a.setEndIconVisible(J());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void q(boolean z10) {
        if (this.f١٠٢٣٣b.w() == null) {
            return;
        }
        A(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f١٠٢٠٠i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.I();
                }
            });
        }
    }
}
