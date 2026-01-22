package com.google.android.gms.internal.appinvite;

import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzr extends zza implements zzo {
    public zzr() {
        super("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
    }

    @Override // com.google.android.gms.internal.appinvite.zza
    protected final boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            zza((Status) zzd.zza(parcel, Status.CREATOR), (Intent) zzd.zza(parcel, Intent.CREATOR));
        } else {
            zza((Status) zzd.zza(parcel, Status.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
