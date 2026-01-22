package b0;

import e0.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g extends d {

    /* renamed from: b, reason: collision with root package name */
    public final int f٥٣٢٢b;

    /* renamed from: c, reason: collision with root package name */
    public final e f٥٣٢٣c;

    /* renamed from: d, reason: collision with root package name */
    public final e f٥٣٢٤d;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f٥٣٢٨h;

    /* renamed from: a, reason: collision with root package name */
    public boolean f٥٣٢١a = false;

    /* renamed from: e, reason: collision with root package name */
    public int f٥٣٢٥e = 0;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f٥٣٢٦f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    public int f٥٣٢٧g = 0;

    public g(b bVar, int i10, int[] iArr, int[] iArr2) {
        this.f٥٣٢٨h = bVar;
        this.f٥٣٢٢b = i10;
        this.f٥٣٢٣c = b.c(iArr);
        this.f٥٣٢٤d = b.c(iArr2);
    }

    @Override // b0.d
    public final int a() {
        return this.f٥٣٢٧g - this.f٥٣٢٥e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x011b, code lost:
    
        return r5;
     */
    @Override // b0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (this.f٥٣٢١a) {
            return -1;
        }
        int i15 = this.f٥٣٢٧g - this.f٥٣٢٥e;
        if (i15 > 0) {
            i12 = Math.min(i11, i15);
            System.arraycopy(this.f٥٣٢٦f, this.f٥٣٢٥e, bArr, i10, i12);
            this.f٥٣٢٥e += i12;
        } else {
            i12 = 0;
        }
        while (true) {
            if (i12 < i11) {
                int a10 = b.a(this.f٥٣٢٨h.f٥٣٠٧c, this.f٥٣٢٣c);
                if (a10 < 256) {
                    int i16 = i12 + 1;
                    int i17 = i12 + i10;
                    f fVar = this.f٥٣٢٨h.f٥٣٠٩e;
                    byte b10 = (byte) a10;
                    byte[] bArr2 = fVar.f٥٣١٨a;
                    int i18 = fVar.f٥٣١٩b;
                    bArr2[i18] = b10;
                    int i19 = 65535 & (i18 + 1);
                    if (!fVar.f٥٣٢٠c && i19 < i18) {
                        fVar.f٥٣٢٠c = true;
                    }
                    fVar.f٥٣١٩b = i19;
                    bArr[i17] = b10;
                    i12 = i16;
                } else if (a10 > 256) {
                    int b11 = (int) (b.b(this.f٥٣٢٨h.f٥٣٠٧c, b.f٥٣٠٠f[a10 - 257] & 31) + (r6 >>> 5));
                    int b12 = (int) (b.b(this.f٥٣٢٨h.f٥٣٠٧c, b.f٥٣٠١g[b.a(this.f٥٣٢٨h.f٥٣٠٧c, this.f٥٣٢٤d)] & 15) + (r6 >>> 4));
                    if (this.f٥٣٢٦f.length < b11) {
                        this.f٥٣٢٦f = new byte[b11];
                    }
                    this.f٥٣٢٧g = b11;
                    this.f٥٣٢٥e = i14;
                    f fVar2 = this.f٥٣٢٨h.f٥٣٠٩e;
                    byte[] bArr3 = this.f٥٣٢٦f;
                    if (b12 <= fVar2.f٥٣١٨a.length) {
                        int i20 = fVar2.f٥٣١٩b;
                        int i21 = (i20 - b12) & 65535;
                        if (!fVar2.f٥٣٢٠c && i21 >= i20) {
                            throw new IllegalStateException(m.a(b12, "Attempt to read beyond memory: dist="));
                        }
                        int i22 = 0;
                        while (i22 < b11) {
                            byte[] bArr4 = fVar2.f٥٣١٨a;
                            byte b13 = bArr4[i21];
                            int i23 = fVar2.f٥٣١٩b;
                            bArr4[i23] = b13;
                            int i24 = (i23 + 1) & 65535;
                            if (!fVar2.f٥٣٢٠c && i24 < i23) {
                                fVar2.f٥٣٢٠c = true;
                            }
                            fVar2.f٥٣١٩b = i24;
                            bArr3[i22] = b13;
                            i22++;
                            int i25 = (i21 + 1) & 65535;
                            if (!fVar2.f٥٣٢٠c && i25 < i21) {
                                fVar2.f٥٣٢٠c = true;
                            }
                            i21 = i25;
                        }
                        int i26 = i10 + i12;
                        int i27 = i11 - i12;
                        int i28 = this.f٥٣٢٧g - this.f٥٣٢٥e;
                        if (i28 > 0) {
                            i13 = Math.min(i27, i28);
                            System.arraycopy(this.f٥٣٢٦f, this.f٥٣٢٥e, bArr, i26, i13);
                            this.f٥٣٢٥e += i13;
                        } else {
                            i13 = 0;
                        }
                        i12 += i13;
                        i14 = 0;
                    } else {
                        throw new IllegalStateException(m.a(b12, "Illegal distance parameter: "));
                    }
                } else {
                    this.f٥٣٢١a = true;
                    break;
                }
            } else {
                break;
            }
        }
    }

    @Override // b0.d
    public final int c() {
        if (this.f٥٣٢١a) {
            return 1;
        }
        return this.f٥٣٢٢b;
    }

    @Override // b0.d
    public final boolean d() {
        return !this.f٥٣٢١a;
    }
}
