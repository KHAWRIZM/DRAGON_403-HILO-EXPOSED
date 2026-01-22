package com.tencent.liteav.audio;

import android.text.TextUtils;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@JNINamespace("liteav::manager")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXAudioEffectManagerImpl implements TXAudioEffectManager {
    private static final int EFFECT_PLAYER_ID_TYPE = 2;
    private static final String TAG = "TXAudioEffectManagerImpl";
    private List<Integer> mEffectIdList = new ArrayList();
    private final MusicPlayObserver mMusicPlayObserver;
    private final MusicPreloadObserver mMusicPreloadObserver;
    private long mNativeAudioEffectMgr;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class AudioBgmParams {
        private TXAudioEffectManager.AudioMusicParam mParams;

        public AudioBgmParams(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
            this.mParams = audioMusicParam;
        }

        public long getEndTimeMS() {
            return this.mParams.endTimeMS;
        }

        public int getLoopCount() {
            return this.mParams.loopCount;
        }

        public String getPath() {
            return this.mParams.path;
        }

        public long getStartTimeMS() {
            return this.mParams.startTimeMS;
        }

        public boolean isPublish() {
            return this.mParams.publish;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class MusicPlayObserver {
        private final HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mObserverMap = new HashMap<>();

        MusicPlayObserver() {
        }

        public void addObserver(long j, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
            if (tXMusicPlayObserver == null) {
                return;
            }
            synchronized (this) {
                this.mObserverMap.put(Long.valueOf(j), tXMusicPlayObserver);
            }
        }

        public void onComplete(long j, int i) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onComplete((int) j, i);
            }
        }

        public void onPlayProgress(long j, long j2, long j3) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onPlayProgress((int) j, j2, j3);
            }
        }

        public void onStart(long j, int i) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onStart((int) j, i);
            }
        }

        public void removeObserver(long j) {
            synchronized (this) {
                this.mObserverMap.remove(Long.valueOf(j));
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class MusicPreloadObserver {
        private TXAudioEffectManager.TXMusicPreloadObserver mObserver;

        MusicPreloadObserver() {
        }

        public void onLoadError(long j, int i) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadError((int) j, i);
            }
        }

        public void onLoadProgress(long j, int i) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadProgress((int) j, i);
            }
        }

        public void setObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
            this.mObserver = tXMusicPreloadObserver;
        }
    }

    public TXAudioEffectManagerImpl(long j) {
        this.mNativeAudioEffectMgr = 0L;
        MusicPlayObserver musicPlayObserver = new MusicPlayObserver();
        this.mMusicPlayObserver = musicPlayObserver;
        MusicPreloadObserver musicPreloadObserver = new MusicPreloadObserver();
        this.mMusicPreloadObserver = musicPreloadObserver;
        this.mNativeAudioEffectMgr = j;
        if (j != 0) {
            nativeSetMusicObserver(j, musicPlayObserver);
            nativeSetPreloadObserver(this.mNativeAudioEffectMgr, musicPreloadObserver);
        }
    }

    private static long convertToEffectId(int i) {
        return 8589934592L | i;
    }

    private static native void nativeDestroy(long j);

    private static native void nativeEnableVoiceEarMonitor(long j, boolean z);

    private static native long nativeGetMusicCurrentPosInMS(long j, long j2);

    private static native long nativeGetMusicDurationInMS(long j, String str);

    private static native int nativeGetMusicTrackCount(long j, long j2);

    private static native void nativePausePlayMusic(long j, long j2);

    private static native void nativePreloadMusic(long j, long j2, AudioBgmParams audioBgmParams);

    private static native void nativeResumePlayMusic(long j, long j2);

    private static native void nativeSeekMusicToPosInMS(long j, long j2, long j3);

    private static native void nativeSetAllMusicVolume(long j, int i);

    private static native void nativeSetMusicObserver(long j, MusicPlayObserver musicPlayObserver);

    private static native void nativeSetMusicPitch(long j, long j2, float f);

    private static native void nativeSetMusicPlayoutVolume(long j, long j2, int i);

    private static native void nativeSetMusicPublishVolume(long j, long j2, int i);

    private static native void nativeSetMusicScratchSpeedRate(long j, long j2, float f);

    private static native void nativeSetMusicSpeedRate(long j, long j2, float f);

    private static native void nativeSetMusicTrack(long j, long j2, int i);

    private static native void nativeSetPreloadObserver(long j, MusicPreloadObserver musicPreloadObserver);

    private static native void nativeSetVoiceCaptureVolume(long j, int i);

    private static native void nativeSetVoiceChangerType(long j, int i);

    private static native void nativeSetVoiceEarMonitorVolume(long j, int i);

    private static native void nativeSetVoicePitch(long j, double d);

    private static native void nativeSetVoiceReverbType(long j, int i);

    private static native void nativeStartPlayMusic(long j, long j2, AudioBgmParams audioBgmParams);

    private static native void nativeStopPlayMusic(long j, long j2);

    public static TXAudioEffectManager.TXVoiceChangerType voiceChangerTypeFromInt(int i) {
        if (i == 0) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        }
        if (i == 1) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1;
        }
        if (i == 2) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2;
        }
        if (i == 3) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3;
        }
        if (i == 4) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4;
        }
        if (i == 5) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5;
        }
        if (i == 6) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6;
        }
        if (i == 7) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7;
        }
        if (i == 8) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8;
        }
        if (i == 9) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9;
        }
        if (i == 10) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10;
        }
        if (i == 11) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11;
        }
        return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
    }

    public static TXAudioEffectManager.TXVoiceReverbType voiceReverbTypeFromInt(int i) {
        if (i == 0) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        }
        if (i == 1) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1;
        }
        if (i == 2) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2;
        }
        if (i == 3) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3;
        }
        if (i == 4) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4;
        }
        if (i == 5) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5;
        }
        if (i == 6) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6;
        }
        if (i == 7) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7;
        }
        if (i == 8) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_8;
        }
        if (i == 9) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_9;
        }
        if (i == 10) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_10;
        }
        return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void enableVoiceEarMonitor(boolean z) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeEnableVoiceEarMonitor(j, z);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeAudioEffectMgr = 0L;
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicCurrentPosInMS(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j == 0) {
            return 0L;
        }
        return nativeGetMusicCurrentPosInMS(j, i);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicDurationInMS(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "getMusicDurationInMS invalid params");
            return 0L;
        }
        long j = this.mNativeAudioEffectMgr;
        if (j == 0) {
            return 0L;
        }
        return nativeGetMusicDurationInMS(j, str);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public int getMusicTrackCount(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            return nativeGetMusicTrackCount(j, i);
        }
        return 0;
    }

    public void pauseAudioEffect(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativePausePlayMusic(j, convertToEffectId(i));
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void pausePlayMusic(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativePausePlayMusic(j, i);
        }
    }

    public void playAudioEffect(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam != null && !TextUtils.isEmpty(audioMusicParam.path)) {
            long j = this.mNativeAudioEffectMgr;
            if (j != 0) {
                nativeStartPlayMusic(j, convertToEffectId(audioMusicParam.f٨٢id), new AudioBgmParams(audioMusicParam));
                synchronized (this) {
                    this.mEffectIdList.add(Integer.valueOf(audioMusicParam.f٨٢id));
                }
                return;
            }
            return;
        }
        LiteavLog.e(TAG, "startPlayMusic invalid params");
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public boolean preloadMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null) {
            LiteavLog.e(TAG, "preloadMusic invalid params");
            return false;
        }
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativePreloadMusic(j, audioMusicParam.f٨٢id, new AudioBgmParams(audioMusicParam));
            return true;
        }
        return true;
    }

    public void resumeAudioEffect(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeResumePlayMusic(j, convertToEffectId(i));
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void resumePlayMusic(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeResumePlayMusic(j, i);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void seekMusicToPosInMS(int i, int i2) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSeekMusicToPosInMS(j, i, i2);
        }
    }

    public void setAllAudioEffectsVolume(int i) {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                try {
                    Iterator<Integer> it = this.mEffectIdList.iterator();
                    while (it.hasNext()) {
                        setAudioEffectVolume(it.next().intValue(), i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setAllMusicVolume(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetAllMusicVolume(j, i);
        }
    }

    public void setAudioEffectVolume(int i, int i2) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicPlayoutVolume(j, convertToEffectId(i), i2);
            nativeSetMusicPublishVolume(this.mNativeAudioEffectMgr, convertToEffectId(i), i2);
        }
    }

    public void setEffectObserver(int i, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            if (tXMusicPlayObserver != null) {
                this.mMusicPlayObserver.addObserver(convertToEffectId(i), tXMusicPlayObserver);
            } else {
                this.mMusicPlayObserver.removeObserver(convertToEffectId(i));
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicObserver(int i, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            if (tXMusicPlayObserver != null) {
                this.mMusicPlayObserver.addObserver(i, tXMusicPlayObserver);
            } else {
                this.mMusicPlayObserver.removeObserver(i);
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPitch(int i, float f) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicPitch(j, i, f);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPlayoutVolume(int i, int i2) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicPlayoutVolume(j, i, i2);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPublishVolume(int i, int i2) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicPublishVolume(j, i, i2);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicScratchSpeedRate(int i, float f) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicScratchSpeedRate(j, i, f);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicSpeedRate(int i, float f) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicSpeedRate(j, i, f);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicTrack(int i, int i2) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetMusicTrack(j, i, i2);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setPreloadObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPreloadObserver.setObserver(tXMusicPreloadObserver);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceCaptureVolume(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetVoiceCaptureVolume(j, i);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0 && tXVoiceChangerType != null) {
            nativeSetVoiceChangerType(j, tXVoiceChangerType.getNativeValue());
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceEarMonitorVolume(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetVoiceEarMonitorVolume(j, i);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoicePitch(double d) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeSetVoicePitch(j, d);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0 && tXVoiceReverbType != null) {
            nativeSetVoiceReverbType(j, tXVoiceReverbType.getNativeValue());
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null) {
            LiteavLog.e(TAG, "startPlayMusic invalid params");
            return false;
        }
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeStartPlayMusic(j, audioMusicParam.f٨٢id, new AudioBgmParams(audioMusicParam));
            return true;
        }
        return true;
    }

    public void stopAllAudioEffects() {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                try {
                    for (Integer num : this.mEffectIdList) {
                        this.mMusicPlayObserver.removeObserver(convertToEffectId(num.intValue()));
                        nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(num.intValue()));
                    }
                    this.mEffectIdList.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void stopAudioEffect(int i) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPlayObserver.removeObserver(convertToEffectId(i));
            nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(i));
            synchronized (this) {
                try {
                    int indexOf = this.mEffectIdList.indexOf(Integer.valueOf(i));
                    if (indexOf >= 0) {
                        this.mEffectIdList.remove(indexOf);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void stopPlayMusic(int i) {
        long j = this.mNativeAudioEffectMgr;
        if (j != 0) {
            nativeStopPlayMusic(j, i);
        }
    }
}
