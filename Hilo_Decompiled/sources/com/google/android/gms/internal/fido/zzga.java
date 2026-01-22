package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzga extends zzfq implements Serializable {
    private final MessageDigest zza;
    private final int zzb;
    private final boolean zzc;
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(String str, String str2) {
        MessageDigest zzb = zzb("SHA-256");
        this.zza = zzb;
        this.zzb = zzb.getDigestLength();
        this.zzd = "Hashing.sha256()";
        this.zzc = zzc(zzb);
    }

    private static MessageDigest zzb(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    private static boolean zzc(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public final String toString() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzfu
    public final zzfv zza() {
        zzfy zzfyVar = null;
        if (this.zzc) {
            try {
                return new zzfz((MessageDigest) this.zza.clone(), this.zzb, zzfyVar);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new zzfz(zzb(this.zza.getAlgorithm()), this.zzb, zzfyVar);
    }
}
