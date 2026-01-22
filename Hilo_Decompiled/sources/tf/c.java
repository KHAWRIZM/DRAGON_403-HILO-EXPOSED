package tf;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
abstract class c {
    private final Queue a = b(20);

    public static Queue b(int i) {
        return new ArrayDeque(i);
    }

    abstract i a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c() {
        i iVar = (i) this.a.poll();
        if (iVar == null) {
            return a();
        }
        return iVar;
    }

    public void d(i iVar) {
        if (this.a.size() < 20) {
            this.a.offer(iVar);
        }
    }
}
