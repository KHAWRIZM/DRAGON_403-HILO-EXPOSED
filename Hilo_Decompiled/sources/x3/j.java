package x3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private float f١٨٩٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٨٩٢١b;

    public void a(float f10) {
        float f11 = this.f١٨٩٢٠a + f10;
        this.f١٨٩٢٠a = f11;
        int i10 = this.f١٨٩٢١b + 1;
        this.f١٨٩٢١b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f١٨٩٢٠a = f11 / 2.0f;
            this.f١٨٩٢١b = i10 / 2;
        }
    }
}
