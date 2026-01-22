package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface AuthorizationClient extends HasApiKey<zbc> {
    Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest);

    AuthorizationResult getAuthorizationResultFromIntent(Intent intent) throws ApiException;
}
