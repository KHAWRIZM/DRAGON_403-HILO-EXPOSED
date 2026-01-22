package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzll extends zzky {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzll.class.getName());
    private static final boolean zzd = zzoo.zza();
    zzlm zza;

    private zzll() {
        throw null;
    }

    public static int zzA(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzor.zzb(str);
        } catch (zzoq unused) {
            length = str.getBytes(zzmo.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzC(zznl zznlVar) {
        int zzcn = zznlVar.zzcn();
        return zzz(zzcn) + zzcn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzD(zznl zznlVar, zznw zznwVar) {
        int zzcd = ((zzkr) zznlVar).zzcd(zznwVar);
        return zzz(zzcd) + zzcd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzG(int i10, zznl zznlVar, zznw zznwVar) {
        int zzz = zzz(i10 << 3);
        return zzz + zzz + ((zzkr) zznlVar).zzcd(zznwVar);
    }

    public static int zzz(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, zzoq zzoqVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzoqVar);
        byte[] bytes = str.getBytes(zzmo.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzlk(e10);
        }
    }

    public abstract void zza(int i10, int i11) throws IOException;

    public abstract void zzb(int i10, int i11) throws IOException;

    public abstract void zzc(int i10, int i11) throws IOException;

    public abstract void zzd(int i10, int i11) throws IOException;

    public abstract void zze(int i10, long j10) throws IOException;

    public abstract void zzf(int i10, long j10) throws IOException;

    public abstract void zzg(int i10, boolean z10) throws IOException;

    public abstract void zzh(int i10, String str) throws IOException;

    public abstract void zzi(int i10, zzlg zzlgVar) throws IOException;

    public abstract void zzj(zzlg zzlgVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i10, int i11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(int i10, zznl zznlVar, zznw zznwVar) throws IOException;

    public abstract void zzm(int i10, zznl zznlVar) throws IOException;

    public abstract void zzn(int i10, zzlg zzlgVar) throws IOException;

    public abstract void zzo(zznl zznlVar) throws IOException;

    public abstract void zzp(byte b10) throws IOException;

    public abstract void zzq(int i10) throws IOException;

    public abstract void zzr(int i10) throws IOException;

    public abstract void zzs(int i10) throws IOException;

    public abstract void zzt(long j10) throws IOException;

    public abstract void zzu(long j10) throws IOException;

    public abstract void zzw(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void zzx(String str) throws IOException;

    public abstract int zzy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzll(byte[] bArr) {
    }
}
