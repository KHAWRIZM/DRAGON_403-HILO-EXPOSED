package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcy extends zzbl implements zzda {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j10) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbn.zzc(zza, bundle);
        zza.writeLong(j10);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() throws RemoteException {
        Parcel zzP = zzP(2, zza());
        int readInt = zzP.readInt();
        zzP.recycle();
        return readInt;
    }
}
