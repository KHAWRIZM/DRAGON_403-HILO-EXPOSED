package io.agora.rtc.mediaio;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.EglRenderer;
import io.agora.rtc.gl.GlRectDrawer;
import io.agora.rtc.gl.JavaI420Buffer;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.RgbaBuffer;
import io.agora.rtc.gl.TextureBufferImpl;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.mediaio.MediaIO;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseVideoRenderer implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    private static final String ERROR_EGL = "Only one egl surface allowed";
    private static final String TAG = "BaseVideoRenderer";
    private final EglRenderer eglRenderer;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private SurfaceView mSurfaceView;
    private SurfaceHolder.Callback mSurfaceViewListener;
    private TextureView mTextureView;
    private int mBufferType = -1;
    private int mPixelFormat = -1;
    private boolean mHasEglSurface = false;
    private boolean mStarted = false;

    public BaseVideoRenderer(String str) {
        this.eglRenderer = new EglRenderer(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseBuffer(ByteBuffer byteBuffer) {
    }

    private void rendI420Frame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10) {
        if (byteBuffer == null) {
            return;
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr, 0, remaining);
        JavaI420Buffer createYUV = JavaI420Buffer.createYUV(bArr, i11, i12);
        if (createYUV == null) {
            return;
        }
        VideoFrame videoFrame = new VideoFrame(createYUV, i13, j10);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    private void rendRGBAFrame(final ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10) {
        if (byteBuffer == null) {
            return;
        }
        VideoFrame videoFrame = new VideoFrame(new RgbaBuffer(byteBuffer, i11, i12, new Runnable() { // from class: io.agora.rtc.mediaio.BaseVideoRenderer.2
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoRenderer.this.releaseBuffer(byteBuffer);
            }
        }), i13, j10);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    private void rendTextureFrame(int i10, VideoFrame.TextureBuffer.Type type, int i11, int i12, int i13, long j10, float[] fArr) {
        VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(this.eglRenderer.getEglContext(), i11, i12, type, i10, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), null, null, new Runnable() { // from class: io.agora.rtc.mediaio.BaseVideoRenderer.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }), i13, j10);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    public void consume(int i10, int i11, int i12, int i13, int i14, long j10, float[] fArr) {
        VideoFrame.TextureBuffer.Type type;
        if (this.mStarted) {
            if (i11 == 11) {
                type = VideoFrame.TextureBuffer.Type.OES;
            } else if (i11 != 10) {
                return;
            } else {
                type = VideoFrame.TextureBuffer.Type.RGB;
            }
            rendTextureFrame(i10, type, i12, i13, i14, j10, fArr);
        }
    }

    public int getBufferType() {
        int i10 = this.mBufferType;
        if (i10 != -1) {
            return i10;
        }
        throw new IllegalArgumentException("Buffer type is not set");
    }

    public long getEGLContextHandle() {
        return this.eglRenderer.getEglContext().getNativeEglContext();
    }

    public EglRenderer getEglRender() {
        return this.eglRenderer;
    }

    public int getPixelFormat() {
        int i10 = this.mPixelFormat;
        if (i10 != -1) {
            return i10;
        }
        throw new IllegalArgumentException("Pixel format is not set");
    }

    public void init(EglBase.Context context) {
        init(context, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(surfaceTexture);
        this.mHasEglSurface = true;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i10, i11);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() { // from class: io.agora.rtc.mediaio.BaseVideoRenderer.5
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        Log.e(TAG, "onSurfaceTextureSizeChanged: width- " + i10 + ", height: " + i11);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void setBufferType(MediaIO.BufferType bufferType) {
        this.mBufferType = bufferType.intValue();
    }

    public void setPixelFormat(MediaIO.PixelFormat pixelFormat) {
        this.mPixelFormat = pixelFormat.intValue();
    }

    public void setRenderSurface(Surface surface) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurface = surface;
            this.eglRenderer.createEglSurface(surface);
            this.mHasEglSurface = true;
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setRenderView(SurfaceView surfaceView, SurfaceHolder.Callback callback) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurfaceView = surfaceView;
            this.mSurfaceViewListener = callback;
            surfaceView.getHolder().addCallback(this);
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public boolean start() {
        this.mStarted = true;
        return true;
    }

    public void stop() {
        this.mStarted = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        ThreadUtils.checkIsOnMainThread();
        Log.e(TAG, "surfaceChanged: format: " + i10 + " size: " + i11 + "x" + i12);
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i10, i11, i12);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(surfaceHolder.getSurface());
        this.mHasEglSurface = true;
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() { // from class: io.agora.rtc.mediaio.BaseVideoRenderer.4
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }

    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.init(context, iArr, glDrawer);
    }

    private void rendRGBAFrame(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        final ByteBuffer wrap = ByteBuffer.wrap(bArr);
        VideoFrame videoFrame = new VideoFrame(new RgbaBuffer(wrap, i11, i12, new Runnable() { // from class: io.agora.rtc.mediaio.BaseVideoRenderer.3
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoRenderer.this.releaseBuffer(wrap);
            }
        }), i13, j10);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    public void consume(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, long j10) {
        if (this.mStarted) {
            if (i10 == 1) {
                rendI420Frame(byteBuffer, i10, i11, i12, i13, j10);
            } else if (i10 == 4) {
                rendRGBAFrame(byteBuffer, i10, i11, i12, i13, j10);
            }
        }
    }

    private void rendI420Frame(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        JavaI420Buffer createYUV;
        if (bArr == null || bArr.length == 0 || (createYUV = JavaI420Buffer.createYUV(bArr, i11, i12)) == null) {
            return;
        }
        VideoFrame videoFrame = new VideoFrame(createYUV, i13, j10);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    public void setRenderSurface(SurfaceTexture surfaceTexture) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurfaceTexture = surfaceTexture;
            this.eglRenderer.createEglSurface(surfaceTexture);
            this.mHasEglSurface = true;
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setRenderView(TextureView textureView, TextureView.SurfaceTextureListener surfaceTextureListener) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mTextureView = textureView;
            this.mSurfaceTextureListener = surfaceTextureListener;
            textureView.setSurfaceTextureListener(this);
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void consume(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
        if (this.mStarted) {
            if (i10 == 1) {
                rendI420Frame(bArr, i10, i11, i12, i13, j10);
            } else if (i10 == 4) {
                rendRGBAFrame(bArr, i10, i11, i12, i13, j10);
            }
        }
    }
}
