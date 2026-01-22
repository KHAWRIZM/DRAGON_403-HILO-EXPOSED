package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o0 extends a {

    /* renamed from: b, reason: collision with root package name */
    private final pd.g f٢٠٢٤٠b;

    /* renamed from: c, reason: collision with root package name */
    private final pd.a f٢٠٢٤١c;

    public o0(io.reactivex.rxjava3.core.z zVar, pd.g gVar, pd.a aVar) {
        super(zVar);
        this.f٢٠٢٤٠b = gVar;
        this.f٢٠٢٤١c = aVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new ud.k(g0Var, this.f٢٠٢٤٠b, this.f٢٠٢٤١c));
    }
}
