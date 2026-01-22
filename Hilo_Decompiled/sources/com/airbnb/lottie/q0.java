package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q0 {

    /* renamed from: e, reason: collision with root package name */
    public static Executor f٦٢٨٢e = Executors.newCachedThreadPool(new x3.g());

    /* renamed from: a, reason: collision with root package name */
    private final Set f٦٢٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f٦٢٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f٦٢٨٥c;

    /* renamed from: d, reason: collision with root package name */
    private volatile o0 f٦٢٨٦d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends FutureTask {

        /* renamed from: a, reason: collision with root package name */
        private q0 f٦٢٨٧a;

        a(q0 q0Var, Callable callable) {
            super(callable);
            this.f٦٢٨٧a = q0Var;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                if (!isCancelled()) {
                    try {
                        this.f٦٢٨٧a.l((o0) get());
                    } catch (InterruptedException | ExecutionException e10) {
                        this.f٦٢٨٧a.l(new o0(e10));
                    }
                }
            } finally {
                this.f٦٢٨٧a = null;
            }
        }
    }

    public q0(Callable callable) {
        this(callable, false);
    }

    private synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f٦٢٨٤b);
        if (arrayList.isEmpty()) {
            x3.f.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l0) it.next()).onResult(th);
        }
    }

    private void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.f٦٢٨٥c.post(new Runnable() { // from class: com.airbnb.lottie.p0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.this.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        o0 o0Var = this.f٦٢٨٦d;
        if (o0Var == null) {
            return;
        }
        if (o0Var.b() != null) {
            i(o0Var.b());
        } else {
            f(o0Var.a());
        }
    }

    private synchronized void i(Object obj) {
        Iterator it = new ArrayList(this.f٦٢٨٣a).iterator();
        while (it.hasNext()) {
            ((l0) it.next()).onResult(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(o0 o0Var) {
        if (this.f٦٢٨٦d == null) {
            this.f٦٢٨٦d = o0Var;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized q0 c(l0 l0Var) {
        try {
            o0 o0Var = this.f٦٢٨٦d;
            if (o0Var != null && o0Var.a() != null) {
                l0Var.onResult(o0Var.a());
            }
            this.f٦٢٨٤b.add(l0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized q0 d(l0 l0Var) {
        try {
            o0 o0Var = this.f٦٢٨٦d;
            if (o0Var != null && o0Var.b() != null) {
                l0Var.onResult(o0Var.b());
            }
            this.f٦٢٨٣a.add(l0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public o0 e() {
        return this.f٦٢٨٦d;
    }

    public synchronized q0 j(l0 l0Var) {
        this.f٦٢٨٤b.remove(l0Var);
        return this;
    }

    public synchronized q0 k(l0 l0Var) {
        this.f٦٢٨٣a.remove(l0Var);
        return this;
    }

    public q0(Object obj) {
        this.f٦٢٨٣a = new LinkedHashSet(1);
        this.f٦٢٨٤b = new LinkedHashSet(1);
        this.f٦٢٨٥c = new Handler(Looper.getMainLooper());
        this.f٦٢٨٦d = null;
        l(new o0(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(Callable callable, boolean z10) {
        this.f٦٢٨٣a = new LinkedHashSet(1);
        this.f٦٢٨٤b = new LinkedHashSet(1);
        this.f٦٢٨٥c = new Handler(Looper.getMainLooper());
        this.f٦٢٨٦d = null;
        if (z10) {
            try {
                l((o0) callable.call());
                return;
            } catch (Throwable th) {
                l(new o0(th));
                return;
            }
        }
        f٦٢٨٢e.execute(new a(this, callable));
    }
}
