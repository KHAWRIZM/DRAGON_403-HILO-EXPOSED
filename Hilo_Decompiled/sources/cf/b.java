package cf;

import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class b implements Runnable, l {
    private final k a = new k();
    private final c b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.b = cVar;
    }

    @Override // cf.l
    public void a(q qVar, Object obj) {
        j a = j.a(qVar, obj);
        synchronized (this) {
            try {
                this.a.a(a);
                if (!this.c) {
                    this.c = true;
                    this.b.d().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    j c = this.a.c(1000);
                    if (c == null) {
                        synchronized (this) {
                            c = this.a.b();
                            if (c == null) {
                                this.c = false;
                                this.c = false;
                                return;
                            }
                        }
                    }
                    this.b.g(c);
                } catch (InterruptedException e) {
                    this.b.e().a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.c = false;
                    return;
                }
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
    }
}
