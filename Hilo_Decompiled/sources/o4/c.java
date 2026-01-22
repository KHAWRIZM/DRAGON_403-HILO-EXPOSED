package o4;

import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.List;
import o4.f;
import t4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements f, d.a {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦٥٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private final g f١٦٥٥١b;

    /* renamed from: c, reason: collision with root package name */
    private final f.a f١٦٥٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٦٥٥٣d;

    /* renamed from: e, reason: collision with root package name */
    private m4.f f١٦٥٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private List f١٦٥٥٥f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٦٥٥٦g;

    /* renamed from: h, reason: collision with root package name */
    private volatile n.a f١٦٥٥٧h;

    /* renamed from: i, reason: collision with root package name */
    private File f١٦٥٥٨i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        if (this.f١٦٥٥٦g < this.f١٦٥٥٥f.size()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r2 != false) goto L٤٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (b() == false) goto L٤٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r0 = r7.f١٦٥٥٥f;
        r3 = r7.f١٦٥٥٦g;
        r7.f١٦٥٥٦g = r3 + 1;
        r7.f١٦٥٥٧h = ((t4.n) r0.get(r3)).buildLoadData(r7.f١٦٥٥٨i, r7.f١٦٥٥١b.t(), r7.f١٦٥٥١b.f(), r7.f١٦٥٥١b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r7.f١٦٥٥٧h == null) goto L٤٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (r7.f١٦٥٥١b.u(r7.f١٦٥٥٧h.f١٨٠٨٦c.getDataClass()) == false) goto L٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r7.f١٦٥٥٧h.f١٨٠٨٦c.loadData(r7.f١٦٥٥١b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r7.f١٦٥٥٧h = null;
     */
    @Override // o4.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        g5.b.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z10 = false;
                if (this.f١٦٥٥٥f != null && b()) {
                    break;
                }
                int i10 = this.f١٦٥٥٣d + 1;
                this.f١٦٥٥٣d = i10;
                if (i10 >= this.f١٦٥٥٠a.size()) {
                    return false;
                }
                m4.f fVar = (m4.f) this.f١٦٥٥٠a.get(this.f١٦٥٥٣d);
                File a10 = this.f١٦٥٥١b.d().a(new d(fVar, this.f١٦٥٥١b.p()));
                this.f١٦٥٥٨i = a10;
                if (a10 != null) {
                    this.f١٦٥٥٤e = fVar;
                    this.f١٦٥٥٥f = this.f١٦٥٥١b.j(a10);
                    this.f١٦٥٥٦g = 0;
                }
            } finally {
                g5.b.e();
            }
        }
    }

    @Override // o4.f
    public void cancel() {
        n.a aVar = this.f١٦٥٥٧h;
        if (aVar != null) {
            aVar.f١٨٠٨٦c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void onDataReady(Object obj) {
        this.f١٦٥٥٢c.c(this.f١٦٥٥٤e, obj, this.f١٦٥٥٧h.f١٨٠٨٦c, m4.a.DATA_DISK_CACHE, this.f١٦٥٥٤e);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void onLoadFailed(Exception exc) {
        this.f١٦٥٥٢c.e(this.f١٦٥٥٤e, exc, this.f١٦٥٥٧h.f١٨٠٨٦c, m4.a.DATA_DISK_CACHE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List list, g gVar, f.a aVar) {
        this.f١٦٥٥٣d = -1;
        this.f١٦٥٥٠a = list;
        this.f١٦٥٥١b = gVar;
        this.f١٦٥٥٢c = aVar;
    }
}
