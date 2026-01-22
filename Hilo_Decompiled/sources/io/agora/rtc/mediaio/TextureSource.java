package io.agora.rtc.mediaio;

import android.graphics.SurfaceTexture;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.mediaio.MediaIO;
import io.agora.rtc.mediaio.SurfaceTextureHelper;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class TextureSource implements IVideoSource, SurfaceTextureHelper.OnTextureFrameAvailableListener {
    protected WeakReference<IVideoFrameConsumer> mConsumer;
    protected int mHeight;
    protected int mPixelFormat = 11;
    protected SurfaceTextureHelper mSurfaceTextureHelper;
    protected int mWidth;

    public TextureSource(EglBase.Context context, int i10, int i11) {
        this.mWidth = i10;
        this.mHeight = i11;
        SurfaceTextureHelper create = SurfaceTextureHelper.create("TexCamThread", context);
        this.mSurfaceTextureHelper = create;
        create.getSurfaceTexture().setDefaultBufferSize(i10, i11);
        this.mSurfaceTextureHelper.startListening(this);
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getBufferType() {
        return 3;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getCaptureType() {
        return MediaIO.CaptureType.CAMERA.intValue();
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getContentHint() {
        return MediaIO.ContentHint.NONE.intValue();
    }

    public EglBase.Context getEglContext() {
        return this.mSurfaceTextureHelper.getEglContext();
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTextureHelper.getSurfaceTexture();
    }

    protected abstract void onCapturerClosed();

    protected abstract boolean onCapturerOpened();

    protected abstract boolean onCapturerStarted();

    protected abstract void onCapturerStopped();

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onDispose() {
        this.mConsumer = null;
        onCapturerClosed();
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        this.mConsumer = new WeakReference<>(iVideoFrameConsumer);
        return onCapturerOpened();
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onStart() {
        return onCapturerStarted();
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onStop() {
        onCapturerStopped();
    }

    public void onTextureFrameAvailable(int i10, float[] fArr, long j10) {
        this.mSurfaceTextureHelper.returnTextureFrame();
    }

    public void release() {
        this.mSurfaceTextureHelper.stopListening();
        this.mSurfaceTextureHelper.dispose();
        this.mSurfaceTextureHelper = null;
    }

    public void onTextureFrameAvailable(int i10, MediaIO.PixelFormat pixelFormat, float[] fArr, long j10) {
        this.mSurfaceTextureHelper.returnTextureFrame();
    }

    public TextureSource(EglBase.Context context, int i10, int i11, boolean z10) {
        this.mWidth = i10;
        this.mHeight = i11;
        SurfaceTextureHelper create = SurfaceTextureHelper.create("TexCamThreadOesTo2D", context, z10, i10, i11);
        this.mSurfaceTextureHelper = create;
        create.getSurfaceTexture().setDefaultBufferSize(i10, i11);
        this.mSurfaceTextureHelper.startListening(this);
    }
}
