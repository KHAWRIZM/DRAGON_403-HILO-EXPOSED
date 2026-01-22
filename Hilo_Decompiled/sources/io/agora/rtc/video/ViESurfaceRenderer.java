package io.agora.rtc.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.facebook.internal.security.CertificateUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.internal.Logging;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ViESurfaceRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "ViESurfaceRenderer";
    private SurfaceHolder surfaceHolder;
    private Bitmap bitmap = null;
    private ByteBuffer byteBuffer = null;
    private Rect source = new Rect();
    private Rect dest = new Rect();
    private float topScale = DownloadProgress.UNKNOWN_PROGRESS;
    private float bottomScale = 1.0f;
    private float leftScale = DownloadProgress.UNKNOWN_PROGRESS;
    private float rightScale = 1.0f;

    public ViESurfaceRenderer(SurfaceView surfaceView) {
        Logging.i(TAG, "surface view " + surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        this.surfaceHolder = holder;
        if (holder == null) {
            return;
        }
        holder.addCallback(this);
        surfaceCreated(this.surfaceHolder);
    }

    private void changeDestRect(int i10, int i11) {
        this.dest.right = (int) (r0.left + (Math.abs(this.leftScale - this.rightScale) * i10));
        this.dest.bottom = (int) (r0.top + (Math.abs(this.topScale - this.bottomScale) * i11));
        Logging.i(TAG, "ViESurfaceRender::surfaceChanged in_width:" + i10 + " in_height:" + i11 + " source.left:" + this.source.left + " source.top:" + this.source.top + " source.dest:" + this.source.right + " source.bottom:" + this.source.bottom + " dest.left:" + this.dest.left + " dest.top:" + this.dest.top + " dest.dest:" + this.dest.right + " dest.bottom:" + this.dest.bottom + " dest scale " + this.rightScale + " bottom scale " + this.bottomScale);
    }

    private void saveBitmapToJPEG(int i10, int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(String.format("/sdcard/render_%d.jpg", Long.valueOf(System.currentTimeMillis())));
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            Logging.i(TAG, "saved jpg " + fileOutputStream.toString());
        } catch (IOException e10) {
            Logging.e(TAG, "save jpg failed", e10);
        }
    }

    public Bitmap CreateBitmap(int i10, int i11) {
        Logging.d(TAG, "CreateByteBitmap " + i10 + CertificateUtil.DELIMITER + i11);
        if (this.bitmap == null) {
            try {
                Process.setThreadPriority(-4);
            } catch (Exception unused) {
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.RGB_565);
        this.bitmap = createBitmap;
        Rect rect = this.source;
        rect.left = 0;
        rect.top = 0;
        rect.bottom = i11;
        rect.right = i10;
        return createBitmap;
    }

    public ByteBuffer CreateByteBuffer(int i10, int i11) {
        Logging.i(TAG, "CreateByteBuffer " + i10 + " * " + i11);
        this.bitmap = CreateBitmap(i10, i11);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i10 * i11 * 2);
        this.byteBuffer = allocateDirect;
        return allocateDirect;
    }

    public void DrawBitmap() {
        Canvas lockCanvas;
        if (this.bitmap != null && (lockCanvas = this.surfaceHolder.lockCanvas()) != null) {
            lockCanvas.drawBitmap(this.bitmap, this.source, this.dest, (Paint) null);
            this.surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    public void DrawByteBuffer() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer == null) {
            Logging.w(TAG, "DrawByteBuffer null");
            return;
        }
        byteBuffer.rewind();
        this.bitmap.copyPixelsFromBuffer(this.byteBuffer);
        DrawBitmap();
    }

    public void SetCoordinates(float f10, float f11, float f12, float f13) {
        Logging.i(TAG, "SetCoordinates " + f10 + "," + f11 + " : " + f12 + "," + f13);
        this.leftScale = f10;
        this.topScale = f11;
        this.rightScale = f12;
        this.bottomScale = f13;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        changeDestRect(i11, i12);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas lockCanvas = this.surfaceHolder.lockCanvas();
        if (lockCanvas != null) {
            Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
            if (surfaceFrame != null) {
                changeDestRect(surfaceFrame.right - surfaceFrame.left, surfaceFrame.bottom - surfaceFrame.top);
                Logging.i(TAG, "ViESurfaceRender::surfaceCreated dst.left:" + surfaceFrame.left + " dst.top:" + surfaceFrame.top + " dst.dest:" + surfaceFrame.right + " dst.bottom:" + surfaceFrame.bottom + " source.left:" + this.source.left + " source.top:" + this.source.top + " source.dest:" + this.source.right + " source.bottom:" + this.source.bottom + " dest.left:" + this.dest.left + " dest.top:" + this.dest.top + " dest.dest:" + this.dest.right + " dest.bottom:" + this.dest.bottom);
            }
            this.surfaceHolder.unlockCanvasAndPost(lockCanvas);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Logging.d(TAG, "ViESurfaceRenderer::surfaceDestroyed");
        this.bitmap = null;
        this.byteBuffer = null;
    }
}
