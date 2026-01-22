package c7;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f٥٩٤٨a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f٥٩٤٩b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f٥٩٥٠c;

    public j(ne.a aVar, ne.a aVar2, ne.a aVar3) {
        this.f٥٩٤٨a = aVar;
        this.f٥٩٤٩b = aVar2;
        this.f٥٩٥٠c = aVar3;
    }

    public static j a(ne.a aVar, ne.a aVar2, ne.a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, l7.a aVar, l7.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f٥٩٤٨a.get(), (l7.a) this.f٥٩٤٩b.get(), (l7.a) this.f٥٩٥٠c.get());
    }
}
