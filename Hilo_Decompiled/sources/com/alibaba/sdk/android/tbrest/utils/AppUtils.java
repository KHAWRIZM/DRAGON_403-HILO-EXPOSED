package com.alibaba.sdk.android.tbrest.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import com.alibaba.sdk.android.tool.ProcessUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppUtils {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface ReaderListener {
        boolean onReadLine(String str);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e10) {
                LogUtil.e("close.", e10);
            }
        }
    }

    public static String dumpMeminfo(Context context) {
        Integer num;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                num = Integer.valueOf((int) (memoryInfo.threshold >> 10));
            } else {
                num = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JavaTotal:");
            sb.append(Runtime.getRuntime().totalMemory());
            sb.append(" JavaFree:");
            sb.append(Runtime.getRuntime().freeMemory());
            sb.append(" NativeHeap:");
            sb.append(Debug.getNativeHeapSize());
            sb.append(" NativeAllocated:");
            sb.append(Debug.getNativeHeapAllocatedSize());
            sb.append(" NativeFree:");
            sb.append(Debug.getNativeHeapFreeSize());
            sb.append(" threshold:");
            if (num != null) {
                str = num + " KB";
            } else {
                str = "not valid";
            }
            sb.append(str);
            return sb.toString();
        } catch (Exception e10) {
            LogUtil.e("dumpMeminfo", e10);
            return "";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|2|3|4|5|6|(11:8|9|10|11|(1:13)|14|(1:16)|17|(1:19)|21|22)|27|9|10|11|(0)|14|(0)|17|(0)|21|22) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c6, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0146, code lost:
    
        com.alibaba.sdk.android.tbrest.utils.LogUtil.e("getSizes", r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008d A[Catch: Exception -> 0x00c6, TryCatch #2 {Exception -> 0x00c6, blocks: (B:11:0x004b, B:13:0x008d, B:14:0x00c9, B:16:0x00cf, B:17:0x0107, B:19:0x010d), top: B:10:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf A[Catch: Exception -> 0x00c6, TryCatch #2 {Exception -> 0x00c6, blocks: (B:11:0x004b, B:13:0x008d, B:14:0x00c9, B:16:0x00cf, B:17:0x0107, B:19:0x010d), top: B:10:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010d A[Catch: Exception -> 0x00c6, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c6, blocks: (B:11:0x004b, B:13:0x008d, B:14:0x00c9, B:16:0x00cf, B:17:0x0107, B:19:0x010d), top: B:10:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String dumpStorage(Context context) {
        boolean z10;
        boolean z11;
        File dataDirectory;
        File downloadCacheDirectory;
        StringBuilder sb = new StringBuilder();
        try {
            z10 = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e10) {
            LogUtil.w("hasSDCard", e10);
            z10 = false;
        }
        try {
        } catch (Exception e11) {
            LogUtil.w("installSDCard", e11);
        }
        if ((context.getApplicationInfo().flags & 262144) != 0) {
            z11 = true;
            sb.append("hasSDCard: ");
            sb.append(z10);
            sb.append("\n");
            sb.append("installSDCard: ");
            sb.append(z11);
            sb.append("\n");
            File rootDirectory = Environment.getRootDirectory();
            long[] sizes = getSizes(rootDirectory.getAbsolutePath());
            sb.append("RootDirectory: ");
            sb.append(rootDirectory.getAbsolutePath());
            sb.append(" ");
            sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes[0]), Long.valueOf(sizes[1]), Long.valueOf(sizes[2])));
            dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null) {
                long[] sizes2 = getSizes(dataDirectory.getAbsolutePath());
                sb.append("DataDirectory: ");
                sb.append(dataDirectory.getAbsolutePath());
                sb.append(" ");
                sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes2[0]), Long.valueOf(sizes2[1]), Long.valueOf(sizes2[2])));
            }
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (dataDirectory != null) {
                sb.append("ExternalStorageDirectory: ");
                sb.append(externalStorageDirectory.getAbsolutePath());
                sb.append(" ");
                long[] sizes3 = getSizes(externalStorageDirectory.getAbsolutePath());
                sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes3[0]), Long.valueOf(sizes3[1]), Long.valueOf(sizes3[2])));
            }
            downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            if (downloadCacheDirectory != null) {
                sb.append("DownloadCacheDirectory: ");
                sb.append(downloadCacheDirectory.getAbsolutePath());
                sb.append(" ");
                long[] sizes4 = getSizes(downloadCacheDirectory.getAbsolutePath());
                sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes4[0]), Long.valueOf(sizes4[1]), Long.valueOf(sizes4[2])));
            }
            return sb.toString();
        }
        z11 = false;
        sb.append("hasSDCard: ");
        sb.append(z10);
        sb.append("\n");
        sb.append("installSDCard: ");
        sb.append(z11);
        sb.append("\n");
        File rootDirectory2 = Environment.getRootDirectory();
        long[] sizes5 = getSizes(rootDirectory2.getAbsolutePath());
        sb.append("RootDirectory: ");
        sb.append(rootDirectory2.getAbsolutePath());
        sb.append(" ");
        sb.append(String.format("TotalSize: %s FreeSize: %s AvailableSize: %s \n", Long.valueOf(sizes5[0]), Long.valueOf(sizes5[1]), Long.valueOf(sizes5[2])));
        dataDirectory = Environment.getDataDirectory();
        if (dataDirectory != null) {
        }
        File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
        if (dataDirectory != null) {
        }
        downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (downloadCacheDirectory != null) {
        }
        return sb.toString();
    }

    public static String dumpThread(Thread thread) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
            sb.append(String.format("\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
            for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                sb.append(String.format("\tat %s\n", stackTraceElement.toString()));
            }
        } catch (Exception e10) {
            LogUtil.e("dumpThread", e10);
        }
        return sb.toString();
    }

    public static String getGMT8Time(long j10) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j10));
        } catch (Exception e10) {
            LogUtil.e("getGMT8Time", e10);
            return "";
        }
    }

    public static String getMeminfo() {
        return readFully(new File("/proc/meminfo")).trim();
    }

    public static String getMyProcessNameByAppProcessInfo(Context context) {
        if (context != null) {
            try {
                return ProcessUtils.getProcessName(context);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String getMyProcessNameByCmdline() {
        try {
            return readLine("/proc/self/cmdline").trim();
        } catch (Exception e10) {
            LogUtil.e("get my process name by cmd line failure .", e10);
            return null;
        }
    }

    public static String getMyStatus() {
        return readFully(new File("/proc/self/status")).trim();
    }

    private static long[] getSizes(String str) {
        long[] jArr = {-1, -1, -1};
        try {
            StatFs statFs = new StatFs(str);
            long blockSizeLong = statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong();
            long freeBlocksLong = statFs.getFreeBlocksLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            jArr[0] = blockCountLong * blockSizeLong;
            jArr[1] = freeBlocksLong * blockSizeLong;
            jArr[2] = blockSizeLong * availableBlocksLong;
        } catch (Exception e10) {
            LogUtil.e("getSizes", e10);
        }
        return jArr;
    }

    public static Boolean isBackgroundRunning(Context context) {
        try {
            if (Integer.parseInt(readLine("/proc/self/oom_adj").trim()) == 0) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String readFully(File file) {
        FileInputStream fileInputStream;
        Exception e10;
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        ?? r12 = 0;
        r12 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                r12 = file;
            }
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 == read) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                } catch (Exception e11) {
                    e10 = e11;
                    LogUtil.e("readFully.", e10);
                    closeQuietly(inputStreamReader);
                    closeQuietly(fileInputStream);
                    return sb.toString();
                }
            } catch (Exception e12) {
                e10 = e12;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(r12);
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e13) {
            fileInputStream = null;
            e10 = e13;
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        closeQuietly(inputStreamReader);
        closeQuietly(fileInputStream);
        return sb.toString();
    }

    public static String readLine(String str) {
        return readLine(new File(str));
    }

    public static String readLineAndDel(File file) {
        try {
            String readLine = readLine(file);
            file.delete();
            return readLine;
        } catch (Exception e10) {
            LogUtil.e("readLineAndDel", e10);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.lang.String] */
    public static List<String> readLines(File file, int i10) {
        ?? readLine;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                int i11 = 0;
                while (true) {
                    try {
                        readLine = bufferedReader3.readLine();
                        if (readLine == 0) {
                            break;
                        }
                        i11++;
                        arrayList.add(readLine);
                        if (i10 > 0 && i11 >= i10) {
                            break;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader2 = bufferedReader3;
                        LogUtil.e("readLine", e);
                        closeQuietly(bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                closeQuietly(bufferedReader3);
                bufferedReader = readLine;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e = e11;
        }
        return arrayList;
    }

    public static boolean writeFile(File file, String str) {
        return writeFile(file, str, false);
    }

    public static String readLine(File file) {
        List<String> readLines = readLines(file, 1);
        return !readLines.isEmpty() ? readLines.get(0) : "";
    }

    public static boolean writeFile(File file, String str, boolean z10) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file, z10);
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            closeQuietly(fileWriter);
            return true;
        } catch (IOException e11) {
            e = e11;
            fileWriter2 = fileWriter;
            LogUtil.e("writeFile", e);
            closeQuietly(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            closeQuietly(fileWriter2);
            throw th;
        }
    }

    public static void readLine(File file, ReaderListener readerListener) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (IOException e11) {
                e = e11;
                bufferedReader2 = bufferedReader;
                LogUtil.e("readLine", e);
                closeQuietly(bufferedReader2);
                return;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                closeQuietly(bufferedReader2);
                throw th;
            }
            if (readLine == null) {
                closeQuietly(bufferedReader);
                return;
            }
        } while (!readerListener.onReadLine(readLine));
        closeQuietly(bufferedReader);
    }
}
