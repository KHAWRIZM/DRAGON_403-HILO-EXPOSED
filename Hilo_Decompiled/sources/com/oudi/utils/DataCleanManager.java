package com.oudi.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DataCleanManager {
    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static long getFolderSize(File file) {
        long length;
        long j10 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                if (listFiles[i10].isDirectory()) {
                    length = getFolderSize(listFiles[i10]);
                } else {
                    length = listFiles[i10].length();
                }
                j10 += length;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return j10;
    }

    public static String getFormatSize(double d10) {
        double d11 = d10 / 1024.0d;
        if (d11 < 1.0d) {
            return "0K";
        }
        double d12 = d11 / 1024.0d;
        if (d12 < 1.0d) {
            return new BigDecimal(Double.toString(d11)).setScale(2, 4).toPlainString() + "K";
        }
        double d13 = d12 / 1024.0d;
        if (d13 < 1.0d) {
            return new BigDecimal(Double.toString(d12)).setScale(2, 4).toPlainString() + "MB";
        }
        double d14 = d13 / 1024.0d;
        if (d14 < 1.0d) {
            return new BigDecimal(Double.toString(d13)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d14).setScale(2, 4).toPlainString() + "TB";
    }

    public static String getTotalCacheSize(Context context) {
        long folderSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            folderSize += getFolderSize(context.getExternalCacheDir());
        }
        return getFormatSize(folderSize);
    }
}
