package l1;

import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements c, a {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f١٥٦٨٨a;

    /* renamed from: b, reason: collision with root package name */
    public final Request.Builder f١٥٦٨٩b;

    /* renamed from: c, reason: collision with root package name */
    public Request f١٥٦٩٠c;

    /* renamed from: d, reason: collision with root package name */
    public Response f١٥٦٩١d;

    public d(OkHttpClient okHttpClient, String str) {
        Request.Builder url = new Request.Builder().url(str);
        this.f١٥٦٨٨a = okHttpClient;
        this.f١٥٦٨٩b = url;
    }

    public final String a(String str) {
        Response response = this.f١٥٦٩١d;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    public final void b(Map map) {
        if (map != null && map.size() > 0) {
            for (Class cls : map.keySet()) {
                this.f١٥٦٨٩b.tag(cls, map.get(cls));
            }
        }
    }
}
