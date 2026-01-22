package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.t;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private static volatile m f٣٤٠٨b;

    /* renamed from: c, reason: collision with root package name */
    static final m f٣٤٠٩c = new m(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map f٣٤١٠a = Collections.emptyMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f٣٤١١a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٣٤١٢b;

        a(Object obj, int i10) {
            this.f٣٤١١a = obj;
            this.f٣٤١٢b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f٣٤١١a != aVar.f٣٤١١a || this.f٣٤١٢b != aVar.f٣٤١٢b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f٣٤١١a) * 65535) + this.f٣٤١٢b;
        }
    }

    m(boolean z10) {
    }

    public static m b() {
        if (t0.f٣٥٠٥d) {
            return f٣٤٠٩c;
        }
        m mVar = f٣٤٠٨b;
        if (mVar == null) {
            synchronized (m.class) {
                try {
                    mVar = f٣٤٠٨b;
                    if (mVar == null) {
                        mVar = l.a();
                        f٣٤٠٨b = mVar;
                    }
                } finally {
                }
            }
        }
        return mVar;
    }

    public t.c a(j0 j0Var, int i10) {
        androidx.appcompat.app.a0.a(this.f٣٤١٠a.get(new a(j0Var, i10)));
        return null;
    }
}
