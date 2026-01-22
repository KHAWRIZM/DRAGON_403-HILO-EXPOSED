package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.integration.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final m4.h f٧٣٠٧d = m4.h.f("com.bumptech.glide.integration.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    private final p4.b f٧٣٠٨a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.d f٧٣٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f٧٣١٠c;

    public a(p4.b bVar, p4.d dVar) {
        this.f٧٣٠٨a = bVar;
        this.f٧٣٠٩b = dVar;
        this.f٧٣١٠c = new com.bumptech.glide.load.resource.gif.b(dVar, bVar);
    }

    public v a(InputStream inputStream, int i10, int i11, m4.i iVar) {
        byte[] b10 = h.b(inputStream);
        if (b10 == null) {
            return null;
        }
        return b(ByteBuffer.wrap(b10), i10, i11, iVar);
    }

    public v b(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        j jVar = new j(this.f٧٣١٠c, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i10, i11));
        try {
            jVar.b();
            return v4.f.b(jVar.a(), this.f٧٣٠٩b);
        } finally {
            jVar.clear();
        }
    }

    public boolean c(InputStream inputStream, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣٠٧d)).booleanValue()) {
            return false;
        }
        return com.bumptech.glide.integration.webp.b.e(com.bumptech.glide.integration.webp.b.b(inputStream, this.f٧٣٠٨a));
    }

    public boolean d(ByteBuffer byteBuffer, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣٠٧d)).booleanValue()) {
            return false;
        }
        return com.bumptech.glide.integration.webp.b.e(com.bumptech.glide.integration.webp.b.c(byteBuffer));
    }
}
