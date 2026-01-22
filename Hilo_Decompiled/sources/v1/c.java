package v1;

import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f١٨٣٢٩c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f١٨٣٣٠d = new Executor() { // from class: v1.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f١٨٣٣١e = new Executor() { // from class: v1.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f١٨٣٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private final e f١٨٣٣٣b;

    private c() {
        d dVar = new d();
        this.f١٨٣٣٣b = dVar;
        this.f١٨٣٣٢a = dVar;
    }

    public static Executor g() {
        return f١٨٣٣١e;
    }

    public static c h() {
        if (f١٨٣٢٩c != null) {
            return f١٨٣٢٩c;
        }
        synchronized (c.class) {
            try {
                if (f١٨٣٢٩c == null) {
                    f١٨٣٢٩c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f١٨٣٢٩c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        h().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Runnable runnable) {
        h().a(runnable);
    }

    @Override // v1.e
    public void a(Runnable runnable) {
        this.f١٨٣٣٢a.a(runnable);
    }

    @Override // v1.e
    public boolean c() {
        return this.f١٨٣٣٢a.c();
    }

    @Override // v1.e
    public void d(Runnable runnable) {
        this.f١٨٣٣٢a.d(runnable);
    }
}
