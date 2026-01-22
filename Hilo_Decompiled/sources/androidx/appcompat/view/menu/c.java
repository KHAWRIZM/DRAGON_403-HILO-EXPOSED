package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final Context f٩٥٩a;

    /* renamed from: b, reason: collision with root package name */
    private SimpleArrayMap f٩٦٠b;

    /* renamed from: c, reason: collision with root package name */
    private SimpleArrayMap f٩٦١c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f٩٥٩a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof i2.b) {
            i2.b bVar = (i2.b) menuItem;
            if (this.f٩٦٠b == null) {
                this.f٩٦٠b = new SimpleArrayMap();
            }
            MenuItem menuItem2 = (MenuItem) this.f٩٦٠b.get(bVar);
            if (menuItem2 == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f٩٥٩a, bVar);
                this.f٩٦٠b.put(bVar, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        SimpleArrayMap simpleArrayMap = this.f٩٦٠b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap simpleArrayMap2 = this.f٩٦١c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i10) {
        if (this.f٩٦٠b == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f٩٦٠b.getSize()) {
            if (((i2.b) this.f٩٦٠b.keyAt(i11)).getGroupId() == i10) {
                this.f٩٦٠b.removeAt(i11);
                i11--;
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i10) {
        if (this.f٩٦٠b == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f٩٦٠b.getSize(); i11++) {
            if (((i2.b) this.f٩٦٠b.keyAt(i11)).getItemId() == i10) {
                this.f٩٦٠b.removeAt(i11);
                return;
            }
        }
    }
}
