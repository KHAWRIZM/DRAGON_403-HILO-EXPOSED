package s6;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private b f١٧٨٨٩a;

    /* renamed from: b, reason: collision with root package name */
    private g f١٧٨٩٠b;

    public static c c() {
        c cVar = new c();
        cVar.d(b.j());
        cVar.e(g.d());
        return cVar;
    }

    public static c f(int i10) {
        c c10 = c();
        c10.d(b.k(i10));
        return c10;
    }

    public b a() {
        return this.f١٧٨٨٩a;
    }

    public g b() {
        return this.f١٧٨٩٠b;
    }

    public void d(b bVar) {
        this.f١٧٨٨٩a = bVar;
    }

    public void e(g gVar) {
        this.f١٧٨٩٠b = gVar;
    }

    public String toString() {
        return this.f١٧٨٨٩a.toString() + " " + this.f١٧٨٩٠b.toString();
    }
}
