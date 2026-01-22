package com.alibaba.sdk.android.ams.common.util;

import android.content.Context;
import android.util.Base64;
import anet.channel.request.Request;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.qiahao.base_common.network.model.ErrorCode;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٣٣٠a = AmsLogger.getLogger("MPS:httpClient");

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.alibaba.sdk.android.ams.common.util.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٧٥a extends IOException {
        public C٠٠٧٥a(IOException iOException, int i10) {
            super(iOException.getMessage() + " code " + i10, iOException);
        }
    }

    public static HttpURLConnection a(String str, Map<String, String> map, String str2) {
        return Request.Method.POST.equals(str2) ? a(str, map, str2, 0, null) : a(str, map, str2, 0);
    }

    @Deprecated
    private static HttpURLConnection a(String str, Map<String, String> map, String str2, int i10) {
        if (i10 >= 3) {
            throw new C٠٠٧٥a(new IOException("redirectCount > 3"), 300);
        }
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    f٦٣٣٠a.w("skip empty entry " + entry.getKey());
                } else {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str + "?" + ((Object) sb)).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(str2 == null ? Request.Method.GET : str2);
        httpURLConnection.setReadTimeout(ErrorCode.ERROR_6000);
        httpURLConnection.setConnectTimeout(ErrorCode.ERROR_6000);
        httpURLConnection.connect();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            f٦٣٣٠a.d("responseCode: " + responseCode);
            return (responseCode != 200 && responseCode / 3 == 100) ? a(httpURLConnection.getHeaderField("Location"), map, str2, i10) : httpURLConnection;
        } catch (IOException e10) {
            f٦٣٣٠a.d("openConnection: ", e10);
            throw new C٠٠٧٥a(e10, httpURLConnection.getResponseCode());
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map, String str2, int i10, Context context) {
        if (i10 >= 3) {
            throw new C٠٠٧٥a(new IOException("redirectCount > 3"), 300);
        }
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() == null) {
                    f٦٣٣٠a.w("skip empty entry " + entry.getKey());
                } else {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(Base64.encodeToString(entry.getValue().getBytes(), 8));
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(Request.Method.POST);
        httpURLConnection.setReadTimeout(ErrorCode.ERROR_6000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(ErrorCode.ERROR_6000);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(sb.toString().getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
        try {
            int responseCode = httpURLConnection.getResponseCode();
            f٦٣٣٠a.d("responseCode: " + responseCode);
            return (responseCode != 200 && responseCode / 3 == 100) ? a(httpURLConnection.getHeaderField("Location"), map, str2, i10, context) : httpURLConnection;
        } catch (IOException e10) {
            f٦٣٣٠a.d("openConnection: ", e10);
            throw new C٠٠٧٥a(e10, httpURLConnection.getResponseCode());
        }
    }
}
