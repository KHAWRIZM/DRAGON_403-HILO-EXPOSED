package tech.sud.runtime.a;

import android.app.Activity;
import android.widget.FrameLayout;
import java.util.HashMap;
import tech.sud.runtime.a.a;
import tech.sud.runtime.component.h.f;
import tech.sud.runtime.core.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class c implements a {
    private tech.sud.runtime.core.b a;
    private final g b;
    private final tech.sud.runtime.component.d.a c;

    public c() {
        g gVar = new g();
        this.b = gVar;
        this.c = new tech.sud.runtime.component.d.a(gVar);
    }

    @Override // tech.sud.runtime.a.a
    public void a(Activity activity, HashMap<String, String> hashMap) {
        this.a = new tech.sud.runtime.core.b(activity, this.b, hashMap, this.c);
    }

    @Override // tech.sud.runtime.a.a
    public void b() {
        this.a.h();
    }

    @Override // tech.sud.runtime.a.a
    public void c() {
        this.a.g();
    }

    @Override // tech.sud.runtime.a.a
    public void d() {
        this.a.f();
    }

    @Override // tech.sud.runtime.a.a
    public String[] e() {
        return this.a.i();
    }

    @Override // tech.sud.runtime.a.a
    public Object a() {
        return this.a.a;
    }

    @Override // tech.sud.runtime.a.a
    public void b(String str, String str2) {
        tech.sud.runtime.core.b bVar = this.a;
        if (bVar != null) {
            bVar.b(str, str2);
        }
    }

    @Override // tech.sud.runtime.a.a
    public void a(FrameLayout frameLayout) {
        this.a.a(frameLayout);
    }

    @Override // tech.sud.runtime.a.a
    public void a(boolean z) {
        this.a.a();
    }

    @Override // tech.sud.runtime.a.a
    public void a(String str, a.InterfaceC٠٠٥٦a r3) {
        this.c.a(str, r3);
    }

    @Override // tech.sud.runtime.a.a
    public void a(String str, String str2) {
        tech.sud.runtime.core.b bVar = this.a;
        if (bVar == null || bVar.b) {
            return;
        }
        this.c.b(str, str2);
    }

    @Override // tech.sud.runtime.a.a
    public void a(b bVar) {
        g.a(bVar);
        f.a(bVar);
    }
}
