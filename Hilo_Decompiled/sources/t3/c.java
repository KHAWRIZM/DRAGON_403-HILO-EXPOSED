package t3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import o3.q;
import t3.e;
import x3.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends b {
    private o3.a D;
    private final List E;
    private final RectF F;
    private final RectF G;
    private final Paint H;
    private float I;
    private boolean J;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٩٧٨a;

        static {
            int[] iArr = new int[e.b.values().length];
            f١٧٩٧٨a = iArr;
            try {
                iArr[e.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٩٧٨a[e.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(j0 j0Var, e eVar, List list, j jVar) {
        super(j0Var, eVar);
        int i10;
        b bVar;
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.J = true;
        r3.b v10 = eVar.v();
        if (v10 != null) {
            o3.a a10 = v10.a();
            this.D = a10;
            i(a10);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(jVar.k().size());
        int size = list.size() - 1;
        b bVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            e eVar2 = (e) list.get(size);
            b u10 = b.u(this, eVar2, j0Var, jVar);
            if (u10 != null) {
                longSparseArray.put(u10.z().e(), u10);
                if (bVar2 != null) {
                    bVar2.J(u10);
                    bVar2 = null;
                } else {
                    this.E.add(0, u10);
                    int i11 = a.f١٧٩٧٨a[eVar2.i().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        bVar2 = u10;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < longSparseArray.size(); i10++) {
            b bVar3 = (b) longSparseArray.get(longSparseArray.keyAt(i10));
            if (bVar3 != null && (bVar = (b) longSparseArray.get(bVar3.z().k())) != null) {
                bVar3.L(bVar);
            }
        }
    }

    @Override // t3.b
    protected void I(q3.e eVar, int i10, List list, q3.e eVar2) {
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            ((b) this.E.get(i11)).d(eVar, i10, list, eVar2);
        }
    }

    @Override // t3.b
    public void K(boolean z10) {
        super.K(z10);
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            ((b) it.next()).K(z10);
        }
    }

    @Override // t3.b
    public void M(float f10) {
        com.airbnb.lottie.e.b("CompositionLayer#setProgress");
        this.I = f10;
        super.M(f10);
        if (this.D != null) {
            f10 = ((((Float) this.D.h()).floatValue() * this.f١٧٩٦٦q.c().i()) - this.f١٧٩٦٦q.c().p()) / (this.f١٧٩٦٥p.J().e() + 0.01f);
        }
        if (this.D == null) {
            f10 -= this.f١٧٩٦٦q.s();
        }
        if (this.f١٧٩٦٦q.w() != DownloadProgress.UNKNOWN_PROGRESS && !"__container".equals(this.f١٧٩٦٦q.j())) {
            f10 /= this.f١٧٩٦٦q.w();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            ((b) this.E.get(size)).M(f10);
        }
        com.airbnb.lottie.e.c("CompositionLayer#setProgress");
    }

    public float P() {
        return this.I;
    }

    public void Q(boolean z10) {
        this.J = z10;
    }

    @Override // t3.b, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.E) {
            if (cVar == null) {
                o3.a aVar = this.D;
                if (aVar != null) {
                    aVar.o(null);
                    return;
                }
                return;
            }
            q qVar = new q(cVar);
            this.D = qVar;
            qVar.a(this);
            i(this.D);
        }
    }

    @Override // t3.b, n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            ((b) this.E.get(size)).f(this.F, this.f١٧٩٦٤o, true);
            rectF.union(this.F);
        }
    }

    @Override // t3.b
    void t(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        boolean clipRect;
        com.airbnb.lottie.e.b("CompositionLayer#draw");
        this.G.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f١٧٩٦٦q.m(), this.f١٧٩٦٦q.l());
        matrix.mapRect(this.G);
        if (this.f١٧٩٦٥p.f0() && this.E.size() > 1 && i10 != 255) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.H.setAlpha(i10);
            l.m(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if ((this.J || !"__container".equals(this.f١٧٩٦٦q.j())) && !this.G.isEmpty()) {
                clipRect = canvas.clipRect(this.G);
            } else {
                clipRect = true;
            }
            if (clipRect) {
                ((b) this.E.get(size)).h(canvas, matrix, i10);
            }
        }
        canvas.restore();
        com.airbnb.lottie.e.c("CompositionLayer#draw");
    }
}
