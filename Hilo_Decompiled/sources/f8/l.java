package f8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l extends g {

    /* renamed from: a, reason: collision with root package name */
    private final g f١٤١٧٤a;

    /* renamed from: b, reason: collision with root package name */
    private final float f١٤١٧٥b;

    public l(g gVar, float f10) {
        this.f١٤١٧٤a = gVar;
        this.f١٤١٧٥b = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f8.g
    public boolean a() {
        return this.f١٤١٧٤a.a();
    }

    @Override // f8.g
    public void b(float f10, float f11, float f12, q qVar) {
        this.f١٤١٧٤a.b(f10, f11 - this.f١٤١٧٥b, f12, qVar);
    }
}
