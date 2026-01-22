package com.luck.picture.lib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadFileUtils {
    public static void saveLocalFile(final Context context, final String str, final String str2, final OnCallbackListener<String> onCallbackListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.utils.DownloadFileUtils.1
            /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0069 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x00f0 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x00f9 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:71:0x0176 A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x017f A[Catch: Exception -> 0x0052, TryCatch #0 {Exception -> 0x0052, blocks: (B:3:0x0006, B:6:0x002f, B:8:0x003e, B:10:0x0046, B:13:0x004f, B:14:0x0057, B:16:0x0060, B:17:0x00aa, B:19:0x01de, B:21:0x01e6, B:22:0x020e, B:24:0x021a, B:29:0x01f2, B:31:0x01fa, B:32:0x0207, B:34:0x0069, B:36:0x0073, B:37:0x0086, B:38:0x007a, B:40:0x00b8, B:43:0x00c2, B:45:0x00d1, B:47:0x00d9, B:50:0x00e2, B:51:0x00e7, B:53:0x00f0, B:54:0x013a, B:55:0x00f9, B:57:0x0103, B:58:0x0116, B:59:0x010a, B:61:0x0148, B:63:0x0157, B:65:0x015f, B:68:0x0168, B:69:0x016d, B:71:0x0176, B:72:0x01d0, B:73:0x017f, B:75:0x0187, B:77:0x018f, B:79:0x0199, B:80:0x01ac, B:81:0x01a0), top: B:2:0x0006 }] */
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public String doInBackground() {
                String str3;
                File file;
                Uri insert;
                String str4;
                File file2;
                InputStream fileInputStream;
                String str5;
                File file3;
                try {
                    ContentValues contentValues = new ContentValues();
                    String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
                    if (PictureMimeType.isHasAudio(str2)) {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("AUD_"));
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith("video") && !str2.startsWith("image")) {
                            str5 = str2;
                            contentValues.put("mime_type", str5);
                            if (!SdkVersionUtils.isQ()) {
                                contentValues.put("datetaken", valueOf);
                                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
                            } else {
                                if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                                    file3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                                } else {
                                    file3 = new File(FileDirMap.getFileDirPath(context, 3));
                                }
                                contentValues.put("_data", file3.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("AUD_") + PictureMimeType.AMR);
                            }
                            insert = context.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
                        }
                        str5 = "audio/mpeg";
                        contentValues.put("mime_type", str5);
                        if (!SdkVersionUtils.isQ()) {
                        }
                        insert = context.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else if (PictureMimeType.isHasVideo(str2)) {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO) && !str2.startsWith("image")) {
                            str4 = str2;
                            contentValues.put("mime_type", str4);
                            if (!SdkVersionUtils.isQ()) {
                                contentValues.put("datetaken", valueOf);
                                contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
                            } else {
                                if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                                    file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                                } else {
                                    file2 = new File(FileDirMap.getFileDirPath(context, 2));
                                }
                                contentValues.put("_data", file2.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("VID_") + ".mp4");
                            }
                            insert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                        }
                        str4 = "video/mp4";
                        contentValues.put("mime_type", str4);
                        if (!SdkVersionUtils.isQ()) {
                        }
                        insert = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO) && !str2.startsWith("video")) {
                            str3 = str2;
                            contentValues.put("mime_type", str3);
                            if (!SdkVersionUtils.isQ()) {
                                contentValues.put("datetaken", valueOf);
                                contentValues.put("relative_path", PictureMimeType.DCIM);
                            } else if (PictureMimeType.isHasGif(str2) || PictureMimeType.isUrlHasGif(str)) {
                                if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                                    file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                                } else {
                                    file = new File(FileDirMap.getFileDirPath(context, 1));
                                }
                                contentValues.put("_data", file.getAbsolutePath() + File.separator + DateUtils.getCreateFileName("IMG_") + ".gif");
                            }
                            insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                        }
                        str3 = "image/jpeg";
                        contentValues.put("mime_type", str3);
                        if (!SdkVersionUtils.isQ()) {
                        }
                        insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    }
                    if (insert == null) {
                        return null;
                    }
                    if (PictureMimeType.isHasHttp(str)) {
                        fileInputStream = new URL(str).openStream();
                    } else if (PictureMimeType.isContent(str)) {
                        fileInputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    } else {
                        fileInputStream = new FileInputStream(str);
                    }
                    if (PictureFileUtils.writeFileFromIS(fileInputStream, PictureContentResolver.openOutputStream(context, insert))) {
                        return PictureFileUtils.getPath(context, insert);
                    }
                    return null;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return null;
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(String str3) {
                PictureThreadUtils.cancel(this);
                OnCallbackListener onCallbackListener2 = onCallbackListener;
                if (onCallbackListener2 != null) {
                    onCallbackListener2.onCall(str3);
                }
            }
        });
    }
}
