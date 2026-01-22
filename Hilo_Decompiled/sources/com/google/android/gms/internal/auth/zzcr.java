package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.annotation.GuardedBy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcr {

    @GuardedBy("PhenotypeConstants.class")
    private static final androidx.collection.a zza = new androidx.collection.a();

    public static synchronized Uri zza(String str) {
        synchronized (zzcr.class) {
            androidx.collection.a aVar = zza;
            Uri uri = (Uri) aVar.get("com.google.android.gms.auth_account");
            if (uri == null) {
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
                aVar.put("com.google.android.gms.auth_account", parse);
                return parse;
            }
            return uri;
        }
    }
}
