package u4;

import android.content.Context;
import android.net.Uri;
import m4.i;
import t4.n;
import t4.o;
import t4.r;
import v4.l0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨٢٤٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٢٤٤a;

        public a(Context context) {
            this.f١٨٢٤٤a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new c(this.f١٨٢٤٤a);
        }
    }

    public c(Context context) {
        this.f١٨٢٤٣a = context.getApplicationContext();
    }

    private boolean c(i iVar) {
        Long l10 = (Long) iVar.a(l0.f١٨٥١٨d);
        if (l10 != null && l10.longValue() == -1) {
            return true;
        }
        return false;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, i iVar) {
        if (n4.b.e(i10, i11) && c(iVar)) {
            return new n.a(new e5.d(uri), n4.c.c(this.f١٨٢٤٣a, uri));
        }
        return null;
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return n4.b.d(uri);
    }
}
