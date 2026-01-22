package q3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧١٠٩a;

    /* renamed from: b, reason: collision with root package name */
    private final char f١٧١١٠b;

    /* renamed from: c, reason: collision with root package name */
    private final double f١٧١١١c;

    /* renamed from: d, reason: collision with root package name */
    private final double f١٧١١٢d;

    /* renamed from: e, reason: collision with root package name */
    private final String f١٧١١٣e;

    /* renamed from: f, reason: collision with root package name */
    private final String f١٧١١٤f;

    public d(List list, char c10, double d10, double d11, String str, String str2) {
        this.f١٧١٠٩a = list;
        this.f١٧١١٠b = c10;
        this.f١٧١١١c = d10;
        this.f١٧١١٢d = d11;
        this.f١٧١١٣e = str;
        this.f١٧١١٤f = str2;
    }

    public static int c(char c10, String str, String str2) {
        return (((c10 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f١٧١٠٩a;
    }

    public double b() {
        return this.f١٧١١٢d;
    }

    public int hashCode() {
        return c(this.f١٧١١٠b, this.f١٧١١٤f, this.f١٧١١٣e);
    }
}
