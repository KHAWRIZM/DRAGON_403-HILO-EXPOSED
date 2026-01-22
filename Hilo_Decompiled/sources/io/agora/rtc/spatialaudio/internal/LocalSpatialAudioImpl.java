package io.agora.rtc.spatialaudio.internal;

import anetwork.channel.util.RequestConstant;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine;
import io.agora.rtc.spatialaudio.LocalSpatialAudioConfig;
import io.agora.rtc.spatialaudio.RemoteVoicePositionInfo;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LocalSpatialAudioImpl extends ILocalSpatialAudioEngine {
    private static final String TAG = "LocalSpatialAudioImpl";
    private long mNativeHandle = 0;

    private native int nativeClearRemotePositions(long j10);

    private static native int nativeDestroy(long j10);

    private native long nativeObjectInit(Object obj, long j10);

    private native int nativeRemoveRemotePosition(long j10, int i10);

    private native int nativeSetParameters(long j10, String str);

    private native int nativeUpdateRemotePosition(long j10, int i10, float[] fArr, float[] fArr2);

    private native int nativeUpdateSelfPosition(long j10, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    @Override // io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine
    public int clearRemotePositions() {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        return nativeClearRemotePositions(j10);
    }

    @Override // io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine
    public int initialize(LocalSpatialAudioConfig localSpatialAudioConfig) {
        RtcEngine rtcEngine = localSpatialAudioConfig.mRtcEngine;
        if (rtcEngine == null) {
            return -2;
        }
        long nativeObjectInit = nativeObjectInit(localSpatialAudioConfig, rtcEngine.getNativeHandle());
        this.mNativeHandle = nativeObjectInit;
        if (nativeObjectInit == 0) {
            return -7;
        }
        return 0;
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int muteAllRemoteAudioStreams(boolean z10) {
        String str;
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        Locale locale = Locale.US;
        if (z10) {
            str = "true";
        } else {
            str = RequestConstant.FALSE;
        }
        return nativeSetParameters(j10, String.format(locale, "{\"rtc.local_spatial_audio.mute_all_remote_audio_streams\":%s}", str));
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int muteLocalAudioStream(boolean z10) {
        String str;
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        Locale locale = Locale.US;
        if (z10) {
            str = "true";
        } else {
            str = RequestConstant.FALSE;
        }
        return nativeSetParameters(j10, String.format(locale, "{\"rtc.local_spatial_audio.mute_local_stream\":%s}", str));
    }

    @Override // io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine
    protected int release() {
        long j10 = this.mNativeHandle;
        if (j10 != 0) {
            nativeDestroy(j10);
            this.mNativeHandle = 0L;
            return 0;
        }
        return 0;
    }

    @Override // io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine
    public int removeRemotePosition(int i10) {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        return nativeRemoveRemotePosition(j10, i10);
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int setAudioRecvRange(float f10) {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        return nativeSetParameters(j10, String.format(Locale.US, "{\"rtc.local_spatial_audio.hear_range\":%f}", Float.valueOf(f10)));
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int setDistanceUnit(float f10) {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        return nativeSetParameters(j10, String.format(Locale.US, "{\"rtc.local_spatial_audio.distance_unit\":%f}", Float.valueOf(f10)));
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int setMaxAudioRecvCount(int i10) {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        return nativeSetParameters(j10, String.format(Locale.US, "{\"rtc.local_spatial_audio.max_hear_count\":%d}", Integer.valueOf(i10)));
    }

    @Override // io.agora.rtc.spatialaudio.ILocalSpatialAudioEngine
    public int updateRemotePosition(int i10, RemoteVoicePositionInfo remoteVoicePositionInfo) {
        float[] fArr;
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        if (remoteVoicePositionInfo != null && (fArr = remoteVoicePositionInfo.position) != null && fArr.length == 3) {
            if (remoteVoicePositionInfo.forward == null) {
                remoteVoicePositionInfo.forward = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
            }
            return nativeUpdateRemotePosition(j10, i10, fArr, remoteVoicePositionInfo.forward);
        }
        return -2;
    }

    @Override // io.agora.rtc.spatialaudio.IBaseSpatialAudioEngine
    public int updateSelfPosition(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        long j10 = this.mNativeHandle;
        if (j10 == 0) {
            return -7;
        }
        if (fArr.length == 3 && fArr2.length == 3 && fArr3.length == 3 && fArr4.length == 3) {
            return nativeUpdateSelfPosition(j10, fArr, fArr2, fArr3, fArr4);
        }
        return -2;
    }
}
