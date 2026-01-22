package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import f5.k;
import java.security.MessageDigest;
import m4.m;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f implements m {

    /* renamed from: b, reason: collision with root package name */
    private final m f٧٤٨٨b;

    public f(m mVar) {
        this.f٧٤٨٨b = (m) k.d(mVar);
    }

    @Override // m4.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f٧٤٨٨b.equals(((f) obj).f٧٤٨٨b);
        }
        return false;
    }

    @Override // m4.f
    public int hashCode() {
        return this.f٧٤٨٨b.hashCode();
    }

    @Override // m4.m
    public v transform(Context context, v vVar, int i10, int i11) {
        c cVar = (c) vVar.getEntity();
        v fVar = new v4.f(cVar.e(), Glide.get(context).getBitmapPool());
        v transform = this.f٧٤٨٨b.transform(context, fVar, i10, i11);
        if (!fVar.equals(transform)) {
            fVar.recycle();
        }
        cVar.m(this.f٧٤٨٨b, (Bitmap) transform.getEntity());
        return vVar;
    }

    @Override // m4.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f٧٤٨٨b.updateDiskCacheKey(messageDigest);
    }
}
