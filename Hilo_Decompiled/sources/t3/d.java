package t3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.k0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import o3.q;
import x3.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends b {
    private final Paint D;
    private final Rect E;
    private final Rect F;
    private final k0 G;
    private o3.a H;
    private o3.a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(j0 j0Var, e eVar) {
        super(j0Var, eVar);
        this.D = new m3.a(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = j0Var.P(eVar.n());
    }

    private Bitmap P() {
        Bitmap bitmap;
        o3.a aVar = this.I;
        if (aVar != null && (bitmap = (Bitmap) aVar.h()) != null) {
            return bitmap;
        }
        Bitmap G = this.f١٧٩٦٥p.G(this.f١٧٩٦٦q.n());
        if (G != null) {
            return G;
        }
        k0 k0Var = this.G;
        if (k0Var != null) {
            return k0Var.b();
        }
        return null;
    }

    @Override // t3.b, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.K) {
            if (cVar == null) {
                this.H = null;
                return;
            } else {
                this.H = new q(cVar);
                return;
            }
        }
        if (obj == n0.N) {
            if (cVar == null) {
                this.I = null;
            } else {
                this.I = new q(cVar);
            }
        }
    }

    @Override // t3.b, n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        if (this.G != null) {
            float e10 = l.e();
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.G.f() * e10, this.G.d() * e10);
            this.f١٧٩٦٤o.mapRect(rectF);
        }
    }

    @Override // t3.b
    public void t(Canvas canvas, Matrix matrix, int i10) {
        Bitmap P = P();
        if (P != null && !P.isRecycled() && this.G != null) {
            float e10 = l.e();
            this.D.setAlpha(i10);
            o3.a aVar = this.H;
            if (aVar != null) {
                this.D.setColorFilter((ColorFilter) aVar.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.E.set(0, 0, P.getWidth(), P.getHeight());
            if (this.f١٧٩٦٥p.Q()) {
                this.F.set(0, 0, (int) (this.G.f() * e10), (int) (this.G.d() * e10));
            } else {
                this.F.set(0, 0, (int) (P.getWidth() * e10), (int) (P.getHeight() * e10));
            }
            canvas.drawBitmap(P, this.E, this.F, this.D);
            canvas.restore();
        }
    }
}
