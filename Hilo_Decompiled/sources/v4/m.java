package v4;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class m extends g {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = ID.getBytes(m4.f.f١٥٩٧٢a);
    private static final int VERSION = 1;

    @Override // m4.f
    public boolean equals(Object obj) {
        return obj instanceof m;
    }

    @Override // m4.f
    public int hashCode() {
        return 1101716364;
    }

    @Override // v4.g
    protected Bitmap transform(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        return i0.d(dVar, bitmap, i10, i11);
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
