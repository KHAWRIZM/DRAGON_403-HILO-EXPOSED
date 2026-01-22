package e0;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q extends ThreadPoolExecutor {
    public q() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new t0());
    }

    public final void b(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            int type = networkInfo.getType();
            if (type != 0) {
                if (type != 1 && type != 6 && type != 9) {
                    setCorePoolSize(3);
                    setMaximumPoolSize(3);
                    return;
                } else {
                    setCorePoolSize(4);
                    setMaximumPoolSize(4);
                    return;
                }
            }
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    setCorePoolSize(1);
                    setMaximumPoolSize(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            setCorePoolSize(3);
                            setMaximumPoolSize(3);
                            return;
                        default:
                            setCorePoolSize(3);
                            setMaximumPoolSize(3);
                            return;
                    }
            }
            setCorePoolSize(2);
            setMaximumPoolSize(2);
            return;
        }
        setCorePoolSize(3);
        setMaximumPoolSize(3);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        o oVar = new o((d) runnable);
        execute(oVar);
        return oVar;
    }
}
