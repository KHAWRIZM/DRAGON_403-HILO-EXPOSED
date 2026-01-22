package c7;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f٥٩٥٦a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f٥٩٥٧b;

    public l(ne.a aVar, ne.a aVar2) {
        this.f٥٩٥٦a = aVar;
        this.f٥٩٥٧b = aVar2;
    }

    public static l a(ne.a aVar, ne.a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f٥٩٥٦a.get(), this.f٥٩٥٧b.get());
    }
}
