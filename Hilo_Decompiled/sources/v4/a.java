package v4;

import android.content.res.Resources;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final m4.k f١٨٤٦٦a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f١٨٤٦٧b;

    public a(Resources resources, m4.k kVar) {
        this.f١٨٤٦٧b = (Resources) f5.k.d(resources);
        this.f١٨٤٦٦a = (m4.k) f5.k.d(kVar);
    }

    @Override // m4.k
    public o4.v decode(Object obj, int i10, int i11, m4.i iVar) {
        return c0.b(this.f١٨٤٦٧b, this.f١٨٤٦٦a.decode(obj, i10, i11, iVar));
    }

    @Override // m4.k
    public boolean handles(Object obj, m4.i iVar) {
        return this.f١٨٤٦٦a.handles(obj, iVar);
    }
}
