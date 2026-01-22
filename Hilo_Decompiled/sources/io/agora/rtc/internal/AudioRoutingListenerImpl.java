package io.agora.rtc.internal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class AudioRoutingListenerImpl implements AudioRoutingListener {
    private long mAudioRoutingNativeHandle;

    AudioRoutingListenerImpl(long j10) {
        this.mAudioRoutingNativeHandle = j10;
    }

    native void nativeAudioBtProfileChanged(long j10, int i10);

    native void nativeAudioRoutingChanged(long j10, int i10);

    native void nativeAudioRoutingError(long j10, int i10);

    @Override // io.agora.rtc.internal.AudioRoutingListener
    public void onAudioBtProfileChanged(int i10) {
        synchronized (this) {
            nativeAudioBtProfileChanged(this.mAudioRoutingNativeHandle, i10);
        }
    }

    @Override // io.agora.rtc.internal.AudioRoutingListener
    public void onAudioRoutingChanged(int i10) {
        synchronized (this) {
            nativeAudioRoutingChanged(this.mAudioRoutingNativeHandle, i10);
        }
    }

    @Override // io.agora.rtc.internal.AudioRoutingListener
    public void onAudioRoutingDestroyed() {
        synchronized (this) {
            this.mAudioRoutingNativeHandle = 0L;
        }
    }

    @Override // io.agora.rtc.internal.AudioRoutingListener
    public void onAudioRoutingError(int i10) {
        synchronized (this) {
            nativeAudioRoutingError(this.mAudioRoutingNativeHandle, i10);
        }
    }
}
