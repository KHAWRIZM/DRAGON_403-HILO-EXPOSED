package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class zzge extends zzgf {
    private volatile zzgf zza;
    final zzgb zzb;
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(zzgb zzgbVar, Character ch) {
        this.zzb = zzgbVar;
        if (ch != null && zzgbVar.zzc('=')) {
            throw new IllegalArgumentException(zzbo.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzge) {
            zzge zzgeVar = (zzge) obj;
            if (this.zzb.equals(zzgeVar.zzb) && Objects.equals(this.zzc, zzgeVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    zzgf zza(zzgb zzgbVar, Character ch) {
        return new zzge(zzgbVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    void zzb(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        zzbm.zze(0, i11, bArr.length);
        while (i12 < i11) {
            zze(appendable, bArr, i12, Math.min(this.zzb.zzd, i11 - i12));
            i12 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    final int zzc(int i10) {
        zzgb zzgbVar = this.zzb;
        return zzgbVar.zzc * zzgh.zza(i10, zzgbVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.fido.zzgf
    public final zzgf zzd() {
        zzgf zzgfVar = this.zza;
        if (zzgfVar == null) {
            zzgb zzgbVar = this.zzb;
            zzgb zzb = zzgbVar.zzb();
            if (zzb == zzgbVar) {
                zzgfVar = this;
            } else {
                zzgfVar = zza(zzb, this.zzc);
            }
            this.zza = zzgfVar;
        }
        return zzgfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
        boolean z10;
        zzbm.zze(i10, i10 + i11, bArr.length);
        int i12 = 0;
        if (i11 <= this.zzb.zzd) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzbm.zzc(z10);
        long j10 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            j10 = (j10 | (bArr[i10 + i13] & UByte.MAX_VALUE)) << 8;
        }
        int i14 = (i11 + 1) * 8;
        zzgb zzgbVar = this.zzb;
        while (i12 < i11 * 8) {
            long j11 = j10 >>> ((i14 - zzgbVar.zzb) - i12);
            zzgb zzgbVar2 = this.zzb;
            appendable.append(zzgbVar2.zza(zzgbVar2.zza & ((int) j11)));
            i12 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i12 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i12 += this.zzb.zzb;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(String str, String str2, Character ch) {
        this(new zzgb(str, str2.toCharArray()), ch);
    }
}
