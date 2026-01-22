package b5;

import f5.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f٥٤١٦a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.collection.a f٥٤١٧b = new androidx.collection.a();

    public List a(Class cls, Class cls2, Class cls3) {
        List list;
        j jVar = (j) this.f٥٤١٦a.getAndSet(null);
        if (jVar == null) {
            jVar = new j(cls, cls2, cls3);
        } else {
            jVar.a(cls, cls2, cls3);
        }
        synchronized (this.f٥٤١٧b) {
            list = (List) this.f٥٤١٧b.get(jVar);
        }
        this.f٥٤١٦a.set(jVar);
        return list;
    }

    public void b(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f٥٤١٧b) {
            this.f٥٤١٧b.put(new j(cls, cls2, cls3), list);
        }
    }
}
