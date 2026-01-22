package com.tencent.liteav.videoproducer.capture;

import android.opengl.GLES20;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.h;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomFrameToPixelFrameConverter {
    private static final String TAG = "CustomFrameToPixelFrameConverter";
    private final Object mSharedContext;
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private EGLCore mEGLCore = null;
    private h mPixelFrameRenderer = null;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool = null;
    private int mWidth = 0;
    private int mHeight = 0;

    public CustomFrameToPixelFrameConverter(Object obj) {
        this.mSharedContext = obj;
    }

    private void initializeGLComponents(int i, int i2, PixelFrame pixelFrame) {
        Object obj;
        if (this.mEGLCore != null) {
            LiteavLog.w(this.mThrottlers.a("initGL"), TAG, "egl is initialized!", new Object[0]);
            return;
        }
        if (pixelFrame.getGLContext() != null) {
            obj = pixelFrame.getGLContext();
        } else {
            obj = this.mSharedContext;
        }
        try {
            EGLCore eGLCore = new EGLCore();
            this.mEGLCore = eGLCore;
            eGLCore.initialize(obj, null, i, i2);
            this.mEGLCore.makeCurrent();
            LiteavLog.i(this.mThrottlers.a("initSuccess"), TAG, "initialize egl, width: " + i + ", height: " + i2 + ", sharedContext: " + obj, new Object[0]);
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(this.mThrottlers.a("initError"), TAG, "initialize egl failed.", e);
            this.mEGLCore = null;
        }
        if (this.mEGLCore != null) {
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
            if (this.mPixelFrameRenderer == null) {
                this.mPixelFrameRenderer = new h(i, i2);
            }
        }
    }

    private boolean isNeedRecreateEGL(PixelFrame pixelFrame, EGLCore eGLCore) {
        boolean z;
        if (pixelFrame.getGLContext() != null && !CommonUtil.equals(pixelFrame.getGLContext(), eGLCore.getSharedContext())) {
            z = true;
        } else {
            z = false;
        }
        if (pixelFrame.getHeight() == this.mHeight && pixelFrame.getWidth() == this.mWidth && !z) {
            return false;
        }
        return true;
    }

    private void uninitializedGLComponents() {
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null) {
            return;
        }
        try {
            eGLCore.makeCurrent();
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(this.mThrottlers.a("make"), TAG, "uninitialize egl, make current error ", e);
        }
        LiteavLog.i(this.mThrottlers.a("uninitGL"), TAG, "uninitialize egl", new Object[0]);
        h hVar = this.mPixelFrameRenderer;
        if (hVar != null) {
            hVar.a();
            this.mPixelFrameRenderer = null;
        }
        com.tencent.liteav.videobase.frame.e eVar = this.mGLTexturePool;
        if (eVar != null) {
            eVar.a();
            this.mGLTexturePool.b();
            this.mGLTexturePool = null;
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }

    public PixelFrame convertFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            LiteavLog.w(TAG, "convertFrame: pixelFrame is null.");
            return null;
        }
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null || isNeedRecreateEGL(pixelFrame, eGLCore)) {
            this.mWidth = pixelFrame.getWidth();
            this.mHeight = pixelFrame.getHeight();
            uninitializedGLComponents();
            initializeGLComponents(this.mWidth, this.mHeight, pixelFrame);
        }
        EGLCore eGLCore2 = this.mEGLCore;
        if (eGLCore2 == null || this.mGLTexturePool == null || this.mPixelFrameRenderer == null) {
            return null;
        }
        try {
            eGLCore2.makeCurrent();
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(TAG, "EGL makeCurrent error ", e);
        }
        OpenGlUtils.glViewport(0, 0, this.mWidth, this.mHeight);
        com.tencent.liteav.videobase.frame.d a = this.mGLTexturePool.a(this.mWidth, this.mHeight);
        this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a);
        GLES20.glFinish();
        PixelFrame a2 = a.a(this.mEGLCore.getEglContext());
        a2.setTimestamp(pixelFrame.getTimestamp());
        a.release();
        return a2;
    }

    public void release() {
        uninitializedGLComponents();
    }

    public void releaseFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }
}
