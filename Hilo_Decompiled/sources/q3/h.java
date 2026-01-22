package q3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧١٢٠a;

    /* renamed from: b, reason: collision with root package name */
    public final float f١٧١٢١b;

    /* renamed from: c, reason: collision with root package name */
    public final float f١٧١٢٢c;

    public h(String str, float f10, float f11) {
        this.f١٧١٢٠a = str;
        this.f١٧١٢٢c = f11;
        this.f١٧١٢١b = f10;
    }

    public boolean a(String str) {
        if (this.f١٧١٢٠a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f١٧١٢٠a.endsWith("\r")) {
            String str2 = this.f١٧١٢٠a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
