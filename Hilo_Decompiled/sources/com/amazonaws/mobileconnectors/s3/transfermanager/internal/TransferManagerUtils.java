package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.mobileconnectors.s3.transfermanager.PauseStatus;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManagerConfiguration;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class TransferManagerUtils {
    public static long calculateOptimalPartSize(PutObjectRequest putObjectRequest, TransferManagerConfiguration transferManagerConfiguration) {
        return (long) Math.max(Math.ceil(getContentLength(putObjectRequest) / 10000.0d), transferManagerConfiguration.getMinimumUploadPartSize());
    }

    public static long calculateOptimalPartSizeForCopy(CopyObjectRequest copyObjectRequest, TransferManagerConfiguration transferManagerConfiguration, long j10) {
        return (long) Math.max(Math.ceil(j10 / 10000.0d), transferManagerConfiguration.getMultipartCopyPartSize());
    }

    public static ThreadPoolExecutor createDefaultExecutorService() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(10, new ThreadFactory() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferManagerUtils.1
            private int threadCount = 1;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("s3-transfer-manager-worker-");
                int i10 = this.threadCount;
                this.threadCount = i10 + 1;
                sb.append(i10);
                thread.setName(sb.toString());
                return thread;
            }
        });
    }

    public static PauseStatus determinePauseStatus(Transfer.TransferState transferState, boolean z10) {
        if (z10) {
            if (transferState == Transfer.TransferState.Waiting) {
                return PauseStatus.CANCELLED_BEFORE_START;
            }
            if (transferState == Transfer.TransferState.InProgress) {
                return PauseStatus.CANCELLED;
            }
        }
        if (transferState == Transfer.TransferState.Waiting) {
            return PauseStatus.NOT_STARTED;
        }
        return PauseStatus.NO_EFFECT;
    }

    public static long getContentLength(PutObjectRequest putObjectRequest) {
        File requestFile = getRequestFile(putObjectRequest);
        if (requestFile != null) {
            return requestFile.length();
        }
        if (putObjectRequest.getInputStream() != null && putObjectRequest.getMetadata().getContentLength() > 0) {
            return putObjectRequest.getMetadata().getContentLength();
        }
        return -1L;
    }

    public static File getRequestFile(PutObjectRequest putObjectRequest) {
        if (putObjectRequest.getFile() != null) {
            return putObjectRequest.getFile();
        }
        return null;
    }

    public static boolean isUploadParallelizable(PutObjectRequest putObjectRequest, boolean z10) {
        if (z10 || getRequestFile(putObjectRequest) == null) {
            return false;
        }
        return true;
    }

    public static boolean shouldUseMultipartUpload(PutObjectRequest putObjectRequest, TransferManagerConfiguration transferManagerConfiguration) {
        if (getContentLength(putObjectRequest) > transferManagerConfiguration.getMultipartUploadThreshold()) {
            return true;
        }
        return false;
    }
}
