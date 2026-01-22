package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManagerConfiguration;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.StorageClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CopyCallable implements Callable<CopyResult> {
    private static final Log log = LogFactory.getLog(CopyCallable.class);
    private final TransferManagerConfiguration configuration;
    private final CopyImpl copy;
    private final CopyObjectRequest copyObjectRequest;
    private final List<Future<PartETag>> futures = new ArrayList();
    private final ObjectMetadata metadata;
    private String multipartUploadId;
    private final ProgressListenerCallbackExecutor progressListenerChainCallbackExecutor;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩١٦s3;
    private final ExecutorService threadPool;

    public CopyCallable(TransferManager transferManager, ExecutorService executorService, CopyImpl copyImpl, CopyObjectRequest copyObjectRequest, ObjectMetadata objectMetadata, ProgressListenerChain progressListenerChain) {
        this.f٦٩١٦s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.threadPool = executorService;
        this.copyObjectRequest = copyObjectRequest;
        this.metadata = objectMetadata;
        this.progressListenerChainCallbackExecutor = ProgressListenerCallbackExecutor.wrapListener(progressListenerChain);
        this.copy = copyImpl;
    }

    private CopyResult copyInOneChunk() {
        CopyObjectResult copyObject = this.f٦٩١٦s3.copyObject(this.copyObjectRequest);
        CopyResult copyResult = new CopyResult();
        copyResult.setSourceBucketName(this.copyObjectRequest.getSourceBucketName());
        copyResult.setSourceKey(this.copyObjectRequest.getSourceKey());
        copyResult.setDestinationBucketName(this.copyObjectRequest.getDestinationBucketName());
        copyResult.setDestinationKey(this.copyObjectRequest.getDestinationKey());
        copyResult.setETag(copyObject.getETag());
        copyResult.setVersionId(copyObject.getVersionId());
        return copyResult;
    }

    private void copyInParts() throws Exception {
        String destinationBucketName = this.copyObjectRequest.getDestinationBucketName();
        String destinationKey = this.copyObjectRequest.getDestinationKey();
        this.multipartUploadId = initiateMultipartUpload(this.copyObjectRequest);
        try {
            copyPartsInParallel(new CopyPartRequestFactory(this.copyObjectRequest, this.multipartUploadId, getOptimalPartSize(this.metadata.getContentLength()), this.metadata.getContentLength()));
        } catch (Exception e10) {
            fireProgressEvent(8);
            try {
                this.f٦٩١٦s3.abortMultipartUpload(new AbortMultipartUploadRequest(destinationBucketName, destinationKey, this.multipartUploadId));
            } catch (Exception e11) {
                log.info("Unable to abort multipart upload, you may need to manually remove uploaded parts: " + e11.getMessage(), e11);
            }
            throw e10;
        }
    }

    private void copyPartsInParallel(CopyPartRequestFactory copyPartRequestFactory) {
        while (copyPartRequestFactory.hasMoreRequests()) {
            if (!this.threadPool.isShutdown()) {
                this.futures.add(this.threadPool.submit(new CopyPartCallable(this.f٦٩١٦s3, copyPartRequestFactory.getNextCopyPartRequest())));
            } else {
                throw new CancellationException("TransferManager has been shutdown");
            }
        }
    }

    private void fireProgressEvent(int i10) {
        if (this.progressListenerChainCallbackExecutor == null) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.setEventCode(i10);
        this.progressListenerChainCallbackExecutor.progressChanged(progressEvent);
    }

    private long getOptimalPartSize(long j10) {
        long calculateOptimalPartSizeForCopy = TransferManagerUtils.calculateOptimalPartSizeForCopy(this.copyObjectRequest, this.configuration, j10);
        log.debug("Calculated optimal part size: " + calculateOptimalPartSizeForCopy);
        return calculateOptimalPartSizeForCopy;
    }

    private String initiateMultipartUpload(CopyObjectRequest copyObjectRequest) {
        InitiateMultipartUploadRequest withCannedACL = new InitiateMultipartUploadRequest(copyObjectRequest.getDestinationBucketName(), copyObjectRequest.getDestinationKey()).withCannedACL(copyObjectRequest.getCannedAccessControlList());
        if (copyObjectRequest.getAccessControlList() != null) {
            withCannedACL.setAccessControlList(copyObjectRequest.getAccessControlList());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            withCannedACL.setStorageClass(StorageClass.fromValue(copyObjectRequest.getStorageClass()));
        }
        if (copyObjectRequest.getDestinationSSECustomerKey() != null) {
            withCannedACL.setSSECustomerKey(copyObjectRequest.getDestinationSSECustomerKey());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata == null) {
            newObjectMetadata = new ObjectMetadata();
        }
        if (newObjectMetadata.getContentType() == null) {
            newObjectMetadata.setContentType(this.metadata.getContentType());
        }
        withCannedACL.setObjectMetadata(newObjectMetadata);
        populateMetadataWithEncryptionParams(this.metadata, newObjectMetadata);
        String uploadId = this.f٦٩١٦s3.initiateMultipartUpload(withCannedACL).getUploadId();
        log.debug("Initiated new multipart upload: " + uploadId);
        return uploadId;
    }

    private void populateMetadataWithEncryptionParams(ObjectMetadata objectMetadata, ObjectMetadata objectMetadata2) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        Map<String, String> userMetadata2 = objectMetadata2.getUserMetadata();
        String[] strArr = {Headers.CRYPTO_CEK_ALGORITHM, Headers.CRYPTO_IV, Headers.CRYPTO_KEY, Headers.CRYPTO_KEY_V2, Headers.CRYPTO_KEYWRAP_ALGORITHM, Headers.CRYPTO_TAG_LENGTH, Headers.MATERIALS_DESCRIPTION, Headers.UNENCRYPTED_CONTENT_LENGTH, Headers.UNENCRYPTED_CONTENT_MD5};
        if (userMetadata != null) {
            if (userMetadata2 == null) {
                userMetadata2 = new HashMap<>();
                objectMetadata2.setUserMetadata(userMetadata2);
            }
            for (int i10 = 0; i10 < 9; i10++) {
                String str = strArr[i10];
                String str2 = userMetadata.get(str);
                if (str2 != null) {
                    userMetadata2.put(str, str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Future<PartETag>> getFutures() {
        return this.futures;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getMultipartUploadId() {
        return this.multipartUploadId;
    }

    public boolean isMultipartCopy() {
        if (this.metadata.getContentLength() > this.configuration.getMultipartCopyThreshold()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public CopyResult call() throws Exception {
        this.copy.setState(Transfer.TransferState.InProgress);
        if (isMultipartCopy()) {
            fireProgressEvent(2);
            copyInParts();
            return null;
        }
        return copyInOneChunk();
    }
}
