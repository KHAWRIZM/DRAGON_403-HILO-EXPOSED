package j0;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: u, reason: collision with root package name */
    public static final String f١٥٠٥٨u = "SudGIP ".concat(d.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final n0.e f١٥٠٥٩a;

    /* renamed from: b, reason: collision with root package name */
    public final long f١٥٠٦٠b;

    /* renamed from: c, reason: collision with root package name */
    public final long f١٥٠٦١c;

    /* renamed from: d, reason: collision with root package name */
    public final String f١٥٠٦٢d;

    /* renamed from: e, reason: collision with root package name */
    public final String f١٥٠٦٣e;

    /* renamed from: g, reason: collision with root package name */
    public final t.c f١٥٠٦٥g;

    /* renamed from: i, reason: collision with root package name */
    public x0.c f١٥٠٦٧i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f١٥٠٦٨j;

    /* renamed from: k, reason: collision with root package name */
    public final WeakReference f١٥٠٦٩k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f١٥٠٧٠l;

    /* renamed from: m, reason: collision with root package name */
    public w f١٥٠٧١m;

    /* renamed from: n, reason: collision with root package name */
    public y f١٥٠٧٢n;

    /* renamed from: o, reason: collision with root package name */
    public final wf.e f١٥٠٧٣o;

    /* renamed from: p, reason: collision with root package name */
    public long f١٥٠٧٤p;

    /* renamed from: q, reason: collision with root package name */
    public long f١٥٠٧٥q;

    /* renamed from: r, reason: collision with root package name */
    public long f١٥٠٧٦r;

    /* renamed from: s, reason: collision with root package name */
    public int f١٥٠٧٧s;

    /* renamed from: t, reason: collision with root package name */
    public final int f١٥٠٧٨t;

    /* renamed from: f, reason: collision with root package name */
    public int f١٥٠٦٤f = 1;

    /* renamed from: h, reason: collision with root package name */
    public PkgDownloadStatus f١٥٠٦٦h = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;

    public d(t.c cVar, long j10, String str, String str2, x xVar) {
        ArrayList arrayList = new ArrayList();
        this.f١٥٠٦٨j = arrayList;
        this.f١٥٠٧٠l = new ArrayList();
        this.f١٥٠٧٤p = 0L;
        this.f١٥٠٧٥q = 0L;
        this.f١٥٠٧٨t = 3;
        this.f١٥٠٦٥g = cVar;
        n0.d dVar = new n0.d(cVar.f١٧٩٣٧d, str, str2);
        dVar.f١٦١٠٨k = 300;
        dVar.f١٦١٠٢e = 10;
        dVar.f١٦١٠٣f = 8192;
        dVar.f١٦١٠٤g = 32768;
        dVar.f١٦١٠٥h = 65536;
        dVar.f١٦١٠٦i = 2000;
        dVar.f١٦١١٢o = 1;
        dVar.f١٦١٠٧j = true;
        dVar.f١٦١١٠m = false;
        dVar.a("Referer", e.e.b(u.j.b(UUID.randomUUID().toString())));
        dVar.a("sud-device-brand", u.g.a(u.h.a()));
        dVar.a("sud-os-version", u.h.d());
        dVar.a("sud-device-id", u.h.c());
        wf.e eVar = new wf.e();
        this.f١٥٠٧٣o = eVar;
        if (dVar.f١٦١٠١d == null) {
            dVar.f١٦١٠١d = new HashMap();
        }
        dVar.f١٦١٠١d.put(wf.e.class, eVar);
        this.f١٥٠٥٩a = new n0.e(dVar.f١٦٠٩٨a, dVar.f١٦٠٩٩b, dVar.f١٦١٠٢e, dVar.f١٦١٠٣f, dVar.f١٦١٠٤g, dVar.f١٦١٠٥h, dVar.f١٦١٠٦i, dVar.f١٦١٠٧j, dVar.f١٦١٠٨k, dVar.f١٦١٠٠c, dVar.f١٦١٠٩l, dVar.f١٦١١٠m, dVar.f١٦١١١n, dVar.f١٦١١٢o, dVar.f١٦١٠١d);
        arrayList.add(cVar.f١٧٩٣٥b);
        this.f١٥٠٦٠b = cVar.f١٧٩٣٦c;
        this.f١٥٠٦١c = j10;
        this.f١٥٠٦٢d = str;
        this.f١٥٠٦٣e = str2;
        this.f١٥٠٦٩k = new WeakReference(xVar);
    }

    public final void a() {
        y yVar = this.f١٥٠٧٢n;
        if (yVar != null) {
            yVar.f١٥١٣٣a.clear();
            this.f١٥٠٧٢n.cancel();
            this.f١٥٠٧٢n = null;
        }
        a aVar = (a) this.f١٥٠٦٩k.get();
        if (aVar != null) {
            x xVar = (x) aVar;
            LogUtils.file("SudDownloadManager", "onTaskEnd:" + this.f١٥٠٦٠b);
            SudLogger.d(e.f١٥٠٧٩d, "onTaskEnd:" + this.f١٥٠٦٠b);
            xVar.f١٥١٣٢a.f١٥٠٨٠a.remove(this);
            xVar.f١٥١٣٢a.c();
        }
        this.f١٥٠٦٧i = null;
        this.f١٥٠٧٠l.clear();
    }

    public final void b(int i10, String str) {
        LogUtils.file("SudDownloadTask", "onDownloadFailure mgId:" + this.f١٥٠٦٠b + " listenerSize:" + this.f١٥٠٧٠l.size());
        SudLogger.d(f١٥٠٥٨u, "onDownloadFailure mgId:" + this.f١٥٠٦٠b + " listenerSize:" + this.f١٥٠٧٠l.size());
        ArrayList arrayList = this.f١٥٠٧٠l;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((c) obj).e(i10, str, this.f١٥٠٧٣o);
        }
        a();
    }

    public final void c(c cVar) {
        if (cVar != null && !this.f١٥٠٧٠l.contains(cVar)) {
            this.f١٥٠٧٠l.add(cVar);
            this.f١٥٠٦٨j.add(cVar.b());
            PkgDownloadStatus pkgDownloadStatus = this.f١٥٠٦٦h;
            if (pkgDownloadStatus == PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING || pkgDownloadStatus == PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE) {
                cVar.a();
                cVar.c(this.f١٥٠٧٥q, this.f١٥٠٧٤p, this.f١٥٠٦٦h);
                cVar.d(this.f١٥٠٧٥q, this.f١٥٠٧٤p);
            }
        }
    }

    public final void d(PkgDownloadStatus pkgDownloadStatus) {
        long j10 = this.f١٥٠٧٥q;
        long j11 = this.f١٥٠٧٤p;
        ArrayList arrayList = this.f١٥٠٧٠l;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) arrayList.get(i10)).c(j10, j11, pkgDownloadStatus);
        }
    }

    public final void e() {
        if (h()) {
            return;
        }
        LogUtils.file("SudDownloadTask", "download:" + this.f١٥٠٦٦h + "  mgId:" + this.f١٥٠٦٠b + "  url:" + this.f١٥٠٦٥g.f١٧٩٣٧d + "  parentPath:" + this.f١٥٠٦٢d + "  fileName:" + this.f١٥٠٦٣e);
        String str = f١٥٠٥٨u;
        StringBuilder sb = new StringBuilder("download:");
        sb.append(this.f١٥٠٦٦h);
        sb.append("  mgId:");
        sb.append(this.f١٥٠٦٠b);
        SudLogger.d(str, sb.toString());
        this.f١٥٠٦٤f = 1;
        PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_STARTED;
        this.f١٥٠٦٦h = pkgDownloadStatus;
        this.f١٥٠٧٦r = System.currentTimeMillis();
        d(pkgDownloadStatus);
        w wVar = this.f١٥٠٧١m;
        if (wVar != null) {
            wVar.f١٥١٣١b.clear();
        }
        w wVar2 = new w(this);
        this.f١٥٠٧١m = wVar2;
        this.f١٥٠٥٩a.i(wVar2);
        y yVar = this.f١٥٠٧٢n;
        if (yVar != null) {
            yVar.f١٥١٣٣a.clear();
            this.f١٥٠٧٢n.cancel();
            this.f١٥٠٧٢n = null;
        }
        y yVar2 = new y(this);
        this.f١٥٠٧٢n = yVar2;
        yVar2.start();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass() && this.f١٥٠٦١c == ((d) obj).f١٥٠٦١c) {
            return true;
        }
        return false;
    }

    public final void f() {
        LogUtils.file("SudDownloadTask", "cancelDownload mgId:" + this.f١٥٠٦٠b + "  status:" + this.f١٥٠٦٦h);
        SudLogger.d(f١٥٠٥٨u, "cancelDownload mgId:" + this.f١٥٠٦٠b + "  status:" + this.f١٥٠٦٦h);
        if (this.f١٥٠٦٦h == PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE) {
            this.f١٥٠٦٤f = 2;
            this.f١٥٠٥٩a.j();
            d(PkgDownloadStatus.PKG_DOWNLOAD_CANCELED);
            this.f١٥٠٧٠l.clear();
            return;
        }
        if (h()) {
            this.f١٥٠٦٤f = 2;
            this.f١٥٠٥٩a.j();
        }
        PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_CANCELED;
        this.f١٥٠٦٦h = pkgDownloadStatus;
        this.f١٥٠٧٦r = System.currentTimeMillis();
        d(pkgDownloadStatus);
        a();
    }

    public final boolean g() {
        ArrayList arrayList = this.f١٥٠٦٨j;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            t.b bVar = (t.b) obj;
            if (bVar == t.b.LoadMGPackageCore || bVar == t.b.LoadMGPackageGamePackage) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        PkgDownloadStatus pkgDownloadStatus = this.f١٥٠٦٦h;
        if (pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_STARTED && pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING && pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f١٥٠٦١c));
    }
}
