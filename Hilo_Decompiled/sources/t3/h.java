package t3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import o3.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends b {
    private final RectF D;
    private final Paint E;
    private final float[] F;
    private final Path G;
    private final e H;
    private o3.a I;
    private o3.a J;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j0 j0Var, e eVar) {
        super(j0Var, eVar);
        this.D = new RectF();
        m3.a aVar = new m3.a();
        this.E = aVar;
        this.F = new float[8];
        this.G = new Path();
        this.H = eVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(eVar.p());
    }

    @Override // t3.b, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.K) {
            if (cVar == null) {
                this.I = null;
                return;
            } else {
                this.I = new q(cVar);
                return;
            }
        }
        if (obj == n0.f٦٢٤٥a) {
            if (cVar == null) {
                this.J = null;
                this.E.setColor(this.H.p());
            } else {
                this.J = new q(cVar);
            }
        }
    }

    @Override // t3.b, n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        this.D.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.H.r(), this.H.q());
        this.f١٧٩٦٤o.mapRect(this.D);
        rectF.set(this.D);
    }

    @Override // t3.b
    public void t(Canvas canvas, Matrix matrix, int i10) {
        Integer num;
        int intValue;
        int alpha = Color.alpha(this.H.p());
        if (alpha == 0) {
            return;
        }
        o3.a aVar = this.J;
        if (aVar == null) {
            num = null;
        } else {
            num = (Integer) aVar.h();
        }
        if (num != null) {
            this.E.setColor(num.intValue());
        } else {
            this.E.setColor(this.H.p());
        }
        if (this.f١٧٩٧٣x.h() == null) {
            intValue = 100;
        } else {
            intValue = ((Integer) this.f١٧٩٧٣x.h().h()).intValue();
        }
        int i11 = (int) ((i10 / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
        this.E.setAlpha(i11);
        o3.a aVar2 = this.I;
        if (aVar2 != null) {
            this.E.setColorFilter((ColorFilter) aVar2.h());
        }
        if (i11 > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.H.r();
            float[] fArr2 = this.F;
            fArr2[3] = 0.0f;
            fArr2[4] = this.H.r();
            this.F[5] = this.H.q();
            float[] fArr3 = this.F;
            fArr3[6] = 0.0f;
            fArr3[7] = this.H.q();
            matrix.mapPoints(this.F);
            this.G.reset();
            Path path = this.G;
            float[] fArr4 = this.F;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.G;
            float[] fArr5 = this.F;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.G;
            float[] fArr6 = this.F;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.G;
            float[] fArr7 = this.F;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.G;
            float[] fArr8 = this.F;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.G.close();
            canvas.drawPath(this.G, this.E);
        }
    }
}
