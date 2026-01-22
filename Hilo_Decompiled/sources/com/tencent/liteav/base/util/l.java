package com.tencent.liteav.base.util;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class l implements q {
    final ThreadPoolExecutor a;
    final CustomHandler b;
    final List<a> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class a {
        final Runnable a;
        private final Runnable c;
        private final Runnable d = o.a(this);
        private final long e;

        public a(Runnable runnable, long j) {
            this.c = runnable;
            this.a = n.a(this, runnable);
            this.e = j;
        }

        public final void a() {
            l.this.b.postDelayed(this.d, this.e);
        }
    }

    public l() {
        this((byte) 0);
    }

    @Override // com.tencent.liteav.base.util.q
    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }

    private l(byte b) {
        this("SequenceTaskRunner_");
    }

    public final void a(Runnable runnable, long j) {
        a aVar = new a(runnable, j);
        synchronized (this) {
            this.c.add(aVar);
        }
        aVar.a();
    }

    public l(String str) {
        this.a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), m.a(str));
        this.b = new CustomHandler(Looper.getMainLooper());
        this.c = new ArrayList();
    }
}
