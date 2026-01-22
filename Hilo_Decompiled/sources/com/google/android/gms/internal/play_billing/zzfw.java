package com.google.android.gms.internal.play_billing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public enum zzfw {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzbq.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    zzfw(Object obj) {
        this.zzk = obj;
    }
}
