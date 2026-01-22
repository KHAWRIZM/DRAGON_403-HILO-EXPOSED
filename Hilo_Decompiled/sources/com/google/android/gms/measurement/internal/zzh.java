package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzh {
    private Long zzA;
    private long zzB;
    private String zzC;
    private int zzD;
    private int zzE;
    private long zzF;
    private String zzG;
    private byte[] zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private long zzM;
    private long zzN;
    private long zzO;
    private String zzP;
    private boolean zzQ;
    private long zzR;
    private long zzS;
    private final zzib zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private Boolean zzq;
    private long zzr;
    private List zzs;
    private String zzt;
    private boolean zzu;
    private long zzv;
    private long zzw;
    private int zzx;
    private boolean zzy;
    private Long zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzib zzibVar, String str) {
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzibVar;
        this.zzb = str;
        zzibVar.zzaW().zzg();
    }

    public final void zzA(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzn != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzn = j10;
    }

    public final long zzB() {
        this.zza.zzaW().zzg();
        return this.zzr;
    }

    public final void zzC(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzr != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzr = j10;
    }

    public final boolean zzD() {
        this.zza.zzaW().zzg();
        return this.zzo;
    }

    public final void zzE(boolean z10) {
        boolean z11;
        this.zza.zzaW().zzg();
        boolean z12 = this.zzQ;
        if (this.zzo != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzQ = z12 | z11;
        this.zzo = z10;
    }

    public final void zzF(long j10) {
        boolean z10;
        boolean z11 = false;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        this.zza.zzaW().zzg();
        boolean z12 = this.zzQ;
        if (this.zzg != j10) {
            z11 = true;
        }
        this.zzQ = z12 | z11;
        this.zzg = j10;
    }

    public final long zzG() {
        this.zza.zzaW().zzg();
        return this.zzg;
    }

    public final long zzH() {
        this.zza.zzaW().zzg();
        return this.zzR;
    }

    public final void zzI(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzR != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzR = j10;
    }

    public final long zzJ() {
        this.zza.zzaW().zzg();
        return this.zzS;
    }

    public final void zzK(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzS != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzS = j10;
    }

    public final void zzL() {
        zzib zzibVar = this.zza;
        zzibVar.zzaW().zzg();
        long j10 = this.zzg + 1;
        if (j10 > 2147483647L) {
            zzibVar.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            j10 = 0;
        }
        this.zzQ = true;
        this.zzg = j10;
    }

    public final void zzM(long j10) {
        zzib zzibVar = this.zza;
        zzibVar.zzaW().zzg();
        long j11 = this.zzg + j10;
        if (j11 > 2147483647L) {
            zzibVar.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            j11 = (-1) + j10;
        }
        long j12 = this.zzF + 1;
        if (j12 > 2147483647L) {
            zzibVar.zzaV().zze().zzb("Delivery index overflow. appId", zzgt.zzl(this.zzb));
            j12 = 0;
        }
        this.zzQ = true;
        this.zzg = j11;
        this.zzF = j12;
    }

    public final long zzN() {
        this.zza.zzaW().zzg();
        return this.zzJ;
    }

    public final void zzO(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzJ != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzJ = j10;
    }

    public final long zzP() {
        this.zza.zzaW().zzg();
        return this.zzK;
    }

    public final void zzQ(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzK != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzK = j10;
    }

    public final long zzR() {
        this.zza.zzaW().zzg();
        return this.zzL;
    }

    public final void zzS(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzL != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzL = j10;
    }

    public final long zzT() {
        this.zza.zzaW().zzg();
        return this.zzM;
    }

    public final void zzU(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzM != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzM = j10;
    }

    public final long zzV() {
        this.zza.zzaW().zzg();
        return this.zzO;
    }

    public final void zzW(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzO != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzO = j10;
    }

    public final long zzX() {
        this.zza.zzaW().zzg();
        return this.zzN;
    }

    public final void zzY(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzN != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzN = j10;
    }

    public final String zzZ() {
        this.zza.zzaW().zzg();
        return this.zzP;
    }

    public final boolean zza() {
        this.zza.zzaW().zzg();
        return this.zzQ;
    }

    public final int zzaA() {
        this.zza.zzaW().zzg();
        return this.zzD;
    }

    public final void zzaB(int i10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzD != i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzD = i10;
    }

    public final int zzaC() {
        this.zza.zzaW().zzg();
        return this.zzE;
    }

    public final void zzaD(int i10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzE != i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzE = i10;
    }

    public final void zzaE(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzF != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzF = j10;
    }

    public final long zzaF() {
        this.zza.zzaW().zzg();
        return this.zzF;
    }

    public final void zzaG(String str) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzG != str) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzG = str;
    }

    public final String zzaH() {
        this.zza.zzaW().zzg();
        return this.zzG;
    }

    public final void zzaI(byte[] bArr) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzH != bArr) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzH = bArr;
    }

    public final byte[] zzaJ() {
        this.zza.zzaW().zzg();
        return this.zzH;
    }

    public final void zzaK(int i10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzI != i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzI = i10;
    }

    public final int zzaL() {
        this.zza.zzaW().zzg();
        return this.zzI;
    }

    public final String zzaa() {
        this.zza.zzaW().zzg();
        String str = this.zzP;
        zzab(null);
        return str;
    }

    public final void zzab(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzP, str);
        this.zzP = str;
    }

    public final boolean zzac() {
        this.zza.zzaW().zzg();
        return this.zzp;
    }

    public final void zzad(boolean z10) {
        boolean z11;
        this.zza.zzaW().zzg();
        boolean z12 = this.zzQ;
        if (this.zzp != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzQ = z12 | z11;
        this.zzp = z10;
    }

    public final Boolean zzae() {
        this.zza.zzaW().zzg();
        return this.zzq;
    }

    public final void zzaf(Boolean bool) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzq, bool);
        this.zzq = bool;
    }

    public final List zzag() {
        this.zza.zzaW().zzg();
        return this.zzs;
    }

    public final void zzah(List list) {
        ArrayList arrayList;
        this.zza.zzaW().zzg();
        if (!Objects.equals(this.zzs, list)) {
            this.zzQ = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.zzs = arrayList;
        }
    }

    public final boolean zzai() {
        this.zza.zzaW().zzg();
        return this.zzu;
    }

    public final void zzaj(boolean z10) {
        boolean z11;
        this.zza.zzaW().zzg();
        boolean z12 = this.zzQ;
        if (this.zzu != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzQ = z12 | z11;
        this.zzu = z10;
    }

    public final long zzak() {
        this.zza.zzaW().zzg();
        return this.zzv;
    }

    public final void zzal(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzv != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzv = j10;
    }

    public final long zzam() {
        this.zza.zzaW().zzg();
        return this.zzw;
    }

    public final void zzan(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzw != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzw = j10;
    }

    public final int zzao() {
        this.zza.zzaW().zzg();
        return this.zzx;
    }

    public final void zzap(int i10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzx != i10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzx = i10;
    }

    public final boolean zzaq() {
        this.zza.zzaW().zzg();
        return this.zzy;
    }

    public final void zzar(boolean z10) {
        boolean z11;
        this.zza.zzaW().zzg();
        boolean z12 = this.zzQ;
        if (this.zzy != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzQ = z12 | z11;
        this.zzy = z10;
    }

    public final Long zzas() {
        this.zza.zzaW().zzg();
        return this.zzz;
    }

    public final void zzat(Long l10) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzz, l10);
        this.zzz = l10;
    }

    public final Long zzau() {
        this.zza.zzaW().zzg();
        return this.zzA;
    }

    public final void zzav(Long l10) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzA, l10);
        this.zzA = l10;
    }

    public final long zzaw() {
        this.zza.zzaW().zzg();
        return this.zzB;
    }

    public final void zzax(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzB != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzB = j10;
    }

    public final String zzay() {
        this.zza.zzaW().zzg();
        return this.zzC;
    }

    public final void zzaz(String str) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzC != str) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzC = str;
    }

    public final void zzb() {
        this.zza.zzaW().zzg();
        this.zzQ = false;
    }

    public final String zzc() {
        this.zza.zzaW().zzg();
        return this.zzb;
    }

    public final String zzd() {
        this.zza.zzaW().zzg();
        return this.zzc;
    }

    public final void zze(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzc, str);
        this.zzc = str;
    }

    public final String zzf() {
        this.zza.zzaW().zzg();
        return this.zzd;
    }

    public final void zzg(String str) {
        this.zza.zzaW().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzQ |= true ^ Objects.equals(this.zzd, str);
        this.zzd = str;
    }

    public final String zzh() {
        this.zza.zzaW().zzg();
        return this.zzt;
    }

    public final void zzi(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzt, str);
        this.zzt = str;
    }

    public final String zzj() {
        this.zza.zzaW().zzg();
        return this.zze;
    }

    public final void zzk(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zze, str);
        this.zze = str;
    }

    public final String zzl() {
        this.zza.zzaW().zzg();
        return this.zzf;
    }

    public final void zzm(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzf, str);
        this.zzf = str;
    }

    public final long zzn() {
        this.zza.zzaW().zzg();
        return this.zzh;
    }

    public final void zzo(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzh != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzh = j10;
    }

    public final long zzp() {
        this.zza.zzaW().zzg();
        return this.zzi;
    }

    public final void zzq(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzi != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzi = j10;
    }

    public final String zzr() {
        this.zza.zzaW().zzg();
        return this.zzj;
    }

    public final void zzs(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzj, str);
        this.zzj = str;
    }

    public final long zzt() {
        this.zza.zzaW().zzg();
        return this.zzk;
    }

    public final void zzu(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzk != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzk = j10;
    }

    public final String zzv() {
        this.zza.zzaW().zzg();
        return this.zzl;
    }

    public final void zzw(String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzl, str);
        this.zzl = str;
    }

    public final long zzx() {
        this.zza.zzaW().zzg();
        return this.zzm;
    }

    public final void zzy(long j10) {
        boolean z10;
        this.zza.zzaW().zzg();
        boolean z11 = this.zzQ;
        if (this.zzm != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.zzQ = z11 | z10;
        this.zzm = j10;
    }

    public final long zzz() {
        this.zza.zzaW().zzg();
        return this.zzn;
    }
}
