package ze;

import android.content.Context;
import java.io.File;
import re.d;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import wf.e;
import ye.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b extends g {
    public static final String f = "SudGIP ".concat(b.class.getSimpleName());
    public final String e;

    public b(Context context, lf.b bVar) {
        super(bVar);
        this.a = 20;
        this.e = new File(context.getFilesDir(), "sud/mgp/sudapp").getAbsolutePath();
    }

    @Override // ye.g
    public final Object b(d dVar, File file) {
        LogUtils.file("SUDRealSudGamePackageManager", "processDownloadPackage");
        a aVar = new a();
        dVar.f = System.currentTimeMillis();
        this.b.f(dVar);
        e(dVar.a);
        return aVar;
    }

    @Override // ye.g
    public final void h(String str, Object obj, e eVar, re.a aVar) {
        if (obj instanceof a) {
            LogUtils.file("SUDRealSudGamePackageManager", "onDownloadSuccess path=" + str);
            SudLogger.d(f, "onDownloadSuccess path=" + str);
            aVar.b(str, eVar);
            return;
        }
        aVar.e(-1, "extendInfo empty", eVar);
    }

    @Override // ye.g
    public final String k(String str) {
        return this.e;
    }
}
