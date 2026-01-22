package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyPartRequest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CopyPartRequestFactory {
    private final CopyObjectRequest copyObjectRequest;
    private final long optimalPartSize;
    private long remainingBytes;
    private final String uploadId;
    private int partNumber = 1;
    private long offset = 0;

    public CopyPartRequestFactory(CopyObjectRequest copyObjectRequest, String str, long j10, long j11) {
        this.copyObjectRequest = copyObjectRequest;
        this.uploadId = str;
        this.optimalPartSize = j10;
        this.remainingBytes = j11;
    }

    private void setOtherMetadataInRequest(CopyPartRequest copyPartRequest) {
        if (this.copyObjectRequest.getMatchingETagConstraints() != null) {
            copyPartRequest.setMatchingETagConstraints(this.copyObjectRequest.getMatchingETagConstraints());
        }
        if (this.copyObjectRequest.getModifiedSinceConstraint() != null) {
            copyPartRequest.setModifiedSinceConstraint(this.copyObjectRequest.getModifiedSinceConstraint());
        }
        if (this.copyObjectRequest.getNonmatchingETagConstraints() != null) {
            copyPartRequest.setNonmatchingETagConstraints(this.copyObjectRequest.getNonmatchingETagConstraints());
        }
        if (this.copyObjectRequest.getSourceVersionId() != null) {
            copyPartRequest.setSourceVersionId(this.copyObjectRequest.getSourceVersionId());
        }
        if (this.copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            copyPartRequest.setUnmodifiedSinceConstraint(this.copyObjectRequest.getUnmodifiedSinceConstraint());
        }
    }

    public synchronized CopyPartRequest getNextCopyPartRequest() {
        CopyPartRequest withDestinationSSECustomerKey;
        long min = Math.min(this.optimalPartSize, this.remainingBytes);
        CopyPartRequest withUploadId = new CopyPartRequest().withSourceBucketName(this.copyObjectRequest.getSourceBucketName()).withSourceKey(this.copyObjectRequest.getSourceKey()).withUploadId(this.uploadId);
        int i10 = this.partNumber;
        this.partNumber = i10 + 1;
        withDestinationSSECustomerKey = withUploadId.withPartNumber(i10).withDestinationBucketName(this.copyObjectRequest.getDestinationBucketName()).withDestinationKey(this.copyObjectRequest.getDestinationKey()).withSourceVersionId(this.copyObjectRequest.getSourceVersionId()).withFirstByte(new Long(this.offset)).withLastByte(new Long((this.offset + min) - 1)).withSourceSSECustomerKey(this.copyObjectRequest.getSourceSSECustomerKey()).withDestinationSSECustomerKey(this.copyObjectRequest.getDestinationSSECustomerKey());
        setOtherMetadataInRequest(withDestinationSSECustomerKey);
        this.offset += min;
        this.remainingBytes -= min;
        return withDestinationSSECustomerKey;
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
