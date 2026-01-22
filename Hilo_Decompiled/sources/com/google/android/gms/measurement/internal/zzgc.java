package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzgc extends com.google.android.gms.internal.measurement.zzbm implements zzgd {
    public zzgc() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 2) {
            ArrayList createTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
            com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
            zze(createTypedArrayList);
            return true;
        }
        return false;
    }
}
