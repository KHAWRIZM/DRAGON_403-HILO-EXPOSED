package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.p0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import f8.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final f f٩٥٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private final NavigationBarMenuView f٩٥٠١b;

    /* renamed from: c, reason: collision with root package name */
    private final NavigationBarPresenter f٩٥٠٢c;

    /* renamed from: d, reason: collision with root package name */
    private MenuInflater f٩٥٠٣d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        Bundle f٩٥٠٤a;

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

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f٩٥٠٤a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f٩٥٠٤a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            NavigationBarView.a(NavigationBarView.this);
            NavigationBarView.b(NavigationBarView.this);
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavigationBarView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(g8.a.d(context, attributeSet, i10, i11), attributeSet, i10);
        int i12;
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f٩٥٠٢c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.NavigationBarView;
        int i13 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i14 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        p0 j10 = h0.j(context2, attributeSet, iArr, i10, i11, i13, i14);
        f fVar = new f(context2, getClass(), getMaxItemCount(), e());
        this.f٩٥٠٠a = fVar;
        NavigationBarMenuView c10 = c(context2);
        this.f٩٥٠١b = c10;
        c10.setMinimumHeight(getSuggestedMinimumHeight());
        c10.setCollapsedMaxItemCount(getCollapsedMaxItemCount());
        navigationBarPresenter.l(c10);
        navigationBarPresenter.f(1);
        c10.setPresenter(navigationBarPresenter);
        fVar.b(navigationBarPresenter);
        navigationBarPresenter.k(getContext(), fVar);
        int i15 = R.styleable.NavigationBarView_itemIconTint;
        if (j10.s(i15)) {
            c10.setIconTintList(j10.c(i15));
        } else {
            c10.setIconTintList(c10.e(android.R.attr.textColorSecondary));
        }
        setItemIconSize(j10.f(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (j10.s(i13)) {
            setItemTextAppearanceInactive(j10.n(i13, 0));
        }
        if (j10.s(i14)) {
            setItemTextAppearanceActive(j10.n(i14, 0));
        }
        int i16 = R.styleable.NavigationBarView_horizontalItemTextAppearanceInactive;
        if (j10.s(i16)) {
            setHorizontalItemTextAppearanceInactive(j10.n(i16, 0));
        }
        int i17 = R.styleable.NavigationBarView_horizontalItemTextAppearanceActive;
        if (j10.s(i17)) {
            setHorizontalItemTextAppearanceActive(j10.n(i17, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(j10.a(R.styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        int i18 = R.styleable.NavigationBarView_itemTextColor;
        if (j10.s(i18)) {
            setItemTextColor(j10.c(i18));
        }
        Drawable background = getBackground();
        ColorStateList g10 = com.google.android.material.drawable.g.g(background);
        if (background == null || g10 != null) {
            f8.i iVar = new f8.i(o.e(context2, attributeSet, i10, i11).m());
            if (g10 != null) {
                iVar.h0(g10);
            }
            iVar.V(context2);
            setBackground(iVar);
        }
        int i19 = R.styleable.NavigationBarView_itemPaddingTop;
        if (j10.s(i19)) {
            setItemPaddingTop(j10.f(i19, 0));
        }
        int i20 = R.styleable.NavigationBarView_itemPaddingBottom;
        if (j10.s(i20)) {
            setItemPaddingBottom(j10.f(i20, 0));
        }
        int i21 = R.styleable.NavigationBarView_activeIndicatorLabelPadding;
        if (j10.s(i21)) {
            setActiveIndicatorLabelPadding(j10.f(i21, 0));
        }
        int i22 = R.styleable.NavigationBarView_iconLabelHorizontalSpacing;
        if (j10.s(i22)) {
            setIconLabelHorizontalSpacing(j10.f(i22, 0));
        }
        if (j10.s(R.styleable.NavigationBarView_elevation)) {
            setElevation(j10.f(r11, 0));
        }
        getBackground().mutate().setTintList(c8.c.b(context2, j10, R.styleable.NavigationBarView_backgroundTint));
        int i23 = -1;
        setLabelVisibilityMode(j10.l(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        setItemIconGravity(j10.l(R.styleable.NavigationBarView_itemIconGravity, 0));
        setItemGravity(j10.l(R.styleable.NavigationBarView_itemGravity, 49));
        int n10 = j10.n(R.styleable.NavigationBarView_itemBackground, 0);
        if (n10 != 0) {
            c10.setItemBackgroundRes(n10);
        } else {
            setItemRippleColor(c8.c.b(context2, j10, R.styleable.NavigationBarView_itemRippleColor));
        }
        setMeasureBottomPaddingFromLabelBaseline(j10.a(R.styleable.NavigationBarView_measureBottomPaddingFromLabelBaseline, true));
        setLabelFontScalingEnabled(j10.a(R.styleable.NavigationBarView_labelFontScalingEnabled, false));
        setLabelMaxLines(j10.l(R.styleable.NavigationBarView_labelMaxLines, 1));
        int n11 = j10.n(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (n11 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(n11, R.styleable.NavigationBarActiveIndicator);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0);
            setItemActiveIndicatorWidth(dimensionPixelSize);
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0);
            setItemActiveIndicatorMarginHorizontal(dimensionPixelOffset);
            int i24 = R.styleable.NavigationBarActiveIndicator_expandedWidth;
            String string = obtainStyledAttributes.getString(i24);
            if (string != null) {
                if (!String.valueOf(-1).equals(string)) {
                    if (!String.valueOf(-2).equals(string)) {
                        i23 = obtainStyledAttributes.getDimensionPixelSize(i24, -2);
                    }
                }
                setItemActiveIndicatorExpandedWidth(i23);
                setItemActiveIndicatorExpandedHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_expandedHeight, dimensionPixelSize));
                setItemActiveIndicatorExpandedMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedMarginHorizontal, dimensionPixelOffset));
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.m3_navigation_item_leading_trailing_space);
                int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingStart, dimensionPixelSize2);
                int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingEnd, dimensionPixelSize2);
                if (getLayoutDirection() != 1) {
                    i12 = dimensionPixelOffset3;
                } else {
                    i12 = dimensionPixelOffset2;
                }
                f(i12, obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingTop, 0), getLayoutDirection() != 1 ? dimensionPixelOffset3 : dimensionPixelOffset2, obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingBottom, 0));
                setItemActiveIndicatorColor(c8.c.a(context2, obtainStyledAttributes, R.styleable.NavigationBarActiveIndicator_android_color));
                setItemActiveIndicatorShapeAppearance(o.b(context2, obtainStyledAttributes.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
                obtainStyledAttributes.recycle();
            }
            i23 = -2;
            setItemActiveIndicatorExpandedWidth(i23);
            setItemActiveIndicatorExpandedHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_expandedHeight, dimensionPixelSize));
            setItemActiveIndicatorExpandedMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedMarginHorizontal, dimensionPixelOffset));
            int dimensionPixelSize22 = getResources().getDimensionPixelSize(R.dimen.m3_navigation_item_leading_trailing_space);
            int dimensionPixelOffset22 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingStart, dimensionPixelSize22);
            int dimensionPixelOffset32 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingEnd, dimensionPixelSize22);
            if (getLayoutDirection() != 1) {
            }
            f(i12, obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingTop, 0), getLayoutDirection() != 1 ? dimensionPixelOffset32 : dimensionPixelOffset22, obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_expandedActiveIndicatorPaddingBottom, 0));
            setItemActiveIndicatorColor(c8.c.a(context2, obtainStyledAttributes, R.styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(o.b(context2, obtainStyledAttributes.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        int i25 = R.styleable.NavigationBarView_menu;
        if (j10.s(i25)) {
            d(j10.n(i25, 0));
        }
        j10.x();
        if (!g()) {
            addView(c10);
        }
        fVar.W(new a());
    }

    static /* synthetic */ b a(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    static /* synthetic */ c b(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.f٩٥٠٣d == null) {
            this.f٩٥٠٣d = new androidx.appcompat.view.g(getContext());
        }
        return this.f٩٥٠٣d;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z10) {
        this.f٩٥٠١b.setMeasurePaddingFromLabelBaseline(z10);
    }

    protected abstract NavigationBarMenuView c(Context context);

    public void d(int i10) {
        this.f٩٥٠٢c.m(true);
        getMenuInflater().inflate(i10, this.f٩٥٠٠a);
        this.f٩٥٠٢c.m(false);
        this.f٩٥٠٢c.h(true);
    }

    protected boolean e() {
        return false;
    }

    public void f(int i10, int i11, int i12, int i13) {
        this.f٩٥٠١b.o(i10, i11, i12, i13);
    }

    public boolean g() {
        return false;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f٩٥٠١b.getActiveIndicatorLabelPadding();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.f٩٥٠١b.getHorizontalItemTextAppearanceActive();
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.f٩٥٠١b.getHorizontalItemTextAppearanceInactive();
    }

    public int getIconLabelHorizontalSpacing() {
        return this.f٩٥٠١b.getIconLabelHorizontalSpacing();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f٩٥٠١b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.f٩٥٠١b.getItemActiveIndicatorExpandedHeight();
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.f٩٥٠١b.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.f٩٥٠١b.getItemActiveIndicatorExpandedWidth();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f٩٥٠١b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f٩٥٠١b.getItemActiveIndicatorMarginHorizontal();
    }

    public o getItemActiveIndicatorShapeAppearance() {
        return this.f٩٥٠١b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f٩٥٠١b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f٩٥٠١b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f٩٥٠١b.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.f٩٥٠١b.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.f٩٥٠١b.getItemIconGravity();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f٩٥٠١b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f٩٥٠١b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f٩٥٠١b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f٩٥٠١b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f٩٥٠١b.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f٩٥٠١b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f٩٥٠١b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f٩٥٠١b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f٩٥٠١b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f٩٥٠٠a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public m getMenuView() {
        return this.f٩٥٠١b;
    }

    public ViewGroup getMenuViewGroup() {
        return this.f٩٥٠١b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.f٩٥٠٢c;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.f٩٥٠١b.getScaleLabelTextWithFont();
    }

    public int getSelectedItemId() {
        return this.f٩٥٠١b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f٩٥٠٠a.T(savedState.f٩٥٠٤a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f٩٥٠٤a = bundle;
        this.f٩٥٠٠a.V(bundle);
        return savedState;
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        this.f٩٥٠١b.setActiveIndicatorLabelPadding(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        f8.j.d(this, f10);
    }

    public void setHorizontalItemTextAppearanceActive(int i10) {
        this.f٩٥٠١b.setHorizontalItemTextAppearanceActive(i10);
    }

    public void setHorizontalItemTextAppearanceInactive(int i10) {
        this.f٩٥٠١b.setHorizontalItemTextAppearanceInactive(i10);
    }

    public void setIconLabelHorizontalSpacing(int i10) {
        this.f٩٥٠١b.setIconLabelHorizontalSpacing(i10);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f٩٥٠١b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f٩٥٠١b.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorExpandedHeight(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorExpandedHeight(i10);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorExpandedMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorExpandedWidth(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorExpandedWidth(i10);
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(o oVar) {
        this.f٩٥٠١b.setItemActiveIndicatorShapeAppearance(oVar);
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f٩٥٠١b.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f٩٥٠١b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        this.f٩٥٠١b.setItemBackgroundRes(i10);
    }

    public void setItemGravity(int i10) {
        if (this.f٩٥٠١b.getItemGravity() != i10) {
            this.f٩٥٠١b.setItemGravity(i10);
            this.f٩٥٠٢c.h(false);
        }
    }

    public void setItemIconGravity(int i10) {
        if (this.f٩٥٠١b.getItemIconGravity() != i10) {
            this.f٩٥٠١b.setItemIconGravity(i10);
            this.f٩٥٠٢c.h(false);
        }
    }

    public void setItemIconSize(@Dimension int i10) {
        this.f٩٥٠١b.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f٩٥٠١b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i10) {
        this.f٩٥٠١b.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(int i10) {
        this.f٩٥٠١b.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f٩٥٠١b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f٩٥٠١b.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f٩٥٠١b.setItemTextAppearanceActiveBoldEnabled(z10);
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f٩٥٠١b.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f٩٥٠١b.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z10) {
        this.f٩٥٠١b.setLabelFontScalingEnabled(z10);
    }

    public void setLabelMaxLines(int i10) {
        this.f٩٥٠١b.setLabelMaxLines(i10);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f٩٥٠١b.getLabelVisibilityMode() != i10) {
            this.f٩٥٠١b.setLabelVisibilityMode(i10);
            this.f٩٥٠٢c.h(false);
        }
    }

    public void setOnItemReselectedListener(b bVar) {
    }

    public void setOnItemSelectedListener(c cVar) {
    }

    public void setSelectedItemId(int i10) {
        MenuItem findItem = this.f٩٥٠٠a.findItem(i10);
        if (findItem != null) {
            boolean P = this.f٩٥٠٠a.P(findItem, this.f٩٥٠٢c, 0);
            if (findItem.isCheckable()) {
                if (!P || findItem.isChecked()) {
                    this.f٩٥٠١b.setCheckedItem(findItem);
                }
            }
        }
    }
}
