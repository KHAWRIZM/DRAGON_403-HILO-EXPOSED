package b5;

import java.util.ArrayList;
import java.util.List;
import m4.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List f٥٤٢٣a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Class f٥٤٢٤a;

        /* renamed from: b, reason: collision with root package name */
        final l f٥٤٢٥b;

        a(Class cls, l lVar) {
            this.f٥٤٢٤a = cls;
            this.f٥٤٢٥b = lVar;
        }

        boolean a(Class cls) {
            return this.f٥٤٢٤a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, l lVar) {
        this.f٥٤٢٣a.add(new a(cls, lVar));
    }

    public synchronized l b(Class cls) {
        int size = this.f٥٤٢٣a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) this.f٥٤٢٣a.get(i10);
            if (aVar.a(cls)) {
                return aVar.f٥٤٢٥b;
            }
        }
        return null;
    }

    public synchronized void c(Class cls, l lVar) {
        this.f٥٤٢٣a.add(0, new a(cls, lVar));
    }
}
