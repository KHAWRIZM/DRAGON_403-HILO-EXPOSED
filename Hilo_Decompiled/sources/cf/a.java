package cf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a implements Runnable, l {
    private final k a = new k();
    private final c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.b = cVar;
    }

    @Override // cf.l
    public void a(q qVar, Object obj) {
        this.a.a(j.a(qVar, obj));
        this.b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        j b = this.a.b();
        if (b != null) {
            this.b.g(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
