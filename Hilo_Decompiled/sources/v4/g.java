package v4;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g implements m4.m {
    protected abstract Bitmap transform(p4.d dVar, Bitmap bitmap, int i10, int i11);

    @Override // m4.m
    public final o4.v transform(Context context, o4.v vVar, int i10, int i11) {
        if (f5.l.v(i10, i11)) {
            p4.d bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = (Bitmap) vVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap transform = transform(bitmapPool, bitmap, i10, i11);
            return bitmap.equals(transform) ? vVar : f.b(transform, bitmapPool);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
