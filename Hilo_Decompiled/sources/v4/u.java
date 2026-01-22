package v4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import v4.a0;
import v4.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class u {

    /* renamed from: f, reason: collision with root package name */
    public static final m4.h f١٨٥٤٦f = m4.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", m4.b.f١٥٩٦٥c);

    /* renamed from: g, reason: collision with root package name */
    public static final m4.h f١٨٥٤٧g = m4.h.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h, reason: collision with root package name */
    public static final m4.h f١٨٥٤٨h = o.f١٨٥٤١h;

    /* renamed from: i, reason: collision with root package name */
    public static final m4.h f١٨٥٤٩i;

    /* renamed from: j, reason: collision with root package name */
    public static final m4.h f١٨٥٥٠j;

    /* renamed from: k, reason: collision with root package name */
    private static final Set f١٨٥٥١k;

    /* renamed from: l, reason: collision with root package name */
    private static final b f١٨٥٥٢l;

    /* renamed from: m, reason: collision with root package name */
    private static final Set f١٨٥٥٣m;

    /* renamed from: n, reason: collision with root package name */
    private static final Queue f١٨٥٥٤n;

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f١٨٥٥٥a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f١٨٥٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private final p4.b f١٨٥٥٧c;

    /* renamed from: d, reason: collision with root package name */
    private final List f١٨٥٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private final z f١٨٥٥٩e = z.b();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(p4.d dVar, Bitmap bitmap);

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f١٨٥٤٩i = m4.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f١٨٥٥٠j = m4.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f١٨٥٥١k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f١٨٥٥٢l = new a();
        f١٨٥٥٣m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f١٨٥٥٤n = f5.l.g(0);
    }

    public u(List list, DisplayMetrics displayMetrics, p4.d dVar, p4.b bVar) {
        this.f١٨٥٥٨d = list;
        this.f١٨٥٥٦b = (DisplayMetrics) f5.k.d(displayMetrics);
        this.f١٨٥٥٥a = (p4.d) f5.k.d(dVar);
        this.f١٨٥٥٧c = (p4.b) f5.k.d(bVar);
    }

    private static int a(double d10) {
        return x((d10 / (r1 / r0)) * x(l(d10) * d10));
    }

    private void b(a0 a0Var, m4.b bVar, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        boolean z12;
        Bitmap.Config config;
        if (this.f١٨٥٥٩e.g(i10, i11, options, z10, z11)) {
            return;
        }
        if (bVar != m4.b.PREFER_ARGB_8888) {
            try {
                z12 = a0Var.d().hasAlpha();
            } catch (IOException e10) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e10);
                }
                z12 = false;
            }
            if (z12) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, a0 a0Var, b bVar, p4.d dVar, o oVar, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) {
        int i15;
        int i16;
        int min;
        int i17;
        int floor;
        double floor2;
        int i18;
        if (i11 > 0 && i12 > 0) {
            if (r(i10)) {
                i16 = i11;
                i15 = i12;
            } else {
                i15 = i11;
                i16 = i12;
            }
            float b10 = oVar.b(i15, i16, i13, i14);
            if (b10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                throw new IllegalArgumentException("Cannot scale with factor: " + b10 + " from: " + oVar + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
            }
            o.g a10 = oVar.a(i15, i16, i13, i14);
            if (a10 != null) {
                float f10 = i15;
                float f11 = i16;
                int x10 = i15 / x(b10 * f10);
                int x11 = i16 / x(b10 * f11);
                o.g gVar = o.g.MEMORY;
                if (a10 == gVar) {
                    min = Math.max(x10, x11);
                } else {
                    min = Math.min(x10, x11);
                }
                int i19 = Build.VERSION.SDK_INT;
                if (i19 > 23 || !f١٨٥٥١k.contains(options.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    if (a10 == gVar && max < 1.0f / b10) {
                        max <<= 1;
                    }
                    i17 = max;
                } else {
                    i17 = 1;
                }
                options.inSampleSize = i17;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(i17, 8);
                    floor = (int) Math.ceil(f10 / min2);
                    i18 = (int) Math.ceil(f11 / min2);
                    int i20 = i17 / 8;
                    if (i20 > 0) {
                        floor /= i20;
                        i18 /= i20;
                    }
                } else {
                    if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType.isWebp()) {
                            if (i19 >= 24) {
                                float f12 = i17;
                                floor = Math.round(f10 / f12);
                                i18 = Math.round(f11 / f12);
                            } else {
                                float f13 = i17;
                                floor = (int) Math.floor(f10 / f13);
                                floor2 = Math.floor(f11 / f13);
                            }
                        } else if (i15 % i17 == 0 && i16 % i17 == 0) {
                            floor = i15 / i17;
                            i18 = i16 / i17;
                        } else {
                            int[] m10 = m(a0Var, options, bVar, dVar);
                            floor = m10[0];
                            i18 = m10[1];
                        }
                    } else {
                        float f14 = i17;
                        floor = (int) Math.floor(f10 / f14);
                        floor2 = Math.floor(f11 / f14);
                    }
                    i18 = (int) floor2;
                }
                double b11 = oVar.b(floor, i18, i13, i14);
                options.inTargetDensity = a(b11);
                options.inDensity = l(b11);
                if (s(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculate scaling, source: [" + i11 + "x" + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + "x" + i14 + "], power of two scaled: [" + floor + "x" + i18 + "], exact scale factor: " + b10 + ", power of 2 sample size: " + i17 + ", adjusted scale factor: " + b11 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + "x" + i14 + "]");
        }
    }

    private o4.v g(a0 a0Var, int i10, int i11, m4.i iVar, b bVar) {
        boolean z10;
        byte[] bArr = (byte[]) this.f١٨٥٥٧c.c(65536, byte[].class);
        BitmapFactory.Options k10 = k();
        k10.inTempStorage = bArr;
        m4.b bVar2 = (m4.b) iVar.a(f١٨٥٤٦f);
        m4.j jVar = (m4.j) iVar.a(f١٨٥٤٧g);
        o oVar = (o) iVar.a(o.f١٨٥٤١h);
        boolean booleanValue = ((Boolean) iVar.a(f١٨٥٤٩i)).booleanValue();
        m4.h hVar = f١٨٥٥٠j;
        if (iVar.a(hVar) != null && ((Boolean) iVar.a(hVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            return f.b(h(a0Var, k10, oVar, bVar2, jVar, z10, i10, i11, booleanValue, bVar), this.f١٨٥٥٥a);
        } finally {
            v(k10);
            this.f١٨٥٥٧c.put(bArr);
        }
    }

    private Bitmap h(a0 a0Var, BitmapFactory.Options options, o oVar, m4.b bVar, m4.j jVar, boolean z10, int i10, int i11, boolean z11, b bVar2) {
        boolean z12;
        int i12;
        int i13;
        int i14;
        String str;
        int i15;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        float f10;
        int round;
        int i16;
        int i17;
        long b10 = f5.g.b();
        int[] m10 = m(a0Var, options, bVar2, this.f١٨٥٥٥a);
        int i18 = m10[0];
        int i19 = m10[1];
        String str2 = options.outMimeType;
        if (i18 != -1 && i19 != -1) {
            z12 = z10;
        } else {
            z12 = false;
        }
        int c10 = a0Var.c();
        int j10 = i0.j(c10);
        boolean m11 = i0.m(c10);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i11;
            if (r(j10)) {
                i13 = i19;
            } else {
                i13 = i18;
            }
        } else {
            i12 = i11;
            i13 = i10;
        }
        if (i12 == Integer.MIN_VALUE) {
            if (r(j10)) {
                i14 = i18;
            } else {
                i14 = i19;
            }
        } else {
            i14 = i12;
        }
        ImageHeaderParser.ImageType d10 = a0Var.d();
        c(d10, a0Var, bVar2, this.f١٨٥٥٥a, oVar, j10, i18, i19, i13, i14, options);
        b(a0Var, bVar, z12, m11, options, i13, i14);
        int i20 = Build.VERSION.SDK_INT;
        if (!z(d10)) {
            str = "Downsampler";
        } else {
            if (i18 >= 0 && i19 >= 0 && z11) {
                str = "Downsampler";
                i17 = i13;
                round = i14;
            } else {
                if (s(options)) {
                    f10 = options.inTargetDensity / options.inDensity;
                } else {
                    f10 = 1.0f;
                }
                int i21 = options.inSampleSize;
                float f11 = i21;
                int ceil = (int) Math.ceil(i18 / f11);
                int ceil2 = (int) Math.ceil(i19 / f11);
                int round2 = Math.round(ceil * f10);
                round = Math.round(ceil2 * f10);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(round2);
                    sb.append("x");
                    sb.append(round);
                    i16 = round2;
                    sb.append("] for source [");
                    sb.append(i18);
                    sb.append("x");
                    sb.append(i19);
                    sb.append("], sampleSize: ");
                    sb.append(i21);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f10);
                    Log.v(str, sb.toString());
                } else {
                    i16 = round2;
                }
                i17 = i16;
            }
            if (i17 > 0 && round > 0) {
                y(options, this.f١٨٥٥٥a, i17, round);
            }
        }
        if (jVar != null) {
            if (i20 >= 28) {
                if (jVar == m4.j.DISPLAY_P3) {
                    colorSpace3 = options.outColorSpace;
                    if (colorSpace3 != null) {
                        colorSpace4 = options.outColorSpace;
                        isWideGamut = colorSpace4.isWideGamut();
                        if (isWideGamut) {
                            named2 = ColorSpace.Named.DISPLAY_P3;
                            colorSpace2 = ColorSpace.get(named2);
                            options.inPreferredColorSpace = colorSpace2;
                        }
                    }
                }
                named2 = ColorSpace.Named.SRGB;
                colorSpace2 = ColorSpace.get(named2);
                options.inPreferredColorSpace = colorSpace2;
            } else if (i20 >= 26) {
                named = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(named);
                options.inPreferredColorSpace = colorSpace;
            }
        }
        Bitmap i22 = i(a0Var, options, bVar2, this.f١٨٥٥٥a);
        bVar2.a(this.f١٨٥٥٥a, i22);
        if (Log.isLoggable(str, 2)) {
            i15 = c10;
            t(i18, i19, str2, options, i22, i10, i11, b10);
        } else {
            i15 = c10;
        }
        if (i22 != null) {
            i22.setDensity(this.f١٨٥٥٦b.densityDpi);
            Bitmap n10 = i0.n(this.f١٨٥٥٥a, i22, i15);
            if (!i22.equals(n10)) {
                this.f١٨٥٥٥a.d(i22);
                return n10;
            }
            return n10;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap i(a0 a0Var, BitmapFactory.Options options, b bVar, p4.d dVar) {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            a0Var.b();
        }
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        String str = options.outMimeType;
        i0.i().lock();
        try {
            try {
                Bitmap a10 = a0Var.a(options);
                i0.i().unlock();
                return a10;
            } catch (IllegalArgumentException e10) {
                IOException u10 = u(e10, i10, i11, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", u10);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        dVar.d(bitmap);
                        options.inBitmap = null;
                        Bitmap i12 = i(a0Var, options, bVar, dVar);
                        i0.i().unlock();
                        return i12;
                    } catch (IOException unused) {
                        throw u10;
                    }
                }
                throw u10;
            }
        } catch (Throwable th) {
            i0.i().unlock();
            throw th;
        }
    }

    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        synchronized (u.class) {
            Queue queue = f١٨٥٥٤n;
            synchronized (queue) {
                options = (BitmapFactory.Options) queue.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                w(options);
            }
        }
        return options;
    }

    private static int l(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static int[] m(a0 a0Var, BitmapFactory.Options options, b bVar, p4.d dVar) {
        options.inJustDecodeBounds = true;
        i(a0Var, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i10) {
        if (i10 != 90 && i10 != 270) {
            return false;
        }
        return true;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        if (i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10) {
            return true;
        }
        return false;
    }

    private static void t(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + n(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + f5.g.a(j10));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = f١٨٥٥٤n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d10) {
        return (int) (d10 + 0.5d);
    }

    private static void y(BitmapFactory.Options options, p4.d dVar, int i10, int i11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config3 = options.inPreferredConfig;
            config2 = Bitmap.Config.HARDWARE;
            if (config3 != config2) {
                config = options.outConfig;
            } else {
                return;
            }
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.g(i10, i11, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public o4.v d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, m4.i iVar) {
        return g(new a0.c(parcelFileDescriptor, this.f١٨٥٥٨d, this.f١٨٥٥٧c), i10, i11, iVar, f١٨٥٥٢l);
    }

    public o4.v e(InputStream inputStream, int i10, int i11, m4.i iVar, b bVar) {
        return g(new a0.b(inputStream, this.f١٨٥٥٨d, this.f١٨٥٥٧c), i10, i11, iVar, bVar);
    }

    public o4.v f(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        return g(new a0.a(byteBuffer, this.f١٨٥٥٨d, this.f١٨٥٥٧c), i10, i11, iVar, f١٨٥٥٢l);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.b();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements b {
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
