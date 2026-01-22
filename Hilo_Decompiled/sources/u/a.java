package u;

import java.io.File;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {
    public static boolean a(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            return true;
        }
        if (file.isFile()) {
            return false;
        }
        String parent = file.getParent();
        if (parent != null && !a(parent)) {
            return false;
        }
        return file.mkdir();
    }

    public static void b(String str) {
        String[] list;
        LogUtils.file("PathUtils", "start deleteFolderRecursive:" + str);
        File file = new File(str);
        if (!file.exists()) {
            LogUtils.file("PathUtils", "文件不存在 deleteFolderRecursive:" + str);
            return;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str2 : list) {
                b(file.getPath() + File.separator + str2);
            }
        }
        LogUtils.file("PathUtils", "end deleteFolderRecursive:" + str + "  result:" + file.delete());
    }

    public static void c(String str) {
        LogUtils.file("PathUtils", "start deleteFolderAllChilds:" + str);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    c(file2.getAbsolutePath());
                    file2.delete();
                }
            }
            return;
        }
        LogUtils.file("PathUtils", "目录不存在 deleteFolderAllChilds:" + str);
    }
}
