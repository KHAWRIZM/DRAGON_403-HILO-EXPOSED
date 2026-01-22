package jd;

import d.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class c {
    public final lf.b a;
    public String b;
    public String c;

    static {
        "SudGIP ".concat(c.class.getSimpleName());
    }

    public c(lf.b bVar) {
        new b(this);
        this.a = bVar;
    }

    public abstract d.d a();

    public final void b(int i, hd.a aVar) {
        String str;
        String str2;
        String str3;
        n e = e();
        if (e == null || (str = e.c) == null || str.isEmpty() || (str2 = e.a) == null || str2.isEmpty() || (str3 = e.b) == null || str3.isEmpty()) {
            e = null;
        }
        if (e == null) {
            aVar.a("sdkCoreCfg url_arm64_v8a version key cannot be empty");
        } else {
            aVar.b(nf.b.b());
        }
    }

    public abstract void c(long j, Object obj, d dVar);

    public abstract boolean d(Object obj);

    public abstract n e();
}
