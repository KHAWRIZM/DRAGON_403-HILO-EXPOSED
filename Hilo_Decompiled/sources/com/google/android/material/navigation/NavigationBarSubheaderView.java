package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.widget.l;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationBarSubheaderView extends FrameLayout implements h {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f٩٤٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٩٤٩٦b;

    /* renamed from: c, reason: collision with root package name */
    boolean f٩٤٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.appcompat.view.menu.i f٩٤٩٨d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f٩٤٩٩e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavigationBarSubheaderView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.m3_navigation_menu_subheader, (ViewGroup) this, true);
        this.f٩٤٩٥a = (TextView) findViewById(R.id.navigation_menu_subheader_label);
    }

    private void a() {
        int i10;
        androidx.appcompat.view.menu.i iVar = this.f٩٤٩٨d;
        if (iVar != null) {
            if (iVar.isVisible() && (this.f٩٤٩٦b || !this.f٩٤٩٧c)) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            setVisibility(i10);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(androidx.appcompat.view.menu.i iVar, int i10) {
        this.f٩٤٩٨d = iVar;
        iVar.setCheckable(false);
        this.f٩٤٩٥a.setText(iVar.getTitle());
        a();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.f٩٤٩٨d;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return false;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
    }

    @Override // com.google.android.material.navigation.h
    public void setExpanded(boolean z10) {
        this.f٩٤٩٦b = z10;
        a();
    }

    public void setIcon(Drawable drawable) {
    }

    @Override // com.google.android.material.navigation.h
    public void setOnlyShowWhenExpanded(boolean z10) {
        this.f٩٤٩٧c = z10;
        a();
    }

    public void setTextAppearance(int i10) {
        l.m(this.f٩٤٩٥a, i10);
        ColorStateList colorStateList = this.f٩٤٩٩e;
        if (colorStateList != null) {
            this.f٩٤٩٥a.setTextColor(colorStateList);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f٩٤٩٩e = colorStateList;
        if (colorStateList != null) {
            this.f٩٤٩٥a.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
    }
}
