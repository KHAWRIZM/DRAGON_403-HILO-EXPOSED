package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class TransferProgress {
    private static final Log log = LogFactory.getLog(TransferProgress.class);
    protected volatile long bytesTransferred = 0;
    protected volatile long totalBytesToTransfer = -1;

    @Deprecated
    public long getBytesTransfered() {
        return getBytesTransferred();
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    @Deprecated
    public synchronized double getPercentTransfered() {
        return getPercentTransferred();
    }

    public synchronized double getPercentTransferred() {
        double d10;
        if (getBytesTransferred() < 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (this.totalBytesToTransfer < 0) {
            d10 = -1.0d;
        } else {
            d10 = (this.bytesTransferred / this.totalBytesToTransfer) * 100.0d;
        }
        return d10;
    }

    public long getTotalBytesToTransfer() {
        return this.totalBytesToTransfer;
    }

    public void setTotalBytesToTransfer(long j10) {
        this.totalBytesToTransfer = j10;
    }

    public synchronized void updateProgress(long j10) {
        this.bytesTransferred += j10;
        if (this.totalBytesToTransfer > -1 && this.bytesTransferred > this.totalBytesToTransfer) {
            this.bytesTransferred = this.totalBytesToTransfer;
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Number of bytes transfered is more than the actual total bytes to transfer. Total number of bytes to Transfer : " + this.totalBytesToTransfer + ". Bytes Transferred : " + (this.bytesTransferred + j10));
            }
        }
    }
}
