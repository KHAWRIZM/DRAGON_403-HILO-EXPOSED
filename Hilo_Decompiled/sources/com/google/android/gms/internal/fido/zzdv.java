package com.google.android.gms.internal.fido;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzdv {
    private static final zzdz zza = new zzds();
    private static final zzdy zzb = new zzdt();
    private final zzdz zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzdy zzf = null;

    public final zzdv zza(zzdy zzdyVar) {
        this.zzf = zzdyVar;
        return this;
    }

    public final zzea zzd() {
        return new zzdx(this, null);
    }

    public final void zzg(zzdk zzdkVar) {
        zzfk.zza(zzdkVar, TransferTable.COLUMN_KEY);
        if (zzdkVar.zzb()) {
            zzdy zzdyVar = zzb;
            zzfk.zza(zzdkVar, TransferTable.COLUMN_KEY);
            if (zzdkVar.zzb()) {
                this.zzc.remove(zzdkVar);
                this.zzd.put(zzdkVar, zzdyVar);
                return;
            }
            throw new IllegalArgumentException("key must be repeating");
        }
        zzdz zzdzVar = zza;
        zzfk.zza(zzdkVar, TransferTable.COLUMN_KEY);
        this.zzd.remove(zzdkVar);
        this.zzc.put(zzdkVar, zzdzVar);
    }
}
