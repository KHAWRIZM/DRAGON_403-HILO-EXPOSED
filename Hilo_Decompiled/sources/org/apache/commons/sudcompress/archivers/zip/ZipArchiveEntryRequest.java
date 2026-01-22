package org.apache.commons.sudcompress.archivers.zip;

import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ZipArchiveEntryRequest {
    private final int method;
    private final i0.f payloadSupplier;
    private final ZipArchiveEntry zipArchiveEntry;

    private ZipArchiveEntryRequest(ZipArchiveEntry zipArchiveEntry, i0.f fVar) {
        this.zipArchiveEntry = zipArchiveEntry;
        this.method = zipArchiveEntry.getMethod();
    }

    public static ZipArchiveEntryRequest createZipArchiveEntryRequest(ZipArchiveEntry zipArchiveEntry, i0.f fVar) {
        return new ZipArchiveEntryRequest(zipArchiveEntry, fVar);
    }

    public int getMethod() {
        return this.method;
    }

    public InputStream getPayloadStream() {
        throw null;
    }

    public ZipArchiveEntry getZipArchiveEntry() {
        return this.zipArchiveEntry;
    }
}
