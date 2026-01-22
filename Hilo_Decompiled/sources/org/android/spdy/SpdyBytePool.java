package org.android.spdy;

import java.util.Random;
import java.util.TreeSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SpdyBytePool {
    private static volatile SpdyBytePool gInstance;
    private static Object lock = new Object();
    private static Random rand = new Random();
    private TreeSet<SpdyByteArray> pool;
    private SpdyByteArray std = new SpdyByteArray();
    private long reused = 0;

    private SpdyBytePool() {
        this.pool = null;
        this.pool = new TreeSet<>();
    }

    public static SpdyBytePool getInstance() {
        if (gInstance == null) {
            synchronized (lock) {
                try {
                    if (gInstance == null) {
                        gInstance = new SpdyBytePool();
                    }
                } finally {
                }
            }
        }
        return gInstance;
    }

    SpdyByteArray getSpdyByteArray(int i) {
        SpdyByteArray ceiling;
        synchronized (lock) {
            try {
                SpdyByteArray spdyByteArray = this.std;
                spdyByteArray.length = i;
                ceiling = this.pool.ceiling(spdyByteArray);
                if (ceiling == null) {
                    ceiling = new SpdyByteArray(i);
                } else {
                    this.pool.remove(ceiling);
                    this.reused += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        spduLog.Logi("libeasy", "getSpdyByteArray: " + ceiling);
        spduLog.Logi("libeasy", "reused: " + this.reused);
        return ceiling;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle(SpdyByteArray spdyByteArray) {
        synchronized (lock) {
            try {
                this.pool.add(spdyByteArray);
                while (this.pool.size() > 100) {
                    if (rand.nextBoolean()) {
                        this.pool.pollFirst();
                    } else {
                        this.pool.pollLast();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
