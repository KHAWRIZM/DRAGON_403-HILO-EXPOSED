package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.u;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c extends t implements k0 {
    private static final c DEFAULT_INSTANCE;
    private static volatile r0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private u.b strings_ = t.p();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a extends t.a implements k0 {
        /* synthetic */ a(androidx.datastore.preferences.a aVar) {
            this();
        }

        public a m(Iterable iterable) {
            h();
            ((c) this.f٣٤٩٤b).M(iterable);
            return this;
        }

        private a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        t.H(c.class, cVar);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Iterable iterable) {
        N();
        androidx.datastore.preferences.protobuf.a.b(iterable, this.strings_);
    }

    private void N() {
        u.b bVar = this.strings_;
        if (!bVar.c()) {
            this.strings_ = t.B(bVar);
        }
    }

    public static c O() {
        return DEFAULT_INSTANCE;
    }

    public static a Q() {
        return (a) DEFAULT_INSTANCE.l();
    }

    public List P() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.t
    protected final Object o(t.d dVar, Object obj, Object obj2) {
        androidx.datastore.preferences.a aVar = null;
        switch (androidx.datastore.preferences.a.f٣٢٣١a[dVar.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new a(aVar);
            case 3:
                return t.D(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                r0 r0Var = PARSER;
                if (r0Var == null) {
                    synchronized (c.class) {
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
