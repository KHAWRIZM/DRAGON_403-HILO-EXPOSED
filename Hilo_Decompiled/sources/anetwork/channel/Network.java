package anetwork.channel;

import android.os.Handler;
import anetwork.channel.aidl.Connection;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Network {
    Future<Response> asyncSend(Request request, Object obj, Handler handler, NetworkListener networkListener);

    Connection getConnection(Request request, Object obj);

    Response syncSend(Request request, Object obj);
}
