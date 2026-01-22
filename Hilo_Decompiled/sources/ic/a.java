package ic;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f١٤٨٢٣a = false;

    /* renamed from: b, reason: collision with root package name */
    private Object f١٤٨٢٤b;

    public Object a(Object obj) {
        if (this.f١٤٨٢٣a) {
            return this.f١٤٨٢٤b;
        }
        synchronized (this) {
            try {
                if (!this.f١٤٨٢٣a) {
                    this.f١٤٨٢٤b = b(obj);
                    this.f١٤٨٢٣a = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f١٤٨٢٤b;
    }

    protected abstract Object b(Object obj);
}
