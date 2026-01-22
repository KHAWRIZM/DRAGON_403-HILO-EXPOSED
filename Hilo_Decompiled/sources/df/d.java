package df;

import android.os.Looper;
import cf.f;
import cf.h;
import cf.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d implements h {
    @Override // cf.h
    public boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    @Override // cf.h
    public l b(cf.c cVar) {
        return new f(cVar, Looper.getMainLooper(), 10);
    }
}
