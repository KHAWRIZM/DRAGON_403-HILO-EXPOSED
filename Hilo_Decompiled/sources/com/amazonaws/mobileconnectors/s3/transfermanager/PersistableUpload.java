package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PersistableUpload extends PersistableTransfer {
    static final String TYPE = "upload";
    private final String bucketName;
    private final String file;
    private final String key;
    private final String multipartUploadId;
    private final long mutlipartUploadThreshold;
    private final long partSize;
    private final String pauseType;

    @Deprecated
    public PersistableUpload() {
        this(null, null, null, null, -1L, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBucketName() {
        return this.bucketName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFile() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getMultipartUploadId() {
        return this.multipartUploadId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getMutlipartUploadThreshold() {
        return this.mutlipartUploadThreshold;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getPartSize() {
        return this.partSize;
    }

    String getPauseType() {
        return TYPE;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.PersistableTransfer
    public String serialize() {
        StringWriter stringWriter = new StringWriter();
        try {
            JsonUtils.getJsonWriter(stringWriter).beginObject().name("pauseType").value(TYPE).name("bucketName").value(this.bucketName).name(TransferTable.COLUMN_KEY).value(this.key).name("file").value(this.file).name("multipartUploadId").value(this.multipartUploadId).name("partSize").value(this.partSize).name("mutlipartUploadThreshold").value(this.mutlipartUploadThreshold).endObject().close();
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public PersistableUpload(String str, String str2, String str3, String str4, long j10, long j11) {
        this.pauseType = TYPE;
        this.bucketName = str;
        this.key = str2;
        this.file = str3;
        this.multipartUploadId = str4;
        this.partSize = j10;
        this.mutlipartUploadThreshold = j11;
    }
}
