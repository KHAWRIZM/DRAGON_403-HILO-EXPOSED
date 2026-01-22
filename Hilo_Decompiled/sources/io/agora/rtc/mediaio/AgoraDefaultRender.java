package io.agora.rtc.mediaio;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraDefaultRender implements IVideoSink {
    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteArrayFrame(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10) {
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeTextureFrame(int i10, int i11, int i12, int i13, int i14, long j10, float[] fArr) {
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public int getBufferType() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public long getEGLContextHandle() {
        return 0L;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public int getPixelFormat() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public void onDispose() {
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public boolean onInitialize() {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public boolean onStart() {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public void onStop() {
    }
}
