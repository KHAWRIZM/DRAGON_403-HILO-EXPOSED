package le;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class c extends z implements g0 {
    public final c d() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
