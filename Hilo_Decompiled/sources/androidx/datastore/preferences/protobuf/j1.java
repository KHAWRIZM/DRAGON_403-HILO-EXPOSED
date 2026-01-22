package androidx.datastore.preferences.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j1 {

    /* renamed from: a, reason: collision with root package name */
    static final int f٣٣٦٧a = c(1, 3);

    /* renamed from: b, reason: collision with root package name */
    static final int f٣٣٦٨b = c(1, 4);

    /* renamed from: c, reason: collision with root package name */
    static final int f٣٣٦٩c = c(2, 0);

    /* renamed from: d, reason: collision with root package name */
    static final int f٣٣٧٠d = c(3, 2);

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f٣٣٧١c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f٣٣٧٢d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f٣٣٧٣e;

        /* renamed from: f, reason: collision with root package name */
        public static final b f٣٣٧٤f;

        /* renamed from: g, reason: collision with root package name */
        public static final b f٣٣٧٥g;

        /* renamed from: h, reason: collision with root package name */
        public static final b f٣٣٧٦h;

        /* renamed from: i, reason: collision with root package name */
        public static final b f٣٣٧٧i;

        /* renamed from: j, reason: collision with root package name */
        public static final b f٣٣٧٨j;

        /* renamed from: k, reason: collision with root package name */
        public static final b f٣٣٧٩k;

        /* renamed from: l, reason: collision with root package name */
        public static final b f٣٣٨٠l;

        /* renamed from: m, reason: collision with root package name */
        public static final b f٣٣٨١m;

        /* renamed from: n, reason: collision with root package name */
        public static final b f٣٣٨٢n;

        /* renamed from: o, reason: collision with root package name */
        public static final b f٣٣٨٣o;

        /* renamed from: p, reason: collision with root package name */
        public static final b f٣٣٨٤p;

        /* renamed from: q, reason: collision with root package name */
        public static final b f٣٣٨٥q;

        /* renamed from: r, reason: collision with root package name */
        public static final b f٣٣٨٦r;

        /* renamed from: s, reason: collision with root package name */
        public static final b f٣٣٨٧s;

        /* renamed from: t, reason: collision with root package name */
        public static final b f٣٣٨٨t;

        /* renamed from: u, reason: collision with root package name */
        private static final /* synthetic */ b[] f٣٣٨٩u;

        /* renamed from: a, reason: collision with root package name */
        private final c f٣٣٩٠a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٣٣٩١b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        enum a extends b {
            a(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* renamed from: androidx.datastore.preferences.protobuf.j1$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        enum C٠٠٣٦b extends b {
            C٠٠٣٦b(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        enum c extends b {
            c(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        enum d extends b {
            d(String str, int i10, c cVar, int i11) {
                super(str, i10, cVar, i11);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            f٣٣٧١c = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f٣٣٧٢d = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f٣٣٧٣e = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f٣٣٧٤f = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f٣٣٧٥g = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f٣٣٧٦h = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f٣٣٧٧i = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f٣٣٧٨j = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f٣٣٧٩k = aVar;
            c cVar3 = c.MESSAGE;
            C٠٠٣٦b r32 = new C٠٠٣٦b("GROUP", 9, cVar3, 3);
            f٣٣٨٠l = r32;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f٣٣٨١m = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            f٣٣٨٢n = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            f٣٣٨٣o = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            f٣٣٨٤p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            f٣٣٨٥q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            f٣٣٨٦r = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            f٣٣٨٧s = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            f٣٣٨٨t = bVar14;
            f٣٣٨٩u = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, r32, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f٣٣٨٩u.clone();
        }

        public c a() {
            return this.f٣٣٩٠a;
        }

        public int c() {
            return this.f٣٣٩١b;
        }

        private b(String str, int i10, c cVar, int i11) {
            this.f٣٣٩٠a = cVar;
            this.f٣٣٩١b = i11;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)),
        DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(f.f٣٢٨٥b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a, reason: collision with root package name */
        private final Object f٣٤٠٢a;

        c(Object obj) {
            this.f٣٤٠٢a = obj;
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
}
