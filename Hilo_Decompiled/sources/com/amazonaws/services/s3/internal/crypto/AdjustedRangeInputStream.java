package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdjustedRangeInputStream extends SdkInputStream {
    private boolean closed = false;
    private InputStream decryptedContents;
    private long virtualAvailable;

    public AdjustedRangeInputStream(InputStream inputStream, long j10, long j11) throws IOException {
        this.decryptedContents = inputStream;
        initializeForRead(j10, j11);
    }

    private void initializeForRead(long j10, long j11) throws IOException {
        int i10;
        if (j10 < 16) {
            i10 = (int) j10;
        } else {
            i10 = ((int) (j10 % 16)) + 16;
        }
        if (i10 != 0) {
            while (i10 > 0) {
                this.decryptedContents.read();
                i10--;
            }
        }
        this.virtualAvailable = (j11 - j10) + 1;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        abortIfNeeded();
        int available = this.decryptedContents.available();
        long j10 = available;
        long j11 = this.virtualAvailable;
        if (j10 < j11) {
            return available;
        }
        return (int) j11;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.decryptedContents.close();
        }
        abortIfNeeded();
    }

    @Override // com.amazonaws.internal.SdkInputStream
    protected InputStream getWrappedInputStream() {
        return this.decryptedContents;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        int read = this.virtualAvailable <= 0 ? -1 : this.decryptedContents.read();
        if (read != -1) {
            this.virtualAvailable--;
        } else {
            close();
            this.virtualAvailable = 0L;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read;
        abortIfNeeded();
        long j10 = this.virtualAvailable;
        if (j10 <= 0) {
            read = -1;
        } else {
            if (i11 > j10) {
                i11 = j10 < 2147483647L ? (int) j10 : Integer.MAX_VALUE;
            }
            read = this.decryptedContents.read(bArr, i10, i11);
        }
        if (read != -1) {
            this.virtualAvailable -= read;
        } else {
            close();
            this.virtualAvailable = 0L;
        }
        return read;
    }
}
