package b0;

import java.io.EOFException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final long f٥٢٩٧a;

    /* renamed from: b, reason: collision with root package name */
    public long f٥٢٩٨b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f٥٢٩٩c;

    public a(b bVar, long j10) {
        this.f٥٢٩٩c = bVar;
        this.f٥٢٩٧a = j10;
    }

    @Override // b0.d
    public final int a() {
        return (int) Math.min(this.f٥٢٩٧a - this.f٥٢٩٨b, this.f٥٢٩٩c.f٥٣٠٧c.bitsAvailable() / 8);
    }

    @Override // b0.d
    public final int b(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        if (i11 == 0) {
            return 0;
        }
        int min = (int) Math.min(this.f٥٢٩٧a - this.f٥٢٩٨b, i11);
        while (i12 < min) {
            int i13 = 1;
            if (this.f٥٢٩٩c.f٥٣٠٧c.bitsCached() > 0) {
                byte b10 = (byte) b.b(this.f٥٢٩٩c.f٥٣٠٧c, 8);
                int i14 = i10 + i12;
                f fVar = this.f٥٢٩٩c.f٥٣٠٩e;
                byte[] bArr2 = fVar.f٥٣١٨a;
                int i15 = fVar.f٥٣١٩b;
                bArr2[i15] = b10;
                int i16 = 65535 & (i15 + 1);
                if (!fVar.f٥٣٢٠c && i16 < i15) {
                    fVar.f٥٣٢٠c = true;
                }
                fVar.f٥٣١٩b = i16;
                bArr[i14] = b10;
            } else {
                int i17 = i10 + i12;
                int read = this.f٥٢٩٩c.f٥٣٠٨d.read(bArr, i17, min - i12);
                if (read != -1) {
                    f fVar2 = this.f٥٢٩٩c.f٥٣٠٩e;
                    for (int i18 = i17; i18 < i17 + read; i18++) {
                        byte b11 = bArr[i18];
                        byte[] bArr3 = fVar2.f٥٣١٨a;
                        int i19 = fVar2.f٥٣١٩b;
                        bArr3[i19] = b11;
                        int i20 = (i19 + 1) & 65535;
                        if (!fVar2.f٥٣٢٠c && i20 < i19) {
                            fVar2.f٥٣٢٠c = true;
                        }
                        fVar2.f٥٣١٩b = i20;
                    }
                    i13 = read;
                } else {
                    throw new EOFException("Truncated Deflate64 Stream");
                }
            }
            this.f٥٢٩٨b += i13;
            i12 += i13;
        }
        return min;
    }

    @Override // b0.d
    public final int c() {
        if (this.f٥٢٩٨b < this.f٥٢٩٧a) {
            return 2;
        }
        return 1;
    }

    @Override // b0.d
    public final boolean d() {
        if (this.f٥٢٩٨b < this.f٥٢٩٧a) {
            return true;
        }
        return false;
    }
}
