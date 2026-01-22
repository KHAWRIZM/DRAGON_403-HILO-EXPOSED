package y4;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٩١٥٠a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Class f١٩١٥١a;

        /* renamed from: b, reason: collision with root package name */
        final Class f١٩١٥٢b;

        /* renamed from: c, reason: collision with root package name */
        final e f١٩١٥٣c;

        a(Class cls, Class cls2, e eVar) {
            this.f١٩١٥١a = cls;
            this.f١٩١٥٢b = cls2;
            this.f١٩١٥٣c = eVar;
        }

        public boolean a(Class cls, Class cls2) {
            if (this.f١٩١٥١a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f١٩١٥٢b)) {
                return true;
            }
            return false;
        }
    }

    public synchronized e a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a aVar : this.f١٩١٥٠a) {
            if (aVar.a(cls, cls2)) {
                return aVar.f١٩١٥٣c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a aVar : this.f١٩١٥٠a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f١٩١٥٢b)) {
                arrayList.add(aVar.f١٩١٥٢b);
            }
        }
        return arrayList;
    }

    public synchronized void c(Class cls, Class cls2, e eVar) {
        this.f١٩١٥٠a.add(new a(cls, cls2, eVar));
    }
}
