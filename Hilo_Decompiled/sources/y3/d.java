package y3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private float f١٩١٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٩١٤٣b;

    public d(float f10, float f11) {
        this.f١٩١٤٢a = f10;
        this.f١٩١٤٣b = f11;
    }

    public boolean a(float f10, float f11) {
        if (this.f١٩١٤٢a == f10 && this.f١٩١٤٣b == f11) {
            return true;
        }
        return false;
    }

    public float b() {
        return this.f١٩١٤٢a;
    }

    public float c() {
        return this.f١٩١٤٣b;
    }

    public void d(float f10, float f11) {
        this.f١٩١٤٢a = f10;
        this.f١٩١٤٣b = f11;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
