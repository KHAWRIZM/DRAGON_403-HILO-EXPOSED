package h7;

import android.content.Context;
import i7.x;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f١٤٥٣١a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f١٤٥٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f١٤٥٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private final ne.a f١٤٥٣٤d;

    public i(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        this.f١٤٥٣١a = aVar;
        this.f١٤٥٣٢b = aVar2;
        this.f١٤٥٣٣c = aVar3;
        this.f١٤٥٣٤d = aVar4;
    }

    public static i a(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, j7.d dVar, i7.f fVar, l7.a aVar) {
        return (x) d7.d.d(h.a(context, dVar, fVar, aVar));
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.f١٤٥٣١a.get(), (j7.d) this.f١٤٥٣٢b.get(), (i7.f) this.f١٤٥٣٣c.get(), (l7.a) this.f١٤٥٣٤d.get());
    }
}
