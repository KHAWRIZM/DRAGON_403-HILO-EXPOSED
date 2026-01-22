package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UploadPartCallable implements Callable<PartETag> {
    private final UploadPartRequest request;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩٢١s3;

    public UploadPartCallable(AmazonS3 amazonS3, UploadPartRequest uploadPartRequest) {
        this.f٦٩٢١s3 = amazonS3;
        this.request = uploadPartRequest;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PartETag call() throws Exception {
        return this.f٦٩٢١s3.uploadPart(this.request).getPartETag();
    }
}
