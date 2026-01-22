package com.google.android.material.button;

import a8.k;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.j;
import f8.o;
import f8.r;
import f8.w;
import f8.x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v2.i;
import v2.l;
import v2.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, r {
    private static final int[] C = {R.attr.state_checkable};
    private static final int[] D = {R.attr.state_checked};
    private static final int E = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    private static final int F = com.google.android.material.R.attr.materialSizeOverlay;
    private static final i G = new a("widthIncrease");
    private float A;

    /* renamed from: B, reason: collision with root package name */
    private l f٨٥٠٢B;

    /* renamed from: a, reason: collision with root package name */
    private final d f٨٥٠٣a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f٨٥٠٤b;

    /* renamed from: c, reason: collision with root package name */
    private c f٨٥٠٥c;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f٨٥٠٦d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f٨٥٠٧e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f٨٥٠٨f;

    /* renamed from: g, reason: collision with root package name */
    private String f٨٥٠٩g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٥١٠h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٥١١i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٥١٢j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٥١٣k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٨٥١٤l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٨٥١٥m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨٥١٦n;

    /* renamed from: o, reason: collision with root package name */
    private int f٨٥١٧o;

    /* renamed from: p, reason: collision with root package name */
    private float f٨٥١٨p;

    /* renamed from: q, reason: collision with root package name */
    private int f٨٥١٩q;

    /* renamed from: r, reason: collision with root package name */
    private int f٨٥٢٠r;

    /* renamed from: s, reason: collision with root package name */
    private LinearLayout.LayoutParams f٨٥٢١s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٥٢٢t;

    /* renamed from: u, reason: collision with root package name */
    private int f٨٥٢٣u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٨٥٢٤v;

    /* renamed from: w, reason: collision with root package name */
    int f٨٥٢٥w;

    /* renamed from: x, reason: collision with root package name */
    x f٨٥٢٦x;

    /* renamed from: y, reason: collision with root package name */
    int f٨٥٢٧y;

    /* renamed from: z, reason: collision with root package name */
    private float f٨٥٢٨z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f٨٥٢٩a;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f٨٥٢٩a = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٨٥٢٩a ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends i {
        a(String str) {
            super(str);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MaterialButton materialButton, float f10) {
            materialButton.setDisplayedWidthIncrease(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface c {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private m g() {
        return k.h(getContext(), com.google.android.material.R.attr.motionSpringFastSpatial, com.google.android.material.R.style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f٨٥٢٨z;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        f8.i g10;
        if (this.f٨٥٢٢t && this.f٨٥٢٤v && (g10 = this.f٨٥٠٣a.g()) != null) {
            return (int) (g10.B() * 0.11f);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < lineCount; i10++) {
            f10 = Math.max(f10, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(f10);
    }

    private void h() {
        l lVar = new l(this, G);
        this.f٨٥٠٢B = lVar;
        lVar.y(g());
    }

    private boolean l() {
        int i10 = this.f٨٥١٦n;
        if (i10 != 3 && i10 != 4) {
            return false;
        }
        return true;
    }

    private boolean m() {
        int i10 = this.f٨٥١٦n;
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        return false;
    }

    private boolean n() {
        int i10 = this.f٨٥١٦n;
        if (i10 != 16 && i10 != 32) {
            return false;
        }
        return true;
    }

    private boolean o() {
        if ((getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getOrientation() == 0) {
            return true;
        }
        return false;
    }

    private boolean p() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private boolean q() {
        d dVar = this.f٨٥٠٣a;
        if (dVar != null && !dVar.q()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(float f10) {
        int i10 = (int) (f10 * 0.11f);
        if (this.f٨٥٢٣u != i10) {
            this.f٨٥٢٣u = i10;
            y();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.f٨٥٢٣u = getOpticalCenterShift();
        y();
        invalidate();
    }

    private void setCheckedInternal(boolean z10) {
        if (k() && this.f٨٥١٤l != z10) {
            this.f٨٥١٤l = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).w(this, this.f٨٥١٤l);
            }
            if (this.f٨٥١٥m) {
                return;
            }
            this.f٨٥١٥m = true;
            Iterator it = this.f٨٥٠٤b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(this, this.f٨٥١٤l);
            }
            this.f٨٥١٥m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f10) {
        if (this.f٨٥٢٨z != f10) {
            this.f٨٥٢٨z = f10;
            y();
            invalidate();
            if (getParent() instanceof MaterialButtonGroup) {
                ((MaterialButtonGroup) getParent()).l(this, (int) this.f٨٥٢٨z);
            }
        }
    }

    private void t(boolean z10) {
        if (this.f٨٥٢٦x == null) {
            return;
        }
        if (this.f٨٥٠٢B == null) {
            h();
        }
        if (this.f٨٥٢٤v) {
            this.f٨٥٠٢B.u(Math.min(this.f٨٥٢٧y, this.f٨٥٢٦x.e(getDrawableState()).f١٤٢٨٢a.a(getWidth())));
            if (z10) {
                this.f٨٥٠٢B.z();
            }
        }
    }

    private void v() {
        if (m()) {
            setCompoundDrawablesRelative(this.f٨٥٠٨f, null, null, null);
        } else if (l()) {
            setCompoundDrawablesRelative(null, null, this.f٨٥٠٨f, null);
        } else if (n()) {
            setCompoundDrawablesRelative(null, this.f٨٥٠٨f, null, null);
        }
    }

    private void w(boolean z10) {
        Drawable drawable = this.f٨٥٠٨f;
        if (drawable != null) {
            Drawable mutate = h2.b.r(drawable).mutate();
            this.f٨٥٠٨f = mutate;
            mutate.setTintList(this.f٨٥٠٧e);
            PorterDuff.Mode mode = this.f٨٥٠٦d;
            if (mode != null) {
                this.f٨٥٠٨f.setTintMode(mode);
            }
            int i10 = this.f٨٥١٠h;
            if (i10 == 0) {
                i10 = this.f٨٥٠٨f.getIntrinsicWidth();
            }
            int i11 = this.f٨٥١٠h;
            if (i11 == 0) {
                i11 = this.f٨٥٠٨f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f٨٥٠٨f;
            int i12 = this.f٨٥١١i;
            int i13 = this.f٨٥١٢j;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f٨٥٠٨f.setVisible(true, z10);
        }
        if (z10) {
            v();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((m() && drawable3 != this.f٨٥٠٨f) || ((l() && drawable5 != this.f٨٥٠٨f) || (n() && drawable4 != this.f٨٥٠٨f))) {
            v();
        }
    }

    private void x(int i10, int i11) {
        if (this.f٨٥٠٨f != null && getLayout() != null) {
            if (!m() && !l()) {
                if (n()) {
                    this.f٨٥١١i = 0;
                    if (this.f٨٥١٦n == 16) {
                        this.f٨٥١٢j = 0;
                        w(false);
                        return;
                    }
                    int i12 = this.f٨٥١٠h;
                    if (i12 == 0) {
                        i12 = this.f٨٥٠٨f.getIntrinsicHeight();
                    }
                    int max = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - i12) - this.f٨٥١٣k) - getPaddingBottom()) / 2);
                    if (this.f٨٥١٢j != max) {
                        this.f٨٥١٢j = max;
                        w(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.f٨٥١٢j = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i13 = this.f٨٥١٦n;
            boolean z10 = true;
            if (i13 != 1 && i13 != 3 && ((i13 != 2 || actualTextAlignment != Layout.Alignment.ALIGN_NORMAL) && (i13 != 4 || actualTextAlignment != Layout.Alignment.ALIGN_OPPOSITE))) {
                int i14 = this.f٨٥١٠h;
                if (i14 == 0) {
                    i14 = this.f٨٥٠٨f.getIntrinsicWidth();
                }
                int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - getPaddingEnd()) - i14) - this.f٨٥١٣k) - getPaddingStart();
                if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                    textLayoutWidth /= 2;
                }
                boolean p10 = p();
                if (this.f٨٥١٦n != 4) {
                    z10 = false;
                }
                if (p10 != z10) {
                    textLayoutWidth = -textLayoutWidth;
                }
                if (this.f٨٥١١i != textLayoutWidth) {
                    this.f٨٥١١i = textLayoutWidth;
                    w(false);
                    return;
                }
                return;
            }
            this.f٨٥١١i = 0;
            w(false);
        }
    }

    private void y() {
        int i10 = (int) (this.f٨٥٢٨z - this.A);
        int i11 = (i10 / 2) + this.f٨٥٢٣u;
        getLayoutParams().width = (int) (this.f٨٥١٨p + i10);
        setPaddingRelative(this.f٨٥١٩q + i11, getPaddingTop(), (this.f٨٥٢٠r + i10) - i11, getPaddingBottom());
    }

    public void addOnCheckedChangeListener(b bVar) {
        this.f٨٥٠٤b.add(bVar);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    String getA11yClassName() {
        Class cls;
        if (!TextUtils.isEmpty(this.f٨٥٠٩g)) {
            return this.f٨٥٠٩g;
        }
        if (k()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAllowedWidthDecrease() {
        return this.f٨٥٢٥w;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (q()) {
            return this.f٨٥٠٣a.b();
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public m getCornerSpringForce() {
        return this.f٨٥٠٣a.c();
    }

    public Drawable getIcon() {
        return this.f٨٥٠٨f;
    }

    public int getIconGravity() {
        return this.f٨٥١٦n;
    }

    public int getIconPadding() {
        return this.f٨٥١٣k;
    }

    public int getIconSize() {
        return this.f٨٥١٠h;
    }

    public ColorStateList getIconTint() {
        return this.f٨٥٠٧e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f٨٥٠٦d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f٨٥٠٣a.d();
    }

    @Dimension
    public int getInsetTop() {
        return this.f٨٥٠٣a.e();
    }

    public ColorStateList getRippleColor() {
        if (q()) {
            return this.f٨٥٠٣a.i();
        }
        return null;
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        if (q()) {
            return this.f٨٥٠٣a.j();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public w getStateListShapeAppearanceModel() {
        if (q()) {
            return this.f٨٥٠٣a.k();
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (q()) {
            return this.f٨٥٠٣a.l();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (q()) {
            return this.f٨٥٠٣a.m();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (q()) {
            return this.f٨٥٠٣a.n();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (q()) {
            return this.f٨٥٠٣a.o();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f٨٥١٤l;
    }

    public boolean k() {
        d dVar = this.f٨٥٠٣a;
        if (dVar != null && dVar.r()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (q()) {
            j.f(this, this.f٨٥٠٣a.g());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (k()) {
            View.mergeDrawableStates(onCreateDrawableState, C);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, D);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        x(getMeasuredWidth(), getMeasuredHeight());
        int i15 = getResources().getConfiguration().orientation;
        if (this.f٨٥١٧o != i15) {
            this.f٨٥١٧o = i15;
            this.f٨٥١٨p = -1.0f;
        }
        if (this.f٨٥١٨p == -1.0f) {
            this.f٨٥١٨p = getMeasuredWidth();
            if (this.f٨٥٢١s == null && (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getButtonSizeChange() != null) {
                this.f٨٥٢١s = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f٨٥٢١s);
                layoutParams.width = (int) this.f٨٥١٨p;
                setLayoutParams(layoutParams);
            }
        }
        if (this.f٨٥٢٥w == -1) {
            if (this.f٨٥٠٨f == null) {
                i14 = 0;
            } else {
                int iconPadding = getIconPadding();
                int i16 = this.f٨٥١٠h;
                if (i16 == 0) {
                    i16 = this.f٨٥٠٨f.getIntrinsicWidth();
                }
                i14 = iconPadding + i16;
            }
            this.f٨٥٢٥w = (getMeasuredWidth() - getTextLayoutWidth()) - i14;
        }
        if (this.f٨٥١٩q == -1) {
            this.f٨٥١٩q = getPaddingStart();
        }
        if (this.f٨٥٢٠r == -1) {
            this.f٨٥٢٠r = getPaddingEnd();
        }
        this.f٨٥٢٤v = o();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f٨٥٢٩a);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f٨٥٢٩a = this.f٨٥١٤l;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        x(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isEnabled() && this.f٨٥٠٣a.s()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f٨٥٠٨f != null) {
            if (this.f٨٥٠٨f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(b bVar) {
        this.f٨٥٠٤b.remove(bVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setA11yClassName(String str) {
        this.f٨٥٠٩g = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (q()) {
            this.f٨٥٠٣a.u(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (q()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f٨٥٠٣a.v();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (q()) {
            this.f٨٥٠٣a.w(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(int i10) {
        if (q()) {
            this.f٨٥٠٣a.x(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (q()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCornerSpringForce(m mVar) {
        this.f٨٥٠٣a.y(mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisplayedWidthDecrease(int i10) {
        this.A = Math.min(i10, this.f٨٥٢٥w);
        y();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (q()) {
            this.f٨٥٠٣a.g().g0(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f٨٥٠٨f != drawable) {
            this.f٨٥٠٨f = drawable;
            w(true);
            x(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f٨٥١٦n != i10) {
            this.f٨٥١٦n = i10;
            x(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f٨٥١٣k != i10) {
            this.f٨٥١٣k = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = r1.a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(int i10) {
        if (i10 >= 0) {
            if (this.f٨٥١٠h != i10) {
                this.f٨٥١٠h = i10;
                w(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f٨٥٠٧e != colorStateList) {
            this.f٨٥٠٧e = colorStateList;
            w(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f٨٥٠٦d != mode) {
            this.f٨٥٠٦d = mode;
            w(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(r1.a.a(getContext(), i10));
    }

    public void setInsetBottom(@Dimension int i10) {
        this.f٨٥٠٣a.z(i10);
    }

    public void setInsetTop(@Dimension int i10) {
        this.f٨٥٠٣a.A(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(c cVar) {
        this.f٨٥٠٥c = cVar;
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.f٨٥٢٢t != z10) {
            this.f٨٥٢٢t = z10;
            if (z10) {
                this.f٨٥٠٣a.setCornerSizeChangeListener(new i.d() { // from class: com.google.android.material.button.a
                    @Override // f8.i.d
                    public final void a(float f10) {
                        MaterialButton.this.r(f10);
                    }
                });
            } else {
                this.f٨٥٠٣a.setCornerSizeChangeListener(null);
            }
            post(new Runnable() { // from class: com.google.android.material.button.b
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.this.s();
                }
            });
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        c cVar = this.f٨٥٠٥c;
        if (cVar != null) {
            cVar.a(this, z10);
        }
        super.setPressed(z10);
        t(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (q()) {
            this.f٨٥٠٣a.B(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (q()) {
            setRippleColor(r1.a.a(getContext(), i10));
        }
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        if (q()) {
            this.f٨٥٠٣a.C(oVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (q()) {
            this.f٨٥٠٣a.D(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSizeChange(x xVar) {
        if (this.f٨٥٢٦x != xVar) {
            this.f٨٥٢٦x = xVar;
            t(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearanceModel(w wVar) {
        if (q()) {
            if (this.f٨٥٠٣a.c() == null && wVar.f()) {
                this.f٨٥٠٣a.y(g());
            }
            this.f٨٥٠٣a.E(wVar);
            return;
        }
        throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (q()) {
            this.f٨٥٠٣a.F(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (q()) {
            setStrokeColor(r1.a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (q()) {
            this.f٨٥٠٣a.G(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (q()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.y0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (q()) {
            this.f٨٥٠٣a.H(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (q()) {
            this.f٨٥٠٣a.I(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        x(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f٨٥٠٣a.J(z10);
    }

    @Override // android.widget.TextView
    public void setWidth(int i10) {
        this.f٨٥١٨p = -1.0f;
        super.setWidth(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidthChangeMax(int i10) {
        if (this.f٨٥٢٧y != i10) {
            this.f٨٥٢٧y = i10;
            t(true);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f٨٥١٤l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        LinearLayout.LayoutParams layoutParams = this.f٨٥٢١s;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.f٨٥٢١s = null;
            this.f٨٥١٨p = -1.0f;
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButton(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.e(context, attributeSet, i10, r6, new int[]{F}), attributeSet, i10);
        o m10;
        int i11 = E;
        this.f٨٥٠٤b = new LinkedHashSet();
        this.f٨٥١٤l = false;
        this.f٨٥١٥m = false;
        this.f٨٥١٧o = -1;
        this.f٨٥١٨p = -1.0f;
        this.f٨٥١٩q = -1;
        this.f٨٥٢٠r = -1;
        this.f٨٥٢٥w = -1;
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i10, i11, new int[0]);
        this.f٨٥١٣k = i12.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.f٨٥٠٦d = k0.o(i12.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f٨٥٠٧e = c8.c.a(getContext(), i12, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.f٨٥٠٨f = c8.c.e(getContext(), i12, com.google.android.material.R.styleable.MaterialButton_icon);
        this.f٨٥١٦n = i12.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.f٨٥١٠h = i12.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        w b10 = w.b(context2, i12, com.google.android.material.R.styleable.MaterialButton_shapeAppearance);
        if (b10 != null) {
            m10 = b10.c(true);
        } else {
            m10 = o.e(context2, attributeSet, i10, i11).m();
        }
        boolean z10 = i12.getBoolean(com.google.android.material.R.styleable.MaterialButton_opticalCenterEnabled, false);
        d dVar = new d(this, m10);
        this.f٨٥٠٣a = dVar;
        dVar.t(i12);
        setCheckedInternal(i12.getBoolean(com.google.android.material.R.styleable.MaterialButton_android_checked, false));
        if (b10 != null) {
            dVar.y(g());
            dVar.E(b10);
        }
        setOpticalCenterEnabled(z10);
        i12.recycle();
        setCompoundDrawablePadding(this.f٨٥١٣k);
        w(this.f٨٥٠٨f != null);
    }
}
