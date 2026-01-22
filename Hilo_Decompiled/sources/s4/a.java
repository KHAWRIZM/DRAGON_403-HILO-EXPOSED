package s4;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import q4.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    private static final C٠٢٢٧a f١٧٨٦٢i = new C٠٢٢٧a();

    /* renamed from: j, reason: collision with root package name */
    static final long f١٧٨٦٣j = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f١٧٨٦٤a;

    /* renamed from: b, reason: collision with root package name */
    private final h f١٧٨٦٥b;

    /* renamed from: c, reason: collision with root package name */
    private final c f١٧٨٦٦c;

    /* renamed from: d, reason: collision with root package name */
    private final C٠٢٢٧a f١٧٨٦٧d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f١٧٨٦٨e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f١٧٨٦٩f;

    /* renamed from: g, reason: collision with root package name */
    private long f١٧٨٧٠g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٧٨٧١h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠٢٢٧a {
        C٠٢٢٧a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    public a(p4.d dVar, h hVar, c cVar) {
        this(dVar, hVar, cVar, f١٧٨٦٢i, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        long j10 = this.f١٧٨٧٠g;
        this.f١٧٨٧٠g = Math.min(4 * j10, f١٧٨٦٣j);
        return j10;
    }

    private boolean d(long j10) {
        if (this.f١٧٨٦٧d.a() - j10 >= 32) {
            return true;
        }
        return false;
    }

    boolean a() {
        long a10 = this.f١٧٨٦٧d.a();
        if (!this.f١٧٨٦٦c.a() && !d(a10)) {
            this.f١٧٨٦٦c.b();
            if (!this.f١٧٨٦٨e.contains(null)) {
                this.f١٧٨٦٨e.add(null);
                throw null;
            }
            throw null;
        }
        if (!this.f١٧٨٧١h && !this.f١٧٨٦٦c.a()) {
            return true;
        }
        return false;
    }

    public void b() {
        this.f١٧٨٧١h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f١٧٨٦٩f.postDelayed(this, c());
        }
    }

    a(p4.d dVar, h hVar, c cVar, C٠٢٢٧a r62, Handler handler) {
        this.f١٧٨٦٨e = new HashSet();
        this.f١٧٨٧٠g = 40L;
        this.f١٧٨٦٤a = dVar;
        this.f١٧٨٦٥b = hVar;
        this.f١٧٨٦٦c = cVar;
        this.f١٧٨٦٧d = r62;
        this.f١٧٨٦٩f = handler;
    }
}
