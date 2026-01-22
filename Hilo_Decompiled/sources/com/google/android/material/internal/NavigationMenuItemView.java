package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.u0;
import androidx.core.view.d1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements m.a {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f٩١٩٠r = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    private int f٩١٩١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٩١٩٢h;

    /* renamed from: i, reason: collision with root package name */
    boolean f٩١٩٣i;

    /* renamed from: j, reason: collision with root package name */
    boolean f٩١٩٤j;

    /* renamed from: k, reason: collision with root package name */
    private final CheckedTextView f٩١٩٥k;

    /* renamed from: l, reason: collision with root package name */
    private FrameLayout f٩١٩٦l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.appcompat.view.menu.i f٩١٩٧m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f٩١٩٨n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩١٩٩o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f٩٢٠٠p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.core.view.a f٩٢٠١q;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, m2.g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.m0(NavigationMenuItemView.this.f٩١٩٣i);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void j() {
        if (n()) {
            this.f٩١٩٥k.setVisibility(8);
            FrameLayout frameLayout = this.f٩١٩٦l;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f٩١٩٦l.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f٩١٩٥k.setVisibility(0);
        FrameLayout frameLayout2 = this.f٩١٩٦l;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f٩١٩٦l.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable k() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f٩١٩٠r, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean n() {
        if (this.f٩١٩٧m.getTitle() == null && this.f٩١٩٧m.getIcon() == null && this.f٩١٩٧m.getActionView() != null) {
            return true;
        }
        return false;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f٩١٩٦l == null) {
                this.f٩١٩٦l = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.f٩١٩٦l.removeAllViews();
            this.f٩١٩٦l.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(androidx.appcompat.view.menu.i iVar, int i10) {
        int i11;
        this.f٩١٩٧m = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        if (getBackground() == null) {
            setBackground(k());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        u0.a(this, iVar.getTooltipText());
        j();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.f٩١٩٧m;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return false;
    }

    public void l(androidx.appcompat.view.menu.i iVar, boolean z10) {
        this.f٩١٩٤j = z10;
        g(iVar, 0);
    }

    public void m() {
        FrameLayout frameLayout = this.f٩١٩٦l;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f٩١٩٥k.setCompoundDrawables(null, null, null, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        androidx.appcompat.view.menu.i iVar = this.f٩١٩٧m;
        if (iVar != null && iVar.isCheckable() && this.f٩١٩٧m.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f٩١٩٠r);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.f٩١٩٣i != z10) {
            this.f٩١٩٣i = z10;
            this.f٩٢٠١q.sendAccessibilityEvent(this.f٩١٩٥k, 2048);
        }
    }

    public void setChecked(boolean z10) {
        int i10;
        refreshDrawableState();
        this.f٩١٩٥k.setChecked(z10);
        CheckedTextView checkedTextView = this.f٩١٩٥k;
        Typeface typeface = checkedTextView.getTypeface();
        if (z10 && this.f٩١٩٤j) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        checkedTextView.setTypeface(typeface, i10);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f٩١٩٩o) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = h2.b.r(drawable).mutate();
                drawable.setTintList(this.f٩١٩٨n);
            }
            int i10 = this.f٩١٩١g;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.f٩١٩٢h) {
            if (this.f٩٢٠٠p == null) {
                Drawable f10 = androidx.core.content.res.h.f(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.f٩٢٠٠p = f10;
                if (f10 != null) {
                    int i11 = this.f٩١٩١g;
                    f10.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f٩٢٠٠p;
        }
        this.f٩١٩٥k.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f٩١٩٥k.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(@Dimension int i10) {
        this.f٩١٩١g = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        boolean z10;
        this.f٩١٩٨n = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٩١٩٩o = z10;
        androidx.appcompat.view.menu.i iVar = this.f٩١٩٧m;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f٩١٩٥k.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.f٩١٩٢h = z10;
    }

    public void setTextAppearance(int i10) {
        androidx.core.widget.l.m(this.f٩١٩٥k, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f٩١٩٥k.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f٩١٩٥k.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٩١٩٤j = true;
        a aVar = new a();
        this.f٩٢٠١q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.f٩١٩٥k = checkedTextView;
        d1.q0(checkedTextView, aVar);
    }
}
