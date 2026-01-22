package x3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import n3.u;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f١٨٩٢٣a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f١٨٩٢٤b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal f١٨٩٢٥c = new c();

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f١٨٩٢٦d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static final float f١٨٩٢٧e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c extends ThreadLocal {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d extends ThreadLocal {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f10, float f11, float f12) {
        com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = (PathMeasure) f١٨٩٢٣a.get();
        Path path2 = (Path) f١٨٩٢٤b.get();
        Path path3 = (Path) f١٨٩٢٥c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f10 == 1.0f && f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            com.airbnb.lottie.e.c("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f11 - f10) - 1.0f) >= 0.01d) {
            float f13 = f10 * length;
            float f14 = f11 * length;
            float f15 = f12 * length;
            float min = Math.min(f13, f14) + f15;
            float max = Math.max(f13, f14) + f15;
            if (min >= length && max >= length) {
                min = k.f(min, length);
                max = k.f(max, length);
            }
            if (min < DownloadProgress.UNKNOWN_PROGRESS) {
                min = k.f(min, length);
            }
            if (max < DownloadProgress.UNKNOWN_PROGRESS) {
                max = k.f(max, length);
            }
            if (min == max) {
                path.reset();
                com.airbnb.lottie.e.c("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(DownloadProgress.UNKNOWN_PROGRESS, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < DownloadProgress.UNKNOWN_PROGRESS) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.airbnb.lottie.e.c("applyTrimPathIfNeeded");
            return;
        }
        com.airbnb.lottie.e.c("applyTrimPathIfNeeded");
    }

    public static void b(Path path, u uVar) {
        if (uVar != null && !uVar.k()) {
            a(path, ((o3.d) uVar.i()).q() / 100.0f, ((o3.d) uVar.d()).q() / 100.0f, ((o3.d) uVar.g()).q() / 360.0f);
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != DownloadProgress.UNKNOWN_PROGRESS || pointF4.length() != DownloadProgress.UNKNOWN_PROGRESS)) {
            float f10 = pointF3.x + pointF.x;
            float f11 = pointF.y + pointF3.y;
            float f12 = pointF2.x;
            float f13 = f12 + pointF4.x;
            float f14 = pointF2.y;
            path.cubicTo(f10, f11, f13, f14 + pointF4.y, f12, f14);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = (float[]) f١٨٩٢٦d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f10 = f١٨٩٢٧e;
        fArr[2] = f10;
        fArr[3] = f10;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = (float[]) f١٨٩٢٦d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static int i(float f10, float f11, float f12, float f13) {
        int i10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            i10 = (int) (527 * f10);
        } else {
            i10 = 17;
        }
        if (f11 != DownloadProgress.UNKNOWN_PROGRESS) {
            i10 = (int) (i10 * 31 * f11);
        }
        if (f12 != DownloadProgress.UNKNOWN_PROGRESS) {
            i10 = (int) (i10 * 31 * f12);
        }
        if (f13 != DownloadProgress.UNKNOWN_PROGRESS) {
            return (int) (i10 * 31 * f13);
        }
        return i10;
    }

    public static boolean j(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i10 < i13) {
            return false;
        }
        if (i10 > i13) {
            return true;
        }
        if (i11 < i14) {
            return false;
        }
        if (i11 <= i14 && i12 < i15) {
            return false;
        }
        return true;
    }

    public static boolean k(Throwable th) {
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static Bitmap l(Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void m(Canvas canvas, RectF rectF, Paint paint) {
        n(canvas, rectF, paint, 31);
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint, int i10) {
        com.airbnb.lottie.e.b("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i10);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.e.c("Utils#saveLayer");
    }
}
