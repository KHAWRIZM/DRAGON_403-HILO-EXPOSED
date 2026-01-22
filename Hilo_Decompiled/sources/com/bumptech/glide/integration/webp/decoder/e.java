package com.bumptech.glide.integration.webp.decoder;

import java.io.InputStream;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final a f٧٣١٧a;

    public e(a aVar) {
        this.f٧٣١٧a = aVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(InputStream inputStream, int i10, int i11, m4.i iVar) {
        return this.f٧٣١٧a.a(inputStream, i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(InputStream inputStream, m4.i iVar) {
        return this.f٧٣١٧a.c(inputStream, iVar);
    }
}
