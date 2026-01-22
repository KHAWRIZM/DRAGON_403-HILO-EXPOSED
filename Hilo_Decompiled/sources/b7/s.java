package b7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class s implements z6.i {

    /* renamed from: a, reason: collision with root package name */
    private final p f٥٥٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٥٥٣١b;

    /* renamed from: c, reason: collision with root package name */
    private final z6.c f٥٥٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private final z6.h f٥٥٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private final t f٥٥٣٤e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, String str, z6.c cVar, z6.h hVar, t tVar) {
        this.f٥٥٣٠a = pVar;
        this.f٥٥٣١b = str;
        this.f٥٥٣٢c = cVar;
        this.f٥٥٣٣d = hVar;
        this.f٥٥٣٤e = tVar;
    }

    @Override // z6.i
    public void a(z6.d dVar, z6.k kVar) {
        this.f٥٥٣٤e.a(o.a().e(this.f٥٥٣٠a).c(dVar).f(this.f٥٥٣١b).d(this.f٥٥٣٣d).b(this.f٥٥٣٢c).a(), kVar);
    }

    @Override // z6.i
    public void b(z6.d dVar) {
        a(dVar, new z6.k() { // from class: b7.r
            @Override // z6.k
            public final void a(Exception exc) {
                s.e(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p d() {
        return this.f٥٥٣٠a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Exception exc) {
    }
}
