package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureFileUtils {
    private static final int BYTE_SIZE = 1024;
    private static final String POSTFIX_AMR = ".amr";
    private static final String POSTFIX_JPG = ".jpg";
    private static final String POSTFIX_MP4 = ".mp4";
    static final String TAG = "PictureFileUtils";

    private PictureFileUtils() {
    }

    public static void close(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copyFile(String str, String str2) {
        FileChannel fileChannel;
        FileChannel channel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(str).getChannel();
        } catch (Exception e10) {
            e = e10;
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(str2).getChannel();
            channel.transferTo(0L, channel.size(), fileChannel2);
            close(channel);
            close(fileChannel2);
        } catch (Exception e11) {
            e = e11;
            FileChannel fileChannel3 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel3;
            try {
                e.printStackTrace();
                close(fileChannel2);
                close(fileChannel);
            } catch (Throwable th2) {
                th = th2;
                close(fileChannel2);
                close(fileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            FileChannel fileChannel4 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel4;
            close(fileChannel2);
            close(fileChannel);
            throw th;
        }
    }

    public static File createCameraFile(Context context, int i10, String str, String str2, String str3) {
        return createMediaFile(context, i10, str, str2, str3);
    }

    public static String createFilePath(Context context, String str, String str2) {
        File rootDirFile;
        String str3;
        String lastSourceSuffix = PictureMimeType.getLastSourceSuffix(str);
        if (PictureMimeType.isHasVideo(str)) {
            rootDirFile = getRootDirFile(context, 2);
            str3 = "VID_";
        } else if (PictureMimeType.isHasAudio(str)) {
            rootDirFile = getRootDirFile(context, 3);
            str3 = "AUD_";
        } else {
            rootDirFile = getRootDirFile(context, 1);
            str3 = "IMG_";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rootDirFile.getPath());
        sb.append(File.separator);
        if (TextUtils.isEmpty(str2)) {
            str2 = DateUtils.getCreateFileName(str3) + lastSourceSuffix;
        }
        sb.append(str2);
        return sb.toString();
    }

    private static File createMediaFile(Context context, int i10, String str, String str2, String str3) {
        return createOutFile(context, i10, str, str2, str3);
    }

    private static File createOutFile(Context context, int i10, String str, String str2, String str3) {
        File file;
        File rootDirFile;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                rootDirFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                StringBuilder sb = new StringBuilder();
                sb.append(rootDirFile.getAbsolutePath());
                String str4 = File.separator;
                sb.append(str4);
                sb.append(PictureMimeType.CAMERA);
                sb.append(str4);
                file = new File(sb.toString());
            } else {
                rootDirFile = getRootDirFile(applicationContext, i10);
                file = new File(rootDirFile.getAbsolutePath() + File.separator);
            }
            if (!rootDirFile.exists()) {
                rootDirFile.mkdirs();
            }
        } else {
            File file2 = new File(str3);
            File parentFile = file2.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                file2.getParentFile().mkdirs();
            }
            file = file2;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (i10 != 2) {
            if (i10 != 3) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = ".jpg";
                }
                if (isEmpty) {
                    str = DateUtils.getCreateFileName("IMG_") + str2;
                }
                return new File(file, str);
            }
            if (isEmpty) {
                str = DateUtils.getCreateFileName("AUD_") + ".amr";
            }
            return new File(file, str);
        }
        if (isEmpty) {
            str = DateUtils.getCreateFileName("VID_") + ".mp4";
        }
        return new File(file, str);
    }

    @Deprecated
    public static void deleteAllCacheDirFile(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null && (listFiles3 = externalFilesDir.listFiles()) != null) {
            for (File file : listFiles3) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 != null && (listFiles2 = externalFilesDir2.listFiles()) != null) {
            for (File file2 : listFiles2) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 != null && (listFiles = externalFilesDir3.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    file3.delete();
                }
            }
        }
    }

    @Deprecated
    public static void deleteCacheDirFile(Context context, int i10) {
        String str;
        File[] listFiles;
        if (i10 == SelectMimeType.ofImage()) {
            str = Environment.DIRECTORY_PICTURES;
        } else {
            str = Environment.DIRECTORY_MOVIES;
        }
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null && (listFiles = externalFilesDir.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String formatAccurateUnitFileSize(long j10) {
        double d10;
        String str;
        if (j10 >= 0) {
            if (j10 < 1000) {
                d10 = j10;
                str = "";
            } else if (j10 < 1000000) {
                d10 = j10 / 1000.0d;
                str = "KB";
            } else if (j10 < 1000000000) {
                d10 = j10 / 1000000.0d;
                str = "MB";
            } else {
                d10 = j10 / 1.0E9d;
                str = "GB";
            }
            Object format = String.format(new Locale("zh"), "%.2f", Double.valueOf(d10));
            StringBuilder sb = new StringBuilder();
            if (Math.round(ValueOf.toDouble(format)) - ValueOf.toDouble(format) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                format = Long.valueOf(Math.round(ValueOf.toDouble(format)));
            }
            sb.append(format);
            sb.append(str);
            return sb.toString();
        }
        throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
    }

    @SuppressLint({"DefaultLocale"})
    public static String formatFileSize(long j10) {
        if (j10 >= 0) {
            if (j10 < 1024) {
                Object format = String.format("%.2f", Double.valueOf(j10));
                double d10 = ValueOf.toDouble(format);
                long round = Math.round(d10);
                StringBuilder sb = new StringBuilder();
                if (round - d10 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    format = Long.valueOf(round);
                }
                sb.append(format);
                sb.append("B");
                return sb.toString();
            }
            if (j10 < 1048576) {
                Object format2 = String.format("%.2f", Double.valueOf(j10 / 1024.0d));
                double d11 = ValueOf.toDouble(format2);
                long round2 = Math.round(d11);
                StringBuilder sb2 = new StringBuilder();
                if (round2 - d11 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    format2 = Long.valueOf(round2);
                }
                sb2.append(format2);
                sb2.append("KB");
                return sb2.toString();
            }
            if (j10 < 1073741824) {
                Object format3 = String.format("%.2f", Double.valueOf(j10 / 1048576.0d));
                double d12 = ValueOf.toDouble(format3);
                long round3 = Math.round(d12);
                StringBuilder sb3 = new StringBuilder();
                if (round3 - d12 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    format3 = Long.valueOf(round3);
                }
                sb3.append(format3);
                sb3.append("MB");
                return sb3.toString();
            }
            Object format4 = String.format("%.2f", Double.valueOf(j10 / 1.073741824E9d));
            double d13 = ValueOf.toDouble(format4);
            long round4 = Math.round(d13);
            StringBuilder sb4 = new StringBuilder();
            if (round4 - d13 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                format4 = Long.valueOf(round4);
            }
            sb4.append(format4);
            sb4.append("GB");
            return sb4.toString();
        }
        throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            } catch (IllegalArgumentException e10) {
                Log.i(TAG, String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", e10.getMessage()));
                if (cursor == null) {
                    return "";
                }
            }
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                cursor.close();
                return string;
            }
            if (cursor == null) {
                return "";
            }
            cursor.close();
            return "";
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(applicationContext, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                if ("primary".equalsIgnoreCase(split[0])) {
                    if (SdkVersionUtils.isQ()) {
                        return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
                    }
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                return "";
            }
            if (isDownloadsDocument(uri)) {
                return getDataColumn(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ValueOf.toLong(DocumentsContract.getDocumentId(uri))), null, null);
            }
            if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (PictureMimeType.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(applicationContext, uri2, "_id=?", new String[]{split2[1]});
            }
            return "";
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(applicationContext, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return "";
    }

    private static File getRootDirFile(Context context, int i10) {
        return new File(FileDirMap.getFileDirPath(context, i10));
    }

    public static String getVideoThumbnailDir(Context context) {
        File file = new File(context.getExternalFilesDir("").getAbsolutePath(), "VideoThumbnail");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFileExists(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isImageFileExists(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 2;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth > 0 && options.outHeight > 0) {
            return true;
        }
        return false;
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri parUri(Context context, File file) {
        String str = context.getPackageName() + ".luckProvider";
        if (Build.VERSION.SDK_INT > 23) {
            return FileProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    public static boolean writeFileFromIS(InputStream inputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (Exception e10) {
                e = e10;
                bufferedOutputStream = null;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        close(bufferedInputStream2);
                        close(bufferedOutputStream);
                        return true;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    close(bufferedInputStream);
                    close(bufferedOutputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    close(bufferedInputStream);
                    close(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                close(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}
