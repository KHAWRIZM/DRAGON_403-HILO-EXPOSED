package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import java.security.MessageDigest;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class p implements m4.m {

    /* renamed from: b, reason: collision with root package name */
    private final m4.m f٧٣٥٨b;

    public p(m4.m mVar) {
        this.f٧٣٥٨b = (m4.m) f5.k.d(mVar);
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f٧٣٥٨b.equals(((p) obj).f٧٣٥٨b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f٧٣٥٨b.hashCode();
    }

    @Override // m4.m
    public v transform(Context context, v vVar, int i10, int i11) {
        m mVar = (m) vVar.getEntity();
        v fVar = new v4.f(mVar.e(), Glide.get(context).getBitmapPool());
        v transform = this.f٧٣٥٨b.transform(context, fVar, i10, i11);
        if (!fVar.equals(transform)) {
            fVar.recycle();
        }
        mVar.n(this.f٧٣٥٨b, (Bitmap) transform.getEntity());
        return vVar;
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f٧٣٥٨b.updateDiskCacheKey(messageDigest);
    }
}
