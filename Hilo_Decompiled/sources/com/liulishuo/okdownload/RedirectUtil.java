package com.liulishuo.okdownload;

import com.liulishuo.okdownload.core.connection.DownloadConnection;
import java.net.ProtocolException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RedirectUtil {
    static final int HTTP_PERMANENT_REDIRECT = 308;
    static final int HTTP_TEMPORARY_REDIRECT = 307;
    public static final int MAX_REDIRECT_TIMES = 10;

    public static String getRedirectedUrl(DownloadConnection.Connected connected, int i10) {
        String responseHeaderField = connected.getResponseHeaderField("Location");
        if (responseHeaderField != null) {
            return responseHeaderField;
        }
        throw new ProtocolException("Response code is " + i10 + " but can't find Location field");
    }

    public static boolean isRedirect(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == HTTP_TEMPORARY_REDIRECT || i10 == HTTP_PERMANENT_REDIRECT;
    }
}
