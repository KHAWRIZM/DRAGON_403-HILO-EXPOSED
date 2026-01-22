package z6;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٩٤٩٧a;

    private c(String str) {
        if (str != null) {
            this.f١٩٤٩٧a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static c b(String str) {
        return new c(str);
    }

    public String a() {
        return this.f١٩٤٩٧a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f١٩٤٩٧a.equals(((c) obj).f١٩٤٩٧a);
    }

    public int hashCode() {
        return this.f١٩٤٩٧a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f١٩٤٩٧a + "\"}";
    }
}
