package fd;

import java.io.File;
import tech.sud.base.utils.Utils;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            e.b(new File(Utils.getApp().getFilesDir(), "sud/mgp/clog"));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.file("ReportCacheCLogTask", "ReportCacheCLogTask error:" + LogUtils.getErrorInfo(e));
        }
    }
}
