package com.bumptech.glide.integration.webp.decoder;

import java.io.InputStream;
import java.nio.ByteBuffer;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements m4.k {

    /* renamed from: c, reason: collision with root package name */
    public static final m4.h f٧٣٢٠c = m4.h.f("com.bumptech.glide.integration.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    private final m4.k f٧٣٢١a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.b f٧٣٢٢b;

    public g(m4.k kVar, p4.b bVar) {
        this.f٧٣٢١a = kVar;
        this.f٧٣٢٢b = bVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(InputStream inputStream, int i10, int i11, m4.i iVar) {
        byte[] b10 = h.b(inputStream);
        if (b10 == null) {
            return null;
        }
        return this.f٧٣٢١a.decode(ByteBuffer.wrap(b10), i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(InputStream inputStream, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣٢٠c)).booleanValue()) {
            return false;
        }
        return com.bumptech.glide.integration.webp.b.e(com.bumptech.glide.integration.webp.b.b(inputStream, this.f٧٣٢٢b));
    }
}
