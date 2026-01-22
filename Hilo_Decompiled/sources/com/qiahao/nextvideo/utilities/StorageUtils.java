package com.qiahao.nextvideo.utilities;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.provider.MediaStore;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/utilities/StorageUtils;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StorageUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IMAGE = "image";

    @NotNull
    public static final String MUSIC = "music";

    @NotNull
    public static final String VIDEO = "video";

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0018J)\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u0015J)\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020!2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0007¢\u0006\u0004\b0\u0010\u0006J\u001d\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00101\u001a\u00020\t¢\u0006\u0004\b2\u0010\fJ\u001d\u00103\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00101\u001a\u00020\t¢\u0006\u0004\b3\u0010\fJ!\u00105\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00104\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u00101\u001a\u00020\t¢\u0006\u0004\b7\u0010\fJ%\u00109\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00108\u001a\u00020\t¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b;\u0010\u001eJ\u001b\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0=2\u0006\u0010<\u001a\u00020\u0013¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b@\u0010AJ\u001f\u0010@\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0004\b@\u0010CJ\u0017\u0010D\u001a\u00020!2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010KR\u0014\u0010M\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010K¨\u0006N"}, d2 = {"Lcom/qiahao/nextvideo/utilities/StorageUtils$Companion;", "", "<init>", "()V", "", "isSdCardExist", "()Z", "Landroid/content/Context;", "context", "", "dir", "getMediaDownloadDir", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "Ljava/io/File;", "file", "getImgMimeType", "(Ljava/io/File;)Ljava/lang/String;", "fileName", "imgMimeType", "Landroid/net/Uri;", "insertImageIntoMediaStore", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "mFile", "copyMusicToPublicDir", "(Landroid/content/Context;Ljava/io/File;)Z", "copyVideoToPublicDir", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "insertMusicToMediaStore", "insertVideoMediaStore", "updateMedia", "(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", "parcelFileDescriptor", "", "writeToPublicDir", "(Ljava/io/File;Landroid/os/ParcelFileDescriptor;)V", "Ljava/io/FileInputStream;", "fis", "Ljava/io/FileOutputStream;", "fos", "copy", "(Ljava/io/FileInputStream;Ljava/io/FileOutputStream;)V", "", "getAvailSpace", "(Ljava/lang/String;)J", "Ljava/io/InputStream;", "getInputStreamCompat", "(Ljava/lang/String;)Ljava/io/InputStream;", "isQModel", "dirName", "getPicDownloadPath", "getVideoDownloadPath", "defType", "getFileTypeByPath", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getMusicDownloadPath", "type", "saveMediaToPublicDir", "(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z", "copyImageToPublicDir", "uri", "Lio/reactivex/rxjava3/core/z;", "getPathFromUri", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/z;", "getUriFromPath", "(Ljava/lang/String;)Landroid/net/Uri;", "isPhoto", "(Ljava/lang/String;Z)Landroid/net/Uri;", "deleteRawFile", "(Ljava/io/File;)V", "getAbsolutePathFromUri", "(Landroid/net/Uri;)Ljava/lang/String;", "getFileCompat", "(Ljava/lang/String;)Ljava/io/File;", "IMAGE", "Ljava/lang/String;", "MUSIC", "VIDEO", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStorageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageUtils.kt\ncom/qiahao/nextvideo/utilities/StorageUtils$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,574:1\n1#2:575\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0053 A[Catch: IOException -> 0x0057, TryCatch #0 {IOException -> 0x0057, blocks: (B:29:0x004e, B:31:0x0053, B:32:0x0059, B:34:0x005e), top: B:28:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x005e A[Catch: IOException -> 0x0057, TRY_LEAVE, TryCatch #0 {IOException -> 0x0057, blocks: (B:29:0x004e, B:31:0x0053, B:32:0x0059, B:34:0x005e), top: B:28:0x004e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void copy(FileInputStream fis, FileOutputStream fos) {
            Throwable th;
            FileChannel fileChannel;
            IOException iOException;
            FileChannel channel;
            FileChannel fileChannel2 = null;
            try {
                try {
                    channel = fis.getChannel();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (IOException e2) {
                iOException = e2;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
            try {
                fileChannel2 = fos.getChannel();
                channel.transferTo(0L, channel.size(), fileChannel2);
                fis.close();
                channel.close();
                fos.close();
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
            } catch (IOException e3) {
                iOException = e3;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                try {
                    iOException.printStackTrace();
                    fis.close();
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    fos.close();
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        fis.close();
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        fos.close();
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                fis.close();
                if (fileChannel2 != null) {
                }
                fos.close();
                if (fileChannel != null) {
                }
                throw th;
            }
        }

        private final boolean copyMusicToPublicDir(Context context, File mFile) {
            ParcelFileDescriptor openFileDescriptor;
            if (!isQModel()) {
                try {
                    updateMedia(context, mFile);
                    return true;
                } catch (FileNotFoundException unused) {
                    return false;
                }
            }
            String name = mFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String absolutePath = mFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            Uri insertMusicToMediaStore = insertMusicToMediaStore(context, name, absolutePath);
            if (insertMusicToMediaStore != null && (openFileDescriptor = context.getContentResolver().openFileDescriptor(insertMusicToMediaStore, "w")) != null) {
                StorageUtils.INSTANCE.writeToPublicDir(mFile, openFileDescriptor);
                return true;
            }
            return true;
        }

        private final boolean copyVideoToPublicDir(Context context, File mFile) {
            ParcelFileDescriptor openFileDescriptor;
            if (!isQModel()) {
                try {
                    updateMedia(context, mFile);
                    return true;
                } catch (FileNotFoundException unused) {
                    return false;
                }
            }
            String name = mFile.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String absolutePath = mFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            Uri insertVideoMediaStore = insertVideoMediaStore(context, name, absolutePath);
            if (insertVideoMediaStore != null && (openFileDescriptor = context.getContentResolver().openFileDescriptor(insertVideoMediaStore, "w")) != null) {
                StorageUtils.INSTANCE.writeToPublicDir(mFile, openFileDescriptor);
                return true;
            }
            return true;
        }

        private final long getAvailSpace(String path) {
            StatFs statFs = new StatFs(path);
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }

        public static /* synthetic */ String getFileTypeByPath$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.getFileTypeByPath(str, str2);
        }

        private final String getImgMimeType(File file) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            String str = options.outMimeType;
            Intrinsics.checkNotNullExpressionValue(str, "outMimeType");
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
        
            if (r2 == null) goto L٣٢;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0061, code lost:
        
            if (r2 == null) goto L٣٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0063, code lost:
        
            r2.close();
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0050: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:81), block:B:41:0x0050 */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r10v7, types: [java.io.InputStream] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final InputStream getInputStreamCompat(String path) {
            Object obj;
            Cursor cursor;
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
            Cursor cursor2 = null;
            try {
                try {
                    try {
                        Uri contentUri = MediaStore.Files.getContentUri("external");
                        HiloApplication.Companion companion = HiloApplication.INSTANCE;
                        cursor = companion.getCONTEXT().getContentResolver().query(contentUri, null, "_data= ?", new String[]{path}, null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    int columnIndex = cursor.getColumnIndex("_id");
                                    if (columnIndex < 0) {
                                        cursor.close();
                                        return null;
                                    }
                                    Uri withAppendedId = ContentUris.withAppendedId(contentUri, cursor.getLong(columnIndex));
                                    Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                                    ?? openInputStream = companion.getCONTEXT().getContentResolver().openInputStream(withAppendedId);
                                    r0 = openInputStream;
                                    path = openInputStream;
                                }
                            } catch (IOException e) {
                                e = e;
                                r0 = r0;
                                e.printStackTrace();
                            } catch (SecurityException unused) {
                                cursor2 = cursor;
                                FileInputStream fileInputStream = new FileInputStream(new File(path));
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                r0 = fileInputStream;
                                return r0;
                            }
                        }
                        r0 = new FileInputStream(new File(path));
                        path = path;
                    } catch (Throwable th) {
                        th = th;
                        if (r0 != 0) {
                            r0.close();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    cursor = null;
                } catch (SecurityException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = obj;
            }
        }

        private final String getMediaDownloadDir(Context context, String dir) {
            String absolutePath;
            if (!isSdCardExist()) {
                String absolutePath2 = context.getCacheDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                return absolutePath2;
            }
            if (isQModel()) {
                File externalFilesDir = context.getExternalFilesDir(null);
                File file = new File(externalFilesDir, dir);
                if (!file.exists() && !file.mkdirs()) {
                    if (externalFilesDir != null && (absolutePath = externalFilesDir.getAbsolutePath()) != null) {
                        String str = absolutePath + dir;
                        if (str != null) {
                            return str;
                        }
                    }
                    return "";
                }
                String path = file.getPath();
                Intrinsics.checkNotNull(path);
                return path;
            }
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + dir;
            File file2 = new File(str2);
            if (!file2.exists() && !file2.mkdirs()) {
                return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void getPathFromUri$lambda$8(ContentResolver contentResolver, Uri uri, io.reactivex.rxjava3.core.b0 b0Var) {
            Exception exc;
            Intrinsics.checkNotNullParameter(b0Var, "emitter");
            if (StorageUtils.INSTANCE.isQModel()) {
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    File file = new File(HiloApplication.INSTANCE.getCONTEXT().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "compress");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    Intrinsics.checkNotNull(openInputStream);
                    com.qhqc.core.basic.utils.b.a(openInputStream, fileOutputStream);
                    openInputStream.close();
                    fileOutputStream.close();
                    if (!b0Var.isDisposed()) {
                        b0Var.onNext(file.getAbsolutePath());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    if (!b0Var.isDisposed()) {
                        b0Var.onError(e);
                        return;
                    }
                    return;
                }
            }
            String str = "";
            Cursor cursor = null;
            try {
                try {
                    cursor = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        str = cursor.getString(cursor.getColumnIndex("_data"));
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                        if (!b0Var.isDisposed()) {
                            b0Var.onNext("");
                        }
                    } else if (!b0Var.isDisposed()) {
                        b0Var.onError(new Exception("uri is invalid"));
                    }
                    throw th;
                }
            } catch (Exception e2) {
                if (!b0Var.isDisposed()) {
                    b0Var.onError(e2);
                }
                if (cursor != null) {
                    cursor.close();
                    if (b0Var.isDisposed()) {
                        return;
                    }
                } else if (!b0Var.isDisposed()) {
                    exc = new Exception("uri is invalid");
                } else {
                    return;
                }
            }
            if (cursor != null) {
                cursor.close();
                if (b0Var.isDisposed()) {
                    return;
                }
                b0Var.onNext(str);
                return;
            }
            if (!b0Var.isDisposed()) {
                exc = new Exception("uri is invalid");
                b0Var.onError(exc);
            }
        }

        private final Uri insertImageIntoMediaStore(Context context, String fileName, String imgMimeType) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", fileName);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            }
            contentValues.put("mime_type", imgMimeType);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }

        private final Uri insertMusicToMediaStore(Context context, String fileName, String path) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", fileName);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("owner_package_name", context.getApplicationContext().getPackageName());
            }
            contentValues.put("mime_type", "audio/mp3");
            return context.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
        }

        private final Uri insertVideoMediaStore(Context context, String fileName, String path) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", fileName);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("owner_package_name", context.getApplicationContext().getPackageName());
            }
            contentValues.put("mime_type", "video/mp4");
            return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        }

        private final boolean isSdCardExist() {
            return Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted");
        }

        private final Uri updateMedia(Context context, File file) {
            if (!file.exists()) {
                return null;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
            return Uri.fromFile(file);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x001f -> B:12:0x0046). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void writeToPublicDir(File file, ParcelFileDescriptor parcelFileDescriptor) {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                        try {
                            copy(fileInputStream2, fileOutputStream);
                            try {
                                fileInputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            fileOutputStream.close();
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }

        @Nullable
        public final Uri copyImageToPublicDir(@NotNull Context context, @NotNull File mFile) {
            ParcelFileDescriptor openFileDescriptor;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mFile, "mFile");
            try {
                if (!isQModel()) {
                    return updateMedia(context, mFile);
                }
                String imgMimeType = getImgMimeType(mFile);
                String name = mFile.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Uri insertImageIntoMediaStore = insertImageIntoMediaStore(context, name, imgMimeType);
                if (insertImageIntoMediaStore != null && (openFileDescriptor = context.getContentResolver().openFileDescriptor(insertImageIntoMediaStore, "w")) != null) {
                    StorageUtils.INSTANCE.writeToPublicDir(mFile, openFileDescriptor);
                }
                return insertImageIntoMediaStore;
            } catch (FileNotFoundException unused) {
                return null;
            }
        }

        public final void deleteRawFile(@Nullable File file) {
            if (file != null) {
                try {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @NotNull
        public final String getAbsolutePathFromUri(@Nullable Uri uri) {
            String str;
            if (uri == null) {
                return "";
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = HiloApplication.INSTANCE.getCONTEXT().getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                    if (cursor == null || !cursor.moveToFirst()) {
                        str = "";
                    } else {
                        str = cursor.getString(cursor.getColumnIndex("_data"));
                    }
                    if (cursor == null) {
                        return "";
                    }
                    cursor.close();
                    return str;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "";
                }
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                }
                return "";
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00dd, code lost:
        
            if (r2 != null) goto L٥٠;
         */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00e9  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final File getFileCompat(@NotNull String path) {
            FileOutputStream fileOutputStream;
            File file;
            InputStream inputStreamCompat;
            String str;
            String str2;
            int lastIndexOf$default;
            int lastIndexOf$default2;
            Intrinsics.checkNotNullParameter(path, TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH);
            InputStream inputStream = null;
            try {
                inputStreamCompat = getInputStreamCompat(path);
            } catch (IOException e) {
                e = e;
                file = null;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            if (inputStreamCompat == null) {
                return null;
            }
            try {
                try {
                    String str3 = "";
                    if (!StringsKt.contains$default(path, "/", false, 2, (Object) null) || (lastIndexOf$default2 = StringsKt.lastIndexOf$default(path, "/", 0, false, 6, (Object) null) + 1) <= 0 || lastIndexOf$default2 >= path.length()) {
                        str = "";
                    } else {
                        str = path.substring(lastIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                    }
                    if (!StringsKt.contains$default(str, ".", false, 2, (Object) null) || (lastIndexOf$default = StringsKt.lastIndexOf$default(str, ".", 0, false, 6, (Object) null)) <= 0 || lastIndexOf$default >= str.length()) {
                        str2 = "";
                    } else {
                        str2 = str.substring(lastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                    }
                    if (!StringsKt.contains$default(str2, "/", false, 2, (Object) null)) {
                        str3 = str2;
                    }
                    File file2 = new File(HiloApplication.INSTANCE.getCONTEXT().getCacheDir(), "upload_cache");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(file2, "cache_" + System.currentTimeMillis() + str3);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                file = null;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStreamCompat.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                inputStreamCompat.close();
            } catch (IOException e4) {
                e = e4;
                inputStream = inputStreamCompat;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = inputStreamCompat;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            fileOutputStream.close();
            return file;
        }

        @NotNull
        public final String getFileTypeByPath(@Nullable String path, @NotNull String defType) {
            String str;
            String str2;
            int lastIndexOf$default;
            int lastIndexOf$default2;
            Intrinsics.checkNotNullParameter(defType, "defType");
            if (path != null && path.length() != 0) {
                String str3 = "";
                if (!StringsKt.contains$default(path, "/", false, 2, (Object) null) || (lastIndexOf$default2 = StringsKt.lastIndexOf$default(path, "/", 0, false, 6, (Object) null) + 1) <= 0 || lastIndexOf$default2 >= path.length()) {
                    str = "";
                } else {
                    str = path.substring(lastIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                }
                if (!StringsKt.contains$default(str, ".", false, 2, (Object) null) || (lastIndexOf$default = StringsKt.lastIndexOf$default(str, ".", 0, false, 6, (Object) null)) <= 0 || lastIndexOf$default >= str.length()) {
                    str2 = "";
                } else {
                    str2 = str.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                }
                if (!StringsKt.contains$default(str2, "/", false, 2, (Object) null)) {
                    str3 = str2;
                }
                if (str3.length() != 0) {
                    return str3;
                }
                return defType;
            }
            return defType;
        }

        @NotNull
        public final String getMusicDownloadPath(@NotNull Context context, @NotNull String dirName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dirName, "dirName");
            String str = getMediaDownloadDir(context, "/StarChat/music") + "/" + dirName;
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                }
            }
            return str;
        }

        @NotNull
        public final io.reactivex.rxjava3.core.z<String> getPathFromUri(@NotNull final Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            final ContentResolver contentResolver = HiloApplication.INSTANCE.getCONTEXT().getContentResolver();
            io.reactivex.rxjava3.core.z<String> create = io.reactivex.rxjava3.core.z.create(new io.reactivex.rxjava3.core.c0() { // from class: com.qiahao.nextvideo.utilities.u0
                public final void a(io.reactivex.rxjava3.core.b0 b0Var) {
                    StorageUtils.Companion.getPathFromUri$lambda$8(contentResolver, uri, b0Var);
                }
            });
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }

        @NotNull
        public final String getPicDownloadPath(@NotNull Context context, @NotNull String dirName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dirName, "dirName");
            String str = getMediaDownloadDir(context, "/StarChat/pic") + "/" + dirName;
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                }
            }
            return str;
        }

        @Nullable
        public final Uri getUriFromPath(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH);
            return getUriFromPath(path, true);
        }

        @NotNull
        public final String getVideoDownloadPath(@NotNull Context context, @NotNull String dirName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dirName, "dirName");
            String str = getMediaDownloadDir(context, "/StarChat/video") + "/" + dirName;
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                }
            }
            return str;
        }

        @JvmStatic
        public final boolean isQModel() {
            if (Build.VERSION.SDK_INT >= 29 && !u4.e.a()) {
                return true;
            }
            return false;
        }

        public final boolean saveMediaToPublicDir(@NotNull Context context, @NotNull File file, @NotNull String type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            if (hashCode != 100313435) {
                if (hashCode != 104263205) {
                    if (hashCode == 112202875 && type.equals("video")) {
                        return copyVideoToPublicDir(context, file);
                    }
                } else if (type.equals("music")) {
                    return copyMusicToPublicDir(context, file);
                }
            } else {
                if (!type.equals("image") || copyImageToPublicDir(context, file) == null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Uri getUriFromPath(@NotNull String path, boolean isPhoto) {
            Cursor cursor;
            Uri uri;
            Intrinsics.checkNotNullParameter(path, TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH);
            Cursor cursor2 = null;
            r6 = null;
            r6 = null;
            r6 = null;
            Uri uri2 = null;
            try {
                if (isPhoto) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                }
                Cursor query = HiloApplication.INSTANCE.getCONTEXT().getContentResolver().query(uri, null, "_data= ?", new String[]{path}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            int columnIndex = query.getColumnIndex("_id");
                            if (columnIndex < 0) {
                                query.close();
                                return null;
                            }
                            uri2 = ContentUris.withAppendedId(uri, query.getLong(columnIndex));
                        }
                    } catch (Exception e) {
                        cursor = query;
                        e = e;
                        try {
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                            return uri2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            return uri2;
        }
    }

    @JvmStatic
    public static final boolean isQModel() {
        return INSTANCE.isQModel();
    }
}
