package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٢٨٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private a f٢٨٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC٠٠٢٧b f٢٩٠٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        void f(boolean z10);
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٠٢٧b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
        this.f٢٨٩٨a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.f٢٩٠٠c = null;
        this.f٢٨٩٩b = null;
    }

    public void h(a aVar) {
        this.f٢٨٩٩b = aVar;
    }

    public abstract void i(InterfaceC٠٠٢٧b r12);

    public void j(boolean z10) {
        a aVar = this.f٢٨٩٩b;
        if (aVar != null) {
            aVar.f(z10);
        }
    }
}
