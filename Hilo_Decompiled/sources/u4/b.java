package u4;

import android.content.Context;
import android.net.Uri;
import m4.i;
import t4.n;
import t4.o;
import t4.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨٢٤١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٢٤٢a;

        public a(Context context) {
            this.f١٨٢٤٢a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new b(this.f١٨٢٤٢a);
        }
    }

    public b(Context context) {
        this.f١٨٢٤١a = context.getApplicationContext();
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, i iVar) {
        if (n4.b.e(i10, i11)) {
            return new n.a(new e5.d(uri), n4.c.b(this.f١٨٢٤١a, uri));
        }
        return null;
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return n4.b.b(uri);
    }
}
