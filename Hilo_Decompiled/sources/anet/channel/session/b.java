package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.c;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f٤٩٠١a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f٤٩٠٢b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f٤٩٠٣c;

        /* renamed from: d, reason: collision with root package name */
        public int f٤٩٠٤d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f٤٩٠٥e;
    }

    private b() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(12:8|9|10|11|(13:281|282|284|285|286|287|288|289|290|291|293|294|295)(1:13)|14|15|16|17|18|19|(9:20|21|22|23|24|25|26|(1:225)(2:30|(10:32|33|34|35|36|37|38|39|41|42)(7:166|167|168|169|170|171|172))|173))|(11:184|(1:186)|(1:188)|189|190|191|(1:193)|(1:195)|197|198|56)|204|190|191|(0)|(0)|197|198|56|6) */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x033b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x033c, code lost:
    
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x02f0, code lost:
    
        r26.onResponseCode(r15.f٤٩٠١a, r15.f٤٩٠٣c);
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04ef A[Catch: all -> 0x0514, TRY_LEAVE, TryCatch #109 {all -> 0x0514, blocks: (B:100:0x04c4, B:104:0x04e8, B:106:0x04ef, B:110:0x0510), top: B:99:0x04c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x05d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0570 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0413 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0438 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0316 A[Catch: all -> 0x0090, IOException -> 0x009e, CancellationException -> 0x00a4, ConnectException -> 0x00bd, ConnectTimeoutException -> 0x00c3, SocketTimeoutException -> 0x00c9, UnknownHostException -> 0x00cf, Exception -> 0x021c, SSLException -> 0x0222, SSLHandshakeException -> 0x0226, TRY_ENTER, TryCatch #14 {SSLHandshakeException -> 0x0226, blocks: (B:18:0x013b, B:22:0x017e, B:26:0x0192, B:28:0x019d, B:30:0x01a7, B:32:0x01ad, B:37:0x01c6, B:168:0x024d, B:172:0x025e, B:173:0x027d, B:175:0x029f, B:184:0x02b2, B:186:0x02cd, B:188:0x02db, B:189:0x02e2, B:190:0x02ff, B:193:0x0316, B:195:0x032f, B:203:0x02f0, B:204:0x02f7), top: B:17:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x032f A[Catch: all -> 0x0090, IOException -> 0x009e, CancellationException -> 0x00a4, ConnectException -> 0x00bd, ConnectTimeoutException -> 0x00c3, SocketTimeoutException -> 0x00c9, UnknownHostException -> 0x00cf, Exception -> 0x021c, SSLException -> 0x0222, SSLHandshakeException -> 0x0226, TRY_LEAVE, TryCatch #14 {SSLHandshakeException -> 0x0226, blocks: (B:18:0x013b, B:22:0x017e, B:26:0x0192, B:28:0x019d, B:30:0x01a7, B:32:0x01ad, B:37:0x01c6, B:168:0x024d, B:172:0x025e, B:173:0x027d, B:175:0x029f, B:184:0x02b2, B:186:0x02cd, B:188:0x02db, B:189:0x02e2, B:190:0x02ff, B:193:0x0316, B:195:0x032f, B:203:0x02f0, B:204:0x02f7), top: B:17:0x013b }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x047c A[Catch: all -> 0x0090, TRY_LEAVE, TryCatch #49 {all -> 0x0090, blocks: (B:11:0x0039, B:282:0x003f, B:286:0x0057, B:291:0x0070, B:295:0x008b, B:15:0x0129, B:18:0x013b, B:22:0x017e, B:26:0x0192, B:28:0x019d, B:30:0x01a7, B:32:0x01ad, B:37:0x01c6, B:168:0x024d, B:172:0x025e, B:173:0x027d, B:175:0x029f, B:184:0x02b2, B:186:0x02cd, B:188:0x02db, B:189:0x02e2, B:190:0x02ff, B:193:0x0316, B:195:0x032f, B:203:0x02f0, B:204:0x02f7, B:254:0x0451, B:258:0x0475, B:260:0x047c, B:265:0x049f), top: B:10:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03ae A[Catch: all -> 0x03a0, TryCatch #55 {all -> 0x03a0, blocks: (B:9:0x0035, B:48:0x03a8, B:50:0x03ae, B:51:0x03b5, B:53:0x03bd, B:54:0x03d1, B:63:0x03cc, B:146:0x03f2, B:156:0x0427, B:69:0x0534, B:136:0x055c, B:79:0x0582, B:89:0x05a8), top: B:8:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03bd A[Catch: all -> 0x03a0, TryCatch #55 {all -> 0x03a0, blocks: (B:9:0x0035, B:48:0x03a8, B:50:0x03ae, B:51:0x03b5, B:53:0x03bd, B:54:0x03d1, B:63:0x03cc, B:146:0x03f2, B:156:0x0427, B:69:0x0534, B:136:0x055c, B:79:0x0582, B:89:0x05a8), top: B:8:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03cc A[Catch: all -> 0x03a0, TryCatch #55 {all -> 0x03a0, blocks: (B:9:0x0035, B:48:0x03a8, B:50:0x03ae, B:51:0x03b5, B:53:0x03bd, B:54:0x03d1, B:63:0x03cc, B:146:0x03f2, B:156:0x0427, B:69:0x0534, B:136:0x055c, B:79:0x0582, B:89:0x05a8), top: B:8:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0548 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0596 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x05c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Request request, RequestCb requestCb) {
        String str;
        Exception exc;
        ConnectTimeoutException connectTimeoutException;
        String str2;
        String str3;
        String str4;
        SSLException sSLException;
        HttpURLConnection httpURLConnection;
        String str5;
        SSLHandshakeException sSLHandshakeException;
        HttpURLConnection httpURLConnection2;
        CancellationException cancellationException;
        IOException iOException;
        UnknownHostException unknownHostException;
        SocketTimeoutException socketTimeoutException;
        ConnectException connectException;
        Throwable th;
        String seq;
        String obj;
        int i10;
        String singleHeaderFieldByKey;
        int i11 = 2;
        String str6 = "hostnameVerifier";
        String str7 = "sslSocketFactory";
        String str8 = "SSL Error Info.";
        String str9 = "";
        a aVar = new a();
        Throwable th2 = null;
        if (request == null || request.getUrl() == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), new RequestStatistic(null, null));
            }
            return aVar;
        }
        Request request2 = request;
        HttpURLConnection httpURLConnection3 = null;
        while (NetworkStatusHelper.isConnected()) {
            try {
                try {
                    httpURLConnection = a(request2);
                    try {
                        try {
                            try {
                                try {
                                    if (ALog.isPrintLog(i11)) {
                                        try {
                                            try {
                                                String seq2 = request2.getSeq();
                                                String url = httpURLConnection.getURL().toString();
                                                try {
                                                    Object[] objArr = new Object[i11];
                                                    objArr[0] = "request URL";
                                                    objArr[1] = url;
                                                    ALog.i("awcn.HttpConnector", str9, seq2, objArr);
                                                    String seq3 = request2.getSeq();
                                                    String requestMethod = httpURLConnection.getRequestMethod();
                                                    str4 = str8;
                                                    try {
                                                        Object[] objArr2 = new Object[i11];
                                                        objArr2[0] = "request Method";
                                                        objArr2[1] = requestMethod;
                                                        try {
                                                            ALog.i("awcn.HttpConnector", str9, seq3, objArr2);
                                                            seq = request2.getSeq();
                                                            obj = httpURLConnection.getRequestProperties().toString();
                                                        } catch (SSLHandshakeException e10) {
                                                            e = e10;
                                                            httpURLConnection2 = httpURLConnection;
                                                            str2 = str6;
                                                            str3 = str7;
                                                            str5 = str4;
                                                            sSLHandshakeException = e;
                                                            try {
                                                                c.a.f٤٩٨٣a.b(request2.getHost());
                                                                a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                                                try {
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), sSLHandshakeException);
                                                                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                                                                    }
                                                                    if (httpURLConnection2 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                }
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                            }
                                                        } catch (SSLException e11) {
                                                            e = e11;
                                                        }
                                                    } catch (ConnectException e12) {
                                                        e = e12;
                                                    } catch (SocketTimeoutException e13) {
                                                        e = e13;
                                                    } catch (UnknownHostException e14) {
                                                        e = e14;
                                                    } catch (CancellationException e15) {
                                                        e = e15;
                                                    } catch (SSLHandshakeException e16) {
                                                        e = e16;
                                                    } catch (SSLException e17) {
                                                        e = e17;
                                                    } catch (ConnectTimeoutException e18) {
                                                        e = e18;
                                                    } catch (IOException e19) {
                                                        e = e19;
                                                    } catch (Exception e20) {
                                                        e = e20;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                    }
                                                } catch (ConnectException e21) {
                                                    e = e21;
                                                } catch (SocketTimeoutException e22) {
                                                    e = e22;
                                                } catch (UnknownHostException e23) {
                                                    e = e23;
                                                } catch (CancellationException e24) {
                                                    e = e24;
                                                } catch (SSLHandshakeException e25) {
                                                    e = e25;
                                                    str4 = str8;
                                                } catch (SSLException e26) {
                                                    e = e26;
                                                    str4 = str8;
                                                } catch (ConnectTimeoutException e27) {
                                                    e = e27;
                                                } catch (IOException e28) {
                                                    e = e28;
                                                } catch (Exception e29) {
                                                    e = e29;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                }
                                            } catch (Exception e30) {
                                                e = e30;
                                            }
                                        } catch (SSLHandshakeException e31) {
                                            e = e31;
                                            str4 = str8;
                                        } catch (SSLException e32) {
                                            e = e32;
                                            str4 = str8;
                                        }
                                        try {
                                            Object[] objArr3 = new Object[i11];
                                            objArr3[0] = "request headers";
                                            objArr3[1] = obj;
                                            ALog.i("awcn.HttpConnector", str9, seq, objArr3);
                                        } catch (ConnectException e33) {
                                            e = e33;
                                            connectException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_CONNECT_EXCEPTION, connectException);
                                            ALog.e("awcn.HttpConnector", "HTTP Connect Exception", request2.getSeq(), connectException, new Object[0]);
                                            NetworkStatusHelper.printNetworkDetail();
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (SocketTimeoutException e34) {
                                            e = e34;
                                            socketTimeoutException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_SOCKET_TIME_OUT, socketTimeoutException);
                                            ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", request2.getSeq(), socketTimeoutException, new Object[0]);
                                            NetworkStatusHelper.printNetworkDetail();
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (UnknownHostException e35) {
                                            e = e35;
                                            unknownHostException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, unknownHostException);
                                            ALog.e("awcn.HttpConnector", "Unknown Host Exception", request2.getSeq(), "host", request2.getHost(), unknownHostException);
                                            NetworkStatusHelper.printNetworkDetail();
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (SSLHandshakeException e36) {
                                            e = e36;
                                            httpURLConnection2 = httpURLConnection;
                                            sSLHandshakeException = e;
                                            str2 = str6;
                                            str3 = str7;
                                            str5 = str4;
                                            c.a.f٤٩٨٣a.b(request2.getHost());
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                            ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), sSLHandshakeException);
                                            if (httpURLConnection2 instanceof HttpsURLConnection) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            return aVar;
                                        } catch (SSLException e37) {
                                            e = e37;
                                            sSLException = e;
                                            str2 = str6;
                                            str3 = str7;
                                            c.a.f٤٩٨٣a.b(request2.getHost());
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLException);
                                            try {
                                                ALog.e("awcn.HttpConnector", "connect SSLException", request2.getSeq(), "host", request2.getHost(), sSLException);
                                                if (httpURLConnection instanceof HttpsURLConnection) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                return aVar;
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                        } catch (ConnectTimeoutException e38) {
                                            e = e38;
                                            connectTimeoutException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_CONN_TIME_OUT, connectTimeoutException);
                                            ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", request2.getSeq(), connectTimeoutException, new Object[0]);
                                            NetworkStatusHelper.printNetworkDetail();
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (IOException e39) {
                                            e = e39;
                                            iOException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, iOException);
                                            ALog.e("awcn.HttpConnector", "IO Exception", request2.getSeq(), "host", request2.getHost(), iOException);
                                            NetworkStatusHelper.printNetworkDetail();
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (CancellationException e40) {
                                            e = e40;
                                            cancellationException = e;
                                            httpURLConnection3 = httpURLConnection;
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_REQUEST_CANCEL, cancellationException);
                                            ALog.e("awcn.HttpConnector", "HTTP Request Cancel", request2.getSeq(), cancellationException, new Object[0]);
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (Exception e41) {
                                            e = e41;
                                            exc = e;
                                            httpURLConnection3 = httpURLConnection;
                                            str = str9;
                                            if (!(exc.getMessage() == null ? exc.getMessage() : str).contains("not verified")) {
                                            }
                                            ALog.e("awcn.HttpConnector", "HTTP Exception", request2.getSeq(), exc, new Object[0]);
                                            if (httpURLConnection3 != null) {
                                            }
                                            return aVar;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            th = th;
                                            httpURLConnection3 = httpURLConnection;
                                            if (httpURLConnection3 == null) {
                                            }
                                        }
                                    } else {
                                        str4 = str8;
                                    }
                                    try {
                                        request2.f٤٨٤٤a.sendStart = System.currentTimeMillis();
                                        RequestStatistic requestStatistic = request2.f٤٨٤٤a;
                                        str2 = str6;
                                        str3 = str7;
                                        try {
                                            try {
                                                requestStatistic.processTime = requestStatistic.sendStart - request2.f٤٨٤٤a.start;
                                                httpURLConnection.connect();
                                                a(httpURLConnection, request2);
                                                request2.f٤٨٤٤a.sendEnd = System.currentTimeMillis();
                                                RequestStatistic requestStatistic2 = request2.f٤٨٤٤a;
                                                requestStatistic2.sendDataTime = requestStatistic2.sendEnd - request2.f٤٨٤٤a.sendStart;
                                                aVar.f٤٩٠١a = httpURLConnection.getResponseCode();
                                                aVar.f٤٩٠٣c = HttpHelper.cloneMap(httpURLConnection.getHeaderFields());
                                                try {
                                                    ALog.i("awcn.HttpConnector", str9, request2.getSeq(), "response code", Integer.valueOf(aVar.f٤٩٠١a));
                                                    try {
                                                        ALog.i("awcn.HttpConnector", str9, request2.getSeq(), "response headers", aVar.f٤٩٠٣c);
                                                        if (!HttpHelper.checkRedirect(request2, aVar.f٤٩٠١a) || (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(aVar.f٤٩٠٣c, "Location")) == null) {
                                                            str = str9;
                                                        } else {
                                                            HttpUrl parse = HttpUrl.parse(singleHeaderFieldByKey);
                                                            if (parse != null) {
                                                                str = str9;
                                                                try {
                                                                    try {
                                                                        ALog.i("awcn.HttpConnector", "redirect", request2.getSeq(), "to url", parse.toString());
                                                                        request2 = request2.newBuilder().setMethod(Request.Method.GET).setBody(null).setUrl(parse).setRedirectTimes(request2.getRedirectTimes() + 1).setSslSocketFactory(null).setHostnameVerifier(null).build();
                                                                        request2.f٤٨٤٤a.recordRedirect(aVar.f٤٩٠١a, parse.simpleUrlString());
                                                                        request2.f٤٨٤٤a.locationUrl = singleHeaderFieldByKey;
                                                                        try {
                                                                            httpURLConnection.disconnect();
                                                                        } catch (Exception e42) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e42, new Object[0]);
                                                                        }
                                                                        httpURLConnection3 = httpURLConnection;
                                                                        str8 = str4;
                                                                        str6 = str2;
                                                                        str7 = str3;
                                                                        str9 = str;
                                                                        th2 = null;
                                                                        i11 = 2;
                                                                    } catch (Exception e43) {
                                                                        e = e43;
                                                                        exc = e;
                                                                        httpURLConnection3 = httpURLConnection;
                                                                        if (!(exc.getMessage() == null ? exc.getMessage() : str).contains("not verified")) {
                                                                            c.a.f٤٩٨٣a.b(request2.getHost());
                                                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR, exc);
                                                                        } else {
                                                                            a(request2, aVar, requestCb, -101, exc);
                                                                        }
                                                                        ALog.e("awcn.HttpConnector", "HTTP Exception", request2.getSeq(), exc, new Object[0]);
                                                                        if (httpURLConnection3 != null) {
                                                                            try {
                                                                                httpURLConnection3.disconnect();
                                                                            } catch (Exception e44) {
                                                                                ALog.e("awcn.HttpConnector", "http disconnect", null, e44, new Object[0]);
                                                                            }
                                                                        }
                                                                        return aVar;
                                                                    }
                                                                } catch (ConnectException e45) {
                                                                    e = e45;
                                                                    connectException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_CONNECT_EXCEPTION, connectException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect Exception", request2.getSeq(), connectException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e46) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e46, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (SocketTimeoutException e47) {
                                                                    e = e47;
                                                                    socketTimeoutException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_SOCKET_TIME_OUT, socketTimeoutException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", request2.getSeq(), socketTimeoutException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e48) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e48, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (UnknownHostException e49) {
                                                                    e = e49;
                                                                    unknownHostException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, unknownHostException);
                                                                    ALog.e("awcn.HttpConnector", "Unknown Host Exception", request2.getSeq(), "host", request2.getHost(), unknownHostException);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e50) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e50, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (SSLHandshakeException e51) {
                                                                    e = e51;
                                                                    httpURLConnection2 = httpURLConnection;
                                                                    sSLHandshakeException = e;
                                                                    str5 = str4;
                                                                    c.a.f٤٩٨٣a.b(request2.getHost());
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), sSLHandshakeException);
                                                                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                                                                    }
                                                                    if (httpURLConnection2 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (ConnectTimeoutException e52) {
                                                                    e = e52;
                                                                    connectTimeoutException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_CONN_TIME_OUT, connectTimeoutException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", request2.getSeq(), connectTimeoutException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e53) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e53, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (IOException e54) {
                                                                    e = e54;
                                                                    iOException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, iOException);
                                                                    ALog.e("awcn.HttpConnector", "IO Exception", request2.getSeq(), "host", request2.getHost(), iOException);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e55) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e55, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (CancellationException e56) {
                                                                    e = e56;
                                                                    cancellationException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_REQUEST_CANCEL, cancellationException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Request Cancel", request2.getSeq(), cancellationException, new Object[0]);
                                                                    if (httpURLConnection3 != null) {
                                                                        try {
                                                                            httpURLConnection3.disconnect();
                                                                        } catch (Exception e57) {
                                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e57, new Object[0]);
                                                                        }
                                                                    }
                                                                    return aVar;
                                                                } catch (Exception e58) {
                                                                    e = e58;
                                                                    exc = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    if (!(exc.getMessage() == null ? exc.getMessage() : str).contains("not verified")) {
                                                                    }
                                                                    ALog.e("awcn.HttpConnector", "HTTP Exception", request2.getSeq(), exc, new Object[0]);
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    th = th;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    if (httpURLConnection3 == null) {
                                                                    }
                                                                }
                                                            } else {
                                                                str = str9;
                                                                try {
                                                                    ALog.e("awcn.HttpConnector", "redirect url is invalid!", request2.getSeq(), "redirect url", singleHeaderFieldByKey);
                                                                } catch (ConnectException e59) {
                                                                    e = e59;
                                                                    connectException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_CONNECT_EXCEPTION, connectException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect Exception", request2.getSeq(), connectException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (SocketTimeoutException e60) {
                                                                    e = e60;
                                                                    socketTimeoutException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_SOCKET_TIME_OUT, socketTimeoutException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", request2.getSeq(), socketTimeoutException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (UnknownHostException e61) {
                                                                    e = e61;
                                                                    unknownHostException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, unknownHostException);
                                                                    ALog.e("awcn.HttpConnector", "Unknown Host Exception", request2.getSeq(), "host", request2.getHost(), unknownHostException);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (CancellationException e62) {
                                                                    e = e62;
                                                                    cancellationException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_REQUEST_CANCEL, cancellationException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Request Cancel", request2.getSeq(), cancellationException, new Object[0]);
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (SSLHandshakeException e63) {
                                                                    e = e63;
                                                                    httpURLConnection2 = httpURLConnection;
                                                                    sSLHandshakeException = e;
                                                                    str5 = str4;
                                                                    c.a.f٤٩٨٣a.b(request2.getHost());
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), sSLHandshakeException);
                                                                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                                                                    }
                                                                    if (httpURLConnection2 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (ConnectTimeoutException e64) {
                                                                    e = e64;
                                                                    connectTimeoutException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_CONN_TIME_OUT, connectTimeoutException);
                                                                    ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", request2.getSeq(), connectTimeoutException, new Object[0]);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (IOException e65) {
                                                                    e = e65;
                                                                    iOException = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    a(request2, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, iOException);
                                                                    ALog.e("awcn.HttpConnector", "IO Exception", request2.getSeq(), "host", request2.getHost(), iOException);
                                                                    NetworkStatusHelper.printNetworkDetail();
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (Exception e66) {
                                                                    e = e66;
                                                                    exc = e;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    if (!(exc.getMessage() == null ? exc.getMessage() : str).contains("not verified")) {
                                                                    }
                                                                    ALog.e("awcn.HttpConnector", "HTTP Exception", request2.getSeq(), exc, new Object[0]);
                                                                    if (httpURLConnection3 != null) {
                                                                    }
                                                                    return aVar;
                                                                } catch (Throwable th10) {
                                                                    th = th10;
                                                                    th = th;
                                                                    httpURLConnection3 = httpURLConnection;
                                                                    if (httpURLConnection3 == null) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        request2.f٤٨٤٤a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(aVar.f٤٩٠٣c, "Content-Encoding");
                                                        request2.f٤٨٤٤a.contentType = HttpHelper.getSingleHeaderFieldByKey(aVar.f٤٩٠٣c, "Content-Type");
                                                    } catch (ConnectException e67) {
                                                        e = e67;
                                                    } catch (SocketTimeoutException e68) {
                                                        e = e68;
                                                    } catch (UnknownHostException e69) {
                                                        e = e69;
                                                    } catch (CancellationException e70) {
                                                        e = e70;
                                                    } catch (SSLHandshakeException e71) {
                                                        e = e71;
                                                    } catch (ConnectTimeoutException e72) {
                                                        e = e72;
                                                    } catch (IOException e73) {
                                                        e = e73;
                                                    } catch (Exception e74) {
                                                        e = e74;
                                                        str = str9;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                    }
                                                } catch (ConnectException e75) {
                                                    e = e75;
                                                } catch (SocketTimeoutException e76) {
                                                    e = e76;
                                                } catch (UnknownHostException e77) {
                                                    e = e77;
                                                } catch (SSLHandshakeException e78) {
                                                    e = e78;
                                                } catch (ConnectTimeoutException e79) {
                                                    e = e79;
                                                } catch (IOException e80) {
                                                    e = e80;
                                                } catch (CancellationException e81) {
                                                    e = e81;
                                                } catch (Exception e82) {
                                                    e = e82;
                                                    str = str9;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                }
                                            } catch (SSLHandshakeException e83) {
                                                e = e83;
                                                httpURLConnection2 = httpURLConnection;
                                                str5 = str4;
                                                sSLHandshakeException = e;
                                                c.a.f٤٩٨٣a.b(request2.getHost());
                                                a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                                ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), sSLHandshakeException);
                                                if (httpURLConnection2 instanceof HttpsURLConnection) {
                                                    try {
                                                        ALog.e("awcn.HttpConnector", str5, request2.getSeq(), str3, ((HttpsURLConnection) httpURLConnection2).getSSLSocketFactory(), str2, ((HttpsURLConnection) httpURLConnection2).getHostnameVerifier());
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        th = th;
                                                        httpURLConnection3 = httpURLConnection2;
                                                        if (httpURLConnection3 == null) {
                                                        }
                                                    }
                                                }
                                                if (httpURLConnection2 != null) {
                                                    try {
                                                        httpURLConnection2.disconnect();
                                                    } catch (Exception e84) {
                                                        ALog.e("awcn.HttpConnector", "http disconnect", null, e84, new Object[0]);
                                                    }
                                                }
                                                return aVar;
                                            }
                                        } catch (SSLException e85) {
                                            e = e85;
                                            sSLException = e;
                                            c.a.f٤٩٨٣a.b(request2.getHost());
                                            a(request2, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLException);
                                            ALog.e("awcn.HttpConnector", "connect SSLException", request2.getSeq(), "host", request2.getHost(), sSLException);
                                            if (httpURLConnection instanceof HttpsURLConnection) {
                                                try {
                                                    ALog.e("awcn.HttpConnector", str4, request2.getSeq(), str3, ((HttpsURLConnection) httpURLConnection).getSSLSocketFactory(), str2, ((HttpsURLConnection) httpURLConnection).getHostnameVerifier());
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    th = th;
                                                    httpURLConnection3 = httpURLConnection;
                                                    if (httpURLConnection3 == null) {
                                                    }
                                                }
                                            }
                                            if (httpURLConnection != null) {
                                                try {
                                                    httpURLConnection.disconnect();
                                                } catch (Exception e86) {
                                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e86, new Object[0]);
                                                }
                                            }
                                            return aVar;
                                        }
                                    } catch (SSLHandshakeException e87) {
                                        e = e87;
                                        str2 = str6;
                                        str3 = str7;
                                    } catch (SSLException e88) {
                                        e = e88;
                                        str2 = str6;
                                        str3 = str7;
                                    }
                                } catch (Throwable th15) {
                                    th = th15;
                                }
                            } catch (Exception e89) {
                                e = e89;
                                str = str9;
                            }
                        } catch (SSLHandshakeException e90) {
                            e = e90;
                            str2 = str6;
                            str3 = str7;
                            str4 = str8;
                        } catch (SSLException e91) {
                            e = e91;
                            str2 = str6;
                            str3 = str7;
                            str4 = str8;
                        }
                    } catch (ConnectException e92) {
                        e = e92;
                    } catch (SocketTimeoutException e93) {
                        e = e93;
                    } catch (UnknownHostException e94) {
                        e = e94;
                    } catch (CancellationException e95) {
                        e = e95;
                    } catch (ConnectTimeoutException e96) {
                        e = e96;
                    } catch (IOException e97) {
                        e = e97;
                    }
                } catch (Throwable th16) {
                    th = th16;
                    if (httpURLConnection3 == null) {
                        try {
                            httpURLConnection3.disconnect();
                            throw th;
                        } catch (Exception e98) {
                            ALog.e("awcn.HttpConnector", "http disconnect", null, e98, new Object[0]);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (ConnectException e99) {
                connectException = e99;
            } catch (SocketTimeoutException e100) {
                socketTimeoutException = e100;
            } catch (UnknownHostException e101) {
                unknownHostException = e101;
            } catch (IOException e102) {
                iOException = e102;
            } catch (CancellationException e103) {
                cancellationException = e103;
            } catch (SSLHandshakeException e104) {
                str2 = str6;
                str3 = str7;
                str5 = str8;
                sSLHandshakeException = e104;
                httpURLConnection2 = httpURLConnection3;
            } catch (SSLException e105) {
                str2 = str6;
                str3 = str7;
                str4 = str8;
                sSLException = e105;
                httpURLConnection = httpURLConnection3;
            } catch (ConnectTimeoutException e106) {
                connectTimeoutException = e106;
            } catch (Exception e107) {
                str = str9;
                exc = e107;
            }
            if (!"HEAD".equals(request2.getMethod()) && (i10 = aVar.f٤٩٠١a) != 304 && i10 != 204 && (i10 < 100 || i10 >= 200)) {
                int parseContentLength = HttpHelper.parseContentLength(aVar.f٤٩٠٣c);
                aVar.f٤٩٠٤d = parseContentLength;
                request2.f٤٨٤٤a.contentLength = parseContentLength;
                boolean equalsIgnoreCase = HttpConstant.GZIP.equalsIgnoreCase(request2.f٤٨٤٤a.contentEncoding);
                aVar.f٤٩٠٥e = equalsIgnoreCase;
                if (equalsIgnoreCase) {
                    aVar.f٤٩٠٣c.remove("Content-Encoding");
                    aVar.f٤٩٠٣c.remove("Content-Length");
                }
                if (requestCb != null) {
                    requestCb.onResponseCode(aVar.f٤٩٠١a, aVar.f٤٩٠٣c);
                }
                request2.f٤٨٤٤a.rspStart = System.currentTimeMillis();
                a(httpURLConnection, request2, aVar, requestCb);
                RequestStatistic requestStatistic3 = request2.f٤٨٤٤a;
                requestStatistic3.firstDataTime = requestStatistic3.rspStart - request2.f٤٨٤٤a.sendEnd;
                if (!request2.f٤٨٤٤a.isDone.get()) {
                    request2.f٤٨٤٤a.ret = 1;
                    request2.f٤٨٤٤a.statusCode = aVar.f٤٩٠١a;
                    request2.f٤٨٤٤a.msg = HttpConstant.SUCCESS;
                    request2.f٤٨٤٤a.rspEnd = System.currentTimeMillis();
                }
                if (requestCb != null) {
                    requestCb.onFinish(aVar.f٤٩٠١a, HttpConstant.SUCCESS, request2.f٤٨٤٤a);
                }
                httpURLConnection.disconnect();
                return aVar;
            }
            request2.f٤٨٤٤a.rspStart = System.currentTimeMillis();
            RequestStatistic requestStatistic32 = request2.f٤٨٤٤a;
            requestStatistic32.firstDataTime = requestStatistic32.rspStart - request2.f٤٨٤٤a.sendEnd;
            if (!request2.f٤٨٤٤a.isDone.get()) {
            }
            if (requestCb != null) {
            }
            httpURLConnection.disconnect();
            return aVar;
        }
        a(request2, aVar, requestCb, ErrorConstant.ERROR_NO_NETWORK, th2);
        return aVar;
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i10, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i10);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i10), "errMsg", errMsg, "url", request.getUrlString(), "host", request.getHost());
        if (aVar != null) {
            aVar.f٤٩٠١a = i10;
        }
        if (!request.f٤٨٤٤a.isDone.get()) {
            request.f٤٨٤٤a.statusCode = i10;
            request.f٤٨٤٤a.msg = errMsg;
            request.f٤٨٤٤a.rspEnd = System.currentTimeMillis();
            if (i10 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i10, errMsg, request.f٤٨٤٤a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i10, errMsg, request.f٤٨٤٤a);
        }
    }

    private static HttpURLConnection a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g a10 = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && a10 != null) {
            proxy = a10.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String str = headers.get("Host");
        if (str == null) {
            str = request.getHost();
        }
        String concatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(str, CertificateUtil.DELIMITER, String.valueOf(request.getHttpUrl().getPort())) : str;
        httpURLConnection.setRequestProperty("Host", concatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, concatString);
        }
        if (!headers.containsKey(HttpConstant.ACCEPT_ENCODING)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        }
        if (a10 != null) {
            httpURLConnection.setRequestProperty("Authorization", a10.c());
        }
        if (url.getProtocol().equalsIgnoreCase(HttpConstant.HTTPS)) {
            a(httpURLConnection, request, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.f٥٠٧٢a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.f٥٠٧٢a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f٥٠٧٣b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f٥٠٧٣b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i10 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int postBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e10) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e10, new Object[0]);
                        }
                    }
                    i10 = postBody;
                } catch (Exception e11) {
                    ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e11, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e12) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e12, new Object[0]);
                        }
                    }
                }
                long j10 = i10;
                request.f٤٨٤٤a.reqBodyInflateSize = j10;
                request.f٤٨٤٤a.reqBodyDeflateSize = j10;
                request.f٤٨٤٤a.sendDataSize = j10;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e13) {
                        ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e13, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i10;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws IOException, CancellationException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar3 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e10) {
            if (e10 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e11) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e11, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            a(request, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, null);
            return;
        }
        if (requestCb == null) {
            int i10 = aVar.f٤٩٠٤d;
            if (i10 <= 0) {
                i10 = 1024;
            } else if (aVar.f٤٩٠٥e) {
                i10 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i10);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            InputStream gZIPInputStream = aVar.f٤٩٠٥e ? new GZIPInputStream(aVar2) : aVar2;
            ByteArray byteArray = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArray == null) {
                    byteArray = a.C٠٠٦٠a.f٤٦٩٣a.a(2048);
                }
                int readFrom = byteArray.readFrom(gZIPInputStream);
                if (readFrom != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArray.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArray, false);
                        byteArray = null;
                    }
                    long j10 = readFrom;
                    request.f٤٨٤٤a.recDataSize += j10;
                    request.f٤٨٤٤a.rspBodyInflateSize += j10;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArray.recycle();
                    } else {
                        requestCb.onDataReceive(byteArray, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.f٤٩٠٢b = byteArrayOutputStream.toByteArray();
                    }
                    request.f٤٨٤٤a.recDataTime = System.currentTimeMillis() - request.f٤٨٤٤a.rspStart;
                    request.f٤٨٤٤a.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            aVar3 = aVar2;
            request.f٤٨٤٤a.recDataTime = System.currentTimeMillis() - request.f٤٨٤٤a.rspStart;
            request.f٤٨٤٤a.rspBodyDeflateSize = aVar3.a();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
