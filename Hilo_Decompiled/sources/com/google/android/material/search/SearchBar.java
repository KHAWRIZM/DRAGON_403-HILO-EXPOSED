package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.i0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SearchBar extends Toolbar {

    /* renamed from: x, reason: collision with root package name */
    private static final int f٩٧٤٨x = R.style.Widget_Material3_SearchBar;

    /* renamed from: a, reason: collision with root package name */
    private final TextView f٩٧٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f٩٧٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private final FrameLayout f٩٧٥١c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٩٧٥٢d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٩٧٥٣e;

    /* renamed from: f, reason: collision with root package name */
    private final ColorStateList f٩٧٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f٩٧٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f٩٧٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private final b f٩٧٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private final Drawable f٩٧٥٨j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f٩٧٥٩k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f٩٧٦٠l;

    /* renamed from: m, reason: collision with root package name */
    private View f٩٧٦١m;

    /* renamed from: n, reason: collision with root package name */
    private Integer f٩٧٦٢n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f٩٧٦٣o;

    /* renamed from: p, reason: collision with root package name */
    private int f٩٧٦٤p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٩٧٦٥q;

    /* renamed from: r, reason: collision with root package name */
    private f8.i f٩٧٦٦r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٩٧٦٧s;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٧٦٨t;

    /* renamed from: u, reason: collision with root package name */
    private ActionMenuView f٩٧٦٩u;

    /* renamed from: v, reason: collision with root package name */
    private ImageButton f٩٧٧٠v;

    /* renamed from: w, reason: collision with root package name */
    private final AppBarLayout.g f٩٧٧١w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f٩٧٧٢a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f٩٧٧٢a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٩٧٧٢a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AppBarLayout.g {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.g
        public void a(float f10, int i10, float f11) {
            if (SearchBar.this.f٩٧٥٤f != null) {
                SearchBar.this.f٩٧٦٦r.h0(ColorStateList.valueOf(v7.a.k(SearchBar.this.f٩٧٥٢d, SearchBar.this.f٩٧٥٤f.getDefaultColor(), f11)));
            }
        }
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    private int A(int i10, int i11) {
        return i10 == 0 ? i11 : i10;
    }

    private ActionMenuView B() {
        if (this.f٩٧٦٩u == null) {
            this.f٩٧٦٩u = i0.a(this);
        }
        return this.f٩٧٦٩u;
    }

    private ImageButton C() {
        if (this.f٩٧٧٠v == null) {
            this.f٩٧٧٠v = i0.d(this);
        }
        return this.f٩٧٧٠v;
    }

    private void D(f8.o oVar, int i10, float f10, float f11, int i11) {
        f8.i iVar = new f8.i(oVar);
        this.f٩٧٦٦r = iVar;
        iVar.V(getContext());
        this.f٩٧٦٦r.g0(f10);
        if (f11 >= DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٩٧٦٦r.r0(f11, i11);
        }
        int d10 = v7.a.d(this, androidx.appcompat.R.attr.colorControlHighlight);
        this.f٩٧٦٦r.h0(ColorStateList.valueOf(i10));
        ColorStateList valueOf = ColorStateList.valueOf(d10);
        f8.i iVar2 = this.f٩٧٦٦r;
        setBackground(new RippleDrawable(valueOf, iVar2, iVar2));
    }

    private void E() {
        Drawable navigationIcon;
        if (getNavigationIcon() == null) {
            navigationIcon = this.f٩٧٥٨j;
        } else {
            navigationIcon = getNavigationIcon();
        }
        setNavigationIcon(navigationIcon);
        setNavigationIconDecorative(true);
    }

    private void F(int i10, String str, String str2) {
        if (i10 != -1) {
            androidx.core.widget.l.m(this.f٩٧٤٩a, i10);
            androidx.core.widget.l.m(this.f٩٧٥٠b, i10);
        }
        setText(str);
        setHint(str2);
        setTextCentered(this.f٩٧٦٧s);
    }

    private void G(View view, int i10, int i11, int i12, int i13) {
        if (getLayoutDirection() == 1) {
            view.layout(getMeasuredWidth() - i12, i11, getMeasuredWidth() - i10, i13);
        } else {
            view.layout(i10, i11, i12, i13);
        }
    }

    private void H() {
        ActionMenuView actionMenuView;
        int i10;
        int i11;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f٩٧٥١c.getMeasuredWidth() / 2);
        int measuredWidth2 = this.f٩٧٥١c.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (getMeasuredHeight() / 2) - (this.f٩٧٥١c.getMeasuredHeight() / 2);
        int measuredHeight2 = this.f٩٧٥١c.getMeasuredHeight() + measuredHeight;
        boolean z10 = true;
        if (getLayoutDirection() != 1) {
            z10 = false;
        }
        ActionMenuView B2 = B();
        ImageButton C = C();
        int measuredWidth3 = (this.f٩٧٥١c.getMeasuredWidth() / 2) - (this.f٩٧٤٩a.getMeasuredWidth() / 2);
        int measuredWidth4 = this.f٩٧٤٩a.getMeasuredWidth() + measuredWidth3;
        int i12 = measuredWidth3 + measuredWidth;
        int i13 = measuredWidth4 + measuredWidth;
        if (z10) {
            actionMenuView = B2;
        } else {
            actionMenuView = C;
        }
        if (z10) {
            B2 = C;
        }
        if (actionMenuView != null) {
            i10 = Math.max(actionMenuView.getRight() - i12, 0);
        } else {
            i10 = 0;
        }
        int i14 = i12 + i10;
        int i15 = i13 + i10;
        if (B2 != null) {
            i11 = Math.max(i15 - B2.getLeft(), 0);
        } else {
            i11 = 0;
        }
        int i16 = i14 - i11;
        int i17 = i15 - i11;
        int max = Math.max(getPaddingLeft() - i16, getContentInsetLeft() - i16);
        int max2 = Math.max(i17 - (getMeasuredWidth() - getPaddingRight()), i17 - (getMeasuredWidth() - getContentInsetRight()));
        int max3 = ((i10 - i11) + Math.max(max, 0)) - Math.max(max2, 0);
        this.f٩٧٥١c.layout(measuredWidth + max3, measuredHeight, measuredWidth2 + max3, measuredHeight2);
    }

    private void I(View view) {
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i10 = measuredWidth2 + measuredWidth;
        int measuredHeight = view.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        G(view, measuredWidth2, measuredHeight2, i10, measuredHeight2 + measuredHeight);
    }

    private Drawable J(Drawable drawable) {
        int i10;
        int d10;
        if (this.f٩٧٥٩k && drawable != null) {
            Integer num = this.f٩٧٦٢n;
            if (num != null) {
                d10 = num.intValue();
            } else {
                if (drawable == this.f٩٧٥٨j) {
                    i10 = R.attr.colorOnSurfaceVariant;
                } else {
                    i10 = R.attr.colorOnSurface;
                }
                d10 = v7.a.d(this, i10);
            }
            Drawable r10 = h2.b.r(drawable.mutate());
            r10.setTint(d10);
            return r10;
        }
        return drawable;
    }

    private void K(int i10, int i11) {
        View view = this.f٩٧٦١m;
        if (view != null) {
            view.measure(i10, i11);
        }
    }

    private void L() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.x(this.f٩٧٧١w);
        }
    }

    private void M() {
        if (this.f٩٧٥٦h && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = A(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = A(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = A(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = A(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void N() {
        int i10;
        int i11;
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z10 = true;
        int i12 = 0;
        if (getLayoutDirection() != 1) {
            z10 = false;
        }
        ImageButton d10 = i0.d(this);
        if (d10 != null && d10.isClickable()) {
            if (z10) {
                i10 = getWidth() - d10.getLeft();
            } else {
                i10 = d10.getRight();
            }
        } else {
            i10 = 0;
        }
        ActionMenuView a10 = i0.a(this);
        if (a10 != null) {
            if (z10) {
                i12 = a10.getRight();
            } else {
                i12 = getWidth() - a10.getLeft();
            }
        }
        if (z10) {
            i11 = i12;
        } else {
            i11 = i10;
        }
        float f10 = -i11;
        if (!z10) {
            i10 = i12;
        }
        setHandwritingBoundsOffsets(f10, DownloadProgress.UNKNOWN_PROGRESS, -i10, DownloadProgress.UNKNOWN_PROGRESS);
    }

    private void O() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f٩٧٦٥q) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    private void Q(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") == null) {
                return;
            } else {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
    }

    private AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    private void setNavigationIconDecorative(boolean z10) {
        Drawable drawable;
        ImageButton d10 = i0.d(this);
        if (d10 == null) {
            return;
        }
        d10.setClickable(!z10);
        d10.setFocusable(!z10);
        Drawable background = d10.getBackground();
        if (background != null) {
            this.f٩٧٦٣o = background;
        }
        if (z10) {
            drawable = null;
        } else {
            drawable = this.f٩٧٦٣o;
        }
        d10.setBackgroundDrawable(drawable);
        N();
    }

    private void z() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null && this.f٩٧٥٤f != null) {
            appBarLayoutParentIfExists.addLiftOnScrollProgressListener(this.f٩٧٧١w);
        }
    }

    public void P() {
        this.f٩٧٥٧i.b(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f٩٧٥٥g && this.f٩٧٦١m == null && !(view instanceof ActionMenuView)) {
            this.f٩٧٦١m = view;
            view.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
        }
        super.addView(view, i10, layoutParams);
    }

    public View getCenterView() {
        return this.f٩٧٦١m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCompatElevation() {
        f8.i iVar = this.f٩٧٦٦r;
        if (iVar != null) {
            return iVar.C();
        }
        return getElevation();
    }

    public float getCornerSize() {
        return this.f٩٧٦٦r.O();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        return this.f٩٧٤٩a.getHint();
    }

    public int getMaxWidth() {
        return this.f٩٧٦٨t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.f٩٧٦٤p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getPlaceholderTextView() {
        return this.f٩٧٥٠b;
    }

    public int getStrokeColor() {
        return this.f٩٧٦٦r.K().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f٩٧٦٦r.M();
    }

    public CharSequence getText() {
        return this.f٩٧٤٩a.getText();
    }

    public boolean getTextCentered() {
        return this.f٩٧٦٧s;
    }

    public TextView getTextView() {
        return this.f٩٧٤٩a;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        super.inflateMenu(i10);
        this.f٩٧٦٤p = i10;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.f(this, this.f٩٧٦٦r);
        M();
        O();
        if (this.f٩٧٥٣e) {
            z();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        L();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f٩٧٦١m;
        if (view != null) {
            I(view);
        }
        N();
        if (this.f٩٧٤٩a != null && this.f٩٧٦٧s) {
            H();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = this.f٩٧٦٨t;
        if (i12 >= 0 && i12 < View.MeasureSpec.getSize(i10)) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.f٩٧٦٨t, View.MeasureSpec.getMode(i10));
        }
        super.onMeasure(i10, i11);
        K(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f٩٧٧٢a);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f٩٧٧٢a = charSequence;
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.f٩٧٦١m;
        if (view2 != null) {
            removeView(view2);
            this.f٩٧٦١m = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f٩٧٦٥q = z10;
        O();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        f8.i iVar = this.f٩٧٦٦r;
        if (iVar != null) {
            iVar.g0(f10);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f٩٧٤٩a.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z10) {
        this.f٩٧٥٣e = z10;
        if (z10) {
            z();
        } else {
            L();
        }
    }

    public void setMaxWidth(int i10) {
        if (this.f٩٧٦٨t != i10) {
            this.f٩٧٦٨t = i10;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(J(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z10;
        if (this.f٩٧٦٠l) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        if (onClickListener == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        setNavigationIconDecorative(z10);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        this.f٩٧٥٧i.a(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaceholderText(String str) {
        this.f٩٧٥٠b.setText(str);
    }

    public void setStrokeColor(int i10) {
        if (getStrokeColor() != i10) {
            this.f٩٧٦٦r.t0(ColorStateList.valueOf(i10));
        }
    }

    public void setStrokeWidth(@Dimension float f10) {
        if (getStrokeWidth() != f10) {
            this.f٩٧٦٦r.u0(f10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f٩٧٤٩a.setText(charSequence);
        this.f٩٧٥٠b.setText(charSequence);
    }

    public void setTextCentered(boolean z10) {
        this.f٩٧٦٧s = z10;
        TextView textView = this.f٩٧٤٩a;
        if (textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        if (z10) {
            layoutParams.gravity = 1;
            this.f٩٧٤٩a.setGravity(1);
        } else {
            layoutParams.gravity = 0;
            this.f٩٧٤٩a.setGravity(0);
        }
        this.f٩٧٤٩a.setLayoutParams(layoutParams);
        this.f٩٧٥٠b.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: h, reason: collision with root package name */
        private boolean f٩٧٧٣h;

        public ScrollingViewBehavior() {
            this.f٩٧٧٣h = false;
        }

        private void a0(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(DownloadProgress.UNKNOWN_PROGRESS);
        }

        @Override // com.google.android.material.appbar.j
        protected boolean V() {
            return true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean n10 = super.n(coordinatorLayout, view, view2);
            if (!this.f٩٧٧٣h && (view2 instanceof AppBarLayout)) {
                this.f٩٧٧٣h = true;
                a0((AppBarLayout) view2);
            }
            return n10;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٩٧٧٣h = false;
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    public void setHint(int i10) {
        this.f٩٧٤٩a.setHint(i10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchBar(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f٩٧٤٨x;
        this.f٩٧٦٤p = -1;
        this.f٩٧٧١w = new a();
        Context context2 = getContext();
        Q(attributeSet);
        this.f٩٧٥٨j = r1.a.b(context2, getDefaultNavigationIconResource());
        this.f٩٧٥٧i = new b();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.SearchBar, i10, i11, new int[0]);
        f8.o m10 = f8.o.e(context2, attributeSet, i10, i11).m();
        int color = i12.getColor(R.styleable.SearchBar_backgroundTint, 0);
        this.f٩٧٥٢d = color;
        this.f٩٧٥٤f = c8.c.a(context2, i12, R.styleable.SearchBar_liftOnScrollColor);
        float dimension = i12.getDimension(R.styleable.SearchBar_elevation, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٩٧٥٦h = i12.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.f٩٧٦٥q = i12.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean z10 = i12.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.f٩٧٦٠l = i12.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.f٩٧٥٩k = i12.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        int i13 = R.styleable.SearchBar_navigationIconTint;
        if (i12.hasValue(i13)) {
            this.f٩٧٦٢n = Integer.valueOf(i12.getColor(i13, -1));
        }
        int resourceId = i12.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String string = i12.getString(R.styleable.SearchBar_android_text);
        String string2 = i12.getString(R.styleable.SearchBar_android_hint);
        float dimension2 = i12.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int color2 = i12.getColor(R.styleable.SearchBar_strokeColor, 0);
        this.f٩٧٦٧s = i12.getBoolean(R.styleable.SearchBar_textCentered, false);
        this.f٩٧٥٣e = i12.getBoolean(R.styleable.SearchBar_liftOnScroll, false);
        this.f٩٧٦٨t = i12.getDimensionPixelSize(R.styleable.SearchBar_android_maxWidth, -1);
        i12.recycle();
        if (!z10) {
            E();
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_bar, this);
        this.f٩٧٥٥g = true;
        this.f٩٧٤٩a = (TextView) findViewById(R.id.open_search_bar_text_view);
        this.f٩٧٥٠b = (TextView) findViewById(R.id.open_search_bar_placeholder_text_view);
        this.f٩٧٥١c = (FrameLayout) findViewById(R.id.open_search_bar_text_view_container);
        setElevation(dimension);
        F(resourceId, string, string2);
        D(m10, color, dimension, dimension2, color2);
    }

    public void setText(int i10) {
        this.f٩٧٤٩a.setText(i10);
        this.f٩٧٥٠b.setText(i10);
    }
}
