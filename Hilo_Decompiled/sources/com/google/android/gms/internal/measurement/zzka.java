package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.annotation.GuardedBy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzka {
    public static final /* synthetic */ int zza = 0;

    @GuardedBy("PhenotypeConstants.class")
    private static final androidx.collection.a zzb = new androidx.collection.a();

    public static synchronized Uri zza(String str) {
        synchronized (zzka.class) {
            androidx.collection.a aVar = zzb;
            Uri uri = (Uri) aVar.get("com.google.android.gms.measurement");
            if (uri == null) {
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
                aVar.put("com.google.android.gms.measurement", parse);
                return parse;
            }
            return uri;
        }
    }
}
