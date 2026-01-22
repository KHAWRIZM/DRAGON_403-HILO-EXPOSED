package u;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f١٨٢٢٥a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f١٨٢٢٦b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d A[Catch: IOException -> 0x002a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x002a, blocks: (B:16:0x0026, B:25:0x003d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        ?? r12;
        byte[] bArr = null;
        try {
            if (file != null) {
                try {
                    r12 = new FileInputStream(file);
                } catch (IOException e10) {
                    e = e10;
                    r12 = 0;
                    try {
                        e.printStackTrace();
                        if (r12 != 0) {
                            r12.close();
                        }
                        return c(bArr, true);
                    } catch (Throwable th) {
                        th = th;
                        bArr = r12;
                        r12 = bArr;
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (NoSuchAlgorithmException e12) {
                    e = e12;
                    r12 = 0;
                    e.printStackTrace();
                    if (r12 != 0) {
                    }
                    return c(bArr, true);
                } catch (Throwable th2) {
                    th = th2;
                    r12 = bArr;
                    if (r12 != 0) {
                    }
                    throw th;
                }
                try {
                    DigestInputStream digestInputStream = new DigestInputStream(r12, MessageDigest.getInstance("MD5"));
                    do {
                    } while (digestInputStream.read(new byte[262144]) > 0);
                    bArr = digestInputStream.getMessageDigest().digest();
                    r12.close();
                } catch (IOException e13) {
                    e = e13;
                    e.printStackTrace();
                    if (r12 != 0) {
                    }
                    return c(bArr, true);
                } catch (NoSuchAlgorithmException e14) {
                    e = e14;
                    e.printStackTrace();
                    if (r12 != 0) {
                    }
                    return c(bArr, true);
                } catch (Throwable th3) {
                    th = th3;
                    if (r12 != 0) {
                    }
                    throw th;
                }
            }
        } catch (IOException e15) {
            e15.printStackTrace();
        }
        return c(bArr, true);
    }

    public static String b(String str) {
        try {
            return c(MessageDigest.getInstance("md5").digest(str.getBytes()), false);
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String c(byte[] bArr, boolean z10) {
        char[] cArr;
        if (bArr == null) {
            return "";
        }
        if (z10) {
            cArr = f١٨٢٢٥a;
        } else {
            cArr = f١٨٢٢٦b;
        }
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 >> 4) & 15];
            i10 += 2;
            cArr2[i11] = cArr[b10 & 15];
        }
        return new String(cArr2);
    }
}
