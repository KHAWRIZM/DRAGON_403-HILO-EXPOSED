package u4;

import com.bumptech.glide.load.data.j;
import m4.h;
import m4.i;
import t4.m;
import t4.n;
import t4.o;
import t4.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements n {

    /* renamed from: b, reason: collision with root package name */
    public static final h f١٨٢٣٨b = h.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    private final m f١٨٢٣٩a;

    /* renamed from: u4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠٢٣٤a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final m f١٨٢٤٠a = new m(500);

        @Override // t4.o
        public n build(r rVar) {
            return new a(this.f١٨٢٤٠a);
        }
    }

    public a(m mVar) {
        this.f١٨٢٣٩a = mVar;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(t4.h hVar, int i10, int i11, i iVar) {
        m mVar = this.f١٨٢٣٩a;
        if (mVar != null) {
            t4.h hVar2 = (t4.h) mVar.a(hVar, 0, 0);
            if (hVar2 == null) {
                this.f١٨٢٣٩a.b(hVar, 0, 0, hVar);
            } else {
                hVar = hVar2;
            }
        }
        return new n.a(hVar, new j(hVar, ((Integer) iVar.a(f١٨٢٣٨b)).intValue()));
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(t4.h hVar) {
        return true;
    }
}
