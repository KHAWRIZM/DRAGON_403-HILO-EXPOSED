package com.liulishuo.okdownload;

import android.os.SystemClock;
import com.liulishuo.okdownload.core.Util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SpeedCalculator {
    long allIncreaseBytes;
    long beginTimestamp;
    long bytesPerSecond;
    long endTimestamp;
    long increaseBytes;
    long timestamp;

    private static String humanReadableSpeed(long j10, boolean z10) {
        return Util.humanReadableBytes(j10, z10) + "/s";
    }

    public String averageSpeed() {
        return speedFromBegin();
    }

    public synchronized void downloading(long j10) {
        try {
            if (this.timestamp == 0) {
                long nowMillis = nowMillis();
                this.timestamp = nowMillis;
                this.beginTimestamp = nowMillis;
            }
            this.increaseBytes += j10;
            this.allIncreaseBytes += j10;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void endTask() {
        this.endTimestamp = nowMillis();
    }

    public synchronized void flush() {
        long nowMillis = nowMillis();
        long j10 = this.increaseBytes;
        long max = Math.max(1L, nowMillis - this.timestamp);
        this.increaseBytes = 0L;
        this.timestamp = nowMillis;
        this.bytesPerSecond = (((float) j10) / ((float) max)) * 1000.0f;
    }

    public synchronized long getBytesPerSecondAndFlush() {
        long nowMillis = nowMillis() - this.timestamp;
        if (nowMillis < 1000) {
            long j10 = this.bytesPerSecond;
            if (j10 != 0) {
                return j10;
            }
        }
        if (this.bytesPerSecond == 0 && nowMillis < 500) {
            return 0L;
        }
        return getInstantBytesPerSecondAndFlush();
    }

    public synchronized long getBytesPerSecondFromBegin() {
        long j10;
        try {
            j10 = this.endTimestamp;
            if (j10 == 0) {
                j10 = nowMillis();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (((float) this.allIncreaseBytes) / ((float) Math.max(1L, j10 - this.beginTimestamp))) * 1000.0f;
    }

    public long getInstantBytesPerSecondAndFlush() {
        flush();
        return this.bytesPerSecond;
    }

    public synchronized long getInstantSpeedDurationMillis() {
        return nowMillis() - this.timestamp;
    }

    public String getSpeedWithBinaryAndFlush() {
        return humanReadableSpeed(getInstantBytesPerSecondAndFlush(), false);
    }

    public String getSpeedWithSIAndFlush() {
        return humanReadableSpeed(getInstantBytesPerSecondAndFlush(), true);
    }

    public String instantSpeed() {
        return getSpeedWithSIAndFlush();
    }

    public String lastSpeed() {
        return humanReadableSpeed(this.bytesPerSecond, true);
    }

    public long nowMillis() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void reset() {
        this.timestamp = 0L;
        this.increaseBytes = 0L;
        this.bytesPerSecond = 0L;
        this.beginTimestamp = 0L;
        this.endTimestamp = 0L;
        this.allIncreaseBytes = 0L;
    }

    public String speed() {
        return humanReadableSpeed(getBytesPerSecondAndFlush(), true);
    }

    public String speedFromBegin() {
        return humanReadableSpeed(getBytesPerSecondFromBegin(), true);
    }
}
