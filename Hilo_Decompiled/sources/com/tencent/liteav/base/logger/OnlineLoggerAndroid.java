package com.tencent.liteav.base.logger;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class OnlineLoggerAndroid {
    private static final int INVALID_INSTANCE = -1;
    private long mNativeOnlineLoggerAndroid;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum a {
        kTRTC(0),
        kLive(1),
        kVod(2);

        int value;

        a(int i) {
            this.value = i;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum b {
        kApi(1),
        kInfo(2),
        kWarning(3),
        kError(4);

        int level;

        b(int i) {
            this.level = i;
        }
    }

    public OnlineLoggerAndroid(a aVar, int i, String str, String str2) {
        this.mNativeOnlineLoggerAndroid = -1L;
        this.mNativeOnlineLoggerAndroid = nativeCreate(aVar.value, i, str, str2);
    }

    private static native long nativeCreate(int i, int i2, String str, String str2);

    private static native void nativeDestroy(long j);

    private static native void nativeLog(long j, int i, String str);

    public synchronized void destroy() {
        long j = this.mNativeOnlineLoggerAndroid;
        if (j == -1) {
            return;
        }
        nativeDestroy(j);
        this.mNativeOnlineLoggerAndroid = -1L;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public synchronized void log(b bVar, String str) {
        long j = this.mNativeOnlineLoggerAndroid;
        if (j == -1) {
            return;
        }
        nativeLog(j, bVar.level, str);
    }
}
