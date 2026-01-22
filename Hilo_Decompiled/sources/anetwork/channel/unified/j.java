package anetwork.channel.unified;

import anetwork.channel.interceptor.Callback;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final anetwork.channel.entity.g f٥٢٨١a;

    /* renamed from: b, reason: collision with root package name */
    public Callback f٥٢٨٢b;

    /* renamed from: c, reason: collision with root package name */
    public final String f٥٢٨٣c;

    /* renamed from: d, reason: collision with root package name */
    public volatile AtomicBoolean f٥٢٨٤d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public volatile IUnifiedTask f٥٢٨٥e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile Future f٥٢٨٦f = null;

    public j(anetwork.channel.entity.g gVar, Callback callback) {
        this.f٥٢٨١a = gVar;
        this.f٥٢٨٣c = gVar.f٥٢٢٨e;
        this.f٥٢٨٢b = callback;
    }

    public void a() {
        Future future = this.f٥٢٨٦f;
        if (future != null) {
            future.cancel(true);
            this.f٥٢٨٦f = null;
        }
    }

    public void b() {
        if (this.f٥٢٨٥e != null) {
            this.f٥٢٨٥e.cancel();
            this.f٥٢٨٥e = null;
        }
    }
}
