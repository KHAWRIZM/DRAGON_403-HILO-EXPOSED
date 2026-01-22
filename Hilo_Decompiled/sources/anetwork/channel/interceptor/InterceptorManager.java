package anetwork.channel.interceptor;

import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class InterceptorManager {

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Interceptor> f٥٢٣٥a = new CopyOnWriteArrayList<>();

    private InterceptorManager() {
    }

    public static void addInterceptor(Interceptor interceptor) {
        CopyOnWriteArrayList<Interceptor> copyOnWriteArrayList = f٥٢٣٥a;
        if (!copyOnWriteArrayList.contains(interceptor)) {
            copyOnWriteArrayList.add(interceptor);
            ALog.i("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", copyOnWriteArrayList.toString());
        }
    }

    public static boolean contains(Interceptor interceptor) {
        return f٥٢٣٥a.contains(interceptor);
    }

    public static Interceptor getInterceptor(int i10) {
        return f٥٢٣٥a.get(i10);
    }

    public static int getSize() {
        return f٥٢٣٥a.size();
    }

    public static void removeInterceptor(Interceptor interceptor) {
        CopyOnWriteArrayList<Interceptor> copyOnWriteArrayList = f٥٢٣٥a;
        copyOnWriteArrayList.remove(interceptor);
        ALog.i("anet.InterceptorManager", "[remoteInterceptor]", null, "interceptors", copyOnWriteArrayList.toString());
    }
}
