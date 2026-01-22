package c5;

import android.graphics.drawable.Drawable;
import anet.channel.util.HttpConstant;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import f5.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f implements c, g {

    /* renamed from: k, reason: collision with root package name */
    private static final a f٥٨٧٤k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f٥٨٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٥٨٧٦b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f٥٨٧٧c;

    /* renamed from: d, reason: collision with root package name */
    private final a f٥٨٧٨d;

    /* renamed from: e, reason: collision with root package name */
    private Object f٥٨٧٩e;

    /* renamed from: f, reason: collision with root package name */
    private d f٥٨٨٠f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٥٨٨١g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٥٨٨٢h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٥٨٨٣i;

    /* renamed from: j, reason: collision with root package name */
    private q f٥٨٨٤j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j10) {
            obj.wait(j10);
        }
    }

    public f(int i10, int i11) {
        this(i10, i11, true, f٥٨٧٤k);
    }

    private synchronized Object a(Long l10) {
        try {
            if (this.f٥٨٧٧c && !isDone()) {
                l.a();
            }
            if (!this.f٥٨٨١g) {
                if (!this.f٥٨٨٣i) {
                    if (this.f٥٨٨٢h) {
                        return this.f٥٨٧٩e;
                    }
                    if (l10 == null) {
                        this.f٥٨٧٨d.b(this, 0L);
                    } else if (l10.longValue() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long longValue = l10.longValue() + currentTimeMillis;
                        while (!isDone() && currentTimeMillis < longValue) {
                            this.f٥٨٧٨d.b(this, longValue - currentTimeMillis);
                            currentTimeMillis = System.currentTimeMillis();
                        }
                    }
                    if (!Thread.interrupted()) {
                        if (!this.f٥٨٨٣i) {
                            if (!this.f٥٨٨١g) {
                                if (this.f٥٨٨٢h) {
                                    return this.f٥٨٧٩e;
                                }
                                throw new TimeoutException();
                            }
                            throw new CancellationException();
                        }
                        throw new ExecutionException(this.f٥٨٨٤j);
                    }
                    throw new InterruptedException();
                }
                throw new ExecutionException(this.f٥٨٨٤j);
            }
            throw new CancellationException();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f٥٨٨١g = true;
                this.f٥٨٧٨d.a(this);
                d dVar = null;
                if (z10) {
                    d dVar2 = this.f٥٨٨٠f;
                    this.f٥٨٨٠f = null;
                    dVar = dVar2;
                }
                if (dVar != null) {
                    dVar.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return a(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.bumptech.glide.request.target.j
    public synchronized d getRequest() {
        return this.f٥٨٨٠f;
    }

    @Override // com.bumptech.glide.request.target.j
    public void getSize(com.bumptech.glide.request.target.i iVar) {
        iVar.d(this.f٥٨٧٥a, this.f٥٨٧٦b);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f٥٨٨١g;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z10;
        if (!this.f٥٨٨١g && !this.f٥٨٨٢h) {
            if (!this.f٥٨٨٣i) {
                z10 = false;
            }
        }
        z10 = true;
        return z10;
    }

    @Override // com.bumptech.glide.request.target.j
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public synchronized void onResourceReady(Object obj, d5.b bVar) {
    }

    @Override // com.bumptech.glide.request.target.j
    public synchronized void setRequest(d dVar) {
        this.f٥٨٨٠f = dVar;
    }

    public String toString() {
        d dVar;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                dVar = null;
                if (this.f٥٨٨١g) {
                    str = "CANCELLED";
                } else if (this.f٥٨٨٣i) {
                    str = "FAILURE";
                } else if (this.f٥٨٨٢h) {
                    str = HttpConstant.SUCCESS;
                } else {
                    str = VideoEvent.PENDING;
                    dVar = this.f٥٨٨٠f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVar != null) {
            return str2 + str + ", request=[" + dVar + "]]";
        }
        return str2 + str + "]";
    }

    f(int i10, int i11, boolean z10, a aVar) {
        this.f٥٨٧٥a = i10;
        this.f٥٨٧٦b = i11;
        this.f٥٨٧٧c = z10;
        this.f٥٨٧٨d = aVar;
    }

    @Override // c5.g
    public synchronized boolean onLoadFailed(q qVar, Object obj, com.bumptech.glide.request.target.j jVar, boolean z10) {
        this.f٥٨٨٣i = true;
        this.f٥٨٨٤j = qVar;
        this.f٥٨٧٨d.a(this);
        return false;
    }

    @Override // c5.g
    public synchronized boolean onResourceReady(Object obj, Object obj2, com.bumptech.glide.request.target.j jVar, m4.a aVar, boolean z10) {
        this.f٥٨٨٢h = true;
        this.f٥٨٧٩e = obj;
        this.f٥٨٧٨d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) {
        return a(Long.valueOf(timeUnit.toMillis(j10)));
    }

    @Override // z4.l
    public void onDestroy() {
    }

    @Override // z4.l
    public void onStart() {
    }

    @Override // z4.l
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.j
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public void removeCallback(com.bumptech.glide.request.target.i iVar) {
    }
}
