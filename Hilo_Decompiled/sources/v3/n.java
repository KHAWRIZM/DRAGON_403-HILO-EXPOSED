package v3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٤٢a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q3.c a(w3.c cVar) {
        cVar.c();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٤٢a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            cVar.z();
                            cVar.A();
                        } else {
                            f10 = (float) cVar.m();
                        }
                    } else {
                        str3 = cVar.s();
                    }
                } else {
                    str2 = cVar.s();
                }
            } else {
                str = cVar.s();
            }
        }
        cVar.h();
        return new q3.c(str, str2, str3, f10);
    }
}
