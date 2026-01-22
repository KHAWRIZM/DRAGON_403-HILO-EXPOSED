package com.google.android.material.navigation;

import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.appcompat.view.menu.g f٩٥٣٥a;

    /* renamed from: c, reason: collision with root package name */
    private int f٩٥٣٧c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f٩٥٣٨d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٥٣٩e = 0;

    /* renamed from: b, reason: collision with root package name */
    private final List f٩٥٣٦b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(androidx.appcompat.view.menu.g gVar) {
        this.f٩٥٣٥a = gVar;
        f();
    }

    public int a() {
        return this.f٩٥٣٧c;
    }

    public MenuItem b(int i10) {
        return (MenuItem) this.f٩٥٣٦b.get(i10);
    }

    public int c() {
        return this.f٩٥٣٨d;
    }

    public int d() {
        return this.f٩٥٣٩e;
    }

    public boolean e(MenuItem menuItem, l lVar, int i10) {
        return this.f٩٥٣٥a.P(menuItem, lVar, i10);
    }

    public void f() {
        this.f٩٥٣٦b.clear();
        this.f٩٥٣٧c = 0;
        this.f٩٥٣٨d = 0;
        this.f٩٥٣٩e = 0;
        for (int i10 = 0; i10 < this.f٩٥٣٥a.size(); i10++) {
            MenuItem item = this.f٩٥٣٥a.getItem(i10);
            if (item.hasSubMenu()) {
                if (!this.f٩٥٣٦b.isEmpty()) {
                    if (!(this.f٩٥٣٦b.get(r3.size() - 1) instanceof a) && item.isVisible()) {
                        this.f٩٥٣٦b.add(new a());
                    }
                }
                this.f٩٥٣٦b.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i11 = 0; i11 < subMenu.size(); i11++) {
                    MenuItem item2 = subMenu.getItem(i11);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    this.f٩٥٣٦b.add(item2);
                    this.f٩٥٣٧c++;
                    if (item2.isVisible()) {
                        this.f٩٥٣٨d++;
                    }
                }
                this.f٩٥٣٦b.add(new a());
            } else {
                this.f٩٥٣٦b.add(item);
                this.f٩٥٣٧c++;
                if (item.isVisible()) {
                    this.f٩٥٣٨d++;
                    this.f٩٥٣٩e++;
                }
            }
        }
        if (!this.f٩٥٣٦b.isEmpty()) {
            if (this.f٩٥٣٦b.get(r0.size() - 1) instanceof a) {
                this.f٩٥٣٦b.remove(r0.size() - 1);
            }
        }
    }

    public int g() {
        return this.f٩٥٣٦b.size();
    }
}
