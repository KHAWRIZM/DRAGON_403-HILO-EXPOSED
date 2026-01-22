package cf;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class j {
    private static final List d = new ArrayList();
    Object a;
    q b;
    j c;

    private j(Object obj, q qVar) {
        this.a = obj;
        this.b = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(q qVar, Object obj) {
        List list = d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size > 0) {
                    j jVar = (j) list.remove(size - 1);
                    jVar.a = obj;
                    jVar.b = qVar;
                    jVar.c = null;
                    return jVar;
                }
                return new j(obj, qVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(j jVar) {
        jVar.a = null;
        jVar.b = null;
        jVar.c = null;
        List list = d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
