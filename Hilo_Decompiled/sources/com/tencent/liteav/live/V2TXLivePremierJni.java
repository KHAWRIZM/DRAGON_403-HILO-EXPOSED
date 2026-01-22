package com.tencent.liteav.live;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TXLivePremierJni {
    private static final String TAG = "V2TXLivePremierJni";
    private static long mNativeV2TXLivePremierJni;
    private static V2TXLivePremier.V2TXLivePremierObserver sObserver;

    static {
        SoLoader.loadAllLibraries();
        mNativeV2TXLivePremierJni = 0L;
    }

    public static int callExperimentalAPI(String str) {
        createNativeV2TXLivePremierIfNeed();
        return nativeCallExperimentalAPI(mNativeV2TXLivePremierJni, str);
    }

    private static void createNativeV2TXLivePremierIfNeed() {
        synchronized (V2TXLivePremierJni.class) {
            try {
                if (mNativeV2TXLivePremierJni == 0) {
                    mNativeV2TXLivePremierJni = nativeCreate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int enableAudioCaptureObserver(boolean z, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        if (v2TXLiveAudioFrameObserverFormat == null) {
            LiteavLog.w(TAG, "Enable audio capture observer failed, format is null.");
            return -2;
        }
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioCaptureObserver(mNativeV2TXLivePremierJni, z, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableAudioPlayoutObserver(boolean z, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        if (v2TXLiveAudioFrameObserverFormat == null) {
            LiteavLog.w(TAG, "Enable audio playout observer failed, format is null.");
            return -2;
        }
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioPlayoutObserver(mNativeV2TXLivePremierJni, z, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableVoiceEarMonitorObserver(boolean z) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableVoiceEarMonitorObserver(mNativeV2TXLivePremierJni, z);
    }

    public static long getObjectAddress(Object obj) {
        createNativeV2TXLivePremierIfNeed();
        return nativeGetObjectAddress(mNativeV2TXLivePremierJni, obj);
    }

    private static native int nativeCallExperimentalAPI(long j, String str);

    private static native long nativeCreate();

    private static native int nativeEnableAudioCaptureObserver(long j, boolean z, int i, int i2, int i3, int i4);

    private static native int nativeEnableAudioPlayoutObserver(long j, boolean z, int i, int i2, int i3, int i4);

    private static native int nativeEnableVoiceEarMonitorObserver(long j, boolean z);

    private static native long nativeGetObjectAddress(long j, Object obj);

    private static native void nativeReleaseObjectAddress(long j, long j2);

    public static void onAudioCaptureData(byte[] bArr, long j, int i, int i2) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i;
        v2TXLiveAudioFrame.channel = i2;
        v2TXLiveAudioFrame.timestamp = j;
        v2TXLivePremierObserver.onCaptureAudioFrame(v2TXLiveAudioFrame);
    }

    public static void onAudioPlayoutData(byte[] bArr, long j, int i, int i2) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i;
        v2TXLiveAudioFrame.channel = i2;
        v2TXLiveAudioFrame.timestamp = j;
        v2TXLivePremierObserver.onPlayoutAudioFrame(v2TXLiveAudioFrame);
    }

    public static void onEarMonitoringData(byte[] bArr, int i, int i2) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i;
        v2TXLiveAudioFrame.channel = i2;
        v2TXLivePremierObserver.onVoiceEarMonitorAudioFrame(v2TXLiveAudioFrame);
    }

    public static void releaseObjectAddress(long j) {
        createNativeV2TXLivePremierIfNeed();
        nativeReleaseObjectAddress(mNativeV2TXLivePremierJni, j);
    }

    public static void setObserver(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        sObserver = v2TXLivePremierObserver;
    }
}
