package com.amazonaws.services.s3.model;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProgressEvent extends com.amazonaws.event.ProgressEvent {
    public ProgressEvent(int i10) {
        super(i10);
    }

    @Deprecated
    public int getBytesTransfered() {
        return (int) getBytesTransferred();
    }

    @Deprecated
    public void setBytesTransfered(int i10) {
        setBytesTransferred(i10);
    }

    public ProgressEvent(int i10, long j10) {
        super(i10, j10);
    }
}
