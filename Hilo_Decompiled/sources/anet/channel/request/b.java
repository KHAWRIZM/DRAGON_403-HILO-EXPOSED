package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Future<?> f٤٨٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٤٨٨١b;

    public b(Future<?> future, String str) {
        this.f٤٨٨٠a = future;
        this.f٤٨٨١b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.f٤٨٨٠a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f٤٨٨١b, new Object[0]);
            this.f٤٨٨٠a.cancel(true);
        }
    }
}
