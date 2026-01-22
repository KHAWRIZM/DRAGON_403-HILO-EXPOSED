package com.google.android.gms.internal.appinvite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzs extends zzb implements zzq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appinvite.internal.IAppInviteService");
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zza(zzo zzoVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzoVar);
        zza.writeString(str);
        zza(1, zza);
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zzb(zzo zzoVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzoVar);
        zza.writeString(str);
        zza(2, zza);
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zza(zzo zzoVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzoVar);
        zza(3, zza);
    }
}
