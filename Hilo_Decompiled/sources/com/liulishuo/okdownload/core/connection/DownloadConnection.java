package com.liulishuo.okdownload.core.connection;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface DownloadConnection {
    public static final int NO_RESPONSE_CODE = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Connected {
        InputStream getInputStream();

        String getRedirectLocation();

        int getResponseCode();

        String getResponseHeaderField(String str);

        Map<String, List<String>> getResponseHeaderFields();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Factory {
        DownloadConnection create(String str);
    }

    void addHeader(String str, String str2);

    Connected execute();

    Map<String, List<String>> getRequestProperties();

    String getRequestProperty(String str);

    void release();

    boolean setRequestMethod(String str);
}
