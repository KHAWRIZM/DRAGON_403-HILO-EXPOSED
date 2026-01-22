package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpImage;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.nio.ByteBuffer;
import l4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j implements l4.a {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f٧٣٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private WebpImage f٧٣٢٤b;

    /* renamed from: c, reason: collision with root package name */
    private final a.InterfaceC٠١٨٦a f٧٣٢٥c;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٣٢٦d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f٧٣٢٧e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.integration.webp.a[] f٧٣٢٨f;

    /* renamed from: g, reason: collision with root package name */
    private int f٧٣٢٩g;

    /* renamed from: h, reason: collision with root package name */
    private int f٧٣٣٠h;

    /* renamed from: i, reason: collision with root package name */
    private int f٧٣٣١i;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f٧٣٣٢j;

    /* renamed from: k, reason: collision with root package name */
    private q f٧٣٣٣k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap.Config f٧٣٣٤l;

    /* renamed from: m, reason: collision with root package name */
    private final LruCache f٧٣٣٥m;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends LruCache {
        a(int i10) {
            super(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z10, Integer num, Bitmap bitmap, Bitmap bitmap2) {
            if (bitmap != null) {
                j.this.f٧٣٢٥c.a(bitmap);
            }
        }
    }

    public j(a.InterfaceC٠١٨٦a r72, WebpImage webpImage, ByteBuffer byteBuffer, int i10) {
        this(r72, webpImage, byteBuffer, i10, q.f٧٣٥٩c);
    }

    private void j(int i10, Bitmap bitmap) {
        this.f٧٣٣٥m.remove(Integer.valueOf(i10));
        Bitmap c10 = this.f٧٣٢٥c.c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        c10.eraseColor(0);
        c10.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(c10);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (Paint) null);
        this.f٧٣٣٥m.put(Integer.valueOf(i10), c10);
    }

    private void k(Canvas canvas, com.bumptech.glide.integration.webp.a aVar) {
        int i10 = aVar.f٧٢٨٣b;
        int i11 = this.f٧٣٢٩g;
        int i12 = aVar.f٧٢٨٤c;
        canvas.drawRect(i10 / i11, i12 / i11, (i10 + aVar.f٧٢٨٥d) / i11, (i12 + aVar.f٧٢٨٦e) / i11, this.f٧٣٣٢j);
    }

    private boolean o(com.bumptech.glide.integration.webp.a aVar) {
        if (aVar.f٧٢٨٣b == 0 && aVar.f٧٢٨٤c == 0 && aVar.f٧٢٨٥d == this.f٧٣٢٤b.getWidth() && aVar.f٧٢٨٦e == this.f٧٣٢٤b.getHeight()) {
            return true;
        }
        return false;
    }

    private boolean p(int i10) {
        if (i10 == 0) {
            return true;
        }
        com.bumptech.glide.integration.webp.a[] aVarArr = this.f٧٣٢٨f;
        com.bumptech.glide.integration.webp.a aVar = aVarArr[i10];
        com.bumptech.glide.integration.webp.a aVar2 = aVarArr[i10 - 1];
        if (!aVar.f٧٢٨٨g && o(aVar)) {
            return true;
        }
        if (aVar2.f٧٢٨٩h && o(aVar2)) {
            return true;
        }
        return false;
    }

    private int q(int i10, Canvas canvas) {
        while (i10 >= 0) {
            com.bumptech.glide.integration.webp.a aVar = this.f٧٣٢٨f[i10];
            if (aVar.f٧٢٨٩h && o(aVar)) {
                return i10 + 1;
            }
            Bitmap bitmap = (Bitmap) this.f٧٣٣٥m.get(Integer.valueOf(i10));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (Paint) null);
                if (aVar.f٧٢٨٩h) {
                    k(canvas, aVar);
                }
                return i10 + 1;
            }
            if (p(i10)) {
                return i10;
            }
            i10--;
        }
        return 0;
    }

    private void r(int i10, Canvas canvas) {
        com.bumptech.glide.integration.webp.a aVar = this.f٧٣٢٨f[i10];
        int i11 = aVar.f٧٢٨٥d;
        int i12 = this.f٧٣٢٩g;
        int i13 = i11 / i12;
        int i14 = aVar.f٧٢٨٦e / i12;
        int i15 = aVar.f٧٢٨٣b / i12;
        int i16 = aVar.f٧٢٨٤c / i12;
        if (i13 != 0 && i14 != 0) {
            WebpFrame frame = this.f٧٣٢٤b.getFrame(i10);
            try {
                try {
                    Bitmap c10 = this.f٧٣٢٥c.c(i13, i14, this.f٧٣٣٤l);
                    c10.eraseColor(0);
                    c10.setDensity(canvas.getDensity());
                    frame.renderFrame(i13, i14, c10);
                    canvas.drawBitmap(c10, i15, i16, (Paint) null);
                    this.f٧٣٢٥c.a(c10);
                } catch (IllegalArgumentException | IllegalStateException unused) {
                    Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i10);
                }
            } finally {
                frame.dispose();
            }
        }
    }

    @Override // l4.a
    public Bitmap a() {
        int i10;
        Bitmap bitmap;
        int i11;
        int g10 = g();
        Bitmap c10 = this.f٧٣٢٥c.c(this.f٧٣٣١i, this.f٧٣٣٠h, Bitmap.Config.ARGB_8888);
        c10.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            i11 = DisplayMetrics.DENSITY_DEVICE_STABLE;
            c10.setDensity(i11);
        }
        Canvas canvas = new Canvas(c10);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!this.f٧٣٣٣k.c() && (bitmap = (Bitmap) this.f٧٣٣٥m.get(Integer.valueOf(g10))) != null) {
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "hit frame bitmap from memory cache, frameNumber=" + g10);
            }
            bitmap.setDensity(canvas.getDensity());
            canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (Paint) null);
            return c10;
        }
        if (!p(g10)) {
            i10 = q(g10 - 1, canvas);
        } else {
            i10 = g10;
        }
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "frameNumber=" + g10 + ", nextIndex=" + i10);
        }
        while (i10 < g10) {
            com.bumptech.glide.integration.webp.a aVar = this.f٧٣٢٨f[i10];
            if (!aVar.f٧٢٨٨g) {
                k(canvas, aVar);
            }
            r(i10, canvas);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "renderFrame, index=" + i10 + ", blend=" + aVar.f٧٢٨٨g + ", dispose=" + aVar.f٧٢٨٩h);
            }
            if (aVar.f٧٢٨٩h) {
                k(canvas, aVar);
            }
            i10++;
        }
        com.bumptech.glide.integration.webp.a aVar2 = this.f٧٣٢٨f[g10];
        if (!aVar2.f٧٢٨٨g) {
            k(canvas, aVar2);
        }
        r(g10, canvas);
        if (Log.isLoggable("WebpDecoder", 3)) {
            Log.d("WebpDecoder", "renderFrame, index=" + g10 + ", blend=" + aVar2.f٧٢٨٨g + ", dispose=" + aVar2.f٧٢٨٩h);
        }
        j(g10, c10);
        return c10;
    }

    @Override // l4.a
    public void b() {
        this.f٧٣٢٦d = (this.f٧٣٢٦d + 1) % this.f٧٣٢٤b.getFrameCount();
    }

    @Override // l4.a
    public int c() {
        return this.f٧٣٢٤b.getFrameCount();
    }

    @Override // l4.a
    public void clear() {
        this.f٧٣٢٤b.dispose();
        this.f٧٣٢٤b = null;
        this.f٧٣٣٥m.evictAll();
        this.f٧٣٢٣a = null;
    }

    @Override // l4.a
    public void d(Bitmap.Config config) {
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config == config2) {
            this.f٧٣٣٤l = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config2);
    }

    @Override // l4.a
    public int e() {
        int i10;
        if (this.f٧٣٢٧e.length != 0 && (i10 = this.f٧٣٢٦d) >= 0) {
            return m(i10);
        }
        return 0;
    }

    @Override // l4.a
    public void f() {
        this.f٧٣٢٦d = -1;
    }

    @Override // l4.a
    public int g() {
        return this.f٧٣٢٦d;
    }

    @Override // l4.a
    public ByteBuffer getData() {
        return this.f٧٣٢٣a;
    }

    @Override // l4.a
    public int h() {
        return this.f٧٣٢٤b.getSizeInBytes();
    }

    public q l() {
        return this.f٧٣٣٣k;
    }

    public int m(int i10) {
        if (i10 >= 0) {
            int[] iArr = this.f٧٣٢٧e;
            if (i10 < iArr.length) {
                return iArr[i10];
            }
        }
        return -1;
    }

    public int n() {
        if (this.f٧٣٢٤b.getLoopCount() == 0) {
            return 0;
        }
        return this.f٧٣٢٤b.getLoopCount();
    }

    public void s(l4.c cVar, ByteBuffer byteBuffer, int i10) {
        if (i10 > 0) {
            int highestOneBit = Integer.highestOneBit(i10);
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f٧٣٢٣a = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f٧٣٢٩g = highestOneBit;
            this.f٧٣٣١i = this.f٧٣٢٤b.getWidth() / highestOneBit;
            this.f٧٣٣٠h = this.f٧٣٢٤b.getHeight() / highestOneBit;
            return;
        }
        throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
    }

    public j(a.InterfaceC٠١٨٦a r52, WebpImage webpImage, ByteBuffer byteBuffer, int i10, q qVar) {
        int max;
        this.f٧٣٢٦d = -1;
        this.f٧٣٣٤l = Bitmap.Config.ARGB_8888;
        this.f٧٣٢٥c = r52;
        this.f٧٣٢٤b = webpImage;
        this.f٧٣٢٧e = webpImage.getFrameDurations();
        this.f٧٣٢٨f = new com.bumptech.glide.integration.webp.a[webpImage.getFrameCount()];
        for (int i11 = 0; i11 < this.f٧٣٢٤b.getFrameCount(); i11++) {
            this.f٧٣٢٨f[i11] = this.f٧٣٢٤b.getFrameInfo(i11);
            if (Log.isLoggable("WebpDecoder", 3)) {
                Log.d("WebpDecoder", "mFrameInfos: " + this.f٧٣٢٨f[i11].toString());
            }
        }
        this.f٧٣٣٣k = qVar;
        Paint paint = new Paint();
        this.f٧٣٣٢j = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (this.f٧٣٣٣k.a()) {
            max = webpImage.getFrameCount();
        } else {
            max = Math.max(5, this.f٧٣٣٣k.b());
        }
        this.f٧٣٣٥m = new a(max);
        s(new l4.c(), byteBuffer, i10);
    }
}
