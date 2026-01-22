package f8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h extends g {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٤٠٩١a;

    public h(float f10) {
        this.f١٤٠٩١a = f10 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f8.g
    public boolean a() {
        return true;
    }

    @Override // f8.g
    public void b(float f10, float f11, float f12, q qVar) {
        float sqrt = (float) ((this.f١٤٠٩١a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f١٤٠٩١a, 2.0d) - Math.pow(sqrt, 2.0d));
        qVar.n(f11 - sqrt, ((float) (-((this.f١٤٠٩١a * Math.sqrt(2.0d)) - this.f١٤٠٩١a))) + sqrt2);
        qVar.m(f11, (float) (-((this.f١٤٠٩١a * Math.sqrt(2.0d)) - this.f١٤٠٩١a)));
        qVar.m(f11 + sqrt, ((float) (-((this.f١٤٠٩١a * Math.sqrt(2.0d)) - this.f١٤٠٩١a))) + sqrt2);
    }
}
