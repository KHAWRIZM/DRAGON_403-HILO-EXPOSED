package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import com.qiahao.base_common.interfaceing.ZipListener;
import com.qiahao.nextvideo.HiloApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ*\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\tJ\u000e\u0010)\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\tJ\u001a\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100J\u001a\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u00102\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\fR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0011\u0010&\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/utilities/FileManager;", "", "<init>", "()V", "profileExternalFiles", "", "getTempImageInputFile", "Ljava/io/File;", "suffix", "", "getTempInputFile", "tempImageInputFile", "()Ljava/io/File;", "unzip", "zipFile", "targetDirectory", "deleteZip", "", "listener", "Lcom/qiahao/base_common/interfaceing/ZipListener;", "ensureDirectory", "dir", "getDownloadFolderImageOutputFile", "getDownloadFolderOutputFile", "readableFileSize", "size", "", "getDirSize", "deleteCache", "context", "Landroid/content/Context;", "deleteDir", "tempVoiceFile", "getTempVoiceFile", "getTempUrlFileName", "name", "agoraSDKLogPath", "getAgoraSDKLogPath", "cacheFilePrinter", "getCacheFilePrinter", "()Ljava/lang/String;", "getSudFile", "getTIMFile", "getCachePath", "getTempSendImgFile", "getBitmapFormUri", "Landroid/graphics/Bitmap;", "uri", "Landroid/net/Uri;", "saveBitmap2SelfDirectroy", "bitmap", "file", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileManager.kt\ncom/qiahao/nextvideo/utilities/FileManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,281:1\n1#2:282\n13472#3,2:283\n*S KotlinDebug\n*F\n+ 1 FileManager.kt\ncom/qiahao/nextvideo/utilities/FileManager\n*L\n125#1:283,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FileManager {

    @NotNull
    public static final FileManager INSTANCE = new FileManager();

    private FileManager() {
    }

    private final void ensureDirectory(File dir) {
        if (dir != null && !dir.isDirectory() && !dir.mkdirs()) {
            throw new IOException("Failed to ensure directory: " + dir.getAbsolutePath());
        }
    }

    private final String getCachePath(Context context) {
        String path;
        if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            String path2 = context.getCacheDir().getPath();
            Intrinsics.checkNotNull(path2);
            return path2;
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null || (path = externalCacheDir.getPath()) == null) {
            return "";
        }
        return path;
    }

    public static /* synthetic */ void unzip$default(FileManager fileManager, File file, File file2, boolean z, ZipListener zipListener, int i, Object obj) {
        if ((i & 8) != 0) {
            zipListener = null;
        }
        fileManager.unzip(file, file2, z, zipListener);
    }

    public final void deleteCache(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            deleteDir(context.getCacheDir());
        } catch (Exception unused) {
        }
    }

    public final boolean deleteDir(@Nullable File dir) {
        if (dir != null && dir.isDirectory()) {
            Iterator it = ArrayIteratorKt.iterator(dir.list());
            while (it.hasNext()) {
                if (!deleteDir(new File(dir, (String) it.next()))) {
                    return false;
                }
            }
            return dir.delete();
        }
        if (dir == null || !dir.isFile()) {
            return false;
        }
        return dir.delete();
    }

    @NotNull
    public final File getAgoraSDKLogPath() {
        File absoluteFile = HiloApplication.INSTANCE.getCONTEXT().getCacheDir().getAbsoluteFile();
        String str = File.separator;
        return new File(absoluteFile + str + "agorasdk" + str + "agorasdk.log");
    }

    @Nullable
    public final Bitmap getBitmapFormUri(@NotNull Context context, @Nullable Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        FileDescriptor fileDescriptor;
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri != null) {
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            openFileDescriptor = null;
        }
        if (openFileDescriptor != null) {
            fileDescriptor = openFileDescriptor.getFileDescriptor();
        } else {
            fileDescriptor = null;
        }
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        if (openFileDescriptor != null) {
            openFileDescriptor.close();
        }
        return decodeFileDescriptor;
    }

    @NotNull
    public final String getCacheFilePrinter() {
        String cachePath = getCachePath(HiloApplication.INSTANCE.getCONTEXT());
        String str = File.separator;
        File file = new File(cachePath + str + "printer");
        if (!file.exists()) {
            file.mkdir();
        }
        return cachePath + str + "printer";
    }

    public final long getDirSize(@NotNull File dir) {
        long length;
        Intrinsics.checkNotNullParameter(dir, "dir");
        long j = 0;
        try {
            File[] listFiles = dir.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file != null && file.isDirectory()) {
                        length = INSTANCE.getDirSize(file);
                    } else {
                        if (file != null && file.isFile()) {
                            length = file.length();
                        }
                    }
                    j += length;
                }
            }
        } catch (Exception unused) {
        }
        return j;
    }

    @NotNull
    public final File getDownloadFolderImageOutputFile(@NotNull String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile() + File.separator + suffix + ".jpg");
    }

    @NotNull
    public final File getDownloadFolderOutputFile(@NotNull String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile() + File.separator + suffix + ".log");
    }

    @NotNull
    public final String getSudFile(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir != null) {
            str = externalFilesDir.getPath();
        } else {
            str = null;
        }
        return str + File.separator + "SudMGPLogs";
    }

    @NotNull
    public final String getTIMFile(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir("");
        if (externalFilesDir != null) {
            str = externalFilesDir.getPath();
        } else {
            str = null;
        }
        String str2 = File.separator;
        return str + str2 + "log" + str2 + "tencent" + str2 + "imsdk";
    }

    @NotNull
    public final File getTempImageInputFile(@NotNull String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new File(HiloApplication.INSTANCE.getCONTEXT().getCacheDir().getAbsoluteFile() + File.separator + "temp" + suffix + ".jpg");
    }

    @NotNull
    public final File getTempInputFile(@NotNull String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new File(HiloApplication.INSTANCE.getCONTEXT().getCacheDir().getAbsoluteFile() + File.separator + "temp" + suffix + ".log");
    }

    @NotNull
    public final File getTempSendImgFile(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        HiloApplication.Companion companion = HiloApplication.INSTANCE;
        File absoluteFile = companion.getCONTEXT().getCacheDir().getAbsoluteFile();
        String str = File.separator;
        File file = new File(absoluteFile + str + "temp_img");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(companion.getCONTEXT().getCacheDir().getAbsoluteFile() + str + "temp_img/" + name);
    }

    @NotNull
    public final File getTempUrlFileName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        File absoluteFile = HiloApplication.INSTANCE.getCONTEXT().getCacheDir().getAbsoluteFile();
        String str = File.separator;
        return new File(absoluteFile + str + "open_file" + str + name + ".png");
    }

    @NotNull
    public final File getTempVoiceFile() {
        return new File(HiloApplication.INSTANCE.getCONTEXT().getCacheDir().getAbsoluteFile() + File.separator + "voice");
    }

    public final void profileExternalFiles() {
        File externalFilesDir = HiloApplication.INSTANCE.getCONTEXT().getExternalFilesDir("");
        ArrayList arrayList = new ArrayList();
        arrayList.add(externalFilesDir);
        while (!arrayList.isEmpty()) {
            File file = (File) arrayList.remove(arrayList.size() - 1);
            if (file != null && file.isDirectory()) {
                Iterator it = ArrayIteratorKt.iterator(file.listFiles());
                while (it.hasNext()) {
                    arrayList.add((File) it.next());
                }
            } else if (file != null) {
                file.length();
            }
        }
    }

    @NotNull
    public final String readableFileSize(long size) {
        if (size <= 0) {
            return MessageService.MSG_DB_READY_REPORT;
        }
        double d = size;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, log10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[log10];
    }

    @Nullable
    public final File saveBitmap2SelfDirectroy(@NotNull Bitmap bitmap, @Nullable File file) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void unzip(@NotNull File zipFile, @NotNull File targetDirectory, boolean deleteZip, @Nullable ZipListener listener) {
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        Intrinsics.checkNotNullParameter(targetDirectory, "targetDirectory");
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
            ZipEntry zipEntry = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        zipEntry = nextEntry;
                    } else {
                        nextEntry = null;
                    }
                    if (nextEntry != null) {
                        if (zipEntry != null) {
                            File file = new File(targetDirectory, zipEntry.getName());
                            if (zipEntry.isDirectory()) {
                                if (!file.mkdirs()) {
                                    throw new IOException("Failed to create directory: " + file.getAbsolutePath());
                                }
                            } else {
                                INSTANCE.ensureDirectory(file.getParentFile());
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    ByteStreamsKt.copyTo(zipInputStream, fileOutputStream, 8192);
                                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                } finally {
                                }
                            }
                        }
                    } else {
                        if (deleteZip) {
                            zipFile.delete();
                        }
                        if (listener != null) {
                            listener.onSuccess();
                            Unit unit = Unit.INSTANCE;
                        }
                        CloseableKt.closeFinally(zipInputStream, (Throwable) null);
                        return;
                    }
                } finally {
                }
            }
        } catch (IOException e) {
            FilesKt.deleteRecursively(targetDirectory);
            if (listener != null) {
                listener.onError(e);
            }
        }
    }

    @NotNull
    public final File getTempImageInputFile() {
        return getTempImageInputFile("");
    }
}
