package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ByteRangeCapturingInputStream extends SdkFilterInputStream {
    private final byte[] block;
    private int blockPosition;
    private final long endingPosition;
    private int markedBlockPosition;
    private long markedStreamPosition;
    private final long startingPosition;
    private long streamPosition;

    public ByteRangeCapturingInputStream(InputStream inputStream, long j10, long j11) {
        super(inputStream);
        this.blockPosition = 0;
        if (j10 < j11) {
            this.startingPosition = j10;
            this.endingPosition = j11;
            this.block = new byte[(int) (j11 - j10)];
            return;
        }
        throw new IllegalArgumentException("Invalid byte range specified: the starting position must be less than the ending position");
    }

    public byte[] getBlock() {
        return this.block;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        super.mark(i10);
        if (markSupported()) {
            this.markedStreamPosition = this.streamPosition;
            this.markedBlockPosition = this.blockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            return -1;
        }
        long j10 = this.streamPosition;
        if (j10 >= this.startingPosition && j10 <= this.endingPosition) {
            byte[] bArr = this.block;
            int i10 = this.blockPosition;
            this.blockPosition = i10 + 1;
            bArr[i10] = (byte) read;
        }
        this.streamPosition = j10 + 1;
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        if (markSupported()) {
            this.streamPosition = this.markedStreamPosition;
            this.blockPosition = this.markedBlockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = super.read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        long j10 = this.streamPosition;
        long j11 = read;
        if (j10 + j11 >= this.startingPosition && j10 <= this.endingPosition) {
            for (int i12 = 0; i12 < read; i12++) {
                long j12 = this.streamPosition;
                long j13 = i12;
                if (j12 + j13 >= this.startingPosition && j12 + j13 < this.endingPosition) {
                    byte[] bArr2 = this.block;
                    int i13 = this.blockPosition;
                    this.blockPosition = i13 + 1;
                    bArr2[i13] = bArr[i10 + i12];
                }
            }
        }
        this.streamPosition += j11;
        return read;
    }
}
