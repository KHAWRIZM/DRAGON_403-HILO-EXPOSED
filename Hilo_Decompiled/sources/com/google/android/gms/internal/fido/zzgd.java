package com.google.android.gms.internal.fido;

import java.io.IOException;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzgd extends zzge {
    private zzgd(zzgb zzgbVar, Character ch) {
        super(zzgbVar, ch);
        char[] cArr;
        cArr = zzgbVar.zzf;
        zzbm.zzc(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzge
    final zzgf zza(zzgb zzgbVar, Character ch) {
        return new zzgd(zzgbVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzge, com.google.android.gms.internal.fido.zzgf
    final void zzb(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        zzbm.zze(0, i11, bArr.length);
        for (int i13 = i11; i13 >= 3; i13 -= 3) {
            int i14 = bArr[i12] & UByte.MAX_VALUE;
            int i15 = ((bArr[i12 + 1] & UByte.MAX_VALUE) << 8) | (i14 << 16) | (bArr[i12 + 2] & UByte.MAX_VALUE);
            appendable.append(this.zzb.zza(i15 >>> 18));
            appendable.append(this.zzb.zza((i15 >>> 12) & 63));
            appendable.append(this.zzb.zza((i15 >>> 6) & 63));
            appendable.append(this.zzb.zza(i15 & 63));
            i12 += 3;
        }
        if (i12 < i11) {
            zze(appendable, bArr, i12, i11 - i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgd(String str, String str2, Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
