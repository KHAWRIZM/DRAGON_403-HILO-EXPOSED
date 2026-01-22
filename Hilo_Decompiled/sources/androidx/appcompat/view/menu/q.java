package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q extends g implements SubMenu {

    /* renamed from: B, reason: collision with root package name */
    private g f١١١٢B;
    private i C;

    public q(Context context, g gVar, i iVar) {
        super(context);
        this.f١١١٢B = gVar;
        this.C = iVar;
    }

    @Override // androidx.appcompat.view.menu.g
    public g F() {
        return this.f١١١٢B.F();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean I() {
        return this.f١١١٢B.I();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean J() {
        return this.f١١١٢B.J();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean K() {
        return this.f١١١٢B.K();
    }

    @Override // androidx.appcompat.view.menu.g
    public void W(g.a aVar) {
        this.f١١١٢B.W(aVar);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(i iVar) {
        return this.f١١١٢B.f(iVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.view.menu.g
    public boolean h(g gVar, MenuItem menuItem) {
        if (!super.h(gVar, menuItem) && !this.f١١١٢B.h(gVar, menuItem)) {
            return false;
        }
        return true;
    }

    public Menu j0() {
        return this.f١١١٢B;
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean m(i iVar) {
        return this.f١١١٢B.m(iVar);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f١١١٢B.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.a0(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.d0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.e0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f١١١٢B.setQwertyMode(z10);
    }

    @Override // androidx.appcompat.view.menu.g
    public String v() {
        int i10;
        i iVar = this.C;
        if (iVar != null) {
            i10 = iVar.getItemId();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return null;
        }
        return super.v() + CertificateUtil.DELIMITER + i10;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.Z(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.c0(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.C.setIcon(i10);
        return this;
    }
}
