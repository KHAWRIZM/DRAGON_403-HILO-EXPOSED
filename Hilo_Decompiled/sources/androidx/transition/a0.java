package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a0 extends k {
    int R;
    ArrayList P = new ArrayList();
    private boolean Q = true;
    boolean S = false;
    private int T = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f٤٢٢٥a;

        a(k kVar) {
            this.f٤٢٢٥a = kVar;
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void i(k kVar) {
            this.f٤٢٢٥a.g0();
            kVar.c0(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends w {
        b() {
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void k(k kVar) {
            a0.this.P.remove(kVar);
            if (!a0.this.N()) {
                a0.this.Y(k.j.f٤٣٤٥c, false);
                a0 a0Var = a0.this;
                a0Var.f٤٢٩٧B = true;
                a0Var.Y(k.j.f٤٣٤٤b, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends w {

        /* renamed from: a, reason: collision with root package name */
        a0 f٤٢٢٨a;

        c(a0 a0Var) {
            this.f٤٢٢٨a = a0Var;
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void d(k kVar) {
            a0 a0Var = this.f٤٢٢٨a;
            if (!a0Var.S) {
                a0Var.o0();
                this.f٤٢٢٨a.S = true;
            }
        }

        @Override // androidx.transition.w, androidx.transition.k.i
        public void i(k kVar) {
            a0 a0Var = this.f٤٢٢٨a;
            int i10 = a0Var.R - 1;
            a0Var.R = i10;
            if (i10 == 0) {
                a0Var.S = false;
                a0Var.r();
            }
            kVar.c0(this);
        }
    }

    private void D0() {
        c cVar = new c(this);
        Iterator it = this.P.iterator();
        while (it.hasNext()) {
            ((k) it.next()).c(cVar);
        }
        this.R = this.P.size();
    }

    private void t0(k kVar) {
        this.P.add(kVar);
        kVar.f٤٣١٥r = this;
    }

    private int w0(long j10) {
        for (int i10 = 1; i10 < this.P.size(); i10++) {
            if (((k) this.P.get(i10)).K > j10) {
                return i10 - 1;
            }
        }
        return this.P.size() - 1;
    }

    @Override // androidx.transition.k
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public a0 k0(TimeInterpolator timeInterpolator) {
        this.T |= 1;
        ArrayList arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((k) this.P.get(i10)).k0(timeInterpolator);
            }
        }
        return (a0) super.k0(timeInterpolator);
    }

    public a0 B0(int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.Q = false;
            } else {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
        } else {
            this.Q = true;
        }
        return this;
    }

    @Override // androidx.transition.k
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public a0 n0(long j10) {
        return (a0) super.n0(j10);
    }

    @Override // androidx.transition.k
    boolean N() {
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            if (((k) this.P.get(i10)).N()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.transition.k
    public boolean O() {
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!((k) this.P.get(i10)).O()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.transition.k
    public void Z(View view) {
        super.Z(view);
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).Z(view);
        }
    }

    @Override // androidx.transition.k
    void b0() {
        this.I = 0L;
        b bVar = new b();
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            k kVar = (k) this.P.get(i10);
            kVar.c(bVar);
            kVar.b0();
            long K = kVar.K();
            if (this.Q) {
                this.I = Math.max(this.I, K);
            } else {
                long j10 = this.I;
                kVar.K = j10;
                this.I = j10 + K;
            }
        }
    }

    @Override // androidx.transition.k
    protected void cancel() {
        super.cancel();
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).cancel();
        }
    }

    @Override // androidx.transition.k
    public void e0(View view) {
        super.e0(view);
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).e0(view);
        }
    }

    @Override // androidx.transition.k
    protected void g0() {
        if (this.P.isEmpty()) {
            o0();
            r();
            return;
        }
        D0();
        if (!this.Q) {
            for (int i10 = 1; i10 < this.P.size(); i10++) {
                ((k) this.P.get(i10 - 1)).c(new a((k) this.P.get(i10)));
            }
            k kVar = (k) this.P.get(0);
            if (kVar != null) {
                kVar.g0();
                return;
            }
            return;
        }
        Iterator it = this.P.iterator();
        while (it.hasNext()) {
            ((k) it.next()).g0();
        }
    }

    @Override // androidx.transition.k
    public void h(c0 c0Var) {
        if (Q(c0Var.f٤٢٥٩b)) {
            Iterator it = this.P.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar.Q(c0Var.f٤٢٥٩b)) {
                    kVar.h(c0Var);
                    c0Var.f٤٢٦٠c.add(kVar);
                }
            }
        }
    }

    @Override // androidx.transition.k
    void h0(long j10, long j11) {
        boolean z10;
        long K = K();
        long j12 = 0;
        if (this.f٤٣١٥r != null) {
            if (j10 >= 0 || j11 >= 0) {
                if (j10 > K && j11 > K) {
                    return;
                }
            } else {
                return;
            }
        }
        if (j10 < j11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((j10 >= 0 && j11 < 0) || (j10 <= K && j11 > K)) {
            this.f٤٢٩٧B = false;
            Y(k.j.f٤٣٤٣a, z10);
        }
        if (this.Q) {
            for (int i10 = 0; i10 < this.P.size(); i10++) {
                ((k) this.P.get(i10)).h0(j10, j11);
            }
        } else {
            int w02 = w0(j11);
            if (j10 >= j11) {
                while (w02 < this.P.size()) {
                    k kVar = (k) this.P.get(w02);
                    long j13 = kVar.K;
                    long j14 = j10 - j13;
                    if (j14 < j12) {
                        break;
                    }
                    kVar.h0(j14, j11 - j13);
                    w02++;
                    j12 = 0;
                }
            } else {
                while (w02 >= 0) {
                    k kVar2 = (k) this.P.get(w02);
                    long j15 = kVar2.K;
                    long j16 = j10 - j15;
                    kVar2.h0(j16, j11 - j15);
                    if (j16 >= 0) {
                        break;
                    } else {
                        w02--;
                    }
                }
            }
        }
        if (this.f٤٣١٥r != null) {
            if ((j10 > K && j11 <= K) || (j10 < 0 && j11 >= 0)) {
                if (j10 > K) {
                    this.f٤٢٩٧B = true;
                }
                Y(k.j.f٤٣٤٤b, z10);
            }
        }
    }

    @Override // androidx.transition.k
    void j(c0 c0Var) {
        super.j(c0Var);
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).j(c0Var);
        }
    }

    @Override // androidx.transition.k
    public void j0(k.f fVar) {
        super.j0(fVar);
        this.T |= 8;
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).j0(fVar);
        }
    }

    @Override // androidx.transition.k
    public void k(c0 c0Var) {
        if (Q(c0Var.f٤٢٥٩b)) {
            Iterator it = this.P.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar.Q(c0Var.f٤٢٥٩b)) {
                    kVar.k(c0Var);
                    c0Var.f٤٢٦٠c.add(kVar);
                }
            }
        }
    }

    @Override // androidx.transition.k
    public void l0(h hVar) {
        super.l0(hVar);
        this.T |= 4;
        if (this.P != null) {
            for (int i10 = 0; i10 < this.P.size(); i10++) {
                ((k) this.P.get(i10)).l0(hVar);
            }
        }
    }

    @Override // androidx.transition.k
    public void m0(y yVar) {
        super.m0(yVar);
        this.T |= 2;
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((k) this.P.get(i10)).m0(yVar);
        }
    }

    @Override // androidx.transition.k
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public k clone() {
        a0 a0Var = (a0) super.clone();
        a0Var.P = new ArrayList();
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            a0Var.t0(((k) this.P.get(i10)).clone());
        }
        return a0Var;
    }

    @Override // androidx.transition.k
    void p(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList arrayList, ArrayList arrayList2) {
        long F = F();
        int size = this.P.size();
        for (int i10 = 0; i10 < size; i10++) {
            k kVar = (k) this.P.get(i10);
            if (F > 0 && (this.Q || i10 == 0)) {
                long F2 = kVar.F();
                if (F2 > 0) {
                    kVar.n0(F2 + F);
                } else {
                    kVar.n0(F);
                }
            }
            kVar.p(viewGroup, d0Var, d0Var2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.k
    String p0(String str) {
        String p02 = super.p0(str);
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append(p02);
            sb.append("\n");
            sb.append(((k) this.P.get(i10)).p0(str + "  "));
            p02 = sb.toString();
        }
        return p02;
    }

    @Override // androidx.transition.k
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public a0 c(k.i iVar) {
        return (a0) super.c(iVar);
    }

    @Override // androidx.transition.k
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public a0 d(View view) {
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            ((k) this.P.get(i10)).d(view);
        }
        return (a0) super.d(view);
    }

    @Override // androidx.transition.k
    public k s(View view, boolean z10) {
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            ((k) this.P.get(i10)).s(view, z10);
        }
        return super.s(view, z10);
    }

    public a0 s0(k kVar) {
        t0(kVar);
        long j10 = this.f٤٣٠٠c;
        if (j10 >= 0) {
            kVar.i0(j10);
        }
        if ((this.T & 1) != 0) {
            kVar.k0(y());
        }
        if ((this.T & 2) != 0) {
            C();
            kVar.m0(null);
        }
        if ((this.T & 4) != 0) {
            kVar.l0(B());
        }
        if ((this.T & 8) != 0) {
            kVar.j0(x());
        }
        return this;
    }

    @Override // androidx.transition.k
    public k t(Class cls, boolean z10) {
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            ((k) this.P.get(i10)).t(cls, z10);
        }
        return super.t(cls, z10);
    }

    public k u0(int i10) {
        if (i10 >= 0 && i10 < this.P.size()) {
            return (k) this.P.get(i10);
        }
        return null;
    }

    public int v0() {
        return this.P.size();
    }

    @Override // androidx.transition.k
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a0 c0(k.i iVar) {
        return (a0) super.c0(iVar);
    }

    @Override // androidx.transition.k
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public a0 d0(View view) {
        for (int i10 = 0; i10 < this.P.size(); i10++) {
            ((k) this.P.get(i10)).d0(view);
        }
        return (a0) super.d0(view);
    }

    @Override // androidx.transition.k
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public a0 i0(long j10) {
        ArrayList arrayList;
        super.i0(j10);
        if (this.f٤٣٠٠c >= 0 && (arrayList = this.P) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((k) this.P.get(i10)).i0(j10);
            }
        }
        return this;
    }
}
