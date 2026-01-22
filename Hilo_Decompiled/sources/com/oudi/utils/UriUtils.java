package com.oudi.utils;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.facebook.internal.security.CertificateUtil;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Uri file2Uri(File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(AppUtils.getApp(), AppUtils.getApp().getPackageName() + ".fileProvider", file);
        }
        return Uri.fromFile(file);
    }

    private static File getFileFromUri(Uri uri, String str) {
        return getFileFromUri(uri, null, null, str);
    }

    public static File uri2File(Uri uri) {
        Uri uri2;
        String str;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null && path.startsWith("/external/")) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace("/external", ""));
            if (file.exists()) {
                Log.d("UriUtils", uri + " -> /external");
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri + " parse failed. -> 0");
            return null;
        }
        if (DocumentsContract.isDocumentUri(AppUtils.getApp(), uri)) {
            int i10 = 0;
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                String str2 = split[0];
                if ("primary".equalsIgnoreCase(str2)) {
                    return new File(Environment.getExternalStorageDirectory() + "/" + split[1]);
                }
                StorageManager storageManager = (StorageManager) AppUtils.getApp().getSystemService("storage");
                try {
                    Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                    Method method = storageManager.getClass().getMethod("getVolumeList", null);
                    Method method2 = cls.getMethod("getUuid", null);
                    Method method3 = cls.getMethod("getState", null);
                    Method method4 = cls.getMethod("getPath", null);
                    Method method5 = cls.getMethod("isPrimary", null);
                    Method method6 = cls.getMethod("isEmulated", null);
                    Object invoke = method.invoke(storageManager, null);
                    int length = Array.getLength(invoke);
                    while (i10 < length) {
                        Object obj = Array.get(invoke, i10);
                        Object obj2 = invoke;
                        if (!"mounted".equals(method3.invoke(obj, null))) {
                            if ("mounted_ro".equals(method3.invoke(obj, null))) {
                            }
                            i10++;
                            invoke = obj2;
                        }
                        if ((!((Boolean) method5.invoke(obj, null)).booleanValue() || !((Boolean) method6.invoke(obj, null)).booleanValue()) && (str = (String) method2.invoke(obj, null)) != null && str.equals(str2)) {
                            return new File(method4.invoke(obj, null) + "/" + split[1]);
                        }
                        i10++;
                        invoke = obj2;
                    }
                } catch (Exception e10) {
                    Log.d("UriUtils", uri + " parse failed. " + e10 + " -> 1_0");
                }
                Log.d("UriUtils", uri + " parse failed. -> 1_0");
                return null;
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return getFileFromUri(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), "1_1");
                    } catch (NumberFormatException unused) {
                        if (documentId.startsWith("raw:")) {
                            return new File(documentId.substring(4));
                        }
                    }
                }
                Log.d("UriUtils", uri + " parse failed. -> 1_1");
                return null;
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                String str3 = split2[0];
                if ("image".equals(str3)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str3)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (PictureMimeType.MIME_TYPE_PREFIX_AUDIO.equals(str3)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Log.d("UriUtils", uri + " parse failed. -> 1_2");
                    return null;
                }
                return getFileFromUri(uri2, "_id=?", new String[]{split2[1]}, "1_2");
            }
            if ("content".equals(scheme)) {
                return getFileFromUri(uri, "1_3");
            }
            Log.d("UriUtils", uri + " parse failed. -> 1_4");
            return null;
        }
        if ("content".equals(scheme)) {
            return getFileFromUri(uri, "2");
        }
        Log.d("UriUtils", uri + " parse failed. -> 3");
        return null;
    }

    private static File getFileFromUri(Uri uri, String str, String[] strArr, String str2) {
        Cursor query = AppUtils.getApp().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (query == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            }
            if (query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("_data");
                if (columnIndex > -1) {
                    return new File(query.getString(columnIndex));
                }
                Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
                return null;
            }
            Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            query.close();
        }
    }
}
