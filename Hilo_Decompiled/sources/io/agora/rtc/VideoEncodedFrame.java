package io.agora.rtc;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoEncodedFrame {
    public static final int CODEC_TYPE_E264 = 4;
    public static final int CODEC_TYPE_EVP = 3;
    public static final int CODEC_TYPE_H264 = 2;
    public static final int CODEC_TYPE_VP8 = 1;
    public static final int FRAME_TYPE_B = 5;
    public static final int FRAME_TYPE_BLANK = 0;
    public static final int FRAME_TYPE_DELTA = 4;
    public static final int FRAME_TYPE_KEY = 3;
    public int codecType;
    public int frameType;
    public int height;
    public ByteBuffer imageBuffer;
    public int length;
    public long renderTimeMs;
    public int rotation;
    public int width;

    public VideoEncodedFrame(int i10, ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, int i15, long j10) {
        this.codecType = i10;
        this.width = i12;
        this.height = i13;
        this.imageBuffer = byteBuffer;
        this.length = i11;
        this.frameType = i14;
        this.rotation = i15;
        this.renderTimeMs = j10;
    }

    public String toString() {
        return "VideoEncodedFrame{codecType=" + this.codecType + ", width=" + this.width + ", height=" + this.height + ", frameType=" + this.frameType + ", rotation=" + this.rotation + ", renderTimeMs=" + this.renderTimeMs + ", imageBuffer=" + this.imageBuffer + ", length=" + this.length + '}';
    }
}
