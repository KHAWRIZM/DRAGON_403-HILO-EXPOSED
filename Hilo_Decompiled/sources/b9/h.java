package b9;

import java.nio.charset.StandardCharsets;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f٥٥٥٢a;

    /* renamed from: b, reason: collision with root package name */
    private l f٥٥٥٣b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f٥٥٥٤c;

    /* renamed from: d, reason: collision with root package name */
    int f٥٥٥٥d;

    /* renamed from: e, reason: collision with root package name */
    private int f٥٥٥٦e;

    /* renamed from: f, reason: collision with root package name */
    private k f٥٥٥٧f;

    /* renamed from: g, reason: collision with root package name */
    private int f٥٥٥٨g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & UByte.MAX_VALUE);
            if (c10 == '?' && str.charAt(i10) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c10);
        }
        this.f٥٥٥٢a = sb.toString();
        this.f٥٥٥٣b = l.FORCE_NONE;
        this.f٥٥٥٤c = new StringBuilder(str.length());
        this.f٥٥٥٦e = -1;
    }

    private int h() {
        return this.f٥٥٥٢a.length() - this.f٥٥٥٨g;
    }

    public int a() {
        return this.f٥٥٥٤c.length();
    }

    public StringBuilder b() {
        return this.f٥٥٥٤c;
    }

    public char c() {
        return this.f٥٥٥٢a.charAt(this.f٥٥٥٥d);
    }

    public String d() {
        return this.f٥٥٥٢a;
    }

    public int e() {
        return this.f٥٥٥٦e;
    }

    public int f() {
        return h() - this.f٥٥٥٥d;
    }

    public k g() {
        return this.f٥٥٥٧f;
    }

    public boolean i() {
        if (this.f٥٥٥٥d < h()) {
            return true;
        }
        return false;
    }

    public void j() {
        this.f٥٥٥٦e = -1;
    }

    public void k() {
        this.f٥٥٥٧f = null;
    }

    public void m(int i10) {
        this.f٥٥٥٨g = i10;
    }

    public void n(l lVar) {
        this.f٥٥٥٣b = lVar;
    }

    public void o(int i10) {
        this.f٥٥٥٦e = i10;
    }

    public void p() {
        q(a());
    }

    public void q(int i10) {
        k kVar = this.f٥٥٥٧f;
        if (kVar == null || i10 > kVar.a()) {
            this.f٥٥٥٧f = k.l(i10, this.f٥٥٥٣b, null, null, true);
        }
    }

    public void r(char c10) {
        this.f٥٥٥٤c.append(c10);
    }

    public void s(String str) {
        this.f٥٥٥٤c.append(str);
    }

    public void l(v8.b bVar, v8.b bVar2) {
    }
}
