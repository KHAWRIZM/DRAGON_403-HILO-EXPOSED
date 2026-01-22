package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.PartETag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CopyMonitor implements Callable<CopyResult>, TransferMonitor {
    private final CopyObjectRequest copyObjectRequest;
    private final CopyCallable multipartCopyCallable;
    private Future<CopyResult> nextFuture;
    private final ProgressListenerCallbackExecutor progressListenerChainCallbackExecutor;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩١٧s3;
    private final ExecutorService threadPool;
    private ScheduledExecutorService timedThreadPool;
    private final CopyImpl transfer;
    private String uploadId;
    private final List<Future<PartETag>> futures = new ArrayList();
    private boolean isCopyDone = false;
    private int pollInterval = 5000;

    public CopyMonitor(TransferManager transferManager, CopyImpl copyImpl, ExecutorService executorService, CopyCallable copyCallable, CopyObjectRequest copyObjectRequest, ProgressListenerChain progressListenerChain) {
        this.f٦٩١٧s3 = transferManager.getAmazonS3Client();
        this.multipartCopyCallable = copyCallable;
        this.threadPool = executorService;
        this.copyObjectRequest = copyObjectRequest;
        this.transfer = copyImpl;
        this.progressListenerChainCallbackExecutor = ProgressListenerCallbackExecutor.wrapListener(progressListenerChain);
        setNextFuture(executorService.submit(this));
    }

    private List<PartETag> collectPartETags() {
        ArrayList arrayList = new ArrayList(this.futures.size());
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().get());
            } catch (Exception e10) {
                throw new AmazonClientException("Unable to copy part: " + e10.getCause().getMessage(), e10.getCause());
            }
        }
        return arrayList;
    }

    private CopyResult completeMultipartUpload() {
        CompleteMultipartUploadResult completeMultipartUpload = this.f٦٩١٧s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.copyObjectRequest.getDestinationBucketName(), this.copyObjectRequest.getDestinationKey(), this.uploadId, collectPartETags()));
        copyComplete();
        CopyResult copyResult = new CopyResult();
        copyResult.setSourceBucketName(this.copyObjectRequest.getSourceBucketName());
        copyResult.setSourceKey(this.copyObjectRequest.getSourceKey());
        copyResult.setDestinationBucketName(completeMultipartUpload.getBucketName());
        copyResult.setDestinationKey(completeMultipartUpload.getKey());
        copyResult.setETag(completeMultipartUpload.getETag());
        copyResult.setVersionId(completeMultipartUpload.getVersionId());
        return copyResult;
    }

    private CopyResult copy() throws Exception, InterruptedException {
        CopyResult call = this.multipartCopyCallable.call();
        if (call != null) {
            copyComplete();
        } else {
            this.uploadId = this.multipartCopyCallable.getMultipartUploadId();
            this.futures.addAll(this.multipartCopyCallable.getFutures());
            reschedule();
        }
        return call;
    }

    private void copyComplete() {
        markAllDone();
        this.transfer.setState(Transfer.TransferState.Completed);
        if (this.multipartCopyCallable.isMultipartCopy()) {
            fireProgressEvent(4);
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

    private synchronized void markAllDone() {
        this.isCopyDone = true;
    }

    private CopyResult poll() throws InterruptedException {
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            if (!it.next().isDone()) {
                reschedule();
                return null;
            }
        }
        Iterator<Future<PartETag>> it2 = this.futures.iterator();
        while (it2.hasNext()) {
            if (it2.next().isCancelled()) {
                throw new CancellationException();
            }
        }
        return completeMultipartUpload();
    }

    private void reschedule() {
        setNextFuture(this.timedThreadPool.schedule(new Callable<CopyResult>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CopyResult call() throws Exception {
                CopyMonitor copyMonitor = CopyMonitor.this;
                copyMonitor.setNextFuture(copyMonitor.threadPool.submit(CopyMonitor.this));
                return null;
            }
        }, this.pollInterval, TimeUnit.MILLISECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNextFuture(Future<CopyResult> future) {
        this.nextFuture = future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized Future<CopyResult> getFuture() {
        return this.nextFuture;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized boolean isDone() {
        return this.isCopyDone;
    }

    public void setTimedThreadPool(ScheduledExecutorService scheduledExecutorService) {
        this.timedThreadPool = scheduledExecutorService;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public CopyResult call() throws Exception {
        try {
            if (this.uploadId == null) {
                return copy();
            }
            return poll();
        } catch (CancellationException unused) {
            this.transfer.setState(Transfer.TransferState.Canceled);
            fireProgressEvent(16);
            throw new AmazonClientException("Upload canceled");
        } catch (Exception e10) {
            this.transfer.setState(Transfer.TransferState.Failed);
            fireProgressEvent(8);
            throw e10;
        }
    }
}
