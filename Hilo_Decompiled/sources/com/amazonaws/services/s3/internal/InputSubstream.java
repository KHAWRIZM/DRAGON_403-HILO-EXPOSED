package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class InputSubstream extends SdkFilterInputStream {
    private final boolean closeSourceStream;
    private long currentPosition;
    private long markedPosition;
    private final long requestedLength;
    private final long requestedOffset;

    public InputSubstream(InputStream inputStream, long j10, long j11, boolean z10) {
        super(inputStream);
        this.markedPosition = 0L;
        this.currentPosition = 0L;
        this.requestedLength = j11;
        this.requestedOffset = j10;
        this.closeSourceStream = z10;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        long j10;
        long j11 = this.currentPosition;
        long j12 = this.requestedOffset;
        if (j11 < j12) {
            j10 = this.requestedLength;
        } else {
            j10 = (this.requestedLength + j12) - j11;
        }
        return (int) Math.min(j10, super.available());
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closeSourceStream) {
            super.close();
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.markedPosition = this.currentPosition;
        super.mark(i10);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.currentPosition = this.markedPosition;
        super.reset();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10;
        long j11;
        while (true) {
            j10 = this.currentPosition;
            j11 = this.requestedOffset;
            if (j10 >= j11) {
                break;
            }
            this.currentPosition += super.skip(j11 - j10);
        }
        long j12 = (this.requestedLength + j11) - j10;
        if (j12 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i10, (int) Math.min(i11, j12));
        this.currentPosition += read;
        return read;
    }
}
