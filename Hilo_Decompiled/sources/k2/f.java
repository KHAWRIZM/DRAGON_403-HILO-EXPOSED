package k2;

import android.util.Base64;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٥٤٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٥٤٤٥b;

    /* renamed from: c, reason: collision with root package name */
    private final String f١٥٤٤٦c;

    /* renamed from: d, reason: collision with root package name */
    private final List f١٥٤٤٧d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٥٤٤٨e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f١٥٤٤٩f;

    public f(String str, String str2, String str3, List list) {
        this.f١٥٤٤٤a = (String) androidx.core.util.h.g(str);
        this.f١٥٤٤٥b = (String) androidx.core.util.h.g(str2);
        this.f١٥٤٤٦c = (String) androidx.core.util.h.g(str3);
        this.f١٥٤٤٧d = (List) androidx.core.util.h.g(list);
        this.f١٥٤٤٩f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f١٥٤٤٧d;
    }

    public int c() {
        return this.f١٥٤٤٨e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f١٥٤٤٩f;
    }

    public String e() {
        return this.f١٥٤٤٤a;
    }

    public String f() {
        return this.f١٥٤٤٥b;
    }

    public String g() {
        return this.f١٥٤٤٦c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f١٥٤٤٤a + ", mProviderPackage: " + this.f١٥٤٤٥b + ", mQuery: " + this.f١٥٤٤٦c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f١٥٤٤٧d.size(); i10++) {
            sb.append(" [");
            List list = (List) this.f١٥٤٤٧d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f١٥٤٤٨e);
        return sb.toString();
    }
}
