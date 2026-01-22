package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class p extends androidx.appcompat.view.menu.g {
    public p(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) a(i10, i11, i12, charSequence);
        r rVar = new r(w(), this, iVar);
        iVar.x(rVar);
        return rVar;
    }
}
