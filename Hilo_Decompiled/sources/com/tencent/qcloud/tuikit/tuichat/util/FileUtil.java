package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.utils.image.ImageTypeUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";
    private static final HashMap<String, String> fileType = new HashMap() { // from class: com.tencent.qcloud.tuikit.tuichat.util.FileUtil.1
    };

    private static String getAppName(Context context) {
        return String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
    }

    public static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String getImageFileName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(95);
        if (lastIndexOf > lastIndexOf2) {
            return str;
        }
        if (lastIndexOf2 >= 0) {
            str = str.substring(0, lastIndexOf2);
        }
        ImageTypeUtils imageTypeUtils = ImageTypeUtils.INSTANCE;
        if (!imageTypeUtils.checkImageType(str)) {
            return str + imageTypeUtils.getFileType(str);
        }
        return str;
    }

    public static String getMimeType(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(com.tencent.qcloud.tuicore.util.FileUtil.getFileExtensionFromUrl(str));
    }

    public static boolean saveFileFromPath(File file, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                fileInputStream2.close();
                                bufferedOutputStream.close();
                                return true;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return true;
                            }
                        }
                    }
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean saveFileToUri(ContentResolver contentResolver, Uri uri, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(contentResolver.openOutputStream(uri));
            try {
                fileInputStream = new FileInputStream(str);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused2) {
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        fileInputStream.close();
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                }
            }
        } catch (IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean saveImageToGallery(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return saveImageToGalleryByMediaStore(context, str);
        }
        return saveImageToGalleryByFile(context, str);
    }

    public static boolean saveImageToGalleryByFile(Context context, String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + getAppName(context) + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + getFileName(str);
        if (!str3.endsWith(".jpg")) {
            str3 = str3 + ".jpg";
        }
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        if (!saveFileFromPath(file2, str)) {
            return false;
        }
        MediaScannerConnection.scanFile(context, new String[]{str3}, new String[]{getMimeType(str)}, null);
        return true;
    }

    public static boolean saveImageToGalleryByMediaStore(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            LogUtil.INSTANCE.e("eTag", "获取图片类型:" + ImageTypeUtils.INSTANCE.getFileType(str), false);
            String imageFileName = getImageFileName(str);
            String mimeType = getMimeType(str);
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            long j = currentTimeMillis / 1000;
            contentValues.put("date_added", Long.valueOf(j));
            contentValues.put("date_modified", Long.valueOf(j));
            contentValues.put("_display_name", imageFileName);
            contentValues.put("mime_type", mimeType);
            Uri contentUri = MediaStore.Images.Media.getContentUri("external_primary");
            contentValues.put("is_pending", (Integer) 1);
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/" + getAppName(context) + "/");
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Uri insert = contentResolver.insert(contentUri, contentValues);
                if (insert == null) {
                    return false;
                }
                if (!saveFileToUri(contentResolver, insert, str)) {
                    contentResolver.delete(insert, null, null);
                    return false;
                }
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                MediaScannerConnection.scanFile(context, new String[]{insert.toString()}, new String[]{mimeType}, null);
                return true;
            } catch (IllegalArgumentException e) {
                TUIChatLog.e(TAG, "saveImageToGalleryByMediaStore failed, " + e.getMessage());
                return false;
            }
        }
        TUIChatLog.e(TAG, "param invalid");
        return false;
    }

    public static boolean saveVideoToGallery(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return saveVideoToGalleryByMediaStore(context, str);
        }
        return saveVideoToGalleryByFile(context, str);
    }

    public static boolean saveVideoToGalleryByFile(Context context, String str) {
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES) + "/" + getAppName(context) + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + getFileName(str);
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        if (!saveFileFromPath(file2, str)) {
            return false;
        }
        MediaScannerConnection.scanFile(context, new String[]{str3}, new String[]{getMimeType(str)}, null);
        return true;
    }

    public static boolean saveVideoToGalleryByMediaStore(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            String fileName = getFileName(str);
            String mimeType = getMimeType(str);
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            long j = currentTimeMillis / 1000;
            contentValues.put("date_added", Long.valueOf(j));
            contentValues.put("date_modified", Long.valueOf(j));
            contentValues.put("_display_name", fileName);
            contentValues.put("mime_type", mimeType);
            Uri contentUri = MediaStore.Video.Media.getContentUri("external_primary");
            contentValues.put("is_pending", (Integer) 1);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + "/" + getAppName(context) + "/");
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Uri insert = contentResolver.insert(contentUri, contentValues);
                if (insert == null) {
                    return false;
                }
                if (!saveFileToUri(contentResolver, insert, str)) {
                    contentResolver.delete(insert, null, null);
                    return false;
                }
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                MediaScannerConnection.scanFile(context, new String[]{insert.toString()}, new String[]{mimeType}, null);
                return true;
            } catch (IllegalArgumentException e) {
                TUIChatLog.e(TAG, "saveVideoToGalleryByMediaStore failed, " + e.getMessage());
                return false;
            }
        }
        TUIChatLog.e(TAG, "param invalid");
        return false;
    }
}
