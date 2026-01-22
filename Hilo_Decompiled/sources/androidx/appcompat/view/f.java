package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.n;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f٨٣٥a;

    /* renamed from: b, reason: collision with root package name */
    final b f٨٣٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f٨٣٧a;

        /* renamed from: b, reason: collision with root package name */
        final Context f٨٣٨b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f٨٣٩c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        final SimpleArrayMap f٨٤٠d = new SimpleArrayMap();

        public a(Context context, ActionMode.Callback callback) {
            this.f٨٣٨b = context;
            this.f٨٣٧a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f٨٤٠d.get(menu);
            if (menu2 == null) {
                n nVar = new n(this.f٨٣٨b, (i2.a) menu);
                this.f٨٤٠d.put(menu, nVar);
                return nVar;
            }
            return menu2;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f٨٣٧a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f٨٣٧a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f٨٣٧a.onActionItemClicked(e(bVar), new MenuItemWrapperICS(this.f٨٣٨b, (i2.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f٨٣٧a.onPrepareActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f٨٣٩c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = (f) this.f٨٣٩c.get(i10);
                if (fVar != null && fVar.f٨٣٦b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f٨٣٨b, bVar);
            this.f٨٣٩c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f٨٣٥a = context;
        this.f٨٣٦b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f٨٣٦b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f٨٣٦b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new n(this.f٨٣٥a, (i2.a) this.f٨٣٦b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f٨٣٦b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f٨٣٦b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f٨٣٦b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f٨٣٦b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f٨٣٦b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f٨٣٦b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f٨٣٦b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f٨٣٦b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f٨٣٦b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f٨٣٦b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f٨٣٦b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f٨٣٦b.s(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f٨٣٦b.n(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f٨٣٦b.q(i10);
    }
}
