package t4;

import androidx.core.util.Pools;
import com.bumptech.glide.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final r f١٨٠٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private final a f١٨٠٨٨b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map f١٨٠٨٩a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t4.p$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class C٠٢٣٢a {

            /* renamed from: a, reason: collision with root package name */
            final List f١٨٠٩٠a;

            public C٠٢٣٢a(List list) {
                this.f١٨٠٩٠a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f١٨٠٨٩a.clear();
        }

        public List b(Class cls) {
            C٠٢٣٢a r22 = (C٠٢٣٢a) this.f١٨٠٨٩a.get(cls);
            if (r22 == null) {
                return null;
            }
            return r22.f١٨٠٩٠a;
        }

        public void c(Class cls, List list) {
            if (((C٠٢٣٢a) this.f١٨٠٨٩a.put(cls, new C٠٢٣٢a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(Pools.Pool pool) {
        this(new r(pool));
    }

    private static Class b(Object obj) {
        return obj.getClass();
    }

    private synchronized List e(Class cls) {
        List b10;
        b10 = this.f١٨٠٨٨b.b(cls);
        if (b10 == null) {
            b10 = Collections.unmodifiableList(this.f١٨٠٨٧a.c(cls));
            this.f١٨٠٨٨b.c(cls, b10);
        }
        return b10;
    }

    public synchronized void a(Class cls, Class cls2, o oVar) {
        this.f١٨٠٨٧a.b(cls, cls2, oVar);
        this.f١٨٠٨٨b.a();
    }

    public synchronized List c(Class cls) {
        return this.f١٨٠٨٧a.g(cls);
    }

    public List d(Object obj) {
        List e10 = e(b(obj));
        if (!e10.isEmpty()) {
            int size = e10.size();
            List emptyList = Collections.emptyList();
            boolean z10 = true;
            for (int i10 = 0; i10 < size; i10++) {
                n nVar = (n) e10.get(i10);
                if (nVar.handles(obj)) {
                    if (z10) {
                        emptyList = new ArrayList(size - i10);
                        z10 = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new g.c(obj, e10);
        }
        throw new g.c(obj);
    }

    private p(r rVar) {
        this.f١٨٠٨٨b = new a();
        this.f١٨٠٨٧a = rVar;
    }
}
