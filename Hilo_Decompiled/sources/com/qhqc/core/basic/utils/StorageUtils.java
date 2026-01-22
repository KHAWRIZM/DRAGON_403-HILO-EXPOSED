package com.qhqc.core.basic.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/qhqc/core/basic/utils/StorageUtils;", "", "()V", "getFileCompat", "Ljava/io/File;", "path", "", "getInputStreamCompat", "Ljava/io/InputStream;", "getPathFromUriSync", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "isQModel", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStorageUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StorageUtils.kt\ncom/qhqc/core/basic/utils/StorageUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n1#2:161\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class StorageUtils {

    @NotNull
    public static final StorageUtils INSTANCE = new StorageUtils();

    private StorageUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
    
        if (r2 == null) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x005f, code lost:
    
        if (r2 == null) goto L٣٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0061, code lost:
    
        r2.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:79), block:B:41:0x004e */
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
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final InputStream getInputStreamCompat(String path) {
        Object obj;
        Cursor cursor;
        ?? r02 = 0;
        r02 = 0;
        r02 = 0;
        Cursor cursor2 = null;
        try {
            try {
                try {
                    Uri contentUri = MediaStore.Files.getContentUri("external");
                    cursor = BasicModuleApp.application().getContentResolver().query(contentUri, null, "_data= ?", new String[]{path}, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex(TransferTable.COLUMN_ID);
                                if (columnIndex < 0) {
                                    cursor.close();
                                    return null;
                                }
                                Uri withAppendedId = ContentUris.withAppendedId(contentUri, cursor.getLong(columnIndex));
                                Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                                ?? openInputStream = BasicModuleApp.application().getContentResolver().openInputStream(withAppendedId);
                                r02 = openInputStream;
                                path = openInputStream;
                            }
                        } catch (IOException e10) {
                            e = e10;
                            r02 = r02;
                            e.printStackTrace();
                        } catch (SecurityException unused) {
                            cursor2 = cursor;
                            FileInputStream fileInputStream = new FileInputStream(new File(path));
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            r02 = fileInputStream;
                            return r02;
                        }
                    }
                    r02 = new FileInputStream(new File(path));
                    path = path;
                } catch (Throwable th) {
                    th = th;
                    if (r02 != 0) {
                        r02.close();
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                cursor = null;
            } catch (SecurityException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            r02 = obj;
        }
    }

    @JvmStatic
    public static final boolean isQModel() {
        boolean isExternalStorageLegacy;
        if (Build.VERSION.SDK_INT >= 29) {
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (!isExternalStorageLegacy) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00db, code lost:
    
        if (r2 != null) goto L٥٠;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7  */
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
        Intrinsics.checkNotNullParameter(path, "path");
        InputStream inputStream = null;
        try {
            inputStreamCompat = getInputStreamCompat(path);
        } catch (IOException e10) {
            e = e10;
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
                if (!StringsKt.contains$default((CharSequence) path, (CharSequence) "/", false, 2, (Object) null) || (lastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) path, "/", 0, false, 6, (Object) null) + 1) <= 0 || lastIndexOf$default2 >= path.length()) {
                    str = "";
                } else {
                    str = path.substring(lastIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                }
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) InstructionFileId.DOT, false, 2, (Object) null) || (lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, InstructionFileId.DOT, 0, false, 6, (Object) null)) <= 0 || lastIndexOf$default >= str.length()) {
                    str2 = "";
                } else {
                    str2 = str.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                }
                if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "/", false, 2, (Object) null)) {
                    str3 = str2;
                }
                File file2 = new File(BasicModuleApp.application().getCacheDir(), "upload_cache");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, "cache_" + System.currentTimeMillis() + str3);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e11) {
                    e = e11;
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException e12) {
            e = e12;
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
        } catch (IOException e13) {
            e = e13;
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getPathFromUriSync(@NotNull Uri uri) {
        Cursor cursor;
        String string;
        Intrinsics.checkNotNullParameter(uri, "uri");
        ContentResolver contentResolver = BasicModuleApp.application().getContentResolver();
        Cursor cursor2 = null;
        if (isQModel()) {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                File file = new File(BasicModuleApp.application().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "compress");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                Intrinsics.checkNotNull(openInputStream);
                FileUtils.copy(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            cursor = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        string = cursor.getString(cursor.getColumnIndex("_data"));
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Exception unused2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            string = "";
            if (cursor != null) {
            }
            return string;
        } catch (Exception unused3) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
