package kd;

import android.content.Context;
import androidx.appcompat.app.a0;
import d.d;
import d.k;
import d.n;
import d.p;
import java.io.File;
import jd.c;
import lf.b;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a extends c {
    public a(Context context, b bVar) {
        super(bVar);
        this.b = new File(context.getFilesDir(), "sud/mgp/sudcore/".concat(nf.b.b())).getAbsolutePath();
        this.c = new File(context.getCacheDir(), "sud/mgp/sudcache").getAbsolutePath();
    }

    @Override // jd.c
    public final d a() {
        String b = nf.b.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.c);
        sb2.append("/dynamic_load");
        String str = File.separator;
        sb2.append(str);
        String sb3 = sb2.toString();
        String str2 = this.b + str;
        String str3 = str2 + "libsud.so";
        d a = nf.b.a(sb3 + b + "/libsud.so", str3);
        if (a.a == 0) {
            LogUtils.file("SUDRealSudGameCoreManager", "setReadOnlyResult:" + new File(str3).setReadOnly() + " path:" + str3);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append("sud-dex.jar");
            String sb5 = sb4.toString();
            d a2 = nf.b.a(sb3 + "sud-dex.jar", sb5);
            if (a2.a == 0) {
                LogUtils.file("SUDRealSudGameCoreManager", "setReadOnlyResult:" + new File(sb5).setReadOnly() + " path:" + sb5);
                d0.a.a("TechSudMGPGlobal.sp").e("key_fix_android14_read_only_cocos");
            }
            return a2;
        }
        return a;
    }

    @Override // jd.c
    public final void c(long j, Object obj, jd.d dVar) {
        a0.a(obj);
        throw null;
    }

    @Override // jd.c
    public final boolean d(Object obj) {
        return false;
    }

    @Override // jd.c
    public final n e() {
        k kVar;
        p pVar = e.d.e;
        if (pVar != null && (kVar = pVar.c) != null) {
            return kVar.b;
        }
        return null;
    }
}
