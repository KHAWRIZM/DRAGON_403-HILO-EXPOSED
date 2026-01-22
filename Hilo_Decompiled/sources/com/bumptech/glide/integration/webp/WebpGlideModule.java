package com.bumptech.glide.integration.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.g;
import com.bumptech.glide.integration.webp.decoder.c;
import com.bumptech.glide.integration.webp.decoder.e;
import com.bumptech.glide.integration.webp.decoder.f;
import com.bumptech.glide.integration.webp.decoder.l;
import com.bumptech.glide.integration.webp.decoder.m;
import com.bumptech.glide.integration.webp.decoder.n;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p4.d;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class WebpGlideModule implements a5.b {
    @Override // a5.b
    public void applyOptions(Context context, com.bumptech.glide.b bVar) {
    }

    @Override // a5.b
    public void registerComponents(Context context, Glide glide, g gVar) {
        Resources resources = context.getResources();
        d bitmapPool = glide.getBitmapPool();
        p4.b arrayPool = glide.getArrayPool();
        l lVar = new l(gVar.g(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        com.bumptech.glide.integration.webp.decoder.a aVar = new com.bumptech.glide.integration.webp.decoder.a(arrayPool, bitmapPool);
        c cVar = new c(lVar);
        f fVar = new f(lVar, arrayPool);
        com.bumptech.glide.integration.webp.decoder.d dVar = new com.bumptech.glide.integration.webp.decoder.d(context, arrayPool, bitmapPool);
        gVar.q("Bitmap", ByteBuffer.class, Bitmap.class, cVar).q("Bitmap", InputStream.class, Bitmap.class, fVar).q("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new v4.a(resources, cVar)).q("BitmapDrawable", InputStream.class, BitmapDrawable.class, new v4.a(resources, fVar)).q("Bitmap", ByteBuffer.class, Bitmap.class, new com.bumptech.glide.integration.webp.decoder.b(aVar)).q("Bitmap", InputStream.class, Bitmap.class, new e(aVar)).o(ByteBuffer.class, m.class, dVar).o(InputStream.class, m.class, new com.bumptech.glide.integration.webp.decoder.g(dVar, arrayPool)).p(m.class, new n());
    }
}
