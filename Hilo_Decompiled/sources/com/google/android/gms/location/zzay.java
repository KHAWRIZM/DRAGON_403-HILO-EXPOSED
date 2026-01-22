package com.google.android.gms.location;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzay extends com.google.android.gms.internal.location.zza implements zzba {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzba
    public final void zzd(LocationResult locationResult) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.location.zzba
    public final void zze(LocationAvailability locationAvailability) throws RemoteException {
        throw null;
    }
}
