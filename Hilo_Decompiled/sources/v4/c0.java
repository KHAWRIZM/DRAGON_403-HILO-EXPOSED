package v4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c0 implements o4.v, o4.r {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f١٨٤٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private final o4.v f١٨٤٨٤b;

    private c0(Resources resources, o4.v vVar) {
        this.f١٨٤٨٣a = (Resources) f5.k.d(resources);
        this.f١٨٤٨٤b = (o4.v) f5.k.d(vVar);
    }

    public static o4.v b(Resources resources, o4.v vVar) {
        if (vVar == null) {
            return null;
        }
        return new c0(resources, vVar);
    }

    @Override // o4.v
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f١٨٤٨٣a, (Bitmap) this.f١٨٤٨٤b.get());
    }

    @Override // o4.v
    public Class getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // o4.v
    public int getSize() {
        return this.f١٨٤٨٤b.getSize();
    }

    @Override // o4.r
    public void initialize() {
        o4.v vVar = this.f١٨٤٨٤b;
        if (vVar instanceof o4.r) {
            ((o4.r) vVar).initialize();
        }
    }

    @Override // o4.v
    public void recycle() {
        this.f١٨٤٨٤b.recycle();
    }
}
