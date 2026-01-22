package com.amazonaws.mobile.auth.core.signin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.amazonaws.mobile.auth.core.IdentityProvider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface SignInProvider extends IdentityProvider {
    void handleActivityResult(int i10, int i11, Intent intent);

    View.OnClickListener initializeSignInButton(Activity activity, View view, SignInProviderResultHandler signInProviderResultHandler);

    boolean isRequestCodeOurs(int i10);
}
