package tech.sud.runtime.component.g;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class e {
    private b a;
    private Map<f, d> b;
    private String c = "";
    private String d = "";
    private String e = "";
    private final Set<String> f = new HashSet();
    private String g = "";

    private void b() {
        this.a.c();
        int f = this.a.f();
        this.a.b(6L);
        this.b = new HashMap();
        d[] dVarArr = new d[f];
        for (int i = 0; i < f; i++) {
            d dVar = new d();
            dVarArr[i] = dVar;
            this.b.put(f.a(dVar.a(this.a)), dVarArr[i]);
        }
        this.b.put(f.a, new d(0L, this.a.a()));
    }

    private void c() {
        String a;
        a(this.a, f.b, 2L);
        int a2 = this.a.a();
        int f = this.a.f();
        int f2 = (this.a.f() + a2) - 2;
        int i = a2 + 4;
        while (true) {
            int i2 = f - 1;
            if (f > 0) {
                this.a.a(i);
                int f3 = this.a.f();
                int f4 = this.a.f();
                int f5 = this.a.f();
                int f6 = this.a.f();
                int f7 = this.a.f();
                if ((f3 == 1 || f3 == 3) && (f4 == 0 || f4 == 1)) {
                    this.a.a(r12.f() + f2);
                    if (f3 == 3) {
                        a = this.a.a(f7, f4);
                    } else {
                        a = this.a.a(f7);
                    }
                    if (f6 != 0) {
                        if (f6 != 1) {
                            if (f6 != 2) {
                                if (f6 != 4) {
                                    if (f6 != 6) {
                                        if (f6 != 16) {
                                        }
                                    } else if (this.c.length() == 0) {
                                        this.c = a;
                                    }
                                } else if (this.d.length() == 0 || (f3 == 3 && f5 == 1033)) {
                                    this.d = a;
                                }
                            } else if (this.g.length() == 0) {
                                this.g = a;
                            }
                        }
                        this.f.add(a);
                    } else if (this.e.length() == 0) {
                        this.e = a;
                    }
                }
                i += 12;
                f = i2;
            } else {
                return;
            }
        }
    }

    public String a() {
        return this.c;
    }

    public void a(b bVar) {
        this.a = bVar;
        b();
        c();
    }

    private boolean a(b bVar, f fVar, long j) {
        d dVar = this.b.get(fVar);
        if (dVar == null) {
            return false;
        }
        bVar.a(dVar.a() + j);
        return true;
    }
}
