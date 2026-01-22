package d7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements ne.a {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f١٣٦٤٩c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private volatile ne.a f١٣٦٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f١٣٦٥١b = f١٣٦٤٩c;

    private a(ne.a aVar) {
        this.f١٣٦٥٠a = aVar;
    }

    public static ne.a a(ne.a aVar) {
        d.b(aVar);
        if (aVar instanceof a) {
            return aVar;
        }
        return new a(aVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj != f١٣٦٤٩c && obj != obj2) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
    }

    @Override // ne.a
    public Object get() {
        Object obj = this.f١٣٦٥١b;
        Object obj2 = f١٣٦٤٩c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f١٣٦٥١b;
                    if (obj == obj2) {
                        obj = this.f١٣٦٥٠a.get();
                        this.f١٣٦٥١b = b(this.f١٣٦٥١b, obj);
                        this.f١٣٦٥٠a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
