package o4;

import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import o4.f;
import t4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class z implements f, f.a {

    /* renamed from: a, reason: collision with root package name */
    private final g f١٦٧٥٧a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f١٦٧٥٨b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f١٦٧٥٩c;

    /* renamed from: d, reason: collision with root package name */
    private volatile c f١٦٧٦٠d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f١٦٧٦١e;

    /* renamed from: f, reason: collision with root package name */
    private volatile n.a f١٦٧٦٢f;

    /* renamed from: g, reason: collision with root package name */
    private volatile d f١٦٧٦٣g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a f١٦٧٦٤a;

        a(n.a aVar) {
            this.f١٦٧٦٤a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void onDataReady(Object obj) {
            if (z.this.g(this.f١٦٧٦٤a)) {
                z.this.h(this.f١٦٧٦٤a, obj);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void onLoadFailed(Exception exc) {
            if (z.this.g(this.f١٦٧٦٤a)) {
                z.this.i(this.f١٦٧٦٤a, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(g gVar, f.a aVar) {
        this.f١٦٧٥٧a = gVar;
        this.f١٦٧٥٨b = aVar;
    }

    private boolean b(Object obj) {
        long b10 = f5.g.b();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.e o10 = this.f١٦٧٥٧a.o(obj);
            Object a10 = o10.a();
            m4.d q10 = this.f١٦٧٥٧a.q(a10);
            e eVar = new e(q10, a10, this.f١٦٧٥٧a.k());
            d dVar = new d(this.f١٦٧٦٢f.f١٨٠٨٤a, this.f١٦٧٥٧a.p());
            q4.a d10 = this.f١٦٧٥٧a.d();
            d10.b(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + q10 + ", duration: " + f5.g.a(b10));
            }
            if (d10.a(dVar) != null) {
                this.f١٦٧٦٣g = dVar;
                this.f١٦٧٦٠d = new c(Collections.singletonList(this.f١٦٧٦٢f.f١٨٠٨٤a), this.f١٦٧٥٧a, this);
                this.f١٦٧٦٢f.f١٨٠٨٦c.cleanup();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f١٦٧٦٣g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f١٦٧٥٨b.c(this.f١٦٧٦٢f.f١٨٠٨٤a, o10.a(), this.f١٦٧٦٢f.f١٨٠٨٦c, this.f١٦٧٦٢f.f١٨٠٨٦c.getDataSource(), this.f١٦٧٦٢f.f١٨٠٨٤a);
                return false;
            } catch (Throwable th) {
                th = th;
                z10 = true;
                if (!z10) {
                    this.f١٦٧٦٢f.f١٨٠٨٦c.cleanup();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean f() {
        if (this.f١٦٧٥٩c < this.f١٦٧٥٧a.g().size()) {
            return true;
        }
        return false;
    }

    private void j(n.a aVar) {
        this.f١٦٧٦٢f.f١٨٠٨٦c.loadData(this.f١٦٧٥٧a.l(), new a(aVar));
    }

    @Override // o4.f
    public boolean a() {
        if (this.f١٦٧٦١e != null) {
            Object obj = this.f١٦٧٦١e;
            this.f١٦٧٦١e = null;
            try {
                if (!b(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.f١٦٧٦٠d != null && this.f١٦٧٦٠d.a()) {
            return true;
        }
        this.f١٦٧٦٠d = null;
        this.f١٦٧٦٢f = null;
        boolean z10 = false;
        while (!z10 && f()) {
            List g10 = this.f١٦٧٥٧a.g();
            int i10 = this.f١٦٧٥٩c;
            this.f١٦٧٥٩c = i10 + 1;
            this.f١٦٧٦٢f = (n.a) g10.get(i10);
            if (this.f١٦٧٦٢f != null && (this.f١٦٧٥٧a.e().c(this.f١٦٧٦٢f.f١٨٠٨٦c.getDataSource()) || this.f١٦٧٥٧a.u(this.f١٦٧٦٢f.f١٨٠٨٦c.getDataClass()))) {
                j(this.f١٦٧٦٢f);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // o4.f.a
    public void c(m4.f fVar, Object obj, com.bumptech.glide.load.data.d dVar, m4.a aVar, m4.f fVar2) {
        this.f١٦٧٥٨b.c(fVar, obj, dVar, this.f١٦٧٦٢f.f١٨٠٨٦c.getDataSource(), fVar);
    }

    @Override // o4.f
    public void cancel() {
        n.a aVar = this.f١٦٧٦٢f;
        if (aVar != null) {
            aVar.f١٨٠٨٦c.cancel();
        }
    }

    @Override // o4.f.a
    public void d() {
        throw new UnsupportedOperationException();
    }

    @Override // o4.f.a
    public void e(m4.f fVar, Exception exc, com.bumptech.glide.load.data.d dVar, m4.a aVar) {
        this.f١٦٧٥٨b.e(fVar, exc, dVar, this.f١٦٧٦٢f.f١٨٠٨٦c.getDataSource());
    }

    boolean g(n.a aVar) {
        n.a aVar2 = this.f١٦٧٦٢f;
        if (aVar2 != null && aVar2 == aVar) {
            return true;
        }
        return false;
    }

    void h(n.a aVar, Object obj) {
        j e10 = this.f١٦٧٥٧a.e();
        if (obj != null && e10.c(aVar.f١٨٠٨٦c.getDataSource())) {
            this.f١٦٧٦١e = obj;
            this.f١٦٧٥٨b.d();
        } else {
            f.a aVar2 = this.f١٦٧٥٨b;
            m4.f fVar = aVar.f١٨٠٨٤a;
            com.bumptech.glide.load.data.d dVar = aVar.f١٨٠٨٦c;
            aVar2.c(fVar, obj, dVar, dVar.getDataSource(), this.f١٦٧٦٣g);
        }
    }

    void i(n.a aVar, Exception exc) {
        f.a aVar2 = this.f١٦٧٥٨b;
        d dVar = this.f١٦٧٦٣g;
        com.bumptech.glide.load.data.d dVar2 = aVar.f١٨٠٨٦c;
        aVar2.e(dVar, exc, dVar2, dVar2.getDataSource());
    }
}
