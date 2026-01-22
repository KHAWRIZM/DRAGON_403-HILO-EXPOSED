package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class r2 {

    /* renamed from: a, reason: collision with root package name */
    static final int f١١٩٠٩a = c(1, 3);

    /* renamed from: b, reason: collision with root package name */
    static final int f١١٩١٠b = c(1, 4);

    /* renamed from: c, reason: collision with root package name */
    static final int f١١٩١١c = c(2, 0);

    /* renamed from: d, reason: collision with root package name */
    static final int f١١٩١٢d = c(3, 2);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٩١٣a;

        static {
            int[] iArr = new int[b.values().length];
            f١١٩١٣a = iArr;
            try {
                iArr[b.f١١٩١٤c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١١٩١٣a[b.f١١٩١٥d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١١٩١٣a[b.f١١٩١٦e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١١٩١٣a[b.f١١٩١٧f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١١٩١٣a[b.f١١٩١٨g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١١٩١٣a[b.f١١٩١٩h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٠i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢١j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٥n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٦o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٨q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٩r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١١٩١٣a[b.f١١٩٣٠s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f١١٩١٣a[b.f١١٩٣١t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٢k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٣l.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٤m.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f١١٩١٣a[b.f١١٩٢٧p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f١١٩١٤c = new b("DOUBLE", 0, c.DOUBLE, 1);

        /* renamed from: d, reason: collision with root package name */
        public static final b f١١٩١٥d = new b("FLOAT", 1, c.FLOAT, 5);

        /* renamed from: e, reason: collision with root package name */
        public static final b f١١٩١٦e;

        /* renamed from: f, reason: collision with root package name */
        public static final b f١١٩١٧f;

        /* renamed from: g, reason: collision with root package name */
        public static final b f١١٩١٨g;

        /* renamed from: h, reason: collision with root package name */
        public static final b f١١٩١٩h;

        /* renamed from: i, reason: collision with root package name */
        public static final b f١١٩٢٠i;

        /* renamed from: j, reason: collision with root package name */
        public static final b f١١٩٢١j;

        /* renamed from: k, reason: collision with root package name */
        public static final b f١١٩٢٢k;

        /* renamed from: l, reason: collision with root package name */
        public static final b f١١٩٢٣l;

        /* renamed from: m, reason: collision with root package name */
        public static final b f١١٩٢٤m;

        /* renamed from: n, reason: collision with root package name */
        public static final b f١١٩٢٥n;

        /* renamed from: o, reason: collision with root package name */
        public static final b f١١٩٢٦o;

        /* renamed from: p, reason: collision with root package name */
        public static final b f١١٩٢٧p;

        /* renamed from: q, reason: collision with root package name */
        public static final b f١١٩٢٨q;

        /* renamed from: r, reason: collision with root package name */
        public static final b f١١٩٢٩r;

        /* renamed from: s, reason: collision with root package name */
        public static final b f١١٩٣٠s;

        /* renamed from: t, reason: collision with root package name */
        public static final b f١١٩٣١t;

        /* renamed from: u, reason: collision with root package name */
        private static final /* synthetic */ b[] f١١٩٣٢u;

        /* renamed from: a, reason: collision with root package name */
        private final c f١١٩٣٣a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١١٩٣٤b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum a extends b {
            a(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11, null);
            }

            @Override // com.google.protobuf.r2.b
            public boolean e() {
                return false;
            }
        }

        /* renamed from: com.google.protobuf.r2$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum C٠١٤٢b extends b {
            C٠١٤٢b(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11, null);
            }

            @Override // com.google.protobuf.r2.b
            public boolean e() {
                return false;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum c extends b {
            c(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11, null);
            }

            @Override // com.google.protobuf.r2.b
            public boolean e() {
                return false;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum d extends b {
            d(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11, null);
            }

            @Override // com.google.protobuf.r2.b
            public boolean e() {
                return false;
            }
        }

        static {
            c cVar = c.LONG;
            f١١٩١٦e = new b("INT64", 2, cVar, 0);
            f١١٩١٧f = new b("UINT64", 3, cVar, 0);
            c cVar2 = c.INT;
            f١١٩١٨g = new b("INT32", 4, cVar2, 0);
            f١١٩١٩h = new b("FIXED64", 5, cVar, 1);
            f١١٩٢٠i = new b("FIXED32", 6, cVar2, 5);
            f١١٩٢١j = new b("BOOL", 7, c.BOOLEAN, 0);
            f١١٩٢٢k = new a("STRING", 8, c.STRING, 2);
            c cVar3 = c.MESSAGE;
            f١١٩٢٣l = new C٠١٤٢b("GROUP", 9, cVar3, 3);
            f١١٩٢٤m = new c("MESSAGE", 10, cVar3, 2);
            f١١٩٢٥n = new d("BYTES", 11, c.BYTE_STRING, 2);
            f١١٩٢٦o = new b("UINT32", 12, cVar2, 0);
            f١١٩٢٧p = new b("ENUM", 13, c.ENUM, 0);
            f١١٩٢٨q = new b("SFIXED32", 14, cVar2, 5);
            f١١٩٢٩r = new b("SFIXED64", 15, cVar, 1);
            f١١٩٣٠s = new b("SINT32", 16, cVar2, 0);
            f١١٩٣١t = new b("SINT64", 17, cVar, 0);
            f١١٩٣٢u = a();
        }

        /* synthetic */ b(String str, int i10, c cVar, int i11, a aVar) {
            this(str, i10, cVar, i11);
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f١١٩١٤c, f١١٩١٥d, f١١٩١٦e, f١١٩١٧f, f١١٩١٨g, f١١٩١٩h, f١١٩٢٠i, f١١٩٢١j, f١١٩٢٢k, f١١٩٢٣l, f١١٩٢٤m, f١١٩٢٥n, f١١٩٢٦o, f١١٩٢٧p, f١١٩٢٨q, f١١٩٢٩r, f١١٩٣٠s, f١١٩٣١t};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f١١٩٣٢u.clone();
        }

        public c c() {
            return this.f١١٩٣٣a;
        }

        public int d() {
            return this.f١١٩٣٤b;
        }

        public boolean e() {
            return true;
        }

        private b(String str, int i10, c cVar, int i11) {
            this.f١١٩٣٣a = cVar;
            this.f١١٩٣٤b = i11;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)),
        DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(h.f١١٠١١b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a, reason: collision with root package name */
        private final Object f١١٩٤٥a;

        c(Object obj) {
            this.f١١٩٤٥a = obj;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f١١٩٤٦a = new a("LOOSE", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final d f١١٩٤٧b = new b("STRICT", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final d f١١٩٤٨c = new c("LAZY", 2);

        /* renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f١١٩٤٩d = a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum a extends d {
            a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.r2.d
            Object c(i iVar) {
                return iVar.I();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum b extends d {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.r2.d
            Object c(i iVar) {
                return iVar.J();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        enum c extends d {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.protobuf.r2.d
            Object c(i iVar) {
                return iVar.r();
            }
        }

        private d(String str, int i10) {
        }

        private static /* synthetic */ d[] a() {
            return new d[]{f١١٩٤٦a, f١١٩٤٧b, f١١٩٤٨c};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f١١٩٤٩d.clone();
        }

        abstract Object c(i iVar);

        /* synthetic */ d(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    public static int a(int i10) {
        return i10 >>> 3;
    }

    public static int b(int i10) {
        return i10 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, int i11) {
        return (i10 << 3) | i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(i iVar, b bVar, d dVar) {
        switch (a.f١١٩١٣a[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(iVar.s());
            case 2:
                return Float.valueOf(iVar.w());
            case 3:
                return Long.valueOf(iVar.z());
            case 4:
                return Long.valueOf(iVar.M());
            case 5:
                return Integer.valueOf(iVar.y());
            case 6:
                return Long.valueOf(iVar.v());
            case 7:
                return Integer.valueOf(iVar.u());
            case 8:
                return Boolean.valueOf(iVar.q());
            case 9:
                return iVar.r();
            case 10:
                return Integer.valueOf(iVar.L());
            case 11:
                return Integer.valueOf(iVar.E());
            case 12:
                return Long.valueOf(iVar.F());
            case 13:
                return Integer.valueOf(iVar.G());
            case 14:
                return Long.valueOf(iVar.H());
            case 15:
                return dVar.c(iVar);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
