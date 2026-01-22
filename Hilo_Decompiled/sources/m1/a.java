package m1;

import android.util.SparseArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public volatile g f١٥٩٠٥a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f١٥٩٠٦b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final h1.c f١٥٩٠٧c;

    public a(h1.c cVar) {
        this.f١٥٩٠٧c = cVar;
    }

    public final g a(n0.e eVar) {
        g gVar;
        int i10 = eVar.f١٦١١٣b;
        synchronized (this) {
            try {
                if (this.f١٥٩٠٥a != null && ((b) this.f١٥٩٠٥a).f١٥٩٠٨a == i10) {
                    gVar = this.f١٥٩٠٥a;
                } else {
                    gVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (gVar == null) {
            return (g) this.f١٥٩٠٦b.get(i10);
        }
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g b(n0.e eVar, r0.g gVar) {
        e eVar2;
        int i10 = eVar.f١٦١١٣b;
        synchronized (this) {
            try {
                if (this.f١٥٩٠٥a != null && ((b) this.f١٥٩٠٥a).f١٥٩٠٨a == i10) {
                    g gVar2 = this.f١٥٩٠٥a;
                    this.f١٥٩٠٥a = null;
                    eVar2 = gVar2;
                } else {
                    g gVar3 = (g) this.f١٥٩٠٦b.get(i10);
                    this.f١٥٩٠٦b.remove(i10);
                    eVar2 = gVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (eVar2 == 0) {
            this.f١٥٩٠٧c.getClass();
            eVar2 = new e(i10);
            if (gVar != null) {
                eVar2.a(gVar);
            }
        }
        return eVar2;
    }
}
