package x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Response;
import okhttp3.ResponseBody;
import w.m;
import w.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Runnable {

    /* renamed from: q, reason: collision with root package name */
    public static final ThreadPoolExecutor f١٨٨٠٧q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new l0.b("OkDownload Cancel Block"));

    /* renamed from: a, reason: collision with root package name */
    public final int f١٨٨٠٨a;

    /* renamed from: b, reason: collision with root package name */
    public final n0.e f١٨٨٠٩b;

    /* renamed from: c, reason: collision with root package name */
    public final r0.g f١٨٨١٠c;

    /* renamed from: d, reason: collision with root package name */
    public final i f١٨٨١١d;

    /* renamed from: i, reason: collision with root package name */
    public long f١٨٨١٦i;

    /* renamed from: j, reason: collision with root package name */
    public volatile l1.d f١٨٨١٧j;

    /* renamed from: k, reason: collision with root package name */
    public long f١٨٨١٨k;

    /* renamed from: l, reason: collision with root package name */
    public volatile Thread f١٨٨١٩l;

    /* renamed from: n, reason: collision with root package name */
    public final r0.d f١٨٨٢١n;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٨٨١٢e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f١٨٨١٣f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public int f١٨٨١٤g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f١٨٨١٥h = 0;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f١٨٨٢٢o = new AtomicBoolean(false);

    /* renamed from: p, reason: collision with root package name */
    public final a f١٨٨٢٣p = new a(this);

    /* renamed from: m, reason: collision with root package name */
    public final o f١٨٨٢٠m = n0.f.a().f١٦١٣٨b;

    public b(int i10, n0.e eVar, r0.g gVar, i iVar, r0.d dVar) {
        this.f١٨٨٠٨a = i10;
        this.f١٨٨٠٩b = eVar;
        this.f١٨٨١١d = iVar;
        this.f١٨٨١٠c = gVar;
        this.f١٨٨٢١n = dVar;
    }

    public final synchronized l1.c a() {
        try {
            if (!this.f١٨٨١١d.c()) {
                if (this.f١٨٨١٧j == null) {
                    String str = this.f١٨٨١١d.f١٨٨٤٩a;
                    if (str == null) {
                        str = this.f١٨٨١٠c.f١٧٢٨٣b;
                    }
                    this.f١٨٨١٧j = n0.f.a().f١٦١٤٠d.a(str);
                    this.f١٨٨١٧j.b(this.f١٨٨٠٩b.f١٦١٣٥x);
                }
            } else {
                throw z.d.f١٩٣٢٧a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f١٨٨١٧j;
    }

    public final long b() {
        if (!this.f١٨٨١١d.c()) {
            ArrayList arrayList = this.f١٨٨١٣f;
            int i10 = this.f١٨٨١٥h;
            this.f١٨٨١٥h = i10 + 1;
            return ((m0.d) arrayList.get(i10)).a(this);
        }
        throw z.d.f١٩٣٢٧a;
    }

    public final l1.a c() {
        if (!this.f١٨٨١١d.c()) {
            ArrayList arrayList = this.f١٨٨١٢e;
            int i10 = this.f١٨٨١٤g;
            this.f١٨٨١٤g = i10 + 1;
            return ((m0.b) arrayList.get(i10)).b(this);
        }
        throw z.d.f١٩٣٢٧a;
    }

    public final void d() {
        o oVar = n0.f.a().f١٦١٣٨b;
        m0.e eVar = new m0.e();
        m0.a aVar = new m0.a();
        this.f١٨٨١٢e.add(eVar);
        this.f١٨٨١٢e.add(aVar);
        this.f١٨٨١٢e.add(new t0.b());
        this.f١٨٨١٢e.add(new t0.a());
        this.f١٨٨١٤g = 0;
        l1.a c10 = c();
        if (!this.f١٨٨١١d.c()) {
            m mVar = oVar.f١٨٦٦٣a;
            n0.e eVar2 = this.f١٨٨٠٩b;
            int i10 = this.f١٨٨٠٨a;
            long j10 = this.f١٨٨١٦i;
            mVar.getClass();
            int i11 = eVar2.f١٦١١٣b;
            if (eVar2.f١٦١٢٥n) {
                mVar.f١٨٦٦١a.post(new w.h(eVar2, i10, j10));
            } else {
                eVar2.f١٦١٢٧p.getClass();
            }
            int i12 = this.f١٨٨٠٨a;
            Response response = ((l1.d) c10).f١٥٦٩١d;
            if (response != null) {
                ResponseBody body = response.body();
                if (body != null) {
                    m0.c cVar = new m0.c(i12, body.byteStream(), this.f١٨٨١١d.a(), this.f١٨٨٠٩b);
                    this.f١٨٨١٣f.add(eVar);
                    this.f١٨٨١٣f.add(aVar);
                    this.f١٨٨١٣f.add(cVar);
                    this.f١٨٨١٥h = 0;
                    long b10 = b();
                    m mVar2 = oVar.f١٨٦٦٣a;
                    n0.e eVar3 = this.f١٨٨٠٩b;
                    int i13 = this.f١٨٨٠٨a;
                    mVar2.getClass();
                    int i14 = eVar3.f١٦١١٣b;
                    if (eVar3.f١٦١٢٥n) {
                        mVar2.f١٨٦٦١a.post(new w.i(eVar3, i13, b10));
                        return;
                    } else {
                        eVar3.f١٦١٢٧p.a(eVar3, i13, b10);
                        return;
                    }
                }
                throw new IOException("no body found on response!");
            }
            throw new IOException("Please invoke execute first!");
        }
        throw z.d.f١٩٣٢٧a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f١٨٨٢٢o.get()) {
            this.f١٨٨١٩l = Thread.currentThread();
            try {
                d();
                return;
            } catch (IOException unused) {
                return;
            } finally {
                this.f١٨٨٢٢o.set(true);
                f١٨٨٠٧q.execute(this.f١٨٨٢٣p);
            }
        }
        throw new IllegalAccessError("The chain has been finished!");
    }
}
