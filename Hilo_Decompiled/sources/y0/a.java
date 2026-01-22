package y0;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f١٩٠٤٨a;

    /* renamed from: b, reason: collision with root package name */
    public long f١٩٠٤٩b;

    /* renamed from: c, reason: collision with root package name */
    public final g f١٩٠٥٠c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f١٩٠٥٢e;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f١٩٠٥١d = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public final long f١٩٠٥٣f = 100;

    /* renamed from: g, reason: collision with root package name */
    public final f f١٩٠٥٤g = new f(this);

    public a(long j10, q0.c cVar) {
        this.f١٩٠٤٨a = j10;
        this.f١٩٠٥٠c = cVar;
    }

    public final synchronized void a() {
        this.f١٩٠٥١d.removeCallbacks(this.f١٩٠٥٤g);
        this.f١٩٠٥١d.postDelayed(this.f١٩٠٥٤g, this.f١٩٠٥٣f);
    }

    public final synchronized void b() {
        this.f١٩٠٥٢e = true;
        this.f١٩٠٤٩b = this.f١٩٠٤٨a;
        a();
    }
}
