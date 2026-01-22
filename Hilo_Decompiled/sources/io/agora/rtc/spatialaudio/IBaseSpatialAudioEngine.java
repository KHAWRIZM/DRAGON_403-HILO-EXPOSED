package io.agora.rtc.spatialaudio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class IBaseSpatialAudioEngine {
    public abstract int muteAllRemoteAudioStreams(boolean z10);

    public abstract int muteLocalAudioStream(boolean z10);

    public abstract int setAudioRecvRange(float f10);

    public abstract int setDistanceUnit(float f10);

    public abstract int setMaxAudioRecvCount(int i10);

    public abstract int updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);
}
