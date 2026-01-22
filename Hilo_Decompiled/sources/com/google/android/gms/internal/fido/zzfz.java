package com.google.android.gms.internal.fido;

import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzfz extends zzfp {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfz(MessageDigest messageDigest, int i10, zzfy zzfyVar) {
        this.zza = messageDigest;
        this.zzb = i10;
    }

    private final void zzd() {
        zzbm.zzf(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.gms.internal.fido.zzfp
    protected final void zzb(byte[] bArr, int i10, int i11) {
        zzd();
        this.zza.update(bArr, 0, i11);
    }

    @Override // com.google.android.gms.internal.fido.zzfv
    public final zzft zzc() {
        zzd();
        this.zzc = true;
        int i10 = this.zzb;
        if (i10 == this.zza.getDigestLength()) {
            byte[] digest = this.zza.digest();
            int i11 = zzft.zzb;
            return new zzfs(digest);
        }
        byte[] copyOf = Arrays.copyOf(this.zza.digest(), i10);
        int i12 = zzft.zzb;
        return new zzfs(copyOf);
    }
}
