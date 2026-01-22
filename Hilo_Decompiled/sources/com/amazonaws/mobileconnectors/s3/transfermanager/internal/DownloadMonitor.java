package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DownloadMonitor implements TransferMonitor {
    private final DownloadImpl download;
    private final Future<?> future;

    public DownloadMonitor(DownloadImpl downloadImpl, Future<?> future) {
        this.download = downloadImpl;
        this.future = future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public Future<?> getFuture() {
        return this.future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public boolean isDone() {
        return this.download.isDone();
    }
}
