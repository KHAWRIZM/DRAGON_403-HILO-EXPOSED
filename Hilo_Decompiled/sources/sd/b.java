package sd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f١٧٩٢٨a;

    @Override // sd.a
    public void cancel() {
        this.f١٧٩٢٨a = true;
    }

    @Override // nd.c
    public void dispose() {
        this.f١٧٩٢٨a = true;
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٧٩٢٨a;
    }
}
