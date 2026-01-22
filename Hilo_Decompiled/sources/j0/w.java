package j0;

import e0.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class w extends x0.b {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f١٥١٣١b;

    public w(d dVar) {
        this.f١٥١٣١b = new WeakReference(dVar);
    }

    @Override // n0.b
    public final void b(n0.e eVar) {
        d dVar = (d) this.f١٥١٣١b.get();
        if (dVar != null) {
            ArrayList arrayList = dVar.f١٥٠٧٠l;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((c) obj).a();
            }
            LogUtils.file("SudDownloadTask", "taskStart mgId:" + dVar.f١٥٠٦٠b);
        }
    }

    @Override // m1.c
    public final void c(r0.g gVar) {
        gVar.c();
        d dVar = (d) this.f١٥١٣١b.get();
        if (dVar != null) {
            dVar.f١٥٠٧٤p = gVar.c();
            dVar.f١٥٠٧٥q = gVar.e();
            PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING;
            dVar.f١٥٠٦٦h = pkgDownloadStatus;
            dVar.f١٥٠٧٦r = System.currentTimeMillis();
            dVar.d(pkgDownloadStatus);
            LogUtils.file("SudDownloadTask", "infoReady mgId:" + dVar.f١٥٠٦٠b);
        }
    }

    @Override // m1.c
    public final void d(long j10) {
        d dVar = (d) this.f١٥١٣١b.get();
        if (dVar != null) {
            dVar.f١٥٠٧٥q = j10;
            long j11 = dVar.f١٥٠٧٤p;
            ArrayList arrayList = dVar.f١٥٠٧٠l;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((c) obj).d(j10, j11);
            }
            PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING;
            dVar.f١٥٠٦٦h = pkgDownloadStatus;
            dVar.f١٥٠٧٦r = System.currentTimeMillis();
            dVar.d(pkgDownloadStatus);
            SudLogger.d(d.f١٥٠٥٨u, "progress mgId:" + dVar.f١٥٠٦٠b + " 进度：" + j10 + "/" + dVar.f١٥٠٧٤p);
            LogUtils.file("SudDownloadTask", "progress mgId:" + dVar.f١٥٠٦٠b + " 进度：" + j10 + "/" + dVar.f١٥٠٧٤p);
        }
    }

    @Override // m1.c
    public final void e(n0.e eVar, int i10, Exception exc) {
        String str;
        d dVar = (d) this.f١٥١٣١b.get();
        if (dVar != null) {
            LogUtils.file("SudDownloadTask", "taskEnd:" + dVar.f١٥٠٦٦h + "  :mgId:" + dVar.f١٥٠٦٠b + "  cause:" + v0.a.a(i10) + "  cancelCause:" + t.a.a(dVar.f١٥٠٦٤f) + "  realCause:" + LogUtils.getErrorInfo(exc));
            String str2 = d.f١٥٠٥٨u;
            StringBuilder sb = new StringBuilder("taskEnd:");
            sb.append(dVar.f١٥٠٦٦h);
            sb.append("  :mgId:");
            sb.append(dVar.f١٥٠٦٠b);
            sb.append("  cause:");
            sb.append(v0.a.a(i10));
            sb.append("  cancelCause:");
            sb.append(t.a.a(dVar.f١٥٠٦٤f));
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
                PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE;
                dVar.f١٥٠٦٦h = pkgDownloadStatus;
                dVar.f١٥٠٧٦r = System.currentTimeMillis();
                dVar.d(pkgDownloadStatus);
                LogUtils.file("SudDownloadTask", "checkMd5:" + dVar.f١٥٠٦٦h + "  :mgId:" + dVar.f١٥٠٦٠b);
                SudLogger.d(str2, "checkMd5:" + dVar.f١٥٠٦٦h + "  :mgId:" + dVar.f١٥٠٦٠b);
                t.c(eVar.h(), dVar.f١٥٠٦٥g.f١٧٩٣٩f, new q(dVar));
            } else if (i10 == 3) {
                int a10 = h0.a(dVar.f١٥٠٦٤f);
                if (a10 != 0) {
                    if (a10 != 2) {
                        if (a10 != 3) {
                            PkgDownloadStatus pkgDownloadStatus2 = PkgDownloadStatus.PKG_DOWNLOAD_CANCELED;
                            dVar.f١٥٠٦٦h = pkgDownloadStatus2;
                            dVar.f١٥٠٧٦r = System.currentTimeMillis();
                            dVar.d(pkgDownloadStatus2);
                            dVar.a();
                        } else {
                            PkgDownloadStatus pkgDownloadStatus3 = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                            dVar.f١٥٠٦٦h = pkgDownloadStatus3;
                            dVar.f١٥٠٧٦r = System.currentTimeMillis();
                            dVar.d(pkgDownloadStatus3);
                        }
                    } else {
                        PkgDownloadStatus pkgDownloadStatus4 = PkgDownloadStatus.PKG_DOWNLOAD_PAUSE;
                        dVar.f١٥٠٦٦h = pkgDownloadStatus4;
                        dVar.f١٥٠٧٦r = System.currentTimeMillis();
                        dVar.d(pkgDownloadStatus4);
                    }
                } else {
                    dVar.f١٥٠٧٧s++;
                    LogUtils.file("SudDownloadTask", "unknown cancel:" + dVar.f١٥٠٧٧s);
                    SudLogger.d(str2, "unknown cancel:" + dVar.f١٥٠٧٧s);
                    if (dVar.f١٥٠٧٧s >= dVar.f١٥٠٧٨t) {
                        LogUtils.file("SudDownloadTask", "unknown cancel callback fail");
                        SudLogger.d(str2, "unknown cancel callback fail");
                        dVar.b(-10101, "retry download fail. unknown cancel");
                    } else {
                        LogUtils.file("SudDownloadTask", "unknown cancel retry download");
                        SudLogger.d(str2, "unknown cancel retry download");
                        PkgDownloadStatus pkgDownloadStatus5 = PkgDownloadStatus.PKG_DOWNLOAD_WAITING;
                        dVar.f١٥٠٦٦h = pkgDownloadStatus5;
                        dVar.f١٥٠٧٦r = System.currentTimeMillis();
                        dVar.d(pkgDownloadStatus5);
                    }
                }
            } else {
                dVar.b(d.a.a(exc), str);
            }
            a aVar = (a) dVar.f١٥٠٦٩k.get();
            if (aVar != null) {
                ((x) aVar).f١٥١٣٢a.c();
            }
        }
    }
}
