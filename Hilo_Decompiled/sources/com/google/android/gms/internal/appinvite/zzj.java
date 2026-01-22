package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzj extends zze {
    private final /* synthetic */ zzg zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(zzg zzgVar) {
        this.zzk = zzgVar;
    }

    @Override // com.google.android.gms.internal.appinvite.zze, com.google.android.gms.internal.appinvite.zzo
    public final void zza(Status status) throws RemoteException {
        this.zzk.setResult((zzg) status);
    }
}
