package com.bumptech.glide.integration.webp.decoder;

import java.nio.ByteBuffer;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final l f٧٣١٢a;

    public c(l lVar) {
        this.f٧٣١٢a = lVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        return this.f٧٣١٢a.d(f5.a.g(byteBuffer), i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
        return this.f٧٣١٢a.m(byteBuffer, iVar);
    }
}
