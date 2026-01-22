package jd;

import j0.n;
import java.io.File;
import tech.sud.logger.LogUtils;
import u.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b implements x0.c {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    public final void a(final File file, final long j, final Object obj, final n nVar) {
        if (file != null && this.a.d(obj)) {
            final String absolutePath = file.getAbsolutePath();
            LogUtils.file("RealSudGameCoreManager", "processor onDownloadSuccess:" + absolutePath);
            w0.a.a.execute(new Runnable() { // from class: jd.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(absolutePath, file, j, obj, nVar);
                }
            });
            return;
        }
        nVar.a((Object) null);
    }

    public final /* synthetic */ void b(String str, File file, long j, Object obj, x0.a aVar) {
        LogUtils.file("RealSudGameCoreManager", "processor onDownloadSuccess beginUnzip file:");
        d dVar = new d();
        d.d a = f.a(str, this.a.c);
        LogUtils.file("RealSudGameCoreManager", "processor onDownloadSuccess unzipResult:" + a + "  path:" + file.getAbsolutePath() + "  _sudPathCache:" + this.a.c);
        if (a.a == 0) {
            d.d a2 = this.a.a();
            LogUtils.file("RealSudGameCoreManager", "processor onDownloadSuccess copyRuntimeResult:" + a2);
            if (a2.a == 0) {
                this.a.c(j, obj, dVar);
            }
        }
        u.a.b(this.a.c);
        ((n) aVar).a(dVar);
    }
}
