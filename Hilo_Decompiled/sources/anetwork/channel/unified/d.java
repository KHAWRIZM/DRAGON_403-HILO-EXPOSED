package anetwork.channel.unified;

import anetwork.channel.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d implements Future<Response> {

    /* renamed from: a, reason: collision with root package name */
    private k f٥٢٤٦a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٥٢٤٧b;

    public d(k kVar) {
        this.f٥٢٤٦a = kVar;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Response get() throws InterruptedException, ExecutionException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public Response b() throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        if (!this.f٥٢٤٧b) {
            this.f٥٢٤٦a.b();
            this.f٥٢٤٧b = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f٥٢٤٧b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ Response get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return b();
    }
}
