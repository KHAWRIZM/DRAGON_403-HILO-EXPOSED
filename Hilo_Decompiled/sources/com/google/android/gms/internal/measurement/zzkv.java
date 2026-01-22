package com.google.android.gms.internal.measurement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzkv {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlq zzd;
    public int zze;

    zzkv() {
        int i10 = zzlq.zzb;
        int i11 = zznt.zza;
        this.zzd = zzlq.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zza(int i10, int i11, byte b10, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + b10 + String.valueOf(i10).length());
        sb.append(str);
        sb.append(i11);
        sb.append(str2);
        sb.append(i10);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkv(zzlq zzlqVar) {
        zzlqVar.getClass();
        this.zzd = zzlqVar;
    }
}
