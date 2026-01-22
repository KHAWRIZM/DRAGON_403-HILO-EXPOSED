package tech.sud.runtime.component.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class f {
    public static final f a = new f("tableDirectory");
    public static final f b = new f("name");
    private final String c;

    private f(String str) {
        this.c = str;
    }

    public static f a(String str) {
        if (str != null) {
            return new f(str);
        }
        throw new IllegalArgumentException("A TrueType font table name must not be null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.c.equals(((f) obj).a());
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return this.c;
    }

    public String a() {
        return this.c;
    }
}
