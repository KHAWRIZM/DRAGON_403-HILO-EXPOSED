package v4;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class l extends g {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f١٨٥١٧b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(m4.f.f١٥٩٧٢a);

    @Override // m4.f
    public boolean equals(Object obj) {
        return obj instanceof l;
    }

    @Override // m4.f
    public int hashCode() {
        return -670243078;
    }

    @Override // v4.g
    protected Bitmap transform(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        return i0.c(dVar, bitmap, i10, i11);
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f١٨٥١٧b);
    }
}
