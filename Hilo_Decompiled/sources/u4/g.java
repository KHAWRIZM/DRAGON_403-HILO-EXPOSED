package u4;

import java.io.InputStream;
import java.net.URL;
import m4.i;
import t4.h;
import t4.n;
import t4.o;
import t4.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements n {

    /* renamed from: a, reason: collision with root package name */
    private final n f١٨٢٦٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {
        @Override // t4.o
        public n build(r rVar) {
            return new g(rVar.d(h.class, InputStream.class));
        }
    }

    public g(n nVar) {
        this.f١٨٢٦٢a = nVar;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(URL url, int i10, int i11, i iVar) {
        return this.f١٨٢٦٢a.buildLoadData(new h(url), i10, i11, iVar);
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(URL url) {
        return true;
    }
}
