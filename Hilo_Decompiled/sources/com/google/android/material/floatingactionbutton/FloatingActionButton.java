package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import androidx.core.view.y0;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.e;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.google.android.material.stateful.ExtendableSavedState;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.r;
import java.util.List;
import p7.h;
import p7.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements y0, y7.a, r, CoordinatorLayout.b {

    /* renamed from: r, reason: collision with root package name */
    private static final int f٩٠٤١r = R.style.Widget_Design_FloatingActionButton;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f٩٠٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f٩٠٤٣c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f٩٠٤٤d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f٩٠٤٥e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f٩٠٤٦f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٠٤٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٩٠٤٨h;

    /* renamed from: i, reason: collision with root package name */
    private int f٩٠٤٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٠٥٠j;

    /* renamed from: k, reason: collision with root package name */
    private int f٩٠٥١k;

    /* renamed from: l, reason: collision with root package name */
    boolean f٩٠٥٢l;

    /* renamed from: m, reason: collision with root package name */
    final Rect f٩٠٥٣m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f٩٠٥٤n;

    /* renamed from: o, reason: collision with root package name */
    private final j f٩٠٥٥o;

    /* renamed from: p, reason: collision with root package name */
    private final y7.b f٩٠٥٦p;

    /* renamed from: q, reason: collision with root package name */
    private e f٩٠٥٧q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: K */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.h(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: O */
        public /* bridge */ /* synthetic */ boolean n(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.n(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: P */
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            return super.r(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void m(CoordinatorLayout.f fVar) {
            super.m(fVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @VisibleForTesting
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(b bVar) {
            super.setInternalAutoHideListener(bVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements e.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f٩٠٦١a;

        a(b bVar) {
            this.f٩٠٦١a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.e.g
        public void a() {
            this.f٩٠٦١a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.e.g
        public void b() {
            this.f٩٠٦١a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements e8.b {
        c() {
        }

        @Override // e8.b
        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f٩٠٥٣m.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f٩٠٥٠j, i11 + FloatingActionButton.this.f٩٠٥٠j, i12 + FloatingActionButton.this.f٩٠٥٠j, i13 + FloatingActionButton.this.f٩٠٥٠j);
        }

        @Override // e8.b
        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // e8.b
        public boolean c() {
            return FloatingActionButton.this.f٩٠٥٢l;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d implements e.f {

        /* renamed from: a, reason: collision with root package name */
        private final k f٩٠٦٤a;

        d(k kVar) {
            this.f٩٠٦٤a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        public void a() {
            this.f٩٠٦٤a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.e.f
        public void b() {
            this.f٩٠٦٤a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof d) && ((d) obj).f٩٠٦٤a.equals(this.f٩٠٦٤a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f٩٠٦٤a.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private e getImpl() {
        if (this.f٩٠٥٧q == null) {
            this.f٩٠٥٧q = new e(this, new c());
        }
        return this.f٩٠٥٧q;
    }

    private int i(int i10) {
        int i11 = this.f٩٠٤٩i;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 != -1) {
            if (i10 != 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return i(1);
        }
        return i(0);
    }

    private void j(Rect rect) {
        h(rect);
        int i10 = -this.f٩٠٥٧q.x();
        rect.inset(i10, i10);
    }

    private void n(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f٩٠٥٣m;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void o() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f٩٠٤٤d;
        if (colorStateList == null) {
            h2.b.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f٩٠٤٥e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.f.e(colorForState, mode));
    }

    private e.g q(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // y7.a
    public boolean a() {
        return this.f٩٠٥٦p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(k kVar) {
        getImpl().g(new d(kVar));
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f٩٠٤٢b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f٩٠٤٣c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().p();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().s();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().u();
    }

    public Drawable getContentBackground() {
        return getImpl().o();
    }

    public int getCustomSize() {
        return this.f٩٠٤٩i;
    }

    public int getExpandedComponentIdHint() {
        return this.f٩٠٥٦p.b();
    }

    public h getHideMotionSpec() {
        return getImpl().r();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f٩٠٤٦f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f٩٠٤٦f;
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return (o) androidx.core.util.h.g(getImpl().v());
    }

    public h getShowMotionSpec() {
        return getImpl().w();
    }

    public int getSize() {
        return this.f٩٠٤٨h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSizeDimension() {
        return i(this.f٩٠٤٨h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f٩٠٤٤d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f٩٠٤٥e;
    }

    public boolean getUseCompatPadding() {
        return this.f٩٠٥٢l;
    }

    public void h(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        n(rect);
    }

    public void hide(b bVar) {
        k(bVar, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    void k(b bVar, boolean z10) {
        getImpl().y(q(bVar), z10);
    }

    public boolean l() {
        return getImpl().B();
    }

    public boolean m() {
        return getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().E();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().G();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f٩٠٥٠j = (sizeDimension - this.f٩٠٥١k) / 2;
        getImpl().d0();
        int min = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f٩٠٥٣m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.f٩٠٥٦p.d((Bundle) androidx.core.util.h.g((Bundle) extendableSavedState.f١٠٠١٥a.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f١٠٠١٥a.put("expandableWidgetHelper", this.f٩٠٥٦p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            j(this.f٩٠٥٤n);
            if (!this.f٩٠٥٤n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    void p(b bVar, boolean z10) {
        getImpl().b0(q(bVar), z10);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f٩٠٤٢b != colorStateList) {
            this.f٩٠٤٢b = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f٩٠٤٣c != mode) {
            this.f٩٠٤٣c = mode;
            getImpl().M(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().N(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().Q(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().U(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f٩٠٤٩i) {
                this.f٩٠٤٩i = i10;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().e0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().q()) {
            getImpl().O(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f٩٠٥٦p.f(i10);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().P(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.d(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().c0();
            if (this.f٩٠٤٤d != null) {
                o();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f٩٠٥٥o.i(i10);
        o();
    }

    public void setMaxImageSize(int i10) {
        this.f٩٠٥١k = i10;
        getImpl().S(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().J();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().W(z10);
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        getImpl().X(oVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().Y(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.d(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f٩٠٤٩i = 0;
        if (i10 != this.f٩٠٤٨h) {
            this.f٩٠٤٨h = i10;
            requestLayout();
        }
    }

    @Override // androidx.core.view.y0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f٩٠٤٤d != colorStateList) {
            this.f٩٠٤٤d = colorStateList;
            o();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f٩٠٤٥e != mode) {
            this.f٩٠٤٥e = mode;
            o();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().K();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().K();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().K();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f٩٠٥٢l != z10) {
            this.f٩٠٥٢l = z10;
            getImpl().F();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void show(b bVar) {
        p(bVar, true);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f٩٠٥٨a;

        /* renamed from: b, reason: collision with root package name */
        private b f٩٠٥٩b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٩٠٦٠c;

        public BaseBehavior() {
            this.f٩٠٦٠c = true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (!this.f٩٠٦٠c || fVar.e() != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return true;
            }
            return false;
        }

        private static boolean M(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void N(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i10;
            Rect rect = floatingActionButton.f٩٠٥٣m;
            if (rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
                int i11 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                    i10 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin) {
                    i10 = -rect.left;
                } else {
                    i10 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                    i11 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                    i11 = -rect.top;
                }
                if (i11 != 0) {
                    d1.b0(floatingActionButton, i11);
                }
                if (i10 != 0) {
                    d1.a0(floatingActionButton, i10);
                }
            }
        }

        private boolean Q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (L(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f٩٠٥٨a == null) {
                this.f٩٠٥٨a = new Rect();
            }
            Rect rect = this.f٩٠٥٨a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.k(this.f٩٠٥٩b, false);
                return true;
            }
            floatingActionButton.p(this.f٩٠٥٩b, false);
            return true;
        }

        private boolean R(View view, FloatingActionButton floatingActionButton) {
            if (L(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.k(this.f٩٠٥٩b, false);
                return true;
            }
            floatingActionButton.p(this.f٩٠٥٩b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f٩٠٥٣m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                Q(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (M(view)) {
                R(view, floatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: P, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List x10 = coordinatorLayout.x(floatingActionButton);
            int size = x10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = (View) x10.get(i11);
                if (view instanceof AppBarLayout) {
                    if (Q(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (M(view) && R(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.O(floatingActionButton, i10);
            N(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void m(CoordinatorLayout.f fVar) {
            if (fVar.f٢٥٦٧h == 0) {
                fVar.f٢٥٦٧h = 80;
            }
        }

        @VisibleForTesting
        public void setInternalAutoHideListener(b bVar) {
            this.f٩٠٥٩b = bVar;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f٩٠٦٠c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f٩٠٤٦f != colorStateList) {
            this.f٩٠٤٦f = colorStateList;
            getImpl().V(this.f٩٠٤٦f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f٩٠٤١r;
        this.f٩٠٥٣m = new Rect();
        this.f٩٠٥٤n = new Rect();
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.FloatingActionButton, i10, i11, new int[0]);
        this.f٩٠٤٢b = c8.c.a(context2, i12, R.styleable.FloatingActionButton_backgroundTint);
        this.f٩٠٤٣c = k0.o(i12.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f٩٠٤٦f = c8.c.a(context2, i12, R.styleable.FloatingActionButton_rippleColor);
        this.f٩٠٤٨h = i12.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f٩٠٤٩i = i12.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f٩٠٤٧g = i12.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = i12.getDimension(R.styleable.FloatingActionButton_elevation, DownloadProgress.UNKNOWN_PROGRESS);
        float dimension2 = i12.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, DownloadProgress.UNKNOWN_PROGRESS);
        float dimension3 = i12.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٩٠٥٢l = i12.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(i12.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0));
        h c10 = h.c(context2, i12, R.styleable.FloatingActionButton_showMotionSpec);
        h c11 = h.c(context2, i12, R.styleable.FloatingActionButton_hideMotionSpec);
        o m10 = o.g(context2, attributeSet, i10, i11, o.f١٤١٧٨m).m();
        boolean z10 = i12.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(i12.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        i12.recycle();
        j jVar = new j(this);
        this.f٩٠٥٥o = jVar;
        jVar.g(attributeSet, i10);
        this.f٩٠٥٦p = new y7.b(this);
        getImpl().X(m10);
        getImpl().A(this.f٩٠٤٢b, this.f٩٠٤٣c, this.f٩٠٤٦f, this.f٩٠٤٧g);
        getImpl().T(dimensionPixelSize);
        getImpl().N(dimension);
        getImpl().Q(dimension2);
        getImpl().U(dimension3);
        getImpl().Y(c10);
        getImpl().P(c11);
        getImpl().O(z10);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
