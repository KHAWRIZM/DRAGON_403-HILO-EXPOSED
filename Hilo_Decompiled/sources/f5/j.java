package f5;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Class f١٤٠٧٦a;

    /* renamed from: b, reason: collision with root package name */
    private Class f١٤٠٧٧b;

    /* renamed from: c, reason: collision with root package name */
    private Class f١٤٠٧٨c;

    public j() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.f١٤٠٧٦a = cls;
        this.f١٤٠٧٧b = cls2;
        this.f١٤٠٧٨c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f١٤٠٧٦a.equals(jVar.f١٤٠٧٦a) && this.f١٤٠٧٧b.equals(jVar.f١٤٠٧٧b) && l.e(this.f١٤٠٧٨c, jVar.f١٤٠٧٨c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f١٤٠٧٦a.hashCode() * 31) + this.f١٤٠٧٧b.hashCode()) * 31;
        Class cls = this.f١٤٠٧٨c;
        if (cls != null) {
            i10 = cls.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f١٤٠٧٦a + ", second=" + this.f١٤٠٧٧b + '}';
    }

    public j(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
