package x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public volatile String f١٨٨٢٤a;

    public c() {
    }

    public final boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        if (this.f١٨٨٢٤a == null) {
            if (((c) obj).f١٨٨٢٤a == null) {
                return true;
            }
            return false;
        }
        return this.f١٨٨٢٤a.equals(((c) obj).f١٨٨٢٤a);
    }

    public final int hashCode() {
        if (this.f١٨٨٢٤a == null) {
            return 0;
        }
        return this.f١٨٨٢٤a.hashCode();
    }

    public c(String str) {
        this.f١٨٨٢٤a = str;
    }
}
