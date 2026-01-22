package com.tencent.qcloud.tuicore.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUILogin;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FileUtil {
    public static final String DOCUMENTS_DIR = "documents";
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String formatFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "GB";
    }

    public static File generateFileName(String str, File file) {
        String str2;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int lastIndexOf = str.lastIndexOf(46);
            int i = 0;
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                str2 = str.substring(lastIndexOf);
                str = substring;
            } else {
                str2 = "";
            }
            while (file2.exists()) {
                i++;
                file2 = new File(file, str + '(' + i + ')' + str2);
            }
        }
        try {
            if (!file2.createNewFile()) {
                return null;
            }
            return file2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r8 == null) goto L٢٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
    
        if (r8 != null) goto L١٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            cursor.close();
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static File getDocumentCacheDir(Context context) {
        File file = new File(context.getCacheDir(), DOCUMENTS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!str.isEmpty() && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
                return str.substring(lastIndexOf + 1).toLowerCase();
            }
            return "";
        }
        return "";
    }

    public static String getFileName(Context context, Uri uri) {
        if (context.getContentResolver().getType(uri) == null) {
            return getName(uri.toString());
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("_display_name");
            query.moveToFirst();
            String string = query.getString(columnIndex);
            query.close();
            return string;
        }
        return null;
    }

    public static long getFileSize(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public static String getPath(Context context, Uri uri) {
        int i = Build.VERSION.SDK_INT;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return getPathByCopyFile(context, uri);
            }
            if (isDownloadsDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                for (int i2 = 0; i2 < 3; i2++) {
                    try {
                        String dataColumn = getDataColumn(context, ContentUris.withAppendedId(Uri.parse(strArr[i2]), Long.parseLong(documentId)), null, null);
                        if (dataColumn != null && Build.VERSION.SDK_INT < 29) {
                            return dataColumn;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return getPathByCopyFile(context, uri);
            }
            if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (TUIConstants.TUICalling.TYPE_AUDIO.equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String dataColumn2 = getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                if (TextUtils.isEmpty(dataColumn2) || i >= 29) {
                    return getPathByCopyFile(context, uri);
                }
                return dataColumn2;
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                String dataColumn3 = getDataColumn(context, uri, null, null);
                if (TextUtils.isEmpty(dataColumn3) || i >= 29) {
                    return getPathByCopyFile(context, uri);
                }
                return dataColumn3;
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String getPathByCopyFile(Context context, Uri uri) {
        File generateFileName = generateFileName(getFileName(context, uri), getDocumentCacheDir(context));
        if (generateFileName == null) {
            return null;
        }
        String absolutePath = generateFileName.getAbsolutePath();
        if (!saveFileFromUri(context, uri, absolutePath)) {
            generateFileName.delete();
            return null;
        }
        return absolutePath;
    }

    public static String getPathFromUri(Uri uri) {
        String str;
        try {
            str = getPathByCopyFile(TUILogin.getAppContext(), uri);
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getRealFilePath(Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (query = TUILogin.getAppContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static Uri getUriFromPath(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return FileProvider.getUriForFile(TUIConfig.getAppContext(), TUIConfig.getAppContext().getApplicationInfo().packageName + ".tuicore.fileprovider", new File(str));
            }
            return Uri.fromFile(new File(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void openFile(String str, String str2) {
        String fileExtensionFromUrl;
        Uri uriForFile = FileProvider.getUriForFile(TUIConfig.getAppContext(), TUIConfig.getAppContext().getApplicationInfo().packageName + ".tuicore.fileprovider", new File(str));
        if (uriForFile == null) {
            Log.e("FileUtil", "openFile failed , uri is null");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            fileExtensionFromUrl = getFileExtensionFromUrl(str);
        } else {
            fileExtensionFromUrl = getFileExtensionFromUrl(str2);
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, mimeTypeFromExtension);
        try {
            Intent createChooser = Intent.createChooser(intent, TUIConfig.getAppContext().getString(R.string.open_file_tips));
            createChooser.addFlags(268435456);
            TUIConfig.getAppContext().startActivity(createChooser);
        } catch (Exception e) {
            Log.e("FileUtil", "openFile failed , " + e.getMessage());
        }
    }

    public static String saveBitmap(String str, Bitmap bitmap) {
        String str2 = TUIConfig.getMediaDir() + "picture_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg";
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return str2;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0061 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #8 {IOException -> 0x005d, blocks: (B:46:0x0059, B:39:0x0061), top: B:45:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean saveFileFromUri(Context context, Uri uri, String str) {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, false));
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            openInputStream.close();
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = openInputStream;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = openInputStream;
                if (inputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}
