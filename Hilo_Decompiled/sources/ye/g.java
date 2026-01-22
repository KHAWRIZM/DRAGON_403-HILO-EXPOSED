package ye;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import d.k;
import d.p;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tech.sud.gip.R;
import tech.sud.gip.core.ISudCfg;
import tech.sud.gip.core.SudGIP;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class g {
    public static final String d = "SudGIP ".concat(g.class.getSimpleName());
    public final lf.b b;
    public int a = 10;
    public final i c = new i(this);

    public g(lf.b bVar) {
        this.b = bVar;
    }

    public final long a(t.c cVar, re.a aVar) {
        String str;
        String b = j.b(cVar.d);
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(cVar.d);
        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
            str = b + "." + fileExtensionFromUrl;
        } else {
            str = b;
        }
        String k = k(b);
        u.a.a(k);
        re.d dVar = new re.d();
        dVar.c = cVar.d;
        dVar.a = cVar.c;
        dVar.b = cVar.e;
        dVar.d = str;
        cVar.g = dVar;
        LogUtils.file("RealSudGamePackageManager", "downloadPackage");
        SudLogger.d(d, "downloadPackage");
        String str2 = j0.e.d;
        return j0.b.a.a(cVar, k, str, new f(this, aVar, cVar), this.c);
    }

    public abstract Object b(re.d dVar, File file);

    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(int i, long j, String str, re.b bVar) {
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        String str3;
        k kVar;
        d.j jVar;
        if (bVar != null) {
            if ("true".equals(SudGIP.getCfg().getAdvancedConfigMap().get(ISudCfg.PRIORITY_EMBEDDED_GAME_PKG))) {
                String str4 = (String) h0.b.a.c.get(Long.valueOf(j));
                if (!TextUtils.isEmpty(str4)) {
                    g(j, str4, bVar);
                    return;
                }
            }
            p pVar = e.d.e;
            if (pVar != null && (kVar = pVar.c) != null && (jVar = kVar.g) != null) {
                z = jVar.a;
            } else {
                z = true;
            }
            if (z) {
                String str5 = (String) h0.b.a.c.get(Long.valueOf(j));
                if (!TextUtils.isEmpty(str5)) {
                    Matcher matcher = Pattern.compile("\\d+(\\.\\d+){3}").matcher(str5);
                    if (matcher.find()) {
                        str3 = matcher.group();
                    } else {
                        str3 = null;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        if (TextUtils.isEmpty(str)) {
                            f(j, str3, str5, bVar);
                        } else if (str3.equals(str)) {
                            g(j, str5, bVar);
                        }
                        z3 = true;
                        if (z3) {
                            return;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                }
            } else {
                String str6 = (String) h0.b.a.c.get(Long.valueOf(j));
                if (TextUtils.isEmpty(str6)) {
                    z2 = false;
                } else {
                    Matcher matcher2 = Pattern.compile("\\d+(\\.\\d+){3}").matcher(str6);
                    if (matcher2.find()) {
                        str2 = matcher2.group();
                    } else {
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        g(j, str6, bVar);
                    } else {
                        f(j, str2, str6, bVar);
                    }
                    z2 = true;
                }
                if (z2) {
                    return;
                }
            }
            re.d a = nf.a.a(this.b.a.getString(String.valueOf(j), ""));
            if (a != null) {
                LogUtils.file("RealSudGamePackageManager", "isPackageInstalled gamePackageInfo != null");
                String str7 = d;
                SudLogger.d(str7, "isPackageInstalled gamePackageInfo != null");
                if (!TextUtils.isEmpty(a.d)) {
                    String j2 = j(a.c);
                    String absolutePath = new File(j2, a.d).getAbsolutePath();
                    t.d dVar = new t.d();
                    dVar.a = t.b.b;
                    dVar.b = str;
                    dVar.c = a.b;
                    dVar.d = j2;
                    dVar.e = a.d;
                    dVar.f = a.e;
                    dVar.g = i;
                    String str8 = j0.e.d;
                    j0.b.a.getClass();
                    boolean d2 = j0.e.d(dVar);
                    LogUtils.file("RealSudGamePackageManager", "isPackageInstalled isOk=" + d2);
                    SudLogger.d(str7, "isPackageInstalled isOk=" + d2);
                    if (d2) {
                        a.f = System.currentTimeMillis();
                        this.b.f(a);
                        bVar.a(true, c(absolutePath), true);
                        return;
                    }
                    this.b.c(j);
                }
            }
            bVar.a(false, "", true);
        }
    }

    public final void e(long j) {
        ArrayList b = this.b.b();
        if (b.size() > this.a) {
            for (re.d dVar : b.subList(0, b.size() - this.a)) {
                if (dVar.a != j) {
                    LogUtils.file("RealSudGamePackageManager", "removeDiskCacheLimit mgId:" + dVar.a);
                    this.b.c(dVar.a);
                    String str = j(dVar.c) + "/" + dVar.d;
                    String str2 = u.f.a;
                    LogUtils.file("FileUtils", "deleteFile result:" + new File(str).delete());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
    
        if (r14 > 0) goto L٣٨;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(long j, String str, String str2, re.b bVar) {
        boolean z;
        char c;
        re.d a = nf.a.a(this.b.a.getString(String.valueOf(j), ""));
        if (a != null && !TextUtils.isEmpty(a.b) && !TextUtils.isEmpty(a.d)) {
            String absolutePath = new File(j(a.c), a.d).getAbsolutePath();
            String str3 = u.f.a;
            if (absolutePath != null) {
                z = new File(absolutePath).exists();
                if (!z) {
                    re.d a2 = nf.a.a(this.b.a.getString(String.valueOf(j), ""));
                    String[] split = a2.b.split("\\.");
                    String[] split2 = str.split("\\.");
                    int min = Math.min(split.length, split2.length);
                    long j2 = 0;
                    int i = 0;
                    while (i < min) {
                        j2 = Long.parseLong(split[i]) - Long.parseLong(split2[i]);
                        if (j2 != 0) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j2 == 0) {
                        for (int i2 = i; i2 < split.length; i2++) {
                            if (Long.parseLong(split[i2]) > 0) {
                                c = 1;
                                break;
                            }
                        }
                        while (i < split2.length) {
                            if (Long.parseLong(split2[i]) <= 0) {
                                i++;
                            } else {
                                c = 65535;
                                break;
                            }
                        }
                        c = 0;
                    }
                    if (c > 0) {
                        bVar.a(true, c(new File(j(a2.c), a2.d).getAbsolutePath()), false);
                        return;
                    } else {
                        g(j, str2, bVar);
                        return;
                    }
                }
                g(j, str2, bVar);
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    public void g(long j, String str, re.b bVar) {
        bVar.a(true, str, false);
    }

    public abstract void h(String str, Object obj, wf.e eVar, re.a aVar);

    public final void i(re.c cVar) {
        s0.f fVar = (s0.f) cVar;
        LogUtils.file("SudGameLoadingStageLoadPackage", "PackageInstallListener.onInstallStart");
        String str = s0.i.j;
        SudLogger.d(str, "PackageInstallListener.onInstallStart");
        s0.i iVar = fVar.a;
        if (!iVar.f) {
            iVar.c.c(iVar.a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_install_game_package_start));
        }
        s0.i iVar2 = fVar.a;
        if (!iVar2.f) {
            iVar2.c.c(iVar2.a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_install_game_package_downloading));
        }
        LogUtils.file("SudGameLoadingStageLoadPackage", "PackageInstallListener.onSuccess");
        SudLogger.d(str, "PackageInstallListener.onSuccess");
        s0.i iVar3 = fVar.a;
        if (!iVar3.f) {
            iVar3.c.c(iVar3.a.getString(R.string.fsm_mgp_game_loading_stage_loadPackage_install_game_package_download_finish));
            fVar.a.c.a(3);
        }
    }

    public String j(String str) {
        return k(str);
    }

    public abstract String k(String str);

    public String c(String str) {
        return str;
    }
}
