package com.liulishuo.okdownload.core;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.util.Log;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointStoreOnCache;
import com.liulishuo.okdownload.core.breakpoint.BreakpointStoreOnSQLite;
import com.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import com.liulishuo.okdownload.core.connection.DownloadOkHttp3Connection;
import com.liulishuo.okdownload.core.connection.DownloadUrlConnection;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Util {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String ETAG = "Etag";
    public static final String IF_MATCH = "If-Match";
    public static final String METHOD_HEAD = "HEAD";
    public static final String RANGE = "Range";
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String USER_AGENT = "User-Agent";
    public static final String VALUE_CHUNKED = "chunked";
    private static Logger logger = new EmptyLogger();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class EmptyLogger implements Logger {
        @Override // com.liulishuo.okdownload.core.Util.Logger
        public void d(String str, String str2) {
        }

        @Override // com.liulishuo.okdownload.core.Util.Logger
        public void e(String str, String str2, Exception exc) {
        }

        @Override // com.liulishuo.okdownload.core.Util.Logger
        public void i(String str, String str2) {
        }

        @Override // com.liulishuo.okdownload.core.Util.Logger
        public void w(String str, String str2) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2, Exception exc);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static void addDefaultUserAgent(DownloadConnection downloadConnection) {
        downloadConnection.addHeader("User-Agent", "OkDownload/");
    }

    public static void addRequestHeaderFields(Map<String, List<String>> map, DownloadConnection downloadConnection) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                downloadConnection.addHeader(key, it.next());
            }
        }
    }

    public static void addUserRequestHeaderField(Map<String, List<String>> map, DownloadConnection downloadConnection) {
        inspectUserHeader(map);
        addRequestHeaderFields(map, downloadConnection);
    }

    public static void assembleBlock(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j10, boolean z10) {
        int i10;
        if (OkDownload.with().downloadStrategy().isUseMultiBlock(z10)) {
            i10 = OkDownload.with().downloadStrategy().determineBlockCount(downloadTask, j10);
        } else {
            i10 = 1;
        }
        breakpointInfo.resetBlockInfos();
        long j11 = i10;
        long j12 = j10 / j11;
        long j13 = 0;
        long j14 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j13 += j14;
            if (i11 == 0) {
                j14 = (j10 % j11) + j12;
            } else {
                j14 = j12;
            }
            breakpointInfo.addBlock(new BlockInfo(j13, j14));
        }
    }

    public static boolean checkPermission(String str) {
        if (OkDownload.with().context().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static DownloadConnection.Factory createDefaultConnectionFactory() {
        try {
            return (DownloadConnection.Factory) DownloadOkHttp3Connection.Factory.class.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new DownloadUrlConnection.Factory();
        }
    }

    public static DownloadStore createDefaultDatabase(Context context) {
        try {
            return (DownloadStore) BreakpointStoreOnSQLite.class.getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new BreakpointStoreOnCache();
        }
    }

    public static DownloadStore createRemitDatabase(DownloadStore downloadStore) {
        try {
            downloadStore = (DownloadStore) downloadStore.getClass().getMethod("createRemitSelf", null).invoke(downloadStore, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        d("Util", "Get final download store is " + downloadStore);
        return downloadStore;
    }

    public static void d(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2, Exception exc) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.e(str, str2, exc);
        } else {
            Log.e(str, str2, exc);
        }
    }

    public static void enableConsoleLog() {
        logger = null;
    }

    public static String getFilenameFromContentUri(Uri uri) {
        Cursor query = OkDownload.with().context().getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                return query.getString(query.getColumnIndex("_display_name"));
            } finally {
                query.close();
            }
        }
        return null;
    }

    public static long getFreeSpaceBytes(StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static Logger getLogger() {
        return logger;
    }

    public static File getParentFile(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return new File("/");
        }
        return parentFile;
    }

    public static long getSizeFromContentUri(Uri uri) {
        Cursor query = OkDownload.with().context().getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                return query.getLong(query.getColumnIndex("_size"));
            } finally {
                query.close();
            }
        }
        return 0L;
    }

    public static String humanReadableBytes(long j10, boolean z10) {
        int i10;
        String str;
        String str2;
        if (z10) {
            i10 = 1000;
        } else {
            i10 = 1024;
        }
        if (j10 < i10) {
            return j10 + " B";
        }
        double d10 = j10;
        double d11 = i10;
        int log = (int) (Math.log(d10) / Math.log(d11));
        StringBuilder sb = new StringBuilder();
        if (z10) {
            str = "kMGTPE";
        } else {
            str = "KMGTPE";
        }
        sb.append(str.charAt(log - 1));
        if (z10) {
            str2 = "";
        } else {
            str2 = "i";
        }
        sb.append(str2);
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d10 / Math.pow(d11, log)), sb.toString());
    }

    public static void i(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void inspectUserHeader(Map<String, List<String>> map) {
        if (!map.containsKey("If-Match") && !map.containsKey("Range")) {
        } else {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static boolean isCorrectFull(long j10, long j11) {
        return j10 == j11;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkNotOnWifiType(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return true;
        }
        return false;
    }

    public static boolean isUriContentScheme(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static boolean isUriFileScheme(Uri uri) {
        return uri.getScheme().equals("file");
    }

    public static String md5(String str) {
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 & UByte.MAX_VALUE;
            if (i10 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i10));
        }
        return sb.toString();
    }

    public static long parseContentLength(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            d("Util", "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static long parseContentLengthFromContentRange(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e10) {
                w("Util", "parse content-length from content-range failed " + e10);
            }
        }
        return -1L;
    }

    public static void resetBlockIfDirty(BlockInfo blockInfo) {
        if (blockInfo.getCurrentOffset() < 0 || blockInfo.getCurrentOffset() > blockInfo.getContentLength()) {
            w("resetBlockIfDirty", "block is dirty so have to reset: " + blockInfo);
            blockInfo.resetBlock();
        }
    }

    public static void setLogger(Logger logger2) {
        logger = logger2;
    }

    public static ThreadFactory threadFactory(final String str, final boolean z10) {
        return new ThreadFactory() { // from class: com.liulishuo.okdownload.core.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z10);
                return thread;
            }
        };
    }

    public static void w(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }
}
