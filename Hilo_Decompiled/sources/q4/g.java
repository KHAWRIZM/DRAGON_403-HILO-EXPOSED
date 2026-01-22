package q4;

import o4.v;
import q4.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g extends f5.h implements h {

    /* renamed from: e, reason: collision with root package name */
    private h.a f١٧١٣٩e;

    public g(long j10) {
        super(j10);
    }

    @Override // q4.h
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            o(e() / 2);
        }
    }

    @Override // q4.h
    public /* bridge */ /* synthetic */ v f(m4.f fVar, v vVar) {
        return (v) super.m(fVar, vVar);
    }

    @Override // q4.h
    public /* bridge */ /* synthetic */ v g(m4.f fVar) {
        return (v) super.n(fVar);
    }

    @Override // q4.h
    public void h(h.a aVar) {
        this.f١٧١٣٩e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f5.h
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int k(v vVar) {
        if (vVar == null) {
            return super.k(null);
        }
        return vVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f5.h
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(m4.f fVar, v vVar) {
        h.a aVar = this.f١٧١٣٩e;
        if (aVar != null && vVar != null) {
            aVar.b(vVar);
        }
    }
}
