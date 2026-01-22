package com.alibaba.sdk.android.error;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SystemError extends ErrorCode {
    public static final String TYPE_SYSTEM = "ANDROID";

    public SystemError(String str, String str2, String str3, String[] strArr, boolean z10) {
        super(str + "_ANDROID_" + str2, str3, null, strArr, z10);
    }
}
