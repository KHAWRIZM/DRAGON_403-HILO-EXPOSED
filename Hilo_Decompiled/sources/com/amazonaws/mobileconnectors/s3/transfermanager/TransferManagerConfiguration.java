package com.amazonaws.mobileconnectors.s3.transfermanager;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class TransferManagerConfiguration {
    private static final long DEFAULT_MINIMUM_COPY_PART_SIZE = 104857600;
    private static final int DEFAULT_MINIMUM_UPLOAD_PART_SIZE = 5242880;
    private static final long DEFAULT_MULTIPART_COPY_THRESHOLD = 5368709120L;
    private static final long DEFAULT_MULTIPART_UPLOAD_THRESHOLD = 16777216;
    private long minimumUploadPartSize = 5242880;
    private long multipartUploadThreshold = DEFAULT_MULTIPART_UPLOAD_THRESHOLD;
    private long multipartCopyThreshold = DEFAULT_MULTIPART_COPY_THRESHOLD;
    private long multipartCopyPartSize = DEFAULT_MINIMUM_COPY_PART_SIZE;

    public long getMinimumUploadPartSize() {
        return this.minimumUploadPartSize;
    }

    public long getMultipartCopyPartSize() {
        return this.multipartCopyPartSize;
    }

    public long getMultipartCopyThreshold() {
        return this.multipartCopyThreshold;
    }

    public long getMultipartUploadThreshold() {
        return this.multipartUploadThreshold;
    }

    public void setMinimumUploadPartSize(long j10) {
        this.minimumUploadPartSize = j10;
    }

    public void setMultipartCopyPartSize(long j10) {
        this.multipartCopyPartSize = j10;
    }

    public void setMultipartCopyThreshold(long j10) {
        this.multipartCopyThreshold = j10;
    }

    public void setMultipartUploadThreshold(long j10) {
        this.multipartUploadThreshold = j10;
    }
}
