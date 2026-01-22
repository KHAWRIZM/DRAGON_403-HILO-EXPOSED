package com.luck.picture.lib.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MediaUtils {
    public static final String QUERY_ARG_SQL_LIMIT = "android:query-arg-sql-limit";

    public static Bundle createQueryArgsBundle(String str, String[] strArr, int i10, int i11, String str2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", str2);
            if (SdkVersionUtils.isR()) {
                bundle.putString(QUERY_ARG_SQL_LIMIT, i10 + " offset " + i11);
            }
        }
        return bundle;
    }

    public static void deleteUri(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && PictureMimeType.isContent(str)) {
                context.getContentResolver().delete(Uri.parse(str), null, null);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String generateCameraFolderName(String str) {
        File file = new File(str);
        if (file.getParentFile() != null) {
            return file.getParentFile().getName();
        }
        return PictureMimeType.CAMERA;
    }

    public static void getAsyncVideoThumbnail(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() { // from class: com.luck.picture.lib.utils.MediaUtils.3
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getVideoThumbnail(context, str);
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel(this);
                OnCallbackListener onCallbackListener2 = onCallbackListener;
                if (onCallbackListener2 != null) {
                    onCallbackListener2.onCall(mediaExtraInfo);
                }
            }
        });
    }

    public static MediaExtraInfo getAudioSize(Context context, String str) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    if (PictureMimeType.isContent(str)) {
                        mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                    } else {
                        mediaMetadataRetriever.setDataSource(str);
                    }
                    mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                    mediaMetadataRetriever.release();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    mediaMetadataRetriever.release();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return mediaExtraInfo;
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            throw th;
        }
    }

    public static int getDCIMLastImageId(Context context, String str) {
        Cursor query;
        int i10 = -1;
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"%" + str + "%"};
                if (SdkVersionUtils.isR()) {
                    query = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, createQueryArgsBundle("_data like ?", strArr, 1, 0, "_id DESC"), null);
                } else {
                    query = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                }
                cursor = query;
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    int i11 = cursor.getInt(cursor.getColumnIndex(TransferTable.COLUMN_ID));
                    if (DateUtils.dateDiffer(cursor.getLong(cursor.getColumnIndex("date_added"))) <= 1) {
                        i10 = i11;
                    }
                    cursor.close();
                    return i10;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Deprecated
    public static MediaExtraInfo getImageSize(String str) {
        BitmapFactory.Options options;
        InputStream fileInputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream inputStream = null;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.isContent(str)) {
                    fileInputStream = PictureContentResolver.openInputStream(PictureAppMaster.getInstance().getAppContext(), Uri.parse(str));
                } else {
                    fileInputStream = new FileInputStream(str);
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            BitmapFactory.decodeStream(fileInputStream, null, options);
            mediaExtraInfo.setWidth(options.outWidth);
            mediaExtraInfo.setHeight(options.outHeight);
            PictureFileUtils.close(fileInputStream);
        } catch (Exception e11) {
            inputStream = fileInputStream;
            e = e11;
            e.printStackTrace();
            PictureFileUtils.close(inputStream);
            return mediaExtraInfo;
        } catch (Throwable th2) {
            inputStream = fileInputStream;
            th = th2;
            PictureFileUtils.close(inputStream);
            throw th;
        }
        return mediaExtraInfo;
    }

    private static String getMimeType(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static String getMimeTypeFromMediaHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.toLowerCase().endsWith(PictureMimeType.JPG) && !str.toLowerCase().endsWith(PictureMimeType.JPEG)) {
            if (str.toLowerCase().endsWith(".png")) {
                return PictureMimeType.PNG_Q;
            }
            if (str.toLowerCase().endsWith(".gif")) {
                return "image/gif";
            }
            if (str.toLowerCase().endsWith(".webp")) {
                return "image/webp";
            }
            if (str.toLowerCase().endsWith(PictureMimeType.BMP)) {
                return "image/bmp";
            }
            if (str.toLowerCase().endsWith(".mp4")) {
                return "video/mp4";
            }
            if (str.toLowerCase().endsWith(PictureMimeType.AVI)) {
                return PictureMimeType.AVI_Q;
            }
            if (str.toLowerCase().endsWith(PictureMimeType.MP3)) {
                return "audio/mpeg";
            }
            if (str.toLowerCase().endsWith(PictureMimeType.AMR)) {
                return "audio/amr";
            }
            if (!str.toLowerCase().endsWith(".m4a")) {
                return null;
            }
            return "audio/mpeg";
        }
        return "image/jpeg";
    }

    public static String getMimeTypeFromMediaUrl(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase());
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            mimeTypeFromExtension = getMimeType(new File(str));
        }
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            return "image/jpeg";
        }
        return mimeTypeFromExtension;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        if (r2 != null) goto L٢٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x008a, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        if (r2 == null) goto L٢٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Long[] getPathMediaBucketId(Context context, String str) {
        Cursor query;
        Long[] lArr = {0L, 0L};
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"%" + str + "%"};
                if (SdkVersionUtils.isR()) {
                    query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), null, createQueryArgsBundle("_data like ?", strArr, 1, 0, "_id DESC"), null);
                } else {
                    query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                }
                cursor = query;
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    lArr[0] = Long.valueOf(cursor.getLong(cursor.getColumnIndex(TransferTable.COLUMN_ID)));
                    lArr[1] = Long.valueOf(cursor.getLong(cursor.getColumnIndex("bucket_id")));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String getRealPathUri(long j10, String str) {
        Uri contentUri;
        if (PictureMimeType.isHasImage(str)) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (PictureMimeType.isHasVideo(str)) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (PictureMimeType.isHasAudio(str)) {
            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(contentUri, j10).toString();
    }

    public static void getVideoSize(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() { // from class: com.luck.picture.lib.utils.MediaUtils.2
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getVideoSize(context, str);
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel(this);
                OnCallbackListener onCallbackListener2 = onCallbackListener;
                if (onCallbackListener2 != null) {
                    onCallbackListener2.onCall(mediaExtraInfo);
                }
            }
        });
    }

    public static MediaExtraInfo getVideoThumbnail(Context context, String str) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        Bitmap frameAtTime;
        FileOutputStream fileOutputStream2;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        } catch (IOException e10) {
            e = e10;
            fileOutputStream = null;
            bitmap = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
            bitmap = null;
        }
        if (frameAtTime != null) {
            try {
            } catch (IOException e11) {
                e = e11;
                bitmap = frameAtTime;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bitmap = frameAtTime;
                fileOutputStream = null;
            }
            if (!frameAtTime.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    frameAtTime.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream2);
                    File file = new File(PictureFileUtils.getVideoThumbnailDir(context), DateUtils.getCreateFileName("vid_") + "_thumb.jpg");
                    fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(byteArrayOutputStream2.toByteArray());
                        fileOutputStream2.flush();
                        mediaExtraInfo.setVideoThumbnail(file.getAbsolutePath());
                        mediaExtraInfo.setWidth(frameAtTime.getWidth());
                        mediaExtraInfo.setHeight(frameAtTime.getHeight());
                        byteArrayOutputStream = byteArrayOutputStream2;
                        PictureFileUtils.close(byteArrayOutputStream);
                        PictureFileUtils.close(fileOutputStream2);
                        if (frameAtTime != null && !frameAtTime.isRecycled()) {
                            frameAtTime.recycle();
                        }
                    } catch (IOException e12) {
                        fileOutputStream = fileOutputStream2;
                        e = e12;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        bitmap = frameAtTime;
                        try {
                            e.printStackTrace();
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return mediaExtraInfo;
                        } catch (Throwable th3) {
                            th = th3;
                            PictureFileUtils.close(byteArrayOutputStream);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        bitmap = frameAtTime;
                        fileOutputStream = fileOutputStream2;
                        th = th4;
                        PictureFileUtils.close(byteArrayOutputStream);
                        PictureFileUtils.close(fileOutputStream);
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                }
                return mediaExtraInfo;
            }
        }
        fileOutputStream2 = null;
        PictureFileUtils.close(byteArrayOutputStream);
        PictureFileUtils.close(fileOutputStream2);
        if (frameAtTime != null) {
            frameAtTime.recycle();
        }
        return mediaExtraInfo;
    }

    public static boolean isLongImage(int i10, int i11) {
        return i10 > 0 && i11 > 0 && i11 > i10 * 3;
    }

    public static void removeMedia(Context context, int i10) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(i10)});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static MediaExtraInfo getVideoSize(Context context, String str) {
        String extractMetadata;
        int i10;
        int i11;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    if (PictureMimeType.isContent(str)) {
                        mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                    } else {
                        mediaMetadataRetriever.setDataSource(str);
                    }
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    mediaMetadataRetriever.release();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (!TextUtils.equals("90", extractMetadata) && !TextUtils.equals("270", extractMetadata)) {
                i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                i10 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                mediaExtraInfo.setWidth(i11);
                mediaExtraInfo.setHeight(i10);
                mediaExtraInfo.setOrientation(extractMetadata);
                mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                mediaMetadataRetriever.release();
                return mediaExtraInfo;
            }
            int i12 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            i10 = i12;
            i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
            mediaExtraInfo.setWidth(i11);
            mediaExtraInfo.setHeight(i10);
            mediaExtraInfo.setOrientation(extractMetadata);
            mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
            mediaMetadataRetriever.release();
            return mediaExtraInfo;
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            throw th;
        }
    }

    public static MediaExtraInfo getImageSize(Context context, String str) {
        BitmapFactory.Options options;
        InputStream fileInputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.isHasHttp(str)) {
            return mediaExtraInfo;
        }
        InputStream inputStream = null;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.isContent(str)) {
                    fileInputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                } else {
                    fileInputStream = new FileInputStream(str);
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            BitmapFactory.decodeStream(fileInputStream, null, options);
            mediaExtraInfo.setWidth(options.outWidth);
            mediaExtraInfo.setHeight(options.outHeight);
            PictureFileUtils.close(fileInputStream);
        } catch (Exception e11) {
            inputStream = fileInputStream;
            e = e11;
            e.printStackTrace();
            PictureFileUtils.close(inputStream);
            return mediaExtraInfo;
        } catch (Throwable th2) {
            inputStream = fileInputStream;
            th = th2;
            PictureFileUtils.close(inputStream);
            throw th;
        }
        return mediaExtraInfo;
    }

    public static void getImageSize(final Context context, final String str, final OnCallbackListener<MediaExtraInfo> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() { // from class: com.luck.picture.lib.utils.MediaUtils.1
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public MediaExtraInfo doInBackground() {
                return MediaUtils.getImageSize(context, str);
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.cancel(this);
                OnCallbackListener onCallbackListener2 = onCallbackListener;
                if (onCallbackListener2 != null) {
                    onCallbackListener2.onCall(mediaExtraInfo);
                }
            }
        });
    }
}
