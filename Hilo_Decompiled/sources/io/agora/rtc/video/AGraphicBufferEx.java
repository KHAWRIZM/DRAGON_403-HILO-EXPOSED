package io.agora.rtc.video;

import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.gl.YuvConverter;
import io.agora.rtc.utils.ThreadUtils;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AGraphicBufferEx implements VideoFrame.TextureBuffer {
    private final EglBase.Context eglContext;
    private int height;
    private final int id;
    private long mHandler;
    private final Runnable releaseCallback;
    private final Handler toI420Handler;
    private Matrix transformMatrix;
    private int width;
    private final Object refCountLock = new Object();
    private final VideoFrame.TextureBuffer.Type type = VideoFrame.TextureBuffer.Type.OES;
    private int refCount = 1;

    public AGraphicBufferEx(EglBase.Context context, int i10, int i11, Handler handler, int i12, Matrix matrix, Runnable runnable) {
        this.eglContext = context;
        this.width = i10;
        this.height = i11;
        this.id = i12;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.releaseCallback = runnable;
        this.mHandler = initHardwareBuffer(i10, i11, i12);
    }

    private native byte[] getBuffer(long j10);

    private native int getTextureId(long j10);

    private native long initHardwareBuffer(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean isValid(long j10);

    private native void releaseHardwareBuffer(long j10);

    private native void setBuffer(long j10, byte[] bArr);

    public VideoFrame.TextureBuffer applyTransformMatrix(Matrix matrix, int i10, int i11) {
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        this.transformMatrix = matrix2;
        this.width = i10;
        this.height = i11;
        return this;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i10, int i11, int i12, int i13, int i14, int i15) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(i10 / this.width, (r1 - (i11 + i13)) / this.height);
        matrix.preScale(i12 / this.width, i13 / this.height);
        return applyTransformMatrix(matrix, i14, i15);
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer flip(boolean z10) {
        float[] horizontalFlipMatrix;
        if (z10) {
            horizontalFlipMatrix = RendererCommon.verticalFlipMatrix();
        } else {
            horizontalFlipMatrix = RendererCommon.horizontalFlipMatrix();
        }
        return applyTransformMatrix(RendererCommon.convertMatrixToAndroidGraphicsMatrix(horizontalFlipMatrix), this.width, this.height);
    }

    public byte[] getBuffer() {
        return getBuffer(this.mHandler);
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public EglBase.Context getEglBaseContext() {
        return this.eglContext;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public int getEglType() {
        return this.eglContext.getEglType();
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public float[] getGlTransformMatrix() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public long getNativeBuffer() {
        return ((Long) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<Long>() { // from class: io.agora.rtc.video.AGraphicBufferEx.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                return Long.valueOf(AGraphicBufferEx.this.mHandler);
            }
        })).longValue();
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public long getNativeEglContext() {
        EglBase.Context context = this.eglContext;
        if (context != null) {
            return context.getNativeEglContext();
        }
        return 0L;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public Object getRealEglContext() {
        return this.eglContext.getRealEglContext();
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public int getSequence() {
        return 0;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public int getTextureId() {
        return getTextureId(this.mHandler);
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public int getTextureType() {
        if (this.type == VideoFrame.TextureBuffer.Type.OES) {
            return 11;
        }
        return 10;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public Handler getToI420Handler() {
        return this.toI420Handler;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public YuvConverter getYuvConverter() {
        return null;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public String infoString() {
        return toString();
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public boolean isNativeBufferSupported() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public boolean isValidNativeBuffer() {
        return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.AGraphicBufferEx.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                AGraphicBufferEx aGraphicBufferEx = AGraphicBufferEx.this;
                return Boolean.valueOf(aGraphicBufferEx.isValid(aGraphicBufferEx.mHandler));
            }
        })).booleanValue();
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public void release() {
        Runnable runnable;
        synchronized (this.refCountLock) {
            try {
                int i10 = this.refCount - 1;
                this.refCount = i10;
                if (i10 == 0 && (runnable = this.releaseCallback) != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseNativeBuffer() {
        releaseHardwareBuffer(this.mHandler);
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public void retain() {
        synchronized (this.refCountLock) {
            this.refCount++;
        }
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer rotate(int i10) {
        boolean z10;
        int i11;
        int i12;
        if (i10 != 90 && i10 != 270) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i11 = this.height;
        } else {
            i11 = this.width;
        }
        if (z10) {
            i12 = this.width;
        } else {
            i12 = this.height;
        }
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preRotate(i10);
        matrix.preTranslate(-0.5f, -0.5f);
        return applyTransformMatrix(matrix, i11, i12);
    }

    public void setBuffer(byte[] bArr) {
        setBuffer(this.mHandler, bArr);
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer toAGraphicBufferEx() {
        return this;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return null;
    }

    public String toString() {
        return "AGraphicBufferEx{eglContext=" + this.eglContext + ", width=" + this.width + ", height=" + this.height + ", type=" + this.type + ", id=" + this.id + ", transformMatrix=" + this.transformMatrix + ", toI420Handler=" + this.toI420Handler + ", releaseCallback=" + this.releaseCallback + ", refCountLock=" + this.refCountLock + ", refCount=" + this.refCount + ", mHandler=" + this.mHandler + '}';
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer toTextureBuffer() {
        return this;
    }
}
