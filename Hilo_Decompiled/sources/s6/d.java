package s6;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements u6.b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f١٧٨٩١d = Locale.getDefault().getDisplayLanguage().contains("中文");

    /* renamed from: a, reason: collision with root package name */
    private String f١٧٨٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٧٨٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٧٨٩٤c;

    @Override // u6.b
    public String a() {
        if (f١٧٨٩١d) {
            return this.f١٧٨٩٣b;
        }
        return this.f١٧٨٩٤c;
    }

    public void b(String str) {
        this.f١٧٨٩٢a = str;
    }

    public void c(String str) {
        this.f١٧٨٩٣b = str;
    }

    public void d(String str) {
        this.f١٧٨٩٤c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (Objects.equals(this.f١٧٨٩٢a, dVar.f١٧٨٩٢a) || Objects.equals(this.f١٧٨٩٣b, dVar.f١٧٨٩٣b) || Objects.equals(this.f١٧٨٩٤c, dVar.f١٧٨٩٤c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f١٧٨٩٢a, this.f١٧٨٩٣b, this.f١٧٨٩٤c);
    }

    public String toString() {
        return "EthnicEntity{code='" + this.f١٧٨٩٢a + "', name='" + this.f١٧٨٩٣b + "', spelling='" + this.f١٧٨٩٤c + "'}";
    }
}
