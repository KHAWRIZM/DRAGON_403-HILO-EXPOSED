package v4;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f implements o4.v, o4.r {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f١٨٤٩٣a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.d f١٨٤٩٤b;

    public f(Bitmap bitmap, p4.d dVar) {
        this.f١٨٤٩٣a = (Bitmap) f5.k.e(bitmap, "Bitmap must not be null");
        this.f١٨٤٩٤b = (p4.d) f5.k.e(dVar, "BitmapPool must not be null");
    }

    public static f b(Bitmap bitmap, p4.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new f(bitmap, dVar);
    }

    @Override // o4.v
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f١٨٤٩٣a;
    }

    @Override // o4.v
    public Class getResourceClass() {
        return Bitmap.class;
    }

    @Override // o4.v
    public int getSize() {
        return f5.l.i(this.f١٨٤٩٣a);
    }

    @Override // o4.r
    public void initialize() {
        this.f١٨٤٩٣a.prepareToDraw();
    }

    @Override // o4.v
    public void recycle() {
        this.f١٨٤٩٤b.d(this.f١٨٤٩٣a);
    }
}
