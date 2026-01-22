package p4;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j implements d {

    /* renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f١٦٨٧١k = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final k f١٦٨٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f١٦٨٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private final long f١٦٨٧٤c;

    /* renamed from: d, reason: collision with root package name */
    private final a f١٦٨٧٥d;

    /* renamed from: e, reason: collision with root package name */
    private long f١٦٨٧٦e;

    /* renamed from: f, reason: collision with root package name */
    private long f١٦٨٧٧f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٦٨٧٨g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٦٨٧٩h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٦٨٨٠i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٦٨٨١j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    j(long j10, k kVar, Set set) {
        this.f١٦٨٧٤c = j10;
        this.f١٦٨٧٦e = j10;
        this.f١٦٨٧٢a = kVar;
        this.f١٦٨٧٣b = set;
        this.f١٦٨٧٥d = new b();
    }

    private static void h(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.HARDWARE;
            if (config != config2) {
                return;
            }
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap i(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f١٦٨٧١k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void j() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            k();
        }
    }

    private void k() {
        Log.v("LruBitmapPool", "Hits=" + this.f١٦٨٧٨g + ", misses=" + this.f١٦٨٧٩h + ", puts=" + this.f١٦٨٨٠i + ", evictions=" + this.f١٦٨٨١j + ", currentSize=" + this.f١٦٨٧٧f + ", maxSize=" + this.f١٦٨٧٦e + "\nStrategy=" + this.f١٦٨٧٢a);
    }

    private void l() {
        r(this.f١٦٨٧٦e);
    }

    private static Set m() {
        Bitmap.Config config;
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static k n() {
        return new n();
    }

    private synchronized Bitmap o(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap f10;
        try {
            h(config);
            k kVar = this.f١٦٨٧٢a;
            if (config != null) {
                config2 = config;
            } else {
                config2 = f١٦٨٧١k;
            }
            f10 = kVar.f(i10, i11, config2);
            if (f10 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f١٦٨٧٢a.b(i10, i11, config));
                }
                this.f١٦٨٧٩h++;
            } else {
                this.f١٦٨٧٨g++;
                this.f١٦٨٧٧f -= this.f١٦٨٧٢a.c(f10);
                this.f١٦٨٧٥d.a(f10);
                q(f10);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f١٦٨٧٢a.b(i10, i11, config));
            }
            j();
        } catch (Throwable th) {
            throw th;
        }
        return f10;
    }

    private static void p(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void q(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        p(bitmap);
    }

    private synchronized void r(long j10) {
        while (this.f١٦٨٧٧f > j10) {
            try {
                Bitmap removeLast = this.f١٦٨٧٢a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        k();
                    }
                    this.f١٦٨٧٧f = 0L;
                    return;
                }
                this.f١٦٨٧٥d.a(removeLast);
                this.f١٦٨٧٧f -= this.f١٦٨٧٢a.c(removeLast);
                this.f١٦٨٨١j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f١٦٨٧٢a.a(removeLast));
                }
                j();
                removeLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p4.d
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 < 40 && (Build.VERSION.SDK_INT < 23 || i10 < 20)) {
            if (i10 >= 20 || i10 == 15) {
                r(e() / 2);
                return;
            }
            return;
        }
        b();
    }

    @Override // p4.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        r(0L);
    }

    @Override // p4.d
    public synchronized void c(float f10) {
        this.f١٦٨٧٦e = Math.round(((float) this.f١٦٨٧٤c) * f10);
        l();
    }

    @Override // p4.d
    public synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f١٦٨٧٢a.c(bitmap) <= this.f١٦٨٧٦e && this.f١٦٨٧٣b.contains(bitmap.getConfig())) {
                        int c10 = this.f١٦٨٧٢a.c(bitmap);
                        this.f١٦٨٧٢a.d(bitmap);
                        this.f١٦٨٧٥d.b(bitmap);
                        this.f١٦٨٨٠i++;
                        this.f١٦٨٧٧f += c10;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f١٦٨٧٢a.a(bitmap));
                        }
                        j();
                        l();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f١٦٨٧٢a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f١٦٨٧٣b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p4.d
    public long e() {
        return this.f١٦٨٧٦e;
    }

    @Override // p4.d
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        Bitmap o10 = o(i10, i11, config);
        if (o10 != null) {
            o10.eraseColor(0);
            return o10;
        }
        return i(i10, i11, config);
    }

    @Override // p4.d
    public Bitmap g(int i10, int i11, Bitmap.Config config) {
        Bitmap o10 = o(i10, i11, config);
        if (o10 == null) {
            return i(i10, i11, config);
        }
        return o10;
    }

    public j(long j10) {
        this(j10, n(), m());
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements a {
        b() {
        }

        @Override // p4.j.a
        public void a(Bitmap bitmap) {
        }

        @Override // p4.j.a
        public void b(Bitmap bitmap) {
        }
    }
}
