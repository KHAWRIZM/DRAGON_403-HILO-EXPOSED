package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.PauseResult;
import com.amazonaws.mobileconnectors.s3.transfermanager.PauseStatus;
import com.amazonaws.mobileconnectors.s3.transfermanager.PersistableUpload;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManagerConfiguration;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.UploadResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutObjectRequest;
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
public class UploadMonitor implements Callable<UploadResult>, TransferMonitor {
    private static final Log log = LogFactory.getLog(UploadMonitor.class);
    private final TransferManagerConfiguration configuration;
    private final UploadCallable multipartUploadCallable;
    private Future<UploadResult> nextFuture;
    private final ProgressListenerCallbackExecutor progressListenerChainCallbackExecutor;
    private final PutObjectRequest putObjectRequest;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩٢٠s3;
    private final ExecutorService threadPool;
    private ScheduledExecutorService timedThreadPool;
    private final UploadImpl transfer;
    private String uploadId;
    private final List<Future<PartETag>> futures = new ArrayList();
    private boolean isUploadDone = false;
    private int pollInterval = 5000;

    public UploadMonitor(TransferManager transferManager, UploadImpl uploadImpl, ExecutorService executorService, UploadCallable uploadCallable, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain) {
        this.f٦٩٢٠s3 = transferManager.getAmazonS3Client();
        this.configuration = transferManager.getConfiguration();
        this.multipartUploadCallable = uploadCallable;
        this.threadPool = executorService;
        this.putObjectRequest = putObjectRequest;
        this.progressListenerChainCallbackExecutor = ProgressListenerCallbackExecutor.wrapListener(progressListenerChain);
        this.transfer = uploadImpl;
        setNextFuture(executorService.submit(this));
    }

    private void cancelFutures() {
        this.nextFuture.cancel(true);
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.multipartUploadCallable.getFutures().clear();
        this.futures.clear();
    }

    private List<PartETag> collectPartETags() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.multipartUploadCallable.getETags());
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().get());
            } catch (Exception e10) {
                throw new AmazonClientException("Unable to upload part: " + e10.getCause().getMessage(), e10.getCause());
            }
        }
        return arrayList;
    }

    private UploadResult completeMultipartUpload() {
        CompleteMultipartUploadResult completeMultipartUpload = this.f٦٩٢٠s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.putObjectRequest.getBucketName(), this.putObjectRequest.getKey(), this.uploadId, collectPartETags()));
        uploadComplete();
        UploadResult uploadResult = new UploadResult();
        uploadResult.setBucketName(completeMultipartUpload.getBucketName());
        uploadResult.setKey(completeMultipartUpload.getKey());
        uploadResult.setETag(completeMultipartUpload.getETag());
        uploadResult.setVersionId(completeMultipartUpload.getVersionId());
        return uploadResult;
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
        this.isUploadDone = true;
    }

    private UploadResult poll() throws InterruptedException {
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
        setNextFuture(this.timedThreadPool.schedule(new Callable<UploadResult>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public UploadResult call() throws Exception {
                UploadMonitor uploadMonitor = UploadMonitor.this;
                uploadMonitor.setNextFuture(uploadMonitor.threadPool.submit(UploadMonitor.this));
                return null;
            }
        }, this.pollInterval, TimeUnit.MILLISECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNextFuture(Future<UploadResult> future) {
        this.nextFuture = future;
    }

    private UploadResult upload() throws Exception, InterruptedException {
        UploadResult call = this.multipartUploadCallable.call();
        if (call != null) {
            uploadComplete();
        } else {
            this.uploadId = this.multipartUploadCallable.getMultipartUploadId();
            this.futures.addAll(this.multipartUploadCallable.getFutures());
            reschedule();
        }
        return call;
    }

    private void uploadComplete() {
        markAllDone();
        this.transfer.setState(Transfer.TransferState.Completed);
        if (this.multipartUploadCallable.isMultipartUpload()) {
            fireProgressEvent(4);
        }
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized Future<UploadResult> getFuture() {
        return this.nextFuture;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized boolean isDone() {
        return this.isUploadDone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PauseResult<PersistableUpload> pause(boolean z10) {
        PersistableUpload persistableUpload = this.multipartUploadCallable.getPersistableUpload();
        if (persistableUpload == null) {
            PauseStatus determinePauseStatus = TransferManagerUtils.determinePauseStatus(this.transfer.getState(), z10);
            if (z10) {
                cancelFutures();
                this.multipartUploadCallable.performAbortMultipartUpload();
            }
            return new PauseResult<>(determinePauseStatus);
        }
        cancelFutures();
        return new PauseResult<>(PauseStatus.SUCCESS, persistableUpload);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performAbort() {
        cancelFutures();
        this.multipartUploadCallable.performAbortMultipartUpload();
    }

    public void setTimedThreadPool(ScheduledExecutorService scheduledExecutorService) {
        this.timedThreadPool = scheduledExecutorService;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public UploadResult call() throws Exception {
        try {
            if (this.uploadId == null) {
                return upload();
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
