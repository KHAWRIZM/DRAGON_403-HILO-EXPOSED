package io.agora.rtc;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class IVideoFrameObserver {
    public static final int FRAME_TYPE_RGBA = 2;
    public static final int FRAME_TYPE_YUV420 = 0;
    public static final int FRAME_TYPE_YUV422 = 1;
    public static final int POSITION_POST_CAPTURER = 1;
    public static final int POSITION_PRE_ENCODER = 4;
    public static final int POSITION_PRE_RENDERER = 2;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class VideoFrame {
        public int avsync_type;
        public int height;
        public long renderTimeMs;
        public int rotation;
        public int type;
        public ByteBuffer uBuffer;
        public int uStride;
        public ByteBuffer vBuffer;
        public int vStride;
        public int width;
        public ByteBuffer yBuffer;
        public int yStride;

        public VideoFrame(int i10, int i11, int i12, int i13, int i14, int i15, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i16, long j10, int i17) {
            this.type = i10;
            this.width = i11;
            this.height = i12;
            this.yStride = i13;
            this.uStride = i14;
            this.vStride = i15;
            this.yBuffer = byteBuffer;
            this.uBuffer = byteBuffer2;
            this.vBuffer = byteBuffer3;
            this.rotation = i16;
            this.renderTimeMs = j10;
            this.avsync_type = i17;
        }

        public String toString() {
            String byteBuffer;
            String byteBuffer2;
            StringBuilder sb = new StringBuilder();
            sb.append("VideoFrame{type=");
            sb.append(this.type);
            sb.append(", width=");
            sb.append(this.width);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(", yStride=");
            sb.append(this.yStride);
            sb.append(", uStride=");
            sb.append(this.uStride);
            sb.append(", vStride=");
            sb.append(this.vStride);
            sb.append(", yBuffer=");
            ByteBuffer byteBuffer3 = this.yBuffer;
            String str = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
            if (byteBuffer3 == null) {
                byteBuffer = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
            } else {
                byteBuffer = byteBuffer3.toString();
            }
            sb.append(byteBuffer);
            sb.append(", uBuffer=");
            ByteBuffer byteBuffer4 = this.uBuffer;
            if (byteBuffer4 == null) {
                byteBuffer2 = com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID;
            } else {
                byteBuffer2 = byteBuffer4.toString();
            }
            sb.append(byteBuffer2);
            sb.append(", vBuffer=");
            ByteBuffer byteBuffer5 = this.vBuffer;
            if (byteBuffer5 != null) {
                str = byteBuffer5.toString();
            }
            sb.append(str);
            sb.append(", rotation=");
            sb.append(this.rotation);
            sb.append(", renderTimeMs=");
            sb.append(this.renderTimeMs);
            sb.append(", avsync_type=");
            sb.append(this.avsync_type);
            sb.append('}');
            return sb.toString();
        }
    }

    public boolean getMirrorApplied() {
        return false;
    }

    public int getObservedFramePosition() {
        return 3;
    }

    public boolean getRotationApplied() {
        return false;
    }

    public int getVideoFormatPreference() {
        return 0;
    }

    public boolean isMultipleChannelFrameWanted() {
        return false;
    }

    public abstract boolean onCaptureVideoFrame(VideoFrame videoFrame);

    public boolean onPreEncodeVideoFrame(VideoFrame videoFrame) {
        return true;
    }

    public abstract boolean onRenderVideoFrame(int i10, VideoFrame videoFrame);

    public boolean onRenderVideoFrameEx(String str, int i10, VideoFrame videoFrame) {
        return true;
    }
}
