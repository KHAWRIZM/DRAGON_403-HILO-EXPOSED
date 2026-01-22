package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f extends androidx.appcompat.view.menu.g {

    /* renamed from: B, reason: collision with root package name */
    private final Class f٩٥٣٤B;
    private final int C;
    private final boolean D;

    public f(Context context, Class cls, int i10, boolean z10) {
        super(context);
        this.f٩٥٣٤B = cls;
        this.C = i10;
        this.D = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.g
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        if (size() + 1 <= this.C) {
            i0();
            MenuItem a10 = super.a(i10, i11, i12, charSequence);
            h0();
            return a10;
        }
        String simpleName = this.f٩٥٣٤B.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.C + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        if (this.D) {
            androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) a(i10, i11, i12, charSequence);
            i iVar2 = new i(w(), this, iVar);
            iVar.x(iVar2);
            return iVar2;
        }
        throw new UnsupportedOperationException(this.f٩٥٣٤B.getSimpleName() + " does not support submenus");
    }
}
