package u;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f١٨٢٢٢a = "SudGIP ".concat(f.class.getSimpleName());

    /* JADX WARN: Finally extract failed */
    public static d.d a(String str, String str2) {
        ZipFile zipFile;
        d.d dVar = new d.d();
        File file = new File(str);
        File file2 = new File(str2);
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
                zipFile = null;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            byte[] bArr = new byte[1024];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!name.contains("__MACOSX")) {
                        if (nextEntry.isDirectory()) {
                            new File(file2, name).mkdirs();
                        } else {
                            InputStream inputStream = zipFile.getInputStream(nextEntry);
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file2, name));
                            while (true) {
                                try {
                                    int read = inputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                } catch (Throwable th2) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                            fileOutputStream.flush();
                            inputStream.close();
                            fileOutputStream.close();
                        }
                    }
                    zipInputStream.closeEntry();
                } else {
                    k0.a.c(zipFile);
                    return dVar;
                }
            }
        } catch (Exception e11) {
            e = e11;
            zipFile2 = zipFile;
            LogUtils.file("FileUtils", "unzip2 error:" + LogUtils.getErrorInfo(e));
            e.printStackTrace();
            dVar.f١٣٤٨٧a = -1;
            dVar.f١٣٤٨٨b = e.toString();
            k0.a.c(zipFile2);
            return dVar;
        } catch (Throwable th4) {
            th = th4;
            k0.a.c(zipFile);
            throw th;
        }
    }

    public static boolean b(long j10, String str, String str2) {
        boolean exists;
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && 0 != j10) {
            File file = new File(str, str2);
            String absolutePath = file.getAbsolutePath();
            if (absolutePath == null) {
                exists = false;
            } else {
                exists = new File(absolutePath).exists();
            }
            if (exists) {
                long length = file.length();
                if (length != 0 && length == j10) {
                    return true;
                }
                LogUtils.file("FileUtils", "checkFileIsOk size error:" + str + "  fileName:" + str2 + "  size:" + j10 + "  fileSize:" + length);
                SudLogger.d(f١٨٢٢٢a, "checkFileIsOk size error:" + str + "  fileName:" + str2 + "  size:" + j10 + "  fileSize:" + length);
                return false;
            }
            LogUtils.file("FileUtils", "checkFileIsOk notExists path:" + str + "  fileName:" + str2 + "  size:" + j10);
            SudLogger.d(f١٨٢٢٢a, "checkFileIsOk notExists path:" + str + "  fileName:" + str2 + "  size:" + j10);
            return false;
        }
        LogUtils.file("FileUtils", "checkFileIsOk empty path:" + str + "  fileName:" + str2 + "  size:" + j10);
        SudLogger.d(f١٨٢٢٢a, "checkFileIsOk empty path:" + str + "  fileName:" + str2 + "  size:" + j10);
        return false;
    }
}
