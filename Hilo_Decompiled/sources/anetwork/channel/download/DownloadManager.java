package anetwork.channel.download;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import anetwork.channel.Header;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.degrade.DegradableNetwork;
import anetwork.channel.entity.RequestImpl;
import anetwork.channel.http.NetworkSdkSetting;
import com.liulishuo.okdownload.core.breakpoint.BreakpointSQLiteKey;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DownloadManager {
    public static final int ERROR_DOWNLOAD_CANCELLED = -105;
    public static final int ERROR_EXCEPTION_HAPPEN = -104;
    public static final int ERROR_FILE_FOLDER_INVALID = -101;
    public static final int ERROR_FILE_RENAME_FAILED = -106;
    public static final int ERROR_IO_EXCEPTION = -103;
    public static final int ERROR_REQUEST_FAIL = -102;
    public static final int ERROR_URL_INVALID = -100;
    public static final String TAG = "anet.DownloadManager";

    /* renamed from: a, reason: collision with root package name */
    SparseArray<b> f٥١٧٦a;

    /* renamed from: b, reason: collision with root package name */
    AtomicInteger f٥١٧٧b;

    /* renamed from: c, reason: collision with root package name */
    ThreadPoolExecutor f٥١٧٨c;

    /* renamed from: d, reason: collision with root package name */
    Context f٥١٧٩d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface DownloadListener {
        void onFail(int i10, int i11, String str);

        void onProgress(int i10, long j10, long j11);

        void onSuccess(int i10, String str);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static DownloadManager f٥١٨٠a = new DownloadManager();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f٥١٧٩d.getExternalFilesDir(null));
        sb.append("/");
        sb.append("downloads");
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public static DownloadManager getInstance() {
        return a.f٥١٨٠a;
    }

    public void cancel(int i10) {
        synchronized (this.f٥١٧٦a) {
            try {
                b bVar = this.f٥١٧٦a.get(i10);
                if (bVar != null) {
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "try cancel task" + i10 + " url=" + bVar.f٥١٨٢b.toString(), null, new Object[0]);
                    }
                    this.f٥١٧٦a.remove(i10);
                    bVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int enqueue(String str, String str2, DownloadListener downloadListener) {
        return enqueue(str, null, str2, downloadListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f٥١٨١a;

        /* renamed from: b, reason: collision with root package name */
        final URL f٥١٨٢b;

        /* renamed from: d, reason: collision with root package name */
        private final String f٥١٨٤d;

        /* renamed from: e, reason: collision with root package name */
        private final CopyOnWriteArrayList<DownloadListener> f٥١٨٥e;

        /* renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f٥١٨٦f = new AtomicBoolean(false);

        /* renamed from: g, reason: collision with root package name */
        private final AtomicBoolean f٥١٨٧g = new AtomicBoolean(false);

        /* renamed from: h, reason: collision with root package name */
        private volatile Connection f٥١٨٨h = null;

        /* renamed from: i, reason: collision with root package name */
        private boolean f٥١٨٩i;

        b(URL url, String str, String str2, DownloadListener downloadListener) {
            this.f٥١٨٩i = true;
            this.f٥١٨١a = DownloadManager.this.f٥١٧٧b.getAndIncrement();
            this.f٥١٨٢b = url;
            str2 = TextUtils.isEmpty(str2) ? a(url) : str2;
            if (TextUtils.isEmpty(str)) {
                this.f٥١٨٤d = DownloadManager.this.b(str2);
            } else {
                if (str.endsWith("/")) {
                    this.f٥١٨٤d = str + str2;
                } else {
                    this.f٥١٨٤d = str + '/' + str2;
                }
                if (str.startsWith("/data/user") || str.startsWith("/data/data")) {
                    this.f٥١٨٩i = false;
                }
            }
            CopyOnWriteArrayList<DownloadListener> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f٥١٨٥e = copyOnWriteArrayList;
            copyOnWriteArrayList.add(downloadListener);
        }

        public boolean a(DownloadListener downloadListener) {
            if (this.f٥١٨٧g.get()) {
                return false;
            }
            this.f٥١٨٥e.add(downloadListener);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:172:0x0260 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:184:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:188:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0286 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:211:0x027e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:215:0x0277 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:219:0x0270 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            RandomAccessFile randomAccessFile;
            ParcelableInputStream parcelableInputStream;
            BufferedOutputStream bufferedOutputStream;
            ParcelableInputStream parcelableInputStream2;
            long j10;
            if (this.f٥١٨٦f.get()) {
                return;
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    File a10 = DownloadManager.this.a(this.f٥١٨٢b.toString(), this.f٥١٨٩i);
                    boolean exists = a10.exists();
                    RequestImpl requestImpl = new RequestImpl(this.f٥١٨٢b);
                    requestImpl.setRetryTime(0);
                    requestImpl.setFollowRedirects(true);
                    if (exists) {
                        requestImpl.addHeader("Range", "bytes=" + a10.length() + "-");
                    }
                    DegradableNetwork degradableNetwork = new DegradableNetwork(DownloadManager.this.f٥١٧٩d);
                    this.f٥١٨٨h = degradableNetwork.getConnection(requestImpl, null);
                    int statusCode = this.f٥١٨٨h.getStatusCode();
                    if (statusCode > 0 && (statusCode == 200 || statusCode == 206 || statusCode == 416)) {
                        if (exists) {
                            if (statusCode == 416) {
                                a(requestImpl.getHeaders());
                                if (this.f٥١٨٦f.get()) {
                                    synchronized (DownloadManager.this.f٥١٧٦a) {
                                        DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                    }
                                    return;
                                }
                                this.f٥١٨٨h = degradableNetwork.getConnection(requestImpl, null);
                                exists = false;
                            }
                            if (statusCode == 200) {
                                exists = false;
                            }
                        }
                        if (this.f٥١٨٦f.get()) {
                            synchronized (DownloadManager.this.f٥١٧٦a) {
                                DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                            }
                            return;
                        }
                        if (!exists) {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a10));
                            j10 = 0;
                            randomAccessFile = null;
                        } else {
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(a10, "rw");
                            try {
                                long length = randomAccessFile2.length();
                                randomAccessFile2.seek(length);
                                randomAccessFile = randomAccessFile2;
                                bufferedOutputStream = new BufferedOutputStream(Channels.newOutputStream(randomAccessFile2.getChannel()));
                                j10 = length;
                            } catch (Exception e10) {
                                e = e10;
                                parcelableInputStream2 = null;
                                randomAccessFile = randomAccessFile2;
                                bufferedOutputStream = null;
                                ALog.e(DownloadManager.TAG, "file download failed!", null, e, new Object[0]);
                                a(DownloadManager.ERROR_EXCEPTION_HAPPEN, e.toString());
                                if (bufferedOutputStream != null) {
                                }
                                if (randomAccessFile != null) {
                                }
                                if (parcelableInputStream2 != null) {
                                }
                                synchronized (DownloadManager.this.f٥١٧٦a) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                parcelableInputStream = null;
                                randomAccessFile = randomAccessFile2;
                                if (bufferedOutputStream2 != null) {
                                }
                                if (randomAccessFile != null) {
                                }
                                if (parcelableInputStream != null) {
                                }
                                synchronized (DownloadManager.this.f٥١٧٦a) {
                                }
                            }
                        }
                        try {
                            long a11 = a(statusCode, this.f٥١٨٨h.getConnHeadFields(), j10);
                            parcelableInputStream2 = this.f٥١٨٨h.getInputStream();
                            try {
                                if (parcelableInputStream2 == null) {
                                    a(-103, "input stream is null.");
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (parcelableInputStream2 != null) {
                                        try {
                                            parcelableInputStream2.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    synchronized (DownloadManager.this.f٥١٧٦a) {
                                        DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                    }
                                    return;
                                }
                                byte[] bArr = new byte[2048];
                                int i10 = 0;
                                while (true) {
                                    int read = parcelableInputStream2.read(bArr);
                                    if (read != -1) {
                                        if (this.f٥١٨٦f.get()) {
                                            this.f٥١٨٨h.cancel();
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (Exception unused4) {
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                parcelableInputStream2.close();
                                            } catch (Exception unused6) {
                                            }
                                            synchronized (DownloadManager.this.f٥١٧٦a) {
                                                DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                            }
                                            return;
                                        }
                                        i10 += read;
                                        bufferedOutputStream.write(bArr, 0, read);
                                        a(i10 + j10, a11);
                                    } else {
                                        bufferedOutputStream.flush();
                                        if (this.f٥١٨٦f.get()) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (Exception unused7) {
                                            }
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Exception unused8) {
                                                }
                                            }
                                            try {
                                                parcelableInputStream2.close();
                                            } catch (Exception unused9) {
                                            }
                                            synchronized (DownloadManager.this.f٥١٧٦a) {
                                                DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                            }
                                            return;
                                        }
                                        if (a10.renameTo(new File(this.f٥١٨٤d))) {
                                            a(this.f٥١٨٤d);
                                        } else {
                                            a(DownloadManager.ERROR_FILE_RENAME_FAILED, "file rename to " + this.f٥١٨٤d + " failed");
                                        }
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception unused10) {
                                        }
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (Exception unused11) {
                                            }
                                        }
                                        try {
                                            parcelableInputStream2.close();
                                        } catch (Exception unused12) {
                                        }
                                        synchronized (DownloadManager.this.f٥١٧٦a) {
                                            DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                        }
                                        return;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                ALog.e(DownloadManager.TAG, "file download failed!", null, e, new Object[0]);
                                a(DownloadManager.ERROR_EXCEPTION_HAPPEN, e.toString());
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception unused13) {
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused14) {
                                    }
                                }
                                if (parcelableInputStream2 != null) {
                                    try {
                                        parcelableInputStream2.close();
                                    } catch (Exception unused15) {
                                    }
                                }
                                synchronized (DownloadManager.this.f٥١٧٦a) {
                                    DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                                }
                                return;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            parcelableInputStream2 = null;
                        } catch (Throwable th2) {
                            th = th2;
                            parcelableInputStream = null;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (Exception unused16) {
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused17) {
                                }
                            }
                            if (parcelableInputStream != null) {
                                try {
                                    parcelableInputStream.close();
                                } catch (Exception unused18) {
                                }
                            }
                            synchronized (DownloadManager.this.f٥١٧٦a) {
                                DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                            }
                            throw th;
                        }
                    }
                    a(-102, "ResponseCode:" + statusCode);
                    synchronized (DownloadManager.this.f٥١٧٦a) {
                        DownloadManager.this.f٥١٧٦a.remove(this.f٥١٨١a);
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e13) {
                e = e13;
                bufferedOutputStream = null;
                randomAccessFile = null;
                parcelableInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                parcelableInputStream = null;
            }
        }

        public void a() {
            this.f٥١٨٦f.set(true);
            a(-105, "download canceled.");
            if (this.f٥١٨٨h != null) {
                try {
                    this.f٥١٨٨h.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        private void a(String str) {
            if (this.f٥١٨٧g.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.f٥١٨٥e.iterator();
                while (it.hasNext()) {
                    it.next().onSuccess(this.f٥١٨١a, str);
                }
            }
        }

        private void a(int i10, String str) {
            if (this.f٥١٨٧g.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.f٥١٨٥e.iterator();
                while (it.hasNext()) {
                    it.next().onFail(this.f٥١٨١a, i10, str);
                }
            }
        }

        private void a(long j10, long j11) {
            if (this.f٥١٨٧g.get()) {
                return;
            }
            Iterator<DownloadListener> it = this.f٥١٨٥e.iterator();
            while (it.hasNext()) {
                it.next().onProgress(this.f٥١٨١a, j10, j11);
            }
        }

        private long a(int i10, Map<String, List<String>> map, long j10) {
            int lastIndexOf;
            try {
                if (i10 == 200) {
                    return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length"));
                }
                if (i10 != 206) {
                    return 0L;
                }
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Range");
                long parseLong = (singleHeaderFieldByKey == null || (lastIndexOf = singleHeaderFieldByKey.lastIndexOf(47)) == -1) ? 0L : Long.parseLong(singleHeaderFieldByKey.substring(lastIndexOf + 1));
                if (parseLong == 0) {
                    try {
                        return Long.parseLong(HttpHelper.getSingleHeaderFieldByKey(map, "Content-Length")) + j10;
                    } catch (Exception unused) {
                    }
                }
                return parseLong;
            } catch (Exception unused2) {
                return 0L;
            }
        }

        private void a(List<Header> list) {
            if (list != null) {
                ListIterator<Header> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if ("Range".equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        private String a(URL url) {
            String path = url.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            String substring = lastIndexOf != -1 ? path.substring(lastIndexOf + 1, path.length()) : null;
            if (!TextUtils.isEmpty(substring)) {
                return substring;
            }
            String md5ToHex = StringUtils.md5ToHex(url.toString());
            return md5ToHex == null ? url.getFile() : md5ToHex;
        }
    }

    private DownloadManager() {
        this.f٥١٧٦a = new SparseArray<>(6);
        this.f٥١٧٧b = new AtomicInteger(0);
        this.f٥١٧٨c = new ThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.f٥١٧٩d = null;
        this.f٥١٧٩d = NetworkSdkSetting.getContext();
        this.f٥١٧٨c.allowCoreThreadTimeOut(true);
        a();
    }

    public int enqueue(String str, String str2, String str3, DownloadListener downloadListener) {
        int i10 = 0;
        if (ALog.isPrintLog(2)) {
            ALog.i(TAG, "enqueue", null, "folder", str2, BreakpointSQLiteKey.FILENAME, str3, "url", str);
        }
        if (this.f٥١٧٩d == null) {
            ALog.e(TAG, "network sdk not initialized.", null, new Object[0]);
            return -1;
        }
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(str2) && !a(str2)) {
                ALog.e(TAG, "file folder invalid.", null, new Object[0]);
                if (downloadListener != null) {
                    downloadListener.onFail(-1, -101, "file folder path invalid");
                }
                return -1;
            }
            synchronized (this.f٥١٧٦a) {
                try {
                    int size = this.f٥١٧٦a.size();
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        b valueAt = this.f٥١٧٦a.valueAt(i10);
                        if (!url.equals(valueAt.f٥١٨٢b)) {
                            i10++;
                        } else if (valueAt.a(downloadListener)) {
                            return valueAt.f٥١٨١a;
                        }
                    }
                    b bVar = new b(url, str2, str3, downloadListener);
                    this.f٥١٧٦a.put(bVar.f٥١٨١a, bVar);
                    this.f٥١٧٨c.submit(bVar);
                    return bVar.f٥١٨١a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (MalformedURLException e10) {
            ALog.e(TAG, "url invalid.", null, e10, new Object[0]);
            if (downloadListener != null) {
                downloadListener.onFail(-1, -100, "url invalid");
            }
            return -1;
        }
    }

    private void a() {
        if (this.f٥١٧٩d != null) {
            File file = new File(this.f٥١٧٩d.getExternalFilesDir(null), "downloads");
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    private boolean a(String str) {
        if (this.f٥١٧٩d != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                return file.mkdir();
            } catch (Exception unused) {
                ALog.e(TAG, "create folder failed", null, "folder", str);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(String str, boolean z10) {
        String md5ToHex = StringUtils.md5ToHex(str);
        if (md5ToHex != null) {
            str = md5ToHex;
        }
        if (z10) {
            return new File(this.f٥١٧٩d.getExternalCacheDir(), str);
        }
        return new File(this.f٥١٧٩d.getCacheDir(), str);
    }
}
