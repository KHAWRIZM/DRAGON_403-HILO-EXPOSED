package io.agora.rtc.mediaio;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IVideoFrameConsumer {
    void consumeByteArrayFrame(byte[] bArr, int i10, int i11, int i12, int i13, long j10);

    void consumeByteBufferFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10);

    void consumeTextureFrame(int i10, int i11, int i12, int i13, int i14, long j10, float[] fArr);
}
