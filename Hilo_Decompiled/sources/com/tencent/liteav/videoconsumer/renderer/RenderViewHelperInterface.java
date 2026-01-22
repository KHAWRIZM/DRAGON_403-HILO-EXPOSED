package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.rtmp.ui.TXCloudVideoView;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class RenderViewHelperInterface {
    private static final String TAG = "RenderViewHelperInterface";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DisplayTarget.a.values().length];
            a = iArr;
            try {
                iArr[DisplayTarget.a.SURFACEVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DisplayTarget.a.TEXTUREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DisplayTarget.a.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DisplayTarget.a.TXCLOUDVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface RenderViewListener {
        void onRequestRedraw(Bitmap bitmap);

        void onSurfaceChanged(Surface surface, boolean z);

        void onSurfaceDestroy();
    }

    public static RenderViewHelperInterface create(String str, DisplayTarget displayTarget, RenderViewListener renderViewListener) {
        Surface surface;
        TextureView textureView;
        SurfaceView surfaceView;
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget == null || displayTarget.getType() == null) {
            LiteavLog.w(TAG, "displayTarget or type is null. displayTarget=".concat(String.valueOf(displayTarget)));
            return null;
        }
        int i = AnonymousClass1.a[displayTarget.getType().ordinal()];
        if (i == 1) {
            surface = null;
            textureView = null;
            surfaceView = displayTarget.getSurfaceView();
            tXCloudVideoView = null;
        } else if (i != 2) {
            if (i == 3) {
                surface = displayTarget.getSurface();
                tXCloudVideoView = null;
            } else if (i != 4) {
                surface = null;
                tXCloudVideoView = null;
            } else {
                TXCloudVideoView tXCloudVideoView2 = displayTarget.getTXCloudVideoView();
                if (tXCloudVideoView2 == null) {
                    LiteavLog.w(TAG, "txCloudVideoView is null.");
                    surfaceView = null;
                    textureView = null;
                    tXCloudVideoView = tXCloudVideoView2;
                    surface = null;
                } else {
                    SurfaceView surfaceView2 = tXCloudVideoView2.getSurfaceView();
                    textureView = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView2);
                    surfaceView = surfaceView2;
                    tXCloudVideoView = tXCloudVideoView2;
                    surface = null;
                }
            }
            surfaceView = tXCloudVideoView;
            textureView = surfaceView;
        } else {
            surface = null;
            tXCloudVideoView = null;
            textureView = displayTarget.getTextureView();
            surfaceView = null;
        }
        if (surfaceView != null) {
            return new e(str, surfaceView, renderViewListener);
        }
        if (textureView != null) {
            return new j(str, textureView, renderViewListener);
        }
        if (surface != null) {
            return new a(str, surface, renderViewListener);
        }
        if (tXCloudVideoView == null) {
            LiteavLog.w(TAG, "RenderViewHelper not created. displayTarget=".concat(String.valueOf(displayTarget)));
            return null;
        }
        return new j(str, tXCloudVideoView, renderViewListener);
    }

    public static GLConstants.GLScaleType createScaleType(int i) {
        return GLConstants.GLScaleType.a(i);
    }

    public static void releaseSurface(Surface surface) {
        if (surface != null) {
            surface.release();
        }
    }

    public static void setBackgroundColor(DisplayTarget displayTarget, int i) {
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget != null && displayTarget.getType() != null) {
            if (AnonymousClass1.a[displayTarget.getType().ordinal()] == 4 && (tXCloudVideoView = displayTarget.getTXCloudVideoView()) != null) {
                TXCCloudVideoViewMethodInvoker.setBackgroundColorForInternalView(tXCloudVideoView, i);
                return;
            }
            return;
        }
        LiteavLog.w(TAG, "displayTarget or type is null. displayTarget=".concat(String.valueOf(displayTarget)));
    }

    public abstract void checkViewAvailability();

    public abstract void enableNonUniformScale(boolean z);

    public abstract Matrix getTransformMatrix(int i, int i2);

    public abstract boolean isUsingTextureView();

    public abstract boolean isVisible();

    public abstract void release(boolean z);

    public abstract void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i, int i2, boolean z);

    public static RenderViewHelperInterface create(DisplayTarget displayTarget, RenderViewListener renderViewListener) {
        return create("", displayTarget, renderViewListener);
    }
}
