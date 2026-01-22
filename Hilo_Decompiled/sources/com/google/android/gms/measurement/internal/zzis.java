package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzis implements Callable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzjc zzjcVar, zzbg zzbgVar, String str) {
        this.zza = zzbgVar;
        this.zzb = str;
        Objects.requireNonNull(zzjcVar);
        this.zzc = zzjcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlo zzloVar;
        byte[] bArr;
        zzpf zzpfVar;
        zzpm zzpmVar;
        zzpf zzpfVar2;
        zzh zzhVar;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        Bundle bundle;
        String str;
        zzib zzibVar;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        String str2;
        Object obj;
        zzbc zza;
        long j10;
        zzav zzj;
        zzjc zzjcVar = this.zzc;
        zzjcVar.zzL().zzY();
        zzlo zzn = zzjcVar.zzL().zzn();
        zzn.zzg();
        zzib zzibVar2 = zzn.zzu;
        zzib.zzL();
        zzbg zzbgVar = this.zza;
        Preconditions.checkNotNull(zzbgVar);
        String str3 = this.zzb;
        Preconditions.checkNotEmpty(str3);
        String str4 = zzbgVar.zza;
        if (!"_iap".equals(str4) && !"_iapx".equals(str4)) {
            zzn.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str3, str4);
            return null;
        }
        zzpf zzpfVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzh = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpfVar3.zzj().zzb();
        try {
            zzh zzu = zzpfVar3.zzj().zzu(str3);
            if (zzu == null) {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
            } else if (!zzu.zzD()) {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
            } else {
                com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                zzaE.zza(1);
                zzaE.zzC("android");
                if (!TextUtils.isEmpty(zzu.zzc())) {
                    zzaE.zzL(zzu.zzc());
                }
                if (!TextUtils.isEmpty(zzu.zzv())) {
                    zzaE.zzJ((String) Preconditions.checkNotNull(zzu.zzv()));
                }
                if (!TextUtils.isEmpty(zzu.zzr())) {
                    zzaE.zzM((String) Preconditions.checkNotNull(zzu.zzr()));
                }
                if (zzu.zzt() != -2147483648L) {
                    zzaE.zzaj((int) zzu.zzt());
                }
                zzaE.zzN(zzu.zzx());
                zzaE.zzar(zzu.zzB());
                String zzf = zzu.zzf();
                if (!TextUtils.isEmpty(zzf)) {
                    zzaE.zzad(zzf);
                }
                zzaE.zzay(zzu.zzak());
                zzjk zzB = zzn.zzg.zzB(str3);
                zzaE.zzY(zzu.zzz());
                if (zzibVar2.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjj.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzaE.zzam(null);
                }
                zzaE.zzat(zzB.zzk());
                if (zzB.zzo(zzjj.AD_STORAGE) && zzu.zzac()) {
                    Pair zzc = zzpfVar3.zzq().zzc(zzu.zzc(), zzB);
                    if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) zzc.first)) {
                        try {
                            zzaE.zzQ(zzlo.zzc((String) zzc.first, Long.toString(zzbgVar.zzd)));
                            Object obj2 = zzc.second;
                            if (obj2 != null) {
                                zzaE.zzT(((Boolean) obj2).booleanValue());
                            }
                        } catch (SecurityException e10) {
                            zzn.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", e10.getMessage());
                            bArr = new byte[0];
                            zzpfVar = zzn.zzg;
                            zzj = zzpfVar.zzj();
                            zzj.zzd();
                            return bArr;
                        }
                    }
                }
                zzib zzibVar3 = zzn.zzu;
                zzibVar3.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzibVar3.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzibVar3.zzu().zzb());
                zzaE.zzH(zzibVar3.zzu().zzc());
                try {
                    try {
                        if (zzB.zzo(zzjj.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                            zzaE.zzW(zzlo.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbgVar.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzu.zzl())) {
                            zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                        }
                        String zzc2 = zzu.zzc();
                        zzpf zzpfVar4 = zzn.zzg;
                        List zzn2 = zzpfVar4.zzj().zzn(zzc2);
                        Iterator it = zzn2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                zzpmVar = (zzpm) it.next();
                                if ("_lte".equals(zzpmVar.zzc)) {
                                    break;
                                }
                            } else {
                                zzpmVar = null;
                                break;
                            }
                        }
                        if (zzpmVar == null || zzpmVar.zze == null) {
                            zzpm zzpmVar2 = new zzpm(zzc2, "auto", "_lte", zzn.zzu.zzaZ().currentTimeMillis(), 0L);
                            zzn2.add(zzpmVar2);
                            zzpfVar4.zzj().zzl(zzpmVar2);
                        }
                        com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[zzn2.size()];
                        for (int i10 = 0; i10 < zzn2.size(); i10++) {
                            com.google.android.gms.internal.measurement.zzit zzm = com.google.android.gms.internal.measurement.zziu.zzm();
                            zzm.zzb(((zzpm) zzn2.get(i10)).zzc);
                            zzm.zza(((zzpm) zzn2.get(i10)).zzd);
                            zzpfVar4.zzp().zzc(zzm, ((zzpm) zzn2.get(i10)).zze);
                            zziuVarArr[i10] = (com.google.android.gms.internal.measurement.zziu) zzm.zzbc();
                        }
                        zzaE.zzq(Arrays.asList(zziuVarArr));
                        zzpf zzpfVar5 = zzn.zzg;
                        zzpfVar5.zzI(zzu, zzaE);
                        zzpfVar5.zzJ(zzu, zzaE);
                        zzgu zza2 = zzgu.zza(zzbgVar);
                        zzib zzibVar4 = zzn.zzu;
                        zzpo zzk = zzibVar4.zzk();
                        Bundle bundle2 = zza2.zzd;
                        zzk.zzI(bundle2, zzpfVar4.zzj().zzW(str3));
                        zzibVar4.zzk().zzG(zza2, zzibVar4.zzc().zzd(str3));
                        try {
                            bundle2.putLong("_c", 1L);
                            zzibVar4.zzaV().zzj().zza("Marking in-app purchase as real-time");
                            bundle2.putLong("_r", 1L);
                            String str5 = zzbgVar.zzc;
                            bundle2.putString("_o", str5);
                            if (zzibVar4.zzk().zzaa(zzaE.zzK(), zzu.zzay())) {
                                zzibVar4.zzk().zzM(bundle2, "_dbg", 1L);
                                zzibVar4.zzk().zzM(bundle2, "_r", 1L);
                            }
                            zzav zzj2 = zzpfVar4.zzj();
                            String str6 = zzbgVar.zza;
                            zzbc zzf2 = zzj2.zzf(str3, str6);
                            if (zzf2 == null) {
                                bundle = bundle2;
                                str = str5;
                                zzibVar = zzibVar4;
                                zzicVar = zzaE;
                                zzpfVar2 = zzpfVar4;
                                zzhzVar = zzh;
                                str2 = str3;
                                zzhVar = zzu;
                                obj = null;
                                zza = new zzbc(str3, str6, 0L, 0L, 0L, zzbgVar.zzd, 0L, null, null, null, null);
                                j10 = 0;
                            } else {
                                zzpfVar2 = zzpfVar4;
                                zzhVar = zzu;
                                zzhzVar = zzh;
                                bundle = bundle2;
                                str = str5;
                                zzibVar = zzibVar4;
                                zzicVar = zzaE;
                                str2 = str3;
                                obj = null;
                                long j11 = zzf2.zzf;
                                zza = zzf2.zza(zzbgVar.zzd);
                                j10 = j11;
                            }
                            zzpfVar2.zzj().zzh(zza);
                            try {
                                zzbb zzbbVar = new zzbb(zzn.zzu, str, str2, str6, zzbgVar.zzd, j10, bundle);
                                com.google.android.gms.internal.measurement.zzhr zzk2 = com.google.android.gms.internal.measurement.zzhs.zzk();
                                zzk2.zzo(zzbbVar.zzd);
                                zzk2.zzl(zzbbVar.zzb);
                                zzk2.zzq(zzbbVar.zze);
                                zzbe zzbeVar = zzbbVar.zzf;
                                zzbd zzbdVar = new zzbd(zzbeVar);
                                while (zzbdVar.hasNext()) {
                                    String next = zzbdVar.next();
                                    com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn3.zzb(next);
                                    Object zza3 = zzbeVar.zza(next);
                                    if (zza3 != null) {
                                        zzpfVar2.zzp().zzd(zzn3, zza3);
                                        zzk2.zzg(zzn3);
                                    }
                                }
                                zzicVar.zzg(zzk2);
                                com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                                com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                                zza5.zzb(zza.zzc);
                                zza5.zza(str6);
                                zza4.zza(zza5);
                                zzicVar.zzap(zza4);
                                zzicVar.zzaf(zzpfVar2.zzm().zzb(zzhVar.zzc(), Collections.emptyList(), zzicVar.zzk(), Long.valueOf(zzk2.zzn()), Long.valueOf(zzk2.zzn()), false));
                                if (zzk2.zzm()) {
                                    zzicVar.zzv(zzk2.zzn());
                                    zzicVar.zzx(zzk2.zzn());
                                }
                                long zzp = zzhVar.zzp();
                                if (zzp != 0) {
                                    zzicVar.zzA(zzp);
                                }
                                long zzn4 = zzhVar.zzn();
                                if (zzn4 != 0) {
                                    zzicVar.zzy(zzn4);
                                } else if (zzp != 0) {
                                    zzicVar.zzy(zzp);
                                }
                                String zzh2 = zzhVar.zzh();
                                zzqu.zza();
                                String str7 = str2;
                                if (zzibVar.zzc().zzp(str7, zzfx.zzaM) && zzh2 != null) {
                                    zzicVar.zzau(zzh2);
                                }
                                zzhVar.zzL();
                                zzicVar.zzZ((int) zzhVar.zzG());
                                zzibVar.zzc().zzi();
                                zzicVar.zzO(130000L);
                                zzicVar.zzs(zzibVar.zzaZ().currentTimeMillis());
                                zzicVar.zzae(true);
                                zzpfVar5.zzS(zzicVar.zzK(), zzicVar);
                                com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                                zzhzVar2.zze(zzicVar);
                                zzh zzhVar2 = zzhVar;
                                zzhVar2.zzo(zzicVar.zzu());
                                zzhVar2.zzq(zzicVar.zzw());
                                zzpfVar2.zzj().zzv(zzhVar2, false, false);
                                zzpfVar2.zzj().zzc();
                                zzpfVar2.zzj().zzd();
                                try {
                                    return zzpfVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbc()).zzcc());
                                } catch (IOException e11) {
                                    zzn.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgt.zzl(str7), e11);
                                    return obj;
                                }
                            } catch (Throwable th) {
                                th = th;
                                zzloVar = zzn;
                                zzloVar.zzg.zzj().zzd();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            zzloVar = zzn;
                        }
                    } catch (SecurityException e12) {
                        zzn.zzu.zzaV().zzj().zzb("app instance id encryption failed", e12.getMessage());
                        bArr = new byte[0];
                        zzpfVar = zzn.zzg;
                        zzj = zzpfVar.zzj();
                        zzj.zzd();
                        return bArr;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zzloVar = zzbgVar;
                }
            }
            zzj = zzpfVar3.zzj();
            zzj.zzd();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            zzloVar = zzn;
            zzloVar.zzg.zzj().zzd();
            throw th;
        }
    }
}
