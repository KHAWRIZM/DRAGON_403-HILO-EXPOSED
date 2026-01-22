package v4;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g0 extends g {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f١٨٤٩٧c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(m4.f.f١٥٩٧٢a);

    /* renamed from: b, reason: collision with root package name */
    private final int f١٨٤٩٨b;

    public g0(int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f5.k.a(z10, "roundingRadius must be greater than 0.");
        this.f١٨٤٩٨b = i10;
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (!(obj instanceof g0) || this.f١٨٤٩٨b != ((g0) obj).f١٨٤٩٨b) {
            return false;
        }
        return true;
    }

    @Override // m4.f
    public int hashCode() {
        return f5.l.p(-569625254, f5.l.o(this.f١٨٤٩٨b));
    }

    @Override // v4.g
    protected Bitmap transform(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        return i0.p(dVar, bitmap, this.f١٨٤٩٨b);
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f١٨٤٩٧c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f١٨٤٩٨b).array());
    }
}
