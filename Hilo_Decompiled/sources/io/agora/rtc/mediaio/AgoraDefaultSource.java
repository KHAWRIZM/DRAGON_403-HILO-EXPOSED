package io.agora.rtc.mediaio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraDefaultSource implements IVideoSource {
    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getBufferType() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getCaptureType() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getContentHint() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onDispose() {
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onStart() {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onStop() {
    }
}
