package t3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.j;
import com.airbnb.lottie.j0;
import java.util.Collections;
import java.util.List;
import s3.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g extends b {
    private final n3.d D;
    private final c E;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j0 j0Var, e eVar, c cVar, j jVar) {
        super(j0Var, eVar);
        this.E = cVar;
        n3.d dVar = new n3.d(j0Var, this, new q("__container", eVar.o(), false), jVar);
        this.D = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // t3.b
    protected void I(q3.e eVar, int i10, List list, q3.e eVar2) {
        this.D.d(eVar, i10, list, eVar2);
    }

    @Override // t3.b, n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        this.D.f(rectF, this.f١٧٩٦٤o, z10);
    }

    @Override // t3.b
    void t(Canvas canvas, Matrix matrix, int i10) {
        this.D.h(canvas, matrix, i10);
    }

    @Override // t3.b
    public s3.a w() {
        s3.a w10 = super.w();
        if (w10 != null) {
            return w10;
        }
        return this.E.w();
    }

    @Override // t3.b
    public v3.j y() {
        v3.j y10 = super.y();
        if (y10 != null) {
            return y10;
        }
        return this.E.y();
    }
}
