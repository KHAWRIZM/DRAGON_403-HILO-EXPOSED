package y4;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import m4.i;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f١٩١٤٧a;

    /* renamed from: b, reason: collision with root package name */
    private final e f١٩١٤٨b;

    /* renamed from: c, reason: collision with root package name */
    private final e f١٩١٤٩c;

    public c(p4.d dVar, e eVar, e eVar2) {
        this.f١٩١٤٧a = dVar;
        this.f١٩١٤٨b = eVar;
        this.f١٩١٤٩c = eVar2;
    }

    @Override // y4.e
    public v transcode(v vVar, i iVar) {
        Drawable drawable = (Drawable) vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f١٩١٤٨b.transcode(v4.f.b(((BitmapDrawable) drawable).getBitmap(), this.f١٩١٤٧a), iVar);
        }
        if (drawable instanceof com.bumptech.glide.load.resource.gif.c) {
            return this.f١٩١٤٩c.transcode(a(vVar), iVar);
        }
        return null;
    }

    private static v a(v vVar) {
        return vVar;
    }
}
