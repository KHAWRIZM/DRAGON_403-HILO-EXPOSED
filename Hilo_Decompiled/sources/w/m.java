package w;

import android.os.Handler;
import android.os.SystemClock;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m implements n0.b {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f١٨٦٦١a;

    public m(Handler handler) {
        this.f١٨٦٦١a = handler;
    }

    public final void a(n0.e eVar, int i10, int i11, Map map) {
        int i12 = eVar.f١٦١١٣b;
        Objects.toString(map);
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new f(eVar, i10, i11, map));
        } else {
            eVar.f١٦١٢٧p.getClass();
        }
    }

    @Override // n0.b
    public final void b(n0.e eVar) {
        int i10 = eVar.f١٦١١٣b;
        n0.f.a().getClass();
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new j(eVar));
        } else {
            eVar.f١٦١٢٧p.b(eVar);
        }
    }

    public final void c(n0.e eVar, int i10, long j10) {
        if (eVar.f١٦١٢٦o > 0) {
            eVar.f١٦١٢٨q.set(SystemClock.uptimeMillis());
        }
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new k(eVar, i10, j10));
        } else {
            eVar.f١٦١٢٧p.h(eVar, i10, j10);
        }
    }

    public final void d(n0.e eVar, int i10, Exception exc) {
        if (i10 == 2) {
            int i11 = eVar.f١٦١١٣b;
            Objects.toString(exc);
        }
        n0.f.a().getClass();
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new g(eVar, i10, exc));
        } else {
            eVar.f١٦١٢٧p.i(eVar, i10, exc);
        }
    }

    public final void e(n0.e eVar, int i10, Map map) {
        int i11 = eVar.f١٦١١٣b;
        Objects.toString(map);
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new d(eVar, i10, map));
        } else {
            eVar.f١٦١٢٧p.getClass();
        }
    }

    public final void f(n0.e eVar, Map map) {
        int i10 = eVar.f١٦١١٣b;
        Objects.toString(map);
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new l(eVar, map));
        } else {
            eVar.f١٦١٢٧p.getClass();
        }
    }

    public final void g(n0.e eVar, r0.g gVar, int i10) {
        int i11 = eVar.f١٦١١٣b;
        n0.f.a().getClass();
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new b(eVar, gVar, i10));
        } else {
            eVar.f١٦١٢٧p.g(eVar, gVar, i10);
        }
    }

    public final void h(n0.e eVar, int i10, Map map) {
        int i11 = eVar.f١٦١١٣b;
        Objects.toString(map);
        if (eVar.f١٦١٢٥n) {
            this.f١٨٦٦١a.post(new n(eVar, i10, map));
        } else {
            eVar.f١٦١٢٧p.getClass();
        }
    }
}
