package je;

import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a extends h implements kf.b, kf.a, i {
    public final a s() {
        if (this instanceof c) {
            return this;
        }
        return new c(this);
    }
}
