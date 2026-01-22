package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.os.Handler;
import io.agora.rtc.gl.EglBase;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoFrame {
    private final Buffer buffer;
    private final int rotation;
    private final long timestampNs;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Buffer {
        Buffer cropAndScale(int i10, int i11, int i12, int i13, int i14, int i15);

        int getHeight();

        int getWidth();

        void release();

        void retain();

        I420Buffer toI420();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface I420Buffer extends Buffer {
        ByteBuffer getDataU();

        ByteBuffer getDataV();

        ByteBuffer getDataY();

        int getStrideU();

        int getStrideV();

        int getStrideY();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface TextureBuffer extends Buffer {
        public static final String TAG = "TEXBUF";

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public enum Type {
            OES(36197),
            RGB(3553);

            private final int glTarget;

            Type(int i10) {
                this.glTarget = i10;
            }

            public int getGlTarget() {
                return this.glTarget;
            }
        }

        TextureBuffer flip(boolean z10);

        EglBase.Context getEglBaseContext();

        int getEglType();

        float[] getGlTransformMatrix();

        long getNativeBuffer();

        long getNativeEglContext();

        Object getRealEglContext();

        int getSequence();

        int getTextureId();

        int getTextureType();

        Handler getToI420Handler();

        Matrix getTransformMatrix();

        Type getType();

        YuvConverter getYuvConverter();

        String infoString();

        boolean isNativeBufferSupported();

        boolean isValidNativeBuffer();

        TextureBuffer rotate(int i10);

        TextureBuffer toAGraphicBufferEx();

        TextureBuffer toTextureBuffer();
    }

    public VideoFrame(Buffer buffer, int i10, long j10) {
        if (buffer != null) {
            if (i10 % 90 == 0) {
                this.buffer = buffer;
                this.rotation = i10;
                this.timestampNs = j10;
                return;
            }
            throw new IllegalArgumentException("rotation must be a multiple of 90");
        }
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    public static Buffer cropAndScaleI420(final I420Buffer i420Buffer, int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i12 == i14 && i13 == i15) {
            ByteBuffer dataY = i420Buffer.getDataY();
            ByteBuffer dataU = i420Buffer.getDataU();
            ByteBuffer dataV = i420Buffer.getDataV();
            dataY.position(i10 + (i420Buffer.getStrideY() * i11));
            int i16 = i10 / 2;
            int i17 = i11 / 2;
            dataU.position((i420Buffer.getStrideU() * i17) + i16);
            dataV.position(i16 + (i17 * i420Buffer.getStrideV()));
            i420Buffer.retain();
            return JavaI420Buffer.wrap(i420Buffer.getWidth(), i420Buffer.getHeight(), dataY.slice(), i420Buffer.getStrideY(), dataU.slice(), i420Buffer.getStrideU(), dataV.slice(), i420Buffer.getStrideV(), new Runnable() { // from class: io.agora.rtc.gl.VideoFrame.1
                @Override // java.lang.Runnable
                public void run() {
                    I420Buffer.this.release();
                }
            });
        }
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i14, i15);
        nativeCropAndScaleI420(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), i10, i11, i12, i13, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), i14, i15);
        return allocate;
    }

    public static final int getAgoraFormat(TextureBuffer textureBuffer) {
        if (textureBuffer.getType() == TextureBuffer.Type.OES) {
            return 11;
        }
        return 10;
    }

    private static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12, int i13, int i14, int i15, int i16, ByteBuffer byteBuffer4, int i17, ByteBuffer byteBuffer5, int i18, ByteBuffer byteBuffer6, int i19, int i20, int i21);

    public Buffer getBuffer() {
        return this.buffer;
    }

    public int getRotatedHeight() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getHeight();
        }
        return this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        if (this.rotation % 180 == 0) {
            return this.buffer.getWidth();
        }
        return this.buffer.getHeight();
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public void release() {
        this.buffer.release();
    }

    public void retain() {
        this.buffer.retain();
    }
}
