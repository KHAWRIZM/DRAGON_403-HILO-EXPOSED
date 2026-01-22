package e0;

import android.content.Context;
import java.io.File;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f١٣٧٨٩a;

    public g0(Context context) {
        StringBuilder sb = u0.f١٣٨٣٥a;
        File file = new File(context.getApplicationContext().getCacheDir(), "sud-picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        OkHttpClient build = new OkHttpClient.Builder().cache(new Cache(file, u0.c(file))).dns(new qf.z("PicassoIpv4PreferredDns")).build();
        this.f١٣٧٨٩a = build;
        build.cache();
    }
}
