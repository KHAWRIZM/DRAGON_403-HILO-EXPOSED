package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzik extends zzme implements zznm {
    private static final zzik zzf;
    private int zzb;
    private int zzd;
    private zzmm zze = zzme.zzct();

    static {
        zzik zzikVar = new zzik();
        zzf = zzikVar;
        zzme.zzcp(zzik.class, zzikVar);
    }

    private zzik() {
    }

    public static zzij zzf() {
        return (zzij) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final long zze(int i10) {
        return this.zze.zzc(i10);
    }

    public final /* synthetic */ void zzg(int i10) {
        this.zzb |= 1;
        this.zzd = i10;
    }

    public final /* synthetic */ void zzh(Iterable iterable) {
        zzmm zzmmVar = this.zze;
        if (!zzmmVar.zza()) {
            this.zze = zzme.zzcu(zzmmVar);
        }
        zzkr.zzce(iterable, this.zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 == 5) {
                            return zzf;
                        }
                        throw null;
                    }
                    return new zzij(null);
                }
                return new zzik();
            }
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        return (byte) 1;
    }
}
