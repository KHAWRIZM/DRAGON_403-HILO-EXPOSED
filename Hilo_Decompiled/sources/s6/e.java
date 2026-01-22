package s6;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements u6.b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f١٧٨٩٥d = Locale.getDefault().getDisplayLanguage().contains("中文");

    /* renamed from: a, reason: collision with root package name */
    private String f١٧٨٩٦a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٧٨٩٧b;

    /* renamed from: c, reason: collision with root package name */
    private String f١٧٨٩٨c;

    @Override // u6.b
    public String a() {
        if (f١٧٨٩٥d) {
            return this.f١٧٨٩٧b;
        }
        return this.f١٧٨٩٨c;
    }

    public void b(String str) {
        this.f١٧٨٩٦a = str;
    }

    public void c(String str) {
        this.f١٧٨٩٨c = str;
    }

    public void d(String str) {
        this.f١٧٨٩٧b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (Objects.equals(this.f١٧٨٩٦a, eVar.f١٧٨٩٦a) || Objects.equals(this.f١٧٨٩٧b, eVar.f١٧٨٩٧b) || Objects.equals(this.f١٧٨٩٨c, eVar.f١٧٨٩٨c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f١٧٨٩٦a, this.f١٧٨٩٧b, this.f١٧٨٩٨c);
    }

    public String toString() {
        return "PhoneCodeEntity{code='" + this.f١٧٨٩٦a + "', name='" + this.f١٧٨٩٧b + "', english" + this.f١٧٨٩٨c + "'}";
    }
}
