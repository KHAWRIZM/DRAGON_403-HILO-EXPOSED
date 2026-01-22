package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.utils.ThreadUtils;
import io.agora.rtc.video.AGraphicBufferEx;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private static final boolean VERBOSE = false;
    private AGraphicBufferEx aGraphicBufferEx;
    private final EglBase.Context eglContext;
    private final int height;
    private final int id;
    private int oesTextureId;
    private int refCount;
    private final Object refCountLock;
    private final Runnable releaseCallback;
    private final int sequence;
    private TextureConverter textureConverter;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int width;
    private final YuvConverter yuvConverter;

    public TextureBufferImpl(EglBase.Context context, int i10, int i11, VideoFrame.TextureBuffer.Type type, int i12, Matrix matrix, Handler handler, YuvConverter yuvConverter, Runnable runnable, int i13) {
        this.refCountLock = new Object();
        this.eglContext = context;
        this.width = i10;
        this.height = i11;
        this.type = type;
        this.id = i12;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.releaseCallback = runnable;
        this.refCount = 1;
        this.oesTextureId = -1;
        this.sequence = i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AGraphicBufferEx copyToAGraphicBufferEx() {
        int i10;
        int i11;
        if (getType() == VideoFrame.TextureBuffer.Type.OES) {
            i10 = 36197;
            i11 = 0;
        } else {
            i10 = 3553;
            i11 = 1;
        }
        if (this.textureConverter == null) {
            this.textureConverter = new TextureConverter(getTextureId(), i10, i11);
        }
        if (this.oesTextureId < 0) {
            this.oesTextureId = this.textureConverter.getOneTexture(36197);
        }
        if (this.aGraphicBufferEx == null) {
            this.aGraphicBufferEx = new AGraphicBufferEx(getEglBaseContext(), getWidth(), getHeight(), this.toI420Handler, this.oesTextureId, getTransformMatrix(), this.releaseCallback);
        }
        this.textureConverter.convert(36197, this.oesTextureId);
        return this.aGraphicBufferEx;
    }

    private void releaseAGraphicBufferEx() {
        TextureConverter textureConverter = this.textureConverter;
        if (textureConverter != null) {
            textureConverter.release();
            this.textureConverter = null;
        }
        AGraphicBufferEx aGraphicBufferEx = this.aGraphicBufferEx;
        if (aGraphicBufferEx != null) {
            aGraphicBufferEx.releaseNativeBuffer();
            this.aGraphicBufferEx = null;
        }
    }

    public VideoFrame.TextureBuffer applyTransformMatrix(Matrix matrix, int i10, int i11) {
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        retain();
        return new TextureBufferImpl(this.eglContext, i10, i11, this.type, this.id, matrix2, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: io.agora.rtc.gl.TextureBufferImpl.3
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferImpl.this.release();
            }
        }, this.sequence);
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
        return 0L;
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
        return this.sequence;
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.id;
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
        return this.yuvConverter;
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
        return false;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public void release() {
        synchronized (this.refCountLock) {
            try {
                int i10 = this.refCount - 1;
                this.refCount = i10;
                if (i10 == 0 && this.releaseCallback != null) {
                    releaseAGraphicBufferEx();
                    this.releaseCallback.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
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

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer toAGraphicBufferEx() {
        if (isNativeBufferSupported()) {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<VideoFrame.TextureBuffer>() { // from class: io.agora.rtc.gl.TextureBufferImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public VideoFrame.TextureBuffer call() throws Exception {
                    return TextureBufferImpl.this.copyToAGraphicBufferEx();
                }
            });
        }
        throw new IllegalStateException("mini api level 26 is needed, curr: " + Build.VERSION.SDK_INT);
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<VideoFrame.I420Buffer>() { // from class: io.agora.rtc.gl.TextureBufferImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VideoFrame.I420Buffer call() throws Exception {
                return TextureBufferImpl.this.yuvConverter.convert(TextureBufferImpl.this);
            }
        });
    }

    public String toString() {
        return "TextureBufferImpl{eglContext=" + this.eglContext + ", " + this.width + "x" + this.height + ", type=" + this.type + ", seq=" + this.sequence + ", id=" + this.id + ", refCount=" + this.refCount + '}';
    }

    @Override // io.agora.rtc.gl.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer toTextureBuffer() {
        return this;
    }

    public TextureBufferImpl(EglBase.Context context, int i10, int i11, VideoFrame.TextureBuffer.Type type, int i12, Matrix matrix, Handler handler, YuvConverter yuvConverter, Runnable runnable) {
        this(context, i10, i11, type, i12, matrix, handler, yuvConverter, runnable, -1);
    }
}
