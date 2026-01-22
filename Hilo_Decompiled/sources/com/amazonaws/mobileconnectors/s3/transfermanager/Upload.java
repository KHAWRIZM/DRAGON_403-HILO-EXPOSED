package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobileconnectors.s3.transfermanager.exception.PauseException;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.UploadResult;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Upload extends Transfer {
    void abort();

    PersistableUpload pause() throws PauseException;

    PauseResult<PersistableUpload> tryPause(boolean z10);

    UploadResult waitForUploadResult() throws AmazonClientException, AmazonServiceException, InterruptedException;
}
