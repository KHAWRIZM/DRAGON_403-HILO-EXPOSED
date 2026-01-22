package o4;

import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d implements m4.f {

    /* renamed from: b, reason: collision with root package name */
    private final m4.f f١٦٥٥٩b;

    /* renamed from: c, reason: collision with root package name */
    private final m4.f f١٦٥٦٠c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(m4.f fVar, m4.f fVar2) {
        this.f١٦٥٥٩b = fVar;
        this.f١٦٥٦٠c = fVar2;
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f١٦٥٥٩b.equals(dVar.f١٦٥٥٩b) || !this.f١٦٥٦٠c.equals(dVar.f١٦٥٦٠c)) {
            return false;
        }
        return true;
    }

    @Override // m4.f
    public int hashCode() {
        return (this.f١٦٥٥٩b.hashCode() * 31) + this.f١٦٥٦٠c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f١٦٥٥٩b + ", signature=" + this.f١٦٥٦٠c + '}';
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f١٦٥٥٩b.updateDiskCacheKey(messageDigest);
        this.f١٦٥٦٠c.updateDiskCacheKey(messageDigest);
    }
}
