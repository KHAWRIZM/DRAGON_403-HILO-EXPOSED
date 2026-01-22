package com.tencent.imsdk.common;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.BaseConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HttpClient {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HTTP_ACTION_REQUEST = 0;
    public static final int HTTP_ACTION_RESPONSE = 1;
    private static final long KEEP_ALIVE = 5;
    private static final int MAX_POOL_SIZE;
    private static final int PROXY_TYPE_HTTP = 1;
    private static final int PROXY_TYPE_SOCKS5 = 2;
    private static final String TAG = "HttpClient";
    private static boolean mNeedRollbackHttps2Http;
    private static String mRollbackHttps2Http;
    private static final Executor mThreadPoolExecutor;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class BasicAuthenticator extends Authenticator {
        private String password;
        private String userName;

        public BasicAuthenticator(String str, String str2) {
            this.userName = str;
            this.password = str2;
        }

        @Override // java.net.Authenticator
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.userName, this.password.toCharArray());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface HttpRequestListener {
        void onCompleted(int i, Map<String, String> map, byte[] bArr);

        void onProgress(int i, int i2, int i3);

        void onStatistics(boolean z, int i, boolean z2, int i2, int i3, String str, int i4, int i5);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i = availableProcessors + 1;
        CORE_POOL_SIZE = i;
        int i2 = (availableProcessors * 2) + 1;
        MAX_POOL_SIZE = i2;
        mRollbackHttps2Http = "";
        mNeedRollbackHttps2Http = false;
        mThreadPoolExecutor = new ThreadPoolExecutor(i, i2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    private static void httpRequest(final String str, final String str2, final boolean z, final Map<String, String> map, final byte[] bArr, final String str3, final String str4, final int i, final String str5, final int i2, final String str6, final String str7, final int i3, final int i4, final String str8, final boolean z2, final HttpRequestListener httpRequestListener) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: com.tencent.imsdk.common.HttpClient.1
            /* JADX WARN: Can't wrap try/catch for region: R(45:1|(4:3|(1:5)|6|(1:8))|9|10|11|12|(3:475|476|477)(11:14|15|17|18|19|20|21|(2:434|435)|23|24|25)|26|27|(1:28)|(7:(3:393|394|(38:398|399|(2:401|(1:403))|43|44|(3:46|(2:49|47)|50)|51|(1:360)|55|(2:57|58)(1:356)|59|60|(3:343|344|(22:346|63|(1:342)(1:67)|(1:341)(1:70)|71|72|(5:75|(1:77)(1:197)|78|(2:79|(1:87)(3:81|(2:83|84)(1:86)|85))|88)|198|199|200|(4:202|203|(2:205|206)|222)(1:331)|223|(1:225)|226|(1:329)(1:230)|(9:232|(2:234|235)(2:325|326)|236|237|(2:238|(1:261)(5:240|241|242|(2:244|245)(2:247|248)|246))|(2:263|264)(1:307)|265|266|267)(1:328)|268|269|270|(2:280|281)|272|(4:274|(1:276)|277|278)(1:279)))|62|63|(1:65)|342|(0)|341|71|72|(5:75|(0)(0)|78|(3:79|(0)(0)|85)|88)|198|199|200|(0)(0)|223|(0)|226|(1:228)|329|(0)(0)|268|269|270|(0)|272|(0)(0)))|268|269|270|(0)|272|(0)(0))|30|31|(1:391)(3:37|38|(2:40|(1:42)))|43|44|(0)|51|(1:53)|358|360|55|(0)(0)|59|60|(0)|62|63|(0)|342|(0)|341|71|72|(0)|198|199|200|(0)(0)|223|(0)|226|(0)|329|(0)(0)) */
            /* JADX WARN: Code restructure failed: missing block: B:332:0x03fc, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:333:0x03fd, code lost:
            
                r7 = r0;
                r5 = r6;
                r18 = r5;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r16 = r25;
                r4 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:334:0x03e6, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:335:0x03e7, code lost:
            
                r4 = r0;
                r5 = r6;
                r18 = r5;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r9 = null;
                r16 = null;
                r6 = r3;
                r3 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:336:0x03d7, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:337:0x03d8, code lost:
            
                r5 = r0;
                r8 = r6;
                r18 = r8;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r4 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:338:0x03c6, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:339:0x03c7, code lost:
            
                r2 = r0;
                r5 = r6;
                r18 = r5;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r16 = r25;
                r4 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:347:0x05eb, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:348:0x05ec, code lost:
            
                r5 = 200;
                r7 = r0;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r16 = r25;
                r4 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:349:0x05db, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:350:0x05dc, code lost:
            
                r5 = 200;
                r4 = r0;
                r6 = r3;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r3 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:351:0x05c9, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:352:0x05ca, code lost:
            
                r5 = r0;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r4 = null;
                r6 = null;
                r8 = 200;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:353:0x05b8, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:354:0x05b9, code lost:
            
                r5 = 200;
                r2 = r0;
                r11 = r20;
                r12 = r21;
                r13 = r22;
                r14 = r23;
                r16 = r25;
                r4 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:380:0x0623, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:381:0x0624, code lost:
            
                r5 = 200;
                r7 = r0;
                r11 = r20;
                r12 = r21;
                r16 = r25;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:382:0x062d, code lost:
            
                r4 = null;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:383:0x0617, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:384:0x0618, code lost:
            
                r5 = 200;
                r4 = r0;
                r6 = r3;
                r11 = r20;
                r12 = r21;
                r3 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:385:0x0609, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:386:0x060a, code lost:
            
                r5 = r0;
                r11 = r20;
                r12 = r21;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:387:0x0611, code lost:
            
                r4 = null;
                r6 = null;
                r8 = 200;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:388:0x05fc, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:389:0x05fd, code lost:
            
                r5 = 200;
                r2 = r0;
                r11 = r20;
                r12 = r21;
                r16 = r25;
                r3 = r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:390:0x0606, code lost:
            
                r4 = null;
                r3 = r3;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:101:0x0835  */
            /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:108:0x0823 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:118:0x0857  */
            /* JADX WARN: Removed duplicated region for block: B:121:0x085e  */
            /* JADX WARN: Removed duplicated region for block: B:126:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:127:0x084c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:139:0x07c5 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:142:0x07d3  */
            /* JADX WARN: Removed duplicated region for block: B:145:0x07ed  */
            /* JADX WARN: Removed duplicated region for block: B:148:0x07f4  */
            /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:154:0x07e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:173:0x0764  */
            /* JADX WARN: Removed duplicated region for block: B:176:0x076b  */
            /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:182:0x0759 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:197:0x0324 A[Catch: all -> 0x02ac, Exception -> 0x02bf, IOException -> 0x02cd, UnknownHostException -> 0x02e0, TryCatch #43 {UnknownHostException -> 0x02e0, IOException -> 0x02cd, Exception -> 0x02bf, all -> 0x02ac, blocks: (B:344:0x02a7, B:65:0x02f8, B:75:0x0317, B:77:0x031c, B:78:0x032b, B:79:0x0335, B:88:0x033b, B:81:0x033f, B:83:0x034b, B:197:0x0324), top: B:343:0x02a7 }] */
            /* JADX WARN: Removed duplicated region for block: B:202:0x035f A[Catch: all -> 0x03c6, Exception -> 0x03d7, IOException -> 0x03e6, UnknownHostException -> 0x03fc, TRY_LEAVE, TryCatch #41 {UnknownHostException -> 0x03fc, IOException -> 0x03e6, Exception -> 0x03d7, all -> 0x03c6, blocks: (B:200:0x0355, B:202:0x035f), top: B:199:0x0355 }] */
            /* JADX WARN: Removed duplicated region for block: B:225:0x0414  */
            /* JADX WARN: Removed duplicated region for block: B:228:0x0419 A[Catch: all -> 0x0375, Exception -> 0x0389, IOException -> 0x039c, UnknownHostException -> 0x03b2, TryCatch #34 {UnknownHostException -> 0x03b2, IOException -> 0x039c, Exception -> 0x0389, all -> 0x0375, blocks: (B:206:0x0367, B:223:0x040e, B:226:0x0415, B:228:0x0419, B:232:0x0424), top: B:205:0x0367 }] */
            /* JADX WARN: Removed duplicated region for block: B:232:0x0424 A[Catch: all -> 0x0375, Exception -> 0x0389, IOException -> 0x039c, UnknownHostException -> 0x03b2, TRY_LEAVE, TryCatch #34 {UnknownHostException -> 0x03b2, IOException -> 0x039c, Exception -> 0x0389, all -> 0x0375, blocks: (B:206:0x0367, B:223:0x040e, B:226:0x0415, B:228:0x0419, B:232:0x0424), top: B:205:0x0367 }] */
            /* JADX WARN: Removed duplicated region for block: B:274:0x0575  */
            /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:280:0x0565 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:328:0x055a  */
            /* JADX WARN: Removed duplicated region for block: B:331:0x040d  */
            /* JADX WARN: Removed duplicated region for block: B:343:0x02a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:356:0x029b  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0242 A[Catch: all -> 0x017b, Exception -> 0x018a, IOException -> 0x0194, UnknownHostException -> 0x01a9, TRY_ENTER, TryCatch #36 {UnknownHostException -> 0x01a9, IOException -> 0x0194, Exception -> 0x018a, all -> 0x017b, blocks: (B:399:0x015d, B:401:0x0165, B:403:0x016d, B:46:0x0242, B:47:0x024a, B:49:0x0250, B:53:0x026a, B:57:0x0289, B:360:0x0272, B:38:0x0206, B:40:0x020e, B:42:0x0216), top: B:28:0x0139 }] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0289 A[Catch: all -> 0x017b, Exception -> 0x018a, IOException -> 0x0194, UnknownHostException -> 0x01a9, TRY_ENTER, TRY_LEAVE, TryCatch #36 {UnknownHostException -> 0x01a9, IOException -> 0x0194, Exception -> 0x018a, all -> 0x017b, blocks: (B:399:0x015d, B:401:0x0165, B:403:0x016d, B:46:0x0242, B:47:0x024a, B:49:0x0250, B:53:0x026a, B:57:0x0289, B:360:0x0272, B:38:0x0206, B:40:0x020e, B:42:0x0216), top: B:28:0x0139 }] */
            /* JADX WARN: Removed duplicated region for block: B:65:0x02f8 A[Catch: all -> 0x02ac, Exception -> 0x02bf, IOException -> 0x02cd, UnknownHostException -> 0x02e0, TRY_ENTER, TRY_LEAVE, TryCatch #43 {UnknownHostException -> 0x02e0, IOException -> 0x02cd, Exception -> 0x02bf, all -> 0x02ac, blocks: (B:344:0x02a7, B:65:0x02f8, B:75:0x0317, B:77:0x031c, B:78:0x032b, B:79:0x0335, B:88:0x033b, B:81:0x033f, B:83:0x034b, B:197:0x0324), top: B:343:0x02a7 }] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0303 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0315 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:77:0x031c A[Catch: all -> 0x02ac, Exception -> 0x02bf, IOException -> 0x02cd, UnknownHostException -> 0x02e0, TryCatch #43 {UnknownHostException -> 0x02e0, IOException -> 0x02cd, Exception -> 0x02bf, all -> 0x02ac, blocks: (B:344:0x02a7, B:65:0x02f8, B:75:0x0317, B:77:0x031c, B:78:0x032b, B:79:0x0335, B:88:0x033b, B:81:0x033f, B:83:0x034b, B:197:0x0324), top: B:343:0x02a7 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x033f A[Catch: all -> 0x02ac, Exception -> 0x02bf, IOException -> 0x02cd, UnknownHostException -> 0x02e0, TryCatch #43 {UnknownHostException -> 0x02e0, IOException -> 0x02cd, Exception -> 0x02bf, all -> 0x02ac, blocks: (B:344:0x02a7, B:65:0x02f8, B:75:0x0317, B:77:0x031c, B:78:0x032b, B:79:0x0335, B:88:0x033b, B:81:0x033f, B:83:0x034b, B:197:0x0324), top: B:343:0x02a7 }] */
            /* JADX WARN: Removed duplicated region for block: B:87:0x033b A[EDGE_INSN: B:87:0x033b->B:88:0x033b BREAK  A[LOOP:1: B:79:0x0335->B:85:0x034e], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:98:0x082e  */
            /* JADX WARN: Type inference failed for: r3v117 */
            /* JADX WARN: Type inference failed for: r3v118 */
            /* JADX WARN: Type inference failed for: r3v119 */
            /* JADX WARN: Type inference failed for: r3v120 */
            /* JADX WARN: Type inference failed for: r3v121 */
            /* JADX WARN: Type inference failed for: r3v122 */
            /* JADX WARN: Type inference failed for: r3v123 */
            /* JADX WARN: Type inference failed for: r3v55, types: [int] */
            /* JADX WARN: Type inference failed for: r3v56 */
            /* JADX WARN: Type inference failed for: r3v57 */
            /* JADX WARN: Type inference failed for: r3v58 */
            /* JADX WARN: Type inference failed for: r3v60 */
            /* JADX WARN: Type inference failed for: r3v74, types: [java.net.HttpURLConnection, java.net.URLConnection] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i5;
                Throwable th;
                String str9;
                HttpURLConnection httpURLConnection;
                HashMap hashMap;
                Exception exc;
                String str10;
                HttpURLConnection httpURLConnection2;
                BufferedInputStream bufferedInputStream;
                UnknownHostException unknownHostException;
                HttpURLConnection httpURLConnection3;
                HashMap hashMap2;
                HttpURLConnection httpURLConnection4;
                byte[] bArr2;
                boolean z3;
                HttpURLConnection httpURLConnection5;
                int i6;
                HttpURLConnection httpURLConnection6;
                HttpURLConnection httpURLConnection7;
                HttpURLConnection httpURLConnection8;
                boolean z4;
                int i7;
                int i8;
                int i9;
                HttpURLConnection httpURLConnection9;
                byte[] bArr3;
                BufferedInputStream bufferedInputStream2;
                HttpURLConnection httpURLConnection10;
                IOException iOException;
                HttpURLConnection httpURLConnection11;
                HttpRequestListener httpRequestListener2;
                HttpURLConnection httpURLConnection12;
                String message;
                int i10;
                HttpRequestListener httpRequestListener3;
                HttpURLConnection httpURLConnection13;
                HttpRequestListener httpRequestListener4;
                HttpURLConnection httpURLConnection14;
                HttpRequestListener httpRequestListener5;
                URL url;
                boolean z5;
                int i11;
                HttpURLConnection httpURLConnection15;
                HttpURLConnection httpURLConnection16;
                HttpURLConnection httpURLConnection17;
                HttpURLConnection httpURLConnection18;
                HttpURLConnection httpURLConnection19;
                HttpURLConnection httpURLConnection20;
                HttpsURLConnection httpsURLConnection;
                HttpURLConnection httpURLConnection21;
                HttpURLConnection httpURLConnection22;
                HttpURLConnection httpURLConnection23;
                Map map2;
                boolean z6;
                int i12;
                byte[] bArr4;
                boolean z7;
                boolean z8;
                int responseCode;
                int size;
                HashMap hashMap3;
                int contentLength;
                HttpRequestListener httpRequestListener6;
                OutputStream byteArrayOutputStream;
                BufferedInputStream bufferedInputStream3;
                InputStream byteArrayInputStream;
                byte[] bArr5;
                int read;
                URL url2;
                long uptimeMillis;
                InetAddress byName;
                int uptimeMillis2;
                HttpURLConnection httpURLConnection24;
                HttpURLConnection httpURLConnection25;
                HttpURLConnection httpURLConnection26;
                String str11 = str2;
                String str12 = "";
                if (str11.startsWith("https")) {
                    if (!HttpClient.mRollbackHttps2Http.equals(str8)) {
                        String unused = HttpClient.mRollbackHttps2Http = str8;
                        boolean unused2 = HttpClient.mNeedRollbackHttps2Http = HttpClient.needRollbackHttps2Http(str8);
                    }
                    if (HttpClient.mNeedRollbackHttps2Http) {
                        str11 = str2.replaceFirst("https", "http");
                    }
                }
                int i13 = 200;
                try {
                    try {
                        if (!z2) {
                            try {
                                url = new URL(str11);
                                str10 = "";
                                z5 = false;
                                i11 = 0;
                                i9 = 0;
                            } catch (UnknownHostException e) {
                                unknownHostException = e;
                                str9 = "";
                                httpURLConnection3 = null;
                                hashMap = null;
                                i5 = 200;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = false;
                                httpURLConnection7 = httpURLConnection3;
                                i6 = 0;
                                httpURLConnection10 = httpURLConnection7;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection14 = httpURLConnection10;
                                try {
                                    IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection14 != null) {
                                        httpURLConnection14.disconnect();
                                    }
                                    httpRequestListener5 = httpRequestListener;
                                    if (httpRequestListener5 == null) {
                                        if (z2) {
                                            httpRequestListener5.onStatistics(z3, i6, z4, i7, 0, str9, i9, i8);
                                        }
                                        httpRequestListener.onCompleted(404, hashMap, bArr2);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection13 = httpURLConnection14;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection13 != null) {
                                        httpURLConnection13.disconnect();
                                    }
                                    httpRequestListener4 = httpRequestListener;
                                    if (httpRequestListener4 == null) {
                                        if (z2) {
                                            httpRequestListener4.onStatistics(z3, i6, z4, i7, 0, str9, i9, i8);
                                        }
                                        httpRequestListener.onCompleted(i5, hashMap, bArr2);
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                str10 = "";
                                hashMap2 = null;
                                i5 = 200;
                                httpURLConnection4 = null;
                                bArr2 = null;
                                z3 = false;
                                i6 = 0;
                                z4 = false;
                                i7 = 0;
                                bufferedInputStream2 = null;
                                i8 = 0;
                                i9 = 0;
                                iOException = e;
                                try {
                                    IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                    message = iOException.getMessage();
                                    if (str2.startsWith("http")) {
                                        if (message.toLowerCase().contains("cleartext http traffic")) {
                                        }
                                    }
                                    i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                    if (bufferedInputStream2 != null) {
                                    }
                                    if (httpURLConnection4 != null) {
                                    }
                                    httpRequestListener3 = httpRequestListener;
                                    if (httpRequestListener3 == null) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    hashMap = hashMap2;
                                    httpURLConnection12 = httpURLConnection4;
                                    bufferedInputStream = bufferedInputStream2;
                                    str9 = str10;
                                    httpURLConnection13 = httpURLConnection12;
                                    if (bufferedInputStream != null) {
                                    }
                                    if (httpURLConnection13 != null) {
                                    }
                                    httpRequestListener4 = httpRequestListener;
                                    if (httpRequestListener4 == null) {
                                    }
                                }
                            } catch (Exception e5) {
                                exc = e5;
                                str10 = "";
                                httpURLConnection2 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                z3 = false;
                                httpURLConnection6 = httpURLConnection2;
                                i6 = 0;
                                httpURLConnection9 = httpURLConnection6;
                                z4 = false;
                                i7 = 0;
                                bArr3 = null;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection11 = httpURLConnection9;
                                try {
                                    IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                    try {
                                        byte[] bytes = Log.getStackTraceString(exc).getBytes();
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                        if (httpURLConnection11 != null) {
                                            httpURLConnection11.disconnect();
                                        }
                                        httpRequestListener2 = httpRequestListener;
                                        if (httpRequestListener2 == null) {
                                            if (z2) {
                                                httpRequestListener2.onStatistics(z3, i6, z4, i7, 0, str10, i9, i8);
                                            }
                                            httpRequestListener.onCompleted(BaseConstants.ERR_HTTP_REQ_FAILED, hashMap, bytes);
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        bArr2 = bArr3;
                                        str9 = str10;
                                        i5 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                        httpURLConnection13 = httpURLConnection11;
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection13 != null) {
                                        }
                                        httpRequestListener4 = httpRequestListener;
                                        if (httpRequestListener4 == null) {
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    i5 = i13;
                                    bArr2 = bArr3;
                                    httpURLConnection12 = httpURLConnection11;
                                    str9 = str10;
                                    httpURLConnection13 = httpURLConnection12;
                                    if (bufferedInputStream != null) {
                                    }
                                    if (httpURLConnection13 != null) {
                                    }
                                    httpRequestListener4 = httpRequestListener;
                                    if (httpRequestListener4 == null) {
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                str9 = "";
                                httpURLConnection = null;
                                hashMap = null;
                                i5 = 200;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = false;
                                httpURLConnection5 = httpURLConnection;
                                i6 = 0;
                                httpURLConnection8 = httpURLConnection5;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection13 = httpURLConnection8;
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection13 != null) {
                                }
                                httpRequestListener4 = httpRequestListener;
                                if (httpRequestListener4 == null) {
                                }
                            }
                        } else {
                            try {
                                url2 = new URL(str11);
                                uptimeMillis = SystemClock.uptimeMillis();
                                byName = InetAddress.getByName(url2.getHost());
                            } catch (IOException e7) {
                                e = e7;
                                i5 = 200;
                                str10 = "";
                                hashMap2 = null;
                                httpURLConnection4 = null;
                                bArr2 = null;
                                z3 = false;
                                i6 = 0;
                                z4 = false;
                                i7 = 0;
                                bufferedInputStream2 = null;
                                i8 = 0;
                                i9 = 0;
                                iOException = e;
                                IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                message = iOException.getMessage();
                                if (str2.startsWith("http") && message != null) {
                                    if (message.toLowerCase().contains("cleartext http traffic")) {
                                        i10 = BaseConstants.ERR_HTTP_NO_CLEARTEXT_TRAFFIC_PERMISSION;
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        if (httpURLConnection4 != null) {
                                            httpURLConnection4.disconnect();
                                        }
                                        httpRequestListener3 = httpRequestListener;
                                        if (httpRequestListener3 == null) {
                                            if (z2) {
                                                httpRequestListener3.onStatistics(z3, i6, z4, i7, 0, str10, i9, i8);
                                            }
                                            httpRequestListener.onCompleted(i10, hashMap2, bArr2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                if (bufferedInputStream2 != null) {
                                }
                                if (httpURLConnection4 != null) {
                                }
                                httpRequestListener3 = httpRequestListener;
                                if (httpRequestListener3 == null) {
                                }
                            }
                            try {
                                uptimeMillis2 = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                            } catch (UnknownHostException e9) {
                                i5 = 200;
                                unknownHostException = e9;
                                str9 = "";
                                httpURLConnection7 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = true;
                                i6 = 0;
                                httpURLConnection10 = httpURLConnection7;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection14 = httpURLConnection10;
                                IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection14 != null) {
                                }
                                httpRequestListener5 = httpRequestListener;
                                if (httpRequestListener5 == null) {
                                }
                            } catch (IOException e10) {
                                e = e10;
                                i5 = 200;
                                str10 = "";
                                hashMap2 = null;
                                httpURLConnection4 = null;
                                bArr2 = null;
                                z3 = true;
                                i6 = 0;
                                z4 = false;
                                i7 = 0;
                                bufferedInputStream2 = null;
                                i8 = 0;
                                i9 = 0;
                                iOException = e;
                                IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                message = iOException.getMessage();
                                if (str2.startsWith("http")) {
                                }
                                i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                if (bufferedInputStream2 != null) {
                                }
                                if (httpURLConnection4 != null) {
                                }
                                httpRequestListener3 = httpRequestListener;
                                if (httpRequestListener3 == null) {
                                }
                            } catch (Exception e11) {
                                exc = e11;
                                str10 = "";
                                httpURLConnection6 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                i13 = 200;
                                z3 = true;
                                i6 = 0;
                                httpURLConnection9 = httpURLConnection6;
                                z4 = false;
                                i7 = 0;
                                bArr3 = null;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection11 = httpURLConnection9;
                                IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                byte[] bytes2 = Log.getStackTraceString(exc).getBytes();
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection11 != null) {
                                }
                                httpRequestListener2 = httpRequestListener;
                                if (httpRequestListener2 == null) {
                                }
                            } catch (Throwable th7) {
                                i5 = 200;
                                th = th7;
                                str9 = "";
                                httpURLConnection5 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = true;
                                i6 = 0;
                                httpURLConnection8 = httpURLConnection5;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection13 = httpURLConnection8;
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection13 != null) {
                                }
                                httpRequestListener4 = httpRequestListener;
                                if (httpRequestListener4 == null) {
                                }
                            }
                            try {
                                str12 = byName.getHostAddress();
                                int port = url2.getPort();
                                if (-1 == port) {
                                    try {
                                        port = url2.getDefaultPort();
                                    } catch (UnknownHostException e12) {
                                        unknownHostException = e12;
                                        str9 = str12;
                                        i9 = port;
                                        i6 = uptimeMillis2;
                                        httpURLConnection26 = null;
                                        hashMap = null;
                                        i5 = 200;
                                        bufferedInputStream = null;
                                        bArr2 = null;
                                        z3 = true;
                                        httpURLConnection17 = httpURLConnection26;
                                        z4 = false;
                                        i7 = 0;
                                        httpURLConnection20 = httpURLConnection17;
                                        i8 = 0;
                                        httpURLConnection14 = httpURLConnection20;
                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection14 != null) {
                                        }
                                        httpRequestListener5 = httpRequestListener;
                                        if (httpRequestListener5 == null) {
                                        }
                                    } catch (IOException e13) {
                                        e = e13;
                                        str10 = str12;
                                        i9 = port;
                                        i6 = uptimeMillis2;
                                        hashMap2 = null;
                                        i5 = 200;
                                        httpURLConnection4 = null;
                                        bArr2 = null;
                                        z3 = true;
                                        z4 = false;
                                        i7 = 0;
                                        bufferedInputStream2 = null;
                                        i8 = 0;
                                        iOException = e;
                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                        message = iOException.getMessage();
                                        if (str2.startsWith("http")) {
                                        }
                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                        if (bufferedInputStream2 != null) {
                                        }
                                        if (httpURLConnection4 != null) {
                                        }
                                        httpRequestListener3 = httpRequestListener;
                                        if (httpRequestListener3 == null) {
                                        }
                                    } catch (Exception e14) {
                                        exc = e14;
                                        str10 = str12;
                                        i9 = port;
                                        i6 = uptimeMillis2;
                                        httpURLConnection25 = null;
                                        hashMap = null;
                                        bufferedInputStream = null;
                                        z3 = true;
                                        httpURLConnection16 = httpURLConnection25;
                                        z4 = false;
                                        i7 = 0;
                                        httpURLConnection19 = httpURLConnection16;
                                        bArr3 = null;
                                        i8 = 0;
                                        httpURLConnection11 = httpURLConnection19;
                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                        byte[] bytes22 = Log.getStackTraceString(exc).getBytes();
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection11 != null) {
                                        }
                                        httpRequestListener2 = httpRequestListener;
                                        if (httpRequestListener2 == null) {
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        str9 = str12;
                                        i9 = port;
                                        i6 = uptimeMillis2;
                                        httpURLConnection24 = null;
                                        hashMap = null;
                                        i5 = 200;
                                        bufferedInputStream = null;
                                        bArr2 = null;
                                        z3 = true;
                                        httpURLConnection15 = httpURLConnection24;
                                        z4 = false;
                                        i7 = 0;
                                        httpURLConnection18 = httpURLConnection15;
                                        i8 = 0;
                                        httpURLConnection13 = httpURLConnection18;
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection13 != null) {
                                        }
                                        httpRequestListener4 = httpRequestListener;
                                        if (httpRequestListener4 == null) {
                                        }
                                    }
                                }
                                try {
                                    str10 = str12;
                                    url = new URL(url2.getProtocol(), byName.getHostAddress(), url2.getPort(), url2.getFile());
                                    i9 = port;
                                    i11 = uptimeMillis2;
                                    z5 = true;
                                } catch (UnknownHostException e15) {
                                    i5 = 200;
                                    unknownHostException = e15;
                                    str9 = str12;
                                    i9 = port;
                                    i6 = uptimeMillis2;
                                    httpURLConnection26 = null;
                                    hashMap = null;
                                    bufferedInputStream = null;
                                    bArr2 = null;
                                    z3 = true;
                                    httpURLConnection17 = httpURLConnection26;
                                    z4 = false;
                                    i7 = 0;
                                    httpURLConnection20 = httpURLConnection17;
                                    i8 = 0;
                                    httpURLConnection14 = httpURLConnection20;
                                    IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                    if (bufferedInputStream != null) {
                                    }
                                    if (httpURLConnection14 != null) {
                                    }
                                    httpRequestListener5 = httpRequestListener;
                                    if (httpRequestListener5 == null) {
                                    }
                                } catch (IOException e16) {
                                    e = e16;
                                    i5 = 200;
                                    str10 = str12;
                                    i9 = port;
                                    i6 = uptimeMillis2;
                                    hashMap2 = null;
                                    httpURLConnection4 = null;
                                    bArr2 = null;
                                    z3 = true;
                                    z4 = false;
                                    i7 = 0;
                                    bufferedInputStream2 = null;
                                    i8 = 0;
                                    iOException = e;
                                    IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                    message = iOException.getMessage();
                                    if (str2.startsWith("http")) {
                                    }
                                    i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                    if (bufferedInputStream2 != null) {
                                    }
                                    if (httpURLConnection4 != null) {
                                    }
                                    httpRequestListener3 = httpRequestListener;
                                    if (httpRequestListener3 == null) {
                                    }
                                } catch (Exception e17) {
                                    exc = e17;
                                    str10 = str12;
                                    i9 = port;
                                    i6 = uptimeMillis2;
                                    httpURLConnection25 = null;
                                    hashMap = null;
                                    bufferedInputStream = null;
                                    i13 = 200;
                                    z3 = true;
                                    httpURLConnection16 = httpURLConnection25;
                                    z4 = false;
                                    i7 = 0;
                                    httpURLConnection19 = httpURLConnection16;
                                    bArr3 = null;
                                    i8 = 0;
                                    httpURLConnection11 = httpURLConnection19;
                                    IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                    byte[] bytes222 = Log.getStackTraceString(exc).getBytes();
                                    if (bufferedInputStream != null) {
                                    }
                                    if (httpURLConnection11 != null) {
                                    }
                                    httpRequestListener2 = httpRequestListener;
                                    if (httpRequestListener2 == null) {
                                    }
                                } catch (Throwable th9) {
                                    i5 = 200;
                                    th = th9;
                                    str9 = str12;
                                    i9 = port;
                                    i6 = uptimeMillis2;
                                    httpURLConnection24 = null;
                                    hashMap = null;
                                    bufferedInputStream = null;
                                    bArr2 = null;
                                    z3 = true;
                                    httpURLConnection15 = httpURLConnection24;
                                    z4 = false;
                                    i7 = 0;
                                    httpURLConnection18 = httpURLConnection15;
                                    i8 = 0;
                                    httpURLConnection13 = httpURLConnection18;
                                    if (bufferedInputStream != null) {
                                    }
                                    if (httpURLConnection13 != null) {
                                    }
                                    httpRequestListener4 = httpRequestListener;
                                    if (httpRequestListener4 == null) {
                                    }
                                }
                            } catch (UnknownHostException e18) {
                                i5 = 200;
                                unknownHostException = e18;
                                str9 = str12;
                                i6 = uptimeMillis2;
                                httpURLConnection10 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = true;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection14 = httpURLConnection10;
                                IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection14 != null) {
                                }
                                httpRequestListener5 = httpRequestListener;
                                if (httpRequestListener5 == null) {
                                }
                            } catch (IOException e19) {
                                e = e19;
                                i5 = 200;
                                str10 = str12;
                                i6 = uptimeMillis2;
                                hashMap2 = null;
                                httpURLConnection4 = null;
                                bArr2 = null;
                                z3 = true;
                                z4 = false;
                                i7 = 0;
                                bufferedInputStream2 = null;
                                i8 = 0;
                                i9 = 0;
                                iOException = e;
                                IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                message = iOException.getMessage();
                                if (str2.startsWith("http")) {
                                }
                                i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                if (bufferedInputStream2 != null) {
                                }
                                if (httpURLConnection4 != null) {
                                }
                                httpRequestListener3 = httpRequestListener;
                                if (httpRequestListener3 == null) {
                                }
                            } catch (Exception e20) {
                                exc = e20;
                                str10 = str12;
                                i6 = uptimeMillis2;
                                httpURLConnection9 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                i13 = 200;
                                z3 = true;
                                z4 = false;
                                i7 = 0;
                                bArr3 = null;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection11 = httpURLConnection9;
                                IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                byte[] bytes2222 = Log.getStackTraceString(exc).getBytes();
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection11 != null) {
                                }
                                httpRequestListener2 = httpRequestListener;
                                if (httpRequestListener2 == null) {
                                }
                            } catch (Throwable th10) {
                                i5 = 200;
                                th = th10;
                                str9 = str12;
                                i6 = uptimeMillis2;
                                httpURLConnection8 = null;
                                hashMap = null;
                                bufferedInputStream = null;
                                bArr2 = null;
                                z3 = true;
                                z4 = false;
                                i7 = 0;
                                i8 = 0;
                                i9 = 0;
                                httpURLConnection13 = httpURLConnection8;
                                if (bufferedInputStream != null) {
                                }
                                if (httpURLConnection13 != null) {
                                }
                                httpRequestListener4 = httpRequestListener;
                                if (httpRequestListener4 == null) {
                                }
                            }
                        }
                        try {
                            httpsURLConnection = i;
                            try {
                            } catch (UnknownHostException e21) {
                                unknownHostException = e21;
                                z3 = z5;
                                i6 = i11;
                                str9 = str10;
                                httpURLConnection23 = httpsURLConnection;
                            } catch (IOException e22) {
                                iOException = e22;
                                httpURLConnection4 = httpsURLConnection;
                                z3 = z5;
                                i6 = i11;
                                hashMap2 = null;
                                i5 = 200;
                            } catch (Exception e23) {
                                exc = e23;
                                z3 = z5;
                                i6 = i11;
                                httpURLConnection22 = httpsURLConnection;
                            } catch (Throwable th11) {
                                th = th11;
                                z3 = z5;
                                i6 = i11;
                                str9 = str10;
                                httpURLConnection21 = httpsURLConnection;
                            }
                        } catch (UnknownHostException e24) {
                            i5 = 200;
                            unknownHostException = e24;
                            z3 = z5;
                            i6 = i11;
                            str9 = str10;
                            HttpURLConnection httpURLConnection27 = null;
                        } catch (IOException e25) {
                            i5 = 200;
                            iOException = e25;
                            z3 = z5;
                            i6 = i11;
                            hashMap2 = null;
                        } catch (Exception e26) {
                            exc = e26;
                            z3 = z5;
                            i6 = i11;
                            HttpURLConnection httpURLConnection28 = null;
                        } catch (Throwable th12) {
                            i5 = 200;
                            th = th12;
                            z3 = z5;
                            i6 = i11;
                            str9 = str10;
                            HttpURLConnection httpURLConnection29 = null;
                        }
                    } catch (IOException e27) {
                        e = e27;
                        i5 = 200;
                        str10 = "";
                        hashMap2 = null;
                        httpURLConnection4 = null;
                    }
                } catch (UnknownHostException e28) {
                    i5 = 200;
                    unknownHostException = e28;
                    str9 = "";
                    httpURLConnection3 = null;
                    hashMap = null;
                } catch (Exception e29) {
                    exc = e29;
                    str10 = "";
                    httpURLConnection2 = null;
                    hashMap = null;
                    bufferedInputStream = null;
                    i13 = 200;
                } catch (Throwable th13) {
                    i5 = 200;
                    th = th13;
                    str9 = "";
                    httpURLConnection = null;
                    hashMap = null;
                }
                try {
                    if (1 == httpsURLConnection) {
                        try {
                            if (!str5.isEmpty() && i2 != 0) {
                                HttpURLConnection httpURLConnection30 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str5, i2)));
                                httpsURLConnection = httpURLConnection30;
                                if (!str6.isEmpty()) {
                                    httpsURLConnection = httpURLConnection30;
                                    if (!str7.isEmpty()) {
                                        Authenticator.setDefault(new BasicAuthenticator(str6, str7));
                                        httpsURLConnection = httpURLConnection30;
                                    }
                                }
                                httpsURLConnection.setRequestMethod(str);
                                httpsURLConnection.setConnectTimeout(i3);
                                httpsURLConnection.setReadTimeout(i4);
                                httpsURLConnection.setUseCaches(false);
                                httpsURLConnection.setDoInput(true);
                                map2 = map;
                                if (map2 != null) {
                                    for (Map.Entry entry : map2.entrySet()) {
                                        httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                                if ((!z2 || z) && (httpsURLConnection instanceof HttpsURLConnection)) {
                                    final HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                                    httpsURLConnection2.setSSLSocketFactory(new SSLSocketFactory() { // from class: com.tencent.imsdk.common.HttpClient.1.1
                                        @Override // javax.net.ssl.SSLSocketFactory
                                        public Socket createSocket(Socket socket, String str13, int i14, boolean z9) throws IOException {
                                            String requestProperty = httpsURLConnection2.getRequestProperty("Host");
                                            SSLSocket sSLSocket = (SSLSocket) HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(socket, requestProperty, i14, z9);
                                            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                                            if (Build.VERSION.SDK_INT < 24) {
                                                if (!HttpClient.nativeSetHostname(sSLSocket, requestProperty)) {
                                                    IMLog.e(HttpClient.TAG, "setHostname failed");
                                                }
                                            } else {
                                                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                                                sSLParameters.setServerNames(Arrays.asList(b.a(requestProperty)));
                                                sSLSocket.setSSLParameters(sSLParameters);
                                            }
                                            return sSLSocket;
                                        }

                                        @Override // javax.net.ssl.SSLSocketFactory
                                        public String[] getDefaultCipherSuites() {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().getDefaultCipherSuites();
                                        }

                                        @Override // javax.net.ssl.SSLSocketFactory
                                        public String[] getSupportedCipherSuites() {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().getSupportedCipherSuites();
                                        }

                                        @Override // javax.net.SocketFactory
                                        public Socket createSocket(String str13, int i14) throws IOException, UnknownHostException {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str13, i14);
                                        }

                                        @Override // javax.net.SocketFactory
                                        public Socket createSocket(String str13, int i14, InetAddress inetAddress, int i15) throws IOException, UnknownHostException {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str13, i14, inetAddress, i15);
                                        }

                                        @Override // javax.net.SocketFactory
                                        public Socket createSocket(InetAddress inetAddress, int i14) throws IOException {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i14);
                                        }

                                        @Override // javax.net.SocketFactory
                                        public Socket createSocket(InetAddress inetAddress, int i14, InetAddress inetAddress2, int i15) throws IOException {
                                            return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i14, inetAddress2, i15);
                                        }
                                    });
                                    httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.imsdk.common.HttpClient.1.2
                                        @Override // javax.net.ssl.HostnameVerifier
                                        public boolean verify(String str13, SSLSession sSLSession) {
                                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(httpsURLConnection2.getRequestProperty("Host"), sSLSession);
                                        }
                                    });
                                }
                                if (z2) {
                                    z6 = false;
                                    i12 = 0;
                                } else {
                                    long uptimeMillis3 = SystemClock.uptimeMillis();
                                    httpsURLConnection.connect();
                                    i12 = (int) (SystemClock.uptimeMillis() - uptimeMillis3);
                                    z6 = true;
                                }
                                long uptimeMillis4 = SystemClock.uptimeMillis();
                                bArr4 = bArr;
                                if (bArr4 != null) {
                                    try {
                                        if (bArr4.length > 0) {
                                            z7 = true;
                                            String str13 = str3;
                                            z8 = str13 == null && str13.length() != 0;
                                            boolean z9 = !z7 || z8;
                                            if (!str.equalsIgnoreCase(SpdyRequest.GET_METHOD) && z9) {
                                                httpsURLConnection.setDoOutput(true);
                                                if (!z8) {
                                                    byteArrayInputStream = new FileInputStream(str3);
                                                } else {
                                                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                                                }
                                                int available = byteArrayInputStream.available();
                                                httpsURLConnection.setFixedLengthStreamingMode(available);
                                                bArr5 = new byte[4096];
                                                int i14 = 0;
                                                while (true) {
                                                    read = byteArrayInputStream.read(bArr5);
                                                    if (read >= 0) {
                                                        break;
                                                    }
                                                    i14 += read;
                                                    httpsURLConnection.getOutputStream().write(bArr5, 0, read);
                                                    HttpRequestListener httpRequestListener7 = httpRequestListener;
                                                    if (httpRequestListener7 != null) {
                                                        httpRequestListener7.onProgress(0, i14, available);
                                                    }
                                                }
                                                byteArrayInputStream.close();
                                            }
                                            responseCode = httpsURLConnection.getResponseCode();
                                            size = httpsURLConnection.getHeaderFields().size();
                                            if (size > 0) {
                                                hashMap3 = new HashMap();
                                                for (int i15 = 0; i15 < size; i15++) {
                                                    try {
                                                        hashMap3.put(httpsURLConnection.getHeaderFieldKey(i15), httpsURLConnection.getHeaderField(i15));
                                                    } catch (UnknownHostException e30) {
                                                        unknownHostException = e30;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        str9 = str10;
                                                        bufferedInputStream = null;
                                                        bArr2 = null;
                                                        httpURLConnection14 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection14 != null) {
                                                        }
                                                        httpRequestListener5 = httpRequestListener;
                                                        if (httpRequestListener5 == null) {
                                                        }
                                                    } catch (IOException e31) {
                                                        iOException = e31;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        z3 = z5;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bArr2 = null;
                                                        bufferedInputStream2 = null;
                                                        httpURLConnection4 = httpsURLConnection;
                                                        hashMap2 = hashMap3;
                                                        i6 = i11;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                                        message = iOException.getMessage();
                                                        if (str2.startsWith("http")) {
                                                        }
                                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                                        if (bufferedInputStream2 != null) {
                                                        }
                                                        if (httpURLConnection4 != null) {
                                                        }
                                                        httpRequestListener3 = httpRequestListener;
                                                        if (httpRequestListener3 == null) {
                                                        }
                                                    } catch (Exception e32) {
                                                        exc = e32;
                                                        i13 = responseCode;
                                                        i8 = i13;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = null;
                                                        bArr3 = null;
                                                        httpURLConnection11 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                        byte[] bytes22222 = Log.getStackTraceString(exc).getBytes();
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection11 != null) {
                                                        }
                                                        httpRequestListener2 = httpRequestListener;
                                                        if (httpRequestListener2 == null) {
                                                        }
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        str9 = str10;
                                                        bufferedInputStream = null;
                                                        bArr2 = null;
                                                        httpURLConnection13 = httpsURLConnection;
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection13 != null) {
                                                        }
                                                        httpRequestListener4 = httpRequestListener;
                                                        if (httpRequestListener4 == null) {
                                                        }
                                                    }
                                                }
                                            } else {
                                                hashMap3 = null;
                                            }
                                            contentLength = httpsURLConnection.getContentLength();
                                            if (contentLength == -1) {
                                                contentLength = 0;
                                            }
                                            String str14 = str4;
                                            boolean z10 = str14 == null && str14.length() != 0;
                                            if (responseCode == 200) {
                                                BufferedInputStream bufferedInputStream4 = new BufferedInputStream(httpsURLConnection.getInputStream());
                                                if (z10) {
                                                    try {
                                                        byteArrayOutputStream = new FileOutputStream(str4);
                                                    } catch (UnknownHostException e33) {
                                                        unknownHostException = e33;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        bufferedInputStream = bufferedInputStream4;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection14 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection14 != null) {
                                                        }
                                                        httpRequestListener5 = httpRequestListener;
                                                        if (httpRequestListener5 == null) {
                                                        }
                                                    } catch (IOException e34) {
                                                        iOException = e34;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        bufferedInputStream2 = bufferedInputStream4;
                                                        z3 = z5;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bArr2 = null;
                                                        httpURLConnection4 = httpsURLConnection;
                                                        hashMap2 = hashMap3;
                                                        i6 = i11;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                                        message = iOException.getMessage();
                                                        if (str2.startsWith("http")) {
                                                        }
                                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                                        if (bufferedInputStream2 != null) {
                                                        }
                                                        if (httpURLConnection4 != null) {
                                                        }
                                                        httpRequestListener3 = httpRequestListener;
                                                        if (httpRequestListener3 == null) {
                                                        }
                                                    } catch (Exception e35) {
                                                        exc = e35;
                                                        i8 = responseCode;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bArr3 = null;
                                                        bufferedInputStream = bufferedInputStream4;
                                                        i13 = i8;
                                                        httpURLConnection11 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                        byte[] bytes222222 = Log.getStackTraceString(exc).getBytes();
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection11 != null) {
                                                        }
                                                        httpRequestListener2 = httpRequestListener;
                                                        if (httpRequestListener2 == null) {
                                                        }
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        bufferedInputStream = bufferedInputStream4;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection13 = httpsURLConnection;
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection13 != null) {
                                                        }
                                                        httpRequestListener4 = httpRequestListener;
                                                        if (httpRequestListener4 == null) {
                                                        }
                                                    }
                                                } else {
                                                    try {
                                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                                    } catch (UnknownHostException e36) {
                                                        e = e36;
                                                        bufferedInputStream3 = bufferedInputStream4;
                                                        unknownHostException = e;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection14 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection14 != null) {
                                                        }
                                                        httpRequestListener5 = httpRequestListener;
                                                        if (httpRequestListener5 == null) {
                                                        }
                                                    } catch (IOException e37) {
                                                        e = e37;
                                                        bufferedInputStream3 = bufferedInputStream4;
                                                        iOException = e;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        z3 = z5;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream2 = bufferedInputStream3;
                                                        bArr2 = null;
                                                        httpURLConnection4 = httpsURLConnection;
                                                        hashMap2 = hashMap3;
                                                        i6 = i11;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                                        message = iOException.getMessage();
                                                        if (str2.startsWith("http")) {
                                                        }
                                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                                        if (bufferedInputStream2 != null) {
                                                        }
                                                        if (httpURLConnection4 != null) {
                                                        }
                                                        httpRequestListener3 = httpRequestListener;
                                                        if (httpRequestListener3 == null) {
                                                        }
                                                    } catch (Exception e38) {
                                                        e = e38;
                                                        bufferedInputStream3 = bufferedInputStream4;
                                                        exc = e;
                                                        i13 = responseCode;
                                                        i8 = i13;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        bArr3 = null;
                                                        httpURLConnection11 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                        byte[] bytes2222222 = Log.getStackTraceString(exc).getBytes();
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection11 != null) {
                                                        }
                                                        httpRequestListener2 = httpRequestListener;
                                                        if (httpRequestListener2 == null) {
                                                        }
                                                    } catch (Throwable th16) {
                                                        th = th16;
                                                        bufferedInputStream3 = bufferedInputStream4;
                                                        th = th;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection13 = httpsURLConnection;
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection13 != null) {
                                                        }
                                                        httpRequestListener4 = httpRequestListener;
                                                        if (httpRequestListener4 == null) {
                                                        }
                                                    }
                                                }
                                                byte[] bArr6 = new byte[4096];
                                                int i16 = 0;
                                                while (true) {
                                                    int read2 = bufferedInputStream4.read(bArr6);
                                                    if (read2 < 0) {
                                                        break;
                                                    }
                                                    i16 += read2;
                                                    bufferedInputStream3 = bufferedInputStream4;
                                                    try {
                                                        byteArrayOutputStream.write(bArr6, 0, read2);
                                                        HttpRequestListener httpRequestListener8 = httpRequestListener;
                                                        if (httpRequestListener8 != null) {
                                                            httpRequestListener8.onProgress(1, i16, contentLength);
                                                        }
                                                        bufferedInputStream4 = bufferedInputStream3;
                                                    } catch (UnknownHostException e39) {
                                                        e = e39;
                                                        unknownHostException = e;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection14 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection14 != null) {
                                                        }
                                                        httpRequestListener5 = httpRequestListener;
                                                        if (httpRequestListener5 == null) {
                                                        }
                                                    } catch (IOException e40) {
                                                        e = e40;
                                                        iOException = e;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        z3 = z5;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream2 = bufferedInputStream3;
                                                        bArr2 = null;
                                                        httpURLConnection4 = httpsURLConnection;
                                                        hashMap2 = hashMap3;
                                                        i6 = i11;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                                        message = iOException.getMessage();
                                                        if (str2.startsWith("http")) {
                                                        }
                                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                                        if (bufferedInputStream2 != null) {
                                                        }
                                                        if (httpURLConnection4 != null) {
                                                        }
                                                        httpRequestListener3 = httpRequestListener;
                                                        if (httpRequestListener3 == null) {
                                                        }
                                                    } catch (Exception e41) {
                                                        e = e41;
                                                        exc = e;
                                                        i13 = responseCode;
                                                        i8 = i13;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        bArr3 = null;
                                                        httpURLConnection11 = httpsURLConnection;
                                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                        byte[] bytes22222222 = Log.getStackTraceString(exc).getBytes();
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection11 != null) {
                                                        }
                                                        httpRequestListener2 = httpRequestListener;
                                                        if (httpRequestListener2 == null) {
                                                        }
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        th = th;
                                                        i5 = responseCode;
                                                        i8 = i5;
                                                        hashMap = hashMap3;
                                                        z3 = z5;
                                                        i6 = i11;
                                                        z4 = z6;
                                                        i7 = i12;
                                                        bufferedInputStream = bufferedInputStream3;
                                                        str9 = str10;
                                                        bArr2 = null;
                                                        httpURLConnection13 = httpsURLConnection;
                                                        if (bufferedInputStream != null) {
                                                        }
                                                        if (httpURLConnection13 != null) {
                                                        }
                                                        httpRequestListener4 = httpRequestListener;
                                                        if (httpRequestListener4 == null) {
                                                        }
                                                    }
                                                }
                                                if (z10) {
                                                    bArr2 = new byte[0];
                                                } else {
                                                    bArr2 = ((ByteArrayOutputStream) byteArrayOutputStream).toByteArray();
                                                }
                                                try {
                                                    byteArrayOutputStream.close();
                                                    bufferedInputStream2 = bufferedInputStream4;
                                                } catch (UnknownHostException e42) {
                                                    unknownHostException = e42;
                                                    i5 = responseCode;
                                                    i8 = i5;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    hashMap = hashMap3;
                                                    z3 = z5;
                                                    i6 = i11;
                                                    z4 = z6;
                                                    i7 = i12;
                                                    str9 = str10;
                                                    httpURLConnection14 = httpsURLConnection;
                                                    IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    if (httpURLConnection14 != null) {
                                                    }
                                                    httpRequestListener5 = httpRequestListener;
                                                    if (httpRequestListener5 == null) {
                                                    }
                                                } catch (IOException e43) {
                                                    iOException = e43;
                                                    i5 = responseCode;
                                                    i8 = i5;
                                                    bufferedInputStream2 = bufferedInputStream4;
                                                    z3 = z5;
                                                    z4 = z6;
                                                    i7 = i12;
                                                    httpURLConnection4 = httpsURLConnection;
                                                    hashMap2 = hashMap3;
                                                    i6 = i11;
                                                    IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                                    message = iOException.getMessage();
                                                    if (str2.startsWith("http")) {
                                                    }
                                                    i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                                    if (bufferedInputStream2 != null) {
                                                    }
                                                    if (httpURLConnection4 != null) {
                                                    }
                                                    httpRequestListener3 = httpRequestListener;
                                                    if (httpRequestListener3 == null) {
                                                    }
                                                } catch (Exception e44) {
                                                    exc = e44;
                                                    i8 = responseCode;
                                                    bArr3 = bArr2;
                                                    hashMap = hashMap3;
                                                    z3 = z5;
                                                    i6 = i11;
                                                    z4 = z6;
                                                    i7 = i12;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    i13 = i8;
                                                    httpURLConnection11 = httpsURLConnection;
                                                    IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                                    byte[] bytes222222222 = Log.getStackTraceString(exc).getBytes();
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    if (httpURLConnection11 != null) {
                                                    }
                                                    httpRequestListener2 = httpRequestListener;
                                                    if (httpRequestListener2 == null) {
                                                    }
                                                } catch (Throwable th18) {
                                                    th = th18;
                                                    i5 = responseCode;
                                                    i8 = i5;
                                                    bufferedInputStream = bufferedInputStream4;
                                                    hashMap = hashMap3;
                                                    z3 = z5;
                                                    i6 = i11;
                                                    z4 = z6;
                                                    i7 = i12;
                                                    httpURLConnection12 = httpsURLConnection;
                                                    str9 = str10;
                                                    httpURLConnection13 = httpURLConnection12;
                                                    if (bufferedInputStream != null) {
                                                    }
                                                    if (httpURLConnection13 != null) {
                                                    }
                                                    httpRequestListener4 = httpRequestListener;
                                                    if (httpRequestListener4 == null) {
                                                    }
                                                }
                                            } else {
                                                bArr2 = null;
                                                bufferedInputStream2 = null;
                                            }
                                            int uptimeMillis5 = (int) (SystemClock.uptimeMillis() - uptimeMillis4);
                                            if (bufferedInputStream2 != null) {
                                                try {
                                                    bufferedInputStream2.close();
                                                } catch (IOException e45) {
                                                    e45.printStackTrace();
                                                }
                                            }
                                            httpsURLConnection.disconnect();
                                            httpRequestListener6 = httpRequestListener;
                                            if (httpRequestListener6 != null) {
                                                if (z2) {
                                                    httpRequestListener6.onStatistics(z5, i11, z6, i12, uptimeMillis5, str10, i9, responseCode);
                                                }
                                                httpRequestListener.onCompleted(responseCode, hashMap3, bArr2);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (UnknownHostException e46) {
                                        unknownHostException = e46;
                                        z3 = z5;
                                        i6 = i11;
                                        z4 = z6;
                                        i7 = i12;
                                        str9 = str10;
                                        hashMap = null;
                                        i5 = 200;
                                        bufferedInputStream = null;
                                        bArr2 = null;
                                        httpURLConnection20 = httpsURLConnection;
                                        i8 = 0;
                                        httpURLConnection14 = httpURLConnection20;
                                        IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection14 != null) {
                                        }
                                        httpRequestListener5 = httpRequestListener;
                                        if (httpRequestListener5 == null) {
                                        }
                                    } catch (IOException e47) {
                                        iOException = e47;
                                        httpURLConnection4 = httpsURLConnection;
                                        z3 = z5;
                                        i6 = i11;
                                        z4 = z6;
                                        i7 = i12;
                                        hashMap2 = null;
                                        i5 = 200;
                                        bArr2 = null;
                                        bufferedInputStream2 = null;
                                        i8 = 0;
                                        IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                                        message = iOException.getMessage();
                                        if (str2.startsWith("http")) {
                                        }
                                        i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                                        if (bufferedInputStream2 != null) {
                                        }
                                        if (httpURLConnection4 != null) {
                                        }
                                        httpRequestListener3 = httpRequestListener;
                                        if (httpRequestListener3 == null) {
                                        }
                                    } catch (Exception e48) {
                                        exc = e48;
                                        z3 = z5;
                                        i6 = i11;
                                        z4 = z6;
                                        i7 = i12;
                                        hashMap = null;
                                        bufferedInputStream = null;
                                        httpURLConnection19 = httpsURLConnection;
                                        bArr3 = null;
                                        i8 = 0;
                                        httpURLConnection11 = httpURLConnection19;
                                        IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                                        byte[] bytes2222222222 = Log.getStackTraceString(exc).getBytes();
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection11 != null) {
                                        }
                                        httpRequestListener2 = httpRequestListener;
                                        if (httpRequestListener2 == null) {
                                        }
                                    } catch (Throwable th19) {
                                        th = th19;
                                        z3 = z5;
                                        i6 = i11;
                                        z4 = z6;
                                        i7 = i12;
                                        str9 = str10;
                                        hashMap = null;
                                        i5 = 200;
                                        bufferedInputStream = null;
                                        bArr2 = null;
                                        httpURLConnection18 = httpsURLConnection;
                                        i8 = 0;
                                        httpURLConnection13 = httpURLConnection18;
                                        if (bufferedInputStream != null) {
                                        }
                                        if (httpURLConnection13 != null) {
                                        }
                                        httpRequestListener4 = httpRequestListener;
                                        if (httpRequestListener4 == null) {
                                        }
                                    }
                                }
                                z7 = false;
                                String str132 = str3;
                                if (str132 == null) {
                                }
                                if (z7) {
                                }
                                if (!str.equalsIgnoreCase(SpdyRequest.GET_METHOD)) {
                                    httpsURLConnection.setDoOutput(true);
                                    if (!z8) {
                                    }
                                    int available2 = byteArrayInputStream.available();
                                    httpsURLConnection.setFixedLengthStreamingMode(available2);
                                    bArr5 = new byte[4096];
                                    int i142 = 0;
                                    while (true) {
                                        read = byteArrayInputStream.read(bArr5);
                                        if (read >= 0) {
                                        }
                                    }
                                    byteArrayInputStream.close();
                                }
                                responseCode = httpsURLConnection.getResponseCode();
                                size = httpsURLConnection.getHeaderFields().size();
                                if (size > 0) {
                                }
                                contentLength = httpsURLConnection.getContentLength();
                                if (contentLength == -1) {
                                }
                                String str142 = str4;
                                if (str142 == null) {
                                }
                                if (responseCode == 200) {
                                }
                                int uptimeMillis52 = (int) (SystemClock.uptimeMillis() - uptimeMillis4);
                                if (bufferedInputStream2 != null) {
                                }
                                httpsURLConnection.disconnect();
                                httpRequestListener6 = httpRequestListener;
                                if (httpRequestListener6 != null) {
                                }
                            }
                        } catch (UnknownHostException e49) {
                            unknownHostException = e49;
                            z3 = z5;
                            i6 = i11;
                            str9 = str10;
                            httpURLConnection23 = null;
                            hashMap = null;
                            i5 = 200;
                            HttpURLConnection httpURLConnection31 = httpURLConnection23;
                            bufferedInputStream = null;
                            bArr2 = null;
                            httpURLConnection17 = httpURLConnection31;
                            z4 = false;
                            i7 = 0;
                            httpURLConnection20 = httpURLConnection17;
                            i8 = 0;
                            httpURLConnection14 = httpURLConnection20;
                            IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection14 != null) {
                            }
                            httpRequestListener5 = httpRequestListener;
                            if (httpRequestListener5 == null) {
                            }
                        } catch (IOException e50) {
                            iOException = e50;
                            z3 = z5;
                            i6 = i11;
                            hashMap2 = null;
                            i5 = 200;
                            httpURLConnection4 = null;
                            bArr2 = null;
                            z4 = false;
                            i7 = 0;
                            bufferedInputStream2 = null;
                            i8 = 0;
                            IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                            message = iOException.getMessage();
                            if (str2.startsWith("http")) {
                            }
                            i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                            if (bufferedInputStream2 != null) {
                            }
                            if (httpURLConnection4 != null) {
                            }
                            httpRequestListener3 = httpRequestListener;
                            if (httpRequestListener3 == null) {
                            }
                        } catch (Exception e51) {
                            exc = e51;
                            z3 = z5;
                            i6 = i11;
                            httpURLConnection22 = null;
                            hashMap = null;
                            bufferedInputStream = null;
                            httpURLConnection16 = httpURLConnection22;
                            z4 = false;
                            i7 = 0;
                            httpURLConnection19 = httpURLConnection16;
                            bArr3 = null;
                            i8 = 0;
                            httpURLConnection11 = httpURLConnection19;
                            IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                            byte[] bytes22222222222 = Log.getStackTraceString(exc).getBytes();
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection11 != null) {
                            }
                            httpRequestListener2 = httpRequestListener;
                            if (httpRequestListener2 == null) {
                            }
                        } catch (Throwable th20) {
                            th = th20;
                            z3 = z5;
                            i6 = i11;
                            str9 = str10;
                            httpURLConnection21 = null;
                            hashMap = null;
                            i5 = 200;
                            HttpURLConnection httpURLConnection32 = httpURLConnection21;
                            bufferedInputStream = null;
                            bArr2 = null;
                            httpURLConnection15 = httpURLConnection32;
                            z4 = false;
                            i7 = 0;
                            httpURLConnection18 = httpURLConnection15;
                            i8 = 0;
                            httpURLConnection13 = httpURLConnection18;
                            if (bufferedInputStream != null) {
                            }
                            if (httpURLConnection13 != null) {
                            }
                            httpRequestListener4 = httpRequestListener;
                            if (httpRequestListener4 == null) {
                            }
                        }
                    }
                    int uptimeMillis522 = (int) (SystemClock.uptimeMillis() - uptimeMillis4);
                    if (bufferedInputStream2 != null) {
                    }
                    httpsURLConnection.disconnect();
                    httpRequestListener6 = httpRequestListener;
                    if (httpRequestListener6 != null) {
                    }
                } catch (UnknownHostException e52) {
                    unknownHostException = e52;
                    i5 = responseCode;
                    i8 = i5;
                    hashMap = hashMap3;
                    bufferedInputStream = bufferedInputStream2;
                    z3 = z5;
                    i6 = i11;
                    z4 = z6;
                    i7 = i12;
                    str9 = str10;
                    httpURLConnection14 = httpsURLConnection;
                    IMLog.e(HttpClient.TAG, "http request failed." + unknownHostException.getLocalizedMessage());
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection14 != null) {
                    }
                    httpRequestListener5 = httpRequestListener;
                    if (httpRequestListener5 == null) {
                    }
                } catch (IOException e53) {
                    iOException = e53;
                    i5 = responseCode;
                    i8 = i5;
                    z3 = z5;
                    z4 = z6;
                    i7 = i12;
                    httpURLConnection4 = httpsURLConnection;
                    hashMap2 = hashMap3;
                    i6 = i11;
                    IMLog.e(HttpClient.TAG, "http request failed." + iOException.getLocalizedMessage());
                    message = iOException.getMessage();
                    if (str2.startsWith("http")) {
                    }
                    i10 = BaseConstants.ERR_HTTP_REQ_FAILED;
                    if (bufferedInputStream2 != null) {
                    }
                    if (httpURLConnection4 != null) {
                    }
                    httpRequestListener3 = httpRequestListener;
                    if (httpRequestListener3 == null) {
                    }
                } catch (Exception e54) {
                    exc = e54;
                    i13 = responseCode;
                    i8 = i13;
                    hashMap = hashMap3;
                    bufferedInputStream = bufferedInputStream2;
                    z3 = z5;
                    i6 = i11;
                    z4 = z6;
                    i7 = i12;
                    bArr3 = bArr2;
                    httpURLConnection11 = httpsURLConnection;
                    IMLog.e(HttpClient.TAG, "http request failed." + exc.getLocalizedMessage());
                    byte[] bytes222222222222 = Log.getStackTraceString(exc).getBytes();
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection11 != null) {
                    }
                    httpRequestListener2 = httpRequestListener;
                    if (httpRequestListener2 == null) {
                    }
                } catch (Throwable th21) {
                    th = th21;
                    i5 = responseCode;
                    i8 = i5;
                    hashMap = hashMap3;
                    bufferedInputStream = bufferedInputStream2;
                    z3 = z5;
                    i6 = i11;
                    z4 = z6;
                    i7 = i12;
                    httpURLConnection12 = httpsURLConnection;
                    str9 = str10;
                    httpURLConnection13 = httpURLConnection12;
                    if (bufferedInputStream != null) {
                    }
                    if (httpURLConnection13 != null) {
                    }
                    httpRequestListener4 = httpRequestListener;
                    if (httpRequestListener4 == null) {
                    }
                }
                if (2 == i && !str5.isEmpty() && i2 != 0) {
                    HttpURLConnection httpURLConnection33 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str5, i2)));
                    httpsURLConnection = httpURLConnection33;
                    if (!str6.isEmpty()) {
                        httpsURLConnection = httpURLConnection33;
                        if (!str7.isEmpty()) {
                            Authenticator.setDefault(new BasicAuthenticator(str6, str7));
                            httpsURLConnection = httpURLConnection33;
                        }
                    }
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                httpsURLConnection.setRequestMethod(str);
                httpsURLConnection.setConnectTimeout(i3);
                httpsURLConnection.setReadTimeout(i4);
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                map2 = map;
                if (map2 != null) {
                }
                if (!z2) {
                }
                final HttpsURLConnection httpsURLConnection22 = httpsURLConnection;
                httpsURLConnection22.setSSLSocketFactory(new SSLSocketFactory() { // from class: com.tencent.imsdk.common.HttpClient.1.1
                    @Override // javax.net.ssl.SSLSocketFactory
                    public Socket createSocket(Socket socket, String str133, int i143, boolean z92) throws IOException {
                        String requestProperty = httpsURLConnection22.getRequestProperty("Host");
                        SSLSocket sSLSocket = (SSLSocket) HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(socket, requestProperty, i143, z92);
                        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                        if (Build.VERSION.SDK_INT < 24) {
                            if (!HttpClient.nativeSetHostname(sSLSocket, requestProperty)) {
                                IMLog.e(HttpClient.TAG, "setHostname failed");
                            }
                        } else {
                            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                            sSLParameters.setServerNames(Arrays.asList(b.a(requestProperty)));
                            sSLSocket.setSSLParameters(sSLParameters);
                        }
                        return sSLSocket;
                    }

                    @Override // javax.net.ssl.SSLSocketFactory
                    public String[] getDefaultCipherSuites() {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().getDefaultCipherSuites();
                    }

                    @Override // javax.net.ssl.SSLSocketFactory
                    public String[] getSupportedCipherSuites() {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().getSupportedCipherSuites();
                    }

                    @Override // javax.net.SocketFactory
                    public Socket createSocket(String str133, int i143) throws IOException, UnknownHostException {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str133, i143);
                    }

                    @Override // javax.net.SocketFactory
                    public Socket createSocket(String str133, int i143, InetAddress inetAddress, int i152) throws IOException, UnknownHostException {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str133, i143, inetAddress, i152);
                    }

                    @Override // javax.net.SocketFactory
                    public Socket createSocket(InetAddress inetAddress, int i143) throws IOException {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i143);
                    }

                    @Override // javax.net.SocketFactory
                    public Socket createSocket(InetAddress inetAddress, int i143, InetAddress inetAddress2, int i152) throws IOException {
                        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i143, inetAddress2, i152);
                    }
                });
                httpsURLConnection22.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.imsdk.common.HttpClient.1.2
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str133, SSLSession sSLSession) {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(httpsURLConnection22.getRequestProperty("Host"), sSLSession);
                    }
                });
                if (z2) {
                }
                long uptimeMillis42 = SystemClock.uptimeMillis();
                bArr4 = bArr;
                if (bArr4 != null) {
                }
                z7 = false;
                String str1322 = str3;
                if (str1322 == null) {
                }
                if (z7) {
                }
                if (!str.equalsIgnoreCase(SpdyRequest.GET_METHOD)) {
                }
                responseCode = httpsURLConnection.getResponseCode();
                size = httpsURLConnection.getHeaderFields().size();
                if (size > 0) {
                }
                contentLength = httpsURLConnection.getContentLength();
                if (contentLength == -1) {
                }
                String str1422 = str4;
                if (str1422 == null) {
                }
                if (responseCode == 200) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProgressCallback(int i, int i2, int i3, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeResponseCallback(int i, String[] strArr, String[] strArr2, byte[] bArr, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeSetHostname(Socket socket, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeStatisticsCallback(boolean z, int i, boolean z2, int i2, int i3, String str, int i4, int i5, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needRollbackHttps2Http(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String str2 = "";
            if (SystemUtil.isBrandOppo()) {
                str2 = AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO;
            } else if (SystemUtil.isBrandVivo()) {
                str2 = AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO;
            } else if (SystemUtil.isBrandHuawei()) {
                str2 = AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI;
            } else if (SystemUtil.isBrandXiaoMi()) {
                str2 = AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI;
            } else if (SystemUtil.isBrandMeizu()) {
                str2 = AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(Constants.KEY_BRAND);
                int i2 = jSONObject.getInt("below_version");
                if (str2.equals(string)) {
                    if (SystemUtil.getSDKVersion() > i2) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void httpRequest(String str, String str2, boolean z, String[] strArr, String[] strArr2, byte[] bArr, String str3, String str4, int i, String str5, int i2, String str6, String str7, int i3, int i4, String str8, boolean z2, final long j) {
        HashMap hashMap;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i5 = 0; i5 < strArr.length; i5++) {
                hashMap.put(strArr[i5], strArr2[i5]);
            }
        }
        httpRequest(str, str2, z, hashMap, bArr, str3, str4, i, str5, i2, str6, str7, i3, i4, str8, z2, new HttpRequestListener() { // from class: com.tencent.imsdk.common.HttpClient.2
            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onCompleted(int i6, Map<String, String> map, byte[] bArr2) {
                String[] strArr3;
                String[] strArr4;
                if (j != 0) {
                    if (map != null) {
                        String[] strArr5 = new String[map.size()];
                        String[] strArr6 = new String[map.size()];
                        int i7 = 0;
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            strArr5[i7] = entry.getKey();
                            strArr6[i7] = entry.getValue();
                            i7++;
                        }
                        strArr3 = strArr5;
                        strArr4 = strArr6;
                    } else {
                        strArr3 = null;
                        strArr4 = null;
                    }
                    HttpClient.nativeResponseCallback(i6, strArr3, strArr4, bArr2, j);
                }
            }

            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onProgress(int i6, int i7, int i8) {
                long j2 = j;
                if (j2 != 0) {
                    HttpClient.nativeProgressCallback(i6, i7, i8, j2);
                }
            }

            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onStatistics(boolean z3, int i6, boolean z4, int i7, int i8, String str9, int i9, int i10) {
                long j2 = j;
                if (j2 != 0) {
                    HttpClient.nativeStatisticsCallback(z3, i6, z4, i7, i8, str9, i9, i10, j2);
                }
            }
        });
    }
}
