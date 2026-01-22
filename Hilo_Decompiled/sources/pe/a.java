package pe;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import f5.l;
import m4.m;
import o4.v;
import p4.d;
import v4.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a implements m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }

    protected abstract Bitmap b(Context context, d dVar, Bitmap bitmap, int i10, int i11);

    @Override // m4.m
    public final v transform(Context context, v vVar, int i10, int i11) {
        if (l.v(i10, i11)) {
            d bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = (Bitmap) vVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            int i12 = i10;
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap b10 = b(context.getApplicationContext(), bitmapPool, bitmap, i12, i11);
            if (!bitmap.equals(b10)) {
                return f.b(b10, bitmapPool);
            }
            return vVar;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
