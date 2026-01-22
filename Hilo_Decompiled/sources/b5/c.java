package b5;

import f5.j;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import o4.i;
import o4.t;
import y4.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final t f٥٤١٣c = new t(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.a f٥٤١٤a = new androidx.collection.a();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f٥٤١٥b = new AtomicReference();

    private j b(Class cls, Class cls2, Class cls3) {
        j jVar = (j) this.f٥٤١٥b.getAndSet(null);
        if (jVar == null) {
            jVar = new j();
        }
        jVar.a(cls, cls2, cls3);
        return jVar;
    }

    public t a(Class cls, Class cls2, Class cls3) {
        t tVar;
        j b10 = b(cls, cls2, cls3);
        synchronized (this.f٥٤١٤a) {
            tVar = (t) this.f٥٤١٤a.get(b10);
        }
        this.f٥٤١٥b.set(b10);
        return tVar;
    }

    public boolean c(t tVar) {
        return f٥٤١٣c.equals(tVar);
    }

    public void d(Class cls, Class cls2, Class cls3, t tVar) {
        synchronized (this.f٥٤١٤a) {
            androidx.collection.a aVar = this.f٥٤١٤a;
            j jVar = new j(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f٥٤١٣c;
            }
            aVar.put(jVar, tVar);
        }
    }
}
