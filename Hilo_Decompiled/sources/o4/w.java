package o4;

import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.List;
import o4.f;
import t4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class w implements f, d.a {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f١٦٧٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private final g f١٦٧٣٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٦٧٣٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٦٧٣٩d = -1;

    /* renamed from: e, reason: collision with root package name */
    private m4.f f١٦٧٤٠e;

    /* renamed from: f, reason: collision with root package name */
    private List f١٦٧٤١f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٦٧٤٢g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a f١٦٧٤٣h;

    /* renamed from: i, reason: collision with root package name */
    private File f١٦٧٤٤i;

    /* renamed from: j, reason: collision with root package name */
    private x f١٦٧٤٥j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(g gVar, f.a aVar) {
        this.f١٦٧٣٧b = gVar;
        this.f١٦٧٣٦a = aVar;
    }

    private boolean b() {
        if (this.f١٦٧٤٢g < this.f١٦٧٤١f.size()) {
            return true;
        }
        return false;
    }

    @Override // o4.f
    public boolean a() {
        g5.b.a("ResourceCacheGenerator.startNext");
        try {
            List c10 = this.f١٦٧٣٧b.c();
            boolean z10 = false;
            if (c10.isEmpty()) {
                g5.b.e();
                return false;
            }
            List m10 = this.f١٦٧٣٧b.m();
            if (m10.isEmpty()) {
                if (File.class.equals(this.f١٦٧٣٧b.r())) {
                    g5.b.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f١٦٧٣٧b.i() + " to " + this.f١٦٧٣٧b.r());
            }
            while (true) {
                if (this.f١٦٧٤١f != null && b()) {
                    this.f١٦٧٤٣h = null;
                    while (!z10 && b()) {
                        List list = this.f١٦٧٤١f;
                        int i10 = this.f١٦٧٤٢g;
                        this.f١٦٧٤٢g = i10 + 1;
                        this.f١٦٧٤٣h = ((t4.n) list.get(i10)).buildLoadData(this.f١٦٧٤٤i, this.f١٦٧٣٧b.t(), this.f١٦٧٣٧b.f(), this.f١٦٧٣٧b.k());
                        if (this.f١٦٧٤٣h != null && this.f١٦٧٣٧b.u(this.f١٦٧٤٣h.f١٨٠٨٦c.getDataClass())) {
                            this.f١٦٧٤٣h.f١٨٠٨٦c.loadData(this.f١٦٧٣٧b.l(), this);
                            z10 = true;
                        }
                    }
                    g5.b.e();
                    return z10;
                }
                int i11 = this.f١٦٧٣٩d + 1;
                this.f١٦٧٣٩d = i11;
                if (i11 >= m10.size()) {
                    int i12 = this.f١٦٧٣٨c + 1;
                    this.f١٦٧٣٨c = i12;
                    if (i12 >= c10.size()) {
                        g5.b.e();
                        return false;
                    }
                    this.f١٦٧٣٩d = 0;
                }
                m4.f fVar = (m4.f) c10.get(this.f١٦٧٣٨c);
                Class cls = (Class) m10.get(this.f١٦٧٣٩d);
                this.f١٦٧٤٥j = new x(this.f١٦٧٣٧b.b(), fVar, this.f١٦٧٣٧b.p(), this.f١٦٧٣٧b.t(), this.f١٦٧٣٧b.f(), this.f١٦٧٣٧b.s(cls), cls, this.f١٦٧٣٧b.k());
                File a10 = this.f١٦٧٣٧b.d().a(this.f١٦٧٤٥j);
                this.f١٦٧٤٤i = a10;
                if (a10 != null) {
                    this.f١٦٧٤٠e = fVar;
                    this.f١٦٧٤١f = this.f١٦٧٣٧b.j(a10);
                    this.f١٦٧٤٢g = 0;
                }
            }
        } catch (Throwable th) {
            g5.b.e();
            throw th;
        }
    }

    @Override // o4.f
    public void cancel() {
        n.a aVar = this.f١٦٧٤٣h;
        if (aVar != null) {
            aVar.f١٨٠٨٦c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void onDataReady(Object obj) {
        this.f١٦٧٣٦a.c(this.f١٦٧٤٠e, obj, this.f١٦٧٤٣h.f١٨٠٨٦c, m4.a.RESOURCE_DISK_CACHE, this.f١٦٧٤٥j);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void onLoadFailed(Exception exc) {
        this.f١٦٧٣٦a.e(this.f١٦٧٤٥j, exc, this.f١٦٧٤٣h.f١٨٠٨٦c, m4.a.RESOURCE_DISK_CACHE);
    }
}
