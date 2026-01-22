package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e extends b implements g.a {

    /* renamed from: c, reason: collision with root package name */
    private Context f٨٢٨c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContextView f٨٢٩d;

    /* renamed from: e, reason: collision with root package name */
    private b.a f٨٣٠e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f٨٣١f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٨٣٢g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٣٣h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.g f٨٣٤i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f٨٢٨c = context;
        this.f٨٢٩d = actionBarContextView;
        this.f٨٣٠e = aVar;
        androidx.appcompat.view.menu.g X = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).X(1);
        this.f٨٣٤i = X;
        X.W(this);
        this.f٨٣٣h = z10;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f٨٣٠e.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.f٨٢٩d.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f٨٣٢g) {
            return;
        }
        this.f٨٣٢g = true;
        this.f٨٣٠e.a(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference weakReference = this.f٨٣١f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f٨٣٤i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f٨٢٩d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f٨٢٩d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f٨٢٩d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.f٨٣٠e.d(this, this.f٨٣٤i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f٨٢٩d.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        WeakReference weakReference;
        this.f٨٢٩d.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.f٨٣١f = weakReference;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i10) {
        o(this.f٨٢٨c.getString(i10));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f٨٢٩d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i10) {
        r(this.f٨٢٨c.getString(i10));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f٨٢٩d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z10) {
        super.s(z10);
        this.f٨٢٩d.setTitleOptional(z10);
    }
}
