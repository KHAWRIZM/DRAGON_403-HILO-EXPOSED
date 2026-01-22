package fe;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class q {
    public static boolean a(boolean z10, boolean z11, g0 g0Var, boolean z12, sd.j jVar, nd.c cVar, n nVar) {
        if (nVar.h()) {
            jVar.clear();
            cVar.dispose();
            return true;
        }
        if (z10) {
            if (z12) {
                if (z11) {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    Throwable d10 = nVar.d();
                    if (d10 != null) {
                        g0Var.onError(d10);
                    } else {
                        g0Var.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable d11 = nVar.d();
            if (d11 != null) {
                jVar.clear();
                if (cVar != null) {
                    cVar.dispose();
                }
                g0Var.onError(d11);
                return true;
            }
            if (z11) {
                if (cVar != null) {
                    cVar.dispose();
                }
                g0Var.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }

    public static sd.j b(int i10) {
        if (i10 < 0) {
            return new be.c(-i10);
        }
        return new be.b(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.f(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L٢١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(sd.i iVar, g0 g0Var, boolean z10, nd.c cVar, n nVar) {
        boolean z11;
        int i10 = 1;
        while (!a(nVar.g(), iVar.isEmpty(), g0Var, z10, iVar, cVar, nVar)) {
            while (true) {
                boolean g10 = nVar.g();
                Object poll = iVar.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (a(g10, z11, g0Var, z10, iVar, cVar, nVar)) {
                    return;
                }
                if (z11) {
                    break;
                } else {
                    nVar.e(g0Var, poll);
                }
            }
        }
    }
}
