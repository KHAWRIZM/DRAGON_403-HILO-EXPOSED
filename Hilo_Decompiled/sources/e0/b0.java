package e0;

import android.net.NetworkInfo;
import anet.channel.util.HttpConstant;
import java.util.UUID;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b0 extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f١٣٧٤٣a;

    /* renamed from: b, reason: collision with root package name */
    public final p0 f١٣٧٤٤b;

    public b0(g0 g0Var, p0 p0Var) {
        this.f١٣٧٤٣a = g0Var;
        this.f١٣٧٤٤b = p0Var;
    }

    @Override // e0.j0
    public final int a() {
        return 2;
    }

    @Override // e0.j0
    public final j b(e0 e0Var, int i10) {
        CacheControl cacheControl;
        int i11;
        if (i10 != 0) {
            if ((i10 & 4) != 0) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                CacheControl.Builder builder = new CacheControl.Builder();
                if ((i10 & 1) != 0) {
                    builder.noCache();
                }
                if ((i10 & 2) != 0) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        } else {
            cacheControl = null;
        }
        Request.Builder url = new Request.Builder().addHeader("Referer", e.e.b(u.j.b(UUID.randomUUID().toString()))).addHeader("sud-device-brand", u.g.a(u.h.a())).addHeader("sud-os-version", u.h.d()).addHeader("sud-device-id", u.h.c()).url(e0Var.f١٣٧٨٣a.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f١٣٧٤٣a.f١٣٧٨٩a.newCall(url.build()).execute();
        ResponseBody body = execute.body();
        if (execute.isSuccessful()) {
            if (execute.cacheResponse() == null) {
                i11 = 3;
            } else {
                i11 = 2;
            }
            if (i11 == 2 && body.contentLength() == 0) {
                body.close();
                throw new s0();
            }
            if (i11 == 3 && body.contentLength() > 0) {
                p0 p0Var = this.f١٣٧٤٤b;
                long contentLength = body.contentLength();
                f0 f0Var = p0Var.f١٣٨٠٩b;
                f0Var.sendMessage(f0Var.obtainMessage(4, Long.valueOf(contentLength)));
            }
            return new j(body.source(), i11);
        }
        body.close();
        throw new w(execute.code());
    }

    @Override // e0.j0
    public final boolean c(NetworkInfo networkInfo) {
        if (networkInfo != null && !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    @Override // e0.j0
    public final boolean d(e0 e0Var) {
        String scheme = e0Var.f١٣٧٨٣a.getScheme();
        if (!HttpConstant.HTTP.equals(scheme) && !HttpConstant.HTTPS.equals(scheme)) {
            return false;
        }
        return true;
    }
}
