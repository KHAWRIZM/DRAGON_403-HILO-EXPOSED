package j7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class n0 implements d7.b {

    /* renamed from: a, reason: collision with root package name */
    private final ne.a f١٥٣٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private final ne.a f١٥٣٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private final ne.a f١٥٣٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private final ne.a f١٥٣٠٩d;

    /* renamed from: e, reason: collision with root package name */
    private final ne.a f١٥٣١٠e;

    public n0(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        this.f١٥٣٠٦a = aVar;
        this.f١٥٣٠٧b = aVar2;
        this.f١٥٣٠٨c = aVar3;
        this.f١٥٣٠٩d = aVar4;
        this.f١٥٣١٠e = aVar5;
    }

    public static n0 a(ne.a aVar, ne.a aVar2, ne.a aVar3, ne.a aVar4, ne.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(l7.a aVar, l7.a aVar2, Object obj, Object obj2, ne.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (v0) obj2, aVar3);
    }

    @Override // ne.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((l7.a) this.f١٥٣٠٦a.get(), (l7.a) this.f١٥٣٠٧b.get(), this.f١٥٣٠٨c.get(), this.f١٥٣٠٩d.get(), this.f١٥٣١٠e);
    }
}
