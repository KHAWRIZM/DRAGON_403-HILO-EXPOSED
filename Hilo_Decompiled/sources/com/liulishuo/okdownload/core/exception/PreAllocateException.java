package com.liulishuo.okdownload.core.exception;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PreAllocateException extends IOException {
    private final long freeSpace;
    private final long requireSpace;

    public PreAllocateException(long j10, long j11) {
        super("There is Free space less than Require space: " + j11 + " < " + j10);
        this.requireSpace = j10;
        this.freeSpace = j11;
    }

    public long getFreeSpace() {
        return this.freeSpace;
    }

    public long getRequireSpace() {
        return this.requireSpace;
    }
}
