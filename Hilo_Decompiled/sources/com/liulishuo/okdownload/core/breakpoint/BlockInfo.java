package com.liulishuo.okdownload.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BlockInfo {
    private final long contentLength;
    private final AtomicLong currentOffset;
    private final long startOffset;

    public BlockInfo(long j10, long j11) {
        this(j10, j11, 0L);
    }

    public BlockInfo copy() {
        return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset.get());
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurrentOffset() {
        return this.currentOffset.get();
    }

    public long getRangeLeft() {
        return this.currentOffset.get() + this.startOffset;
    }

    public long getRangeRight() {
        return (this.startOffset + this.contentLength) - 1;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void increaseCurrentOffset(long j10) {
        this.currentOffset.addAndGet(j10);
    }

    public void resetBlock() {
        this.currentOffset.set(0L);
    }

    public String toString() {
        return "[" + this.startOffset + ", " + getRangeRight() + ")-current:" + this.currentOffset;
    }

    public BlockInfo(long j10, long j11, long j12) {
        if (j10 >= 0 && ((j11 >= 0 || j11 == -1) && j12 >= 0)) {
            this.startOffset = j10;
            this.contentLength = j11;
            this.currentOffset = new AtomicLong(j12);
            return;
        }
        throw new IllegalArgumentException();
    }
}
