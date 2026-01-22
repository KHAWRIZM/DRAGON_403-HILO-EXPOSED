package org.apache.commons.sudcompress.archivers.zip;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class InflaterInputStreamWithStatistics extends InflaterInputStream {
    private long compressedCount;
    private long uncompressedCount;

    public InflaterInputStreamWithStatistics(InputStream inputStream) {
        super(inputStream);
        this.compressedCount = 0L;
        this.uncompressedCount = 0L;
    }

    @Override // java.util.zip.InflaterInputStream
    public void fill() {
        super.fill();
        this.compressedCount += ((InflaterInputStream) this).inf.getRemaining();
    }

    public long getCompressedCount() {
        return this.compressedCount;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read > -1) {
            this.uncompressedCount++;
        }
        return read;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read > -1) {
            this.uncompressedCount += read;
        }
        return read;
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater) {
        super(inputStream, inflater);
        this.compressedCount = 0L;
        this.uncompressedCount = 0L;
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater, int i) {
        super(inputStream, inflater, i);
        this.compressedCount = 0L;
        this.uncompressedCount = 0L;
    }
}
