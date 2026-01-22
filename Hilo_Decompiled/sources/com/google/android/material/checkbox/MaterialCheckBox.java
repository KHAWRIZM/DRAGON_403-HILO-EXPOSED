package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.a0;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.p0;
import androidx.vectordrawable.graphics.drawable.e;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.facebook.internal.q;
import com.facebook.internal.r;
import com.google.android.material.R;
import com.google.android.material.drawable.g;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[] A;

    /* renamed from: B, reason: collision with root package name */
    private static final int[][] f٨٦٩٦B;
    private static final int C;

    /* renamed from: y, reason: collision with root package name */
    private static final int f٨٦٩٧y = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f٨٦٩٨z = {R.attr.state_indeterminate};

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet f٨٦٩٩e;

    /* renamed from: f, reason: collision with root package name */
    private final LinkedHashSet f٨٧٠٠f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f٨٧٠١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٧٠٢h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٨٧٠٣i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٨٧٠٤j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f٨٧٠٥k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f٨٧٠٦l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f٨٧٠٧m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٨٧٠٨n;

    /* renamed from: o, reason: collision with root package name */
    ColorStateList f٨٧٠٩o;

    /* renamed from: p, reason: collision with root package name */
    ColorStateList f٨٧١٠p;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f٨٧١١q;

    /* renamed from: r, reason: collision with root package name */
    private int f٨٧١٢r;

    /* renamed from: s, reason: collision with root package name */
    private int[] f٨٧١٣s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٧١٤t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f٨٧١٥u;

    /* renamed from: v, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f٨٧١٦v;

    /* renamed from: w, reason: collision with root package name */
    private final e f٨٧١٧w;

    /* renamed from: x, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f٨٧١٨x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f٨٧١٩a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        private String a() {
            int i10 = this.f٨٧١٩a;
            if (i10 != 1) {
                if (i10 != 2) {
                    return "unchecked";
                }
                return "indeterminate";
            }
            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.f٨٧١٩a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f٨٧١٩a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends androidx.vectordrawable.graphics.drawable.b {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f٨٧٠٩o;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f٨٧٠٩o;
            if (colorStateList != null) {
                drawable.setTint(colorStateList.getColorForState(materialCheckBox.f٨٧١٣s, MaterialCheckBox.this.f٨٧٠٩o.getDefaultColor()));
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
    }

    static {
        int i10 = R.attr.state_error;
        A = new int[]{i10};
        f٨٦٩٦B = new int[][]{new int[]{android.R.attr.state_enabled, i10}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        C = Resources.getSystem().getIdentifier("btn_check_material_anim", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "android");
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private boolean c(p0 p0Var) {
        int n10 = p0Var.n(R.styleable.MaterialCheckBox_android_button, 0);
        int n11 = p0Var.n(R.styleable.MaterialCheckBox_buttonCompat, 0);
        if (n10 != C || n11 != 0) {
            return false;
        }
        return true;
    }

    private void e() {
        this.f٨٧٠٦l = g.d(this.f٨٧٠٦l, this.f٨٧٠٩o, androidx.core.widget.c.c(this));
        this.f٨٧٠٧m = g.d(this.f٨٧٠٧m, this.f٨٧١٠p, this.f٨٧١١q);
        g();
        h();
        super.setButtonDrawable(g.a(this.f٨٧٠٦l, this.f٨٧٠٧m));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 30 && this.f٨٧١٥u == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    private void g() {
        e eVar;
        if (!this.f٨٧٠٨n) {
            return;
        }
        e eVar2 = this.f٨٧١٧w;
        if (eVar2 != null) {
            eVar2.g(this.f٨٧١٨x);
            this.f٨٧١٧w.c(this.f٨٧١٨x);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Drawable drawable = this.f٨٧٠٦l;
            if ((drawable instanceof AnimatedStateListDrawable) && (eVar = this.f٨٧١٧w) != null) {
                int i10 = R.id.checked;
                int i11 = R.id.unchecked;
                ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, eVar, false);
                ((AnimatedStateListDrawable) this.f٨٧٠٦l).addTransition(R.id.indeterminate, i11, this.f٨٧١٧w, false);
            }
        }
    }

    private String getButtonStateDescription() {
        int i10 = this.f٨٧١٢r;
        if (i10 == 1) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_checked);
        }
        if (i10 == 0) {
            return getResources().getString(R.string.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f٨٧٠١g == null) {
            int[][] iArr = f٨٦٩٦B;
            int[] iArr2 = new int[iArr.length];
            int d10 = v7.a.d(this, androidx.appcompat.R.attr.colorControlActivated);
            int d11 = v7.a.d(this, androidx.appcompat.R.attr.colorError);
            int d12 = v7.a.d(this, R.attr.colorSurface);
            int d13 = v7.a.d(this, R.attr.colorOnSurface);
            iArr2[0] = v7.a.k(d12, d11, 1.0f);
            iArr2[1] = v7.a.k(d12, d10, 1.0f);
            iArr2[2] = v7.a.k(d12, d13, 0.54f);
            iArr2[3] = v7.a.k(d12, d13, 0.38f);
            iArr2[4] = v7.a.k(d12, d13, 0.38f);
            this.f٨٧٠١g = new ColorStateList(iArr, iArr2);
        }
        return this.f٨٧٠١g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f٨٧٠٩o;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }
        return getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f٨٧٠٦l;
        if (drawable != null && (colorStateList2 = this.f٨٧٠٩o) != null) {
            drawable.setTintList(colorStateList2);
        }
        Drawable drawable2 = this.f٨٧٠٧m;
        if (drawable2 != null && (colorStateList = this.f٨٧١٠p) != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    public void addOnCheckedStateChangedListener(b bVar) {
        this.f٨٧٠٠f.add(bVar);
    }

    public void addOnErrorChangedListener(c cVar) {
        this.f٨٦٩٩e.add(cVar);
    }

    public boolean d() {
        return this.f٨٧٠٤j;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f٨٧٠٦l;
    }

    public Drawable getButtonIconDrawable() {
        return this.f٨٧٠٧m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f٨٧١٠p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f٨٧١١q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f٨٧٠٩o;
    }

    public int getCheckedState() {
        return this.f٨٧١٢r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f٨٧٠٥k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        if (this.f٨٧١٢r == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f٨٧٠٢h && this.f٨٧٠٩o == null && this.f٨٧١٠p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f٨٦٩٨z);
        }
        if (d()) {
            View.mergeDrawableStates(onCreateDrawableState, A);
        }
        this.f٨٧١٣s = g.f(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable a10;
        int i10;
        if (this.f٨٧٠٣i && TextUtils.isEmpty(getText()) && (a10 = androidx.core.widget.c.a(this)) != null) {
            if (k0.m(this)) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            int width = ((getWidth() - a10.getIntrinsicWidth()) / 2) * i10;
            int save = canvas.save();
            canvas.translate(width, DownloadProgress.UNKNOWN_PROGRESS);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = a10.getBounds();
                getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f٨٧٠٥k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f٨٧١٩a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f٨٧١٩a = getCheckedState();
        return savedState;
    }

    public void removeOnCheckedStateChangedListener(b bVar) {
        this.f٨٧٠٠f.remove(bVar);
    }

    public void removeOnErrorChangedListener(c cVar) {
        this.f٨٦٩٩e.remove(cVar);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(r1.a.b(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f٨٧٠٧m = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(r1.a.b(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f٨٧١٠p == colorStateList) {
            return;
        }
        this.f٨٧١٠p = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f٨٧١١q == mode) {
            return;
        }
        this.f٨٧١١q = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f٨٧٠٩o == colorStateList) {
            return;
        }
        this.f٨٧٠٩o = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f٨٧٠٣i = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        boolean z10;
        Object systemService;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f٨٧١٢r != i10) {
            this.f٨٧١٢r = i10;
            if (i10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            super.setChecked(z10);
            refreshDrawableState();
            f();
            if (this.f٨٧١٤t) {
                return;
            }
            this.f٨٧١٤t = true;
            LinkedHashSet linkedHashSet = this.f٨٧٠٠f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    a0.a(it.next());
                    throw null;
                }
            }
            if (this.f٨٧١٢r != 2 && (onCheckedChangeListener = this.f٨٧١٦v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                systemService = getContext().getSystemService((Class<Object>) q.a());
                AutofillManager a10 = r.a(systemService);
                if (a10 != null) {
                    a10.notifyValueChanged(this);
                }
            }
            this.f٨٧١٤t = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f٨٧٠٥k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        setErrorAccessibilityLabel(charSequence);
    }

    public void setErrorShown(boolean z10) {
        if (this.f٨٧٠٤j == z10) {
            return;
        }
        this.f٨٧٠٤j = z10;
        refreshDrawableState();
        Iterator it = this.f٨٦٩٩e.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f٨٧١٦v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(CharSequence charSequence) {
        this.f٨٧١٥u = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f٨٧٠٢h = z10;
        if (z10) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.checkboxStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f٨٧٠٦l = drawable;
        this.f٨٧٠٨n = false;
        e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨٦٩٧y;
        this.f٨٦٩٩e = new LinkedHashSet();
        this.f٨٧٠٠f = new LinkedHashSet();
        this.f٨٧١٧w = e.a(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.f٨٧١٨x = new a();
        Context context2 = getContext();
        this.f٨٧٠٦l = androidx.core.widget.c.a(this);
        this.f٨٧٠٩o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        p0 j10 = h0.j(context2, attributeSet, R.styleable.MaterialCheckBox, i10, i11, new int[0]);
        this.f٨٧٠٧m = j10.g(R.styleable.MaterialCheckBox_buttonIcon);
        if (this.f٨٧٠٦l != null && h0.g(context2) && c(j10)) {
            super.setButtonDrawable((Drawable) null);
            this.f٨٧٠٦l = r1.a.b(context2, R.drawable.mtrl_checkbox_button);
            this.f٨٧٠٨n = true;
            if (this.f٨٧٠٧m == null) {
                this.f٨٧٠٧m = r1.a.b(context2, R.drawable.mtrl_checkbox_button_icon);
            }
        }
        this.f٨٧١٠p = c8.c.b(context2, j10, R.styleable.MaterialCheckBox_buttonIconTint);
        this.f٨٧١١q = k0.o(j10.k(R.styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f٨٧٠٢h = j10.a(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f٨٧٠٣i = j10.a(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f٨٧٠٤j = j10.a(R.styleable.MaterialCheckBox_errorShown, false);
        this.f٨٧٠٥k = j10.p(R.styleable.MaterialCheckBox_errorAccessibilityLabel);
        int i12 = R.styleable.MaterialCheckBox_checkedState;
        if (j10.s(i12)) {
            setCheckedState(j10.k(i12, 0));
        }
        j10.x();
        e();
    }
}
