package com.google.android.gms.internal.fido;

import java.io.Serializable;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfs extends zzft implements Serializable {
    final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfs(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length >= 4) {
            return ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[2] & UByte.MAX_VALUE) << 16) | ((bArr[3] & UByte.MAX_VALUE) << 24);
        }
        throw new IllegalStateException(zzbo.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final int zzb() {
        return this.zza.length * 8;
    }

    @Override // com.google.android.gms.internal.fido.zzft
    final boolean zzc(zzft zzftVar) {
        boolean z10;
        if (this.zza.length != zzftVar.zze().length) {
            return false;
        }
        int i10 = 0;
        boolean z11 = true;
        while (true) {
            byte[] bArr = this.zza;
            if (i10 < bArr.length) {
                if (bArr[i10] == zzftVar.zze()[i10]) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
                i10++;
            } else {
                return z11;
            }
        }
    }

    @Override // com.google.android.gms.internal.fido.zzft
    public final byte[] zzd() {
        return (byte[]) this.zza.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzft
    public final byte[] zze() {
        return this.zza;
    }
}
