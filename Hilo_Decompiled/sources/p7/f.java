package p7;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f extends Property {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f١٦٩٥٥a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f١٦٩٥٥a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f١٦٩٥٥a.set(imageView.getImageMatrix());
        return this.f١٦٩٥٥a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
