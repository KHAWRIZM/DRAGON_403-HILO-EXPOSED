package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class a implements Runnable {
    private static final a a = new a();

    private a() {
    }

    public static Runnable a() {
        return a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HDRCapability.checkIsHDR10Supported();
    }
}
