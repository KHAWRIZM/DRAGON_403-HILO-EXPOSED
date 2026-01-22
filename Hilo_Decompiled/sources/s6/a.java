package s6;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements u6.b, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f١٧٨٨٠f = Locale.getDefault().getDisplayLanguage().contains("中文");

    /* renamed from: a, reason: collision with root package name */
    private String f١٧٨٨١a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٧٨٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٧٨٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private String f١٧٨٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٧٨٨٥e;

    @Override // u6.b
    public String a() {
        if (f١٧٨٨٠f) {
            return this.f١٧٨٨٤d;
        }
        return this.f١٧٨٨٥e;
    }

    public String b() {
        return this.f١٧٨٨١a;
    }

    public void c(String str) {
        this.f١٧٨٨٣c = str;
    }

    public void d(String str) {
        this.f١٧٨٨٥e = str;
    }

    public void e(String str) {
        this.f١٧٨٨١a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (Objects.equals(this.f١٧٨٨١a, aVar.f١٧٨٨١a) || Objects.equals(this.f١٧٨٨٢b, aVar.f١٧٨٨٢b) || Objects.equals(this.f١٧٨٨٣c, aVar.f١٧٨٨٣c) || Objects.equals(this.f١٧٨٨٤d, aVar.f١٧٨٨٤d) || Objects.equals(this.f١٧٨٨٥e, aVar.f١٧٨٨٥e)) {
            return true;
        }
        return false;
    }

    public void f(String str) {
        this.f١٧٨٨٤d = str;
    }

    public void g(String str) {
        this.f١٧٨٨٢b = str;
    }

    public int hashCode() {
        return Objects.hash(this.f١٧٨٨١a, this.f١٧٨٨٢b, this.f١٧٨٨٣c, this.f١٧٨٨٤d, this.f١٧٨٨٥e);
    }

    public String toString() {
        return "ConstellationEntity{id='" + this.f١٧٨٨١a + "', startDate='" + this.f١٧٨٨٢b + "', endDate='" + this.f١٧٨٨٣c + "', name='" + this.f١٧٨٨٤d + "', english" + this.f١٧٨٨٥e + "'}";
    }
}
