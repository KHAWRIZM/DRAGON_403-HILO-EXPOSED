package t4;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h implements m4.f {

    /* renamed from: b, reason: collision with root package name */
    private final i f١٨٠٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private final URL f١٨٠٥٧c;

    /* renamed from: d, reason: collision with root package name */
    private final String f١٨٠٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٨٠٥٩e;

    /* renamed from: f, reason: collision with root package name */
    private URL f١٨٠٦٠f;

    /* renamed from: g, reason: collision with root package name */
    private volatile byte[] f١٨٠٦١g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٨٠٦٢h;

    public h(URL url) {
        this(url, i.f١٨٠٦٤b);
    }

    private byte[] b() {
        if (this.f١٨٠٦١g == null) {
            this.f١٨٠٦١g = a().getBytes(m4.f.f١٥٩٧٢a);
        }
        return this.f١٨٠٦١g;
    }

    private String d() {
        if (TextUtils.isEmpty(this.f١٨٠٥٩e)) {
            String str = this.f١٨٠٥٨d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) f5.k.d(this.f١٨٠٥٧c)).toString();
            }
            this.f١٨٠٥٩e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f١٨٠٥٩e;
    }

    private URL e() {
        if (this.f١٨٠٦٠f == null) {
            this.f١٨٠٦٠f = new URL(d());
        }
        return this.f١٨٠٦٠f;
    }

    public String a() {
        String str = this.f١٨٠٥٨d;
        if (str == null) {
            return ((URL) f5.k.d(this.f١٨٠٥٧c)).toString();
        }
        return str;
    }

    public Map c() {
        return this.f١٨٠٥٦b.getHeaders();
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!a().equals(hVar.a()) || !this.f١٨٠٥٦b.equals(hVar.f١٨٠٥٦b)) {
            return false;
        }
        return true;
    }

    public String f() {
        return d();
    }

    public URL g() {
        return e();
    }

    @Override // m4.f
    public int hashCode() {
        if (this.f١٨٠٦٢h == 0) {
            int hashCode = a().hashCode();
            this.f١٨٠٦٢h = hashCode;
            this.f١٨٠٦٢h = (hashCode * 31) + this.f١٨٠٥٦b.hashCode();
        }
        return this.f١٨٠٦٢h;
    }

    public String toString() {
        return a();
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public h(String str) {
        this(str, i.f١٨٠٦٤b);
    }

    public h(URL url, i iVar) {
        this.f١٨٠٥٧c = (URL) f5.k.d(url);
        this.f١٨٠٥٨d = null;
        this.f١٨٠٥٦b = (i) f5.k.d(iVar);
    }

    public h(String str, i iVar) {
        this.f١٨٠٥٧c = null;
        this.f١٨٠٥٨d = f5.k.b(str);
        this.f١٨٠٥٦b = (i) f5.k.d(iVar);
    }
}
