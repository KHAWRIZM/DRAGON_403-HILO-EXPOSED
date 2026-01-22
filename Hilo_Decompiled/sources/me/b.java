package me;

import android.content.Context;
import androidx.appcompat.app.a0;
import d.d;
import d.k;
import d.n;
import d.p;
import java.io.File;
import jd.c;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends c {
    public b(Context context, lf.b bVar) {
        super(bVar);
        ((c) this).b = new File(context.getFilesDir(), "sud/mgp/utcore/".concat(nf.b.b())).getAbsolutePath();
        ((c) this).c = new File(context.getCacheDir(), "sud/mgp/utcache").getAbsolutePath();
    }

    public final d a() {
        u.a.b(((c) this).b);
        u.a.a(((c) this).b);
        File file = new File(((c) this).c, "dynamic_load" + File.separator + nf.b.b());
        File file2 = new File(((c) this).b);
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                File file4 = new File(file2, file3.getName());
                d a10 = nf.b.a(file3.getAbsolutePath(), file4.getAbsolutePath());
                if (a10.f١٣٤٨٧a != 0) {
                    return a10;
                }
                LogUtils.file("UTRealSudGameCoreManager", "setReadOnlyResult:" + file4.setReadOnly() + " path:" + file4.getAbsolutePath());
            }
            d dVar = new d();
            dVar.f١٣٤٨٧a = 0;
            d0.a.a("TechSudMGPGlobal.sp").e("key_fix_android14_read_only_unity");
            return dVar;
        }
        d dVar2 = new d();
        dVar2.f١٣٤٨٧a = -10401;
        dVar2.f١٣٤٨٨b = "The source directory when the copy runtime is empty";
        return dVar2;
    }

    public final void c(long j10, Object obj, jd.d dVar) {
        a0.a(obj);
        ((c) this).a.d((a) null);
    }

    public final boolean d(Object obj) {
        return false;
    }

    public final n e() {
        k kVar;
        p pVar = e.d.f١٣٧٢٢e;
        if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null) {
            return kVar.f١٣٥١٢c;
        }
        return null;
    }
}
