package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٢٨٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private a f٢٨٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private Object f٢٨٦٩c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٢٨٧٠d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        void onCancel();
    }

    private void b() {
        while (this.f٢٨٧٠d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f٢٨٦٧a) {
                    return;
                }
                this.f٢٨٦٧a = true;
                this.f٢٨٧٠d = true;
                a aVar = this.f٢٨٦٨b;
                Object obj = this.f٢٨٦٩c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f٢٨٧٠d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f٢٨٧٠d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void setOnCancelListener(a aVar) {
        synchronized (this) {
            try {
                b();
                if (this.f٢٨٦٨b == aVar) {
                    return;
                }
                this.f٢٨٦٨b = aVar;
                if (this.f٢٨٦٧a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }
}
