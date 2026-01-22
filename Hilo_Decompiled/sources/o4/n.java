package o4;

import java.security.MessageDigest;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class n implements m4.f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f١٦٧٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٦٧٠١c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٦٧٠٢d;

    /* renamed from: e, reason: collision with root package name */
    private final Class f١٦٧٠٣e;

    /* renamed from: f, reason: collision with root package name */
    private final Class f١٦٧٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private final m4.f f١٦٧٠٥g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f١٦٧٠٦h;

    /* renamed from: i, reason: collision with root package name */
    private final m4.i f١٦٧٠٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٦٧٠٨j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Object obj, m4.f fVar, int i10, int i11, Map map, Class cls, Class cls2, m4.i iVar) {
        this.f١٦٧٠٠b = f5.k.d(obj);
        this.f١٦٧٠٥g = (m4.f) f5.k.e(fVar, "Signature must not be null");
        this.f١٦٧٠١c = i10;
        this.f١٦٧٠٢d = i11;
        this.f١٦٧٠٦h = (Map) f5.k.d(map);
        this.f١٦٧٠٣e = (Class) f5.k.e(cls, "Resource class must not be null");
        this.f١٦٧٠٤f = (Class) f5.k.e(cls2, "Transcode class must not be null");
        this.f١٦٧٠٧i = (m4.i) f5.k.d(iVar);
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f١٦٧٠٠b.equals(nVar.f١٦٧٠٠b) || !this.f١٦٧٠٥g.equals(nVar.f١٦٧٠٥g) || this.f١٦٧٠٢d != nVar.f١٦٧٠٢d || this.f١٦٧٠١c != nVar.f١٦٧٠١c || !this.f١٦٧٠٦h.equals(nVar.f١٦٧٠٦h) || !this.f١٦٧٠٣e.equals(nVar.f١٦٧٠٣e) || !this.f١٦٧٠٤f.equals(nVar.f١٦٧٠٤f) || !this.f١٦٧٠٧i.equals(nVar.f١٦٧٠٧i)) {
            return false;
        }
        return true;
    }

    @Override // m4.f
    public int hashCode() {
        if (this.f١٦٧٠٨j == 0) {
            int hashCode = this.f١٦٧٠٠b.hashCode();
            this.f١٦٧٠٨j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f١٦٧٠٥g.hashCode()) * 31) + this.f١٦٧٠١c) * 31) + this.f١٦٧٠٢d;
            this.f١٦٧٠٨j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f١٦٧٠٦h.hashCode();
            this.f١٦٧٠٨j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f١٦٧٠٣e.hashCode();
            this.f١٦٧٠٨j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f١٦٧٠٤f.hashCode();
            this.f١٦٧٠٨j = hashCode5;
            this.f١٦٧٠٨j = (hashCode5 * 31) + this.f١٦٧٠٧i.hashCode();
        }
        return this.f١٦٧٠٨j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f١٦٧٠٠b + ", width=" + this.f١٦٧٠١c + ", height=" + this.f١٦٧٠٢d + ", resourceClass=" + this.f١٦٧٠٣e + ", transcodeClass=" + this.f١٦٧٠٤f + ", signature=" + this.f١٦٧٠٥g + ", hashCode=" + this.f١٦٧٠٨j + ", transformations=" + this.f١٦٧٠٦h + ", options=" + this.f١٦٧٠٧i + '}';
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
