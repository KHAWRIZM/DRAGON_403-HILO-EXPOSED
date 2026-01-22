package j0;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class t {
    public static void a(p pVar, File file, String str, boolean z10, String str2) {
        String absolutePath;
        if (pVar != null) {
            q qVar = (q) pVar;
            if (file == null) {
                absolutePath = "";
            } else {
                absolutePath = file.getAbsolutePath();
            }
            LogUtils.file("SudDownloadTask", "checkMd5 onCompleted mdId:" + qVar.f١٥١١٨a.f١٥٠٦٠b + "  path:" + absolutePath + "  checkMd5:" + str + "  fileMd5:" + str2 + "  isMatch:" + z10);
            if (z10) {
                LogUtils.file("SudDownloadTask", "checkMd5 match:" + qVar.f١٥١١٨a.f١٥٠٦٦h + "  :mgId:" + qVar.f١٥١١٨a.f١٥٠٦٠b);
                SudLogger.d(d.f١٥٠٥٨u, "checkMd5 match:" + qVar.f١٥١١٨a.f١٥٠٦٦h + "  :mgId:" + qVar.f١٥١١٨a.f١٥٠٦٠b);
                d dVar = qVar.f١٥١١٨a;
                x0.c cVar = dVar.f١٥٠٦٧i;
                if (cVar == null) {
                    PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_COMPLETED;
                    dVar.f١٥٠٦٦h = pkgDownloadStatus;
                    dVar.f١٥٠٧٦r = System.currentTimeMillis();
                    dVar.d(pkgDownloadStatus);
                    d dVar2 = qVar.f١٥١١٨a;
                    ArrayList arrayList = dVar2.f١٥٠٧٠l;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((c) obj).f(absolutePath, dVar2.f١٥٠٧٤p, null, dVar2.f١٥٠٧٣o);
                    }
                    dVar2.a();
                    return;
                }
                cVar.a(file, dVar.f١٥٠٧٤p, dVar.f١٥٠٦٥g.f١٧٩٤٠g, new n(qVar, absolutePath));
                return;
            }
            LogUtils.file("SudDownloadTask", "checkMd5 error:" + qVar.f١٥١١٨a.f١٥٠٦٦h + "  :mgId:" + qVar.f١٥١١٨a.f١٥٠٦٠b + "  checkMd5:" + str + "  fileMd5:" + str2);
            SudLogger.d(d.f١٥٠٥٨u, "checkMd5 error:" + qVar.f١٥١١٨a.f١٥٠٦٦h + "  :mgId:" + qVar.f١٥١١٨a.f١٥٠٦٠b + "  checkMd5:" + str + "  fileMd5:" + str2);
            String str3 = u.f.f١٨٢٢٢a;
            boolean delete = new File(absolutePath).delete();
            StringBuilder sb = new StringBuilder("deleteFile result:");
            sb.append(delete);
            LogUtils.file("FileUtils", sb.toString());
            d dVar3 = qVar.f١٥١١٨a;
            PkgDownloadStatus pkgDownloadStatus2 = PkgDownloadStatus.PKG_DOWNLOAD_COMPLETED;
            dVar3.f١٥٠٦٦h = pkgDownloadStatus2;
            dVar3.f١٥٠٧٦r = System.currentTimeMillis();
            dVar3.d(pkgDownloadStatus2);
            qVar.f١٥١١٨a.b(-10200, "package flaw");
        }
    }

    public static /* synthetic */ void b(final File file, final String str, final p pVar) {
        final boolean equalsIgnoreCase;
        final String a10 = u.j.a(file);
        if (TextUtils.isEmpty(str)) {
            equalsIgnoreCase = true;
        } else {
            equalsIgnoreCase = str.equalsIgnoreCase(a10);
        }
        ThreadUtils.postUITask(new Runnable() { // from class: j0.s
            @Override // java.lang.Runnable
            public final void run() {
                t.a(p.this, file, str, equalsIgnoreCase, a10);
            }
        });
    }

    public static void c(final File file, final String str, final q qVar) {
        w0.a.f١٨٦٦٥a.execute(new Runnable() { // from class: j0.r
            @Override // java.lang.Runnable
            public final void run() {
                t.b(file, str, qVar);
            }
        });
    }
}
