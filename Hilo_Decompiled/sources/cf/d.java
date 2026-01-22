package cf;

import cf.g;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d {
    private static final ExecutorService m = Executors.newCachedThreadPool();
    boolean e;
    boolean g;
    boolean h;
    List j;
    g k;
    h l;
    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    boolean f = true;
    ExecutorService i = m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a() {
        g gVar = this.k;
        if (gVar != null) {
            return gVar;
        }
        return g.a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b() {
        h hVar = this.l;
        if (hVar != null) {
            return hVar;
        }
        if (df.a.a()) {
            return df.a.b().b;
        }
        return null;
    }
}
