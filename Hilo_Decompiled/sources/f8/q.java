package f8;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public float f١٤٢٢١a;

    /* renamed from: b, reason: collision with root package name */
    public float f١٤٢٢٢b;

    /* renamed from: c, reason: collision with root package name */
    public float f١٤٢٢٣c;

    /* renamed from: d, reason: collision with root package name */
    public float f١٤٢٢٤d;

    /* renamed from: e, reason: collision with root package name */
    public float f١٤٢٢٥e;

    /* renamed from: f, reason: collision with root package name */
    public float f١٤٢٢٦f;

    /* renamed from: g, reason: collision with root package name */
    private final List f١٤٢٢٧g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f١٤٢٢٨h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٤٢٢٩i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends g {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f١٤٢٣٠c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f١٤٢٣١d;

        a(List list, Matrix matrix) {
            this.f١٤٢٣٠c = list;
            this.f١٤٢٣١d = matrix;
        }

        @Override // f8.q.g
        public void a(Matrix matrix, e8.a aVar, int i10, Canvas canvas) {
            Iterator it = this.f١٤٢٣٠c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f١٤٢٣١d, aVar, i10, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        private final d f١٤٢٣٣c;

        public b(d dVar) {
            this.f١٤٢٣٣c = dVar;
        }

        @Override // f8.q.g
        public void a(Matrix matrix, e8.a aVar, int i10, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f١٤٢٣٣c.k(), this.f١٤٢٣٣c.o(), this.f١٤٢٣٣c.l(), this.f١٤٢٣٣c.j()), i10, this.f١٤٢٣٣c.m(), this.f١٤٢٣٣c.n());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        private final e f١٤٢٣٤c;

        /* renamed from: d, reason: collision with root package name */
        private final float f١٤٢٣٥d;

        /* renamed from: e, reason: collision with root package name */
        private final float f١٤٢٣٦e;

        public c(e eVar, float f10, float f11) {
            this.f١٤٢٣٤c = eVar;
            this.f١٤٢٣٥d = f10;
            this.f١٤٢٣٦e = f11;
        }

        @Override // f8.q.g
        public void a(Matrix matrix, e8.a aVar, int i10, Canvas canvas) {
            RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (float) Math.hypot(this.f١٤٢٣٤c.f١٤٢٤٥c - this.f١٤٢٣٦e, this.f١٤٢٣٤c.f١٤٢٤٤b - this.f١٤٢٣٥d), DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤٢٤٨a.set(matrix);
            this.f١٤٢٤٨a.preTranslate(this.f١٤٢٣٥d, this.f١٤٢٣٦e);
            this.f١٤٢٤٨a.preRotate(c());
            aVar.b(canvas, this.f١٤٢٤٨a, rectF, i10);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f١٤٢٣٤c.f١٤٢٤٥c - this.f١٤٢٣٦e) / (this.f١٤٢٣٤c.f١٤٢٤٤b - this.f١٤٢٣٥d)));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f١٤٢٣٧h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public float f١٤٢٣٨b;

        /* renamed from: c, reason: collision with root package name */
        public float f١٤٢٣٩c;

        /* renamed from: d, reason: collision with root package name */
        public float f١٤٢٤٠d;

        /* renamed from: e, reason: collision with root package name */
        public float f١٤٢٤١e;

        /* renamed from: f, reason: collision with root package name */
        public float f١٤٢٤٢f;

        /* renamed from: g, reason: collision with root package name */
        public float f١٤٢٤٣g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f١٤٢٤١e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f١٤٢٣٨b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f١٤٢٤٠d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f١٤٢٤٢f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f١٤٢٤٣g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f١٤٢٣٩c;
        }

        private void p(float f10) {
            this.f١٤٢٤١e = f10;
        }

        private void q(float f10) {
            this.f١٤٢٣٨b = f10;
        }

        private void r(float f10) {
            this.f١٤٢٤٠d = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f10) {
            this.f١٤٢٤٢f = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f10) {
            this.f١٤٢٤٣g = f10;
        }

        private void u(float f10) {
            this.f١٤٢٣٩c = f10;
        }

        @Override // f8.q.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f١٤٢٤٦a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f١٤٢٣٧h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f١٤٢٤٤b;

        /* renamed from: c, reason: collision with root package name */
        private float f١٤٢٤٥c;

        @Override // f8.q.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f١٤٢٤٦a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f١٤٢٤٤b, this.f١٤٢٤٥c);
            path.transform(matrix);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f١٤٢٤٦a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        static final Matrix f١٤٢٤٧b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        final Matrix f١٤٢٤٨a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, e8.a aVar, int i10, Canvas canvas);

        public final void b(e8.a aVar, int i10, Canvas canvas) {
            a(f١٤٢٤٧b, aVar, i10, canvas);
        }
    }

    public q() {
        n(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
    }

    private void b(float f10) {
        if (g() == f10) {
            return;
        }
        float g10 = ((f10 - g()) + 360.0f) % 360.0f;
        if (g10 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g10);
        this.f١٤٢٢٨h.add(new b(dVar));
        p(f10);
    }

    private void c(g gVar, float f10, float f11) {
        b(f10);
        this.f١٤٢٢٨h.add(gVar);
        p(f11);
    }

    private float g() {
        return this.f١٤٢٢٥e;
    }

    private float h() {
        return this.f١٤٢٢٦f;
    }

    private void p(float f10) {
        this.f١٤٢٢٥e = f10;
    }

    private void q(float f10) {
        this.f١٤٢٢٦f = f10;
    }

    private void r(float f10) {
        this.f١٤٢٢٣c = f10;
    }

    private void s(float f10) {
        this.f١٤٢٢٤d = f10;
    }

    private void t(float f10) {
        this.f١٤٢٢١a = f10;
    }

    private void u(float f10) {
        this.f١٤٢٢٢b = f10;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        float f16;
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f١٤٢٢٧g.add(dVar);
        b bVar = new b(dVar);
        float f17 = f14 + f15;
        if (f15 < DownloadProgress.UNKNOWN_PROGRESS) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        if (z10) {
            f16 = (180.0f + f17) % 360.0f;
        } else {
            f16 = f17;
        }
        c(bVar, f14, f16);
        double d10 = f17;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f١٤٢٢٧g.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f١٤٢٢٧g.get(i10)).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f١٤٢٢٩i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f١٤٢٢٨h), new Matrix(matrix));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f١٤٢٢٣c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f١٤٢٢٤d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f١٤٢٢١a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f١٤٢٢٢b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f١٤٢٤٤b = f10;
        eVar.f١٤٢٤٥c = f11;
        this.f١٤٢٢٧g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, DownloadProgress.UNKNOWN_PROGRESS);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f١٤٢٢٧g.clear();
        this.f١٤٢٢٨h.clear();
        this.f١٤٢٢٩i = false;
    }
}
