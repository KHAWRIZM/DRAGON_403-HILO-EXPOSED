package com.alibaba.sdk.android.tbrest.request;

import android.text.TextUtils;
import anet.channel.request.Request;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.MD5Utils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UrlWrapper {
    private static final int MAX_CONNECTION_TIME_OUT = 10000;
    private static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 60000;
    public static int mErrorCode;
    private static a mRestSslSocketFactory;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BizResponse sendRequest(SendService sendService, String str, String str2, byte[] bArr) {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        StringBuilder sb = new StringBuilder();
        sb.append("sendRequest use adashx, bytes length : ");
        sb.append(bArr == null ? "0" : Integer.valueOf(bArr.length));
        LogUtil.d(sb.toString());
        BizResponse bizResponse = new BizResponse();
        try {
            URL url = new URL(str2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    if (mRestSslSocketFactory == null && !TextUtils.isEmpty(url.getHost())) {
                        mRestSslSocketFactory = new a(url.getHost());
                    }
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(mRestSslSocketFactory);
                } catch (IllegalStateException unused) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(Request.Method.POST);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnection.setRequestProperty("x-k", str);
                }
                try {
                    String str3 = sendService.appSecret;
                    if (str3 != null && str3.length() > 0) {
                        String b10 = new com.alibaba.sdk.android.tbrest.a.a(str, str3, true).b(MD5Utils.getMd5Hex(bArr));
                        LogUtil.d("signValue:" + b10);
                        httpURLConnection.setRequestProperty("x-s", b10);
                        httpURLConnection.setRequestProperty("x-t", "2");
                    } else {
                        String b11 = new com.alibaba.sdk.android.tbrest.a.a(str, "", false).b(MD5Utils.getMd5Hex(bArr));
                        LogUtil.d("signValue:" + b11);
                        httpURLConnection.setRequestProperty("x-s", b11);
                        httpURLConnection.setRequestProperty("x-t", "3");
                    }
                } catch (Throwable th) {
                    LogUtil.e(th.toString());
                }
                long currentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                r1 = null;
                DataInputStream dataInputStream2 = null;
                DataOutputStream dataOutputStream3 = null;
                DataOutputStream dataOutputStream4 = null;
                try {
                    try {
                        httpURLConnection.connect();
                        if (bArr == null || bArr.length <= 0) {
                            dataOutputStream = null;
                        } else {
                            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                            } catch (SSLHandshakeException e10) {
                                e = e10;
                                dataOutputStream4 = dataOutputStream;
                                LogUtil.e(e.toString());
                                bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream4 != null) {
                                    try {
                                        dataOutputStream4.close();
                                    } catch (IOException e11) {
                                        LogUtil.e(e11.toString());
                                    }
                                }
                                return bizResponse;
                            } catch (Exception e12) {
                                e = e12;
                                dataOutputStream2 = dataOutputStream;
                                LogUtil.e(e.toString());
                                bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e13) {
                                        LogUtil.e(e13.toString());
                                    }
                                }
                                return bizResponse;
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream3 = dataOutputStream;
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e14) {
                                        LogUtil.e(e14.toString());
                                    }
                                }
                                throw th;
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e15) {
                                LogUtil.e(e15.toString());
                            }
                        }
                        bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            try {
                                try {
                                    dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                                } catch (Exception e16) {
                                    LogUtil.e(e16.toString());
                                }
                            } catch (IOException e17) {
                                e = e17;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            byte[] bArr2 = new byte[2048];
                            while (true) {
                                int read = dataInputStream.read(bArr2, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            dataInputStream.close();
                        } catch (IOException e18) {
                            e = e18;
                            dataInputStream2 = dataInputStream;
                            LogUtil.e(e.toString());
                            if (dataInputStream2 != null) {
                                dataInputStream2.close();
                            }
                            if (byteArrayOutputStream.size() > 0) {
                            }
                            return bizResponse;
                        } catch (Throwable th4) {
                            th = th4;
                            dataInputStream2 = dataInputStream;
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Exception e19) {
                                    LogUtil.e(e19.toString());
                                }
                            }
                            throw th;
                        }
                        if (byteArrayOutputStream.size() > 0) {
                            int parseResult = BizRequest.parseResult(byteArrayOutputStream.toByteArray());
                            mErrorCode = parseResult;
                            bizResponse.errCode = parseResult;
                            bizResponse.data = BizRequest.mResponseAdditionalData;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (SSLHandshakeException e20) {
                    e = e20;
                } catch (Exception e21) {
                    e = e21;
                }
            }
        } catch (MalformedURLException | ProtocolException | IOException unused2) {
        }
        return bizResponse;
    }

    public static BizResponse sendRequestByUrl(SendService sendService, String str, byte[] bArr) {
        return sendRequest(sendService, sendService.appKey, str, bArr);
    }

    public static BizResponse sendRequest(SendService sendService, String str, byte[] bArr) {
        String str2;
        String str3 = sendService.appKey;
        if (sendService.openHttp.booleanValue()) {
            str2 = "http://" + str + "/upload";
        } else {
            str2 = "https://" + str + "/upload";
        }
        return sendRequest(sendService, str3, str2, bArr);
    }
}
