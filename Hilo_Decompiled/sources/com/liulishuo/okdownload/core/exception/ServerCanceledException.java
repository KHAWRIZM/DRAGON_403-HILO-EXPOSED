package com.liulishuo.okdownload.core.exception;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ServerCanceledException extends IOException {
    private final int responseCode;

    public ServerCanceledException(int i10, long j10) {
        super("Response code can't handled on internal " + i10 + " with current offset " + j10);
        this.responseCode = i10;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
