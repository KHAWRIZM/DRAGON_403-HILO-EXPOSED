package h1;

import android.os.SystemClock;
import m1.d;
import n0.e;
import n0.f;
import r0.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements n0.b {

    /* renamed from: a, reason: collision with root package name */
    public final d f١٤٤٨٨a;

    public a(d dVar) {
        this.f١٤٤٨٨a = dVar;
        dVar.f١٥٩١٢a = this;
    }

    public final void a(e eVar, int i10, long j10) {
        d dVar = this.f١٤٤٨٨a;
        m1.a aVar = dVar.f١٥٩١٤c;
        if (eVar.f١٦١١٧f == null) {
            r0.c cVar = f.a().f١٦١٣٩c;
            eVar.f١٦١١٧f = (g) cVar.f١٧٢٧٦b.f١٧٣٠٢a.get(eVar.f١٦١١٣b);
        }
        m1.b bVar = (m1.b) aVar.a(eVar);
        if (bVar != null) {
            m1.f fVar = dVar.f١٥٩١٣b;
            if (fVar != null) {
                m1.e eVar2 = (m1.e) bVar;
                synchronized (((n0.a) eVar2.f١٥٩١٦f.get(i10))) {
                    SystemClock.uptimeMillis();
                }
                if (fVar.f١٥٩١٧a != null) {
                    return;
                }
                return;
            }
            if (dVar.f١٥٩١٢a != null) {
            }
        }
    }

    public final void f(e eVar, g gVar) {
        b bVar;
        d dVar = this.f١٤٤٨٨a;
        m1.a aVar = dVar.f١٥٩١٤c;
        c cVar = aVar.f١٥٩٠٧c;
        int i10 = eVar.f١٦١١٣b;
        cVar.getClass();
        m1.e eVar2 = new m1.e(i10);
        synchronized (aVar) {
            try {
                if (aVar.f١٥٩٠٥a == null) {
                    aVar.f١٥٩٠٥a = eVar2;
                } else {
                    aVar.f١٥٩٠٦b.put(eVar.f١٦١١٣b, eVar2);
                }
                if (gVar != null) {
                    eVar2.a(gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        m1.f fVar = dVar.f١٥٩١٣b;
        if (fVar != null && (bVar = fVar.f١٥٩١٧a) != null) {
            bVar.c(gVar);
        }
    }

    public final void g(e eVar, g gVar, int i10) {
        b bVar;
        d dVar = this.f١٤٤٨٨a;
        m1.a aVar = dVar.f١٥٩١٤c;
        c cVar = aVar.f١٥٩٠٧c;
        int i11 = eVar.f١٦١١٣b;
        cVar.getClass();
        m1.e eVar2 = new m1.e(i11);
        synchronized (aVar) {
            try {
                if (aVar.f١٥٩٠٥a == null) {
                    aVar.f١٥٩٠٥a = eVar2;
                } else {
                    aVar.f١٥٩٠٦b.put(eVar.f١٦١١٣b, eVar2);
                }
                if (gVar != null) {
                    eVar2.a(gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        m1.f fVar = dVar.f١٥٩١٣b;
        if (fVar != null && (bVar = fVar.f١٥٩١٧a) != null) {
            bVar.c(gVar);
        }
    }

    public final void h(e eVar, int i10, long j10) {
        d dVar = this.f١٤٤٨٨a;
        m1.a aVar = dVar.f١٥٩١٤c;
        if (eVar.f١٦١١٧f == null) {
            eVar.f١٦١١٧f = (g) f.a().f١٦١٣٩c.f١٧٢٧٦b.f١٧٣٠٢a.get(eVar.f١٦١١٣b);
        }
        m1.b bVar = (m1.b) aVar.a(eVar);
        if (bVar != null) {
            bVar.f١٥٩١١d.put(i10, Long.valueOf(((Long) bVar.f١٥٩١١d.get(i10)).longValue() + j10));
            bVar.f١٥٩١٠c += j10;
            m1.f fVar = dVar.f١٥٩١٣b;
            if (fVar != null) {
                m1.e eVar2 = (m1.e) bVar;
                n0.a aVar2 = (n0.a) eVar2.f١٥٩١٦f.get(i10);
                synchronized (aVar2) {
                    if (aVar2.f١٦٠٩٢a == 0) {
                        aVar2.f١٦٠٩٢a = SystemClock.uptimeMillis();
                    }
                }
                eVar2.f١٥٩١٥e.a(j10);
                if (fVar.f١٥٩١٧a != null) {
                    ((Long) bVar.f١٥٩١١d.get(i10)).getClass();
                    fVar.f١٥٩١٧a.d(bVar.f١٥٩١٠c);
                }
            }
        }
    }

    public final void i(e eVar, int i10, Exception exc) {
        d dVar = this.f١٤٤٨٨a;
        synchronized (dVar) {
            try {
                m1.a aVar = dVar.f١٥٩١٤c;
                if (eVar.f١٦١١٧f == null) {
                    r0.c cVar = f.a().f١٦١٣٩c;
                    eVar.f١٦١١٧f = (g) cVar.f١٧٢٧٦b.f١٧٣٠٢a.get(eVar.f١٦١١٣b);
                }
                m1.b bVar = (m1.b) aVar.b(eVar, eVar.f١٦١١٧f);
                m1.f fVar = dVar.f١٥٩١٣b;
                if (fVar != null) {
                    fVar.a(eVar, i10, exc, bVar);
                } else if (dVar.f١٥٩١٢a != null) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
