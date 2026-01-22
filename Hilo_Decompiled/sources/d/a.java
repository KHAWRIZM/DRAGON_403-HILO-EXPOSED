package d;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {
    public static int a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return -10402;
        }
        if (!(th instanceof InterruptedIOException) && !(th instanceof SocketException)) {
            if (th instanceof SSLHandshakeException) {
                return -10404;
            }
            if (th instanceof UnknownHostException) {
                return -10405;
            }
            if ((th instanceof ConnectException) || (th instanceof SSLException)) {
                return -10406;
            }
            return -1;
        }
        return -10403;
    }

    public static String b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", -1);
            jSONObject.put("retMsg", str);
            return jSONObject.toString();
        } catch (Exception e10) {
            return e10.toString();
        }
    }
}
