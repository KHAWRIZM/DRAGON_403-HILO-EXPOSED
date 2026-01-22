package b7;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class l {
    public static void a(z6.i iVar, z6.f fVar) {
        if (iVar instanceof s) {
            u.c().e().u(((s) iVar).d().f(fVar), 1);
        } else {
            f7.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", iVar);
        }
    }
}
