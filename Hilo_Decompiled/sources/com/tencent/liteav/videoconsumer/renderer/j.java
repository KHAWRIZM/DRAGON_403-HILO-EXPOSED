package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class j extends RenderViewHelperInterface implements TextureView.SurfaceTextureListener {
    private final String a;
    private final CustomHandler b;
    private final com.tencent.liteav.base.b.b c;
    private final RenderViewHelperInterface.RenderViewListener d;
    private final TXCloudVideoView e;
    private TextureView f;
    private boolean g;
    private final Size h;
    private GLConstants.GLScaleType i;
    private boolean j;
    private boolean k;
    private Matrix l;
    private boolean m;
    private SurfaceTexture n;
    private Surface o;
    private final Size p;

    public j(String str, TXCloudVideoView tXCloudVideoView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        this(str, renderViewListener, tXCloudVideoView, null);
        if (this.e == null) {
            LiteavLog.e(this.a, "construct: txCloudVideoView is null.");
            return;
        }
        LiteavLog.i(this.a, "construct: txCloudVideoView=" + this.e);
        this.b.post(k.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar, boolean z) {
        LiteavLog.i(jVar.a, "release: clearLastImage=".concat(String.valueOf(z)));
        TextureView textureView = jVar.f;
        if (textureView == null) {
            return;
        }
        if (textureView.getSurfaceTextureListener() == jVar) {
            jVar.f.setSurfaceTextureListener(null);
        }
        Surface surface = jVar.o;
        if (surface != null) {
            surface.release();
            jVar.o = null;
        }
        if (jVar.n != null) {
            SurfaceTexture surfaceTexture = jVar.f.getSurfaceTexture();
            SurfaceTexture surfaceTexture2 = jVar.n;
            if (surfaceTexture != surfaceTexture2) {
                surfaceTexture2.release();
            }
        }
        TXCloudVideoView tXCloudVideoView = jVar.e;
        if (tXCloudVideoView != null) {
            TXCCloudVideoViewMethodInvoker.removeViewInternal(tXCloudVideoView, jVar.f, z);
        }
        jVar.n = null;
        jVar.f = null;
        jVar.g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(j jVar) {
        jVar.b();
        jVar.c();
        TextureView textureView = jVar.f;
        if (textureView == null || textureView.getVisibility() == 0) {
            return;
        }
        jVar.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(j jVar) {
        TextureView textureView = jVar.f;
        if (textureView == null) {
            LiteavLog.w(jVar.a, "checkViewAvailability: textureView is null");
            return;
        }
        if (!textureView.isAvailable() || jVar.f.getWidth() == 0 || jVar.f.getHeight() == 0 || !jVar.f.isShown()) {
            LiteavLog.w(jVar.a, "checkViewAvailability: %s, %s", a(jVar.f), a(jVar.e));
        }
        if (jVar.e != null && jVar.f.getVisibility() != 0) {
            jVar.f.setVisibility(0);
        }
        jVar.j = jVar.f.isShown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(j jVar) {
        TextureView textureView;
        LiteavLog.i(jVar.a, "first frame rendered");
        TXCloudVideoView tXCloudVideoView = jVar.e;
        if (tXCloudVideoView != null && (textureView = jVar.f) != null) {
            TXCCloudVideoViewMethodInvoker.notifyFirstFrameRendered(tXCloudVideoView, textureView);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.b.runOrPost(n.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final synchronized void enableNonUniformScale(boolean z) {
        if (this.m == z) {
            return;
        }
        this.m = z;
        LiteavLog.i(this.a, "enableNonUniformScale: ".concat(String.valueOf(z)));
        this.b.post(p.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i, int i2) {
        Matrix matrix = new Matrix(this.l);
        matrix.postScale(1.0f, -1.0f, i / 2.0f, i2 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isVisible() {
        return this.j;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        LiteavLog.i(this.a, "onSurfaceTextureAvailable, size:" + i + "x" + i2 + " surfaceTexture:" + surfaceTexture);
        a(surfaceTexture, i, i2);
        b();
        checkViewAvailability();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        LiteavLog.i(this.a, "onSurfaceTextureDestroyed surface:".concat(String.valueOf(surfaceTexture)));
        this.k = false;
        if (this.n == surfaceTexture) {
            return false;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        TextureView textureView;
        Bitmap bitmap;
        boolean z2 = false;
        LiteavLog.i(this.c.a("surfaceSizeChanged"), this.a, "onSurfaceTextureSizeChanged: %dx%d --> %dx%d", Integer.valueOf(this.p.width), Integer.valueOf(this.p.height), Integer.valueOf(i), Integer.valueOf(i2));
        Size size = this.p;
        if (size.width > size.height) {
            z = true;
        } else {
            z = false;
        }
        a(surfaceTexture, i, i2);
        b();
        if (i > i2) {
            z2 = true;
        }
        if (z != z2 && this.d != null && (textureView = this.f) != null && (bitmap = textureView.getBitmap()) != null) {
            this.d.onRequestRedraw(bitmap);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.k) {
            return;
        }
        this.k = true;
        checkViewAvailability();
        this.b.post(q.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z) {
        this.b.post(m.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final synchronized void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i, int i2, boolean z) {
        if (this.i == gLScaleType) {
            Size size = this.h;
            if (i == size.width && i2 == size.height) {
                return;
            }
        }
        LiteavLog.i(this.a, "updateVideoFrameInfo: scaleType: %s, width: %d, height: %d", gLScaleType, Integer.valueOf(i), Integer.valueOf(i2));
        this.i = gLScaleType;
        this.h.set(i, i2);
        this.b.runOrPost(o.a(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if (r3 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L٢٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void b() {
        double d;
        TextureView textureView = this.f;
        if (textureView == null) {
            return;
        }
        if (!this.m) {
            Matrix matrix = new Matrix();
            this.l = matrix;
            this.f.setTransform(matrix);
            this.f.postInvalidate();
            LiteavLog.i(this.c.a("resetTextureViewRenderMatrix"), this.a, "resetTextureViewRenderMatrix", new Object[0]);
            return;
        }
        Size size = new Size(textureView.getWidth(), this.f.getHeight());
        if (this.h.isValid() && size.isValid()) {
            double aspectRatio = size.aspectRatio();
            double aspectRatio2 = this.h.aspectRatio();
            double d2 = 1.0d;
            if (aspectRatio2 < aspectRatio) {
                GLConstants.GLScaleType gLScaleType = this.i;
                if (gLScaleType != GLConstants.GLScaleType.FIT_CENTER) {
                }
                double d3 = aspectRatio2 / aspectRatio;
                d = 1.0d;
                d2 = d3;
            } else {
                GLConstants.GLScaleType gLScaleType2 = this.i;
                if (gLScaleType2 == GLConstants.GLScaleType.FIT_CENTER) {
                    d = aspectRatio / aspectRatio2;
                } else {
                    if (gLScaleType2 == GLConstants.GLScaleType.CENTER_CROP) {
                        double d32 = aspectRatio2 / aspectRatio;
                        d = 1.0d;
                        d2 = d32;
                    }
                    d = 1.0d;
                }
            }
            Matrix matrix2 = new Matrix();
            matrix2.setScale((float) d2, (float) d, size.width / 2.0f, size.height / 2.0f);
            if (!matrix2.equals(this.f.getTransform(new Matrix()))) {
                this.f.setTransform(matrix2);
                this.f.postInvalidate();
                LiteavLog.i(this.c.a("updateTextureViewMatrix"), this.a, "updateTextureViewRenderMatrix: view: %s, scaleX: %.2f, scaleY: %.2f, frame: %s, view: %s", this.f, Double.valueOf(d2), Double.valueOf(d), this.h, size);
            }
            this.l = matrix2;
            return;
        }
        LiteavLog.i(this.c.a("updateTextureViewMatrixFailure"), this.a, "updateTextureViewRenderMatrix, invalid frameSize: %s, viewSize: %s", this.h.toString(), size.toString());
    }

    public j(String str, TextureView textureView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        this(str, renderViewListener, null, textureView);
        if (this.f == null) {
            LiteavLog.e(this.a, "construct: textureView is null.");
            return;
        }
        LiteavLog.i(this.a, "construct: textureView=" + this.f);
        this.b.post(l.a(this));
    }

    private j(String str, RenderViewHelperInterface.RenderViewListener renderViewListener, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        this.b = new CustomHandler(Looper.getMainLooper());
        this.c = new com.tencent.liteav.base.b.b();
        this.g = false;
        this.h = new Size();
        this.i = null;
        this.j = true;
        this.k = false;
        this.l = new Matrix();
        this.m = true;
        this.p = new Size();
        this.a = str + "TextureViewRenderHelper_" + hashCode();
        this.d = renderViewListener;
        this.e = tXCloudVideoView;
        this.f = textureView;
    }

    private synchronized void c() {
        TextureView textureView = this.f;
        if (textureView == null) {
            return;
        }
        if (!this.m && this.i == GLConstants.GLScaleType.FIT_CENTER) {
            textureView.setOpaque(false);
        } else {
            textureView.setOpaque(true);
        }
    }

    private static String a(View view) {
        if (view == null) {
            return "null";
        }
        String format = String.format("%s: is_shown:%b, visibility:%s, window_visibility:%s, size:%dx%d", view.getClass().getSimpleName(), Boolean.valueOf(view.isShown()), Integer.valueOf(view.getVisibility()), Integer.valueOf(view.getWindowVisibility()), Integer.valueOf(view.getWidth()), Integer.valueOf(view.getHeight()));
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 19) {
            format = format + String.format(", is_attached:%b", Boolean.valueOf(view.isAttachedToWindow()));
        }
        if (!(view instanceof TextureView)) {
            return format;
        }
        return format + String.format(", is_surface_available:%s", Boolean.valueOf(((TextureView) view).isAvailable()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar) {
        jVar.b();
        jVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f == null && this.e == null) {
            LiteavLog.e(this.a, "setup: null view");
            return;
        }
        TXCloudVideoView tXCloudVideoView = this.e;
        if (tXCloudVideoView != null) {
            TextureView freeTextureView = TXCCloudVideoViewMethodInvoker.getFreeTextureView(tXCloudVideoView);
            this.f = freeTextureView;
            if (freeTextureView == null) {
                this.f = new TextureView(this.e.getContext());
            }
            TXCCloudVideoViewMethodInvoker.addViewInternal(this.e, this.f);
            LiteavLog.i(this.a, "setup: add view: " + this.f);
        }
        this.f.setSurfaceTextureListener(this);
        if (!this.f.isAvailable()) {
            LiteavLog.i(this.a, "setup: textureView not available.");
            checkViewAvailability();
            return;
        }
        Size size = new Size(this.f.getWidth(), this.f.getHeight());
        LiteavLog.i(this.a, "setup: " + this.f + "," + size + ", isShown=" + this.f.isShown());
        a(this.f.getSurfaceTexture(), size.width, size.height);
    }

    private void a(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.n;
        if (surfaceTexture2 == null) {
            this.n = surfaceTexture;
        } else if (surfaceTexture != surfaceTexture2) {
            LiteavLog.i(this.a, "notifySurfaceChanged: reset surfaceTexture: " + this.n);
            this.f.setSurfaceTexture(this.n);
        }
        this.p.set(i, i2);
        if (this.o == null) {
            Surface surface = new Surface(this.n);
            this.o = surface;
            RenderViewHelperInterface.RenderViewListener renderViewListener = this.d;
            if (renderViewListener != null) {
                renderViewListener.onSurfaceChanged(surface, false);
            }
        }
    }
}
