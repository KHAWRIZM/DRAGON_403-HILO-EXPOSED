package f5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class f {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private volatile Object f١٤٠٦٦a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f١٤٠٦٧b;

        a(b bVar) {
            this.f١٤٠٦٧b = bVar;
        }

        @Override // f5.f.b
        public Object get() {
            if (this.f١٤٠٦٦a == null) {
                synchronized (this) {
                    try {
                        if (this.f١٤٠٦٦a == null) {
                            this.f١٤٠٦٦a = k.d(this.f١٤٠٦٧b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.f١٤٠٦٦a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        Object get();
    }

    public static b a(b bVar) {
        return new a(bVar);
    }
}
