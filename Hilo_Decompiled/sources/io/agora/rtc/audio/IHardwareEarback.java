package io.agora.rtc.audio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
interface IHardwareEarback {
    void destroy();

    int enableEarbackFeature(boolean z10);

    void initialize();

    boolean isHardwareEarbackSupported();

    int setHardwareEarbackVolume(int i10);
}
