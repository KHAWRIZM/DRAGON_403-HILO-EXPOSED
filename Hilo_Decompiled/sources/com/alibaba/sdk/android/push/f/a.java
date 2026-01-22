package com.alibaba.sdk.android.push.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import anet.channel.request.Request;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: com.alibaba.sdk.android.push.f.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٠٨٢a {
        void a(String str);

        void b(String str);
    }

    public static Bitmap a(Context context, String str, String str2) {
        File file;
        File file2 = new File(context.getCacheDir(), "aliyun_push_images");
        String a10 = a(str);
        if (new File(file2, a10).exists()) {
            file = new File(file2, a10);
        } else {
            try {
                a(str, file2, a10, str2);
                file = new File(file2, a10);
            } catch (Exception unused) {
                return null;
            }
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static String a(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        return substring.contains("?") ? substring.substring(0, substring.indexOf("?")) : substring;
    }

    public static StringBuilder a(BufferedReader bufferedReader) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb;
            }
            sb.append(readLine);
        }
    }

    private static void a(InputStream inputStream, File file, String str) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[10240];
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            InterfaceC٠٠٨٢a b10 = com.alibaba.sdk.android.push.b.b.a().b();
                            if ("image".equals(str)) {
                                if (b10 != null) {
                                    b10.a(th.getMessage());
                                }
                            } else if (b10 != null) {
                                b10.b(th.getMessage());
                            }
                            AmsLogger.getLogger("MPS:Download").d("writeToFile failed: " + str + ", error: " + Log.getStackTraceString(th));
                            throw th;
                        } finally {
                        }
                    }
                }
                bufferedInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1  */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, File file, String str2, String str3) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Throwable th;
        ?? r32;
        System.currentTimeMillis();
        InterfaceC٠٠٨٢a b10 = com.alibaba.sdk.android.push.b.b.a().b();
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(false);
                httpURLConnection2.setRequestMethod(Request.Method.GET);
                httpURLConnection2.setRequestProperty("charset", "utf-8");
                if (httpURLConnection2.getResponseCode() != 200) {
                    inputStream = httpURLConnection2.getErrorStream();
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        try {
                            String sb = a(bufferedReader).toString();
                            if ("image".equals(str3)) {
                                if (b10 != null) {
                                    b10.a(httpURLConnection2.getResponseCode() + sb);
                                }
                            } else if (b10 != null) {
                                b10.b(httpURLConnection2.getResponseCode() + sb);
                            }
                            throw new Exception(httpURLConnection2.getResponseCode() + sb);
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            r32 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        r32 = bufferedReader;
                        if ("image".equals(str3)) {
                        }
                        AmsLogger.getLogger("MPS:Download").d("download failed: " + str3 + ", error: " + Log.getStackTraceString(th));
                        throw th;
                    }
                } else {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, str2);
                    try {
                        inputStream = httpURLConnection2.getInputStream();
                        try {
                            a(inputStream, file2, str3);
                            System.currentTimeMillis();
                            httpURLConnection2.disconnect();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            httpURLConnection = httpURLConnection2;
                            th = th4;
                            bufferedReader = null;
                            r32 = file2;
                        }
                    } catch (Throwable th5) {
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection2;
                        th = th5;
                        inputStream = null;
                        r32 = file2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedReader = null;
        }
        try {
            if ("image".equals(str3)) {
                if (b10 != null) {
                    b10.b(th.getMessage());
                }
            } else if (b10 != null) {
                b10.a(th.getMessage());
            }
            AmsLogger.getLogger("MPS:Download").d("download failed: " + str3 + ", error: " + Log.getStackTraceString(th));
            throw th;
        } finally {
        }
    }
}
