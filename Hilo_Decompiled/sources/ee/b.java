package ee;

import sd.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum b implements g {
    INSTANCE;

    public static void c(Throwable th, kf.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    @Override // sd.f
    public int a(int i10) {
        return i10 & 2;
    }

    @Override // sd.j
    public boolean isEmpty() {
        return true;
    }

    @Override // sd.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sd.j
    public Object poll() {
        return null;
    }

    public void request(long j10) {
        c.g(j10);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public void cancel() {
    }

    @Override // sd.j
    public void clear() {
    }
}
