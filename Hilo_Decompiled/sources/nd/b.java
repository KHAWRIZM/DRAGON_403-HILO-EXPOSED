package nd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract /* synthetic */ class b {
    public static c a() {
        return qd.d.INSTANCE;
    }

    public static c b(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new f(runnable);
    }
}
