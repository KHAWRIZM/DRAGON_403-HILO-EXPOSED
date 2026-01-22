package n5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static d f١٦٣٦٥a;

    /* renamed from: b, reason: collision with root package name */
    static a f١٦٣٦٦b;

    /* renamed from: c, reason: collision with root package name */
    static a6.b f١٦٣٦٧c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f١٦٣٦٨d;

    static void a() {
        if (f١٦٣٦٨d) {
        } else {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public static void b(String str) {
        a();
        f١٦٣٦٥a.a(str);
    }

    public static void c(String str) {
        a();
        f١٦٣٦٥a.b(str);
    }

    public static void d(a aVar, a6.b... bVarArr) {
        if (f١٦٣٦٨d) {
            x5.b.d().f("XLog is already initialized, do not initialize again");
        }
        f١٦٣٦٨d = true;
        if (aVar != null) {
            f١٦٣٦٦b = aVar;
            a6.c cVar = new a6.c(bVarArr);
            f١٦٣٦٧c = cVar;
            f١٦٣٦٥a = new d(f١٦٣٦٦b, cVar);
            return;
        }
        throw new IllegalArgumentException("Please specify a LogConfiguration");
    }
}
