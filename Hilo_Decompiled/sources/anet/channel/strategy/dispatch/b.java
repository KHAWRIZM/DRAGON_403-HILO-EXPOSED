package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import android.util.Base64InputStream;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ENV;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import com.amazonaws.services.s3.Headers;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.appinvite.PreviewActivity;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static AtomicInteger f٤٩٩٧a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    static HostnameVerifier f٤٩٩٨b = new c();

    /* renamed from: c, reason: collision with root package name */
    static Random f٤٩٩٩c = new Random();

    b() {
    }

    static List<IConnStrategy> a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static void a(Map map) {
        String schemeByHost;
        String a10;
        IConnStrategy iConnStrategy;
        String str;
        if (map == null) {
            return;
        }
        if (AmdcRuntimeInfo.isForceHttps()) {
            schemeByHost = HttpConstant.HTTPS;
        } else {
            schemeByHost = StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        }
        List<IConnStrategy> a11 = a(schemeByHost);
        for (int i10 = 0; i10 < 3; i10++) {
            HashMap hashMap = new HashMap(map);
            if (i10 != 2) {
                iConnStrategy = !a11.isEmpty() ? a11.remove(0) : null;
                if (iConnStrategy != null) {
                    str = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i10);
                } else {
                    str = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp != null && amdcServerFixIp.length > 0) {
                    a10 = a(schemeByHost, amdcServerFixIp[f٤٩٩٩c.nextInt(amdcServerFixIp.length)], 0, hashMap, i10);
                } else {
                    a10 = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
                String str2 = a10;
                iConnStrategy = null;
                str = str2;
            }
            int a12 = a(str, hashMap, i10);
            if (iConnStrategy != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = a12 == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
            }
            if (a12 == 0 || a12 == 2) {
                return;
            }
        }
    }

    private static String a(String str, String str2, int i10, Map<String, String> map, int i11) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i11 == 2 && HttpConstant.HTTPS.equalsIgnoreCase(str) && f٤٩٩٩c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(str2)) {
                try {
                    str2 = anet.channel.util.c.a(str2);
                } catch (Exception unused) {
                }
            }
            if (anet.channel.strategy.utils.c.b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i10 == 0) {
                i10 = HttpConstant.HTTPS.equalsIgnoreCase(str) ? 443 : 80;
            }
            sb.append(CertificateUtil.DELIMITER);
            sb.append(i10);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put("platform", map.remove("platform"));
        sb.append('?');
        sb.append(anet.channel.strategy.utils.c.a(treeMap, "utf-8"));
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x028a A[Catch: all -> 0x028f, TryCatch #5 {all -> 0x028f, blocks: (B:110:0x0280, B:112:0x028a, B:113:0x0292), top: B:109:0x0280 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, Map map, int i10) {
        URL url;
        HttpURLConnection httpURLConnection;
        String message;
        String str2 = "AMDC" + String.valueOf(f٤٩٩٧a.incrementAndGet());
        int i11 = 2;
        ALog.i("awcn.DispatchCore", "send amdc request", str2, "url", str, "\nhost", map.get("domain").toString());
        ENV env = (ENV) map.remove("Env");
        try {
            url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
                try {
                    message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = th.toString();
                    }
                    a("-1000", message, url, i10, 1);
                    ALog.e("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
                    if (httpURLConnection != null) {
                        return 1;
                    }
                    try {
                        httpURLConnection.disconnect();
                        return 1;
                    } catch (Exception e10) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e10, new Object[0]);
                        return 1;
                    }
                } finally {
                }
            }
            try {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestMethod(Request.Method.POST);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.addRequestProperty(Headers.CONNECTION, PreviewActivity.ON_CLICK_LISTENER_CLOSE);
                httpURLConnection.addRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
                httpURLConnection.addRequestProperty("Host", DispatchConstants.getAmdcServerDomain());
                httpURLConnection.setInstanceFollowRedirects(false);
                if (url.getProtocol().equals(HttpConstant.HTTPS)) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f٤٩٩٨b);
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc request.", str2, "headers", httpURLConnection.getRequestProperties().toString());
                }
                httpURLConnection.getOutputStream().write(anet.channel.strategy.utils.c.a(map, "utf-8").getBytes());
                int responseCode = httpURLConnection.getResponseCode();
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc response. code: " + responseCode, str2, "\nheaders", httpURLConnection.getHeaderFields());
                }
                if (responseCode != 200) {
                    if (responseCode != 302 && responseCode != 307) {
                        i11 = 1;
                    }
                    a(String.valueOf(responseCode), "response code not 200", url, i10, i11);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e11) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e11, new Object[0]);
                    }
                    return i11;
                }
                String headerField = httpURLConnection.getHeaderField("x-am-code");
                if (!"1000".equals(headerField)) {
                    if (!"1007".equals(headerField) && !"1008".equals(headerField)) {
                        i11 = 1;
                    }
                    a(headerField, "return code: " + headerField, url, i10, i11);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e12) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e12, new Object[0]);
                    }
                    return i11;
                }
                String headerField2 = httpURLConnection.getHeaderField("x-am-sign");
                if (TextUtils.isEmpty(headerField2)) {
                    a("-1001", "response sign is empty", url, i10, 1);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e13) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e13, new Object[0]);
                    }
                    return 1;
                }
                String a10 = a(httpURLConnection.getInputStream(), HttpConstant.GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding()));
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc response body", str2, "\nbody", a10);
                }
                a(str, r1.length, httpURLConnection.getContentLength());
                if (TextUtils.isEmpty(a10)) {
                    a("-1002", "read answer error", url, i10, 1);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e14) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e14, new Object[0]);
                    }
                    return 1;
                }
                IAmdcSign sign = AmdcRuntimeInfo.getSign();
                String sign2 = sign != null ? sign.sign(a10) : null;
                if (!sign2.equalsIgnoreCase(headerField2)) {
                    ALog.e("awcn.DispatchCore", "check ret sign failed", str2, "retSign", headerField2, "checkSign", sign2);
                    a("-1003", "check sign failed", url, i10, 1);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e15) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e15, new Object[0]);
                    }
                    return 1;
                }
                try {
                    JSONObject jSONObject = (JSONObject) new JSONTokener(a10).nextValue();
                    if (GlobalAppRuntimeInfo.getEnv() != env) {
                        ALog.w("awcn.DispatchCore", "env change, do not notify result", str2, new Object[0]);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e16) {
                            ALog.e("awcn.DispatchCore", "http disconnect failed", null, e16, new Object[0]);
                        }
                        return 0;
                    }
                    HttpDispatcher.getInstance().a(new DispatchEvent(1, jSONObject));
                    a(headerField, "request success", url, i10, 0);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e17) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e17, new Object[0]);
                    }
                    return 0;
                } catch (JSONException unused) {
                    HttpDispatcher.getInstance().a(new DispatchEvent(0, null));
                    ALog.e("awcn.DispatchCore", "resolve amdc anser failed", str2, new Object[0]);
                    a("-1004", "resolve answer failed", url, i10, 1);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e18) {
                        ALog.e("awcn.DispatchCore", "http disconnect failed", null, e18, new Object[0]);
                    }
                    return 1;
                }
            } catch (Throwable th2) {
                th = th2;
                message = th.getMessage();
                if (TextUtils.isEmpty(message)) {
                }
                a("-1000", message, url, i10, 1);
                ALog.e("awcn.DispatchCore", "amdc request fail", str2, th, new Object[0]);
                if (httpURLConnection != null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            url = null;
        }
    }

    static String a(InputStream inputStream, boolean z10) {
        Throwable th;
        IOException e10;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z10) {
            try {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (IOException e11) {
                    e10 = e11;
                    ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
        FilterInputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e12) {
            e10 = e12;
            bufferedInputStream = base64InputStream;
            ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    static void a(String str, String str2, URL url, int i10, int i11) {
        if ((i11 != 1 || i10 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i10;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    static void a(String str, long j10, long j11) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j10;
            flowStat.downstream = j11;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e10) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", null, e10, new Object[0]);
        }
    }
}
