package b5;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List f٥٤٠٩a = new ArrayList();

    /* renamed from: b5.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class C٠٠٦٦a {

        /* renamed from: a, reason: collision with root package name */
        private final Class f٥٤١٠a;

        /* renamed from: b, reason: collision with root package name */
        final m4.d f٥٤١١b;

        C٠٠٦٦a(Class cls, m4.d dVar) {
            this.f٥٤١٠a = cls;
            this.f٥٤١١b = dVar;
        }

        boolean a(Class cls) {
            return this.f٥٤١٠a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, m4.d dVar) {
        this.f٥٤٠٩a.add(new C٠٠٦٦a(cls, dVar));
    }

    public synchronized m4.d b(Class cls) {
        for (C٠٠٦٦a r12 : this.f٥٤٠٩a) {
            if (r12.a(cls)) {
                return r12.f٥٤١١b;
            }
        }
        return null;
    }
}
