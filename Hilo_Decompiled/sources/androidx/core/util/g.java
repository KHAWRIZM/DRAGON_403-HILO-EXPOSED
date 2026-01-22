package androidx.core.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f٢٨٨٨a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f٢٨٨٩b;

    public g(Object obj, Object obj2) {
        this.f٢٨٨٨a = obj;
        this.f٢٨٨٩b = obj2;
    }

    public static g a(Object obj, Object obj2) {
        return new g(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!f.a(gVar.f٢٨٨٨a, this.f٢٨٨٨a) || !f.a(gVar.f٢٨٨٩b, this.f٢٨٨٩b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        Object obj = this.f٢٨٨٨a;
        int i10 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f٢٨٨٩b;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + this.f٢٨٨٨a + " " + this.f٢٨٨٩b + "}";
    }
}
