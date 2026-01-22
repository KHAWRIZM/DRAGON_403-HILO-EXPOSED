package com.ta.a.b;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import org.android.spdy.SpdyRequest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    private static d a;

    /* renamed from: a, reason: collision with other field name */
    private static f f٢a;

    static {
        System.setProperty("http.keepAlive", "true");
        f٢a = null;
        a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, String str2, boolean z) {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataInputStream dataInputStream;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            URL url = new URL(str);
            if (TextUtils.isEmpty(url.getHost())) {
                return aVar;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (f٢a == null) {
                    f٢a = new f(url.getHost());
                }
                if (a == null) {
                    a = new d(url.getHost());
                }
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(f٢a);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a);
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoInput(true);
                if (z) {
                    httpURLConnection.setDoOutput(true);
                    try {
                        httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
                    } catch (ProtocolException e) {
                        com.ta.a.c.f.a("", e, new Object[0]);
                        return aVar;
                    }
                } else {
                    try {
                        httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                    } catch (ProtocolException e2) {
                        com.ta.a.c.f.a("", e2, new Object[0]);
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                StringBuilder sb2 = new StringBuilder();
                httpURLConnection.setRequestProperty("x-audid-appkey", "");
                String packageName = com.ta.a.a.a().getContext().getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    try {
                        httpURLConnection.setRequestProperty("x-audid-appname", URLEncoder.encode(packageName, "UTF-8"));
                        sb2.append(packageName);
                    } catch (Exception unused) {
                    }
                }
                httpURLConnection.setRequestProperty("x-audid-sdk", "2.5.3-mini");
                sb2.append("2.5.3-mini");
                String str3 = com.ta.a.a.a().m١٢٤a();
                httpURLConnection.setRequestProperty("x-audid-timestamp", str3);
                com.ta.a.c.f.m١٢٧a("", "timestamp:" + str3);
                sb2.append(str3);
                sb2.append(str2);
                httpURLConnection.setRequestProperty(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, com.ta.utdid2.a.a.a.encodeToString(com.ta.a.c.b.d(sb2.toString()).getBytes(), 2));
                long currentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                DataInputStream dataInputStream2 = null;
                DataInputStream dataInputStream3 = null;
                try {
                    httpURLConnection.connect();
                    if (str2 != null && str2.length() > 0) {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.writeBytes(str2);
                            dataOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                            try {
                                com.ta.a.c.f.m١٢٧a("", th);
                                aVar.b = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e3) {
                                        com.ta.a.c.f.m١٢٧a("", e3);
                                    }
                                }
                                return aVar;
                            } finally {
                            }
                        }
                    } else {
                        dataOutputStream = null;
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e4) {
                            com.ta.a.c.f.m١٢٧a("", e4);
                        }
                    }
                    try {
                        aVar.a = httpURLConnection.getResponseCode();
                        aVar.f١a = httpURLConnection.getHeaderField(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE);
                    } catch (Exception e5) {
                        com.ta.a.c.f.m١٢٧a("", e5);
                    }
                    try {
                        aVar.timestamp = Long.parseLong(httpURLConnection.getHeaderField("x-audid-timestamp"));
                        com.ta.a.c.f.m١٢٧a("", "repsonse.timestamp:" + aVar.timestamp);
                        long j = com.ta.a.a.a().m١٢٣a();
                        long j2 = aVar.timestamp;
                        if (j2 > 0 && (j2 > j + 1800000 || j2 < j - 1800000)) {
                            com.ta.a.a.a().a(aVar.timestamp);
                        }
                    } catch (Exception unused2) {
                    }
                    aVar.b = System.currentTimeMillis() - currentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        } catch (Throwable th3) {
                            th = th3;
                            if (dataInputStream2 == null) {
                                try {
                                    dataInputStream2.close();
                                    throw th;
                                } catch (Exception e6) {
                                    com.ta.a.c.f.m١٢٧a("", e6);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        try {
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = dataInputStream.read(bArr, 0, 2048);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e7) {
                                            com.ta.a.c.f.m١٢٧a("", e7);
                                        }
                                    }
                                }
                                dataInputStream.close();
                            } catch (IOException e8) {
                                e = e8;
                                dataInputStream3 = dataInputStream;
                                com.ta.a.c.f.m١٢٧a("", e);
                                try {
                                    dataInputStream = new DataInputStream(httpURLConnection.getErrorStream());
                                } catch (Exception e9) {
                                    e = e9;
                                }
                                try {
                                    byte[] bArr2 = new byte[2048];
                                    while (true) {
                                        int read2 = dataInputStream.read(bArr2, 0, 2048);
                                        if (read2 != -1) {
                                            byteArrayOutputStream.write(bArr2, 0, read2);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e10) {
                                                com.ta.a.c.f.m١٢٧a("", e10);
                                            }
                                        }
                                    }
                                    dataInputStream.close();
                                    if (byteArrayOutputStream.size() > 0) {
                                    }
                                    return aVar;
                                } catch (Exception e11) {
                                    e = e11;
                                    dataInputStream3 = dataInputStream;
                                    com.ta.a.c.f.m١٢٧a("", e);
                                    if (dataInputStream3 != null) {
                                        try {
                                            dataInputStream3.close();
                                        } catch (Exception e12) {
                                            com.ta.a.c.f.m١٢٧a("", e12);
                                        }
                                    }
                                    return aVar;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            dataInputStream2 = dataInputStream;
                            if (dataInputStream2 == null) {
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                    }
                    if (byteArrayOutputStream.size() > 0) {
                        aVar.data = byteArrayOutputStream.toByteArray();
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            return aVar;
        } catch (MalformedURLException e14) {
            com.ta.a.c.f.a("", e14, new Object[0]);
            return aVar;
        } catch (IOException e15) {
            com.ta.a.c.f.a("", e15, new Object[0]);
            return aVar;
        } catch (Throwable th6) {
            com.ta.a.c.f.a("", th6, new Object[0]);
            return aVar;
        }
    }
}
