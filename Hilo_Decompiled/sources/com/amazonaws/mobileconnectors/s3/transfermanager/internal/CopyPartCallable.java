package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.PartETag;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CopyPartCallable implements Callable<PartETag> {
    private final CopyPartRequest request;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩١٨s3;

    public CopyPartCallable(AmazonS3 amazonS3, CopyPartRequest copyPartRequest) {
        this.f٦٩١٨s3 = amazonS3;
        this.request = copyPartRequest;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PartETag call() throws Exception {
        return this.f٦٩١٨s3.copyPart(this.request).getPartETag();
    }
}
