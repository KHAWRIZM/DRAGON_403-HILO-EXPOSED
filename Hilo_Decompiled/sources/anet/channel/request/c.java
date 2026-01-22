package anet.channel.request;

import anet.channel.util.ALog;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);

    /* renamed from: a, reason: collision with root package name */
    private final int f٤٨٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final SpdySession f٤٨٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٤٨٨٤c;

    public c(SpdySession spdySession, int i10, String str) {
        this.f٤٨٨٣b = spdySession;
        this.f٤٨٨٢a = i10;
        this.f٤٨٨٤c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        int i10;
        try {
            if (this.f٤٨٨٣b != null && (i10 = this.f٤٨٨٢a) != 0) {
                ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f٤٨٨٤c, "streamId", Integer.valueOf(i10));
                this.f٤٨٨٣b.streamReset(this.f٤٨٨٢a, 5);
            }
        } catch (SpdyErrorException e10) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f٤٨٨٤c, e10, "errorCode", Integer.valueOf(e10.SpdyErrorGetCode()));
        }
    }
}
