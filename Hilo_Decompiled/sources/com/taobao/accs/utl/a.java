package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class a implements ILogger {
    final /* synthetic */ ALog.ILog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ALog.ILog iLog) {
        this.a = iLog;
    }

    public void print(LogLevel logLevel, String str, String str2) {
        try {
            int i = b.a[logLevel.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.a.e(str, str2);
                        }
                    } else {
                        this.a.w(str, str2);
                    }
                } else {
                    this.a.i(str, str2);
                }
            } else {
                this.a.d(str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
