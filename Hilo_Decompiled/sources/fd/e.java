package fd;

import android.text.TextUtils;
import d.k;
import d.p;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import qf.x;
import qf.z;
import tech.sud.logger.LogUtils;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class e {
    public static boolean a = true;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(File file, File file2) {
        Throwable th;
        DataOutputStream dataOutputStream;
        Exception e;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3;
        DataOutputStream dataOutputStream4;
        byte[] bArr;
        byte[] bArr2;
        int read;
        DataOutputStream dataOutputStream5 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(file2.getAbsolutePath()));
                try {
                    byte[] bytes = j.b(UUID.randomUUID().toString()).getBytes(StandardCharsets.UTF_8);
                    HashMap hashMap = i.d.a;
                    PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(i.a.b("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA84624QluMte2OQf27WRmq4q3nVjVCQX0o+2lZm3ktKHG2PZf5AjxjZiCuNjqfWSo1gJDsyJZC4FSubhhjDSXrPcJRKS6lXt5DKuhABWWqgkUhcJX3/loigHG4Abyi/+b0NkKPaqTbJ64j9jylyXvO6fj1TMmOw+5zJ/6rV0FMVHosyTUX0zTCt6T5OooGiSt+wCvxlj1IT6vqJ4k8EyM6zYhPzQMK7xZniUyYfdl4OeS9NMT1wW62scuEQ5y2VVeHxFSeauGw9CaQLMIjZl2yj87N8gEtsRj5+hQWmG2kEQOZMv9jRwLGpsH0JoBdJwiThf0fYdB3T1jtgL5eyUnewIDAQAB")));
                    if (bytes != null && bytes.length != 0) {
                        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
                        cipher.init(1, generatePublic);
                        bArr = cipher.doFinal(bytes);
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                        bArr2 = new byte[10240];
                        int i = 0;
                        while (true) {
                            read = fileInputStream.read(bArr2);
                            if (read <= 0) {
                                for (int i2 = 0; i2 < read; i2++) {
                                    bArr2[i2] = (byte) (bArr2[i2] ^ bytes[i]);
                                    i = (i + 1) % bytes.length;
                                }
                                dataOutputStream.write(bArr2, 0, read);
                            } else {
                                k0.a.c(fileInputStream);
                                k0.a.c(dataOutputStream);
                                return file2;
                            }
                        }
                    }
                    bArr = null;
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(bArr);
                    bArr2 = new byte[10240];
                    int i3 = 0;
                    while (true) {
                        read = fileInputStream.read(bArr2);
                        if (read <= 0) {
                        }
                        dataOutputStream.write(bArr2, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataOutputStream2 = fileInputStream;
                    try {
                        e.printStackTrace();
                        LogUtils.file("ReportCLogUtils", "encryptFile error:" + LogUtils.getErrorInfo(e));
                        k0.a.c(dataOutputStream2);
                        k0.a.c(dataOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream5 = dataOutputStream2;
                        dataOutputStream4 = dataOutputStream5;
                        dataOutputStream5 = dataOutputStream;
                        dataOutputStream3 = dataOutputStream4;
                        k0.a.c(dataOutputStream3);
                        k0.a.c(dataOutputStream5);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream4 = fileInputStream;
                    dataOutputStream5 = dataOutputStream;
                    dataOutputStream3 = dataOutputStream4;
                    k0.a.c(dataOutputStream3);
                    k0.a.c(dataOutputStream5);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = null;
                dataOutputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream3 = fileInputStream;
                k0.a.c(dataOutputStream3);
                k0.a.c(dataOutputStream5);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            dataOutputStream = null;
            dataOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            dataOutputStream4 = dataOutputStream5;
            dataOutputStream5 = dataOutputStream;
            dataOutputStream3 = dataOutputStream4;
            k0.a.c(dataOutputStream3);
            k0.a.c(dataOutputStream5);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(File file) {
        long j;
        String str;
        String str2;
        String str3;
        k kVar;
        d.e eVar;
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                a = false;
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    String str4 = null;
                    try {
                        JSONObject jSONObject = new JSONObject(d0.a.a("TechSudMGPCLog.sp").a.getString(name, ""));
                        str = jSONObject.optString("appId");
                        try {
                            j = jSONObject.optLong("mgId");
                        } catch (Exception e) {
                            e = e;
                            j = 0;
                        }
                        try {
                            str2 = jSONObject.optString("requestId");
                        } catch (Exception e2) {
                            e = e2;
                            str2 = null;
                            e.printStackTrace();
                            str3 = null;
                            if (TextUtils.isEmpty(str2)) {
                            }
                            d0.a.a("TechSudMGPCLog.sp").d(name);
                            file2.delete();
                        }
                        try {
                            str3 = jSONObject.optString("filePath");
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            str3 = null;
                            if (TextUtils.isEmpty(str2)) {
                            }
                            d0.a.a("TechSudMGPCLog.sp").d(name);
                            file2.delete();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        j = 0;
                        str = null;
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str3)) {
                            File file3 = new File(str3);
                            if (file3.exists() && file3.length() > 0) {
                                p pVar = e.d.e;
                                if (pVar != null && (kVar = pVar.c) != null && (eVar = kVar.d) != null) {
                                    str4 = eVar.e;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    if (c(str4, str2, file3, str, j + "")) {
                                        file3.delete();
                                        d0.a.a("TechSudMGPCLog.sp").d(str2);
                                    } else {
                                        a = true;
                                    }
                                }
                            }
                        }
                    } else {
                        d0.a.a("TechSudMGPCLog.sp").d(name);
                        file2.delete();
                    }
                }
                return;
            }
            d0.a.a("TechSudMGPCLog.sp").b();
            a = false;
        }
    }

    public static boolean c(String str, String str2, File file, String str3, String str4) {
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        wf.d dVar = new wf.d();
        dVar.c = 3;
        dVar.b.a = "UploadHttpLoggingInterceptor";
        wf.a aVar = new wf.a();
        aVar.a = "UploadLoggingEventListener";
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(15L, timeUnit).readTimeout(30L, timeUnit).addInterceptor(dVar).writeTimeout(30L, timeUnit).eventListenerFactory(aVar).dns(new z("UploadLoggingIpv4PreferredDns")).build();
        MultipartBody build2 = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", file.getName(), RequestBody.create(MediaType.get("application/octet-stream"), file)).addFormDataPart("app_id", str3).addFormDataPart("mg_id", str4).build();
        String str5 = null;
        Request.Builder e = x.e(str2, new wf.e(), null);
        String str6 = e.d.a;
        try {
            Response execute = build.newCall(e.addHeader("sud-sdk-signature", e.a.a(e.d.h, str2 + "&" + str3 + "&" + String.valueOf(2) + "&" + e.d.d())).url(str).post(build2).build()).execute();
            if (!execute.isSuccessful()) {
                return false;
            }
            if (execute.body() != null) {
                str5 = execute.body().string();
            }
            LogUtils.file("ReportCLogUtils", "upload response:" + str5);
            return true;
        } catch (Exception e2) {
            LogUtils.file("ReportCLogUtils", LogUtils.getErrorInfo(e2));
            return false;
        }
    }
}
