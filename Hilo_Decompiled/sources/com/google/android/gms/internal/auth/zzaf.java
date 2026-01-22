package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z10) {
        Status status;
        zzag zzagVar = this.zza;
        if (z10) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzagVar.setResult((zzag) new zzak(status));
    }
}
