package com.tencent.liteav.base.system;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.storage.PersistStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class p {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0061: MOVE (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:98), block:B:103:0x0061 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0176 A[Catch: all -> 0x017a, Exception -> 0x017d, TryCatch #12 {Exception -> 0x017d, all -> 0x017a, blocks: (B:36:0x0156, B:38:0x0176, B:39:0x0180, B:41:0x019e, B:42:0x01a1), top: B:35:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019e A[Catch: all -> 0x017a, Exception -> 0x017d, TryCatch #12 {Exception -> 0x017d, all -> 0x017a, blocks: (B:36:0x0156, B:38:0x0176, B:39:0x0180, B:41:0x019e, B:42:0x01a1), top: B:35:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7 A[LOOP:0: B:72:0x00c1->B:74:0x00c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8 A[LOOP:1: B:77:0x00f6->B:78:0x00f8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str2;
        String str3;
        int i;
        int i2;
        String str4;
        FileOutputStream fileOutputStream;
        File file;
        File file2;
        FileOutputStream fileOutputStream2;
        Context applicationContext = ContextUtils.getApplicationContext();
        String str5 = "";
        if (applicationContext == null) {
            return "";
        }
        FileInputStream fileInputStream3 = null;
        File externalFilesDir = applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            Log.e("UUID", "getDeviceUuid: sdcardDir is null.", new Object[0]);
            return "";
        }
        PersistStorage persistStorage = new PersistStorage("com.tencent.liteav.dev_uuid");
        String string = persistStorage.getString("com.tencent.liteav.key_dev_uuid");
        try {
            try {
                File file3 = new File(externalFilesDir.getAbsolutePath() + "/liteav/spuid");
                if (file3.exists()) {
                    fileInputStream = new FileInputStream(file3);
                    try {
                        int available = fileInputStream.available();
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            fileInputStream.read(bArr);
                            str2 = new String(bArr, "UTF-8");
                        } else {
                            str2 = null;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e("UUID", "Read UUID from file failed." + e.getMessage(), new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        str2 = null;
                        if (string == null) {
                        }
                        if (str2 == null) {
                        }
                        str3 = null;
                        if (str3 != null) {
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        while (i >= 0) {
                        }
                        while (i2 >= 0) {
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append(b(str + UUID.randomUUID().toString()));
                        str3 = sb2.toString();
                        str4 = str3;
                        if (str2 != null) {
                        }
                        try {
                            try {
                                file = new File(externalFilesDir.getAbsolutePath() + "/liteav");
                                if (!file.exists()) {
                                }
                                file2 = new File(externalFilesDir.getAbsolutePath() + "/liteav/spuid");
                                if (!file2.exists()) {
                                }
                                fileOutputStream2 = new FileOutputStream(file2);
                            } catch (Exception unused2) {
                            }
                            try {
                                fileOutputStream2.write(str4.getBytes());
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    Log.e("UUID", "Write UUID to file failed." + e.getMessage(), new Object[0]);
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (string != null) {
                                    }
                                    persistStorage.put("com.tencent.liteav.key_dev_uuid", str4);
                                    persistStorage.commit();
                                    return str4;
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                        if (string != null) {
                        }
                        persistStorage.put("com.tencent.liteav.key_dev_uuid", str4);
                        persistStorage.commit();
                        return str4;
                    }
                } else {
                    str2 = null;
                    fileInputStream = null;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream3 != null) {
            }
            throw th;
        }
        if (string == null && string.length() > 0) {
            str3 = string;
        } else if (str2 == null && str2.length() > 0) {
            str3 = str2;
        } else {
            str3 = null;
        }
        if (str3 != null || str3.length() == 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            long uptimeMillis2 = SystemClock.uptimeMillis();
            for (i = 5; i >= 0; i--) {
                str5 = str5 + String.format("%02x", Byte.valueOf((byte) ((currentTimeMillis2 >> (i * 8)) & 255)));
            }
            for (i2 = 3; i2 >= 0; i2--) {
                str5 = str5 + String.format("%02x", Byte.valueOf((byte) ((uptimeMillis2 >> (i2 * 8)) & 255)));
            }
            StringBuilder sb22 = new StringBuilder();
            sb22.append(str5);
            sb22.append(b(str + UUID.randomUUID().toString()));
            str3 = sb22.toString();
        }
        str4 = str3;
        if (str2 != null || !str2.equals(str4)) {
            file = new File(externalFilesDir.getAbsolutePath() + "/liteav");
            if (!file.exists()) {
                file.mkdir();
            }
            file2 = new File(externalFilesDir.getAbsolutePath() + "/liteav/spuid");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream2 = new FileOutputStream(file2);
            fileOutputStream2.write(str4.getBytes());
            fileOutputStream2.close();
        }
        if (string != null || !string.equals(str4)) {
            persistStorage.put("com.tencent.liteav.key_dev_uuid", str4);
            persistStorage.commit();
        }
        return str4;
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("UTF-8"));
            char[] cArr = new char[digest.length << 1];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                char[] cArr2 = a;
                cArr[i] = cArr2[(b & 240) >>> 4];
                i += 2;
                cArr[i2] = cArr2[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            Log.e("UUID", "stringToMd5 failed.", e);
            return "";
        }
    }
}
