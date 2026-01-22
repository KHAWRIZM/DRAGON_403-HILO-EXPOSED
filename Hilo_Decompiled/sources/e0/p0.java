package e0;

import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f١٣٨٠٨a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f١٣٨٠٩b;

    /* renamed from: c, reason: collision with root package name */
    public long f١٣٨١٠c;

    /* renamed from: d, reason: collision with root package name */
    public long f١٣٨١١d;

    /* renamed from: e, reason: collision with root package name */
    public long f١٣٨١٢e;

    /* renamed from: f, reason: collision with root package name */
    public long f١٣٨١٣f;

    /* renamed from: g, reason: collision with root package name */
    public long f١٣٨١٤g;

    /* renamed from: h, reason: collision with root package name */
    public long f١٣٨١٥h;

    /* renamed from: i, reason: collision with root package name */
    public long f١٣٨١٦i;

    /* renamed from: j, reason: collision with root package name */
    public long f١٣٨١٧j;

    /* renamed from: k, reason: collision with root package name */
    public int f١٣٨١٨k;

    /* renamed from: l, reason: collision with root package name */
    public int f١٣٨١٩l;

    /* renamed from: m, reason: collision with root package name */
    public int f١٣٨٢٠m;

    public p0(r rVar) {
        this.f١٣٨٠٨a = rVar;
        HandlerThread handlerThread = new HandlerThread("SudPicasso-Stats", 10);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        StringBuilder sb = u0.f١٣٨٣٥a;
        x xVar = new x(looper);
        xVar.sendMessageDelayed(xVar.obtainMessage(), 1000L);
        this.f١٣٨٠٩b = new f0(handlerThread.getLooper(), this);
    }

    public final v a() {
        return new v(this.f١٣٨٠٨a.a(), this.f١٣٨٠٨a.d(), this.f١٣٨١٠c, this.f١٣٨١١d, this.f١٣٨١٢e, this.f١٣٨١٣f, this.f١٣٨١٤g, this.f١٣٨١٥h, this.f١٣٨١٦i, this.f١٣٨١٧j, this.f١٣٨١٨k, this.f١٣٨١٩l, this.f١٣٨٢٠m, System.currentTimeMillis());
    }
}
