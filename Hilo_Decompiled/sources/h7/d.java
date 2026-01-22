package h7;

import i7.x;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f١٤٥٢٥a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f١٤٥٢٦b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f١٤٥٢٧c;

    /* renamed from: d, reason: collision with root package name */
    private final ne.a f١٤٥٢٨d;

    /* renamed from: e, reason: collision with root package name */
    private final ne.a f١٤٥٢٩e;

    public d(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        this.f١٤٥٢٥a = aVar;
        this.f١٤٥٢٦b = aVar2;
        this.f١٤٥٢٧c = aVar3;
        this.f١٤٥٢٨d = aVar4;
        this.f١٤٥٢٩e = aVar5;
    }

    public static d a(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, c7.e eVar, x xVar, j7.d dVar, k7.b bVar) {
        return new c(executor, eVar, xVar, dVar, bVar);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f١٤٥٢٥a.get(), (c7.e) this.f١٤٥٢٦b.get(), (x) this.f١٤٥٢٧c.get(), (j7.d) this.f١٤٥٢٨d.get(), (k7.b) this.f١٤٥٢٩e.get());
    }
}
