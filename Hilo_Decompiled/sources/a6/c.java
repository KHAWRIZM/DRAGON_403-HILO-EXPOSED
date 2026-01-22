package a6;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private b[] f٢٣٠a;

    public c(b... bVarArr) {
        this.f٢٣٠a = bVarArr;
    }

    @Override // a6.b
    public void println(int i10, String str, String str2) {
        for (b bVar : this.f٢٣٠a) {
            bVar.println(i10, str, str2);
        }
    }
}
