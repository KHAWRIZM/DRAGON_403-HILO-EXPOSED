package com.google.android.material.navigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationBarDividerView extends FrameLayout implements h {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٩٤١٥a;

    /* renamed from: b, reason: collision with root package name */
    boolean f٩٤١٦b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩٤١٧c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavigationBarDividerView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.m3_navigation_menu_divider, (ViewGroup) this, true);
        a();
    }

    public void a() {
        int i10;
        if (this.f٩٤١٧c && (this.f٩٤١٥a || !this.f٩٤١٦b)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(androidx.appcompat.view.menu.i iVar, int i10) {
        a();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public androidx.appcompat.view.menu.i getItemData() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setDividersEnabled(boolean z10) {
        this.f٩٤١٧c = z10;
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
    }

    @Override // com.google.android.material.navigation.h
    public void setExpanded(boolean z10) {
        this.f٩٤١٥a = z10;
        a();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // com.google.android.material.navigation.h
    public void setOnlyShowWhenExpanded(boolean z10) {
        this.f٩٤١٦b = z10;
        a();
    }

    public void setTitle(CharSequence charSequence) {
    }
}
