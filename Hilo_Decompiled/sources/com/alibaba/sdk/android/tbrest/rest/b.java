package com.alibaba.sdk.android.tbrest.rest;

import anet.channel.request.Request;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.StringUtils;
import com.amazonaws.services.s3.Headers;
import com.google.android.gms.appinvite.PreviewActivity;
import com.oudi.utils.date.DateUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:113:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01cf A[Catch: all -> 0x01d3, IOException -> 0x01d7, LOOP:0: B:40:0x01c8->B:42:0x01cf, LOOP_END, TRY_LEAVE, TryCatch #0 {IOException -> 0x01d7, blocks: (B:39:0x01c5, B:40:0x01c8, B:42:0x01cf), top: B:38:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d9 A[EDGE_INSN: B:43:0x01d9->B:44:0x01d9 BREAK  A[LOOP:0: B:40:0x01c8->B:42:0x01cf], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(int i10, String str, Map<String, Object> map, boolean z10) {
        byte[] bArr;
        byte[] bArr2;
        int i11;
        Throwable th;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        InputStream gZIPInputStream;
        Throwable th2;
        InputStream inputStream;
        InputStream inputStream2;
        byte[] bArr3;
        int read;
        char c10 = 0;
        String str2 = "connection error!";
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
            } catch (IOException e10) {
                LogUtil.e("connection error!", e10);
                return null;
            }
        } catch (MalformedURLException e11) {
            e = e11;
            bArr = null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                return null;
            }
            if (i10 == 2 || i10 == 3) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setDoInput(true);
            try {
                if (i10 != 2 && i10 != 3) {
                    httpURLConnection.setRequestMethod(Request.Method.GET);
                } else {
                    httpURLConnection.setRequestMethod(Request.Method.POST);
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(DateUtils.MINUTE);
                str2 = PreviewActivity.ON_CLICK_LISTENER_CLOSE;
                httpURLConnection.setRequestProperty(Headers.CONNECTION, PreviewActivity.ON_CLICK_LISTENER_CLOSE);
                if (z10) {
                    httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, "gzip,deflate");
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                if (i10 != 2 && i10 != 3) {
                    bArr2 = null;
                } else {
                    if (i10 == 2) {
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                    } else if (i10 == 3) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    if (map != null && map.size() > 0) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Set<String> keySet = map.keySet();
                        String[] strArr = new String[keySet.size()];
                        keySet.toArray(strArr);
                        String[] a10 = c.a().a(strArr, true);
                        int length = a10.length;
                        int i12 = 0;
                        while (i12 < length) {
                            String str3 = a10[i12];
                            if (i10 == 2) {
                                byte[] bArr4 = (byte[]) map.get(str3);
                                if (bArr4 != null) {
                                    try {
                                        Object[] objArr = new Object[2];
                                        objArr[c10] = str3;
                                        objArr[1] = str3;
                                        byteArrayOutputStream.write(String.format("--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n", objArr).getBytes());
                                        byteArrayOutputStream.write(bArr4);
                                        byteArrayOutputStream.write("\r\n".getBytes());
                                    } catch (IOException e12) {
                                        LogUtil.e("write lBaos error!", e12);
                                    }
                                }
                            } else if (i10 == 3) {
                                String str4 = (String) map.get(str3);
                                if (byteArrayOutputStream.size() > 0) {
                                    try {
                                        byteArrayOutputStream.write((DispatchConstants.SIGN_SPLIT_SYMBOL + str3 + "=" + str4).getBytes());
                                    } catch (IOException e13) {
                                        LogUtil.e("write lBaos error!", e13);
                                    }
                                } else {
                                    try {
                                        byteArrayOutputStream.write((str3 + "=" + str4).getBytes());
                                    } catch (IOException e14) {
                                        LogUtil.e("write lBaos error!", e14);
                                    }
                                }
                            }
                            i12++;
                            c10 = 0;
                        }
                        if (i10 == 2) {
                            try {
                                byteArrayOutputStream.write("--GJircTeP--\r\n".getBytes());
                            } catch (IOException e15) {
                                LogUtil.e("write lBaos error!", e15);
                            }
                        }
                        bArr2 = byteArrayOutputStream.toByteArray();
                    } else {
                        bArr2 = null;
                    }
                    if (bArr2 != null) {
                        i11 = bArr2.length;
                    } else {
                        i11 = 0;
                    }
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i11));
                }
                try {
                    httpURLConnection.connect();
                    if ((i10 == 2 || i10 == 3) && bArr2 != null && bArr2.length > 0) {
                        dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            try {
                                dataOutputStream2.write(bArr2);
                                dataOutputStream2.flush();
                            } catch (Exception e16) {
                                e = e16;
                                LogUtil.e("write out error!", e);
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                        return null;
                                    } catch (IOException e17) {
                                        LogUtil.e("out close error!", e17);
                                        return null;
                                    }
                                }
                                return null;
                            }
                        } catch (Throwable th3) {
                            dataOutputStream = dataOutputStream2;
                            th = th3;
                            if (dataOutputStream == null) {
                                try {
                                    dataOutputStream.close();
                                    throw th;
                                } catch (IOException e18) {
                                    LogUtil.e("out close error!", e18);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } else {
                        dataOutputStream2 = null;
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e19) {
                            LogUtil.e("out close error!", e19);
                        }
                    }
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        try {
                            if (z10) {
                                try {
                                    if (HttpConstant.GZIP.equals(httpURLConnection.getContentEncoding())) {
                                        gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                                        inputStream2 = gZIPInputStream;
                                        bArr3 = new byte[2048];
                                        while (true) {
                                            read = inputStream2.read(bArr3, 0, 2048);
                                            if (read == -1) {
                                                byteArrayOutputStream2.write(bArr3, 0, read);
                                            } else {
                                                try {
                                                    break;
                                                } catch (Exception e20) {
                                                    LogUtil.e("out close error!", e20);
                                                }
                                            }
                                        }
                                        inputStream2.close();
                                        if (byteArrayOutputStream2.size() <= 0) {
                                            return byteArrayOutputStream2.toByteArray();
                                        }
                                        return null;
                                    }
                                } catch (IOException e21) {
                                    e = e21;
                                    inputStream2 = null;
                                    LogUtil.e("write out error!", e);
                                    if (inputStream2 == null) {
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    inputStream = null;
                                    if (inputStream == null) {
                                    }
                                }
                            }
                            bArr3 = new byte[2048];
                            while (true) {
                                read = inputStream2.read(bArr3, 0, 2048);
                                if (read == -1) {
                                }
                                byteArrayOutputStream2.write(bArr3, 0, read);
                            }
                            inputStream2.close();
                            if (byteArrayOutputStream2.size() <= 0) {
                            }
                        } catch (IOException e22) {
                            e = e22;
                            LogUtil.e("write out error!", e);
                            if (inputStream2 == null) {
                                try {
                                    inputStream2.close();
                                    return null;
                                } catch (Exception e23) {
                                    LogUtil.e("out close error!", e23);
                                    return null;
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        inputStream = inputStream2;
                        if (inputStream == null) {
                            try {
                                inputStream.close();
                                throw th2;
                            } catch (Exception e24) {
                                LogUtil.e("out close error!", e24);
                                throw th2;
                            }
                        }
                        throw th2;
                    }
                    gZIPInputStream = new DataInputStream(httpURLConnection.getInputStream());
                    inputStream2 = gZIPInputStream;
                } catch (Exception e25) {
                    e = e25;
                    dataOutputStream2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    dataOutputStream = null;
                    if (dataOutputStream == null) {
                    }
                }
            } catch (ProtocolException e26) {
                LogUtil.e(str2, e26);
                return null;
            }
        } catch (MalformedURLException e27) {
            e = e27;
            bArr = null;
            LogUtil.e("connection error!", e);
            return bArr;
        }
    }
}
