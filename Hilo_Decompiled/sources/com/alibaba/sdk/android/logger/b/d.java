package com.alibaba.sdk.android.logger.b;

import android.util.Log;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;
import com.qiahao.base_common.network.model.ErrorCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d implements ILogger {

    /* renamed from: com.alibaba.sdk.android.logger.b.d$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٦٤٣٦a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f٦٤٣٦a = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٦٤٣٦a[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٦٤٣٦a[LogLevel.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٦٤٣٦a[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.sdk.android.logger.ILogger
    public void print(LogLevel logLevel, String str, String str2) {
        String str3;
        if (str2.length() > 4000) {
            str3 = str2.substring(ErrorCode.ERROR_4000);
            str2 = str2.substring(0, ErrorCode.ERROR_4000);
        } else {
            str3 = null;
        }
        int i10 = AnonymousClass1.f٦٤٣٦a[logLevel.ordinal()];
        if (i10 == 1) {
            Log.d(str, str2);
        } else if (i10 == 2) {
            Log.i(str, str2);
        } else if (i10 == 3) {
            Log.w(str, str2);
        } else if (i10 == 4) {
            Log.e(str, str2);
        }
        if (str3 != null) {
            print(logLevel, str, str3);
        }
    }
}
