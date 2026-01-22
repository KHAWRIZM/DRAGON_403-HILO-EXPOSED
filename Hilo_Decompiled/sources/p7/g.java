package p7;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f١٦٩٥٦a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f١٦٩٥٧b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f١٦٩٥٨c = new Matrix();

    public Matrix a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f١٦٩٥٦a);
        matrix2.getValues(this.f١٦٩٥٧b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f١٦٩٥٧b;
            float f11 = fArr[i10];
            float f12 = this.f١٦٩٥٦a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f١٦٩٥٨c.setValues(this.f١٦٩٥٧b);
        return this.f١٦٩٥٨c;
    }
}
