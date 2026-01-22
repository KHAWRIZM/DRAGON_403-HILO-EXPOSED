package j0;

import e0.h0;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h extends x0.b {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f١٥٠٨٦b;

    public h(m mVar) {
        this.f١٥٠٨٦b = new WeakReference(mVar);
    }

    @Override // n0.b
    public final void b(n0.e eVar) {
        m mVar = (m) this.f١٥٠٨٦b.get();
        if (mVar != null) {
            ArrayList arrayList = mVar.f١٥١٠٧e;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((c) obj).a();
            }
            LogUtils.file("DownloadFileTask", "taskStart mgId:" + mVar.f١٥١١٤l);
        }
    }

    @Override // m1.c
    public final void c(r0.g gVar) {
        gVar.c();
        m mVar = (m) this.f١٥٠٨٦b.get();
        if (mVar != null) {
            mVar.f١٥١١١i = gVar.c();
            mVar.f١٥١١٢j = gVar.e();
            mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING);
            LogUtils.file("DownloadFileTask", "infoReady mgId:" + mVar.f١٥١١٤l);
        }
    }

    @Override // m1.c
    public final void d(long j10) {
        m mVar = (m) this.f١٥٠٨٦b.get();
        if (mVar != null) {
            mVar.f١٥١١٢j = j10;
            long j11 = mVar.f١٥١١١i;
            ArrayList arrayList = mVar.f١٥١٠٧e;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((c) obj).d(j10, j11);
            }
            mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING);
            SudLogger.d(m.f١٥١٠٢m, " 进度：" + j10 + "/" + mVar.f١٥١١١i);
            LogUtils.file("DownloadFileTask", " 进度：" + j10 + "/" + mVar.f١٥١١١i);
        }
    }

    @Override // m1.c
    public final void e(n0.e eVar, int i10, Exception exc) {
        String str;
        String absolutePath;
        m mVar = (m) this.f١٥٠٨٦b.get();
        if (mVar != null) {
            LogUtils.file("DownloadFileTask", "taskEnd:" + mVar.f١٥١٠٦d + "  cause:" + v0.a.a(i10) + "  cancelCause:" + t.a.a(1) + "  realCause:" + LogUtils.getErrorInfo(exc));
            String str2 = m.f١٥١٠٢m;
            StringBuilder sb = new StringBuilder("taskEnd:");
            sb.append(mVar.f١٥١٠٦d);
            sb.append("  cause:");
            sb.append(v0.a.a(i10));
            sb.append("  cancelCause:");
            sb.append(t.a.a(1));
            SudLogger.d(str2, sb.toString());
            if (exc != null) {
                exc.printStackTrace();
            }
            if (exc != null) {
                str = exc.toString();
            } else {
                str = null;
            }
            if (str == null) {
                if (i10 == 3) {
                    str = "user cancel";
                } else {
                    str = "EndCause:".concat(v0.a.a(i10));
                }
            }
            if (i10 == 1) {
                mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE);
                LogUtils.file("DownloadFileTask", "checkMd5:" + mVar.f١٥١٠٦d);
                SudLogger.d(str2, "checkMd5:" + mVar.f١٥١٠٦d);
                File h10 = eVar.h();
                mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_COMPLETED);
                if (h10 == null) {
                    absolutePath = "";
                } else {
                    absolutePath = h10.getAbsolutePath();
                }
                ArrayList arrayList = mVar.f١٥١٠٧e;
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((c) arrayList.get(i11)).f(absolutePath, mVar.f١٥١١١i, null, mVar.f١٥١١٠h);
                }
                return;
            }
            if (i10 == 3) {
                int a10 = h0.a(1);
                if (a10 != 0) {
                    if (a10 != 2) {
                        if (a10 != 3) {
                            mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_CANCELED);
                            mVar.a(-1, "unknown cancel");
                            return;
                        } else {
                            mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_WAITING);
                            mVar.a(-1, "hang up cancel");
                            return;
                        }
                    }
                    mVar.b(PkgDownloadStatus.PKG_DOWNLOAD_PAUSE);
                    mVar.a(-1, "pause cancel");
                    return;
                }
                mVar.a(-10101, "retry download fail. unknown cancel");
                return;
            }
            mVar.a(d.a.a(exc), str);
            return;
        }
        SudLogger.w(m.f١٥١٠٢m, "taskEnd error task is null");
        LogUtils.file("DownloadFileTask", "taskEnd error task is null");
    }
}
