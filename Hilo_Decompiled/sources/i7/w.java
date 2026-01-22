package i7;

import java.util.concurrent.Executor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class w implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f١٤٦٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f١٤٦٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f١٤٦٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private final ne.a f١٤٦٨٥d;

    public w(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        this.f١٤٦٨٢a = aVar;
        this.f١٤٦٨٣b = aVar2;
        this.f١٤٦٨٤c = aVar3;
        this.f١٤٦٨٥d = aVar4;
    }

    public static w a(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, j7.d dVar, x xVar, k7.b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.f١٤٦٨٢a.get(), (j7.d) this.f١٤٦٨٣b.get(), (x) this.f١٤٦٨٤c.get(), (k7.b) this.f١٤٦٨٥d.get());
    }
}
