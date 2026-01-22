package e4;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements k5.a {

    /* renamed from: a, reason: collision with root package name */
    private int f١٣٨٨١a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٨٨٢b;

    public b(int i10, int i11) {
        this.f١٣٨٨١a = i10;
        this.f١٣٨٨٢b = i11;
    }

    @Override // k5.a
    public int a() {
        return (this.f١٣٨٨٢b - this.f١٣٨٨١a) + 1;
    }

    @Override // k5.a
    public Object getItem(int i10) {
        if (i10 >= 0 && i10 < a()) {
            return Integer.valueOf(this.f١٣٨٨١a + i10);
        }
        return 0;
    }
}
