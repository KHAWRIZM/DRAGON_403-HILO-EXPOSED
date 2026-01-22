package s6;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f implements u6.b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f١٧٨٩٩d = Locale.getDefault().getDisplayLanguage().contains("中文");

    /* renamed from: a, reason: collision with root package name */
    private String f١٧٩٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٧٩٠١b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٧٩٠٢c;

    @Override // u6.b
    public String a() {
        if (f١٧٨٩٩d) {
            return this.f١٧٩٠١b;
        }
        return this.f١٧٩٠٢c;
    }

    public String b() {
        return this.f١٧٩٠٠a;
    }

    public void c(String str) {
        this.f١٧٩٠٢c = str;
    }

    public void d(String str) {
        this.f١٧٩٠٠a = str;
    }

    public void e(String str) {
        this.f١٧٩٠١b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (Objects.equals(this.f١٧٩٠٠a, fVar.f١٧٩٠٠a) || Objects.equals(this.f١٧٩٠١b, fVar.f١٧٩٠١b) || Objects.equals(this.f١٧٩٠٢c, fVar.f١٧٩٠٢c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f١٧٩٠٠a, this.f١٧٩٠١b, this.f١٧٩٠٢c);
    }

    public String toString() {
        return "SexEntity{id='" + this.f١٧٩٠٠a + "', name='" + this.f١٧٩٠١b + "', english" + this.f١٧٩٠٢c + "'}";
    }
}
