package com.bumptech.glide.integration.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpImage;
import java.nio.ByteBuffer;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements m4.k {

    /* renamed from: d, reason: collision with root package name */
    public static final m4.h f٧٣١٣d = m4.h.f("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    private final Context f٧٣١٤a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.d f٧٣١٥b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f٧٣١٦c;

    public d(Context context, p4.b bVar, p4.d dVar) {
        this.f٧٣١٤a = context.getApplicationContext();
        this.f٧٣١٥b = dVar;
        this.f٧٣١٦c = new com.bumptech.glide.load.resource.gif.b(dVar, bVar);
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        WebpImage create = WebpImage.create(bArr);
        j jVar = new j(this.f٧٣١٦c, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i10, i11), (q) iVar.a(r.f٧٣٧١s));
        jVar.b();
        Bitmap a10 = jVar.a();
        if (a10 == null) {
            return null;
        }
        return new o(new m(this.f٧٣١٤a, jVar, this.f٧٣١٥b, com.bumptech.glide.load.resource.l.a(), i10, i11, a10));
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣١٣d)).booleanValue()) {
            return false;
        }
        return com.bumptech.glide.integration.webp.b.e(com.bumptech.glide.integration.webp.b.c(byteBuffer));
    }
}
