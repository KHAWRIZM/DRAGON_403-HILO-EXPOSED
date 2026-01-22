package cf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class k {
    private j a;
    private j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(j jVar) {
        try {
            if (jVar != null) {
                j jVar2 = this.b;
                if (jVar2 != null) {
                    jVar2.c = jVar;
                    this.b = jVar;
                } else if (this.a == null) {
                    this.b = jVar;
                    this.a = jVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j b() {
        j jVar;
        jVar = this.a;
        if (jVar != null) {
            j jVar2 = jVar.c;
            this.a = jVar2;
            if (jVar2 == null) {
                this.b = null;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized j c(int i) {
        try {
            if (this.a == null) {
                wait(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
