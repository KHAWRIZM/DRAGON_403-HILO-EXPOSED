package c5;

import m4.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h extends a {
    private static h A;

    /* renamed from: B, reason: collision with root package name */
    private static h f٥٨٨٥B;

    public static h p0(m mVar) {
        return (h) new h().k0(mVar);
    }

    public static h q0(Class cls) {
        return (h) new h().f(cls);
    }

    public static h r0(o4.j jVar) {
        return (h) new h().g(jVar);
    }

    public static h s0(m4.f fVar) {
        return (h) new h().f0(fVar);
    }

    public static h t0(boolean z10) {
        if (z10) {
            if (A == null) {
                A = (h) ((h) new h().h0(true)).b();
            }
            return A;
        }
        if (f٥٨٨٥B == null) {
            f٥٨٨٥B = (h) ((h) new h().h0(false)).b();
        }
        return f٥٨٨٥B;
    }

    @Override // c5.a
    public boolean equals(Object obj) {
        if ((obj instanceof h) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override // c5.a
    public int hashCode() {
        return super.hashCode();
    }
}
