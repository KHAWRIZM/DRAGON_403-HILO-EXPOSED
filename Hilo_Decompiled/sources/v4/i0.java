package v4;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Paint f١٨٥٠٤a = new Paint(6);

    /* renamed from: b, reason: collision with root package name */
    private static final Paint f١٨٥٠٥b = new Paint(7);

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f١٨٥٠٦c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set f١٨٥٠٧d;

    /* renamed from: e, reason: collision with root package name */
    private static final Lock f١٨٥٠٨e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f١٨٥٠٩a;

        a(int i10) {
            this.f١٨٥٠٩a = i10;
        }

        @Override // v4.i0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i10 = this.f١٨٥٠٩a;
            canvas.drawRoundRect(rectF, i10, i10, paint);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f١٨٥١٠a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f١٨٥١١b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f١٨٥١٢c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f١٨٥١٣d;

        b(float f10, float f11, float f12, float f13) {
            this.f١٨٥١٠a = f10;
            this.f١٨٥١١b = f11;
            this.f١٨٥١٢c = f12;
            this.f١٨٥١٣d = f13;
        }

        @Override // v4.i0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f10 = this.f١٨٥١٠a;
            float f11 = this.f١٨٥١١b;
            float f12 = this.f١٨٥١٢c;
            float f13 = this.f١٨٥١٣d;
            path.addRoundRect(rectF, new float[]{f10, f10, f11, f11, f12, f12, f13, f13}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class d implements Lock {
        d() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        Lock dVar;
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f١٨٥٠٧d = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            dVar = new ReentrantLock();
        } else {
            dVar = new d();
        }
        f١٨٥٠٨e = dVar;
        Paint paint = new Paint(7);
        f١٨٥٠٦c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f١٨٥٠٨e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f١٨٥٠٤a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f١٨٥٠٨e.unlock();
            throw th;
        }
    }

    public static Bitmap b(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        float width;
        float height;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int width2 = bitmap.getWidth() * i11;
        int height2 = bitmap.getHeight() * i10;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        if (width2 > height2) {
            width = i11 / bitmap.getHeight();
            f10 = (i10 - (bitmap.getWidth() * width)) * 0.5f;
            height = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            width = i10 / bitmap.getWidth();
            height = (i11 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f10 + 0.5f), (int) (height + 0.5f));
        Bitmap f11 = dVar.f(i10, i11, k(bitmap));
        r(bitmap, f11);
        a(bitmap, f11, matrix);
        return f11;
    }

    public static Bitmap c(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() <= i10 && bitmap.getHeight() <= i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return f(dVar, bitmap, i10, i11);
    }

    public static Bitmap d(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        int min = Math.min(i10, i11);
        float f10 = min;
        float f11 = f10 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f10 / width, f10 / height);
        float f12 = width * max;
        float f13 = max * height;
        float f14 = (f10 - f12) / 2.0f;
        float f15 = (f10 - f13) / 2.0f;
        RectF rectF = new RectF(f14, f15, f12 + f14, f13 + f15);
        Bitmap g10 = g(dVar, bitmap);
        Bitmap f16 = dVar.f(min, min, h(bitmap));
        f16.setHasAlpha(true);
        Lock lock = f١٨٥٠٨e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f16);
            canvas.drawCircle(f11, f11, f11, f١٨٥٠٥b);
            canvas.drawBitmap(g10, (Rect) null, rectF, f١٨٥٠٦c);
            e(canvas);
            lock.unlock();
            if (!g10.equals(bitmap)) {
                dVar.d(g10);
            }
            return f16;
        } catch (Throwable th) {
            f١٨٥٠٨e.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(p4.d dVar, Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap f10 = dVar.f((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), k(bitmap));
        r(bitmap, f10);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i10 + "x" + i11);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + f10.getWidth() + "x" + f10.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, f10, matrix);
        return f10;
    }

    private static Bitmap g(p4.d dVar, Bitmap bitmap) {
        Bitmap.Config h10 = h(bitmap);
        if (h10.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap f10 = dVar.f(bitmap.getWidth(), bitmap.getHeight(), h10);
        new Canvas(f10).drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (Paint) null);
        return f10;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            if (config.equals(bitmap.getConfig())) {
                config2 = Bitmap.Config.RGBA_F16;
                return config2;
            }
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return f١٨٥٠٨e;
    }

    public static int j(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap.Config.ARGB_8888;
    }

    static void l(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean m(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(p4.d dVar, Bitmap bitmap, int i10) {
        if (!m(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i10, matrix);
        RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap f10 = dVar.f(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        f10.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, f10, matrix);
        return f10;
    }

    public static Bitmap o(p4.d dVar, Bitmap bitmap, float f10, float f11, float f12, float f13) {
        return q(dVar, bitmap, new b(f10, f11, f12, f13));
    }

    public static Bitmap p(p4.d dVar, Bitmap bitmap, int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f5.k.a(z10, "roundingRadius must be greater than 0.");
        return q(dVar, bitmap, new a(i10));
    }

    private static Bitmap q(p4.d dVar, Bitmap bitmap, c cVar) {
        Bitmap.Config h10 = h(bitmap);
        Bitmap g10 = g(dVar, bitmap);
        Bitmap f10 = dVar.f(g10.getWidth(), g10.getHeight(), h10);
        f10.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(g10, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10.getWidth(), f10.getHeight());
        Lock lock = f١٨٥٠٨e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f10);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!g10.equals(bitmap)) {
                dVar.d(g10);
            }
            return f10;
        } catch (Throwable th) {
            f١٨٥٠٨e.unlock();
            throw th;
        }
    }

    public static void r(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
