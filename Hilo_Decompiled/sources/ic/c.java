package ic;

import android.graphics.Color;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class c {
    public static int a(int i10, int i11, float f10) {
        float b10 = g.b(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        return Color.argb(((int) ((Color.alpha(i11) - r0) * b10)) + Color.alpha(i10), ((int) ((Color.red(i11) - r0) * b10)) + Color.red(i10), ((int) ((Color.green(i11) - r0) * b10)) + Color.green(i10), ((int) ((Color.blue(i11) - r4) * b10)) + Color.blue(i10));
    }
}
