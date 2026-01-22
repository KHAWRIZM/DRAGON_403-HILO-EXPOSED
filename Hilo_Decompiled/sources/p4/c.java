package p4;

import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private final Queue f١٦٨٥٥a = f5.l.g(20);

    abstract l a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l b() {
        l lVar = (l) this.f١٦٨٥٥a.poll();
        if (lVar == null) {
            return a();
        }
        return lVar;
    }

    public void c(l lVar) {
        if (this.f١٦٨٥٥a.size() < 20) {
            this.f١٦٨٥٥a.offer(lVar);
        }
    }
}
