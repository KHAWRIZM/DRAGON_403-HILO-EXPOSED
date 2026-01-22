package ye;

import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class f implements j0.c {
    public final /* synthetic */ re.a a;
    public final /* synthetic */ t.c b;
    public final /* synthetic */ g c;

    public f(g gVar, re.a aVar, t.c cVar) {
        this.c = gVar;
        this.a = aVar;
        this.b = cVar;
    }

    public static /* synthetic */ void h(String str, re.a aVar, int i, wf.e eVar) {
        LogUtils.file("RealSudGamePackageManager", "onDownloadFailure error:" + str);
        SudLogger.d(g.d, "onDownloadFailure error:" + str);
        aVar.e(i, str, eVar);
    }

    public static /* synthetic */ void i(re.a aVar) {
        LogUtils.file("RealSudGamePackageManager", "onDownloadStart");
        SudLogger.d(g.d, "onDownloadStart");
        aVar.a();
    }

    public final void a() {
        final re.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: ye.d
            @Override // java.lang.Runnable
            public final void run() {
                f.i(aVar);
            }
        });
    }

    public final t.b b() {
        return this.b.b;
    }

    public final void c(final long j, final long j2, final PkgDownloadStatus pkgDownloadStatus) {
        final re.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: ye.c
            @Override // java.lang.Runnable
            public final void run() {
                aVar.c(j, j2, pkgDownloadStatus);
            }
        });
    }

    public final void d(final long j, final long j2) {
        final re.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: ye.e
            @Override // java.lang.Runnable
            public final void run() {
                aVar.d(j, j2);
            }
        });
    }

    public final void e(final int i, final String str, final wf.e eVar) {
        final re.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: ye.b
            @Override // java.lang.Runnable
            public final void run() {
                f.h(str, aVar, i, eVar);
            }
        });
    }

    public final void f(final String str, final long j, final Object obj, final wf.e eVar) {
        final re.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: ye.a
            @Override // java.lang.Runnable
            public final void run() {
                f.this.g(str, j, obj, eVar, aVar);
            }
        });
    }

    public final /* synthetic */ void g(String str, long j, Object obj, wf.e eVar, re.a aVar) {
        this.c.h(str, obj, eVar, aVar);
    }
}
