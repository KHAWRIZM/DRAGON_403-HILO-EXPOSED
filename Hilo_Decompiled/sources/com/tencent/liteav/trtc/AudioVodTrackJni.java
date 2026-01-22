package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.TRTCCloudDef;

@JNINamespace("liteav::trtc")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AudioVodTrackJni {
    private long mNativeAudioVodTrackJni;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class AudioFrame {
        private TRTCCloudDef.TRTCAudioFrame a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.a.channel;
        }

        public byte[] getData() {
            return this.a.data;
        }

        public int getSampleRate() {
            return this.a.sampleRate;
        }

        public long getTimestamp() {
            return this.a.timestamp;
        }
    }

    public AudioVodTrackJni() {
        this.mNativeAudioVodTrackJni = 0L;
        this.mNativeAudioVodTrackJni = nativeCreateAudioVodTrackJni(this);
    }

    private static native void nativeClean(long j);

    private static native long nativeCreateAudioVodTrackJni(AudioVodTrackJni audioVodTrackJni);

    private static native void nativeEnablePlayout(long j, boolean z);

    private static native void nativePause(long j);

    private static native void nativeResume(long j);

    private static native void nativeSeek(long j);

    private static native void nativeSetPlayoutVolume(long j, int i);

    private static native int nativeWriteData(long j, AudioFrame audioFrame);

    public synchronized void clean() {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativeClean(j);
        }
    }

    public synchronized void enablePlayout(boolean z) {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativeEnablePlayout(j, z);
        }
    }

    public synchronized void pause() {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativePause(j);
        }
    }

    public synchronized void resume() {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativeResume(j);
        }
    }

    public synchronized void seek() {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativeSeek(j);
        }
    }

    public synchronized void setPlayoutVolume(int i) {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            nativeSetPlayoutVolume(j, i);
        }
    }

    public synchronized int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        long j = this.mNativeAudioVodTrackJni;
        if (j != 0) {
            return nativeWriteData(j, new AudioFrame(tRTCAudioFrame));
        }
        return -1;
    }
}
