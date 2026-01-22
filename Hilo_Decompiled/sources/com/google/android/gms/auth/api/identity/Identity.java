package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p٠٠٠authapi.zbaa;
import com.google.android.gms.internal.p٠٠٠authapi.zbag;
import com.google.android.gms.internal.p٠٠٠authapi.zbaq;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class Identity {
    private Identity() {
    }

    public static AuthorizationClient getAuthorizationClient(Activity activity) {
        return new zbaa((Activity) Preconditions.checkNotNull(activity), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbag((Activity) Preconditions.checkNotNull(activity), new zbi());
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zbaq((Activity) Preconditions.checkNotNull(activity), new zbv());
    }

    public static AuthorizationClient getAuthorizationClient(Context context) {
        return new zbaa((Context) Preconditions.checkNotNull(context), new zbb(null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbag((Context) Preconditions.checkNotNull(context), new zbi());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zbaq((Context) Preconditions.checkNotNull(context), new zbv());
    }
}
