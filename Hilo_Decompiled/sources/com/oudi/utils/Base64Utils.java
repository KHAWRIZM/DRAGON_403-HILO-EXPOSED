package com.oudi.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.liulishuo.okdownload.DownloadTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import kotlin.KotlinVersion;
import kotlin.UByte;
import okio.Utf8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class Base64Utils {
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static final byte[] codes = new byte[256];
    private static Base64Utils utils;

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            codes[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            codes[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            codes[i12] = (byte) (i12 - 71);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            codes[i13] = (byte) (i13 + 4);
        }
        byte[] bArr = codes;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static boolean base64ToFile(String str, String str2) {
        byte[] decode = Base64.decode(str, 2);
        for (int i10 = 0; i10 < decode.length; i10++) {
            byte b10 = decode[i10];
            if (b10 < 0) {
                decode[i10] = (byte) (b10 + UByte.MIN_VALUE);
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            fileOutputStream.write(decode);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return false;
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static String decode(String str) {
        return new String(decode(str.toCharArray()));
    }

    public static String encode(String str) {
        return new String(encode(str.getBytes()));
    }

    public static Base64Utils getInstance() {
        if (utils == null) {
            synchronized (Base64Utils.class) {
                try {
                    if (utils == null) {
                        utils = new Base64Utils();
                    }
                } finally {
                }
            }
        }
        return utils;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String imageToBase64(String str) {
        ?? r02;
        String str2 = null;
        try {
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            r02 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[r02.available()];
                r02.read(bArr);
                str2 = Base64.encodeToString(bArr, 0);
                r02.close();
            } catch (Exception e11) {
                e = e11;
                try {
                    e.printStackTrace();
                    if (r02 != 0) {
                        r02.close();
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    str2 = r02;
                    r02 = str2;
                    if (r02 != 0) {
                        try {
                            r02.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (r02 != 0) {
                }
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            r02 = 0;
        } catch (Throwable th3) {
            th = th3;
            r02 = str2;
            if (r02 != 0) {
            }
            throw th;
        }
        return str2;
    }

    private static byte[] readBytes(File file) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream2 = null;
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream3);
                try {
                    byte[] bArr = new byte[DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream3.close();
                        bufferedInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e10) {
                        System.out.println(e10);
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    fileInputStream = fileInputStream3;
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e11) {
                            System.out.println(e11);
                            throw th;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                fileInputStream = fileInputStream3;
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    private static char[] readChars(File file) {
        FileReader fileReader;
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                try {
                    char[] cArr = new char[DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE];
                    while (true) {
                        int read = bufferedReader2.read(cArr);
                        if (read != -1) {
                            if (read > 0) {
                                charArrayWriter.write(cArr, 0, read);
                            }
                        } else {
                            try {
                                break;
                            } catch (Exception e10) {
                                System.out.println(e10);
                            }
                        }
                    }
                    charArrayWriter.close();
                    bufferedReader2.close();
                    fileReader.close();
                    return charArrayWriter.toCharArray();
                } catch (Throwable th) {
                    bufferedReader = bufferedReader2;
                    th = th;
                    try {
                        charArrayWriter.close();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    } catch (Exception e11) {
                        System.out.println(e11);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
    }

    private static void writeBytes(File file, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                try {
                    bufferedOutputStream2.write(bArr);
                    try {
                        bufferedOutputStream2.close();
                        fileOutputStream.close();
                    } catch (Exception e10) {
                        System.out.println(e10);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e11) {
                            System.out.println(e11);
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private static void writeChars(File file, char[] cArr) {
        Throwable th;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter2.write(cArr);
                    try {
                        bufferedWriter2.close();
                        fileWriter.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileWriter = null;
        }
    }

    public static byte[] decode(char[] cArr) {
        int length = cArr.length;
        for (char c10 : cArr) {
            if (c10 > 255 || codes[c10] < 0) {
                length--;
            }
        }
        int i10 = (length / 4) * 3;
        int i11 = length % 4;
        if (i11 == 3) {
            i10 += 2;
        }
        if (i11 == 2) {
            i10++;
        }
        byte[] bArr = new byte[i10];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < cArr.length; i15++) {
            char c11 = cArr[i15];
            byte b10 = c11 > 255 ? (byte) -1 : codes[c11];
            if (b10 >= 0) {
                int i16 = i14 + 6;
                i13 = (i13 << 6) | b10;
                if (i16 >= 8) {
                    i14 -= 2;
                    bArr[i12] = (byte) ((i13 >> i14) & KotlinVersion.MAX_COMPONENT_VALUE);
                    i12++;
                } else {
                    i14 = i16;
                }
            }
        }
        if (i12 == i10) {
            return bArr;
        }
        throw new Error("Miscalculated data length (wrote " + i12 + " instead of " + i10 + ")");
    }

    public static char[] encode(byte[] bArr) {
        boolean z10;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i10 = 0;
        int i11 = 0;
        while (i10 < bArr.length) {
            int i12 = (bArr[i10] & UByte.MAX_VALUE) << 8;
            int i13 = i10 + 1;
            boolean z11 = true;
            if (i13 < bArr.length) {
                i12 |= bArr[i13] & UByte.MAX_VALUE;
                z10 = true;
            } else {
                z10 = false;
            }
            int i14 = i12 << 8;
            int i15 = i10 + 2;
            if (i15 < bArr.length) {
                i14 |= bArr[i15] & UByte.MAX_VALUE;
            } else {
                z11 = false;
            }
            int i16 = i11 + 3;
            char[] cArr2 = alphabet;
            int i17 = 64;
            cArr[i16] = cArr2[z11 ? i14 & 63 : 64];
            int i18 = i14 >> 6;
            int i19 = i11 + 2;
            if (z10) {
                i17 = i18 & 63;
            }
            cArr[i19] = cArr2[i17];
            cArr[i11 + 1] = cArr2[(i14 >> 12) & 63];
            cArr[i11] = cArr2[(i14 >> 18) & 63];
            i10 += 3;
            i11 += 4;
        }
        return cArr;
    }

    public static void decode(File file) {
        if (!file.exists()) {
            System.exit(0);
        } else {
            writeBytes(file, decode(readChars(file)));
        }
    }

    public static void encode(File file) {
        if (!file.exists()) {
            System.exit(0);
        } else {
            writeChars(file, encode(readBytes(file)));
        }
    }
}
