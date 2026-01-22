package q3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    Object f١٧١٢٣a;

    /* renamed from: b, reason: collision with root package name */
    Object f١٧١٢٤b;

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public void b(Object obj, Object obj2) {
        this.f١٧١٢٣a = obj;
        this.f١٧١٢٤b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof androidx.core.util.g)) {
            return false;
        }
        androidx.core.util.g gVar = (androidx.core.util.g) obj;
        if (!a(gVar.f٢٨٨٨a, this.f١٧١٢٣a) || !a(gVar.f٢٨٨٩b, this.f١٧١٢٤b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        Object obj = this.f١٧١٢٣a;
        int i10 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f١٧١٢٤b;
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + this.f١٧١٢٣a + " " + this.f١٧١٢٤b + "}";
    }
}
