package com.luck.picture.lib.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class FileDirMap {
    private static final HashMap<Integer, String> dirMap = new HashMap<>();

    public static void clear() {
        dirMap.clear();
    }

    public static String getFileDirPath(Context context, int i10) {
        HashMap<Integer, String> hashMap = dirMap;
        String str = hashMap.get(Integer.valueOf(i10));
        if (str == null) {
            init(context);
            return hashMap.get(Integer.valueOf(i10));
        }
        return str;
    }

    public static void init(Context context) {
        String path;
        String path2;
        String path3;
        if (!ActivityCompatHelper.assertValidRequest(context)) {
            return;
        }
        HashMap<Integer, String> hashMap = dirMap;
        if (hashMap.get(1) == null) {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir != null && externalFilesDir.exists()) {
                path3 = externalFilesDir.getPath();
            } else {
                path3 = context.getCacheDir().getPath();
            }
            hashMap.put(1, path3);
        }
        if (hashMap.get(2) == null) {
            File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
            if (externalFilesDir2 != null && externalFilesDir2.exists()) {
                path2 = externalFilesDir2.getPath();
            } else {
                path2 = context.getCacheDir().getPath();
            }
            hashMap.put(2, path2);
        }
        if (hashMap.get(3) == null) {
            File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
            if (externalFilesDir3 != null && externalFilesDir3.exists()) {
                path = externalFilesDir3.getPath();
            } else {
                path = context.getCacheDir().getPath();
            }
            hashMap.put(3, path);
        }
    }
}
