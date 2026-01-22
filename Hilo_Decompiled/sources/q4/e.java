package q4;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import k4.b;
import q4.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final File f١٧١٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private final long f١٧١٣٤c;

    /* renamed from: e, reason: collision with root package name */
    private k4.b f١٧١٣٦e;

    /* renamed from: d, reason: collision with root package name */
    private final c f١٧١٣٥d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final j f١٧١٣٢a = new j();

    protected e(File file, long j10) {
        this.f١٧١٣٣b = file;
        this.f١٧١٣٤c = j10;
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    private synchronized k4.b d() {
        try {
            if (this.f١٧١٣٦e == null) {
                this.f١٧١٣٦e = k4.b.D(this.f١٧١٣٣b, 1, 1, this.f١٧١٣٤c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f١٧١٣٦e;
    }

    private synchronized void e() {
        this.f١٧١٣٦e = null;
    }

    @Override // q4.a
    public File a(m4.f fVar) {
        String b10 = this.f١٧١٣٢a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b10 + " for for Key: " + fVar);
        }
        try {
            b.e A = d().A(b10);
            if (A == null) {
                return null;
            }
            return A.a(0);
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    @Override // q4.a
    public void b(m4.f fVar, a.b bVar) {
        k4.b d10;
        String b10 = this.f١٧١٣٢a.b(fVar);
        this.f١٧١٣٥d.a(b10);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b10 + " for for Key: " + fVar);
            }
            try {
                d10 = d();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (d10.A(b10) != null) {
                return;
            }
            b.c w10 = d10.w(b10);
            if (w10 != null) {
                try {
                    if (bVar.a(w10.f(0))) {
                        w10.e();
                    }
                    w10.b();
                    return;
                } catch (Throwable th) {
                    w10.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b10);
        } finally {
            this.f١٧١٣٥d.b(b10);
        }
    }

    @Override // q4.a
    public synchronized void clear() {
        try {
            try {
                d().t();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to clear disk cache or disk cache cleared externally", e10);
                }
            }
        } finally {
            e();
        }
    }
}
