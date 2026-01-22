package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.bumptech.glide.integration.webp.b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import o4.v;
import v4.i0;
import v4.o;
import v4.u;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    public static final m4.h f٧٣٣٧e = m4.h.f("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);

    /* renamed from: f, reason: collision with root package name */
    public static final m4.h f٧٣٣٨f = m4.h.f("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.SystemDecoder", Boolean.TRUE);

    /* renamed from: g, reason: collision with root package name */
    private static final u.b f٧٣٣٩g = new a();

    /* renamed from: h, reason: collision with root package name */
    private static final Queue f٧٣٤٠h = f5.l.g(0);

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f٧٣٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f٧٣٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final p4.b f٧٣٤٣c;

    /* renamed from: d, reason: collision with root package name */
    private final List f٧٣٤٤d;

    public l(List list, DisplayMetrics displayMetrics, p4.d dVar, p4.b bVar) {
        this.f٧٣٤٤d = list;
        this.f٧٣٤٢b = (DisplayMetrics) f5.k.d(displayMetrics);
        this.f٧٣٤١a = (p4.d) f5.k.d(dVar);
        this.f٧٣٤٣c = (p4.b) f5.k.d(bVar);
    }

    private static int a(double d10) {
        return s((d10 / (r0 / 1.0E9f)) * s(1.0E9d * d10));
    }

    private void b(InputStream inputStream, m4.b bVar, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        boolean z12;
        Bitmap.Config config;
        if (bVar != m4.b.PREFER_ARGB_8888) {
            try {
                z12 = com.bumptech.glide.load.a.f(this.f٧٣٤٤d, inputStream, this.f٧٣٤٣c).hasAlpha();
            } catch (IOException e10) {
                if (Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e10);
                }
                z12 = false;
            }
            if (z12) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ALPHA_8) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, u.b bVar, p4.d dVar, v4.o oVar, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) {
        float b10;
        int min;
        int floor;
        double floor2;
        int i15;
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        if (i10 != 90 && i10 != 270) {
            b10 = oVar.b(i11, i12, i13, i14);
        } else {
            b10 = oVar.b(i12, i11, i13, i14);
        }
        if (b10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            throw new IllegalArgumentException("Cannot scale with factor: " + b10 + " from: " + oVar + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
        }
        o.g a10 = oVar.a(i11, i12, i13, i14);
        if (a10 != null) {
            float f10 = i11;
            float f11 = i12;
            int s10 = i11 / s(b10 * f10);
            int s11 = i12 / s(b10 * f11);
            o.g gVar = o.g.MEMORY;
            if (a10 == gVar) {
                min = Math.max(s10, s11);
            } else {
                min = Math.min(s10, s11);
            }
            int max = Math.max(1, Integer.highestOneBit(min));
            if (a10 == gVar && max < 1.0f / b10) {
                max <<= 1;
            }
            options.inSampleSize = max;
            if (imageType == ImageHeaderParser.ImageType.JPEG) {
                float min2 = Math.min(max, 8);
                floor = (int) Math.ceil(f10 / min2);
                i15 = (int) Math.ceil(f11 / min2);
                int i16 = max / 8;
                if (i16 > 0) {
                    floor /= i16;
                    i15 /= i16;
                }
            } else {
                if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                    if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                        if (i11 % max == 0 && i12 % max == 0) {
                            floor = i11 / max;
                            i15 = i12 / max;
                        } else {
                            int[] j10 = j(inputStream, options, bVar, dVar);
                            floor = j10[0];
                            i15 = j10[1];
                        }
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        float f12 = max;
                        floor = Math.round(f10 / f12);
                        i15 = Math.round(f11 / f12);
                    } else {
                        float f13 = max;
                        floor = (int) Math.floor(f10 / f13);
                        floor2 = Math.floor(f11 / f13);
                    }
                } else {
                    float f14 = max;
                    floor = (int) Math.floor(f10 / f14);
                    floor2 = Math.floor(f11 / f14);
                }
                i15 = (int) floor2;
            }
            double b11 = oVar.b(floor, i15, i13, i14);
            options.inTargetDensity = a(b11);
            options.inDensity = 1000000000;
            if (n(options)) {
                options.inScaled = true;
            } else {
                options.inTargetDensity = 0;
                options.inDensity = 0;
            }
            if (Log.isLoggable("WebpDownsampler", 2)) {
                Log.v("WebpDownsampler", "Calculate scaling, source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "], power of two scaled: [" + floor + "x" + i15 + "], exact scale factor: " + b10 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + b11 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot round with null rounding");
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, v4.o oVar, m4.b bVar, boolean z10, int i10, int i11, boolean z11, u.b bVar2) {
        boolean z12;
        int i12;
        int i13;
        int i14;
        float f10;
        int round;
        int round2;
        long b10 = f5.g.b();
        int[] j10 = j(inputStream, options, bVar2, this.f٧٣٤١a);
        int i15 = j10[0];
        int i16 = j10[1];
        String str = options.outMimeType;
        if (i15 != -1 && i16 != -1) {
            z12 = z10;
        } else {
            z12 = false;
        }
        int b11 = com.bumptech.glide.load.a.b(this.f٧٣٤٤d, inputStream, this.f٧٣٤٣c);
        int j11 = i0.j(b11);
        boolean m10 = i0.m(b11);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i15;
        } else {
            i12 = i10;
        }
        if (i11 == Integer.MIN_VALUE) {
            i13 = i16;
        } else {
            i13 = i11;
        }
        ImageHeaderParser.ImageType f11 = com.bumptech.glide.load.a.f(this.f٧٣٤٤d, inputStream, this.f٧٣٤٣c);
        c(f11, inputStream, bVar2, this.f٧٣٤١a, oVar, j11, i15, i16, i12, i13, options);
        b(inputStream, bVar, z12, m10, options, i12, i13);
        if (u(f11)) {
            if (z11) {
                round = i12;
                round2 = i13;
            } else {
                if (n(options)) {
                    f10 = options.inTargetDensity / options.inDensity;
                } else {
                    f10 = 1.0f;
                }
                int i17 = options.inSampleSize;
                float f12 = i17;
                int ceil = (int) Math.ceil(i15 / f12);
                int ceil2 = (int) Math.ceil(i16 / f12);
                round = Math.round(ceil * f10);
                round2 = Math.round(ceil2 * f10);
                if (Log.isLoggable("WebpDownsampler", 2)) {
                    Log.v("WebpDownsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i15 + "x" + i16 + "], sampleSize: " + i17 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f10);
                }
            }
            if (round > 0 && round2 > 0) {
                t(options, this.f٧٣٤١a, round, round2);
            }
        }
        Bitmap g10 = g(inputStream, options, bVar2, this.f٧٣٤١a);
        bVar2.a(this.f٧٣٤١a, g10);
        if (Log.isLoggable("WebpDownsampler", 2)) {
            i14 = b11;
            o(i15, i16, str, options, g10, i10, i11, b10);
        } else {
            i14 = b11;
        }
        if (g10 != null) {
            g10.setDensity(this.f٧٣٤٢b.densityDpi);
            Bitmap n10 = i0.n(this.f٧٣٤١a, g10, i14);
            if (!g10.equals(n10)) {
                this.f٧٣٤١a.d(g10);
                return n10;
            }
            return n10;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap g(InputStream inputStream, BitmapFactory.Options options, u.b bVar, p4.d dVar) {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            bVar.b();
        }
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        String str = options.outMimeType;
        i0.i().lock();
        try {
            try {
                Bitmap decodeStream = WebpBitmapFactory.decodeStream(inputStream, null, options);
                i0.i().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e10) {
                IOException p10 = p(e10, i10, i11, str, options);
                if (Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", p10);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        dVar.d(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap g10 = g(inputStream, options, bVar, dVar);
                        i0.i().unlock();
                        return g10;
                    } catch (IOException unused) {
                        throw p10;
                    }
                }
                throw p10;
            }
        } catch (Throwable th) {
            i0.i().unlock();
            throw th;
        }
    }

    private static String h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options options;
        synchronized (l.class) {
            Queue queue = f٧٣٤٠h;
            synchronized (queue) {
                options = (BitmapFactory.Options) queue.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                r(options);
            }
        }
        return options;
    }

    private static int[] j(InputStream inputStream, BitmapFactory.Options options, u.b bVar, p4.d dVar) {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String k(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean n(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        if (i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10) {
            return true;
        }
        return false;
    }

    private static void o(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("WebpDownsampler", "Decoded " + h(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + k(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + f5.g.a(j10));
    }

    private static IOException p(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + k(options), illegalArgumentException);
    }

    private static void q(BitmapFactory.Options options) {
        r(options);
        Queue queue = f٧٣٤٠h;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void r(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int s(double d10) {
        return (int) (d10 + 0.5d);
    }

    private static void t(BitmapFactory.Options options, p4.d dVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config2 = options.inPreferredConfig;
            config = Bitmap.Config.HARDWARE;
            if (config2 == config) {
                return;
            }
        }
        options.inBitmap = dVar.g(i10, i11, options.inPreferredConfig);
    }

    private boolean u(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public v d(InputStream inputStream, int i10, int i11, m4.i iVar) {
        return e(inputStream, i10, i11, iVar, f٧٣٣٩g);
    }

    public v e(InputStream inputStream, int i10, int i11, m4.i iVar, u.b bVar) {
        boolean z10;
        f5.k.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f٧٣٤٣c.c(65536, byte[].class);
        BitmapFactory.Options i12 = i();
        i12.inTempStorage = bArr;
        m4.b bVar2 = (m4.b) iVar.a(u.f١٨٥٤٦f);
        v4.o oVar = (v4.o) iVar.a(u.f١٨٥٤٨h);
        boolean booleanValue = ((Boolean) iVar.a(u.f١٨٥٤٩i)).booleanValue();
        m4.h hVar = u.f١٨٥٥٠j;
        if (iVar.a(hVar) != null && ((Boolean) iVar.a(hVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            return v4.f.b(f(inputStream, i12, oVar, bVar2, z10, i10, i11, booleanValue, bVar), this.f٧٣٤١a);
        } finally {
            q(i12);
            this.f٧٣٤٣c.e(bArr, byte[].class);
        }
    }

    public boolean l(InputStream inputStream, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣٣٧e)).booleanValue()) {
            return false;
        }
        if (((Boolean) iVar.a(f٧٣٣٨f)).booleanValue()) {
            if (com.bumptech.glide.integration.webp.b.f٧٢٩٠a) {
                return false;
            }
            b.e b10 = com.bumptech.glide.integration.webp.b.b(inputStream, this.f٧٣٤٣c);
            if (!com.bumptech.glide.integration.webp.b.g(b10) || b10 == b.e.WEBP_SIMPLE) {
                return false;
            }
            return true;
        }
        return com.bumptech.glide.integration.webp.b.g(com.bumptech.glide.integration.webp.b.b(inputStream, this.f٧٣٤٣c));
    }

    public boolean m(ByteBuffer byteBuffer, m4.i iVar) {
        if (((Boolean) iVar.a(f٧٣٣٧e)).booleanValue()) {
            return false;
        }
        if (((Boolean) iVar.a(f٧٣٣٨f)).booleanValue()) {
            if (com.bumptech.glide.integration.webp.b.f٧٢٩٠a) {
                return false;
            }
            b.e c10 = com.bumptech.glide.integration.webp.b.c(byteBuffer);
            if (!com.bumptech.glide.integration.webp.b.g(c10) || c10 == b.e.WEBP_SIMPLE) {
                return false;
            }
            return true;
        }
        return com.bumptech.glide.integration.webp.b.g(com.bumptech.glide.integration.webp.b.c(byteBuffer));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements u.b {
        a() {
        }

        @Override // v4.u.b
        public void b() {
        }

        @Override // v4.u.b
        public void a(p4.d dVar, Bitmap bitmap) {
        }
    }
}
