package j;

import com.facebook.internal.security.CertificateUtil;
import java.util.Locale;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements tech.sud.runtime.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final o.a f١٤٩٨١a;

    public a(o.a aVar) {
        this.f١٤٩٨١a = aVar;
    }

    public final void a(int i10, int i11, String str, String str2, String str3) {
        ((g1.f) this.f١٤٩٨١a).getClass();
        Locale locale = Locale.US;
        String str4 = i10 + CertificateUtil.DELIMITER + str2 + CertificateUtil.DELIMITER + str3;
        LogUtils.file(i11, str, str4);
        if (!g1.h.f١٤٣٨٤m) {
            if (i11 == 6) {
                SudLogger.e(str, str4);
            }
        } else {
            if (i11 == 4) {
                SudLogger.i(str, str4);
                return;
            }
            if (i11 == 5) {
                SudLogger.w(str, str4);
            } else if (i11 != 6) {
                SudLogger.w(str, str4);
            } else {
                SudLogger.e(str, str4);
            }
        }
    }

    public final void a(int i10, String str, String str2) {
        ((g1.f) this.f١٤٩٨١a).getClass();
        LogUtils.file(i10, str, str2);
        if (!g1.h.f١٤٣٨٤m) {
            if (i10 == 6) {
                SudLogger.e(str, str2);
            }
        } else {
            if (i10 == 4) {
                SudLogger.i(str, str2);
                return;
            }
            if (i10 == 5) {
                SudLogger.w(str, str2);
            } else if (i10 != 6) {
                SudLogger.w(str, str2);
            } else {
                SudLogger.e(str, str2);
            }
        }
    }

    public final void a(int i10, String str, String str2, Throwable th) {
        ((g1.f) this.f١٤٩٨١a).getClass();
        Locale locale = Locale.US;
        String str3 = str2 + CertificateUtil.DELIMITER + LogUtils.getErrorInfo(th);
        LogUtils.file(i10, str, str3);
        if (!g1.h.f١٤٣٨٤m) {
            if (i10 == 6) {
                SudLogger.e(str, str3);
            }
        } else {
            if (i10 == 4) {
                SudLogger.i(str, str3);
                return;
            }
            if (i10 == 5) {
                SudLogger.w(str, str3);
            } else if (i10 != 6) {
                SudLogger.w(str, str3);
            } else {
                SudLogger.e(str, str3);
            }
        }
    }
}
