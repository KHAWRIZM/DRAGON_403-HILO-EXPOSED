package b7;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
