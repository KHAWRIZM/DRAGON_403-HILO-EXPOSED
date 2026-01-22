package com.google.android.gms.appinvite;

import android.content.Intent;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface AppInviteInvitationResult extends Result {
    Intent getInvitationIntent();

    @Override // com.google.android.gms.common.api.Result
    Status getStatus();
}
