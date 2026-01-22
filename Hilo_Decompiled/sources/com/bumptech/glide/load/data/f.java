package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a f٧٤٣٧b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map f٧٤٣٨a = new HashMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements e.a {
        a() {
        }

        @Override // com.bumptech.glide.load.data.e.a
        public e build(Object obj) {
            return new b(obj);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private final Object f٧٤٣٩a;

        b(Object obj) {
            this.f٧٤٣٩a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public Object a() {
            return this.f٧٤٣٩a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void cleanup() {
        }
    }

    public synchronized e a(Object obj) {
        e.a aVar;
        try {
            f5.k.d(obj);
            aVar = (e.a) this.f٧٤٣٨a.get(obj.getClass());
            if (aVar == null) {
                Iterator it = this.f٧٤٣٨a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a aVar2 = (e.a) it.next();
                    if (aVar2.getDataClass().isAssignableFrom(obj.getClass())) {
                        aVar = aVar2;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f٧٤٣٧b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return aVar.build(obj);
    }

    public synchronized void b(e.a aVar) {
        this.f٧٤٣٨a.put(aVar.getDataClass(), aVar);
    }
}
