package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.autofill.AutofillId;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.p0;
import androidx.core.view.d1;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.c0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import io.agora.rtc.Constants;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int D0 = R.style.Widget_Design_TextInputLayout;
    private static final int[][] E0 = {new int[]{android.R.attr.state_pressed}, new int[0]};
    private ColorStateList A;
    private boolean A0;

    /* renamed from: B, reason: collision with root package name */
    private ColorStateList f١٠١٢٩B;
    private boolean B0;
    private ColorStateList C;
    private boolean C0;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private f8.i G;
    private f8.i H;
    private StateListDrawable I;
    private boolean J;
    private f8.i K;
    private f8.i L;
    private f8.o M;
    private boolean N;
    private final int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private final Rect W;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f١٠١٣٠a;

    /* renamed from: a0, reason: collision with root package name */
    private final Rect f١٠١٣١a0;

    /* renamed from: b, reason: collision with root package name */
    private final StartCompoundLayout f١٠١٣٢b;

    /* renamed from: b0, reason: collision with root package name */
    private final RectF f١٠١٣٣b0;

    /* renamed from: c, reason: collision with root package name */
    private final EndCompoundLayout f١٠١٣٤c;

    /* renamed from: c0, reason: collision with root package name */
    private Typeface f١٠١٣٥c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٠١٣٦d;

    /* renamed from: d0, reason: collision with root package name */
    private Drawable f١٠١٣٧d0;

    /* renamed from: e, reason: collision with root package name */
    EditText f١٠١٣٨e;

    /* renamed from: e0, reason: collision with root package name */
    private int f١٠١٣٩e0;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f١٠١٤٠f;

    /* renamed from: f0, reason: collision with root package name */
    private final LinkedHashSet f١٠١٤١f0;

    /* renamed from: g, reason: collision with root package name */
    private int f١٠١٤٢g;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f١٠١٤٣g0;

    /* renamed from: h, reason: collision with root package name */
    private int f١٠١٤٤h;

    /* renamed from: h0, reason: collision with root package name */
    private int f١٠١٤٥h0;

    /* renamed from: i, reason: collision with root package name */
    private int f١٠١٤٦i;

    /* renamed from: i0, reason: collision with root package name */
    private Drawable f١٠١٤٧i0;

    /* renamed from: j, reason: collision with root package name */
    private int f١٠١٤٨j;

    /* renamed from: j0, reason: collision with root package name */
    private ColorStateList f١٠١٤٩j0;

    /* renamed from: k, reason: collision with root package name */
    private final u f١٠١٥٠k;

    /* renamed from: k0, reason: collision with root package name */
    private ColorStateList f١٠١٥١k0;

    /* renamed from: l, reason: collision with root package name */
    boolean f١٠١٥٢l;

    /* renamed from: l0, reason: collision with root package name */
    private int f١٠١٥٣l0;

    /* renamed from: m, reason: collision with root package name */
    private int f١٠١٥٤m;

    /* renamed from: m0, reason: collision with root package name */
    private int f١٠١٥٥m0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٠١٥٦n;

    /* renamed from: n0, reason: collision with root package name */
    private int f١٠١٥٧n0;

    /* renamed from: o, reason: collision with root package name */
    private f f١٠١٥٨o;

    /* renamed from: o0, reason: collision with root package name */
    private ColorStateList f١٠١٥٩o0;

    /* renamed from: p, reason: collision with root package name */
    private TextView f١٠١٦٠p;

    /* renamed from: p0, reason: collision with root package name */
    private int f١٠١٦١p0;

    /* renamed from: q, reason: collision with root package name */
    private int f١٠١٦٢q;

    /* renamed from: q0, reason: collision with root package name */
    private int f١٠١٦٣q0;

    /* renamed from: r, reason: collision with root package name */
    private int f١٠١٦٤r;

    /* renamed from: r0, reason: collision with root package name */
    private int f١٠١٦٥r0;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f١٠١٦٦s;

    /* renamed from: s0, reason: collision with root package name */
    private int f١٠١٦٧s0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f١٠١٦٨t;

    /* renamed from: t0, reason: collision with root package name */
    private int f١٠١٦٩t0;

    /* renamed from: u, reason: collision with root package name */
    private TextView f١٠١٧٠u;

    /* renamed from: u0, reason: collision with root package name */
    int f١٠١٧١u0;

    /* renamed from: v, reason: collision with root package name */
    private ColorStateList f١٠١٧٢v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f١٠١٧٣v0;

    /* renamed from: w, reason: collision with root package name */
    private int f١٠١٧٤w;

    /* renamed from: w0, reason: collision with root package name */
    final com.google.android.material.internal.b f١٠١٧٥w0;

    /* renamed from: x, reason: collision with root package name */
    private androidx.transition.d f١٠١٧٦x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f١٠١٧٧x0;

    /* renamed from: y, reason: collision with root package name */
    private androidx.transition.d f١٠١٧٨y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f١٠١٧٩y0;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f١٠١٨٠z;

    /* renamed from: z0, reason: collision with root package name */
    private ValueAnimator f١٠١٨١z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        CharSequence f١٠١٨٢a;

        /* renamed from: b, reason: collision with root package name */
        boolean f١٠١٨٣b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f١٠١٨٢a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f١٠١٨٢a, parcel, i10);
            parcel.writeInt(this.f١٠١٨٣b ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f١٠١٨٢a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f١٠١٨٣b = parcel.readInt() == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        int f١٠١٨٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f١٠١٨٥b;

        a(EditText editText) {
            this.f١٠١٨٥b = editText;
            this.f١٠١٨٤a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.y0(!r0.B0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f١٠١٥٢l) {
                textInputLayout.n0(editable);
            }
            if (TextInputLayout.this.f١٠١٦٨t) {
                TextInputLayout.this.C0(editable);
            }
            int lineCount = this.f١٠١٨٥b.getLineCount();
            int i10 = this.f١٠١٨٤a;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int minimumHeight = this.f١٠١٨٥b.getMinimumHeight();
                    int i11 = TextInputLayout.this.f١٠١٧١u0;
                    if (minimumHeight != i11) {
                        this.f١٠١٨٥b.setMinimumHeight(i11);
                    }
                }
                this.f١٠١٨٤a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, m2.g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.T0(false);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f١٠١٣٤c.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f١٠١٧٥w0.D0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends androidx.core.view.a {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f١٠١٩٠a;

        public e(TextInputLayout textInputLayout) {
            this.f١٠١٩٠a = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, m2.g0 g0Var) {
            CharSequence charSequence;
            boolean z10;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            EditText editText = this.f١٠١٩٠a.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = this.f١٠١٩٠a.getHint();
            CharSequence error = this.f١٠١٩٠a.getError();
            CharSequence placeholderText = this.f١٠١٩٠a.getPlaceholderText();
            int counterMaxLength = this.f١٠١٩٠a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f١٠١٩٠a.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean P = this.f١٠١٩٠a.P();
            boolean isEmpty3 = TextUtils.isEmpty(error);
            if (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!isEmpty2) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.f١٠١٩٠a.f١٠١٣٢b.y(g0Var);
            if (!isEmpty) {
                g0Var.R0(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                g0Var.R0(str);
                if (!P && placeholderText != null) {
                    g0Var.R0(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                g0Var.R0(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    g0Var.z0(str);
                } else {
                    if (!isEmpty) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    g0Var.R0(str);
                }
                g0Var.N0(isEmpty);
            }
            if (charSequence == null || charSequence.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            g0Var.C0(counterMaxLength);
            if (z10) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                g0Var.v0(error);
            }
            View t10 = this.f١٠١٩٠a.f١٠١٥٠k.t();
            if (t10 != null) {
                g0Var.A0(t10);
            }
            this.f١٠١٩٠a.f١٠١٣٤c.m().o(view, g0Var);
        }

        @Override // androidx.core.view.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f١٠١٩٠a.f١٠١٣٤c.m().p(view, accessibilityEvent);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f {
        int a(Editable editable);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface h {
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private androidx.transition.d A() {
        androidx.transition.d dVar = new androidx.transition.d();
        dVar.i0(a8.k.f(getContext(), R.attr.motionDurationShort2, 87));
        dVar.k0(a8.k.g(getContext(), R.attr.motionEasingLinearInterpolator, p7.a.f١٦٩٤٧a));
        return dVar;
    }

    private void A0() {
        EditText editText;
        if (this.f١٠١٧٠u != null && (editText = this.f١٠١٣٨e) != null) {
            this.f١٠١٧٠u.setGravity(editText.getGravity());
            this.f١٠١٧٠u.setPadding(this.f١٠١٣٨e.getCompoundPaddingLeft(), this.f١٠١٣٨e.getCompoundPaddingTop(), this.f١٠١٣٨e.getCompoundPaddingRight(), this.f١٠١٣٨e.getCompoundPaddingBottom());
        }
    }

    private boolean B() {
        if (this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof com.google.android.material.textfield.h)) {
            return true;
        }
        return false;
    }

    private void B0() {
        Editable text;
        EditText editText = this.f١٠١٣٨e;
        if (editText == null) {
            text = null;
        } else {
            text = editText.getText();
        }
        C0(text);
    }

    private void C() {
        Iterator it = this.f١٠١٤١f0.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Editable editable) {
        if (this.f١٠١٥٨o.a(editable) == 0 && !this.f١٠١٧٣v0) {
            i0();
        } else {
            L();
        }
    }

    private void D(Canvas canvas) {
        f8.i iVar;
        if (this.L != null && (iVar = this.K) != null) {
            iVar.draw(canvas);
            if (this.f١٠١٣٨e.isFocused()) {
                Rect bounds = this.L.getBounds();
                Rect bounds2 = this.K.getBounds();
                float H = this.f١٠١٧٥w0.H();
                int centerX = bounds2.centerX();
                bounds.left = p7.a.c(centerX, bounds2.left, H);
                bounds.right = p7.a.c(centerX, bounds2.right, H);
                this.L.draw(canvas);
            }
        }
    }

    private void D0(boolean z10, boolean z11) {
        int defaultColor = this.f١٠١٥٩o0.getDefaultColor();
        int colorForState = this.f١٠١٥٩o0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f١٠١٥٩o0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.U = colorForState2;
        } else if (z11) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    private void E(Canvas canvas) {
        if (this.D) {
            this.f١٠١٧٥w0.k(canvas);
        }
    }

    private void F(boolean z10) {
        ValueAnimator valueAnimator = this.f١٠١٨١z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f١٠١٨١z0.cancel();
        }
        if (z10 && this.f١٠١٧٩y0) {
            l(DownloadProgress.UNKNOWN_PROGRESS);
        } else {
            this.f١٠١٧٥w0.D0(DownloadProgress.UNKNOWN_PROGRESS);
        }
        if (B() && ((com.google.android.material.textfield.h) this.G).E0()) {
            y();
        }
        this.f١٠١٧٣v0 = true;
        L();
        this.f١٠١٣٢b.l(true);
        this.f١٠١٣٤c.H(true);
    }

    private f8.i G(boolean z10) {
        float f10;
        float dimensionPixelOffset;
        ColorStateList colorStateList;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (z10) {
            f10 = dimensionPixelOffset2;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        EditText editText = this.f١٠١٣٨e;
        if (editText instanceof MaterialAutoCompleteTextView) {
            dimensionPixelOffset = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        f8.o m10 = f8.o.a().E(f10).I(f10).v(dimensionPixelOffset2).z(dimensionPixelOffset2).m();
        EditText editText2 = this.f١٠١٣٨e;
        if (editText2 instanceof MaterialAutoCompleteTextView) {
            colorStateList = ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList();
        } else {
            colorStateList = null;
        }
        f8.i r10 = f8.i.r(getContext(), dimensionPixelOffset, colorStateList);
        r10.setShapeAppearanceModel(m10);
        r10.j0(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        return r10;
    }

    private static Drawable H(f8.i iVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{v7.a.k(i11, i10, 0.1f), i10}), iVar, iVar);
    }

    private int I(int i10, boolean z10) {
        int compoundPaddingLeft;
        if (!z10 && getPrefixText() != null) {
            compoundPaddingLeft = this.f١٠١٣٢b.c();
        } else if (z10 && getSuffixText() != null) {
            compoundPaddingLeft = this.f١٠١٣٤c.y();
        } else {
            compoundPaddingLeft = this.f١٠١٣٨e.getCompoundPaddingLeft();
        }
        return i10 + compoundPaddingLeft;
    }

    private int J(int i10, boolean z10) {
        int compoundPaddingRight;
        if (!z10 && getSuffixText() != null) {
            compoundPaddingRight = this.f١٠١٣٤c.y();
        } else if (z10 && getPrefixText() != null) {
            compoundPaddingRight = this.f١٠١٣٢b.c();
        } else {
            compoundPaddingRight = this.f١٠١٣٨e.getCompoundPaddingRight();
        }
        return i10 - compoundPaddingRight;
    }

    private static Drawable K(Context context, f8.i iVar, int i10, int[][] iArr) {
        int c10 = v7.a.c(context, R.attr.colorSurface, "TextInputLayout");
        f8.i iVar2 = new f8.i(iVar.getShapeAppearanceModel());
        int k10 = v7.a.k(i10, c10, 0.1f);
        iVar2.h0(new ColorStateList(iArr, new int[]{k10, 0}));
        iVar2.setTint(c10);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{k10, c10});
        f8.i iVar3 = new f8.i(iVar.getShapeAppearanceModel());
        iVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
    }

    private void L() {
        TextView textView = this.f١٠١٧٠u;
        if (textView != null && this.f١٠١٦٨t) {
            textView.setText((CharSequence) null);
            androidx.transition.x.b(this.f١٠١٣٠a, this.f١٠١٧٨y);
            this.f١٠١٧٠u.setVisibility(4);
        }
    }

    private boolean Q() {
        if (getHintMaxLines() == 1) {
            return true;
        }
        return false;
    }

    private boolean R() {
        if (!f0() && (this.f١٠١٦٠p == null || !this.f١٠١٥٦n)) {
            return false;
        }
        return true;
    }

    private boolean T() {
        if (this.P == 1 && this.f١٠١٣٨e.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int U(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f١٠١٣٨e.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(StaticLayout.Builder builder) {
        int breakStrategy;
        if (Build.VERSION.SDK_INT >= 23) {
            breakStrategy = this.f١٠١٧٠u.getBreakStrategy();
            builder.setBreakStrategy(breakStrategy);
        }
    }

    private void X() {
        p();
        u0();
        E0();
        j0();
        k();
        if (this.P != 0) {
            x0();
        }
        d0();
    }

    private void Y() {
        if (!B()) {
            return;
        }
        RectF rectF = this.f١٠١٣٣b0;
        this.f١٠١٧٥w0.o(rectF, this.f١٠١٣٨e.getWidth(), this.f١٠١٣٨e.getGravity());
        if (rectF.width() > DownloadProgress.UNKNOWN_PROGRESS && rectF.height() > DownloadProgress.UNKNOWN_PROGRESS) {
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.R);
            rectF.top = DownloadProgress.UNKNOWN_PROGRESS;
            ((com.google.android.material.textfield.h) this.G).H0(rectF);
        }
    }

    private void Z() {
        if (B() && !this.f١٠١٧٣v0) {
            y();
            Y();
        }
    }

    private static void a0(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                a0((ViewGroup) childAt, z10);
            }
        }
    }

    private void c0() {
        TextView textView = this.f١٠١٧٠u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void d0() {
        EditText editText = this.f١٠١٣٨e;
        if (!(editText instanceof AutoCompleteTextView)) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (autoCompleteTextView.getDropDownBackground() == null) {
            int i10 = this.P;
            if (i10 == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
            } else if (i10 == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    private boolean g0() {
        if ((this.f١٠١٣٤c.G() || ((this.f١٠١٣٤c.A() && M()) || this.f١٠١٣٤c.w() != null)) && this.f١٠١٣٤c.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f١٠١٣٨e;
        if ((editText instanceof AutoCompleteTextView) && !r.a(editText)) {
            int d10 = v7.a.d(this.f١٠١٣٨e, androidx.appcompat.R.attr.colorControlHighlight);
            int i10 = this.P;
            if (i10 == 2) {
                return K(getContext(), this.G, d10, E0);
            }
            if (i10 == 1) {
                return H(this.G, this.V, d10, E0);
            }
            return null;
        }
        return this.G;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], G(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = G(true);
        }
        return this.H;
    }

    private boolean h0() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f١٠١٣٢b.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void i0() {
        if (this.f١٠١٧٠u != null && this.f١٠١٦٨t && !TextUtils.isEmpty(this.f١٠١٦٦s)) {
            this.f١٠١٧٠u.setText(this.f١٠١٦٦s);
            androidx.transition.x.b(this.f١٠١٣٠a, this.f١٠١٧٦x);
            this.f١٠١٧٠u.setVisibility(0);
            this.f١٠١٧٠u.bringToFront();
        }
    }

    private void j() {
        TextView textView = this.f١٠١٧٠u;
        if (textView != null) {
            this.f١٠١٣٠a.addView(textView);
            this.f١٠١٧٠u.setVisibility(0);
        }
    }

    private void j0() {
        if (this.P == 1) {
            if (c8.c.l(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (c8.c.k(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void k() {
        if (this.f١٠١٣٨e != null && this.P == 1) {
            if (!Q()) {
                EditText editText = this.f١٠١٣٨e;
                editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f١٠١٧٥w0.r() + this.f١٠١٣٦d), this.f١٠١٣٨e.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            } else if (c8.c.l(getContext())) {
                EditText editText2 = this.f١٠١٣٨e;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.f١٠١٣٨e.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (c8.c.k(getContext())) {
                EditText editText3 = this.f١٠١٣٨e;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.f١٠١٣٨e.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    private void k0(Rect rect) {
        f8.i iVar = this.K;
        if (iVar != null) {
            int i10 = rect.bottom;
            iVar.setBounds(rect.left, i10 - this.S, rect.right, i10);
        }
        f8.i iVar2 = this.L;
        if (iVar2 != null) {
            int i11 = rect.bottom;
            iVar2.setBounds(rect.left, i11 - this.T, rect.right, i11);
        }
    }

    private void l0(int i10) {
        this.f١٠١٧٥w0.U0(i10);
        Rect rect = this.W;
        com.google.android.material.internal.d.a(this, this.f١٠١٣٨e, rect);
        this.f١٠١٧٥w0.g0(r(rect));
        x0();
        k();
        v0(i10);
    }

    private void m() {
        f8.i iVar = this.G;
        if (iVar == null) {
            return;
        }
        f8.o shapeAppearanceModel = iVar.getShapeAppearanceModel();
        f8.o oVar = this.M;
        if (shapeAppearanceModel != oVar) {
            this.G.setShapeAppearanceModel(oVar);
        }
        if (w()) {
            this.G.r0(this.R, this.U);
        }
        int q10 = q();
        this.V = q10;
        this.G.h0(ColorStateList.valueOf(q10));
        n();
        u0();
    }

    private void m0() {
        Editable text;
        if (this.f١٠١٦٠p != null) {
            EditText editText = this.f١٠١٣٨e;
            if (editText == null) {
                text = null;
            } else {
                text = editText.getText();
            }
            n0(text);
        }
    }

    private void n() {
        ColorStateList valueOf;
        if (this.K != null && this.L != null) {
            if (x()) {
                f8.i iVar = this.K;
                if (this.f١٠١٣٨e.isFocused()) {
                    valueOf = ColorStateList.valueOf(this.f١٠١٥٣l0);
                } else {
                    valueOf = ColorStateList.valueOf(this.U);
                }
                iVar.h0(valueOf);
                this.L.h0(ColorStateList.valueOf(this.U));
            }
            invalidate();
        }
    }

    private void o(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.O;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    private static void o0(Context context, TextView textView, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i12 = R.string.character_counter_overflowed_content_description;
        } else {
            i12 = R.string.character_counter_content_description;
        }
        textView.setContentDescription(context.getString(i12, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void p() {
        int i10 = this.P;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (this.D && !(this.G instanceof com.google.android.material.textfield.h)) {
                        this.G = com.google.android.material.textfield.h.D0(this.M);
                    } else {
                        this.G = new f8.i(this.M);
                    }
                    this.K = null;
                    this.L = null;
                    return;
                }
                throw new IllegalArgumentException(this.P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.G = new f8.i(this.M);
            this.K = new f8.i();
            this.L = new f8.i();
            return;
        }
        this.G = null;
        this.K = null;
        this.L = null;
    }

    private void p0() {
        int i10;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f١٠١٦٠p;
        if (textView != null) {
            if (this.f١٠١٥٦n) {
                i10 = this.f١٠١٦٢q;
            } else {
                i10 = this.f١٠١٦٤r;
            }
            e0(textView, i10);
            if (!this.f١٠١٥٦n && (colorStateList2 = this.f١٠١٨٠z) != null) {
                this.f١٠١٦٠p.setTextColor(colorStateList2);
            }
            if (this.f١٠١٥٦n && (colorStateList = this.A) != null) {
                this.f١٠١٦٠p.setTextColor(colorStateList);
            }
        }
    }

    private int q() {
        int i10 = this.V;
        if (this.P == 1) {
            return v7.a.j(v7.a.e(this, R.attr.colorSurface, 0), this.V);
        }
        return i10;
    }

    private void q0() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f١٠١٢٩B;
        if (colorStateList2 == null) {
            colorStateList2 = v7.a.h(getContext(), androidx.appcompat.R.attr.colorControlActivated);
        }
        EditText editText = this.f١٠١٣٨e;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable != null) {
                textCursorDrawable2 = this.f١٠١٣٨e.getTextCursorDrawable();
                Drawable mutate = h2.b.r(textCursorDrawable2).mutate();
                if (R() && (colorStateList = this.C) != null) {
                    colorStateList2 = colorStateList;
                }
                mutate.setTintList(colorStateList2);
            }
        }
    }

    private Rect r(Rect rect) {
        if (this.f١٠١٣٨e != null) {
            Rect rect2 = this.f١٠١٣١a0;
            boolean m10 = com.google.android.material.internal.k0.m(this);
            rect2.bottom = rect.bottom;
            int i10 = this.P;
            if (i10 != 1) {
                if (i10 != 2) {
                    rect2.left = I(rect.left, m10);
                    rect2.top = getPaddingTop();
                    rect2.right = J(rect.right, m10);
                    return rect2;
                }
                rect2.left = rect.left + this.f١٠١٣٨e.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f١٠١٣٨e.getPaddingRight();
                return rect2;
            }
            rect2.left = I(rect.left, m10);
            rect2.top = rect.top + this.Q;
            rect2.right = J(rect.right, m10);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int s(Rect rect, Rect rect2, float f10) {
        if (T()) {
            return (int) (rect2.top + f10);
        }
        return rect.bottom - this.f١٠١٣٨e.getCompoundPaddingBottom();
    }

    private void setEditText(EditText editText) {
        if (this.f١٠١٣٨e == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f١٠١٣٨e = editText;
            int i10 = this.f١٠١٤٢g;
            if (i10 != -1) {
                setMinEms(i10);
            } else {
                setMinWidth(this.f١٠١٤٦i);
            }
            int i11 = this.f١٠١٤٤h;
            if (i11 != -1) {
                setMaxEms(i11);
            } else {
                setMaxWidth(this.f١٠١٤٨j);
            }
            this.J = false;
            X();
            setTextInputAccessibilityDelegate(new e(this));
            this.f١٠١٧٥w0.R0(this.f١٠١٣٨e.getTypeface());
            this.f١٠١٧٥w0.A0(this.f١٠١٣٨e.getTextSize());
            this.f١٠١٧٥w0.u0(this.f١٠١٣٨e.getLetterSpacing());
            int gravity = this.f١٠١٣٨e.getGravity();
            this.f١٠١٧٥w0.m0((gravity & (-113)) | 48);
            this.f١٠١٧٥w0.z0(gravity);
            this.f١٠١٧١u0 = editText.getMinimumHeight();
            this.f١٠١٣٨e.addTextChangedListener(new a(editText));
            if (this.f١٠١٤٩j0 == null) {
                this.f١٠١٤٩j0 = this.f١٠١٣٨e.getHintTextColors();
            }
            if (this.D) {
                if (TextUtils.isEmpty(this.E)) {
                    CharSequence hint = this.f١٠١٣٨e.getHint();
                    this.f١٠١٤٠f = hint;
                    setHint(hint);
                    this.f١٠١٣٨e.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                q0();
            }
            if (this.f١٠١٦٠p != null) {
                n0(this.f١٠١٣٨e.getText());
            }
            s0();
            this.f١٠١٥٠k.f();
            this.f١٠١٣٢b.bringToFront();
            this.f١٠١٣٤c.bringToFront();
            C();
            this.f١٠١٣٤c.t0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            z0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.E)) {
            this.E = charSequence;
            this.f١٠١٧٥w0.O0(charSequence);
            if (!this.f١٠١٧٣v0) {
                Y();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f١٠١٦٨t == z10) {
            return;
        }
        if (z10) {
            j();
        } else {
            c0();
            this.f١٠١٧٠u = null;
        }
        this.f١٠١٦٨t = z10;
    }

    private int t(Rect rect, float f10) {
        int i10;
        if (T()) {
            return (int) (rect.centerY() - (f10 / 2.0f));
        }
        if (this.P == 0 && !Q()) {
            i10 = (int) (this.f١٠١٧٥w0.E() / 2.0f);
        } else {
            i10 = 0;
        }
        return (rect.top + this.f١٠١٣٨e.getCompoundPaddingTop()) - i10;
    }

    private void t0() {
        this.f١٠١٣٨e.setBackground(getEditTextBoxBackground());
    }

    private Rect u(Rect rect) {
        float B2;
        if (this.f١٠١٣٨e != null) {
            Rect rect2 = this.f١٠١٣١a0;
            if (Q()) {
                B2 = this.f١٠١٧٥w0.E();
            } else {
                B2 = this.f١٠١٧٥w0.B() * this.f١٠١٧٥w0.z();
            }
            rect2.left = rect.left + this.f١٠١٣٨e.getCompoundPaddingLeft();
            rect2.top = t(rect, B2);
            rect2.right = rect.right - this.f١٠١٣٨e.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, B2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int v() {
        if (!this.D) {
            return 0;
        }
        int i10 = this.P;
        if (i10 != 0) {
            if (i10 != 2) {
                return 0;
            }
            if (Q()) {
                return (int) (this.f١٠١٧٥w0.r() / 2.0f);
            }
            return Math.max(0, (int) (this.f١٠١٧٥w0.r() - (this.f١٠١٧٥w0.n() / 2.0f)));
        }
        return (int) this.f١٠١٧٥w0.r();
    }

    private void v0(int i10) {
        boolean z10;
        float f10;
        if (this.f١٠١٣٨e == null) {
            return;
        }
        float D = this.f١٠١٧٥w0.D();
        CharSequence charSequence = this.f١٠١٦٦s;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if (charSequence != null) {
            TextPaint textPaint = new TextPaint(Constants.ERR_WATERMARK_READ);
            textPaint.set(this.f١٠١٧٠u.getPaint());
            textPaint.setTextSize(this.f١٠١٧٠u.getTextSize());
            textPaint.setTypeface(this.f١٠١٧٠u.getTypeface());
            textPaint.setLetterSpacing(this.f١٠١٧٠u.getLetterSpacing());
            try {
                com.google.android.material.internal.c0 c10 = com.google.android.material.internal.c0.c(this.f١٠١٦٦s, textPaint, i10);
                if (getLayoutDirection() == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                StaticLayout a10 = c10.h(z10).g(true).i(this.f١٠١٧٠u.getLineSpacingExtra(), this.f١٠١٧٠u.getLineSpacingMultiplier()).k(new com.google.android.material.internal.d0() { // from class: com.google.android.material.textfield.m0
                    @Override // com.google.android.material.internal.d0
                    public final void a(StaticLayout.Builder builder) {
                        TextInputLayout.this.W(builder);
                    }
                }).a();
                if (this.P == 1) {
                    f10 = this.f١٠١٧٥w0.r() + this.Q + this.f١٠١٣٦d;
                } else {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                f11 = a10.getHeight() + f10;
            } catch (c0.a e10) {
                Log.e("TextInputLayout", e10.getCause().getMessage(), e10);
            }
        }
        float max = Math.max(D, f11);
        if (this.f١٠١٣٨e.getMeasuredHeight() < max) {
            this.f١٠١٣٨e.setMinimumHeight(Math.round(max));
        }
    }

    private boolean w() {
        if (this.P == 2 && x()) {
            return true;
        }
        return false;
    }

    private boolean w0() {
        int max;
        if (this.f١٠١٣٨e == null || this.f١٠١٣٨e.getMeasuredHeight() >= (max = Math.max(this.f١٠١٣٤c.getMeasuredHeight(), this.f١٠١٣٢b.getMeasuredHeight()))) {
            return false;
        }
        this.f١٠١٣٨e.setMinimumHeight(max);
        return true;
    }

    private boolean x() {
        if (this.R > -1 && this.U != 0) {
            return true;
        }
        return false;
    }

    private void x0() {
        if (this.P != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f١٠١٣٠a.getLayoutParams();
            int v10 = v();
            if (v10 != layoutParams.topMargin) {
                layoutParams.topMargin = v10;
                this.f١٠١٣٠a.requestLayout();
            }
        }
    }

    private void y() {
        if (B()) {
            ((com.google.android.material.textfield.h) this.G).F0();
        }
    }

    private void z(boolean z10) {
        ValueAnimator valueAnimator = this.f١٠١٨١z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f١٠١٨١z0.cancel();
        }
        if (z10 && this.f١٠١٧٩y0) {
            l(1.0f);
        } else {
            this.f١٠١٧٥w0.D0(1.0f);
        }
        this.f١٠١٧٣v0 = false;
        if (B()) {
            Y();
        }
        B0();
        this.f١٠١٣٢b.l(false);
        this.f١٠١٣٤c.H(false);
    }

    private void z0(boolean z10, boolean z11) {
        boolean z12;
        ColorStateList colorStateList;
        TextView textView;
        int i10;
        boolean isEnabled = isEnabled();
        EditText editText = this.f١٠١٣٨e;
        boolean z13 = false;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z12 = true;
        } else {
            z12 = false;
        }
        EditText editText2 = this.f١٠١٣٨e;
        if (editText2 != null && editText2.hasFocus()) {
            z13 = true;
        }
        ColorStateList colorStateList2 = this.f١٠١٤٩j0;
        if (colorStateList2 != null) {
            this.f١٠١٧٥w0.e0(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f١٠١٤٩j0;
            if (colorStateList3 != null) {
                i10 = colorStateList3.getColorForState(new int[]{-16842910}, this.f١٠١٦٩t0);
            } else {
                i10 = this.f١٠١٦٩t0;
            }
            this.f١٠١٧٥w0.e0(ColorStateList.valueOf(i10));
        } else if (f0()) {
            this.f١٠١٧٥w0.e0(this.f١٠١٥٠k.r());
        } else if (this.f١٠١٥٦n && (textView = this.f١٠١٦٠p) != null) {
            this.f١٠١٧٥w0.e0(textView.getTextColors());
        } else if (z13 && (colorStateList = this.f١٠١٥١k0) != null) {
            this.f١٠١٧٥w0.l0(colorStateList);
        }
        if (!z12 && this.f١٠١٧٧x0 && (!isEnabled() || !z13)) {
            if (z11 || !this.f١٠١٧٣v0) {
                F(z10);
                return;
            }
            return;
        }
        if (z11 || this.f١٠١٧٣v0) {
            z(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E0() {
        boolean z10;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G != null && this.P != 0) {
            boolean z11 = false;
            if (!isFocused() && ((editText2 = this.f١٠١٣٨e) == null || !editText2.hasFocus())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (isHovered() || ((editText = this.f١٠١٣٨e) != null && editText.isHovered())) {
                z11 = true;
            }
            if (!isEnabled()) {
                this.U = this.f١٠١٦٩t0;
            } else if (f0()) {
                if (this.f١٠١٥٩o0 != null) {
                    D0(z10, z11);
                } else {
                    this.U = getErrorCurrentTextColors();
                }
            } else if (this.f١٠١٥٦n && (textView = this.f١٠١٦٠p) != null) {
                if (this.f١٠١٥٩o0 != null) {
                    D0(z10, z11);
                } else {
                    this.U = textView.getCurrentTextColor();
                }
            } else if (z10) {
                this.U = this.f١٠١٥٧n0;
            } else if (z11) {
                this.U = this.f١٠١٥٥m0;
            } else {
                this.U = this.f١٠١٥٣l0;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                q0();
            }
            this.f١٠١٣٤c.I();
            b0();
            if (this.P == 2) {
                int i10 = this.R;
                if (z10 && isEnabled()) {
                    this.R = this.T;
                } else {
                    this.R = this.S;
                }
                if (this.R != i10) {
                    Z();
                }
            }
            if (this.P == 1) {
                if (!isEnabled()) {
                    this.V = this.f١٠١٦٣q0;
                } else if (z11 && !z10) {
                    this.V = this.f١٠١٦٧s0;
                } else if (z10) {
                    this.V = this.f١٠١٦٥r0;
                } else {
                    this.V = this.f١٠١٦١p0;
                }
            }
            m();
        }
    }

    public boolean M() {
        return this.f١٠١٣٤c.F();
    }

    public boolean N() {
        return this.f١٠١٥٠k.A();
    }

    public boolean O() {
        return this.f١٠١٥٠k.B();
    }

    final boolean P() {
        return this.f١٠١٧٣v0;
    }

    public boolean S() {
        return this.F;
    }

    public void addOnEditTextAttachedListener(g gVar) {
        this.f١٠١٤١f0.add(gVar);
        if (this.f١٠١٣٨e != null) {
            gVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(h hVar) {
        this.f١٠١٣٤c.addOnEndIconChangedListener(hVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f١٠١٣٠a.addView(view, layoutParams2);
            this.f١٠١٣٠a.setLayoutParams(layoutParams);
            x0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    public void b0() {
        this.f١٠١٣٢b.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        AutofillId autofillId;
        ViewStructure newChild;
        EditText editText = this.f١٠١٣٨e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f١٠١٤٠f == null) {
            autofillId = getAutofillId();
            viewStructure.setAutofillId(autofillId);
            onProvideAutofillStructure(viewStructure, i10);
            onProvideAutofillVirtualStructure(viewStructure, i10);
            viewStructure.setChildCount(this.f١٠١٣٠a.getChildCount());
            for (int i11 = 0; i11 < this.f١٠١٣٠a.getChildCount(); i11++) {
                View childAt = this.f١٠١٣٠a.getChildAt(i11);
                newChild = viewStructure.newChild(i11);
                childAt.dispatchProvideAutofillStructure(newChild, i10);
                if (childAt == this.f١٠١٣٨e) {
                    newChild.setHint(getHint());
                }
            }
            return;
        }
        boolean z10 = this.F;
        this.F = false;
        CharSequence hint = editText.getHint();
        this.f١٠١٣٨e.setHint(this.f١٠١٤٠f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
        } finally {
            this.f١٠١٣٨e.setHint(hint);
            this.F = z10;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z10;
        if (this.A0) {
            return;
        }
        boolean z11 = true;
        this.A0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.f١٠١٧٥w0;
        if (bVar != null) {
            z10 = bVar.M0(drawableState);
        } else {
            z10 = false;
        }
        if (this.f١٠١٣٨e != null) {
            if (!isLaidOut() || !isEnabled()) {
                z11 = false;
            }
            y0(z11);
        }
        s0();
        E0();
        if (z10) {
            invalidate();
        }
        this.A0 = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(TextView textView, int i10) {
        try {
            androidx.core.widget.l.m(textView, i10);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            androidx.core.widget.l.m(textView, androidx.appcompat.R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.a.getColor(getContext(), R.color.design_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f0() {
        return this.f١٠١٥٠k.l();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f١٠١٣٨e;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    f8.i getBoxBackground() {
        int i10 = this.P;
        if (i10 != 1 && i10 != 2) {
            throw new IllegalStateException();
        }
        return this.G;
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (com.google.android.material.internal.k0.m(this)) {
            return this.M.j().a(this.f١٠١٣٣b0);
        }
        return this.M.l().a(this.f١٠١٣٣b0);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (com.google.android.material.internal.k0.m(this)) {
            return this.M.l().a(this.f١٠١٣٣b0);
        }
        return this.M.j().a(this.f١٠١٣٣b0);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (com.google.android.material.internal.k0.m(this)) {
            return this.M.r().a(this.f١٠١٣٣b0);
        }
        return this.M.t().a(this.f١٠١٣٣b0);
    }

    public float getBoxCornerRadiusTopStart() {
        if (com.google.android.material.internal.k0.m(this)) {
            return this.M.t().a(this.f١٠١٣٣b0);
        }
        return this.M.r().a(this.f١٠١٣٣b0);
    }

    public int getBoxStrokeColor() {
        return this.f١٠١٥٧n0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f١٠١٥٩o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.f١٠١٥٤m;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f١٠١٥٢l && this.f١٠١٥٦n && (textView = this.f١٠١٦٠p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    public ColorStateList getCounterTextColor() {
        return this.f١٠١٨٠z;
    }

    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.f١٠١٢٩B;
    }

    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f١٠١٤٩j0;
    }

    public EditText getEditText() {
        return this.f١٠١٣٨e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f١٠١٣٤c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f١٠١٣٤c.n();
    }

    public int getEndIconMinSize() {
        return this.f١٠١٣٤c.o();
    }

    public int getEndIconMode() {
        return this.f١٠١٣٤c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f١٠١٣٤c.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f١٠١٣٤c.r();
    }

    public CharSequence getError() {
        if (this.f١٠١٥٠k.A()) {
            return this.f١٠١٥٠k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f١٠١٥٠k.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f١٠١٥٠k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f١٠١٥٠k.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f١٠١٣٤c.s();
    }

    public CharSequence getHelperText() {
        if (this.f١٠١٥٠k.B()) {
            return this.f١٠١٥٠k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f١٠١٥٠k.u();
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.f١٠١٧٥w0.r();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.f١٠١٧٥w0.w();
    }

    public int getHintMaxLines() {
        return this.f١٠١٧٥w0.A();
    }

    public ColorStateList getHintTextColor() {
        return this.f١٠١٥١k0;
    }

    public f getLengthCounter() {
        return this.f١٠١٥٨o;
    }

    public int getMaxEms() {
        return this.f١٠١٤٤h;
    }

    public int getMaxWidth() {
        return this.f١٠١٤٨j;
    }

    public int getMinEms() {
        return this.f١٠١٤٢g;
    }

    public int getMinWidth() {
        return this.f١٠١٤٦i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f١٠١٣٤c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f١٠١٣٤c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f١٠١٦٨t) {
            return this.f١٠١٦٦s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f١٠١٧٤w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f١٠١٧٢v;
    }

    public CharSequence getPrefixText() {
        return this.f١٠١٣٢b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f١٠١٣٢b.b();
    }

    public TextView getPrefixTextView() {
        return this.f١٠١٣٢b.d();
    }

    public f8.o getShapeAppearanceModel() {
        return this.M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f١٠١٣٢b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f١٠١٣٢b.f();
    }

    public int getStartIconMinSize() {
        return this.f١٠١٣٢b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f١٠١٣٢b.h();
    }

    public CharSequence getSuffixText() {
        return this.f١٠١٣٤c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f١٠١٣٤c.x();
    }

    public TextView getSuffixTextView() {
        return this.f١٠١٣٤c.z();
    }

    public Typeface getTypeface() {
        return this.f١٠١٣٥c0;
    }

    void l(float f10) {
        if (this.f١٠١٧٥w0.H() == f10) {
            return;
        }
        if (this.f١٠١٨١z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f١٠١٨١z0 = valueAnimator;
            valueAnimator.setInterpolator(a8.k.g(getContext(), R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b));
            this.f١٠١٨١z0.setDuration(a8.k.f(getContext(), R.attr.motionDurationMedium4, 167));
            this.f١٠١٨١z0.addUpdateListener(new d());
        }
        this.f١٠١٨١z0.setFloatValues(this.f١٠١٧٥w0.H(), f10);
        this.f١٠١٨١z0.start();
    }

    void n0(Editable editable) {
        boolean z10;
        int a10 = this.f١٠١٥٨o.a(editable);
        boolean z11 = this.f١٠١٥٦n;
        int i10 = this.f١٠١٥٤m;
        if (i10 == -1) {
            this.f١٠١٦٠p.setText(String.valueOf(a10));
            this.f١٠١٦٠p.setContentDescription(null);
            this.f١٠١٥٦n = false;
        } else {
            if (a10 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f١٠١٥٦n = z10;
            o0(getContext(), this.f١٠١٦٠p, a10, this.f١٠١٥٤m, this.f١٠١٥٦n);
            if (z11 != this.f١٠١٥٦n) {
                p0();
            }
            this.f١٠١٦٠p.setText(l2.a.c().j(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(a10), Integer.valueOf(this.f١٠١٥٤m))));
        }
        if (this.f١٠١٣٨e != null && z11 != this.f١٠١٥٦n) {
            y0(false);
            E0();
            s0();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f١٠١٧٥w0.Z(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f١٠١٣٤c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.C0 = false;
        boolean w02 = w0();
        boolean r02 = r0();
        if (w02 || r02) {
            this.f١٠١٣٨e.post(new Runnable() { // from class: com.google.android.material.textfield.k0
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout.this.V();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f١٠١٣٨e;
        if (editText != null) {
            Rect rect = this.W;
            com.google.android.material.internal.d.a(this, editText, rect);
            k0(rect);
            if (this.D) {
                this.f١٠١٧٥w0.A0(this.f١٠١٣٨e.getTextSize());
                int gravity = this.f١٠١٣٨e.getGravity();
                this.f١٠١٧٥w0.m0((gravity & (-113)) | 48);
                this.f١٠١٧٥w0.z0(gravity);
                this.f١٠١٧٥w0.g0(r(rect));
                this.f١٠١٧٥w0.t0(u(rect));
                this.f١٠١٧٥w0.b0();
                if (B() && !this.f١٠١٧٣v0) {
                    Y();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.C0) {
            this.f١٠١٣٤c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        A0();
        this.f١٠١٣٤c.t0();
        if (!Q()) {
            l0((this.f١٠١٣٨e.getMeasuredWidth() - this.f١٠١٣٨e.getCompoundPaddingLeft()) - this.f١٠١٣٨e.getCompoundPaddingRight());
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f١٠١٨٢a);
        if (savedState.f١٠١٨٣b) {
            post(new c());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10 != this.N) {
            float a10 = this.M.r().a(this.f١٠١٣٣b0);
            float a11 = this.M.t().a(this.f١٠١٣٣b0);
            float a12 = this.M.j().a(this.f١٠١٣٣b0);
            float a13 = this.M.l().a(this.f١٠١٣٣b0);
            f8.e q10 = this.M.q();
            f8.e s10 = this.M.s();
            f8.o m10 = f8.o.a().D(s10).H(q10).u(this.M.k()).y(this.M.i()).E(a11).I(a10).v(a13).z(a12).m();
            this.N = z10;
            setShapeAppearanceModel(m10);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (f0()) {
            savedState.f١٠١٨٢a = getError();
        }
        savedState.f١٠١٨٣b = this.f١٠١٣٤c.E();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r0() {
        boolean z10;
        if (this.f١٠١٣٨e == null) {
            return false;
        }
        boolean z11 = true;
        if (h0()) {
            int measuredWidth = this.f١٠١٣٢b.getMeasuredWidth() - this.f١٠١٣٨e.getPaddingLeft();
            if (this.f١٠١٣٧d0 == null || this.f١٠١٣٩e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f١٠١٣٧d0 = colorDrawable;
                this.f١٠١٣٩e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f١٠١٣٨e.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f١٠١٣٧d0;
            if (drawable != drawable2) {
                this.f١٠١٣٨e.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f١٠١٣٧d0 != null) {
                Drawable[] compoundDrawablesRelative2 = this.f١٠١٣٨e.getCompoundDrawablesRelative();
                this.f١٠١٣٨e.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f١٠١٣٧d0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (g0()) {
            int measuredWidth2 = this.f١٠١٣٤c.z().getMeasuredWidth() - this.f١٠١٣٨e.getPaddingRight();
            CheckableImageButton k10 = this.f١٠١٣٤c.k();
            if (k10 != null) {
                measuredWidth2 = measuredWidth2 + k10.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) k10.getLayoutParams()).getMarginStart();
            }
            Drawable[] compoundDrawablesRelative3 = this.f١٠١٣٨e.getCompoundDrawablesRelative();
            Drawable drawable3 = this.f١٠١٤٣g0;
            if (drawable3 != null && this.f١٠١٤٥h0 != measuredWidth2) {
                this.f١٠١٤٥h0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                this.f١٠١٣٨e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.f١٠١٤٣g0, compoundDrawablesRelative3[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f١٠١٤٣g0 = colorDrawable2;
                    this.f١٠١٤٥h0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.f١٠١٤٣g0;
                if (drawable4 != drawable5) {
                    this.f١٠١٤٧i0 = drawable4;
                    this.f١٠١٣٨e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z11 = z10;
                }
            }
        } else if (this.f١٠١٤٣g0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.f١٠١٣٨e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.f١٠١٤٣g0) {
                this.f١٠١٣٨e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f١٠١٤٧i0, compoundDrawablesRelative4[3]);
            } else {
                z11 = z10;
            }
            this.f١٠١٤٣g0 = null;
        } else {
            return z10;
        }
        return z11;
    }

    public void removeOnEditTextAttachedListener(g gVar) {
        this.f١٠١٤١f0.remove(gVar);
    }

    public void removeOnEndIconChangedListener(h hVar) {
        this.f١٠١٣٤c.removeOnEndIconChangedListener(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f١٠١٣٨e;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.c0.a(background)) {
            background = background.mutate();
        }
        if (f0()) {
            background.setColorFilter(androidx.appcompat.widget.f.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f١٠١٥٦n && (textView = this.f١٠١٦٠p) != null) {
            background.setColorFilter(androidx.appcompat.widget.f.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            h2.b.c(background);
            this.f١٠١٣٨e.refreshDrawableState();
        }
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.V != i10) {
            this.V = i10;
            this.f١٠١٦١p0 = i10;
            this.f١٠١٦٥r0 = i10;
            this.f١٠١٦٧s0 = i10;
            m();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.a.getColor(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f١٠١٦١p0 = defaultColor;
        this.V = defaultColor;
        this.f١٠١٦٣q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f١٠١٦٥r0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.f١٠١٦٧s0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.P) {
            return;
        }
        this.P = i10;
        if (this.f١٠١٣٨e != null) {
            X();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.Q = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.M = this.M.w().C(i10, this.M.r()).G(i10, this.M.t()).t(i10, this.M.j()).x(i10, this.M.l()).m();
        m();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f١٠١٥٧n0 != i10) {
            this.f١٠١٥٧n0 = i10;
            E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f١٠١٥٣l0 = colorStateList.getDefaultColor();
            this.f١٠١٦٩t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f١٠١٥٥m0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.f١٠١٥٧n0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.f١٠١٥٧n0 != colorStateList.getDefaultColor()) {
            this.f١٠١٥٧n0 = colorStateList.getDefaultColor();
        }
        E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f١٠١٥٩o0 != colorStateList) {
            this.f١٠١٥٩o0 = colorStateList;
            E0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.S = i10;
        E0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.T = i10;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f١٠١٥٢l != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f١٠١٦٠p = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.f١٠١٣٥c0;
                if (typeface != null) {
                    this.f١٠١٦٠p.setTypeface(typeface);
                }
                this.f١٠١٦٠p.setMaxLines(1);
                this.f١٠١٥٠k.e(this.f١٠١٦٠p, 2);
                ((ViewGroup.MarginLayoutParams) this.f١٠١٦٠p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                p0();
                m0();
            } else {
                this.f١٠١٥٠k.C(this.f١٠١٦٠p, 2);
                this.f١٠١٦٠p = null;
            }
            this.f١٠١٥٢l = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f١٠١٥٤m != i10) {
            if (i10 > 0) {
                this.f١٠١٥٤m = i10;
            } else {
                this.f١٠١٥٤m = -1;
            }
            if (this.f١٠١٥٢l) {
                m0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f١٠١٦٢q != i10) {
            this.f١٠١٦٢q = i10;
            p0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            p0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f١٠١٦٤r != i10) {
            this.f١٠١٦٤r = i10;
            p0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f١٠١٨٠z != colorStateList) {
            this.f١٠١٨٠z = colorStateList;
            p0();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f١٠١٢٩B != colorStateList) {
            this.f١٠١٢٩B = colorStateList;
            q0();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (R()) {
                q0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f١٠١٤٩j0 = colorStateList;
        this.f١٠١٥١k0 = colorStateList;
        if (this.f١٠١٣٨e != null) {
            y0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        a0(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f١٠١٣٤c.N(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f١٠١٣٤c.O(z10);
    }

    public void setEndIconContentDescription(int i10) {
        this.f١٠١٣٤c.P(i10);
    }

    public void setEndIconDrawable(int i10) {
        this.f١٠١٣٤c.R(i10);
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i10) {
        this.f١٠١٣٤c.T(i10);
    }

    public void setEndIconMode(int i10) {
        this.f١٠١٣٤c.U(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f١٠١٣٤c.setEndIconOnClickListener(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠١٣٤c.setEndIconOnLongClickListener(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f١٠١٣٤c.V(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f١٠١٣٤c.W(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f١٠١٣٤c.X(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f١٠١٣٤c.Y(z10);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f١٠١٥٠k.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f١٠١٥٠k.Q(charSequence);
        } else {
            this.f١٠١٥٠k.w();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        this.f١٠١٥٠k.E(i10);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f١٠١٥٠k.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f١٠١٥٠k.G(z10);
    }

    public void setErrorIconDrawable(int i10) {
        this.f١٠١٣٤c.Z(i10);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f١٠١٣٤c.setErrorIconOnClickListener(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠١٣٤c.setErrorIconOnLongClickListener(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f١٠١٣٤c.b0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f١٠١٣٤c.c0(mode);
    }

    public void setErrorTextAppearance(int i10) {
        this.f١٠١٥٠k.H(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f١٠١٥٠k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f١٠١٧٧x0 != z10) {
            this.f١٠١٧٧x0 = z10;
            y0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f١٠١٥٠k.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f١٠١٥٠k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f١٠١٥٠k.K(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f١٠١٥٠k.J(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f١٠١٧٩y0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.D) {
            this.D = z10;
            if (!z10) {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f١٠١٣٨e.getHint())) {
                    this.f١٠١٣٨e.setHint(this.E);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f١٠١٣٨e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f١٠١٣٨e.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.f١٠١٣٨e != null) {
                x0();
            }
        }
    }

    public void setHintMaxLines(int i10) {
        this.f١٠١٧٥w0.i0(i10);
        this.f١٠١٧٥w0.v0(i10);
        requestLayout();
    }

    public void setHintTextAppearance(int i10) {
        this.f١٠١٧٥w0.j0(i10);
        this.f١٠١٥١k0 = this.f١٠١٧٥w0.p();
        if (this.f١٠١٣٨e != null) {
            y0(false);
            x0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f١٠١٥١k0 != colorStateList) {
            if (this.f١٠١٤٩j0 == null) {
                this.f١٠١٧٥w0.l0(colorStateList);
            }
            this.f١٠١٥١k0 = colorStateList;
            if (this.f١٠١٣٨e != null) {
                y0(false);
            }
        }
    }

    public void setLengthCounter(f fVar) {
        this.f١٠١٥٨o = fVar;
    }

    public void setMaxEms(int i10) {
        this.f١٠١٤٤h = i10;
        EditText editText = this.f١٠١٣٨e;
        if (editText != null && i10 != -1) {
            editText.setMaxEms(i10);
        }
    }

    public void setMaxWidth(int i10) {
        this.f١٠١٤٨j = i10;
        EditText editText = this.f١٠١٣٨e;
        if (editText != null && i10 != -1) {
            editText.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f١٠١٤٢g = i10;
        EditText editText = this.f١٠١٣٨e;
        if (editText != null && i10 != -1) {
            editText.setMinEms(i10);
        }
    }

    public void setMinWidth(int i10) {
        this.f١٠١٤٦i = i10;
        EditText editText = this.f١٠١٣٨e;
        if (editText != null && i10 != -1) {
            editText.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        this.f١٠١٣٤c.e0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        this.f١٠١٣٤c.g0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f١٠١٣٤c.i0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f١٠١٣٤c.j0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f١٠١٣٤c.k0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f١٠١٧٠u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f١٠١٧٠u = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            this.f١٠١٧٠u.setImportantForAccessibility(1);
            this.f١٠١٧٠u.setAccessibilityLiveRegion(1);
            androidx.transition.d A = A();
            this.f١٠١٧٦x = A;
            A.n0(67L);
            this.f١٠١٧٨y = A();
            setPlaceholderTextAppearance(this.f١٠١٧٤w);
            setPlaceholderTextColor(this.f١٠١٧٢v);
            d1.q0(this.f١٠١٧٠u, new b());
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f١٠١٦٨t) {
                setPlaceholderTextEnabled(true);
            }
            this.f١٠١٦٦s = charSequence;
        }
        B0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.f١٠١٧٤w = i10;
        TextView textView = this.f١٠١٧٠u;
        if (textView != null) {
            androidx.core.widget.l.m(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f١٠١٧٢v != colorStateList) {
            this.f١٠١٧٢v = colorStateList;
            TextView textView = this.f١٠١٧٠u;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f١٠١٣٢b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i10) {
        this.f١٠١٣٢b.o(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f١٠١٣٢b.p(colorStateList);
    }

    public void setShapeAppearanceModel(f8.o oVar) {
        f8.i iVar = this.G;
        if (iVar != null && iVar.getShapeAppearanceModel() != oVar) {
            this.M = oVar;
            m();
        }
    }

    public void setStartIconCheckable(boolean z10) {
        this.f١٠١٣٢b.q(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i10) {
        this.f١٠١٣٢b.t(i10);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f١٠١٣٢b.setStartIconOnClickListener(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٠١٣٢b.setStartIconOnLongClickListener(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f١٠١٣٢b.u(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f١٠١٣٢b.v(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f١٠١٣٢b.w(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f١٠١٣٢b.x(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f١٠١٣٤c.l0(charSequence);
    }

    public void setSuffixTextAppearance(int i10) {
        this.f١٠١٣٤c.m0(i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f١٠١٣٤c.n0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f١٠١٣٨e;
        if (editText != null) {
            d1.q0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f١٠١٣٥c0) {
            this.f١٠١٣٥c0 = typeface;
            this.f١٠١٧٥w0.R0(typeface);
            this.f١٠١٥٠k.N(typeface);
            TextView textView = this.f١٠١٦٠p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0() {
        EditText editText = this.f١٠١٣٨e;
        if (editText != null && this.G != null) {
            if ((this.J || editText.getBackground() == null) && this.P != 0) {
                t0();
                this.J = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y0(boolean z10) {
        z0(z10, false);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f١٠١٣٤c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f١٠١٣٤c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f١٠١٣٤c.a0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f١٠١٣٤c.f0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f١٠١٣٤c.h0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f١٠١٣٢b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f١٠١٣٢b.s(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r9), attributeSet, i10);
        int i11 = D0;
        this.f١٠١٤٢g = -1;
        this.f١٠١٤٤h = -1;
        this.f١٠١٤٦i = -1;
        this.f١٠١٤٨j = -1;
        this.f١٠١٥٠k = new u(this);
        this.f١٠١٥٨o = new f() { // from class: com.google.android.material.textfield.l0
            @Override // com.google.android.material.textfield.TextInputLayout.f
            public final int a(Editable editable) {
                int U;
                U = TextInputLayout.U(editable);
                return U;
            }
        };
        this.W = new Rect();
        this.f١٠١٣١a0 = new Rect();
        this.f١٠١٣٣b0 = new RectF();
        this.f١٠١٤١f0 = new LinkedHashSet();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f١٠١٧٥w0 = bVar;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f١٠١٣٠a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = p7.a.f١٦٩٤٧a;
        bVar.P0(timeInterpolator);
        bVar.K0(timeInterpolator);
        bVar.m0(8388659);
        int[] iArr = R.styleable.TextInputLayout;
        int i12 = R.styleable.TextInputLayout_counterTextAppearance;
        int i13 = R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int i14 = R.styleable.TextInputLayout_errorTextAppearance;
        int i15 = R.styleable.TextInputLayout_helperTextTextAppearance;
        int i16 = R.styleable.TextInputLayout_hintTextAppearance;
        p0 j10 = com.google.android.material.internal.h0.j(context2, attributeSet, iArr, i10, i11, i12, i13, i14, i15, i16);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, j10);
        this.f١٠١٣٢b = startCompoundLayout;
        this.D = j10.a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(j10.p(R.styleable.TextInputLayout_android_hint));
        this.f١٠١٧٩y0 = j10.a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f١٠١٧٧x0 = j10.a(R.styleable.TextInputLayout_expandedHintEnabled, true);
        int i17 = R.styleable.TextInputLayout_android_minEms;
        if (j10.s(i17)) {
            setMinEms(j10.k(i17, -1));
        } else {
            int i18 = R.styleable.TextInputLayout_android_minWidth;
            if (j10.s(i18)) {
                setMinWidth(j10.f(i18, -1));
            }
        }
        int i19 = R.styleable.TextInputLayout_android_maxEms;
        if (j10.s(i19)) {
            setMaxEms(j10.k(i19, -1));
        } else {
            int i20 = R.styleable.TextInputLayout_android_maxWidth;
            if (j10.s(i20)) {
                setMaxWidth(j10.f(i20, -1));
            }
        }
        this.M = f8.o.e(context2, attributeSet, i10, i11).m();
        this.O = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.Q = j10.e(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f١٠١٣٦d = getResources().getDimensionPixelSize(R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.S = j10.f(R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.T = j10.f(R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.R = this.S;
        float d10 = j10.d(R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d11 = j10.d(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d12 = j10.d(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d13 = j10.d(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        o.b w10 = this.M.w();
        if (d10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            w10.E(d10);
        }
        if (d11 >= DownloadProgress.UNKNOWN_PROGRESS) {
            w10.I(d11);
        }
        if (d12 >= DownloadProgress.UNKNOWN_PROGRESS) {
            w10.z(d12);
        }
        if (d13 >= DownloadProgress.UNKNOWN_PROGRESS) {
            w10.v(d13);
        }
        this.M = w10.m();
        ColorStateList b10 = c8.c.b(context2, j10, R.styleable.TextInputLayout_boxBackgroundColor);
        if (b10 != null) {
            int defaultColor = b10.getDefaultColor();
            this.f١٠١٦١p0 = defaultColor;
            this.V = defaultColor;
            if (b10.isStateful()) {
                this.f١٠١٦٣q0 = b10.getColorForState(new int[]{-16842910}, -1);
                this.f١٠١٦٥r0 = b10.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.f١٠١٦٧s0 = b10.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.f١٠١٦٥r0 = this.f١٠١٦١p0;
                ColorStateList a10 = r1.a.a(context2, R.color.mtrl_filled_background_color);
                this.f١٠١٦٣q0 = a10.getColorForState(new int[]{-16842910}, -1);
                this.f١٠١٦٧s0 = a10.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.f١٠١٦١p0 = 0;
            this.f١٠١٦٣q0 = 0;
            this.f١٠١٦٥r0 = 0;
            this.f١٠١٦٧s0 = 0;
        }
        int i21 = R.styleable.TextInputLayout_android_textColorHint;
        if (j10.s(i21)) {
            ColorStateList c10 = j10.c(i21);
            this.f١٠١٥١k0 = c10;
            this.f١٠١٤٩j0 = c10;
        }
        int i22 = R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList b11 = c8.c.b(context2, j10, i22);
        this.f١٠١٥٧n0 = j10.b(i22, 0);
        this.f١٠١٥٣l0 = androidx.core.content.a.getColor(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.f١٠١٦٩t0 = androidx.core.content.a.getColor(context2, R.color.mtrl_textinput_disabled_color);
        this.f١٠١٥٥m0 = androidx.core.content.a.getColor(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (b11 != null) {
            setBoxStrokeColorStateList(b11);
        }
        int i23 = R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (j10.s(i23)) {
            setBoxStrokeErrorColor(c8.c.b(context2, j10, i23));
        }
        if (j10.n(i16, -1) != -1) {
            setHintTextAppearance(j10.n(i16, 0));
        }
        this.f١٠١٢٩B = j10.c(R.styleable.TextInputLayout_cursorColor);
        this.C = j10.c(R.styleable.TextInputLayout_cursorErrorColor);
        int n10 = j10.n(i14, 0);
        CharSequence p10 = j10.p(R.styleable.TextInputLayout_errorContentDescription);
        int k10 = j10.k(R.styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean a11 = j10.a(R.styleable.TextInputLayout_errorEnabled, false);
        int n11 = j10.n(i15, 0);
        boolean a12 = j10.a(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence p11 = j10.p(R.styleable.TextInputLayout_helperText);
        int n12 = j10.n(R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence p12 = j10.p(R.styleable.TextInputLayout_placeholderText);
        boolean a13 = j10.a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(j10.k(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f١٠١٦٤r = j10.n(i12, 0);
        this.f١٠١٦٢q = j10.n(i13, 0);
        setBoxBackgroundMode(j10.k(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(p10);
        setErrorAccessibilityLiveRegion(k10);
        setCounterOverflowTextAppearance(this.f١٠١٦٢q);
        setHelperTextTextAppearance(n11);
        setErrorTextAppearance(n10);
        setCounterTextAppearance(this.f١٠١٦٤r);
        setPlaceholderText(p12);
        setPlaceholderTextAppearance(n12);
        int i24 = R.styleable.TextInputLayout_errorTextColor;
        if (j10.s(i24)) {
            setErrorTextColor(j10.c(i24));
        }
        int i25 = R.styleable.TextInputLayout_helperTextTextColor;
        if (j10.s(i25)) {
            setHelperTextColor(j10.c(i25));
        }
        int i26 = R.styleable.TextInputLayout_hintTextColor;
        if (j10.s(i26)) {
            setHintTextColor(j10.c(i26));
        }
        int i27 = R.styleable.TextInputLayout_counterTextColor;
        if (j10.s(i27)) {
            setCounterTextColor(j10.c(i27));
        }
        int i28 = R.styleable.TextInputLayout_counterOverflowTextColor;
        if (j10.s(i28)) {
            setCounterOverflowTextColor(j10.c(i28));
        }
        int i29 = R.styleable.TextInputLayout_placeholderTextColor;
        if (j10.s(i29)) {
            setPlaceholderTextColor(j10.c(i29));
        }
        EndCompoundLayout endCompoundLayout = new EndCompoundLayout(this, j10);
        this.f١٠١٣٤c = endCompoundLayout;
        boolean a14 = j10.a(R.styleable.TextInputLayout_android_enabled, true);
        setHintMaxLines(j10.k(R.styleable.TextInputLayout_hintMaxLines, 1));
        j10.x();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(endCompoundLayout);
        addView(frameLayout);
        setEnabled(a14);
        setHelperTextEnabled(a12);
        setErrorEnabled(a11);
        setCounterEnabled(a13);
        setHelperText(p11);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
