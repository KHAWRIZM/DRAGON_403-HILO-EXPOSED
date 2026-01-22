package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b extends t implements k0 {
    private static final b DEFAULT_INSTANCE;
    private static volatile r0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private d0 preferences_ = d0.f();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a extends t.a implements k0 {
        /* synthetic */ a(androidx.datastore.preferences.a aVar) {
            this();
        }

        public a m(String str, d dVar) {
            str.getClass();
            dVar.getClass();
            h();
            ((b) this.f٣٤٩٤b).M().put(str, dVar);
            return this;
        }

        private a() {
            super(b.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: androidx.datastore.preferences.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class C٠٠٣٣b {

        /* renamed from: a, reason: collision with root package name */
        static final c0 f٣٢٣٢a = c0.d(j1.b.f٣٣٧٩k, "", j1.b.f٣٣٨١m, d.V());
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        t.H(b.class, bVar);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map M() {
        return O();
    }

    private d0 O() {
        if (!this.preferences_.j()) {
            this.preferences_ = this.preferences_.m();
        }
        return this.preferences_;
    }

    private d0 P() {
        return this.preferences_;
    }

    public static a Q() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public static b R(InputStream inputStream) {
        return (b) t.F(DEFAULT_INSTANCE, inputStream);
    }

    public Map N() {
        return Collections.unmodifiableMap(P());
    }

    @Override // androidx.datastore.preferences.protobuf.t
    protected final Object o(t.d dVar, Object obj, Object obj2) {
        androidx.datastore.preferences.a aVar = null;
        switch (androidx.datastore.preferences.a.f٣٢٣١a[dVar.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new a(aVar);
            case 3:
                return t.D(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", C٠٠٣٣b.f٣٢٣٢a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                r0 r0Var = PARSER;
                if (r0Var == null) {
                    synchronized (b.class) {
                        try {
                            r0Var = PARSER;
                            if (r0Var == null) {
                                r0Var = new t.b(DEFAULT_INSTANCE);
                                PARSER = r0Var;
                            }
                        } finally {
                        }
                    }
                }
                return r0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
