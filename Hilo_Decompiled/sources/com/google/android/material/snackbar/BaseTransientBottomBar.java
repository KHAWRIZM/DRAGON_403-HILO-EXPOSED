package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.a0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c8.c;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.k0;
import f8.i;
import f8.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseTransientBottomBar {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeInterpolator f٩٩٨٩a = p7.a.f١٦٩٤٨b;

    /* renamed from: b, reason: collision with root package name */
    private static final TimeInterpolator f٩٩٩٠b = p7.a.f١٦٩٤٧a;

    /* renamed from: c, reason: collision with root package name */
    private static final TimeInterpolator f٩٩٩١c = p7.a.f١٦٩٥٠d;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f٩٩٩٣e = {R.attr.snackbarStyle};

    /* renamed from: f, reason: collision with root package name */
    private static final String f٩٩٩٤f = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    static final Handler f٩٩٩٢d = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k, reason: collision with root package name */
        private final b f٩٩٩٥k = new b(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean L(View view) {
            return this.f٩٩٩٥k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f٩٩٩٥k.b(coordinatorLayout, view, motionEvent);
            return super.q(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: k, reason: collision with root package name */
        private static final View.OnTouchListener f٩٩٩٦k = new a();

        /* renamed from: a, reason: collision with root package name */
        o f٩٩٩٧a;

        /* renamed from: b, reason: collision with root package name */
        private int f٩٩٩٨b;

        /* renamed from: c, reason: collision with root package name */
        private final float f٩٩٩٩c;

        /* renamed from: d, reason: collision with root package name */
        private final float f١٠٠٠٠d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١٠٠٠١e;

        /* renamed from: f, reason: collision with root package name */
        private final int f١٠٠٠٢f;

        /* renamed from: g, reason: collision with root package name */
        private ColorStateList f١٠٠٠٣g;

        /* renamed from: h, reason: collision with root package name */
        private PorterDuff.Mode f١٠٠٠٤h;

        /* renamed from: i, reason: collision with root package name */
        private Rect f١٠٠٠٥i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f١٠٠٠٦j;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        private Drawable a() {
            int l10 = v7.a.l(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            o oVar = this.f٩٩٩٧a;
            Drawable d10 = oVar != null ? BaseTransientBottomBar.d(l10, oVar) : BaseTransientBottomBar.c(l10, getResources());
            if (this.f١٠٠٠٣g != null) {
                Drawable r10 = h2.b.r(d10);
                r10.setTintList(this.f١٠٠٠٣g);
                return r10;
            }
            return h2.b.r(d10);
        }

        private void b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f١٠٠٠٥i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        }

        float getActionTextColorAlpha() {
            return this.f١٠٠٠٠d;
        }

        int getAnimationMode() {
            return this.f٩٩٩٨b;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f٩٩٩٩c;
        }

        int getMaxInlineActionWidth() {
            return this.f١٠٠٠٢f;
        }

        int getMaxWidth() {
            return this.f١٠٠٠١e;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            requestApplyInsets();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f١٠٠٠١e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f١٠٠٠١e;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        void setAnimationMode(int i10) {
            this.f٩٩٩٨b = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f١٠٠٠٣g != null) {
                drawable = h2.b.r(drawable.mutate());
                drawable.setTintList(this.f١٠٠٠٣g);
                drawable.setTintMode(this.f١٠٠٠٤h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f١٠٠٠٣g = colorStateList;
            if (getBackground() != null) {
                Drawable r10 = h2.b.r(getBackground().mutate());
                r10.setTintList(colorStateList);
                r10.setTintMode(this.f١٠٠٠٤h);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f١٠٠٠٤h = mode;
            if (getBackground() != null) {
                Drawable r10 = h2.b.r(getBackground().mutate());
                r10.setTintMode(mode);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.f١٠٠٠٦j && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                b((ViewGroup.MarginLayoutParams) layoutParams);
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f٩٩٩٦k;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(g8.a.d(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                setElevation(obtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f٩٩٩٨b = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f٩٩٩٧a = o.e(context2, attributeSet, 0, 0).m();
            }
            this.f٩٩٩٩c = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(k0.o(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f١٠٠٠٠d = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f١٠٠٠١e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f١٠٠٠٢f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f٩٩٩٦k);
            setFocusable(true);
            if (getBackground() == null) {
                setBackground(a());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    return false;
                }
                a0.a(message.obj);
                throw null;
            }
            a0.a(message.obj);
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {
        public b(SwipeDismissBehavior swipeDismissBehavior) {
            swipeDismissBehavior.R(0.1f);
            swipeDismissBehavior.Q(0.6f);
            swipeDismissBehavior.S(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    com.google.android.material.snackbar.a.b().f(null);
                    return;
                }
                return;
            }
            if (coordinatorLayout.H(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.google.android.material.snackbar.a.b().e(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GradientDrawable c(int i10, Resources resources) {
        float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static i d(int i10, o oVar) {
        i iVar = new i(oVar);
        iVar.h0(ColorStateList.valueOf(i10));
        return iVar;
    }
}
