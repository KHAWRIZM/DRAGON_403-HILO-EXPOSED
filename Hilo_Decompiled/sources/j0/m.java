package j0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m {

    /* renamed from: m, reason: collision with root package name */
    public static final String f١٥١٠٢m = "SudGIP ".concat(m.class.getSimpleName());

    /* renamed from: a, reason: collision with root package name */
    public final n0.e f١٥١٠٣a;

    /* renamed from: b, reason: collision with root package name */
    public final String f١٥١٠٤b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٥١٠٥c;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٥١٠٧e;

    /* renamed from: f, reason: collision with root package name */
    public h f١٥١٠٨f;

    /* renamed from: g, reason: collision with root package name */
    public o f١٥١٠٩g;

    /* renamed from: h, reason: collision with root package name */
    public final wf.e f١٥١١٠h;

    /* renamed from: k, reason: collision with root package name */
    public long f١٥١١٣k;

    /* renamed from: l, reason: collision with root package name */
    public final String f١٥١١٤l;

    /* renamed from: d, reason: collision with root package name */
    public PkgDownloadStatus f١٥١٠٦d = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;

    /* renamed from: i, reason: collision with root package name */
    public long f١٥١١١i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f١٥١١٢j = 0;

    public m(String str, String str2, String str3) {
        this.f١٥١١٤l = str;
        n0.d dVar = new n0.d(str, str2, str3);
        dVar.f١٦١٠٨k = 300;
        dVar.f١٦١٠٢e = 10;
        dVar.f١٦١٠٣f = 8192;
        dVar.f١٦١٠٤g = 32768;
        dVar.f١٦١٠٥h = 65536;
        dVar.f١٦١٠٦i = 2000;
        dVar.f١٦١١٢o = 1;
        dVar.f١٦١٠٧j = true;
        dVar.f١٦١١٠m = true;
        dVar.a("Referer", e.e.b(u.j.b(UUID.randomUUID().toString())));
        dVar.a("sud-device-brand", u.g.a(u.h.a()));
        dVar.a("sud-os-version", u.h.d());
        dVar.a("sud-device-id", u.h.c());
        wf.e eVar = new wf.e();
        this.f١٥١١٠h = eVar;
        if (dVar.f١٦١٠١d == null) {
            dVar.f١٦١٠١d = new HashMap();
        }
        dVar.f١٦١٠١d.put(wf.e.class, eVar);
        this.f١٥١٠٣a = new n0.e(dVar.f١٦٠٩٨a, dVar.f١٦٠٩٩b, dVar.f١٦١٠٢e, dVar.f١٦١٠٣f, dVar.f١٦١٠٤g, dVar.f١٦١٠٥h, dVar.f١٦١٠٦i, dVar.f١٦١٠٧j, dVar.f١٦١٠٨k, dVar.f١٦١٠٠c, dVar.f١٦١٠٩l, dVar.f١٦١١٠m, dVar.f١٦١١١n, dVar.f١٦١١٢o, dVar.f١٦١٠١d);
        this.f١٥١٠٤b = str2;
        this.f١٥١٠٥c = str3;
        this.f١٥١٠٧e = new ArrayList();
    }

    public final void a(int i10, String str) {
        LogUtils.file("DownloadFileTask", "onDownloadFailure  listenerSize:" + this.f١٥١٠٧e.size());
        SudLogger.d(f١٥١٠٢m, "onDownloadFailure  listenerSize:" + this.f١٥١٠٧e.size());
        ArrayList arrayList = this.f١٥١٠٧e;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((c) obj).e(i10, str, this.f١٥١١٠h);
        }
    }

    public final void b(PkgDownloadStatus pkgDownloadStatus) {
        this.f١٥١٠٦d = pkgDownloadStatus;
        this.f١٥١١٣k = System.currentTimeMillis();
        long j10 = this.f١٥١١٢j;
        long j11 = this.f١٥١١١i;
        ArrayList arrayList = this.f١٥١٠٧e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) arrayList.get(i10)).c(j10, j11, pkgDownloadStatus);
        }
    }
}
