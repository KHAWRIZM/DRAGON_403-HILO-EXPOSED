package sd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a implements g, e {
    @Override // sd.f
    public final int a(int i10) {
        return i10 & 2;
    }

    @Override // sd.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // sd.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sd.j
    public final Object poll() {
        return null;
    }

    public void cancel() {
    }

    @Override // sd.j
    public final void clear() {
    }

    public final void request(long j10) {
    }
}
