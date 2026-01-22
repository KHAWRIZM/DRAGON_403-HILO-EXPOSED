package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzk extends zzh<AppInviteInvitationResult> {
    private final WeakReference<Activity> zzl;
    private final boolean zzm;
    private final Intent zzn;

    public zzk(zzf zzfVar, GoogleApiClient googleApiClient, Activity activity, boolean z10) {
        super(googleApiClient);
        Intent intent;
        this.zzm = z10;
        this.zzl = new WeakReference<>(activity);
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        this.zzn = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzp(status, new Intent());
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzm zzmVar) throws RemoteException {
        zzm zzmVar2 = zzmVar;
        if (AppInviteReferral.hasReferral(this.zzn)) {
            setResult((zzk) new zzp(Status.RESULT_SUCCESS, this.zzn));
            zzmVar2.zza((zzo) null);
        } else {
            zzmVar2.zza(new zzn(this));
        }
    }
}
