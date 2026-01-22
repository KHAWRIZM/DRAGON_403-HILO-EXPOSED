package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcv extends zzbl implements zzcx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final void zze() throws RemoteException {
        zzd(2, zza());
    }
}
