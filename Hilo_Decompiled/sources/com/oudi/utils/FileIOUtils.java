package com.oudi.utils;

import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FileIOUtils {
    private static int sBufferSize = 524288;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnProgressUpdateListener {
        void onProgressUpdate(double d10);
    }

    private FileIOUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void copy(Context context, String str, String str2, String str3) {
        String str4 = str2 + "/" + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            if (!new File(str4).exists()) {
                InputStream open = context.getResources().getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str4);
                byte[] bArr = new byte[7168];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        open.close();
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static boolean createOrExistsDir(File file) {
        if (file != null && (!file.exists() ? file.mkdirs() : file.isDirectory())) {
            return true;
        }
        return false;
    }

    private static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    private static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    private static byte[] is2Bytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[sBufferSize];
                    while (true) {
                        int read = inputStream.read(bArr, 0, sBufferSize);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    return byteArray;
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (IOException e15) {
                e = e15;
                byteArrayOutputStream = null;
            } catch (Throwable th) {
                th = th;
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                if (0 != 0) {
                    try {
                        byteArrayOutputStream2.close();
                        throw th;
                    } catch (IOException e17) {
                        e17.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isFileExists(File file) {
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static byte[] readFile2BytesByChannel(String str) {
        return readFile2BytesByChannel(getFileByPath(str));
    }

    public static byte[] readFile2BytesByMap(String str) {
        return readFile2BytesByMap(getFileByPath(str));
    }

    public static byte[] readFile2BytesByStream(String str) {
        return readFile2BytesByStream(getFileByPath(str), (OnProgressUpdateListener) null);
    }

    public static List<String> readFile2List(String str) {
        return readFile2List(getFileByPath(str), (String) null);
    }

    public static String readFile2String(String str) {
        return readFile2String(getFileByPath(str), (String) null);
    }

    public static void setBufferSize(int i10) {
        sBufferSize = i10;
    }

    public static boolean writeFileFromBytesByChannel(String str, byte[] bArr, boolean z10) {
        return writeFileFromBytesByChannel(getFileByPath(str), bArr, false, z10);
    }

    public static boolean writeFileFromBytesByMap(String str, byte[] bArr, boolean z10) {
        return writeFileFromBytesByMap(str, bArr, false, z10);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr) {
        return writeFileFromBytesByStream(getFileByPath(str), bArr, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream) {
        return writeFileFromIS(getFileByPath(str), inputStream, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromString(String str, String str2) {
        return writeFileFromString(getFileByPath(str), str2, false);
    }

    private static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile2BytesByChannel(File file) {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        if (!isFileExists(file)) {
            return null;
        }
        try {
            fileChannel = new RandomAccessFile(file, "r").getChannel();
            try {
                try {
                    ByteBuffer allocate = ByteBuffer.allocate((int) fileChannel.size());
                    do {
                    } while (fileChannel.read(allocate) > 0);
                    byte[] array = allocate.array();
                    try {
                        fileChannel.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    return array;
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileChannel2 = fileChannel;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile2BytesByMap(File file) {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        if (!isFileExists(file)) {
            return null;
        }
        try {
            fileChannel = new RandomAccessFile(file, "r").getChannel();
            try {
                try {
                    int size = (int) fileChannel.size();
                    byte[] bArr = new byte[size];
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, size).load().get(bArr, 0, size);
                    try {
                        fileChannel.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    return bArr;
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileChannel2 = fileChannel;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel2 != null) {
            }
            throw th;
        }
    }

    public static byte[] readFile2BytesByStream(File file) {
        return readFile2BytesByStream(file, (OnProgressUpdateListener) null);
    }

    public static List<String> readFile2List(String str, String str2) {
        return readFile2List(getFileByPath(str), str2);
    }

    public static String readFile2String(String str, String str2) {
        return readFile2String(getFileByPath(str), str2);
    }

    public static boolean writeFileFromBytesByChannel(String str, byte[] bArr, boolean z10, boolean z11) {
        return writeFileFromBytesByChannel(getFileByPath(str), bArr, z10, z11);
    }

    public static boolean writeFileFromBytesByMap(String str, byte[] bArr, boolean z10, boolean z11) {
        return writeFileFromBytesByMap(getFileByPath(str), bArr, z10, z11);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, boolean z10) {
        return writeFileFromBytesByStream(getFileByPath(str), bArr, z10, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z10) {
        return writeFileFromIS(getFileByPath(str), inputStream, z10, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromString(String str, String str2, boolean z10) {
        return writeFileFromString(getFileByPath(str), str2, z10);
    }

    public static byte[] readFile2BytesByStream(String str, OnProgressUpdateListener onProgressUpdateListener) {
        return readFile2BytesByStream(getFileByPath(str));
    }

    public static List<String> readFile2List(File file) {
        return readFile2List(file, 0, Integer.MAX_VALUE, (String) null);
    }

    public static String readFile2String(File file) {
        return readFile2String(file, (String) null);
    }

    public static boolean writeFileFromBytesByChannel(File file, byte[] bArr, boolean z10) {
        return writeFileFromBytesByChannel(file, bArr, false, z10);
    }

    public static boolean writeFileFromBytesByMap(File file, byte[] bArr, boolean z10) {
        return writeFileFromBytesByMap(file, bArr, false, z10);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr) {
        return writeFileFromBytesByStream(file, bArr, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream) {
        return writeFileFromIS(file, inputStream, false, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromString(File file, String str) {
        return writeFileFromString(file, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[Catch: FileNotFoundException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #4 {FileNotFoundException -> 0x0063, blocks: (B:6:0x0008, B:25:0x005f, B:27:0x0057, B:65:0x0086, B:61:0x0093, B:60:0x0090, B:45:0x007d, B:48:0x0073, B:53:0x0081, B:18:0x0052, B:38:0x006e, B:56:0x008b, B:21:0x005a, B:42:0x0078), top: B:5:0x0008, inners: #1, #2, #5, #6, #8, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile2BytesByStream(File file, OnProgressUpdateListener onProgressUpdateListener) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        if (!isFileExists(file)) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), sBufferSize);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[sBufferSize];
                        if (onProgressUpdateListener != null) {
                            double available = bufferedInputStream.available();
                            onProgressUpdateListener.onProgressUpdate(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            int i10 = 0;
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, sBufferSize);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                i10 += read;
                                onProgressUpdateListener.onProgressUpdate(i10 / available);
                            }
                        } else {
                            while (true) {
                                int read2 = bufferedInputStream.read(bArr, 0, sBufferSize);
                                if (read2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read2);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        return byteArray;
                    } catch (IOException e12) {
                        e = e12;
                        e.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                    if (byteArrayOutputStream == null) {
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                bufferedInputStream.close();
                if (byteArrayOutputStream == null) {
                }
            }
        } catch (FileNotFoundException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static List<String> readFile2List(File file, String str) {
        return readFile2List(file, 0, Integer.MAX_VALUE, str);
    }

    public static String readFile2String(File file, String str) {
        byte[] readFile2BytesByStream = readFile2BytesByStream(file);
        if (readFile2BytesByStream == null) {
            return null;
        }
        if (isSpace(str)) {
            return new String(readFile2BytesByStream);
        }
        try {
            return new String(readFile2BytesByStream, str);
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static boolean writeFileFromBytesByChannel(File file, byte[] bArr, boolean z10, boolean z11) {
        if (bArr == null || !createOrExistsFile(file)) {
            return false;
        }
        FileChannel fileChannel = null;
        try {
            try {
                fileChannel = new FileOutputStream(file, z10).getChannel();
                fileChannel.position(fileChannel.size());
                fileChannel.write(ByteBuffer.wrap(bArr));
                if (z11) {
                    fileChannel.force(true);
                }
                try {
                    fileChannel.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                return true;
            } catch (Throwable th) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return false;
        }
    }

    public static boolean writeFileFromBytesByMap(File file, byte[] bArr, boolean z10, boolean z11) {
        if (bArr == null || !createOrExistsFile(file)) {
            return false;
        }
        FileChannel fileChannel = null;
        try {
            try {
                fileChannel = new FileOutputStream(file, z10).getChannel();
                MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, fileChannel.size(), bArr.length);
                map.put(bArr);
                if (z11) {
                    map.force();
                }
                try {
                    fileChannel.close();
                    return true;
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return true;
                }
            } catch (Throwable th) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return false;
        }
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, boolean z10) {
        return writeFileFromBytesByStream(file, bArr, z10, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z10) {
        return writeFileFromIS(file, inputStream, z10, (OnProgressUpdateListener) null);
    }

    public static boolean writeFileFromString(File file, String str, boolean z10) {
        BufferedWriter bufferedWriter;
        if (file == null || str == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, z10));
            } catch (Throwable th) {
                th = th;
                bufferedWriter = null;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            bufferedWriter.write(str);
            try {
                bufferedWriter.close();
                return true;
            } catch (IOException e11) {
                e11.printStackTrace();
                return true;
            }
        } catch (IOException e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static List<String> readFile2List(String str, int i10, int i11) {
        return readFile2List(getFileByPath(str), i10, i11, (String) null);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(getFileByPath(str), bArr, false, onProgressUpdateListener);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(getFileByPath(str), inputStream, false, onProgressUpdateListener);
    }

    public static List<String> readFile2List(String str, int i10, int i11, String str2) {
        return readFile2List(getFileByPath(str), i10, i11, str2);
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, boolean z10, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(getFileByPath(str), bArr, z10, onProgressUpdateListener);
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z10, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(getFileByPath(str), inputStream, z10, onProgressUpdateListener);
    }

    public static List<String> readFile2List(File file, int i10, int i11) {
        return readFile2List(file, i10, i11, (String) null);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromBytesByStream(file, bArr, false, onProgressUpdateListener);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return writeFileFromIS(file, inputStream, false, onProgressUpdateListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> readFile2List(File file, int i10, int i11, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (!isFileExists(file) || i10 > i11) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i12 = 1;
            if (isSpace(str)) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
            }
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null && i12 <= i11) {
                            if (i10 <= i12 && i12 <= i11) {
                                arrayList.add(readLine);
                            }
                            i12++;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            return arrayList;
        } catch (IOException e14) {
            e = e14;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, boolean z10, OnProgressUpdateListener onProgressUpdateListener) {
        if (bArr == null) {
            return false;
        }
        return writeFileFromIS(file, new ByteArrayInputStream(bArr), z10, onProgressUpdateListener);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:9|(6:11|(2:12|(1:14)(0))|16|17|18|20)(6:28|(2:29|(1:31)(0))|16|17|18|20)|15|16|17|18|20) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        r7.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z10, OnProgressUpdateListener onProgressUpdateListener) {
        BufferedOutputStream bufferedOutputStream;
        if (inputStream == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z10), sBufferSize);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            try {
                if (onProgressUpdateListener == null) {
                    byte[] bArr = new byte[sBufferSize];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    inputStream.close();
                    bufferedOutputStream.close();
                    return true;
                }
                double available = inputStream.available();
                onProgressUpdateListener.onProgressUpdate(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                byte[] bArr2 = new byte[sBufferSize];
                int i10 = 0;
                while (true) {
                    int read2 = inputStream.read(bArr2);
                    if (read2 != -1) {
                        bufferedOutputStream.write(bArr2, 0, read2);
                        i10 += read2;
                        onProgressUpdateListener.onProgressUpdate(i10 / available);
                    }
                }
                inputStream.close();
                bufferedOutputStream.close();
                return true;
                bufferedOutputStream.close();
                return true;
            } catch (IOException e11) {
                e11.printStackTrace();
                return true;
            }
            inputStream.close();
        } catch (IOException e12) {
            e = e12;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            try {
                inputStream.close();
            } catch (IOException e15) {
                e15.printStackTrace();
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                    throw th;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }
}
