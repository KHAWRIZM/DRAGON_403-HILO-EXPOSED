package androidx.datastore.preferences;

import androidx.datastore.preferences.c;
import androidx.datastore.preferences.protobuf.f;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends t implements k0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final d DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile r0 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a extends t.a implements k0 {
        /* synthetic */ a(androidx.datastore.preferences.a aVar) {
            this();
        }

        public a m(boolean z10) {
            h();
            ((d) this.f٣٤٩٤b).e0(z10);
            return this;
        }

        public a n(f fVar) {
            h();
            ((d) this.f٣٤٩٤b).f0(fVar);
            return this;
        }

        public a o(double d10) {
            h();
            ((d) this.f٣٤٩٤b).g0(d10);
            return this;
        }

        public a p(float f10) {
            h();
            ((d) this.f٣٤٩٤b).h0(f10);
            return this;
        }

        public a q(int i10) {
            h();
            ((d) this.f٣٤٩٤b).i0(i10);
            return this;
        }

        public a r(long j10) {
            h();
            ((d) this.f٣٤٩٤b).j0(j10);
            return this;
        }

        public a s(String str) {
            h();
            ((d) this.f٣٤٩٤b).k0(str);
            return this;
        }

        public a t(c.a aVar) {
            h();
            ((d) this.f٣٤٩٤b).l0((c) aVar.e());
            return this;
        }

        private a() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        BYTES(8),
        VALUE_NOT_SET(0);


        /* renamed from: a, reason: collision with root package name */
        private final int f٣٢٤٣a;

        b(int i10) {
            this.f٣٢٤٣a = i10;
        }

        public static b c(int i10) {
            switch (i10) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                case 8:
                    return BYTES;
                default:
                    return null;
            }
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        t.H(d.class, dVar);
    }

    private d() {
    }

    public static d V() {
        return DEFAULT_INSTANCE;
    }

    public static a d0() {
        return (a) DEFAULT_INSTANCE.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(boolean z10) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(f fVar) {
        fVar.getClass();
        this.valueCase_ = 8;
        this.value_ = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(double d10) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(float f10) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i10) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(long j10) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(c cVar) {
        cVar.getClass();
        this.value_ = cVar;
        this.valueCase_ = 6;
    }

    public boolean T() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public f U() {
        if (this.valueCase_ == 8) {
            return (f) this.value_;
        }
        return f.f٣٢٨٥b;
    }

    public double W() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public float X() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public int Y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long Z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String a0() {
        if (this.valueCase_ == 5) {
            return (String) this.value_;
        }
        return "";
    }

    public c b0() {
        if (this.valueCase_ == 6) {
            return (c) this.value_;
        }
        return c.O();
    }

    public b c0() {
        return b.c(this.valueCase_);
    }

    @Override // androidx.datastore.preferences.protobuf.t
    protected final Object o(t.d dVar, Object obj, Object obj2) {
        androidx.datastore.preferences.a aVar = null;
        switch (androidx.datastore.preferences.a.f٣٢٣١a[dVar.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a(aVar);
            case 3:
                return t.D(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                r0 r0Var = PARSER;
                if (r0Var == null) {
                    synchronized (d.class) {
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
