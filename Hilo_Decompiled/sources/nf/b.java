package nf;

import android.os.Build;
import android.text.TextUtils;
import d.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class b {
    public static d a(String str, String str2) {
        Throwable th;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel2;
        IOException iOException;
        FileInputStream fileInputStream2;
        FileChannel fileChannel3;
        IOException iOException2;
        FileChannel fileChannel4;
        FileChannel channel;
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        d dVar = new d();
        dVar.a = 0;
        File file2 = new File(str2);
        if (file2.exists()) {
            return dVar;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            dVar.a = -1;
            dVar.b = "Make dir failed";
            LogUtils.file("SudRuntimeUtils", "Make dir failed: " + parentFile.getAbsolutePath());
            return dVar;
        }
        File file3 = new File(str);
        if (!file3.exists()) {
            dVar.a = -10401;
            dVar.b = "File not exist";
            LogUtils.file("SudRuntimeUtils", "File not exist: " + str);
            return dVar;
        }
        FileChannel fileChannel5 = null;
        try {
            fileInputStream2 = new FileInputStream(file3);
        } catch (IOException e) {
            fileOutputStream = null;
            fileChannel2 = null;
            iOException = e;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
            fileInputStream2 = fileInputStream;
            FileChannel fileChannel6 = fileChannel5;
            fileChannel5 = fileChannel;
            fileChannel3 = fileChannel6;
            c(fileInputStream2);
            c(fileChannel3);
            c(fileOutputStream);
            c(fileChannel5);
            throw th;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                channel = fileInputStream2.getChannel();
            } catch (IOException e2) {
                iOException2 = e2;
                fileChannel4 = null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
            try {
                fileChannel5 = fileOutputStream.getChannel();
                channel.transferTo(0L, channel.size(), fileChannel5);
                c(fileInputStream2);
                c(channel);
                c(fileOutputStream);
                c(fileChannel5);
                return dVar;
            } catch (IOException e3) {
                iOException2 = e3;
                fileChannel4 = fileChannel5;
                fileChannel5 = channel;
                FileChannel fileChannel7 = fileChannel5;
                fileChannel5 = fileChannel4;
                iOException = iOException2;
                fileInputStream = fileInputStream2;
                fileChannel2 = fileChannel7;
                try {
                    dVar.a = -10401;
                    dVar.b = iOException.toString();
                    LogUtils.file("SudRuntimeUtils", "File copy failed: " + str + " -> " + str2);
                    StringBuilder sb2 = new StringBuilder("copyIfNotExist error:");
                    sb2.append(LogUtils.getErrorInfo(iOException));
                    LogUtils.file("SudRuntimeUtils", sb2.toString());
                    iOException.printStackTrace();
                    c(fileInputStream);
                    c(fileChannel2);
                    c(fileOutputStream);
                    c(fileChannel5);
                    return dVar;
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel = fileChannel5;
                    fileChannel5 = fileChannel2;
                    fileInputStream2 = fileInputStream;
                    FileChannel fileChannel62 = fileChannel5;
                    fileChannel5 = fileChannel;
                    fileChannel3 = fileChannel62;
                    c(fileInputStream2);
                    c(fileChannel3);
                    c(fileOutputStream);
                    c(fileChannel5);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                fileChannel = fileChannel5;
                fileChannel5 = channel;
                FileChannel fileChannel622 = fileChannel5;
                fileChannel5 = fileChannel;
                fileChannel3 = fileChannel622;
                c(fileInputStream2);
                c(fileChannel3);
                c(fileOutputStream);
                c(fileChannel5);
                throw th;
            }
        } catch (IOException e4) {
            fileOutputStream = null;
            iOException = e4;
            fileInputStream = fileInputStream2;
            fileChannel2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileChannel3 = null;
            fileOutputStream = null;
            c(fileInputStream2);
            c(fileChannel3);
            c(fileOutputStream);
            c(fileChannel5);
            throw th;
        }
    }

    public static String b() {
        String str = Build.CPU_ABI;
        if (str != null && (str.equals("armeabi-v7a") || str.equals("arm64-v8a") || str.equals("x86") || str.equals("x86_64"))) {
            return str;
        }
        String str2 = Build.CPU_ABI2;
        if (str2 == null || (!str2.equals("armeabi-v7a") && !str2.equals("arm64-v8a") && !str2.equals("x86") && !str2.equals("x86_64"))) {
            return "arm64-v8a";
        }
        return str2;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !name.endsWith(".prof") && (!file2.isDirectory() || !name.endsWith("oat"))) {
                        if (file2.isDirectory()) {
                            d(file2);
                        } else {
                            LogUtils.file("SudRuntimeUtils", "setCoreFileReadOnly:" + file2.setReadOnly());
                        }
                    }
                }
            }
        }
    }
}
