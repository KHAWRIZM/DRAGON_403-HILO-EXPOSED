package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzgf extends com.google.android.gms.internal.measurement.zzbm implements zzgg {
    public zzgf() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 2) {
            zzop zzopVar = (zzop) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzop.CREATOR);
            com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
            zze(zzopVar);
            return true;
        }
        return false;
    }
}
