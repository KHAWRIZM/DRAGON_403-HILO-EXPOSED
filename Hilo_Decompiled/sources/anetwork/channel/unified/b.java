package anetwork.channel.unified;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anetwork.channel.cookie.CookieManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements IUnifiedTask {

    /* renamed from: c, reason: collision with root package name */
    private j f٥٢٤١c;

    /* renamed from: f, reason: collision with root package name */
    private Request f٥٢٤٤f;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f٥٢٤٠b = false;

    /* renamed from: a, reason: collision with root package name */
    volatile Cancelable f٥٢٣٩a = null;

    /* renamed from: d, reason: collision with root package name */
    private int f٥٢٤٢d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f٥٢٤٣e = 0;

    public b(j jVar) {
        this.f٥٢٤١c = jVar;
        this.f٥٢٤٤f = jVar.f٥٢٨١a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(b bVar) {
        int i10 = bVar.f٥٢٤٣e;
        bVar.f٥٢٤٣e = i10 + 1;
        return i10;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f٥٢٤٠b = true;
        if (this.f٥٢٣٩a != null) {
            this.f٥٢٣٩a.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f٥٢٤٠b) {
            return;
        }
        if (this.f٥٢٤١c.f٥٢٨١a.i()) {
            String cookie = CookieManager.getCookie(this.f٥٢٤١c.f٥٢٨١a.g());
            if (!TextUtils.isEmpty(cookie)) {
                Request.Builder newBuilder = this.f٥٢٤٤f.newBuilder();
                String str = this.f٥٢٤٤f.getHeaders().get(HttpConstant.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    cookie = StringUtils.concatString(str, "; ", cookie);
                }
                newBuilder.addHeader(HttpConstant.COOKIE, cookie);
                this.f٥٢٤٤f = newBuilder.build();
            }
        }
        this.f٥٢٤٤f.f٤٨٤٤a.degraded = 2;
        this.f٥٢٤٤f.f٤٨٤٤a.sendBeforeTime = System.currentTimeMillis() - this.f٥٢٤٤f.f٤٨٤٤a.reqStart;
        anet.channel.session.b.a(this.f٥٢٤٤f, new c(this));
    }
}
