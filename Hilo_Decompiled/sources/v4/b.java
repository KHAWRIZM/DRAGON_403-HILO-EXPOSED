package v4;

import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements m4.l {

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f١٨٤٧٧a;

    /* renamed from: b, reason: collision with root package name */
    private final m4.l f١٨٤٧٨b;

    public b(p4.d dVar, m4.l lVar) {
        this.f١٨٤٧٧a = dVar;
        this.f١٨٤٧٨b = lVar;
    }

    @Override // m4.l
    public m4.c a(m4.i iVar) {
        return this.f١٨٤٧٨b.a(iVar);
    }

    @Override // m4.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean encode(o4.v vVar, File file, m4.i iVar) {
        return this.f١٨٤٧٨b.encode(new f(((BitmapDrawable) vVar.get()).getBitmap(), this.f١٨٤٧٧a), file, iVar);
    }
}
