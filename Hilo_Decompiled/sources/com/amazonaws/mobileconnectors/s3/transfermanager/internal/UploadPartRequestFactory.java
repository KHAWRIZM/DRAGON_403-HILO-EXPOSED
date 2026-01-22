package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UploadPartRequestFactory {
    private final String bucketName;
    private final File file;
    private final String key;
    private final long optimalPartSize;
    private final PutObjectRequest putObjectRequest;
    private long remainingBytes;
    private SSECustomerKey sseCustomerKey;
    private final String uploadId;
    private int partNumber = 1;
    private long offset = 0;

    public UploadPartRequestFactory(PutObjectRequest putObjectRequest, String str, long j10) {
        this.putObjectRequest = putObjectRequest;
        this.uploadId = str;
        this.optimalPartSize = j10;
        this.bucketName = putObjectRequest.getBucketName();
        this.key = putObjectRequest.getKey();
        this.file = TransferManagerUtils.getRequestFile(putObjectRequest);
        this.remainingBytes = TransferManagerUtils.getContentLength(putObjectRequest);
        this.sseCustomerKey = putObjectRequest.getSSECustomerKey();
    }

    public synchronized UploadPartRequest getNextUploadPartRequest() {
        boolean z10;
        UploadPartRequest withPartSize;
        try {
            long min = Math.min(this.optimalPartSize, this.remainingBytes);
            if (this.remainingBytes - min <= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.putObjectRequest.getInputStream() != null) {
                UploadPartRequest withInputStream = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withInputStream(new InputSubstream(this.putObjectRequest.getInputStream(), 0L, min, z10));
                int i10 = this.partNumber;
                this.partNumber = i10 + 1;
                withPartSize = withInputStream.withPartNumber(i10).withPartSize(min);
            } else {
                UploadPartRequest withFileOffset = new UploadPartRequest().withBucketName(this.bucketName).withKey(this.key).withUploadId(this.uploadId).withFile(this.file).withFileOffset(this.offset);
                int i11 = this.partNumber;
                this.partNumber = i11 + 1;
                withPartSize = withFileOffset.withPartNumber(i11).withPartSize(min);
            }
            SSECustomerKey sSECustomerKey = this.sseCustomerKey;
            if (sSECustomerKey != null) {
                withPartSize.setSSECustomerKey(sSECustomerKey);
            }
            this.offset += min;
            this.remainingBytes -= min;
            withPartSize.setLastPart(z10);
            withPartSize.setGeneralProgressListener(this.putObjectRequest.getGeneralProgressListener());
        } catch (Throwable th) {
            throw th;
        }
        return withPartSize;
    }

    public synchronized boolean hasMoreRequests() {
        boolean z10;
        if (this.remainingBytes > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }
}
