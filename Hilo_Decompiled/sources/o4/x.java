package o4;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class x implements m4.f {

    /* renamed from: j, reason: collision with root package name */
    private static final f5.h f١٦٧٤٦j = new f5.h(50);

    /* renamed from: b, reason: collision with root package name */
    private final p4.b f١٦٧٤٧b;

    /* renamed from: c, reason: collision with root package name */
    private final m4.f f١٦٧٤٨c;

    /* renamed from: d, reason: collision with root package name */
    private final m4.f f١٦٧٤٩d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٦٧٥٠e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٦٧٥١f;

    /* renamed from: g, reason: collision with root package name */
    private final Class f١٦٧٥٢g;

    /* renamed from: h, reason: collision with root package name */
    private final m4.i f١٦٧٥٣h;

    /* renamed from: i, reason: collision with root package name */
    private final m4.m f١٦٧٥٤i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p4.b bVar, m4.f fVar, m4.f fVar2, int i10, int i11, m4.m mVar, Class cls, m4.i iVar) {
        this.f١٦٧٤٧b = bVar;
        this.f١٦٧٤٨c = fVar;
        this.f١٦٧٤٩d = fVar2;
        this.f١٦٧٥٠e = i10;
        this.f١٦٧٥١f = i11;
        this.f١٦٧٥٤i = mVar;
        this.f١٦٧٥٢g = cls;
        this.f١٦٧٥٣h = iVar;
    }

    private byte[] a() {
        f5.h hVar = f١٦٧٤٦j;
        byte[] bArr = (byte[]) hVar.j(this.f١٦٧٥٢g);
        if (bArr == null) {
            byte[] bytes = this.f١٦٧٥٢g.getName().getBytes(m4.f.f١٥٩٧٢a);
            hVar.m(this.f١٦٧٥٢g, bytes);
            return bytes;
        }
        return bArr;
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f١٦٧٥١f != xVar.f١٦٧٥١f || this.f١٦٧٥٠e != xVar.f١٦٧٥٠e || !f5.l.e(this.f١٦٧٥٤i, xVar.f١٦٧٥٤i) || !this.f١٦٧٥٢g.equals(xVar.f١٦٧٥٢g) || !this.f١٦٧٤٨c.equals(xVar.f١٦٧٤٨c) || !this.f١٦٧٤٩d.equals(xVar.f١٦٧٤٩d) || !this.f١٦٧٥٣h.equals(xVar.f١٦٧٥٣h)) {
            return false;
        }
        return true;
    }

    @Override // m4.f
    public int hashCode() {
        int hashCode = (((((this.f١٦٧٤٨c.hashCode() * 31) + this.f١٦٧٤٩d.hashCode()) * 31) + this.f١٦٧٥٠e) * 31) + this.f١٦٧٥١f;
        m4.m mVar = this.f١٦٧٥٤i;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.f١٦٧٥٢g.hashCode()) * 31) + this.f١٦٧٥٣h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f١٦٧٤٨c + ", signature=" + this.f١٦٧٤٩d + ", width=" + this.f١٦٧٥٠e + ", height=" + this.f١٦٧٥١f + ", decodedResourceClass=" + this.f١٦٧٥٢g + ", transformation='" + this.f١٦٧٥٤i + "', options=" + this.f١٦٧٥٣h + '}';
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f١٦٧٤٧b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f١٦٧٥٠e).putInt(this.f١٦٧٥١f).array();
        this.f١٦٧٤٩d.updateDiskCacheKey(messageDigest);
        this.f١٦٧٤٨c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        m4.m mVar = this.f١٦٧٥٤i;
        if (mVar != null) {
            mVar.updateDiskCacheKey(messageDigest);
        }
        this.f١٦٧٥٣h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.f١٦٧٤٧b.put(bArr);
    }
}
