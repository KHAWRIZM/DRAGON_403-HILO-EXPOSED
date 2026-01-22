package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class MultipartUploadCryptoContext extends MultipartUploadContext {
    private final ContentCryptoMaterial cekMaterial;
    private int partNumber;
    private volatile boolean partUploadInProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultipartUploadCryptoContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        super(str, str2);
        this.cekMaterial = contentCryptoMaterial;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beginPartUpload(int i10) {
        if (i10 >= 1) {
            if (!this.partUploadInProgress) {
                synchronized (this) {
                    try {
                        if (i10 - this.partNumber <= 1) {
                            this.partNumber = i10;
                            this.partUploadInProgress = true;
                        } else {
                            throw new AmazonClientException("Parts are required to be uploaded in series (partNumber=" + this.partNumber + ", nextPartNumber=" + i10 + ")");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            throw new AmazonClientException("Parts are required to be uploaded in series");
        }
        throw new IllegalArgumentException("part number must be at least 1");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endPartUpload() {
        this.partUploadInProgress = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite getCipherLite() {
        return this.cekMaterial.getCipherLite();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentCryptoMaterial getContentCryptoMaterial() {
        return this.cekMaterial;
    }
}
