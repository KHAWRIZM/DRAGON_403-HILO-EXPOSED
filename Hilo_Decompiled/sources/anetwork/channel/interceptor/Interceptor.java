package anetwork.channel.interceptor;

import anet.channel.request.Request;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Interceptor {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface Chain {
        Callback callback();

        Future proceed(Request request, Callback callback);

        Request request();
    }

    Future intercept(Chain chain);
}
