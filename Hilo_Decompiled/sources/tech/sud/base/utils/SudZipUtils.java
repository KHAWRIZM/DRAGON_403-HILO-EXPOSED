package tech.sud.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudZipUtils {
    public static void zipDirectory(File file, File file2) {
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipFile(file, file.getName(), zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
    }

    private static void zipFile(File file, String str, ZipOutputStream zipOutputStream) {
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                if (str.endsWith("/")) {
                    zipOutputStream.putNextEntry(new ZipEntry(str));
                    zipOutputStream.closeEntry();
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(str.concat("/")));
                    zipOutputStream.closeEntry();
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        zipFile(file2, str + "/" + file2.getName(), zipOutputStream);
                    }
                    return;
                }
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(new ZipEntry(str));
            byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read >= 0) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        }
    }
}
