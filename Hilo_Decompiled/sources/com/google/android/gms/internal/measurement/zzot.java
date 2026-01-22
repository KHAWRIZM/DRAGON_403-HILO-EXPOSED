package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public enum zzot {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzlg.zzb),
    ENUM(null),
    MESSAGE(null);

    zzot(Object obj) {
    }
}
