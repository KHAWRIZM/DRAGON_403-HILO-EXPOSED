package cf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class q {
    final Object a;
    final o b;
    volatile boolean c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Object obj, o oVar) {
        this.a = obj;
        this.b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.a != qVar.a || !this.b.equals(qVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
