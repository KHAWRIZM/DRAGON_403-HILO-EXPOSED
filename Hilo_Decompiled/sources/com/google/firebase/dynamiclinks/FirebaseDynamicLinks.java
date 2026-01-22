package com.google.firebase.dynamiclinks;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class FirebaseDynamicLinks {
    @Deprecated
    public static synchronized FirebaseDynamicLinks getInstance() {
        FirebaseDynamicLinks firebaseDynamicLinks;
        synchronized (FirebaseDynamicLinks.class) {
            firebaseDynamicLinks = getInstance(FirebaseApp.getInstance());
        }
        return firebaseDynamicLinks;
    }

    @Deprecated
    public abstract DynamicLink.Builder createDynamicLink();

    @Deprecated
    public abstract Task<PendingDynamicLinkData> getDynamicLink(Intent intent);

    @Deprecated
    public abstract Task<PendingDynamicLinkData> getDynamicLink(Uri uri);

    @Deprecated
    public static synchronized FirebaseDynamicLinks getInstance(FirebaseApp firebaseApp) {
        FirebaseDynamicLinks firebaseDynamicLinks;
        synchronized (FirebaseDynamicLinks.class) {
            firebaseDynamicLinks = (FirebaseDynamicLinks) firebaseApp.get(FirebaseDynamicLinks.class);
        }
        return firebaseDynamicLinks;
    }
}
