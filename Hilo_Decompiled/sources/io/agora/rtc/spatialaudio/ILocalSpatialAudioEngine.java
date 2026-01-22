package io.agora.rtc.spatialaudio;

import io.agora.rtc.spatialaudio.internal.LocalSpatialAudioImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class ILocalSpatialAudioEngine extends IBaseSpatialAudioEngine {
    private static ILocalSpatialAudioEngine mInstance;

    public static synchronized ILocalSpatialAudioEngine create() {
        ILocalSpatialAudioEngine iLocalSpatialAudioEngine;
        synchronized (ILocalSpatialAudioEngine.class) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalSpatialAudioImpl();
                }
                iLocalSpatialAudioEngine = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iLocalSpatialAudioEngine;
    }

    public static synchronized void destroy() {
        synchronized (ILocalSpatialAudioEngine.class) {
            ILocalSpatialAudioEngine iLocalSpatialAudioEngine = mInstance;
            if (iLocalSpatialAudioEngine == null) {
                return;
            }
            iLocalSpatialAudioEngine.release();
            mInstance = null;
        }
    }

    public abstract int clearRemotePositions();

    public abstract int initialize(LocalSpatialAudioConfig localSpatialAudioConfig);

    protected abstract int release();

    public abstract int removeRemotePosition(int i10);

    public abstract int updateRemotePosition(int i10, RemoteVoicePositionInfo remoteVoicePositionInfo);
}
