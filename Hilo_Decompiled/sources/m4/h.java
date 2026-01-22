package m4;

import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    private static final b f١٥٩٧٤e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٥٩٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private final b f١٥٩٧٦b;

    /* renamed from: c, reason: collision with root package name */
    private final String f١٥٩٧٧c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f١٥٩٧٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    private h(String str, Object obj, b bVar) {
        this.f١٥٩٧٧c = f5.k.b(str);
        this.f١٥٩٧٥a = obj;
        this.f١٥٩٧٦b = (b) f5.k.d(bVar);
    }

    public static h a(String str, Object obj, b bVar) {
        return new h(str, obj, bVar);
    }

    private static b b() {
        return f١٥٩٧٤e;
    }

    private byte[] d() {
        if (this.f١٥٩٧٨d == null) {
            this.f١٥٩٧٨d = this.f١٥٩٧٧c.getBytes(f.f١٥٩٧٢a);
        }
        return this.f١٥٩٧٨d;
    }

    public static h e(String str) {
        return new h(str, null, b());
    }

    public static h f(String str, Object obj) {
        return new h(str, obj, b());
    }

    public Object c() {
        return this.f١٥٩٧٥a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f١٥٩٧٧c.equals(((h) obj).f١٥٩٧٧c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.f١٥٩٧٦b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.f١٥٩٧٧c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f١٥٩٧٧c + "'}";
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements b {
        a() {
        }

        @Override // m4.h.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }
}
