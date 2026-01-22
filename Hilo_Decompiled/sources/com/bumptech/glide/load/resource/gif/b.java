package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import l4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements a.InterfaceC٠١٨٦a {

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f٧٤٧٤a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.b f٧٤٧٥b;

    public b(p4.d dVar, p4.b bVar) {
        this.f٧٤٧٤a = dVar;
        this.f٧٤٧٥b = bVar;
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public void a(Bitmap bitmap) {
        this.f٧٤٧٤a.d(bitmap);
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public byte[] b(int i10) {
        p4.b bVar = this.f٧٤٧٥b;
        if (bVar == null) {
            return new byte[i10];
        }
        return (byte[]) bVar.c(i10, byte[].class);
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public Bitmap c(int i10, int i11, Bitmap.Config config) {
        return this.f٧٤٧٤a.g(i10, i11, config);
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public int[] d(int i10) {
        p4.b bVar = this.f٧٤٧٥b;
        if (bVar == null) {
            return new int[i10];
        }
        return (int[]) bVar.c(i10, int[].class);
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public void e(byte[] bArr) {
        p4.b bVar = this.f٧٤٧٥b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // l4.a.InterfaceC٠١٨٦a
    public void f(int[] iArr) {
        p4.b bVar = this.f٧٤٧٥b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
