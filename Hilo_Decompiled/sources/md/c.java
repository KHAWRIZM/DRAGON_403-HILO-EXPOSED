package md;

import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class c extends h0 {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f١٦٠٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٦٠٨٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static final class a extends h0.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f١٦٠٨٦a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٦٠٨٧b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f١٦٠٨٨c;

        a(Handler handler, boolean z10) {
            this.f١٦٠٨٦a = handler;
            this.f١٦٠٨٧b = z10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٦٠٨٨c = true;
            this.f١٦٠٨٦a.removeCallbacksAndMessages(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٦٠٨٨c;
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.f١٦٠٨٨c) {
                        return nd.b.a();
                    }
                    b bVar = new b(this.f١٦٠٨٦a, ie.a.u(runnable));
                    Message obtain = Message.obtain(this.f١٦٠٨٦a, bVar);
                    obtain.obj = this;
                    if (this.f١٦٠٨٧b) {
                        obtain.setAsynchronous(true);
                    }
                    this.f١٦٠٨٦a.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
                    if (this.f١٦٠٨٨c) {
                        this.f١٦٠٨٦a.removeCallbacks(bVar);
                        return nd.b.a();
                    }
                    return bVar;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static final class b implements Runnable, nd.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f١٦٠٨٩a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f١٦٠٩٠b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f١٦٠٩١c;

        b(Handler handler, Runnable runnable) {
            this.f١٦٠٨٩a = handler;
            this.f١٦٠٩٠b = runnable;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٦٠٨٩a.removeCallbacks(this);
            this.f١٦٠٩١c = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٦٠٩١c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f١٦٠٩٠b.run();
            } catch (Throwable th) {
                ie.a.s(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Handler handler, boolean z10) {
        this.f١٦٠٨٤a = handler;
        this.f١٦٠٨٥b = z10;
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new a(this.f١٦٠٨٤a, this.f١٦٠٨٥b);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                b bVar = new b(this.f١٦٠٨٤a, ie.a.u(runnable));
                Message obtain = Message.obtain(this.f١٦٠٨٤a, bVar);
                if (this.f١٦٠٨٥b) {
                    obtain.setAsynchronous(true);
                }
                this.f١٦٠٨٤a.sendMessageDelayed(obtain, timeUnit.toMillis(j10));
                return bVar;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
