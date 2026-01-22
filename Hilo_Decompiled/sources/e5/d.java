package e5;

import f5.k;
import java.security.MessageDigest;
import m4.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d implements f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f١٣٨٨٧b;

    public d(Object obj) {
        this.f١٣٨٨٧b = k.d(obj);
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f١٣٨٨٧b.equals(((d) obj).f١٣٨٨٧b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f١٣٨٨٧b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f١٣٨٨٧b + '}';
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f١٣٨٨٧b.toString().getBytes(f.f١٥٩٧٢a));
    }
}
