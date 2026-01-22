package io.agora.rtc.mediaio;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLException;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoFrameConsumerImpl implements IVideoFrameConsumer {
    private long mCaptureHandle;

    public VideoFrameConsumerImpl(long j10) {
        this.mCaptureHandle = j10;
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteArrayFrame(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        int i14;
        int i15;
        if (i10 != 8 && i10 != 3 && i10 != 1) {
            if (i10 != 4 && i10 != 2 && i10 != 7) {
                i14 = -1;
            } else {
                i14 = i11 * i12 * 4;
            }
        } else {
            i14 = (((i11 + 1) >> 1) * ((i12 + 1) >> 1) * 2) + (i11 * i12);
        }
        if (i13 % 90 != 0) {
            Log.e("IVideoFrameConsumer", "consumeByteArrayFrame rotation is not times of 90, set rotation to 0!");
            i15 = 0;
        } else {
            i15 = i13;
        }
        if (i14 != 0 && (i14 <= 0 || bArr.length >= i14)) {
            provideByteArrayFrame(this.mCaptureHandle, bArr, i10, i11, i12, i15, j10);
            return;
        }
        Log.e("IVideoFrameConsumer", "The size of consumeByteArrayFrame is illegal, format " + i10);
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10) {
        VideoFrameConsumerImpl videoFrameConsumerImpl;
        int i14;
        if (i13 % 90 != 0) {
            Log.e("IVideoFrameConsumer", "consumeByteArrayFrame rotation is not times of 90, set rotation to 0!");
            i14 = 0;
            videoFrameConsumerImpl = this;
        } else {
            videoFrameConsumerImpl = this;
            i14 = i13;
        }
        provideByteBufferFrame(videoFrameConsumerImpl.mCaptureHandle, byteBuffer, i10, i11, i12, i14, j10);
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeTextureFrame(int i10, int i11, int i12, int i13, int i14, long j10, float[] fArr) {
        VideoFrameConsumerImpl videoFrameConsumerImpl;
        int i15;
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            if (i14 % 90 != 0) {
                Log.e("IVideoFrameConsumer", "consumeByteArrayFrame rotation is not times of 90, set rotation to 0!");
                i15 = 0;
                videoFrameConsumerImpl = this;
            } else {
                videoFrameConsumerImpl = this;
                i15 = i14;
            }
            provideTextureFrame(videoFrameConsumerImpl.mCaptureHandle, eglGetCurrentContext, i10, i11, i12, i13, i15, j10, fArr);
            return;
        }
        throw new GLException(eglGetError, "eglError: " + eglGetError);
    }

    public native void provideByteArrayFrame(long j10, byte[] bArr, int i10, int i11, int i12, int i13, long j11);

    public native void provideByteBufferFrame(long j10, ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j11);

    public native void provideTextureFrame(long j10, Object obj, int i10, int i11, int i12, int i13, int i14, long j11, float[] fArr);
}
