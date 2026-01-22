package com.taobao.accs.data;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String b;
    private int c;
    private String d;
    private long e;
    private ScheduledFuture<?> g;
    private volatile int f = 0;
    private Map<Integer, byte[]> h = new TreeMap(new b(this));

    public a(String str, int i, String str2) {
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    public void a(long j) {
        if (j <= 0) {
            j = 30000;
        }
        this.g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f4 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:13:0x0046, B:15:0x004a, B:17:0x0056, B:18:0x005f, B:20:0x0064, B:22:0x006c, B:23:0x0072, B:25:0x0087, B:26:0x0092, B:28:0x0098, B:31:0x00a2, B:38:0x00b2, B:40:0x00ba, B:42:0x00cf, B:44:0x00f4, B:45:0x012a, B:47:0x014b, B:48:0x014e, B:52:0x0165, B:54:0x0150), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014b A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:13:0x0046, B:15:0x004a, B:17:0x0056, B:18:0x005f, B:20:0x0064, B:22:0x006c, B:23:0x0072, B:25:0x0087, B:26:0x0092, B:28:0x0098, B:31:0x00a2, B:38:0x00b2, B:40:0x00ba, B:42:0x00cf, B:44:0x00f4, B:45:0x012a, B:47:0x014b, B:48:0x014e, B:52:0x0165, B:54:0x0150), top: B:12:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(int i, int i2, byte[] bArr) {
        long j;
        long j2;
        ScheduledFuture<?> scheduledFuture;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("AssembleMessage", "putBurst", Constants.KEY_DATA_ID, this.b, "index", Integer.valueOf(i));
        }
        byte[] bArr2 = null;
        if (i2 != this.c) {
            ALog.e("AssembleMessage", "putBurst fail as burstNums not match", new Object[0]);
            return null;
        }
        if (i >= 0 && i < i2) {
            synchronized (this) {
                try {
                    if (this.f == 0) {
                        if (this.h.get(Integer.valueOf(i)) != null) {
                            ALog.e("AssembleMessage", "putBurst fail as exist old", new Object[0]);
                            return null;
                        }
                        if (this.h.isEmpty()) {
                            this.e = System.currentTimeMillis();
                        }
                        this.h.put(Integer.valueOf(i), bArr);
                        if (this.h.size() == this.c) {
                            byte[] bArr3 = null;
                            for (byte[] bArr4 : this.h.values()) {
                                if (bArr3 == null) {
                                    bArr3 = bArr4;
                                } else {
                                    byte[] bArr5 = new byte[bArr3.length + bArr4.length];
                                    System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
                                    System.arraycopy(bArr4, 0, bArr5, bArr3.length, bArr4.length);
                                    bArr3 = bArr5;
                                }
                            }
                            if (!TextUtils.isEmpty(this.d)) {
                                String str = new String(a(com.taobao.accs.utl.d.a(bArr3)));
                                if (!this.d.equals(str)) {
                                    ALog.w("AssembleMessage", "putBurst fail", Constants.KEY_DATA_ID, this.b, "dataMd5", this.d, "finalDataMd5", str);
                                    this.f = 3;
                                    if (bArr2 == null) {
                                        j = bArr2.length;
                                        j2 = System.currentTimeMillis() - this.e;
                                        this.f = 2;
                                        ALog.i("AssembleMessage", "putBurst completed", Constants.KEY_DATA_ID, this.b, "length", Long.valueOf(j), "cost", Long.valueOf(j2));
                                    } else {
                                        j = 0;
                                        j2 = 0;
                                    }
                                    AssembleMonitor assembleMonitor = new AssembleMonitor(this.b, String.valueOf(this.f));
                                    assembleMonitor.assembleLength = j;
                                    assembleMonitor.assembleTimes = j2;
                                    AppMonitor.getInstance().commitStat(assembleMonitor);
                                    this.h.clear();
                                    scheduledFuture = this.g;
                                    if (scheduledFuture != null) {
                                        scheduledFuture.cancel(false);
                                    }
                                    return bArr2;
                                }
                            }
                            bArr2 = bArr3;
                            if (bArr2 == null) {
                            }
                            AssembleMonitor assembleMonitor2 = new AssembleMonitor(this.b, String.valueOf(this.f));
                            assembleMonitor2.assembleLength = j;
                            assembleMonitor2.assembleTimes = j2;
                            AppMonitor.getInstance().commitStat(assembleMonitor2);
                            this.h.clear();
                            scheduledFuture = this.g;
                            if (scheduledFuture != null) {
                            }
                            return bArr2;
                        }
                    } else {
                        ALog.e("AssembleMessage", "putBurst fail", "status", Integer.valueOf(this.f));
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ALog.e("AssembleMessage", "putBurst fail as burstIndex invalid", new Object[0]);
        return null;
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b & 240) >>> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return cArr;
    }
}
