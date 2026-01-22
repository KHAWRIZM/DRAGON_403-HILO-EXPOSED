package p4;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements d {
    @Override // p4.d
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // p4.d
    public long e() {
        return 0L;
    }

    @Override // p4.d
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // p4.d
    public Bitmap g(int i10, int i11, Bitmap.Config config) {
        return f(i10, i11, config);
    }

    @Override // p4.d
    public void b() {
    }

    @Override // p4.d
    public void a(int i10) {
    }

    @Override // p4.d
    public void c(float f10) {
    }
}
