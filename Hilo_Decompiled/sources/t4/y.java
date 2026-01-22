package t4;

import android.net.Uri;
import anet.channel.util.HttpConstant;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class y implements n {

    /* renamed from: b, reason: collision with root package name */
    private static final Set f١٨١٢٨b = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpConstant.HTTP, HttpConstant.HTTPS)));

    /* renamed from: a, reason: collision with root package name */
    private final n f١٨١٢٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a implements o {
        @Override // t4.o
        public n build(r rVar) {
            return new y(rVar.d(h.class, InputStream.class));
        }
    }

    public y(n nVar) {
        this.f١٨١٢٩a = nVar;
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Uri uri, int i10, int i11, m4.i iVar) {
        return this.f١٨١٢٩a.buildLoadData(new h(uri.toString()), i10, i11, iVar);
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return f١٨١٢٨b.contains(uri.getScheme());
    }
}
