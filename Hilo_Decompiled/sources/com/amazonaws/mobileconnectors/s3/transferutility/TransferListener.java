package com.amazonaws.mobileconnectors.s3.transferutility;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface TransferListener {
    void onError(int i10, Exception exc);

    void onProgressChanged(int i10, long j10, long j11);

    void onStateChanged(int i10, TransferState transferState);
}
