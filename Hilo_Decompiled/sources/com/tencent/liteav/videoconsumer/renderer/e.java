package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class e extends RenderViewHelperInterface {
    private final String a;
    private final CustomHandler b;
    private final RenderViewHelperInterface.RenderViewListener c;
    private SurfaceView d;
    private final Size e;
    private final Size f;
    private GLConstants.GLScaleType g;
    private boolean h;
    private boolean i;
    private final SurfaceHolder.Callback j;
    private final View.OnLayoutChangeListener k;

    public e(String str, SurfaceView surfaceView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.b = customHandler;
        this.e = new Size();
        this.f = new Size();
        this.g = null;
        this.h = false;
        this.i = true;
        this.j = new SurfaceHolder.Callback() { // from class: com.tencent.liteav.videoconsumer.renderer.e.1
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                if (surfaceHolder != null) {
                    LiteavLog.i(e.this.a, "surfaceChanged,format=%d,Size(%dx%d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    e.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (surfaceHolder != null) {
                    Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                    LiteavLog.i(e.this.a, "surfaceCreated,Size(%dx%d)", Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
                    e.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                LiteavLog.i(e.this.a, "surfaceDestroyed");
                e.this.a();
            }
        };
        this.k = new View.OnLayoutChangeListener() { // from class: com.tencent.liteav.videoconsumer.renderer.e.2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (e.this.h) {
                    if (e.this.f.width != view.getWidth() || e.this.f.height != view.getHeight()) {
                        e.this.b();
                    }
                }
            }
        };
        String str2 = str + "SurfaceViewRenderHelper_" + hashCode();
        this.a = str2;
        this.c = renderViewListener;
        if (surfaceView == null) {
            LiteavLog.w(str2, "surfaceView is null.");
        } else {
            this.d = surfaceView;
            customHandler.post(f.a(this, surfaceView));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(e eVar) {
        SurfaceView surfaceView = eVar.d;
        if (surfaceView == null) {
            LiteavLog.i(eVar.a, "view is not available when surfaceView is null");
            return;
        }
        Surface surface = surfaceView.getHolder().getSurface();
        boolean z = surface != null && surface.isValid();
        if (!z || eVar.d.getWidth() == 0 || eVar.d.getHeight() == 0 || !eVar.d.isShown()) {
            String str = eVar.a;
            SurfaceView surfaceView2 = eVar.d;
            LiteavLog.i(str, "%s is not available when isShown:%b, surface isValid:%b", surfaceView2, Boolean.valueOf(surfaceView2.isShown()), Boolean.valueOf(z));
        }
        eVar.i = eVar.d.isShown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(e eVar) {
        LiteavLog.i(eVar.a, "release,mSurfaceView=" + eVar.d);
        if (eVar.d == null) {
            return;
        }
        eVar.a();
        eVar.d.getHolder().removeCallback(eVar.j);
        eVar.d = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.b.post(h.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void enableNonUniformScale(boolean z) {
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, i / 2.0f, i2 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return false;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isVisible() {
        return this.i;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z) {
        this.b.post(g.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i, int i2, boolean z) {
        if (this.g == gLScaleType && this.h == z) {
            Size size = this.e;
            if (size.width == i && size.height == i2) {
                return;
            }
        }
        this.h = z;
        this.g = gLScaleType;
        this.e.set(i, i2);
        if (this.h) {
            this.b.runOrPost(i.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar, SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        if (holder.getSurface().isValid()) {
            Surface surface = holder.getSurface();
            Rect surfaceFrame = holder.getSurfaceFrame();
            LiteavLog.i(eVar.a, "construct,surface=%s,Size(%dx%d)", surface, Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            eVar.a(surface);
        } else {
            LiteavLog.i(eVar.a, "construct,surfaceView not valid.");
        }
        holder.addCallback(eVar.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L٢٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        r2 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L١٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        double d;
        SurfaceView surfaceView = this.d;
        if (surfaceView == null || !(surfaceView.getParent() instanceof TXCloudVideoView)) {
            return;
        }
        TXCloudVideoView tXCloudVideoView = (TXCloudVideoView) this.d.getParent();
        Size size = new Size(tXCloudVideoView.getWidth(), tXCloudVideoView.getHeight());
        if (this.e.isValid() && size.isValid()) {
            if (!this.f.isValid()) {
                tXCloudVideoView.addOnLayoutChangeListener(this.k);
            }
            this.f.set(size);
            double aspectRatio = size.aspectRatio();
            double aspectRatio2 = this.e.aspectRatio();
            double d2 = 1.0d;
            if (aspectRatio2 < aspectRatio) {
                GLConstants.GLScaleType gLScaleType = this.g;
                if (gLScaleType != GLConstants.GLScaleType.FIT_CENTER) {
                }
                double d3 = aspectRatio2 / aspectRatio;
                d = 1.0d;
                d2 = d3;
            } else {
                GLConstants.GLScaleType gLScaleType2 = this.g;
                if (gLScaleType2 != GLConstants.GLScaleType.FIT_CENTER) {
                }
                d = aspectRatio / aspectRatio2;
            }
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            layoutParams.width = (int) (size.getWidth() * d2);
            layoutParams.height = (int) (size.getHeight() * d);
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            this.d.setLayoutParams(layoutParams);
            LiteavLog.i(this.a, "adjust view size to %d*%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface) {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }
}
