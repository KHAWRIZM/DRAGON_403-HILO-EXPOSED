package v4;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f0 implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.drawable.k f١٨٤٩٥a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.d f١٨٤٩٦b;

    public f0(com.bumptech.glide.load.resource.drawable.k kVar, p4.d dVar) {
        this.f١٨٤٩٥a = kVar;
        this.f١٨٤٩٦b = dVar;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o4.v decode(Uri uri, int i10, int i11, m4.i iVar) {
        o4.v decode = this.f١٨٤٩٥a.decode(uri, i10, i11, iVar);
        if (decode == null) {
            return null;
        }
        return v.a(this.f١٨٤٩٦b, (Drawable) decode.get(), i10, i11);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri, m4.i iVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
