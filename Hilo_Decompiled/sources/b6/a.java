package b6;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements a6.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f٥٤٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private final e6.b f٥٤٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private final c6.b f٥٤٢٨c;

    /* renamed from: d, reason: collision with root package name */
    private final d6.a f٥٤٢٩d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f٥٤٣٠e;

    /* renamed from: f, reason: collision with root package name */
    private o5.b f٥٤٣١f;

    /* renamed from: g, reason: collision with root package name */
    private f6.b f٥٤٣٢g;

    /* renamed from: h, reason: collision with root package name */
    private volatile d f٥٤٣٣h = new d();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f٥٤٣٤a;

        /* renamed from: b, reason: collision with root package name */
        e6.b f٥٤٣٥b;

        /* renamed from: c, reason: collision with root package name */
        c6.b f٥٤٣٦c;

        /* renamed from: d, reason: collision with root package name */
        d6.a f٥٤٣٧d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٥٤٣٨e;

        /* renamed from: f, reason: collision with root package name */
        o5.b f٥٤٣٩f;

        /* renamed from: g, reason: collision with root package name */
        f6.b f٥٤٤٠g;

        public b(String str) {
            this.f٥٤٣٤a = str;
        }

        private void d() {
            if (this.f٥٤٣٥b == null) {
                this.f٥٤٣٥b = x5.a.e();
            }
            if (this.f٥٤٣٦c == null) {
                this.f٥٤٣٦c = x5.a.b();
            }
            if (this.f٥٤٣٧d == null) {
                this.f٥٤٣٧d = x5.a.d();
            }
            if (this.f٥٤٣٩f == null) {
                this.f٥٤٣٩f = x5.a.f();
            }
            if (this.f٥٤٤٠g == null) {
                this.f٥٤٤٠g = x5.a.k();
            }
        }

        public b a(c6.c cVar) {
            if (!(cVar instanceof c6.b)) {
                cVar = new y5.a(cVar);
            }
            c6.b bVar = (c6.b) cVar;
            this.f٥٤٣٦c = bVar;
            y5.b.b(bVar);
            return this;
        }

        public a b() {
            d();
            return new a(this);
        }

        public b c(e6.b bVar) {
            this.f٥٤٣٥b = bVar;
            return this;
        }

        public b e(o5.b bVar) {
            this.f٥٤٣٩f = bVar;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        long f٥٤٤١a;

        /* renamed from: b, reason: collision with root package name */
        int f٥٤٤٢b;

        /* renamed from: c, reason: collision with root package name */
        String f٥٤٤٣c;

        /* renamed from: d, reason: collision with root package name */
        String f٥٤٤٤d;

        c(long j10, int i10, String str, String str2) {
            this.f٥٤٤١a = j10;
            this.f٥٤٤٢b = i10;
            this.f٥٤٤٣c = str;
            this.f٥٤٤٤d = str2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private BlockingQueue f٥٤٤٥a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f٥٤٤٦b;

        private d() {
            this.f٥٤٤٥a = new LinkedBlockingQueue();
        }

        void a(c cVar) {
            try {
                this.f٥٤٤٥a.put(cVar);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }

        boolean b() {
            boolean z10;
            synchronized (this) {
                z10 = this.f٥٤٤٦b;
            }
            return z10;
        }

        void c() {
            synchronized (this) {
                try {
                    if (this.f٥٤٤٦b) {
                        return;
                    }
                    new Thread(this).start();
                    this.f٥٤٤٦b = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c cVar = (c) this.f٥٤٤٥a.take();
                    if (cVar != null) {
                        a.this.d(cVar.f٥٤٤١a, cVar.f٥٤٤٢b, cVar.f٥٤٤٣c, cVar.f٥٤٤٤d);
                    } else {
                        return;
                    }
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                    synchronized (this) {
                        this.f٥٤٤٦b = false;
                        return;
                    }
                }
            }
        }
    }

    a(b bVar) {
        this.f٥٤٢٦a = bVar.f٥٤٣٤a;
        this.f٥٤٢٧b = bVar.f٥٤٣٥b;
        this.f٥٤٢٨c = bVar.f٥٤٣٦c;
        this.f٥٤٢٩d = bVar.f٥٤٣٧d;
        this.f٥٤٣٠e = bVar.f٥٤٣٨e;
        this.f٥٤٣١f = bVar.f٥٤٣٩f;
        this.f٥٤٣٢g = bVar.f٥٤٤٠g;
        b();
    }

    private void b() {
        File file = new File(this.f٥٤٢٦a);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private void c(String str) {
        File[] listFiles = new File(this.f٥٤٢٦a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if ((str == null || !str.equals(file.getName())) && this.f٥٤٢٩d.a(file)) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j10, int i10, String str, String str2) {
        String d10 = this.f٥٤٣٢g.d();
        boolean e10 = this.f٥٤٣٢g.e();
        if (d10 == null || !e10 || this.f٥٤٢٧b.b()) {
            String a10 = this.f٥٤٢٧b.a(i10, System.currentTimeMillis());
            if (a10 != null && a10.trim().length() != 0) {
                if (!a10.equals(d10) || !e10) {
                    this.f٥٤٣٢g.b();
                    c(null);
                    if (!this.f٥٤٣٢g.f(new File(this.f٥٤٢٦a, a10))) {
                        return;
                    } else {
                        d10 = a10;
                    }
                }
            } else {
                x5.b.d().b("File name should not be empty, ignore log: " + str2);
                return;
            }
        }
        File c10 = this.f٥٤٣٢g.c();
        if (this.f٥٤٢٨c.b(c10)) {
            this.f٥٤٣٢g.b();
            y5.b.a(c10, this.f٥٤٢٨c);
            if (!this.f٥٤٣٢g.f(new File(this.f٥٤٢٦a, d10))) {
                return;
            }
        }
        this.f٥٤٣٢g.a(this.f٥٤٣١f.a(j10, i10, str, str2).toString());
    }

    @Override // a6.b
    public void println(int i10, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f٥٤٣٣h.b()) {
            this.f٥٤٣٣h.c();
        }
        this.f٥٤٣٣h.a(new c(currentTimeMillis, i10, str, str2));
    }
}
