package com.google.protobuf;

import com.google.protobuf.g0;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f١١٩٦٧b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f١١٩٦٨c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile v f١١٩٦٩d;

    /* renamed from: e, reason: collision with root package name */
    static final v f١١٩٧٠e = new v(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map f١١٩٧١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f١١٩٧٢a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١١٩٧٣b;

        a(Object obj, int i10) {
            this.f١١٩٧٢a = obj;
            this.f١١٩٧٣b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f١١٩٧٢a != aVar.f١١٩٧٢a || this.f١١٩٧٣b != aVar.f١١٩٧٣b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f١١٩٧٢a) * 65535) + this.f١١٩٧٣b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(v vVar) {
        if (vVar == f١١٩٧٠e) {
            this.f١١٩٧١a = Collections.emptyMap();
        } else {
            this.f١١٩٧١a = Collections.unmodifiableMap(vVar.f١١٩٧١a);
        }
    }

    public static v b() {
        v vVar = f١١٩٦٩d;
        if (vVar == null) {
            synchronized (v.class) {
                try {
                    vVar = f١١٩٦٩d;
                    if (vVar == null) {
                        if (f١١٩٦٨c) {
                            vVar = u.a();
                        } else {
                            vVar = f١١٩٧٠e;
                        }
                        f١١٩٦٩d = vVar;
                    }
                } finally {
                }
            }
        }
        return vVar;
    }

    public static boolean c() {
        return f١١٩٦٧b;
    }

    public g0.a a(e1 e1Var, int i10) {
        androidx.appcompat.app.a0.a(this.f١١٩٧١a.get(new a(e1Var, i10)));
        return null;
    }

    v(boolean z10) {
        this.f١١٩٧١a = Collections.emptyMap();
    }
}
