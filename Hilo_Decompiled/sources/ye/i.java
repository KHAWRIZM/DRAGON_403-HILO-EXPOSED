package ye;

import android.text.TextUtils;
import j0.n;
import java.io.File;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class i implements x0.c {
    public final /* synthetic */ g a;

    public i(g gVar) {
        this.a = gVar;
    }

    public final void a(final File file, long j, Object obj, final n nVar) {
        if (file != null && (obj instanceof re.d)) {
            LogUtils.file("RealSudGamePackageManager", "processor onDownloadSuccess");
            final re.d dVar = (re.d) obj;
            dVar.e = j;
            w0.a.a.execute(new Runnable() { // from class: ye.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.b(file, dVar, nVar);
                }
            });
            return;
        }
        nVar.a((Object) null);
    }

    public final void b(File file, re.d dVar, x0.a aVar) {
        LogUtils.file("RealSudGamePackageManager", "processor onDownloadSuccess 子线程start:" + file.getAbsolutePath());
        g gVar = this.a;
        long j = dVar.a;
        re.d a = nf.a.a(gVar.b.a.getString(String.valueOf(j), ""));
        if (a != null && !TextUtils.isEmpty(a.d)) {
            File file2 = new File(gVar.j(a.c), a.d);
            if (!file2.equals(file)) {
                String absolutePath = file2.getAbsolutePath();
                LogUtils.file("RealSudGamePackageManager", "deleteOldPackage oldFile:" + absolutePath + " newFile:" + file.getAbsolutePath());
                String str = u.f.a;
                LogUtils.file("FileUtils", "deleteFile result:" + new File(absolutePath).delete());
            }
        }
        ((n) aVar).a(this.a.b(dVar, file));
    }
}
