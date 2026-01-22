package wf;

import android.util.Log;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class b {
    public String a = "HttpLoggingInterceptor";

    public final void a(String str) {
        if (d.d) {
            Log.i("okhttp.OkHttpClient", str);
        }
        LogUtils.file(this.a, str);
    }
}
