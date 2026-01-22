package com.bumptech.glide.integration.webp.decoder;

import java.nio.ByteBuffer;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final a f٧٣١١a;

    public b(a aVar) {
        this.f٧٣١١a = aVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        return this.f٧٣١١a.b(byteBuffer, i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
        return this.f٧٣١١a.d(byteBuffer, iVar);
    }
}
