package m4;

import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i implements f {

    /* renamed from: b, reason: collision with root package name */
    private final androidx.collection.a f١٥٩٧٩b = new f5.b();

    private static void e(h hVar, Object obj, MessageDigest messageDigest) {
        hVar.g(obj, messageDigest);
    }

    public Object a(h hVar) {
        if (this.f١٥٩٧٩b.containsKey(hVar)) {
            return this.f١٥٩٧٩b.get(hVar);
        }
        return hVar.c();
    }

    public void b(i iVar) {
        this.f١٥٩٧٩b.putAll((SimpleArrayMap) iVar.f١٥٩٧٩b);
    }

    public i c(h hVar) {
        this.f١٥٩٧٩b.remove(hVar);
        return this;
    }

    public i d(h hVar, Object obj) {
        this.f١٥٩٧٩b.put(hVar, obj);
        return this;
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f١٥٩٧٩b.equals(((i) obj).f١٥٩٧٩b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f١٥٩٧٩b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f١٥٩٧٩b + '}';
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f١٥٩٧٩b.getSize(); i10++) {
            e((h) this.f١٥٩٧٩b.keyAt(i10), this.f١٥٩٧٩b.valueAt(i10), messageDigest);
        }
    }
}
